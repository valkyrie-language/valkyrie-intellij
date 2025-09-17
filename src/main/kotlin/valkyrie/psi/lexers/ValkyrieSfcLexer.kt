package valkyrie.psi.lexers

import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType

/**
 * Valkyrie Single File Component (.vkc) 词法分析器
 *
 * 经过重构，以简化状态管理并生成更精确的 Token 流，借鉴了标准 HTML/XML 词法分析器的设计。
 *
 * 核心设计变更：
 * 1.  **移除了复杂的标签匹配堆栈**：Lexer 不再尝试匹配开闭标签。它只识别标签的各个部分。
 * 2.  **简化状态**：引入一个简单的 `currentForeignTag` 变量来管理 <script> 和 <style> 块，而不是依赖堆栈。
 * 3.  **更细粒度的 Token**：使用类似 XmlTokenType 的 Token（如 START_TAG_START, TAG_END），为 Parser 提供更清晰的结构。
 * 4.  **明确的职责分离**：Lexer 负责识别 Token，Parser 负责构建语法树和报告结构错误（如标签未闭合）。
 */
class ValkyrieSfcLexer : ValkyrieLexerBase(LexerFlavor.COMPONENT) {
    private companion object {
        // STATE_LANGUAGE (0) 继承自基类, 用于 { ... }
        private const val STATE_XML_TEXT = 1         // 默认状态：标签之间的内容
        private const val STATE_XML_TAG = 2          // 标签 <...> 内部
        private const val STATE_SCRIPT_CONTENT = 3   // <script> 标签内的内容
        private const val STATE_STYLE_CONTENT = 4    // <style> 标签内的内容

        // 特殊的顶层标签，它们的内容需要被特殊处理
        val SPECIAL_TAGS = mapOf(
            "template" to ValkyrieTokenTypes.XML_TEMPLATE,
            "script" to ValkyrieTokenTypes.XML_SCRIPT,
            "style" to ValkyrieTokenTypes.XML_STYLE
        )
    }

    // 用于在 { ... } 块之间保存和恢复状态
    private var storedLexerState: Int = STATE_XML_TEXT
    // 跟踪当前是否在属性值的引号内
    private var attributeQuote: Char? = null
    // 跟踪当前正在处理的特殊标签（"script" 或 "style"），用于状态转换
    private var currentForeignTag: String? = null

    // 为 SFC 的 <script> 块添加额外的关键字
    override val keywords = super.keywords.toMutableMap().apply {
        put("props", ValkyrieTokenTypes.SFC_PROPS)
        put("emits", ValkyrieTokenTypes.SFC_EMITS)
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)
        // SFC 文件总是从 XML 文本状态开始
        lexerState = STATE_XML_TEXT
        storedLexerState = STATE_XML_TEXT
        attributeQuote = null
        currentForeignTag = null
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_XML_TEXT -> processXmlText()
            STATE_XML_TAG -> processXmlTag()
            STATE_SCRIPT_CONTENT -> processForeignContent("script", ValkyrieTokenTypes.SCRIPT_CONTENT, STATE_XML_TEXT)
            STATE_STYLE_CONTENT -> processForeignContent("style", ValkyrieTokenTypes.STYLE_CONTENT, STATE_XML_TEXT)
            STATE_LANGUAGE -> processEmbeddedValkyrie()
            else -> { // 安全回退
                lexerState = STATE_XML_TEXT
                processXmlText()
            }
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。这是文件的默认状态。
     */
    private fun processXmlText() {
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            return
        }

        val ch = buffer[currentOffset]
        when {
            ch == '<' -> {
                when (peek()) {
                    '/' -> { // 结束标签
                        currentOffset += 2; currentTokenType = XmlTokenType.XML_END_TAG_START
                    }
                    '!', '?' -> { // 注释或其他指令
                        if (peekAhead(3) == "!--") {
                            skipXmlComment()
                            return
                        }
                        // 其他如 <!DOCTYPE> 等可以作为普通标签处理
                        currentOffset++; currentTokenType = XmlTokenType.XML_START_TAG_START
                    }
                    else -> { // 开始标签
                        currentOffset++; currentTokenType = XmlTokenType.XML_START_TAG_START
                    }
                }
                lexerState = STATE_XML_TAG
            }
            ch == '{' -> handleBraceStart(STATE_XML_TEXT)
            else -> readTextContent()
        }
    }

    /**
     * 读取纯文本内容，直到遇到下一个标签或嵌入块的开始
     */
    private fun readTextContent() {
        val contentStart = currentOffset
        while (currentOffset < endOffset) {
            val c = buffer[currentOffset]
            // 查找下一个有意义的分隔符
            if (c == '<' || c == '{') break
            currentOffset++
        }

        currentTokenType = if (currentOffset > contentStart) {
            XmlTokenType.XML_DATA_CHARACTERS
        } else {
            // 如果没有内容可读，意味着我们正处于文件末尾或下一个 Token 的开头。
            // 再次调用 advance() 来处理下一个 Token。
            advance()
            return
        }
    }

    /**
     * 状态 2: 处理 XML 标签内部 (<...>)。
     */
    private fun processXmlTag() {
        if (attributeQuote != null) {
            processAttributeValue()
            return
        }

        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace()
            ch == '>' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_TAG_END
                // 根据刚刚解析的标签名决定下一个状态
                lexerState = when (currentForeignTag) {
                    "script" -> STATE_SCRIPT_CONTENT
                    "style" -> STATE_STYLE_CONTENT
                    else -> STATE_XML_TEXT
                }
                currentForeignTag = null // 清除标记，因为它只对开标签的 `>` 有效
            }
            ch == '/' && peek() == '>' -> {
                currentOffset += 2; currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                lexerState = STATE_XML_TEXT
                currentForeignTag = null
            }
            ch == '=' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_EQ
            }
            ch == '"' || ch == '\'' -> startAttributeValue(ch)
            ch == '{' -> handleBraceStart(STATE_XML_TAG) // 支持 <div class={my_class}>
            // 标签名或属性名
            ch.isLetter() || ch == '_' || ch == ':' -> readXmlNameInTag()
            else -> {
                currentOffset++; currentTokenType = BAD_CHARACTER
            }
        }
    }

    /**
     * 读取标签名或属性名
     */
    private fun readXmlNameInTag() {
        val nameStart = currentOffset
        // XML 属性和标签名可以包含更多字符
        while (currentOffset < endOffset) {
            when (buffer[currentOffset]) {
                in 'a'..'z', in 'A'..'Z', in '0'..'9', '_', '-', '.' -> currentOffset++
                // 支持命名空间
                ':' -> if (peek()?.isLetterOrDigit() == true) currentOffset++ else break
                else -> break
            }
        }

        if (currentOffset > nameStart) {
            val name = buffer.subSequence(nameStart, currentOffset).toString()
            val lastToken = getTokenType()

            // 判断是标签名还是属性名
            if (lastToken == XmlTokenType.XML_START_TAG_START || lastToken == XmlTokenType.XML_END_TAG_START) {
                val lowerName = name.lowercase()
                currentTokenType = SPECIAL_TAGS[lowerName] ?: XmlTokenType.XML_TAG_NAME

                // 如果是特殊的开标签，记录下来
                if (lastToken == XmlTokenType.XML_START_TAG_START && SPECIAL_TAGS.containsKey(lowerName)) {
                    currentForeignTag = lowerName
                }
            } else {
                currentTokenType = XmlTokenType.XML_NAME
            }
        } else {
            currentOffset++; currentTokenType = BAD_CHARACTER
        }
    }

    /**
     * 处理属性值
     */
    private fun processAttributeValue() {
        val ch = buffer[currentOffset]
        when {
            ch == attributeQuote -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER
                attributeQuote = null
            }
            ch == '{' -> handleBraceStart(STATE_XML_TAG)
            else -> {
                val valueStart = currentOffset
                while (currentOffset < endOffset) {
                    val c = buffer[currentOffset]
                    if (c == attributeQuote || c == '{') break
                    currentOffset++
                }
                if (currentOffset > valueStart) {
                    currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN
                } else {
                    // 空属性值，必须消费掉结束引号
                    advance()
                }
            }
        }
    }

    private fun startAttributeValue(delimiter: Char) {
        attributeQuote = delimiter
        currentOffset++
        currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER
    }

    /**
     * 状态 3 & 4: 处理 <script> 或 <style> 的内容
     * 使用高效的 indexOf 查找结束标签
     */
    private fun processForeignContent(tagName: String, tokenType: IElementType, nextState: Int) {
        val endTag = "</$tagName"
        val contentStart = currentOffset

        // 忽略大小写查找结束标签
        val endPos = buffer.toString().indexOf(endTag, startIndex = currentOffset, ignoreCase = true)

        currentOffset = if (endPos != -1) endPos else endOffset

        if (currentOffset > contentStart) {
            currentTokenType = tokenType
        } else {
            // 如果没有内容（例如 <script></script>），直接切换到 XML 文本状态去处理 `</script>`
            lexerState = nextState
            advance()
        }
    }

    /**
     * 处理嵌入的 Valkyrie 代码块 { ... }
     */
    private fun processEmbeddedValkyrie() {
        // 遇到 '}' 并且嵌套深度为 1，则准备退出 Valkyrie 模式
        if (buffer[currentOffset] == '}' && braceDepth == 1) {
            handleBraceEnd()
        } else {
            // 使用基类的 Valkyrie 解析逻辑
            super.processLanguage()
            // 在Valkyrie代码中也可能出现嵌套的大括号
            when (currentTokenType) {
                ValkyrieTokenTypes.BRACE_L -> braceDepth++
                ValkyrieTokenTypes.BRACE_R -> braceDepth--
                else -> {}
            }
        }
    }

    private fun handleBraceStart(returnState: Int) {
        storedLexerState = returnState
        currentOffset++
        braceDepth = 1
        currentTokenType = ValkyrieTokenTypes.BRACE_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = 0
        currentTokenType = ValkyrieTokenTypes.BRACE_R
        // 恢复到进入 { 之前的状态
        lexerState = storedLexerState
    }

    private fun skipXmlComment() {
        val endPos = buffer.indexOf("-->", currentOffset + 4)
        if (endPos != -1) {
            currentOffset = endPos + 3
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
        } else {
            // 未闭合的注释
            currentOffset = endOffset
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
        }
    }
}