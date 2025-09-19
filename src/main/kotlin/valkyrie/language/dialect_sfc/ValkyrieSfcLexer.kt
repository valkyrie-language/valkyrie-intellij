package valkyrie.language.dialect_sfc

import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.lexers.LexerFlavor
import valkyrie.psi.lexers.ValkyrieLexerBase
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie Single File Component (.vkc) 词法分析器
 */
class ValkyrieSfcLexer : ValkyrieLexerBase(LexerFlavor.COMPONENT) {
    private companion object {
        private const val STATE_XML_TEXT = 1         // 默认状态：标签之间的内容
        private const val STATE_XML_TAG = 2          // 标签 <...> 内部
        private const val STATE_SCRIPT_VALKYRIE = 3  // 顶层 <script> 标签内的 Valkyrie 代码
        private const val STATE_STYLE_CONTENT = 4    // 顶层 <style> 标签内的内容
        private const val STATE_ATTR_QUOTED_VALUE = 5 // 在带引号的属性值内部
    }

    private var storedLexerState: Int = STATE_XML_TEXT
    private var attributeQuote: Char? = null
    private var currentForeignTag: String? = null

    // SFC script 块内特有的关键字
    private val sfcKeywords = super.keywords.toMutableMap().apply {
        put("properties", ValkyrieTokenTypes.SFC_PROPERTY)
        put("props", ValkyrieTokenTypes.SFC_PROPERTY)
        put("emits", ValkyrieTokenTypes.SFC_EMITS)
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentOffset = startOffset
        this.currentTokenType = null
        this.lexerState = STATE_XML_TEXT // SFC 文件总是从 XML 开始
        this.storedLexerState = STATE_XML_TEXT
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
            STATE_ATTR_QUOTED_VALUE -> processQuotedAttributeValue()
            else -> { // Fallback
                lexerState = STATE_XML_TEXT
                processXmlText()
            }
        }
    }

    private fun processXmlText() {
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
            return
        }

        when (buffer[currentOffset]) {
            '<' -> {
                if (peek(1) == '/') {
                    currentOffset += 2; currentTokenType = XmlTokenType.XML_END_TAG_START
                } else {
                    currentOffset++; currentTokenType = XmlTokenType.XML_START_TAG_START
                }
                lexerState = STATE_XML_TAG
            }

            '{' -> handleBraceStart(STATE_XML_TEXT)
            '&' -> readEntity()
            else -> readTextContent()
        }
    }

    private fun readTextContent() {
        val contentStart = currentOffset
        while (currentOffset < endOffset) {
            val c = buffer[currentOffset]
            // 文本在遇到 <, {, 或 & 时中断
            if (c == '<' || c == '{' || c == '&') break
            currentOffset++
        }

        if (currentOffset > contentStart) {
            currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
        } else {
            advance() // 如果没读到任何东西，就继续下一个 token
        }
    }

    private fun readEntity() {
        val entityStart = currentOffset
        if (buffer[currentOffset] == '&') {
            while (currentOffset < endOffset) {
                currentOffset++
                if (buffer[currentOffset - 1] == ';') {
                    break
                }
                // 如果不是合法的实体字符，就中断
                if (!buffer[currentOffset - 1].isLetterOrDigit() && buffer[currentOffset - 1] != '#' && buffer[currentOffset - 1] != '&') {
                    break
                }
            }
        }

        if (currentOffset > entityStart) {
            currentTokenType = if (buffer[currentOffset - 1] == ';') XmlTokenType.XML_CHAR_ENTITY_REF else XmlTokenType.XML_DATA_CHARACTERS
        } else {
            advance()
        }
    }


    private fun processXmlTag() {
        when (val ch = buffer[currentOffset]) {
            in " \t\n\r" -> readWhitespace()
            '>' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_TAG_END
                lexerState = when (currentForeignTag) {
                    "script" -> STATE_SCRIPT_VALKYRIE
                    "style" -> STATE_STYLE_CONTENT
                    else -> STATE_XML_TEXT // 标签结束后总是回到文本状态
                }
                currentForeignTag = null // 清除顶层标签状态
            }

            '/' -> {
                if (peek() == '>') {
                    currentOffset += 2; currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                    lexerState = STATE_XML_TEXT // 自闭合标签后回到文本状态
                    currentForeignTag = null
                } else {
                    currentOffset++; currentTokenType = BAD_CHARACTER
                }
            }

            '=' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_EQ
            }

            '\'', '"' -> {
                attributeQuote = ch
                currentOffset++
                currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER
                lexerState = STATE_ATTR_QUOTED_VALUE
            }

            '{' -> handleBraceStart(STATE_XML_TAG) // for attr={...}
            else -> {
                // 可能是标签名、属性名或无引号的属性值
                val prevToken = tokenType // Psuedo previous token logic
                if (isAfter(XmlTokenType.XML_EQ)) { // 简化的前置 token 判断
                    readUnquotedAttributeValue()
                } else {
                    readXmlNameInTag()
                }
            }
        }
    }

    private fun readUnquotedAttributeValue() {
        val valueStart = currentOffset
        while (currentOffset < endOffset) {
            val c = buffer[currentOffset]
            if (c.isWhitespace() || c == '>' || (c == '/' && peek() == '>')) {
                break
            }
            currentOffset++
        }
        if (currentOffset > valueStart) {
            currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN
        } else {
            advance()
        }
    }

    private fun processQuotedAttributeValue() {
        if (currentOffset >= endOffset) {
            currentTokenType = null; return
        }
        when (buffer[currentOffset]) {
            attributeQuote -> {
                currentOffset++
                currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER
                attributeQuote = null
                lexerState = STATE_XML_TAG
            }

            '{' -> handleBraceStart(STATE_ATTR_QUOTED_VALUE)
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

    private fun readXmlNameInTag() {
        val nameStart = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset].let { it.isLetterOrDigit() || it in "_-.:" }) {
            currentOffset++
        }

        if (currentOffset > nameStart) {
            val name = buffer.subSequence(nameStart, currentOffset).toString()
            // 判断是否是标签名
            var scanOffset = startOffset - 1
            while (scanOffset >= 0 && buffer[scanOffset].isWhitespace()) {
                scanOffset--
            }
            if (scanOffset >= 0 && (buffer[scanOffset] == '<' || (scanOffset >= 1 && buffer[scanOffset] == '/' && buffer[scanOffset - 1] == '<'))) {
                val lowerName = name.lowercase()
                currentTokenType = when (lowerName) {
                    "template" -> ValkyrieTokenTypes.XML_TEMPLATE
                    "script" -> ValkyrieTokenTypes.XML_SCRIPT
                    "style" -> ValkyrieTokenTypes.XML_STYLE
                    else -> XmlTokenType.XML_TAG_NAME
                }
                // 只有在开始标签时才记录 foreign tag
                if (buffer[scanOffset] == '<' && (lowerName == "script" || lowerName == "style")) {
                    currentForeignTag = lowerName
                }
            } else {
                currentTokenType = XmlTokenType.XML_NAME // 属性名
            }
        } else {
            currentOffset++; currentTokenType = BAD_CHARACTER
        }
    }

    private fun processScriptValkyrie() {
        if (buffer.substring(currentOffset).lowercase().startsWith("</script")) {
            lexerState = STATE_XML_TEXT
            advance()
            return
        }
        super.processLanguage()
        if (currentTokenType == ValkyrieTokenTypes.SYMBOL_XID) {
            val text = buffer.subSequence(tokenStart, tokenEnd).toString()
            sfcKeywords[text]?.let { currentTokenType = it }
        }
    }

    private fun processStyleContent() {
        val endTag = "</style>"
        val contentStart = currentOffset
        val endPos = buffer.indexOf(endTag, currentOffset, ignoreCase = true)
        currentOffset = if (endPos != -1) endPos else endOffset
        if (currentOffset > contentStart) {
            currentTokenType = ValkyrieTokenTypes.STYLE_CONTENT
        } else {
            lexerState = STATE_XML_TEXT
            advance()
        }
    }

    private fun handleBraceStart(returnState: Int) {
        storedLexerState = returnState
        currentOffset++
        braceDepth = 1
        currentTokenType = ValkyrieTokenTypes.BRACE_L
        lexerState = STATE_LANGUAGE
    }

    private fun processEmbeddedValkyrie() {
        if (buffer[currentOffset] == '}' && braceDepth == 1) {
            currentOffset++
            braceDepth = 0
            currentTokenType = ValkyrieTokenTypes.BRACE_R
            lexerState = storedLexerState
        } else {
            super.processLanguage()
            when (currentTokenType) {
                ValkyrieTokenTypes.BRACE_L -> braceDepth++
                ValkyrieTokenTypes.BRACE_R -> braceDepth--
                else -> {}
            }
        }
    }

    private fun skipXmlComment() {
        val endPos = buffer.indexOf("-->", currentOffset + 4)
        currentOffset = if (endPos != -1) endPos + 3 else endOffset
    }

    // 伪实现，实际 Lexer 中很难精确知道前一个有意义的 token
    private fun isAfter(token: IElementType): Boolean {
        var offset = startOffset - 1
        while (offset >= 0 && buffer[offset].isWhitespace()) {
            offset--
        }
        return offset >= 0 && buffer[offset] == '='
    }
}