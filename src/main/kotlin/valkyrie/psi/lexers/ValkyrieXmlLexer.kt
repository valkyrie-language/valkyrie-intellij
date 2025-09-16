package valkyrie.psi.lexers
import com.intellij.psi.xml.XmlTokenType

/**
 * XML Valkyrie 词法分析器
 *
 * 用于解析声明式 UI 文件 (.vkx)
 * 支持 XML 标签语法和嵌入的 Valkyrie 表达式
 *
 * 示例：
 * ```
 * <div class="container">
 *   <h1>{ title }</h1>
 *   <p>Welcome, { user.name }!</p>
 *   <button onclick={ handleClick }>
 *     Click me
 *   </button>
 * </div>
 * ```
 */
class ValkyrieXmlLexer : ValkyrieLexerBase(LexerFlavor.XML) {

    companion object {
        private const val STATE_XML_TEXT = 3        // 解析 XML 标签间文本
        private const val XML_DEPTH_SHIFT = 16
    }

    // XML 特定状态
    private var tagDepth: Int = 0       // XML 标签嵌套深度 <div> ... </div>
    override var braceDepth: Int = 0     // 大括号嵌套深度 { ... }
    private var currentTagName: String? = null  // 当前正在处理的标签名

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)

        if (initialState == 0) {
            // XML 文件默认从语言模式开始（解析标签）
            this.lexerState = STATE_LANGUAGE
            this.tagDepth = 0
        } else {
            // 从之前的状态恢复 - 移除 STATE_MASK，直接使用位移
            this.tagDepth = initialState shr XML_DEPTH_SHIFT
        }
    }

    override fun getState(): Int {
        return (tagDepth shl XML_DEPTH_SHIFT) or super.getState()
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            STATE_XML_TEXT -> processXmlText()
            else -> processLanguage() // 安全回退
        }
    }

    override fun processLanguage() {
        // 优先处理多-token 状态 (字符串和数字宏)
        if (stringDelimiter != null) {
            processStringToken()
            return
        }
        if (pendingNumberMacro) {
            readNumberMacro()
            return
        }

        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace()
            ch == '⍝' -> {
                skipLineComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' && peek() == '?' -> {
                skipDocComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' -> {
                skipLineComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_LINE
            }

            ch == '<' && peek() == '#' -> {
                skipBlockComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_RANGE
            }

            ch.isLetter() || ch == '_' -> readIdentifierAndCheckTag()
            ch.isDigit() -> readNumber()
            ch == '"' || ch == '\'' -> startString()
            ch == '`' -> readRawIdentifier()

            // XML 特定的边界标记处理
            ch == '<' -> handleXmlTagStart()
            ch == '>' -> handleXmlTagEnd()
            ch == '{' -> handleBraceStart()
            ch == '}' -> handleBraceEnd()

            else -> readOperatorOrPunctuation(ch)
        }
    }

    /**
     * 处理 XML 文本（标签间文本）
     */
    private fun processXmlText() {
        // 如果遇到 '<' 或 '{'，切换到语言模式
        if (peek(0) == '<' || peek(0) == '{') {
            lexerState = STATE_LANGUAGE
            return
        }

        // 读取文本直到下一个 '<' 或 '{' 或文件末尾
        val textStart = currentOffset
        while (currentOffset < endOffset && peek(0) != '<' && peek(0) != '{') {
            currentOffset++
        }

        if (currentOffset > textStart) {
            currentTokenType = ValkyrieTokenTypes.XML_TEXT
        } else {
            currentTokenType = null
        }
    }

    private fun readIdentifierAndCheckTag() {
        readIdentifier()

        // 检查是否是标签名
        val tokenText = buffer.subSequence(startOffset, currentOffset).toString()
        currentTagName = tokenText
    }

    private fun handleXmlTagStart() {
        currentOffset++
        if (peek(0) != '/') tagDepth++
        currentTokenType = ValkyrieTokenTypes.ANGLE_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleXmlTagEnd() {
        currentOffset++
        val isClosingTag = currentOffset > 1 && buffer[currentOffset - 2] == '/'
        val isSelfClosing = currentOffset > 1 && buffer[currentOffset - 2] == '/'

        if (isClosingTag || isSelfClosing) {
            tagDepth = (tagDepth - 1).coerceAtLeast(0)
            currentTagName = null
        }

        currentTokenType = ValkyrieTokenTypes.ANGLE_R

        // 标签头结束，进入子节点区域
        if (tagDepth > 0) {
            lexerState = STATE_XML_TEXT
        }
    }

    private fun handleBraceStart() {
        currentOffset++
        braceDepth++
        // 在XML上下文中，使用XML_SLOT_L而不是BRACE_L
        currentTokenType = if (tagDepth > 0) ValkyrieTokenTypes.XML_SLOT_L else ValkyrieTokenTypes.BRACE_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0)
        // 在XML上下文中，使用XML_SLOT_R而不是BRACE_R
        currentTokenType = if (tagDepth > 0) ValkyrieTokenTypes.XML_SLOT_R else ValkyrieTokenTypes.BRACE_R

        // 表达式结束，返回 XML 文本状态
        if (braceDepth == 0 && tagDepth > 0) {
            lexerState = STATE_XML_TEXT
        }
    }
}