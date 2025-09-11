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
        "function" to ValkyrieTokenTypes.FUNCTION,
        "class" to ValkyrieTokenTypes.CLASS,
        "struct" to ValkyrieTokenTypes.CLASS,
        "union" to ValkyrieTokenTypes.UNION,
        "trait" to ValkyrieTokenTypes.TRAIT,
        "return" to ValkyrieTokenTypes.RETURN,
        "break" to ValkyrieTokenTypes.BREAK,
        "continue" to ValkyrieTokenTypes.CONTINUE,
        "namespace" to ValkyrieTokenTypes.NAMESPACE,
        "using" to ValkyrieTokenTypes.USING,
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

            ch == '#' && peek() == '?' -> {
                skipDocComment()
                tokenType = ValkyrieTokenTypes.DOC_COMMENT
            }

            ch == '#' -> {
                skipLineComment()
                tokenType = ValkyrieTokenTypes.LINE_COMMENT
            }

            ch == '<' && peek() == '#' -> {
                skipBlockComment()
                tokenType = ValkyrieTokenTypes.BLOCK_COMMENT
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
        tokenType = keywords[text] ?: ValkyrieTokenTypes.IDENTIFIER
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
                    tokenType = ValkyrieTokenTypes.NOT
                }
            }

            '<' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.LESS_EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.LESS
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

            '&' -> {
                currentOffset++
                if (peek(0) == '&') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.AND
                } else {
                    tokenType = ValkyrieTokenTypes.BAD_CHARACTER
                }
            }

            '|' -> {
                currentOffset++
                if (peek(0) == '|') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.OR
                } else {
                    tokenType = ValkyrieTokenTypes.BAD_CHARACTER
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
                currentOffset++; tokenType = ValkyrieTokenTypes.MULTIPLY
            }

            '/' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.DIVIDE
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

            '}' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.RBRACE
            }

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

            else -> {
                currentOffset++
                tokenType = ValkyrieTokenTypes.BAD_CHARACTER
            }
        }
    }
}