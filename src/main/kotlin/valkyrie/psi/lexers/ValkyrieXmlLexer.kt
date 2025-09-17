package valkyrie.psi.lexers

import com.intellij.psi.xml.XmlTokenType

/**
 * XML Valkyrie 词法分析器
 *
 * 用于解析声明式 UI 文件 (.vkx)。采用一个清晰的三状态机模型：
 * 1. STATE_LANGUAGE: 解析顶层 Valkyrie 代码或嵌入在 {} 中的代码。这是初始状态。
 * 2. STATE_XML_TEXT:  解析 XML 标签之间的内容，如 >...<。
 * 3. STATE_XML_TAG:   解析 XML 标签内部的元素，如 <div class="foo">。
 */
class ValkyrieXmlLexer : ValkyrieLexerBase(LexerFlavor.XML) {

    private companion object {
        // STATE_LANGUAGE (0) 继承自基类，是我们的初始和顶层状态
        private const val STATE_XML_TEXT = 1 // 标签之间的内容
        private const val STATE_XML_TAG = 2  // 标签 <...> 内部
    }

    private var tagDepth: Int = 0

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processValkyrieOrTopLevel()
            STATE_XML_TAG -> processXmlTag()
            STATE_XML_TEXT -> processXmlText()
            else -> {
                // 安全回退
                lexerState = STATE_LANGUAGE
                processValkyrieOrTopLevel()
            }
        }
    }

    /**
     * 状态 0: 处理顶层 Valkyrie 代码、嵌入的 Valkyrie 表达式，并检测 XML 块的开始。
     */
    private fun processValkyrieOrTopLevel() {
        // 在嵌入代码中，如果大括号平衡了，就返回到 XML 文本模式
        if (braceDepth > 0 && peek(0) == '}') {
            handleBraceEnd()
            return
        }

        when (val ch = buffer[currentOffset]) {
            // Context-sensitive check for '<' ---
            '<' -> {
                if (isStartOfTag()) {
                    handleXmlTagStart()
                } else {
                    // It's a comparison operator, delegate to base class
                    super.readOperatorOrPunctuation(ch)
                }
            }
            // '{' in top-level or nested code is handled by the base class
            else -> {
                super.processLanguage()
            }
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。
     */
    private fun processXmlText() {
        when (val ch = buffer[currentOffset]) {
            '<' -> handleXmlTagStart() // `isStartOfTag` check is inside `handleXmlTagStart`
            '{' -> handleBraceStart()
            // Handle Valkyrie-style comments within XML text ---
            '#' -> {
                skipLineComment()
                currentTokenType = ValkyrieTokenTypes.COMMENT_LINE
            }

            else -> {
                // 读取直到下一个 '<', '{', 或 '#'
                val contentStart = currentOffset
                while (currentOffset < endOffset && buffer[currentOffset].let { it != '<' && it != '{' && it != '#' }) {
                    currentOffset++
                }

                if (currentOffset > contentStart) {
                    currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
                } else if (currentTokenType == null) {
                    // 如果没有内容（例如，文件以 '<div>#' 开头），
                    // 我们需要确保 advance() 继续进行，而不是卡住。
                    // 再次调用 advance() 将会命中上面 '#' 的 case。
                    advance()
                }
            }
        }
    }

    /**
     * 状态 2: 处理 XML 标签内部 (<...>)。
     */
    private fun processXmlTag() {
        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> {
                readWhitespace(); currentTokenType = XmlTokenType.XML_WHITE_SPACE
            }

            ch.isLetter() || ch == '_' || ch == ':' -> readXmlTagNameOrAttrName()
            ch == '=' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_EQ
            }

            ch == '"' || ch == '\'' -> readAttributeValue()
            ch == '>' -> {
                currentOffset++
                currentTokenType = XmlTokenType.XML_TAG_END
                // 如果标签是非自闭合的，进入文本模式
                lexerState = STATE_XML_TEXT
            }

            ch == '/' && peek(0) == '>' -> {
                currentOffset += 2
                currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                tagDepth = (tagDepth - 1).coerceAtLeast(0)
                // 自闭合标签结束后，根据标签深度决定返回顶层还是文本模式
                lexerState = if (tagDepth == 0) STATE_LANGUAGE else STATE_XML_TEXT
            }
            // 支持在标签内部的嵌入代码，例如 `<div class={my_class}>`
            ch == '{' -> handleBraceStart()
            ch == '}' -> handleBraceEnd()
            else -> {
                // 处理标签内的其他 Valkyrie 标点符号
                super.readOperatorOrPunctuation(ch)
            }
        }
    }

    /**
     * 检查当前位置是否是 XML 标签的开始。
     * - `<tag`
     * - `</tag`
     * - `<!--`
     * @return true 如果是标签的开始，否则 false。
     */
    private fun isStartOfTag(): Boolean {
        val next = peek(0) ?: return false
        if (next.isLetter() || next == '_') {
            return true // <tag
        }
        if (next == '/') {
            val afterSlash = peek(1)
            return afterSlash != null && (afterSlash.isLetter() || afterSlash == '_') // </tag
        }
        if (next == '!') {
            return peek(1) == '-' && peek(2) == '-' // <!--
        }
        return false
    }

    private fun handleXmlTagStart() {
        // 检查 XML 注释
        if (peek(0) == '!' && peek(1) == '-' && peek(2) == '-') {
            skipXmlComment()
            return
        }

        if (peek(0) == '/') { // 结束标签: </
            currentOffset += 2
            currentTokenType = XmlTokenType.XML_END_TAG_START
            // 结束标签不应该减少深度，直到 '>' 或 '/>' 被解析
            lexerState = STATE_XML_TAG // 切换到标签模式以解析标签名
        } else { // 开始标签: <
            currentOffset++
            currentTokenType = XmlTokenType.XML_START_TAG_START
            tagDepth++
            lexerState = STATE_XML_TAG // 切换到标签模式以解析标签名
        }
    }

    override fun readOperatorOrPunctuation(ch: Char) {
        if (ch == '}' && lexerState == STATE_XML_TAG && braceDepth > 0) {
            handleBraceEnd()
        } else {
            super.readOperatorOrPunctuation(ch)
        }
    }

    private fun handleBraceStart() {
        currentOffset++
        braceDepth++
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_L
        lexerState = STATE_LANGUAGE // 进入嵌入式 Valkyrie 代码解析
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_R
        // 嵌入代码结束，返回到之前的 XML 模式
        if (braceDepth == 0) {
            // 如果我们是从标签内部进入的 (如 on:click={...})，应该返回 STATE_XML_TAG
            // TDOD: 使用一个状态栈。
            lexerState = if (tagDepth > 0) STATE_XML_TEXT else STATE_LANGUAGE
        }
    }

    private fun readXmlTagNameOrAttrName() {
        val nameStart = currentOffset
        // XML 名称可以包含字母、数字、下划线、连字符、冒号
        while (currentOffset < endOffset && buffer[currentOffset].let { it.isLetterOrDigit() || it == '_' || it == '-' || it == ':' }) {
            currentOffset++
        }
        // TODO: 根据上下文决定这是 XML_TAG_NAME 还是 XML_ATTRIBUTE_NAME
        currentTokenType = XmlTokenType.XML_NAME
    }

    private fun readAttributeValue() {
        val quote = buffer[currentOffset]
        currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER
        currentOffset++ // consume opening quote

        // 我们将属性值简化为单个 token，但一个完整的实现会在这里处理嵌入的 {}
        val valueStart = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != quote) {
            currentOffset++
        }
        // 这里可以进一步细分为 XML_ATTRIBUTE_VALUE_TOKEN
        // 为简单起见，我们跳过这步，直接找结束符

        if (currentOffset < endOffset && buffer[currentOffset] == quote) {
            // 在这里什么都不做，让下一个 advance() 来处理结束符
        }
    }

    // Refined XML comment handling ---
    private fun skipXmlComment() {
        val commentStart = currentOffset
        // 寻找 "-->"
        while (currentOffset + 2 < endOffset) {
            if (buffer[currentOffset] == '-' && buffer[currentOffset + 1] == '-' && buffer[currentOffset + 2] == '>') {
                currentOffset += 3 // Consume "-->"
                break
            }
            currentOffset++
        }
        // 如果没有找到结束符，则将整个剩余部分作为注释
        currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
    }
}