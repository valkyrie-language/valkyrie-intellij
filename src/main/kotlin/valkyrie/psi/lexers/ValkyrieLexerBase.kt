package valkyrie.psi.lexers

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.lexer.LexerPositionImpl
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType

/**
 * Valkyrie 词法分析器基础类
 *
 * 提供核心的 Valkyrie 语言词法分析功能，子类可以扩展以支持特定的语法方言
 */
abstract class ValkyrieLexerBase(protected val flavor: LexerFlavor) : Lexer() {

    // 缓冲区和位置信息
    protected var buffer: CharSequence = ""
    protected var startOffset = 0
    protected var endOffset = 0
    protected var currentOffset = 0
    protected var currentTokenType: IElementType? = null

    companion object {
        // 词法分析器状态常量
        protected const val STATE_LANGUAGE = 0
    }

    // 状态变量
    protected var lexerState: Int = STATE_LANGUAGE

    /** 大括号嵌套深度 { ... } */
    protected open var braceDepth: Int = 0

    /** 字符串解析状态 */
    protected var stringDelimiter: Char? = null
    protected var stringDelimiterWidth = 0
    protected var pendingNumberMacro = false

    // 关键字映射
    protected val keywords = mapOf(
        "let" to ValkyrieTokenTypes.LET,
        "if" to ValkyrieTokenTypes.IF,
        "else" to ValkyrieTokenTypes.ELSE,
        "end" to ValkyrieTokenTypes.END,
        "while" to ValkyrieTokenTypes.WHILE,
        "loop" to ValkyrieTokenTypes.LOOP,
        "for" to ValkyrieTokenTypes.LOOP,
        "micro" to ValkyrieTokenTypes.MICRO,
        "function" to ValkyrieTokenTypes.MICRO,
        "func" to ValkyrieTokenTypes.MICRO,
        "fun" to ValkyrieTokenTypes.MICRO,
        "fn" to ValkyrieTokenTypes.MICRO,
        "mezzo" to ValkyrieTokenTypes.MEZZO,
        "type" to ValkyrieTokenTypes.MEZZO,
        "macro" to ValkyrieTokenTypes.MACRO,
        "class" to ValkyrieTokenTypes.CLASS,
        "struct" to ValkyrieTokenTypes.STRUCTURE,
        "structure" to ValkyrieTokenTypes.STRUCTURE,
        "neural" to ValkyrieTokenTypes.NEURAL,
        "widget" to ValkyrieTokenTypes.WIDGET,
        "singleton" to ValkyrieTokenTypes.SINGLETON,
        "union" to ValkyrieTokenTypes.UNION,
        "unity" to ValkyrieTokenTypes.UNITY,
        "flags" to ValkyrieTokenTypes.FLAGS,
        "enums" to ValkyrieTokenTypes.EIDOS,
        "eidos" to ValkyrieTokenTypes.EIDOS,
        "trait" to ValkyrieTokenTypes.TRAIT,
        "imply" to ValkyrieTokenTypes.IMPLY,
        "return" to ValkyrieTokenTypes.RETURN,
        "break" to ValkyrieTokenTypes.BREAK,
        "continue" to ValkyrieTokenTypes.CONTINUE,
        "yield" to ValkyrieTokenTypes.YIELD,
        "raise" to ValkyrieTokenTypes.RAISE,
        "resume" to ValkyrieTokenTypes.RESUME,
        "scope" to ValkyrieTokenTypes.SCOPE,
        "tests" to ValkyrieTokenTypes.TESTS,
        "namespace" to ValkyrieTokenTypes.NAMESPACE,
        "using" to ValkyrieTokenTypes.USING,
        "until" to ValkyrieTokenTypes.UNTIL,
        "match" to ValkyrieTokenTypes.MATCH,
        "case" to ValkyrieTokenTypes.CASE,
        "catch" to ValkyrieTokenTypes.CATCH,
        "try" to ValkyrieTokenTypes.TRY,
        "when" to ValkyrieTokenTypes.WHEN,
        "fallthrough" to ValkyrieTokenTypes.FALLTHROUGH,
        "in" to ValkyrieTokenTypes.IN,
        "is" to ValkyrieTokenTypes.IS,
        "as" to ValkyrieTokenTypes.AS,
        "true" to ValkyrieTokenTypes.BOOLEAN,
        "false" to ValkyrieTokenTypes.BOOLEAN
    )


    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentOffset = startOffset
        this.currentTokenType = null

        // 移除了 mask 机制。
        this.lexerState = STATE_LANGUAGE
        this.braceDepth = initialState

        // 重置其他状态
        this.stringDelimiter = null
        this.stringDelimiterWidth = 0
        this.pendingNumberMacro = false

        advance()
    }

    override fun getState(): Int {
        return braceDepth
    }

    override fun getTokenType(): IElementType? = currentTokenType
    override fun getTokenStart(): Int = startOffset
    override fun getTokenEnd(): Int = currentOffset
    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset

    override fun getCurrentPosition(): LexerPosition {
        return LexerPositionImpl(this.getTokenStart(), this.state)
    }

    override fun restore(position: LexerPosition) {
        this.start(this.getBufferSequence(), position.offset, this.getBufferEnd(), position.state);
    }

    /**
     * 中央调度方法：根据当前状态调用相应的处理函数
     * 子类可以重写此方法以支持额外的状态
     */
    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            else -> processLanguage() // 安全回退 (对于基类，lexerState 始终应为 STATE_LANGUAGE)
        }
    }

    /**
     * 处理 Valkyrie 语言代码
     * 这是所有方言共享的核心解析逻辑
     */
    protected open fun processLanguage() {
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

            ch.isLetter() || ch == '_' -> readIdentifier()
            ch.isDigit() -> readNumber()
            ch == '"' || ch == '\'' -> startString()
            ch == '`' -> readRawIdentifier()

            else -> readOperatorOrPunctuation(ch)
        }
    }

    // ========== 核心解析方法（所有方言共享）==========

    protected fun readWhitespace() {
        while (currentOffset < endOffset && buffer[currentOffset].isWhitespace()) {
            currentOffset++
        }
        currentTokenType = WHITE_SPACE
    }

    protected fun readIdentifier() {
        val idStart = currentOffset
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                currentOffset++
            } else {
                break
            }
        }

        // peek(0) 获取当前 currentOffset 指向的字符，即标识符后面的第一个字符
        val nextChar = peek(0)
        if (nextChar == '\'' || nextChar == '"') {
            currentTokenType = ValkyrieTokenTypes.MACRO_STRING
            return
        }

        val text = buffer.subSequence(idStart, currentOffset).toString()
        currentTokenType = keywords[text] ?: ValkyrieTokenTypes.SYMBOL_XID
    }

    protected fun readRawIdentifier() {
        // Consume the opening '`'
        currentOffset++
        while (currentOffset < endOffset && buffer[currentOffset] != '`') {
            currentOffset++
        }
        if (currentOffset < endOffset) {
            // Consume the closing '`'
            currentOffset++
            currentTokenType = ValkyrieTokenTypes.SYMBOL_RAW
        }
        // 未闭合的原始标识符
        else {
            currentTokenType = BAD_CHARACTER
        }
    }

    protected fun readNumber() {
        var hasDecimalPoint = false
        val numberStart = currentOffset

        if (buffer[currentOffset] == '0' && peek()?.lowercaseChar() in listOf('b', 'x')) {
            val prefix = peek()!!.lowercaseChar()
            currentOffset += 2
            val validChars = if (prefix == 'b') "01" else "0123456789abcdefABCDEF"
            while (currentOffset < endOffset && buffer[currentOffset] in validChars) {
                currentOffset++
            }
            currentTokenType = ValkyrieTokenTypes.INTEGER
        } else {
            while (currentOffset < endOffset) {
                val ch = buffer[currentOffset]
                if (ch.isDigit()) {
                    currentOffset++
                } else if (ch == '.' && !hasDecimalPoint && peek()?.isDigit() == true) {
                    hasDecimalPoint = true
                    currentOffset++
                } else {
                    break
                }
            }
            currentTokenType = if (hasDecimalPoint) ValkyrieTokenTypes.DECIMAL else ValkyrieTokenTypes.INTEGER
        }

        if (currentOffset > numberStart && currentOffset < endOffset) {
            val nextChar = buffer[currentOffset]
            if (nextChar.isLetter() || nextChar == '_') {
                pendingNumberMacro = true
            }
        }
    }

    // 10mm, 10kg
    protected fun readNumberMacro() {
        pendingNumberMacro = false
        val macroStart = currentOffset
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                currentOffset++
            } else {
                break
            }
        }
        if (currentOffset > macroStart) {
            currentTokenType = ValkyrieTokenTypes.MACRO_NUMBER
        } else {
            // 如果没有读取到宏标识符，则为错误字符
            currentTokenType = BAD_CHARACTER
        }
    }

    protected fun startString() {
        val delimiter = buffer[currentOffset]
        var width = 0
        while (currentOffset + width < endOffset && buffer[currentOffset + width] == delimiter) {
            width++
        }

        stringDelimiter = delimiter
        stringDelimiterWidth = width
        currentOffset += width
        currentTokenType = ValkyrieTokenTypes.STRING_START
    }

    protected fun processStringToken() {
        if (isAtStringEnd()) {
            currentOffset += stringDelimiterWidth
            currentTokenType = ValkyrieTokenTypes.STRING_END
            stringDelimiter = null
            stringDelimiterWidth = 0
        } else {
            val contentStart = currentOffset
            while (currentOffset < endOffset && !isAtStringEnd()) {
                currentOffset++
            }
            currentTokenType = when {
                currentOffset > contentStart -> ValkyrieTokenTypes.STRING_TEXT
                // 如果没有读取到文本内容，且不是字符串结束，可能是未闭合或空字符串的错误情况
                else -> BAD_CHARACTER
            }
        }
    }

    private fun isAtStringEnd(): Boolean {
        if (currentOffset + stringDelimiterWidth > endOffset) return false
        for (i in 0 until stringDelimiterWidth) {
            if (buffer[currentOffset + i] != stringDelimiter) {
                return false
            }
        }
        return true
    }


    protected fun skipLineComment() {
        currentOffset++
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    protected fun skipBlockComment() {

    }

    protected fun skipDocComment() {
        currentOffset += 2
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    // ========== 辅助方法 ==========

    protected fun peek(offset: Int = 1): Char? {
        val pos = currentOffset + offset
        return if (pos < endOffset) buffer[pos] else null
    }

    protected fun peekNextKeyword(): String {
        var tempOffset = currentOffset
        // 跳过空格
        while (tempOffset < endOffset && buffer[tempOffset].isWhitespace()) {
            tempOffset++
        }

        // 读取单词
        val keywordStart = tempOffset
        while (tempOffset < endOffset) {
            val ch = buffer[tempOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                tempOffset++
            } else {
                break
            }
        }

        return if (tempOffset > keywordStart) {
            buffer.subSequence(keywordStart, tempOffset).toString()
        } else {
            ""
        }
    }

    protected fun peekNextWord(): String {
        var tempOffset = currentOffset
        // 跳过空格
        while (tempOffset < endOffset && buffer[tempOffset].isWhitespace()) {
            tempOffset++
        }

        // 读取单词
        val wordStart = tempOffset
        while (tempOffset < endOffset) {
            val ch = buffer[tempOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                tempOffset++
            } else {
                break
            }
        }

        return if (tempOffset > wordStart) {
            buffer.subSequence(wordStart, tempOffset).toString()
        } else {
            ""
        }
    }

    protected fun isAtStartOfLine(): Boolean {
        if (currentOffset == 0) return true
        var pos = currentOffset - 1
        while (pos >= 0 && buffer[pos].isWhitespace() && buffer[pos] != '\n') {
            pos--
        }
        return pos < 0 || buffer[pos] == '\n'
    }

    protected fun isValkyrieKeyword(word: String): Boolean {
        return keywords.containsKey(word)
    }

    /**
     * 读取操作符和标点符号
     * 这个方法包含了现有 ValkyrieLexer 中的所有操作符解析逻辑
     */
    protected fun readOperatorOrPunctuation(ch: Char) {
        when (ch) {
            '<' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++; currentTokenType = ValkyrieTokenTypes.LESS_EQUAL
                } else {
                    currentTokenType = ValkyrieTokenTypes.ANGLE_L
                }
            }

            '=' -> {
                currentOffset++
                when (peek(0)) {
                    '=' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.EQUAL
                    }

                    '>' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.DOUBLE_ARROW
                    }

                    else -> currentTokenType = ValkyrieTokenTypes.ASSIGN
                }
            }

            '!' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.NOT_EQUAL
                } else {
                    currentTokenType = ValkyrieTokenTypes.WOW
                }
            }

            '>' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.GREATER_EQUAL
                } else {
                    currentTokenType = ValkyrieTokenTypes.ANGLE_R
                }
            }

            '}' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.BRACE_R
            }

            '&' -> {
                currentOffset++
                if (peek(0) == '&') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.LOGIC_AND
                } else {
                    currentTokenType = ValkyrieTokenTypes.AMPERSAND
                }
            }

            '|' -> {
                currentOffset++
                if (peek(0) == '|') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.LOGIC_OR
                } else {
                    currentTokenType = ValkyrieTokenTypes.PIPE
                }
            }

            '-' -> {
                currentOffset++
                when (peek(0)) {
                    '>' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.ARROW
                    }

                    '=' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.MINUS_ASSIGN
                    }

                    else -> currentTokenType = ValkyrieTokenTypes.MINUS
                }
            }

            '+' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.PLUS_ASSIGN
                } else {
                    currentTokenType = ValkyrieTokenTypes.PLUS
                }
            }

            '*' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.MULTIPLY_ASSIGN
                } else {
                    currentTokenType = ValkyrieTokenTypes.STAR
                }
            }

            '/' -> {
                currentOffset++
                when (peek(0)) {
                    '/' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.INTEGER_DIVIDE
                    }

                    '=' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.DIVIDE_ASSIGN
                    }

                    else -> currentTokenType = ValkyrieTokenTypes.SLASH
                }
            }

            '^' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.POWER_ASSIGN
                } else {
                    currentTokenType = ValkyrieTokenTypes.POWER
                }
            }

            '%' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.MODULO_ASSIGN
                } else {
                    currentTokenType = ValkyrieTokenTypes.PERCENT
                }
            }

            ';' -> {
                currentOffset++
                if (currentOffset < bufferEnd && buffer[currentOffset] == ';') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.DOUBLE_SEMICOLON
                } else {
                    currentTokenType = ValkyrieTokenTypes.SEMICOLON
                }
            }

            ',' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.COMMA
            }

            '.' -> {
                currentOffset++
                if (peek(0) == '.') {
                    currentOffset++
                    when (peek(0)) {
                        '.' -> {
                            currentOffset++; currentTokenType = ValkyrieTokenTypes.ELLIPSIS
                        }

                        '=' -> {
                            currentOffset++; currentTokenType = ValkyrieTokenTypes.DOT_DOT_EQUAL
                        }

                        '<' -> {
                            currentOffset++; currentTokenType = ValkyrieTokenTypes.DOT_DOT_LESS
                        }

                        else -> currentTokenType = ValkyrieTokenTypes.DOT_DOT
                    }
                } else {
                    currentTokenType = ValkyrieTokenTypes.DOT
                }
            }

            ':' -> {
                currentOffset++
                if (peek(0) == ':') {
                    currentOffset++
                    currentTokenType = ValkyrieTokenTypes.DOUBLE_COLON
                } else {
                    currentTokenType = ValkyrieTokenTypes.COLON
                }
            }

            '(' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.PARENTHESIS_L
            }

            ')' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.PARENTHESIS_R
            }

            '{' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.BRACE_L
            }

            '[' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.BRACKET_L
            }

            ']' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.BRACKET_R
            }

            '?' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.WHAT
            }

            '_' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.UNDERSCORE
            }

            '@' -> {
                currentOffset++
                when (peek(0)) {
                    '^' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.ATTRIBUTE_UPPER
                    }

                    '.' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.ATTRIBUTE_LOWER
                    }

                    '*' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.LABEL_MARK
                    }

                    '$' -> {
                        currentOffset++; currentTokenType = ValkyrieTokenTypes.INTERNATIONAL_MARK
                    }

                    else -> currentTokenType = ValkyrieTokenTypes.AT
                }
            }
            // Unicode 操作符
            '↯' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.ATTRIBUTE_LOWER
            }

            '※' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LABEL_MARK
            }

            '⸿' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.INTERNATIONAL_MARK
            }

            '∧' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LOGIC_AND
            }

            '∨' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LOGIC_OR
            }

            '⩟' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LOGIC_XAND
            }

            '⊼' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LOGIC_NAND
            }

            '⊻' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LOGIC_XOR
            }

            '⊽' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.LOGIC_NOR
            }

            '⟨' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.GENERIC_L
            }

            '⟩' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.GENERIC_R
            }

            '×' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.MULTIPLY
            }

            '⅟' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.RECIPROCAL
            }

            '℃' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.CELSIUS
            }

            '℉' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.FAHRENHEIT
            }

            '‰' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.PERMILLE
            }

            'ⱑ' -> { // 字符 'ⱑ' 对应 PERMYRIAD token
                currentOffset++; currentTokenType = ValkyrieTokenTypes.PERMYRIAD
            }

            else -> {
                currentOffset++
                currentTokenType = BAD_CHARACTER
            }
        }
    }

}