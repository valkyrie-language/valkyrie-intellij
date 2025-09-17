package valkyrie.psi.lexers

import com.intellij.psi.xml.XmlTokenType

/**
 * XML Valkyrie 词法分析器
 *
 * 用于解析声明式 UI 文件 (.vkx)。采用一个清晰的三状态机模型：
 * 1. STATE_LANGUAGE: 解析顶层 Valkyrie 代码或嵌入在 {} 中的代码。这是初始状态。
 * 2. STATE_XML_TAG:   解析 XML 标签内部的元素，如 <div class="foo">。
 * 3. STATE_XML_TEXT:  解析 XML 标签之间的内容，如 >...<。
 *
 * 示例：
 * ```
 * <div class="container">
 *   <h1>{ title }</h1>
 *   <p>Welcome, { user.name }!</p>
 *   <button on:click={ handleClick }>
 *     Click me
 *   </button>
 * </div>
 * ```
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
            else -> lexerState = STATE_LANGUAGE // 安全回退
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
            '<' -> handleXmlTagStart()
            '{' -> { // 通常在嵌入代码中遇到嵌套大括号
                if (braceDepth > 0) {
                    super.readOperatorOrPunctuation(ch)
                } else {
                    // 顶层代码中的 '{' 是普通代码块
                    super.processLanguage()
                }
            }

            else -> {
                // 对于所有其他字符 (如 'n' in namespace)，委托给基类处理
                super.processLanguage()
            }
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。
     */
    private fun processXmlText() {
        when (val ch = buffer[currentOffset]) {
            '<' -> handleXmlTagStart()
            '{' -> handleBraceStart()
            else -> {
                // 读取直到下一个 '<' 或 '{'
                val contentStart = currentOffset
                while (currentOffset < endOffset && buffer[currentOffset] != '<' && buffer[currentOffset] != '{') {
                    currentOffset++
                }
                if (currentOffset > contentStart) {
                    currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
                } else {
                    // 如果没有内容，则让 advance 循环继续，而不是返回 null token
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
            ch.isWhitespace() -> readWhitespace()
            ch.isLetter() || ch == '_' -> readXmlTagNameOrAttrName()
            ch == '=' -> {
                currentOffset++; currentTokenType = XmlTokenType.XML_EQ
            }

            ch == '"' || ch == '\'' -> readAttributeValue()
            ch == '>' -> {
                currentOffset++
                currentTokenType = XmlTokenType.XML_TAG_END
                // 如果标签是非自闭合的，并且内部还有内容，则进入文本模式
                lexerState = STATE_XML_TEXT
            }

            ch == '/' && peek(0) == '>' -> {
                currentOffset += 2
                currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                tagDepth = (tagDepth - 1).coerceAtLeast(0)
                // 自闭合标签结束后，根据标签深度决定返回顶层还是文本模式
                lexerState = if (tagDepth == 0) STATE_LANGUAGE else STATE_XML_TEXT
            }

            else -> {
                // 处理标签内的其他 Valkyrie 标点符号（例如，在属性中）
                // 这是一个高级用例，暂时简化处理
                currentOffset++
                currentTokenType = com.intellij.psi.TokenType.BAD_CHARACTER
            }
        }
    }

    private fun handleXmlTagStart() {
        if (peekAhead(3) == "!--") {
            skipXmlComment()
            return
        }

        if (peek(0) == '/') { // 结束标签: </
            currentOffset += 2
            currentTokenType = XmlTokenType.XML_END_TAG_START
            tagDepth = (tagDepth - 1).coerceAtLeast(0)
            lexerState = STATE_XML_TAG // 切换到标签模式以解析标签名
        } else { // 开始标签: <
            currentOffset++
            currentTokenType = XmlTokenType.XML_START_TAG_START
            tagDepth++
            lexerState = STATE_XML_TAG // 切换到标签模式以解析标签名
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
        // 嵌入代码结束，返回到 XML 文本模式
        if (braceDepth == 0) {
            lexerState = STATE_XML_TEXT
        }
    }

    private fun readXmlTagNameOrAttrName() {
        val nameStart = currentOffset
        // XML 名称可以包含字母、数字、下划线、连字符
        while (currentOffset < endOffset && buffer[currentOffset].let { it.isLetterOrDigit() || it == '_' || it == '-' }) {
            currentOffset++
        }
        // 解析器将根据上下文决定这是 XML_TAG_NAME 还是 XML_ATTRIBUTE_NAME
        // 为了简化词法分析器，我们统一使用一个 token
        currentTokenType = XmlTokenType.XML_NAME
    }

    private fun readAttributeValue() {
        val quote = buffer[currentOffset]
        currentOffset++ // consume opening quote
        // 为了支持嵌入表达式，如 class="prefix-{someVar}-suffix"
        // 我们需要将属性值分解为多个 token。
        // 为简化，这里暂时只处理简单字符串值。
        val valueStart = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != quote) {
            currentOffset++
        }
        if (currentOffset > valueStart) {
            currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN
        }

        if (currentOffset < endOffset && buffer[currentOffset] == quote) {
            currentOffset++ // consume closing quote
        }
    }

    private fun skipXmlComment() {
        currentOffset += 4 // "<!--"
        val commentStart = currentOffset
        var endFound = false
        while (currentOffset + 2 < endOffset) {
            if (buffer[currentOffset] == '-' && buffer[currentOffset + 1] == '-' && buffer[currentOffset + 2] == '>') {
                endFound = true
                break
            }
            currentOffset++
        }

        val commentText = buffer.subSequence(commentStart, currentOffset).toString()
        // 为了与 IntelliJ 的 XML 解析器兼容，通常会将注释分解为多个部分
        // 这里为了简单起见，我们将其视为一个大的注释块
        currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS

        if (endFound) {
            currentOffset += 3 // "-->"
        }
    }

    override fun peekAhead(count: Int): CharSequence? {
        if (currentOffset + count > endOffset) return null
        return buffer.subSequence(currentOffset + 1, currentOffset + 1 + count).toString()
    }
}