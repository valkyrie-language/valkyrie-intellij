package valkyrie.psi.lexers

import com.intellij.psi.TokenType.BAD_CHARACTER
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

    // 用于在 { ... } 嵌入块中保存和恢复状态
    private var storedLexerState: Int = STATE_LANGUAGE

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        // 注意：这里的 initialState 来自基类，仅用于 braceDepth。我们不应该用它来设置 XML 状态。
        super.start(buffer, startOffset, endOffset, initialState)
        // 每次 start 都必须重置 XML 特定状态
        tagDepth = 0
        storedLexerState = STATE_LANGUAGE
        lexerState = STATE_LANGUAGE // 总是从顶层语言状态开始
    }

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
        // 在嵌入代码中，如果大括号平衡了，就返回到之前的 XML 模式
        if (braceDepth > 0 && buffer[currentOffset] == '}') {
            handleBraceEnd()
            return
        }

        val ch = buffer[currentOffset]
        // 只有当不在嵌入代码块中时，才将 '<' 视为潜在的 XML 标签起始
        if (ch == '<' && braceDepth == 0 && isStartOfTag()) {
            handleXmlTagStart()
        } else {
            // 否则，它只是一个比较运算符或泛型，由基类处理
            super.processLanguage()
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。
     */
    private fun processXmlText() {
        when (buffer[currentOffset]) {
            '<' -> handleXmlTagStart() // 可能是新标签或闭合标签
            '{' -> handleBraceStart()  // 可能是嵌入表达式
            else -> {
                // 读取直到下一个 '<' 或 '{'
                val contentStart = currentOffset
                while (currentOffset < endOffset && buffer[currentOffset].let { it != '<' && it != '{' }) {
                    currentOffset++
                }

                // 只有在确实读取了内容时才生成 token
                if (currentOffset > contentStart) {
                    currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
                } else {
                    // 如果没有内容（例如 <div></div>），我们不能卡住，需要继续前进。
                    // 再次调用 advance() 将会命中上面 '<' 或 '{' 的 case。
                    advance()
                }
            }
        }
    }

    /**
     * 状态 2: 处理 XML 标签内部 (<...>)。
     */
    private fun processXmlTag() {
        // 在标签内部，如果遇到 '}' 并且我们在一个嵌入块中，则处理它
        if (braceDepth > 0 && buffer[currentOffset] == '}') {
            handleBraceEnd()
            return
        }

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
                // 只有开始标签会增加 tagDepth，所以这里不需要减少
                lexerState = if (tagDepth == 0) STATE_LANGUAGE else STATE_XML_TEXT
            }

            ch == '/' && peek() == '>' -> {
                currentOffset += 2
                currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                tagDepth = (tagDepth - 1).coerceAtLeast(0) // 自闭合标签，深度减一
                lexerState = if (tagDepth == 0) STATE_LANGUAGE else STATE_XML_TEXT
            }

            ch == '{' -> handleBraceStart() // 支持在属性值中使用嵌入代码
            else -> {
                // 避免回退到 `super.readOperatorOrPunctuation`，那会导致错误
                currentOffset++
                currentTokenType = BAD_CHARACTER
            }
        }
    }

    /**
     * 检查当前位置'<'是否为一个 XML 标签的开始，而不是一个比较运算符。
     */
    private fun isStartOfTag(): Boolean {
        // peek() 默认 offset=1，即查看下一个字符
        val next = peek() ?: return false

        // <tag...
        if (next.isLetter() || next == '_') {
            return true
        }
        // </tag...
        if (next == '/') {
            val afterSlash = peek(2) // 查看 '<' 之后第 2 个字符
            return afterSlash != null && (afterSlash.isLetter() || afterSlash == '_')
        }
        // <!-- comment...
        if (next == '!') {
            return peek(2) == '-' && peek(3) == '-'
        }
        return false
    }

    /**
     * 处理 XML 标签的开始，包括开始标签、结束标签和注释。
     */
    private fun handleXmlTagStart() {
        // 检查 XML 注释 `<!--`
        if (peek() == '!' && peek(2) == '-' && peek(3) == '-') {
            skipXmlComment()
            return // skipXmlComment 已设置 token 类型，直接返回
        }

        // 结束标签: </
        if (peek() == '/') {
            currentOffset += 2 // consume '</'
            currentTokenType = XmlTokenType.XML_END_TAG_START
            tagDepth = (tagDepth - 1).coerceAtLeast(0)
            lexerState = STATE_XML_TAG
        }
        // 开始标签: <
        else {
            currentOffset++ // consume '<'
            currentTokenType = XmlTokenType.XML_START_TAG_START
            tagDepth++
            lexerState = STATE_XML_TAG
        }
    }

    private fun handleBraceStart() {
        storedLexerState = lexerState // 保存当前状态 (可能是 STATE_XML_TAG 或 STATE_XML_TEXT)
        currentOffset++
        braceDepth++
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_L
        lexerState = STATE_LANGUAGE // 切换到 Valkyrie SLOT 代码解析模式
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_R

        // 只有当最外层的大括号闭合时，才恢复状态
        if (braceDepth == 0) {
            lexerState = storedLexerState
        }
        // 否则，我们仍在嵌套的 Valkyrie 代码中，状态保持为 STATE_LANGUAGE
    }

    private fun readXmlTagNameOrAttrName() {
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch in "_-:") {
                currentOffset++
            } else {
                break
            }
        }
        // TODO: 根据上下文决定这是标签名还是属性名
        currentTokenType = XmlTokenType.XML_NAME
    }

    private fun readAttributeValue() {
        val quote = buffer[currentOffset]
        currentOffset++ // consume opening quote
        val valueStart = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != quote) {
            // TODO: 处理转义字符
            currentOffset++
        }

        // TODO: 分别为引号和值生成 token
        startOffset = valueStart
        currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN

        if (currentOffset < endOffset) {
            val valueEnd = currentOffset
            currentOffset++ // consume closing quote
            // 重新设置 startOffset 和 end(currentOffset)
            startOffset = valueStart
            this.currentOffset = valueEnd // getTokenEnd() 会使用这个值
        }
    }

    private fun skipXmlComment() {
        val commentStartOffset = startOffset // 保存'<'的位置
        currentOffset += 4 // Consume "<!--"

        // 寻找 "-->"
        while (currentOffset + 2 < endOffset) {
            if (buffer[currentOffset] == '-' && buffer[currentOffset + 1] == '-' && buffer[currentOffset + 2] == '>') {
                currentOffset += 3 // Consume "-->"
                // 找到了完整的注释
                startOffset = commentStartOffset // token 从'<'开始
                currentTokenType = XmlTokenType.XML_COMMENT_START
                return
            }
            currentOffset++
        }

        // 如果没有找到结束符，则将整个剩余部分作为注释
        startOffset = commentStartOffset
        currentTokenType = XmlTokenType.XML_COMMENT_END
    }
}