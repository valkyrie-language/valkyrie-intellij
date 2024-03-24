package valkyrie.psi

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType

/**
 * Valkyrie 手写词法分析器
 */
class ValkyrieLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset = 0
    private var endOffset = 0
    private var currentOffset = 0
    private var currentState = 0
    private var tokenType: IElementType? = null

    // 关键字映射
    private val keywords = mapOf(
        "let" to ValkyrieTokenTypes.LET,
        "if" to ValkyrieTokenTypes.IF,
        "else" to ValkyrieTokenTypes.ELSE,
        "while" to ValkyrieTokenTypes.WHILE,
        "loop" to ValkyrieTokenTypes.LOOP,
        "for" to ValkyrieTokenTypes.LOOP,
        // fn
        "micro" to ValkyrieTokenTypes.MICRO,
        "function" to ValkyrieTokenTypes.MICRO,
        "func" to ValkyrieTokenTypes.MICRO,
        "fun" to ValkyrieTokenTypes.MICRO,
        "fn" to ValkyrieTokenTypes.MICRO,
        // type
        "mezzo" to ValkyrieTokenTypes.MEZZO,
        "type" to ValkyrieTokenTypes.MEZZO,
        // macro
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
        this.currentState = initialState
        this.tokenType = null
        advance()
    }

    override fun getState(): Int = currentState

    override fun getTokenType(): IElementType? = tokenType

    override fun getTokenStart(): Int = startOffset

    override fun getTokenEnd(): Int = currentOffset

    override fun advance() {
        if (currentOffset >= endOffset) {
            tokenType = null
            return
        }

        startOffset = currentOffset
        val ch = buffer[currentOffset]

        when {
            ch.isWhitespace() -> {
                while (currentOffset < endOffset && buffer[currentOffset].isWhitespace()) {
                    currentOffset++
                }
                tokenType = WHITE_SPACE
            }

            ch == '⍝' -> {
                skipLineComment()
                tokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' && peek() == '?' -> {
                skipDocComment()
                tokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' -> {
                skipLineComment()
                tokenType = ValkyrieTokenTypes.COMMENT_LINE
            }

            ch == '<' && peek() == '#' -> {
                skipBlockComment()
                tokenType = ValkyrieTokenTypes.COMMENT_RANGE
            }

            ch.isLetter() || ch == '_' -> {
                readIdentifier()
            }

            ch.isDigit() -> {
                readNumber()
            }

            ch == '"' -> {
                // 检查是否是三引号字符串：需要连续三个引号
                if (currentOffset + 2 < endOffset && buffer[currentOffset + 1] == '"' && buffer[currentOffset + 2] == '"') {
                    readMultiQuoteString()
                    tokenType = ValkyrieTokenTypes.STRING_MQ
                } else {
                    readString()
                    tokenType = ValkyrieTokenTypes.STRING_DQ
                }
            }

            ch == '\'' -> {
                readCharLiteral()
                tokenType = ValkyrieTokenTypes.STRING_DQ
            }

            ch == '`' -> {
                readRawIdentifier()
            }

            else -> {
                readOperatorOrPunctuation(ch)
            }
        }
    }

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = endOffset

    private fun peek(offset: Int = 1): Char? {
        val pos = currentOffset + offset
        return if (pos < endOffset) buffer[pos] else null
    }

    private fun skipLineComment() {
        currentOffset++ // skip #
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun skipBlockComment() {
        currentOffset += 2 // skip <#
        var depth = 1

        while (currentOffset < endOffset - 1 && depth > 0) {
            if (buffer[currentOffset] == '<' && buffer[currentOffset + 1] == '#') {
                // 嵌套块注释开始
                depth++
                currentOffset += 2
            } else if (buffer[currentOffset] == '#' && buffer[currentOffset + 1] == '>') {
                // 块注释结束
                depth--
                currentOffset += 2
            } else {
                currentOffset++
            }
        }
    }

    private fun skipDocComment() {
        currentOffset += 2 // skip #?
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun readIdentifier() {
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                currentOffset++
            } else {
                break
            }
        }

        val text = buffer.subSequence(startOffset, currentOffset).toString()

        // 直接查找关键字，不处理复合关键字（如"not in"、"is not"）
        // 复合关键字应在parser阶段处理，以避免格式化问题
        tokenType = keywords[text] ?: ValkyrieTokenTypes.IDENTIFIER_STD
    }

    private fun readNumber() {
        var hasDecimalPoint = false

        // Check for binary (0b) or hexadecimal (0x) prefixes
        if (buffer[currentOffset] == '0' && currentOffset + 1 < endOffset) {
            val nextChar = buffer[currentOffset + 1]
            when (nextChar) {
                'b', 'B' -> {
                    // Binary number
                    currentOffset += 2 // skip "0b"
                    while (currentOffset < endOffset) {
                        val ch = buffer[currentOffset]
                        if (ch == '0' || ch == '1') {
                            currentOffset++
                        } else {
                            break
                        }
                    }
                    tokenType = ValkyrieTokenTypes.INTEGER
                    return
                }

                'x', 'X' -> {
                    // Hexadecimal number
                    currentOffset += 2 // skip "0x"
                    while (currentOffset < endOffset) {
                        val ch = buffer[currentOffset]
                        if (ch.isDigit() || ch in 'a'..'f' || ch in 'A'..'F') {
                            currentOffset++
                        } else {
                            break
                        }
                    }
                    tokenType = ValkyrieTokenTypes.INTEGER
                    return
                }
            }
        }

        // Regular decimal number parsing
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            when {
                ch.isDigit() -> currentOffset++
                ch == '.' && !hasDecimalPoint && peek()?.isDigit() == true -> {
                    hasDecimalPoint = true
                    currentOffset++
                }

                else -> break
            }
        }

        // 检查数字后是否有单位宏
        val numberTokenType = if (hasDecimalPoint) ValkyrieTokenTypes.DECIMAL else ValkyrieTokenTypes.INTEGER

        // 检查是否有单位后缀（标识符）
        if (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch == '`') {
                // Raw identifier as unit
                readRawIdentifier()
                tokenType = ValkyrieTokenTypes.UNIT_NUMBER
            } else if (ch.isLetter() || ch == '_') {
                // Standard identifier as unit
                while (currentOffset < endOffset) {
                    val unitCh = buffer[currentOffset]
                    if (unitCh.isLetterOrDigit() || unitCh == '_') {
                        currentOffset++
                    } else {
                        break
                    }
                }
                tokenType = ValkyrieTokenTypes.UNIT_NUMBER
            } else {
                tokenType = numberTokenType
            }
        } else {
            tokenType = numberTokenType
        }
    }

    private fun readString() {
        currentOffset++ // skip opening quote
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch == '"') {
                currentOffset++ // skip closing quote
                break
            } else if (ch == '\\') {
                currentOffset += 2 // skip escape sequence
            } else {
                currentOffset++
            }
        }
    }

    private fun readMultiQuoteString() {
        currentOffset += 3 // skip opening triple quotes
        while (currentOffset + 2 < endOffset) {
            if (buffer[currentOffset] == '"' && buffer[currentOffset + 1] == '"' && buffer[currentOffset + 2] == '"') {
                currentOffset += 3 // skip closing triple quotes
                break
            } else {
                currentOffset++
            }
        }
    }

    private fun readCharLiteral() {
        currentOffset++ // skip opening quote
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch == '\'') {
                currentOffset++ // skip closing quote
                break
            } else if (ch == '\\') {
                currentOffset += 2 // skip escape sequence
            } else {
                currentOffset++
            }
        }
    }

    private fun readRawIdentifier() {
        currentOffset++ // skip opening backtick
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch == '`') {
                currentOffset++ // skip closing backtick
                break
            } else {
                currentOffset++
            }
        }
        tokenType = ValkyrieTokenTypes.IDENTIFIER_RAW
    }

    private fun readOperatorOrPunctuation(ch: Char) {
        when (ch) {
            '=' -> {
                currentOffset++
                when (peek(0)) {
                    '=' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.EQUAL
                    }

                    '>' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.DOUBLE_ARROW
                    }

                    else -> {
                        tokenType = ValkyrieTokenTypes.ASSIGN
                    }
                }
            }

            '!' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.NOT_EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.WOW
                }
            }

            '<' -> {
                currentOffset++
                when (peek(0)) {
                    '=' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.LESS_EQUAL
                    }

                    '{' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START
                    }

                    '$' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.TEMPLATE_START
                    }

                    else -> {
                        tokenType = ValkyrieTokenTypes.ANGLE_L
                    }
                }
            }

            '>' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.GREATER_EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.ANGLE_R
                }
            }

            '}' -> {
                currentOffset++
                if (peek(0) == '>') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END
                } else {
                    tokenType = ValkyrieTokenTypes.BRACE_R
                }
            }

            '$' -> {
                currentOffset++
                if (peek(0) == '>') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.TEMPLATE_END
                } else {
                    // $ 作为普通字符处理
                    tokenType = BAD_CHARACTER
                }
            }

            '&' -> {
                currentOffset++
                if (peek(0) == '&') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.LOGIC_AND
                } else {
                    tokenType = ValkyrieTokenTypes.AMPERSAND
                }
            }

            '|' -> {
                currentOffset++
                if (peek(0) == '|') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.LOGIC_OR
                } else {
                    tokenType = ValkyrieTokenTypes.PIPE
                }
            }

            '-' -> {
                currentOffset++
                when (peek(0)) {
                    '>' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.ARROW
                    }

                    '=' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.MINUS_ASSIGN
                    }

                    else -> {
                        tokenType = ValkyrieTokenTypes.MINUS
                    }
                }
            }

            '+' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.PLUS_ASSIGN
                } else {
                    tokenType = ValkyrieTokenTypes.PLUS
                }
            }

            '*' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.MULTIPLY_ASSIGN
                } else {
                    tokenType = ValkyrieTokenTypes.STAR
                }
            }

            '/' -> {
                currentOffset++
                when (peek(0)) {
                    '/' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.INTEGER_DIVIDE
                    }

                    '=' -> {
                        currentOffset++
                        tokenType = ValkyrieTokenTypes.DIVIDE_ASSIGN
                    }

                    else -> {
                        tokenType = ValkyrieTokenTypes.SLASH
                    }
                }
            }

            '^' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.POWER_ASSIGN
                } else {
                    tokenType = ValkyrieTokenTypes.POWER
                }
            }

            '%' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.MODULO_ASSIGN
                } else {
                    tokenType = ValkyrieTokenTypes.PERCENT
                }
            }

            ';' -> {
                currentOffset++
                if (currentOffset < bufferEnd && buffer[currentOffset] == ';') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.DOUBLE_SEMICOLON
                } else {
                    tokenType = ValkyrieTokenTypes.SEMICOLON
                }
            }

            ',' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.COMMA
            }

            '.' -> {
                currentOffset++
                if (peek(0) == '.') {
                    currentOffset++
                    when (peek(0)) {
                        // ...
                        '.' -> {
                            currentOffset++
                            tokenType = ValkyrieTokenTypes.ELLIPSIS
                        }
                        // ..=
                        '=' -> {
                            currentOffset++
                            tokenType = ValkyrieTokenTypes.DOT_DOT_EQUAL
                        }
                        // ..<
                        '<' -> {
                            currentOffset++
                            tokenType = ValkyrieTokenTypes.DOT_DOT_LESS
                        }
                        // ..
                        else -> {
                            tokenType = ValkyrieTokenTypes.DOT_DOT
                        }
                    }
                }
                // .
                else {
                    tokenType = ValkyrieTokenTypes.DOT
                }
            }

            ':' -> {
                // ::
                if (currentOffset + 1 < buffer.length && buffer[currentOffset + 1] == ':') {
                    currentOffset += 2
                    tokenType = ValkyrieTokenTypes.DOUBLE_COLON
                }
                // :
                else {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.COLON
                }
            }

            '⸬' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.DOUBLE_COLON
            }

            '(' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.PARENTHESES_L
            }

            ')' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.PARENTHESES_R
            }

            '{' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.BRACE_L
            }

            '[' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.ARRAY_L
            }

            ']' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.ARRAY_R
            }

            '⟨' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.GENERIC_L
            }

            '⟩' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.GENERIC_R
            }

            '@' -> {
                currentOffset++
                // ↯
                if (peek(0) == '.') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.ATTRIBUTE_LOWER
                }
                // ※
                else if (peek(0) == '*') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.LABEL_MARK
                }
                // ⸿
                else if (peek(0) == '$') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.INTERNATIONAL_MARK
                }
                // @
                else {
                    tokenType = ValkyrieTokenTypes.AT
                }
            }

            '↯' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.ATTRIBUTE_LOWER
            }

            '※' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LABEL_MARK
            }

            '⸿' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.INTERNATIONAL_MARK
            }


            '∧' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LOGIC_AND
            }

            '∨' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LOGIC_OR
            }

            '⩟' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LOGIC_XAND
            }

            '⊼' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LOGIC_NAND
            }

            '⊻' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LOGIC_XOR
            }

            '⊽' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LOGIC_NOR
            }

            '×' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.MULTIPLY_ASSIGN
                } else {
                    tokenType = ValkyrieTokenTypes.MULTIPLY
                }
            }


            '?' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.WHAT
            }

            '_' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.UNDERSCORE
            }


            '⅟' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.RECIPROCAL
            }

            '℃' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.CELSIUS
            }

            '℉' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.FAHRENHEIT
            }

            '‰' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.PERMILLE
            }

            '‱' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.PERMYRIAD
            }

            else -> {
                currentOffset++
                tokenType = BAD_CHARACTER
            }
        }
    }
}