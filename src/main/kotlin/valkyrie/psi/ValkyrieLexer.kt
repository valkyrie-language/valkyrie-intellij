package valkyrie.psi

import com.intellij.lexer.LexerBase
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
        "mut" to ValkyrieTokenTypes.MUT,
        "ref" to ValkyrieTokenTypes.REF,
        "if" to ValkyrieTokenTypes.IF,
        "else" to ValkyrieTokenTypes.ELSE,
        "while" to ValkyrieTokenTypes.WHILE,
        "for" to ValkyrieTokenTypes.FOR,
        "loop" to ValkyrieTokenTypes.LOOP,
        "function" to ValkyrieTokenTypes.FUNCTION,
        "micro" to ValkyrieTokenTypes.MICRO,
        "mezzo" to ValkyrieTokenTypes.MEZZO,
        "macro" to ValkyrieTokenTypes.MACRO,
        "class" to ValkyrieTokenTypes.CLASS,
        "struct" to ValkyrieTokenTypes.CLASS,
        "union" to ValkyrieTokenTypes.UNION,
        "trait" to ValkyrieTokenTypes.TRAIT,
        "return" to ValkyrieTokenTypes.RETURN,
        "break" to ValkyrieTokenTypes.BREAK,
        "continue" to ValkyrieTokenTypes.CONTINUE,
        "yield" to ValkyrieTokenTypes.YIELD,
        "raise" to ValkyrieTokenTypes.RAISE,
        "tests" to ValkyrieTokenTypes.TESTS,
        "test" to ValkyrieTokenTypes.TEST,
        "namespace" to ValkyrieTokenTypes.NAMESPACE,
        "namespace!" to ValkyrieTokenTypes.NAMESPACE_MAIN,
        "namespace?" to ValkyrieTokenTypes.NAMESPACE_TEST,
        "namespace*" to ValkyrieTokenTypes.NAMESPACE_HIDE,
        "using" to ValkyrieTokenTypes.USING,
        "until" to ValkyrieTokenTypes.UNTIL,
        "match" to ValkyrieTokenTypes.MATCH,
        "case" to ValkyrieTokenTypes.CASE,
        "catch" to ValkyrieTokenTypes.CATCH,
        "try" to ValkyrieTokenTypes.TRY,
        "when" to ValkyrieTokenTypes.WHEN,
        "in" to ValkyrieTokenTypes.IN,
        "is" to ValkyrieTokenTypes.IS,
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
                if (ch == '\n') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.NEWLINE
                } else {
                    skipWhitespace()
                    tokenType = ValkyrieTokenTypes.WHITESPACE
                }
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
                tokenType = ValkyrieTokenTypes.COMMENT_REST
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
                readString()
                tokenType = ValkyrieTokenTypes.STRING
            }

            ch == '\'' -> {
                readCharLiteral()
                tokenType = ValkyrieTokenTypes.STRING
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

    private fun skipWhitespace() {
        while (currentOffset < endOffset && buffer[currentOffset].isWhitespace() && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun skipLineComment() {
        currentOffset++ // skip #
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun skipBlockComment() {
        currentOffset += 2 // skip <#
        while (currentOffset < endOffset - 1) {
            if (buffer[currentOffset] == '#' && buffer[currentOffset + 1] == '>') {
                currentOffset += 2
                break
            }
            currentOffset++
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
        
        // 检查复合关键字
        when (text) {
            "not" -> {
                // 检查是否是 "not in"
                val savedOffset = currentOffset
                skipWhitespace()
                if (currentOffset + 2 <= endOffset && 
                    buffer.subSequence(currentOffset, currentOffset + 2).toString() == "in") {
                    currentOffset += 2
                    tokenType = ValkyrieTokenTypes.NOT_IN
                    return
                } else {
                    currentOffset = savedOffset
                }
            }
            "is" -> {
                // 检查是否是 "is not"
                val savedOffset = currentOffset
                skipWhitespace()
                if (currentOffset + 3 <= endOffset && 
                    buffer.subSequence(currentOffset, currentOffset + 3).toString() == "not") {
                    currentOffset += 3
                    tokenType = ValkyrieTokenTypes.IS_NOT
                    return
                } else {
                    currentOffset = savedOffset
                }
            }
        }
        
        tokenType = keywords[text] ?: ValkyrieTokenTypes.IDENTIFIER_STD
    }

    private fun readNumber() {
        var hasDecimalPoint = false

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

        tokenType = if (hasDecimalPoint) ValkyrieTokenTypes.DECIMAL else ValkyrieTokenTypes.INTEGER
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
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.ASSIGN
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
                        tokenType = ValkyrieTokenTypes.LESS
                    }
                }
            }

            '>' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.GREATER_EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.GREATER
                }
            }

            '}' -> {
                currentOffset++
                if (peek(0) == '>') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END
                } else {
                    tokenType = ValkyrieTokenTypes.RBRACE
                }
            }

            '$' -> {
                currentOffset++
                if (peek(0) == '>') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.TEMPLATE_END
                } else {
                    // $ 作为普通字符处理
                    tokenType = ValkyrieTokenTypes.BAD_CHARACTER
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
                if (peek(0) == '>') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.ARROW
                } else {
                    tokenType = ValkyrieTokenTypes.MINUS
                }
            }

            '+' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.PLUS
            }

            '*' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.STAR
            }

            '/' -> {
                currentOffset++
                if (peek(0) == '/') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.INTEGER_DIVIDE
                } else {
                    tokenType = ValkyrieTokenTypes.DIVIDE
                }
            }

            '^' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.POWER
            }

            '%' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.MODULO
            }

            ';' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.SEMICOLON
            }

            ',' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.COMMA
            }

            '.' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.DOT
            }

            ':' -> {
                if (currentOffset + 1 < buffer.length && buffer[currentOffset + 1] == ':') {
                    currentOffset += 2
                    tokenType = ValkyrieTokenTypes.DOUBLE_COLON
                } else {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.COLON
                }
            }

            '(' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LPAREN
            }

            ')' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.RPAREN
            }

            '{' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LBRACE
            }

            // '}' case is handled above for '}>' template syntax

            '[' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LBRACKET
            }

            ']' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.RBRACKET
            }

            '⟨' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LANGLE
            }

            '⟩' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.RANGLE
            }

            '@' -> {
                currentOffset++
                if (peek(0) == '.') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.ATTRIBUTE_LOWER
                } else {
                    tokenType = ValkyrieTokenTypes.AT
                }
            }

            '↯' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.ATTRIBUTE_LOWER
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
                currentOffset++; tokenType = ValkyrieTokenTypes.MULTIPLY
            }

            '※' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.LABEL
            }

            '?' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.WHAT
            }

            else -> {
                currentOffset++
                tokenType = ValkyrieTokenTypes.BAD_CHARACTER
            }
        }
    }
}