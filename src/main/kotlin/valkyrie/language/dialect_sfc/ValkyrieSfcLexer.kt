package valkyrie.psi.lexers

import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.xml.XmlTokenType

/**
 * Valkyrie Single File Component (.vkc) 词法分析器
 */
class ValkyrieSfcLexer : ValkyrieLexerBase(LexerFlavor.COMPONENT) {
    private companion object {
        private const val STATE_XML_TEXT = 1         // 默认状态：标签之间的内容
        private const val STATE_XML_TAG = 2          // 标签 <...> 内部
        private const val STATE_SCRIPT_VALKYRIE = 3  // <script> 标签内的 Valkyrie 代码
        private const val STATE_STYLE_CONTENT = 4    // <style> 标签内的内容

        val SPECIAL_TAGS = mapOf(
            "template" to ValkyrieTokenTypes.XML_TEMPLATE,
            "script" to ValkyrieTokenTypes.XML_SCRIPT,
            "style" to ValkyrieTokenTypes.XML_STYLE
        )
    }

    private var storedLexerState: Int = STATE_XML_TEXT
    private var attributeQuote: Char? = null
    private var currentForeignTag: String? = null

    private val sfcKeywords = super.keywords.toMutableMap().apply {
        put("properties", ValkyrieTokenTypes.SFC_PROPERTY)
        put("props", ValkyrieTokenTypes.SFC_PROPERTY)
        put("emits", ValkyrieTokenTypes.SFC_EMITS)
    }

    // [修复 1] 完全重写 start 方法以控制初始状态
    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentOffset = startOffset
        this.currentTokenType = null

        // 确保 SFC 文件总是从 XML 文本状态开始
        this.lexerState = STATE_XML_TEXT
        this.storedLexerState = STATE_XML_TEXT

        // 重置所有状态变量
        this.braceDepth = 0
        this.attributeQuote = null
        this.currentForeignTag = null

        advance()
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
            STATE_SCRIPT_VALKYRIE -> processScriptValkyrie()
            STATE_STYLE_CONTENT -> processStyleContent()
            STATE_LANGUAGE -> processEmbeddedValkyrie()
            else -> {
                lexerState = STATE_XML_TEXT
                processXmlText()
            }
        }
    }

    private fun processXmlText() {
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            // 在 XML 文本区域，注释被视为一个整体
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
            return
        }

        val ch = buffer[currentOffset]
        when (ch) {
            '<' -> {
                // 检查是否是结束标签
                if (peek(1) == '/') {
                    currentOffset += 2; currentTokenType = XmlTokenType.XML_END_TAG_START
                } else {
                    currentOffset++; currentTokenType = XmlTokenType.XML_START_TAG_START
                }
                lexerState = STATE_XML_TAG
            }
            '{' -> handleBraceStart(STATE_XML_TEXT)
            else -> readTextContent()
        }
    }

    private fun readTextContent() {
        val contentStart = currentOffset
        while (currentOffset < endOffset) {
            val c = buffer[currentOffset]
            // 查找下一个有意义的分隔符
            if (c == '<' || c == '{' || (c == '-' && peekAhead(3) == "-->")) break
            currentOffset++
        }

        if (currentOffset > contentStart) {
            currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
        } else {
            if (currentOffset >= endOffset) {
                currentTokenType = null
            } else {
                advance()
            }
        }
    }

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
                // [修复 3] 根据开标签名或之前的状态决定下一个状态
                lexerState = when (currentForeignTag) {
                    "script" -> STATE_SCRIPT_VALKYRIE
                    "style" -> STATE_STYLE_CONTENT
                    else -> storedLexerState // 返回到进入标签前的状态 (XML_TEXT 或 SCRIPT_VALKYRIE)
                }
                currentForeignTag = null
            }

            ch == '/' && peek() == '>' -> {
                currentOffset += 2; currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                // [修复 3] 通用化返回逻辑
                lexerState = storedLexerState
                currentForeignTag = null
            }

            ch == '=' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_EQ
            }

            ch == '"' || ch == '\'' -> startAttributeValue(ch)
            ch == '{' -> handleBraceStart(STATE_XML_TAG)
            else -> readXmlNameInTag()
        }
    }

    private fun readXmlNameInTag() {
        val nameStart = currentOffset
        while (currentOffset < endOffset) {
            // XML 标签和属性名可以包含 ':', '-', '.'
            val char = buffer[currentOffset]
            if (char.isLetterOrDigit() || char in "_-.:") {
                currentOffset++
            } else {
                break
            }
        }

        if (currentOffset > nameStart) {
            val name = buffer.subSequence(nameStart, currentOffset).toString()
            var isTagName = false
            var scanOffset = startOffset - 1
            while (scanOffset >= 0 && buffer[scanOffset].isWhitespace()) {
                scanOffset--
            }
            if (scanOffset >= 0 && (buffer[scanOffset] == '<' || (scanOffset >= 1 && buffer[scanOffset] == '/' && buffer[scanOffset - 1] == '<'))) {
                isTagName = true
            }

            if (isTagName) {
                val lowerName = name.lowercase()
                currentTokenType = SPECIAL_TAGS[lowerName] ?: XmlTokenType.XML_TAG_NAME
                if (buffer[scanOffset] == '<' && SPECIAL_TAGS.containsKey(lowerName)) {
                    currentForeignTag = lowerName
                }
            } else {
                currentTokenType = XmlTokenType.XML_NAME // 属性名
            }
        } else {
            currentOffset++; currentTokenType = BAD_CHARACTER
        }
    }

    /**
     * [修复 2] 增强 script 块的处理逻辑
     */
    private fun processScriptValkyrie() {
        // 优先检查特殊结构，然后再回退到 Valkyrie 语法
        val ch = buffer[currentOffset]
        when {
            // 1. 检查 script 结束标签
            ch == '<' && peek(1) == '/' && buffer.substring(currentOffset).lowercase().startsWith("</script") -> {
                lexerState = STATE_XML_TEXT
                advance() // 重新调度，让 XML 状态机处理 `</`
                return
            }
            // 2. 检查 XML 注释
            ch == '<' && peekAhead(4) == "<!--" -> {
                skipXmlComment()
                currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
                return
            }
            // 3. 检查内联 XML 标签
            ch == '<' && (peek(1)?.isLetter() == true || peek(1) == '/') -> {
                storedLexerState = STATE_SCRIPT_VALKYRIE // 记住我们要返回到 script
                lexerState = STATE_XML_TAG
                advance() // 重新调度，让 XML 标签状态机处理
                return
            }
            // 4. 如果都不是，则按 Valkyrie 语法处理
            else -> {
                super.processLanguage()
                if (currentTokenType == ValkyrieTokenTypes.SYMBOL_XID) {
                    val text = buffer.subSequence(tokenStart, tokenEnd).toString()
                    sfcKeywords[text]?.let { currentTokenType = it }
                }
            }
        }
    }

    private fun processStyleContent() {
        val endTag = "</style>"
        val contentStart = currentOffset
        val endPos = buffer.toString().indexOf(endTag, startIndex = currentOffset, ignoreCase = true)

        currentOffset = if (endPos != -1) endPos else endOffset

        if (currentOffset > contentStart) {
            currentTokenType = ValkyrieTokenTypes.STYLE_CONTENT
        } else {
            lexerState = STATE_XML_TEXT
            advance()
        }
    }

    private fun processEmbeddedValkyrie() {
        if (buffer[currentOffset] == '}' && braceDepth == 1) {
            handleBraceEnd()
        }
        else {
            super.processLanguage()
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
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = 0
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_R
        lexerState = storedLexerState
    }


    private fun processAttributeValue() {
        when (buffer[currentOffset]) {
            attributeQuote -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER
                attributeQuote = null
            }
            '{' -> handleBraceStart(STATE_XML_TAG)
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
                    // 确保即使值为空也能前进
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

    private fun skipXmlComment() {
        val endPos = buffer.indexOf("-->", currentOffset + 4)
        if (endPos != -1) {
            currentOffset = endPos + 3
        } else {
            currentOffset = endOffset
        }
    }
}