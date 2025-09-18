package valkyrie.language.dialect_xml

import com.intellij.psi.TokenType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.lexers.LexerFlavor
import valkyrie.psi.lexers.ValkyrieLexerBase
import valkyrie.psi.lexers.ValkyrieTokenTypes

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

    // 用于在 { ... } 嵌入块中保存和恢复状态
    private var storedLexerState: Int = STATE_LANGUAGE

    private var isExpectingTagName = false
    private var attributeQuote: Char? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)
        // 每次 start 都必须重置所有 XML 特定状态
        tagDepth = 0
        storedLexerState = STATE_LANGUAGE
        lexerState = STATE_LANGUAGE // 总是从顶层语言状态开始
        isExpectingTagName = false
        attributeQuote = null
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        // 优先处理属性值状态
        if (lexerState == STATE_XML_TAG && attributeQuote != null) {
            processAttributeValue()
            return
        }

        when (lexerState) {
            STATE_LANGUAGE -> processValkyrieOrTopLevel()
            STATE_XML_TAG -> processXmlTag()
            STATE_XML_TEXT -> processXmlText()
            else -> {
                lexerState = STATE_LANGUAGE
                processValkyrieOrTopLevel()
            }
        }
    }

    /**
     * 状态 0: 处理顶层 Valkyrie 代码、嵌入的 Valkyrie 表达式，并检测 XML 块的开始。
     */
    private fun processValkyrieOrTopLevel() {
        if (braceDepth > 0 && buffer[currentOffset] == '}') {
            handleBraceEnd()
            return
        }

        val ch = buffer[currentOffset]
        // 只有当不在嵌入代码块中时，才将 '<' 视为潜在的 XML 标签起始
        if (ch == '<' && braceDepth == 0 && isStartOfTag()) {
            handleXmlTagStart()
        }
        // 否则，它只是一个比较运算符或泛型，由基类处理
        else {
            super.processLanguage()
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。
     */
    private fun processXmlText() {
        // 检查 XML 注释的开始
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            return
        }

        when (buffer[currentOffset]) {
            '<' -> handleXmlTagStart()
            '{' -> handleBraceStart()
            else -> {
                val contentStart = currentOffset
                // 读取直到下一个特殊字符
                while (currentOffset < endOffset) {
                    if (buffer[currentOffset] == '<' || buffer[currentOffset] == '{' || peekAhead(4) == "<!--") {
                        break
                    }
                    currentOffset++
                }

                if (currentOffset > contentStart) {
                    currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
                } else {
                    // 如果没有内容（例如 <div></div>），我们不能卡住，需要继续前进。
                    advance()
                }
            }
        }
    }

    /**
     * 状态 2: 处理 XML 标签内部 (<...>)。
     */
    private fun processXmlTag() {
        if (braceDepth > 0 && buffer[currentOffset] == '}') {
            handleBraceEnd()
            return
        }

        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> {
                readWhitespace(); currentTokenType = XmlTokenType.XML_WHITE_SPACE
            }
            // 使用 isExpectingTagName 状态来决定 token 类型
            ch.isLetter() || ch == '_' || ch == ':' -> readXmlIdentifier()
            ch == '=' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_EQ
            }
            // 启动属性值解析状态
            ch == '"' || ch == '\'' -> {
                attributeQuote = ch
                currentOffset++
                currentTokenType = ValkyrieTokenTypes.XML_SLOT_L
            }

            ch == '>' -> {
                currentOffset++
                currentTokenType = XmlTokenType.XML_TAG_END
                lexerState = if (tagDepth == 0) STATE_LANGUAGE else STATE_XML_TEXT
                isExpectingTagName = false // 重置状态
            }

            ch == '/' && peek() == '>' -> {
                currentOffset += 2
                currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                tagDepth = (tagDepth - 1).coerceAtLeast(0)
                lexerState = if (tagDepth == 0) STATE_LANGUAGE else STATE_XML_TEXT
                isExpectingTagName = false // 重置状态
            }

            ch == '{' -> handleBraceStart()
            else -> {
                currentOffset++
                currentTokenType = TokenType.BAD_CHARACTER
            }
        }
    }

    /**
     * 处理属性字符串内部的内容
     */
    private fun processAttributeValue() {
        val ch = buffer[currentOffset]

        // 检查是否是结束引号
        if (ch == attributeQuote) {
            currentOffset++
            currentTokenType = ValkyrieTokenTypes.XML_SLOT_R
            attributeQuote = null // 退出属性值模式
            return
        }

        // 检查是否是嵌入表达式
        if (ch == '{') {
            handleBraceStart() // 这将切换到 STATE_LANGUAGE
            return
        }

        // 读取文本内容直到下一个特殊字符
        val valueStart = currentOffset
        while (currentOffset < endOffset) {
            val c = buffer[currentOffset]
            if (c == attributeQuote || c == '{') {
                break
            }
            currentOffset++
        }

        if (currentOffset > valueStart) {
            currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN
        } else {
            // 避免无限循环：如果没有任何内容但又不是结束，则标记为坏字符并前进
            currentOffset++
            currentTokenType = TokenType.BAD_CHARACTER
        }
    }

    private fun isStartOfTag(): Boolean {
        val next = peek() ?: return false
        if (next.isLetter() || next == '_') return true
        if (next == '/') {
            val afterSlash = peek(2)
            return afterSlash != null && (afterSlash.isLetter() || afterSlash == '_')
        }
        return next == '!' && peek(2) == '-' && peek(3) == '-'
    }

    private fun handleXmlTagStart() {
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            return
        }
        // 置特殊状态：下一个标识符将是标签名
        isExpectingTagName = true
        if (peek() == '/') {
            currentOffset += 2
            currentTokenType = XmlTokenType.XML_END_TAG_START
            tagDepth = (tagDepth - 1).coerceAtLeast(0)
        } else {
            currentOffset++
            currentTokenType = XmlTokenType.XML_START_TAG_START
            tagDepth++
        }
        lexerState = STATE_XML_TAG
    }

    private fun handleBraceStart() {
        storedLexerState = lexerState
        currentOffset++
        braceDepth++
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_R

        if (braceDepth == 0) {
            lexerState = storedLexerState
        }
    }

    private fun readXmlIdentifier() {
        val idStart = currentOffset
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            // XML 名称可以包含 - 和 :
            if (ch.isLetterOrDigit() || ch in "_-:") {
                currentOffset++
            } else {
                break
            }
        }

        if (currentOffset > idStart) {
            if (isExpectingTagName) {
                currentTokenType = XmlTokenType.XML_TAG_NAME
                isExpectingTagName = false // 消费后立即重置
            } else {
                currentTokenType = XmlTokenType.XML_NAME // 用于属性名
            }
        } else {
            currentOffset++
            currentTokenType = TokenType.BAD_CHARACTER
        }
    }

    private fun skipXmlComment() {
        val commentStart = startOffset
        // 寻找 "-->"
        val endPos = buffer.indexOf("-->", currentOffset + 4)

        // 若有未闭合的注释，将剩余部分全部消费
        currentOffset = if (endPos != -1) endPos + 3 else endOffset

        // 为整个注释块 `<!-- ... -->` 生成一个 token
        startOffset = commentStart
        currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
    }
}