package valkyrie.psi.lexers

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.lexer.LexerPositionImpl
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.parsers.ValkyrieTypes


/**
 * Valkyrie 词法分析器基础类
 *
 * 提供核心的 Valkyrie 语言词法分析功能，子类可以扩展以支持特定的语法方言
 */
open class ValkyrieLexer(config: ValkyrieLanguageConfig) : Lexer() {
    // 配置项
    protected val config: ValkyrieLanguageConfig = config

    // 缓冲区和位置信息
    protected var buffer: CharSequence = ""
    protected var startOffset = 0
    protected var endOffset = 0
    protected var currentOffset = 0
    protected var currentTokenType: IElementType? = null

    companion object {
        // 词法分析器状态常量
        protected const val STATE_LANGUAGE = 0 // 用于解析 Valkyrie 语言代码的默认状态
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
    protected open val keywords = mapOf(
        "let" to ValkyrieTypes.LET,
        "if" to ValkyrieTypes.IF,
        "else" to ValkyrieTypes.ELSE,
        "end" to ValkyrieTypes.EJS_END,
        "while" to ValkyrieTypes.WHILE,
        "loop" to ValkyrieTypes.LOOP,
        "for" to ValkyrieTypes.LOOP,
        "micro" to ValkyrieTypes.MICRO,
        "function" to ValkyrieTypes.MICRO,
        "func" to ValkyrieTypes.MICRO,
        "fun" to ValkyrieTypes.MICRO,
        "fn" to ValkyrieTypes.MICRO,
        "mezzo" to ValkyrieTypes.MEZZO,
        "macro" to ValkyrieTypes.MACRO,
        "class" to ValkyrieTypes.CLASS,
        "struct" to ValkyrieTypes.STRUCTURE,
        "structure" to ValkyrieTypes.STRUCTURE,
        "neural" to ValkyrieTypes.NEURAL,
        "widget" to ValkyrieTypes.WIDGET,
        "singleton" to ValkyrieTypes.SINGLETON,
        "union" to ValkyrieTypes.UNION,
        "unity" to ValkyrieTypes.UNITY,
        "flags" to ValkyrieTypes.FLAGS,
        "enums" to ValkyrieTypes.EIDOS,
        "eidos" to ValkyrieTypes.EIDOS,
        "trait" to ValkyrieTypes.TRAIT,
        "imply" to ValkyrieTypes.IMPLY,
        "constructor" to ValkyrieTypes.CONSTRUCTOR,
        "return" to ValkyrieTypes.RETURN,
        "assert" to ValkyrieTypes.ASSERT,
        "debug" to ValkyrieTypes.DEBUG,
        "break" to ValkyrieTypes.BREAK,
        "continue" to ValkyrieTypes.CONTINUE,
        "yield" to ValkyrieTypes.YIELD,
        "raise" to ValkyrieTypes.RAISE,
        "resume" to ValkyrieTypes.RESUME,
        "scope" to ValkyrieTypes.SCOPE,
        "tests" to ValkyrieTypes.TESTS,
        "namespace" to ValkyrieTypes.NAMESPACE,
        "using" to ValkyrieTypes.USING,
        "until" to ValkyrieTypes.UNTIL,
        "match" to ValkyrieTypes.MATCH,
        "type" to ValkyrieTypes.TYPE,
        "typus" to ValkyrieTypes.TYPE,
        "case" to ValkyrieTypes.CASE,
        "catch" to ValkyrieTypes.CATCH,
        "try" to ValkyrieTypes.TRY,
        "when" to ValkyrieTypes.WHEN,
        "fallthrough" to ValkyrieTypes.FALLTHROUGH,
        "not" to ValkyrieTypes.NOT,
        "in" to ValkyrieTypes.IN,
        "is" to ValkyrieTypes.IS,
        "as" to ValkyrieTypes.AS,
        "true" to ValkyrieTypes.BOOLEAN,
        "false" to ValkyrieTypes.BOOLEAN,
        "nil" to ValkyrieTypes.NIL,
        "null" to ValkyrieTypes.NULL,
        "Some" to ValkyrieTypes.KW_SOME,
        "None" to ValkyrieTypes.KW_NONE,
        "self" to ValkyrieTypes.KW_SELF,
        "Self" to ValkyrieTypes.KW_SELF_TYPE,
        "value" to ValkyrieTypes.KW_VALUE,
        "V" to ValkyrieTypes.KW_V
    )


    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentOffset = startOffset
        this.currentTokenType = null

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
     * 子类可以覆盖此方法，在特定状态下调用不同的处理逻辑
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
                skipLineComment(); currentTokenType = ValkyrieTypes.COMMENT_DOCUMENT
            }

            ch == '#' && peek() == '?' -> {
                skipDocComment(); currentTokenType = ValkyrieTypes.COMMENT_DOCUMENT
            }

            ch == '#' -> {
                skipLineComment(); currentTokenType = ValkyrieTypes.COMMENT_LINE
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

    protected open fun readIdentifier() {
        val idStart = currentOffset
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                currentOffset++
            } else {
                break
            }
        }

        val nextChar = peek(0) // Note: this is actually correct here as it looks at the current character after the loop
        if (nextChar == '\'' || nextChar == '"') {
            currentTokenType = ValkyrieTypes.MACRO_STRING
            return
        }

        val text = buffer.subSequence(idStart, currentOffset).toString()

        // 根据配置项决定是否将某些关键字视为关键字
        var tokenType = keywords[text]

        // 如果不允许旧的 function 语法，那么 fn、fun、function 等不应该被视为关键字
        if (!config.allow_legacy_function) {
            when (text) {
                "fn", "fun", "function" -> tokenType = null
            }
        }

        // 如果不允许旧的 struct 语法，那么 struct 不应该被视为关键字
        if (!config.allow_legacy_struct && text == "struct") {
            tokenType = null
        }

        // 如果不允许旧的 for 语法，那么 for 不应该被视为关键字
        if (!config.allow_legacy_for && text == "for") {
            tokenType = null
        }

        currentTokenType = tokenType ?: ValkyrieTypes.SYMBOL_XID
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
            currentTokenType = ValkyrieTypes.SYMBOL_RAW
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
            currentTokenType = ValkyrieTypes.INTEGER
        } else {
            while (currentOffset < endOffset) {
                val ch = buffer[currentOffset]
                if (ch.isDigit()) {
                    currentOffset++
                }
                // Make sure it's not ".."
                else if (ch == '.' && !hasDecimalPoint && peek()?.isDigit() == true) {
                    hasDecimalPoint = true
                    currentOffset++
                } else {
                    break
                }
            }
            currentTokenType = if (hasDecimalPoint) ValkyrieTypes.DECIMAL else ValkyrieTypes.INTEGER
        }

        if (currentOffset > numberStart && currentOffset < endOffset) {
            val nextChar = buffer[currentOffset]
            if (nextChar == '\'' || nextChar == '"') {
                pendingNumberMacro = true
            } else if (nextChar.isLetter() || nextChar == '_') {
                pendingNumberMacro = true
            }
        }
    }

    // 10mm, 10kg
    protected fun readNumberMacro() {
        pendingNumberMacro = false
        val macroStart = currentOffset
        if (currentOffset < endOffset && (buffer[currentOffset] == '\'' || buffer[currentOffset] == '"')) {
            // It's a macro string starting with a number, e.g., 10"foo"
            // The processLanguage will handle ch == '"' in the next iteration if we don't handle it here.
            // But we want this to be a MACRO_STRING or similar.
            // Actually, the current logic for MACRO_STRING is in readIdentifier.
            // Let's just mark it as MACRO_STRING and let processLanguage handle the string part.
            currentTokenType = ValkyrieTypes.MACRO_STRING
            return
        }
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                currentOffset++
            } else {
                break
            }
        }
        if (currentOffset > macroStart) {
            currentTokenType = ValkyrieTypes.MACRO_NUMBER
        } else {
            // 如果没有读取到宏标识符，则为错误字符
            currentTokenType = BAD_CHARACTER
        }
    }

    protected fun startString() {
        val delimiter = buffer[currentOffset]
        var width = 0
        while (currentOffset + width < endOffset && buffer[currentOffset + width] == delimiter && width < 3) {
            width++
        }

        // Only allow width 1 or 3
        if (width == 2) {
            width = 1
        }

        stringDelimiter = delimiter
        stringDelimiterWidth = width
        currentOffset += width
        currentTokenType = ValkyrieTypes.STRING_START
    }

    protected fun processStringToken() {
        if (isAtStringEnd()) {
            currentOffset += stringDelimiterWidth
            currentTokenType = ValkyrieTypes.STRING_END
            stringDelimiter = null
            stringDelimiterWidth = 0
        } else {
            val contentStart = currentOffset
            while (currentOffset < endOffset && !isAtStringEnd()) {
                if (buffer[currentOffset] == '\\' && stringDelimiterWidth == 1) {
                    currentOffset++
                    if (currentOffset < endOffset) {
                        currentOffset++
                    }
                } else {
                    currentOffset++
                }
            }
            currentTokenType = if (currentOffset > contentStart) ValkyrieTypes.STRING_TEXT else BAD_CHARACTER
        }
    }

    private fun isAtStringEnd(): Boolean {
        // should not happen if stringDelimiter is set
        if (stringDelimiter == null) return false
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

    // 开放以供子类覆盖，例如处理 XML 块注释
    protected open fun skipBlockComment() {
        // 默认实现为空，将当前字符标记为错误
        currentOffset++
        currentTokenType = BAD_CHARACTER
    }

    protected fun skipDocComment() {
        currentOffset += 2 // Skip #?
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    // ========== 辅助方法 ==========

    protected open fun peek(offset: Int = 1): Char? {
        val pos = currentOffset + offset
        return if (pos < endOffset) buffer[pos] else null
    }

    protected open fun peekAhead(length: Int): CharSequence? {
        val start = currentOffset
        val end = minOf(endOffset, currentOffset + length)
        return if (start < end) buffer.subSequence(start, end) else null
    }

    protected fun isValkyrieKeyword(word: String): Boolean {
        return keywords.containsKey(word)
    }

    /**
     * 读取操作符和标点符号
     * 这个方法包含了现有 ValkyrieLexer 中的所有操作符解析逻辑
     * 开放以供子类覆盖，以处理特殊字符（例如 XML 的 < > { }）
     */
    protected open fun readOperatorOrPunctuation(ch: Char) {
        when (ch) {
            '<' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++; currentTokenType = ValkyrieTypes.LESS_EQUAL
                } else {
                    currentTokenType = ValkyrieTypes.ANGLE_L
                }
            }

            '=' -> {
                currentOffset++
                when (peek(0)) {
                    '=' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.EQUAL
                    }

                    '>' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.DOUBLE_ARROW
                    }

                    else -> currentTokenType = ValkyrieTypes.ASSIGN
                }
            }

            '!' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.NOT_EQUAL
                } else {
                    currentTokenType = ValkyrieTypes.WOW
                }
            }

            '>' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.GREATER_EQUAL
                } else {
                    currentTokenType = ValkyrieTypes.ANGLE_R
                }
            }

            '}' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.BRACE_R
            }

            '&' -> {
                currentOffset++
                if (peek(0) == '&') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.LOGIC_AND
                } else {
                    currentTokenType = ValkyrieTypes.AMPERSAND
                }
            }

            '|' -> {
                currentOffset++
                if (peek(0) == '|') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.LOGIC_OR
                } else {
                    currentTokenType = ValkyrieTypes.PIPE
                }
            }

            '-' -> {
                currentOffset++
                when (peek(0)) {
                    '>' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.ARROW
                    }

                    '=' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.MINUS_ASSIGN
                    }

                    else -> currentTokenType = ValkyrieTypes.MINUS
                }
            }

            '+' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.PLUS_ASSIGN
                } else {
                    currentTokenType = ValkyrieTypes.PLUS
                }
            }

            '*' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.MULTIPLY_ASSIGN
                } else {
                    currentTokenType = ValkyrieTypes.STAR
                }
            }

            '/' -> {
                currentOffset++
                when (peek(0)) {
                    '/' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.INTEGER_DIVIDE
                    }

                    '=' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.DIVIDE_ASSIGN
                    }

                    else -> currentTokenType = ValkyrieTypes.SLASH
                }
            }

            '^' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.POWER_ASSIGN
                } else {
                    currentTokenType = ValkyrieTypes.POWER
                }
            }

            '%' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.MODULO_ASSIGN
                } else {
                    currentTokenType = ValkyrieTypes.PERCENT
                }
            }

            ';' -> {
                currentOffset++
                if (currentOffset < bufferEnd && buffer[currentOffset] == ';') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.DOUBLE_SEMICOLON
                } else {
                    currentTokenType = ValkyrieTypes.SEMICOLON
                }
            }

            ',' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.COMMA
            }

            '.' -> {
                currentOffset++
                if (peek(0) == '.') {
                    currentOffset++
                    when (peek(0)) {
                        '.' -> {
                            currentOffset++; currentTokenType = ValkyrieTypes.ELLIPSIS
                        }

                        '=' -> {
                            currentOffset++; currentTokenType = ValkyrieTypes.DOT_DOT_EQUAL
                        }

                        '<' -> {
                            currentOffset++; currentTokenType = ValkyrieTypes.DOT_DOT_LESS
                        }

                        else -> currentTokenType = ValkyrieTypes.DOT_DOT
                    }
                } else {
                    currentTokenType = ValkyrieTypes.DOT
                }
            }

            '⸬' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.DOT_CIRCLE
            }

            ':' -> {
                currentOffset++
                if (peek(0) == ':') {
                    currentOffset++
                    currentTokenType = ValkyrieTypes.DOUBLE_COLON
                } else {
                    currentTokenType = ValkyrieTypes.COLON
                }
            }

            '(' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.PARENTHESIS_L
            }

            ')' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.PARENTHESIS_R
            }

            '{' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.BRACE_L
            }

            '[' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.BRACKET_L
            }

            ']' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.BRACKET_R
            }

            '?' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.WHAT
            }

            '_' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.UNDERSCORE
            }

            '@' -> {
                currentOffset++
                when (peek(0)) {
                    '^' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.ATTRIBUTE_UPPER
                    }

                    '.' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.ATTRIBUTE_LOWER
                    }

                    '*' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.LABEL_MARK
                    }

                    '$' -> {
                        currentOffset++; currentTokenType = ValkyrieTypes.INTERNATIONAL_MARK
                    }

                    else -> currentTokenType = ValkyrieTypes.AT
                }
            }
            // Unicode 操作符
            '↯' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.ATTRIBUTE_LOWER
            }

            '※' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LABEL_MARK
            }

            '⸿' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.INTERNATIONAL_MARK
            }

            '∧' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LOGIC_AND
            }

            '∨' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LOGIC_OR
            }

            '⩟' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LOGIC_XAND
            }

            '⊼' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LOGIC_NAND
            }

            '⊻' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LOGIC_XOR
            }

            '⊽' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.LOGIC_NOR
            }

            '⟨' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.GENERIC_L
            }

            '⟩' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.GENERIC_R
            }

            '×' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.MULTIPLY
            }

            '⅟' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.RECIPROCAL
            }

            '℃' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.CELSIUS
            }

            '℉' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.FAHRENHEIT
            }

            '‰' -> {
                currentOffset++; currentTokenType = ValkyrieTypes.PERMILLE
            }

            'ⱑ' -> { // 字符 'ⱑ' 对应 PERMYRIAD token
                currentOffset++; currentTokenType = ValkyrieTypes.PERMYRIAD
            }

            else -> {
                currentOffset++
                currentTokenType = BAD_CHARACTER
            }
        }
    }
}
