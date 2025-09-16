package valkyrie.psi.lexers

/**
 * String Valkyrie 词法分析器
 * 
 * 用于解析字符串方言文件 (.vks)
 * 支持字符串文本和嵌入的 {} 插值表达式，插值可以嵌套
 * 
 * 示例：
 * ```
 * Hello, {user.name}!
 * Welcome to {app.title} - {version.major}.{version.minor}
 * Complex: {items.map(item => "Item: {item.name}")}
 * ```
 */
class ValkyrieStringLexer : ValkyrieLexerBase(LexerFlavor.STRING) {
    
    companion object {
        private const val STATE_STRING_TEXT = 2        // 解析字符串文本
        private const val STRING_DEPTH_SHIFT = 16
    }
    
    // 字符串特定状态
    private var interpolationDepth: Int = 0       // {} 插值嵌套深度
    
    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)
        
        if (initialState == 0) {
            // String 文件默认从字符串文本模式开始
            this.lexerState = STATE_STRING_TEXT
            this.interpolationDepth = 0
        } else {
            // 从之前的状态恢复 - 移除 STATE_MASK，直接使用位移
            this.interpolationDepth = initialState shr STRING_DEPTH_SHIFT
        }
    }
    
    override fun getState(): Int {
        return (interpolationDepth shl STRING_DEPTH_SHIFT) or super.getState()
    }
    
    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            STATE_STRING_TEXT -> processStringText()
            else -> processStringText() // 安全回退
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
            ch == '⍝' -> { skipLineComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT }
            ch == '#' && peek() == '?' -> { skipDocComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT }
            ch == '#' -> { skipLineComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_LINE }
            ch == '<' && peek() == '#' -> { skipBlockComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_RANGE }
            ch.isLetter() || ch == '_' -> readIdentifier()
            ch.isDigit() -> readNumber()
            ch == '"' || ch == '\'' -> startString()
            ch == '`' -> readRawIdentifier()
            
            // 字符串特定的边界标记处理
            ch == '{' -> handleBraceStart()
            ch == '}' -> handleBraceEnd()
            
            else -> readOperatorOrPunctuation(ch)
        }
    }
    
    /**
     * 处理字符串文本（最外层文本）
     */
    private fun processStringText() {
        // 如果遇到 '{'，切换到语言模式
        if (peek(0) == '{') {
            lexerState = STATE_LANGUAGE
            return
        }

        // 读取文本直到下一个 '{' 或文件末尾
        val textStart = currentOffset
        while (currentOffset < endOffset && peek(0) != '{') {
            currentOffset++
        }

        if (currentOffset > textStart) {
            currentTokenType = ValkyrieTokenTypes.STRING_TEXT
        } else {
            currentTokenType = null
        }
    }

    private fun handleBraceStart() {
        currentOffset++
        interpolationDepth++
        currentTokenType = ValkyrieTokenTypes.BRACE_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        interpolationDepth = (interpolationDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.BRACE_R
        
        // 插值表达式结束，返回字符串文本状态
        if (interpolationDepth == 0) {
            lexerState = STATE_STRING_TEXT
        }
    }
}