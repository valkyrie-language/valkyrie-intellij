package von.language.lexer

import von.language.psi.VonTypes
import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.lexer.LexerPositionImpl
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType

class VonLexer : Lexer() {
    private var buffer: CharSequence = ""
    private var tokenStart = 0
    private var currentOffset = 0
    private var endOffset = 0
    private var currentTokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.tokenStart = startOffset
        this.currentOffset = startOffset
        this.endOffset = endOffset
        advance()
    }

    override fun getState(): Int = 0

    override fun getTokenType(): IElementType? = currentTokenType

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = currentOffset

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = endOffset

    override fun advance() {
        tokenStart = currentOffset
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        currentTokenType = nextToken()
    }

    override fun getCurrentPosition(): LexerPosition =
        LexerPositionImpl(tokenStart, state)

    override fun restore(position: LexerPosition) {
        start(buffer, position.offset, endOffset, position.state)
    }

    private fun nextToken(): IElementType {
        val ch = buffer[currentOffset]

        if (ch.isWhitespace()) {
            while (currentOffset < endOffset && buffer[currentOffset].isWhitespace()) {
                currentOffset++
            }
            return WHITE_SPACE
        }

        if (ch == '/' && peek(1) == '/') {
            skipLineComment()
            return VonTypes.COMMENT
        }
        if (ch == '#' && peek(1) != '/') {
            skipLineComment()
            return VonTypes.COMMENT
        }
        if (ch == '/' && peek(1) == '*') {
            skipBlockComment()
            return VonTypes.BLOCK_COMMENT
        }

        if (ch == '@') {
            return readAtDirective()
        }

        if (ch == '-' && isBackTop()) {
            while (currentOffset < endOffset && buffer[currentOffset] == '-') {
                currentOffset++
            }
            return VonTypes.BACK_TOP
        }

        if (ch == '"') {
            return readString()
        }

        if (ch == '+' || ch == '-') {
            if (isNumberStart(peek(1))) {
                return readNumber(withSign = true)
            }
            currentOffset++
            return VonTypes.SIGN
        }

        if (ch.isDigit() || (ch == '.' && peek(1).isDigit())) {
            return readNumber(withSign = false)
        }

        if (isSymbolStart(ch)) {
            return readSymbol()
        }

        return readSingleCharToken(ch)
    }

    private fun readAtDirective(): IElementType {
        return when {
            matchLiteral("@include") -> VonTypes.INCLUDE
            matchLiteral("@inherit") -> VonTypes.INHERIT
            matchLiteral("@import") -> VonTypes.IMPORT
            matchLiteral("@export") -> VonTypes.EXPORT
            else -> {
                currentOffset++
                VonTypes.AT
            }
        }
    }

    private fun matchLiteral(literal: String): Boolean {
        if (currentOffset + literal.length > endOffset) {
            return false
        }
        if (buffer.substring(currentOffset, currentOffset + literal.length) != literal) {
            return false
        }
        currentOffset += literal.length
        return true
    }

    private fun readSymbol(): IElementType {
        val start = currentOffset
        while (currentOffset < endOffset && isSymbolPart(buffer[currentOffset])) {
            currentOffset++
        }
        val text = buffer.substring(start, currentOffset)
        return when (text) {
            "as" -> VonTypes.AS
            "null" -> VonTypes.NULL
            "true", "false" -> VonTypes.BOOLEAN
            "nan" -> VonTypes.NAN
            else -> VonTypes.SYMBOL
        }
    }

    private fun readString(): IElementType {
        currentOffset++
        while (currentOffset < endOffset) {
            when (buffer[currentOffset]) {
                '\\' -> currentOffset += 2
                '"' -> {
                    currentOffset++
                    return VonTypes.STRING
                }
                else -> currentOffset++
            }
        }
        return VonTypes.STRING
    }

    private fun readNumber(withSign: Boolean): IElementType {
        var start = currentOffset
        if (withSign) {
            currentOffset++
            start = currentOffset
        }

        if (currentOffset < endOffset && buffer[currentOffset] == '0') {
            val next = peek(1)
            if (next == 'b' || next == 'B' || next == 'o' || next == 'O' ||
                next == 'x' || next == 'X' || next == 'f' || next == 'F'
            ) {
                currentOffset += 2
                while (currentOffset < endOffset && isBytePart(buffer[currentOffset])) {
                    currentOffset++
                }
                return VonTypes.BYTE
            }
        }

        var sawDot = false
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            when {
                ch == '_' -> currentOffset++
                ch == '.' -> {
                    if (sawDot) break
                    sawDot = true
                    currentOffset++
                }
                ch == 'e' || ch == 'E' -> {
                    currentOffset++
                    if (currentOffset < endOffset && (buffer[currentOffset] == '+' || buffer[currentOffset] == '-')) {
                        currentOffset++
                    }
                    while (currentOffset < endOffset && buffer[currentOffset].isDigit()) {
                        currentOffset++
                    }
                    break
                }
                ch.isDigit() -> currentOffset++
                else -> break
            }
        }

        val raw = buffer.substring(start, currentOffset)
        return if (sawDot || raw.contains('e', ignoreCase = true)) {
            VonTypes.DECIMAL
        } else {
            VonTypes.INTEGER
        }
    }

    private fun readSingleCharToken(ch: Char): IElementType {
        currentOffset++
        return when (ch) {
            '(' -> VonTypes.PARENTHESIS_L
            ')' -> VonTypes.PARENTHESIS_R
            '[' -> VonTypes.BRACKET_L
            ']' -> VonTypes.BRACKET_R
            '{' -> VonTypes.BRACE_L
            '}' -> VonTypes.BRACE_R
            '^' -> VonTypes.ACCENT
            '<' -> VonTypes.ANGLE_L
            '>' -> VonTypes.ANGLE_R
            '"' -> VonTypes.QUOTATION
            '\\' -> VonTypes.ESCAPE
            '=' -> VonTypes.EQ
            ':' -> VonTypes.COLON
            ';' -> VonTypes.SEMICOLON
            ',' -> VonTypes.COMMA
            '$' -> VonTypes.CITE
            '.' -> VonTypes.DOT
            '*' -> VonTypes.STAR
            '@' -> VonTypes.AT
            else -> BAD_CHARACTER
        }
    }

    private fun skipLineComment() {
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            currentOffset++
            if (ch == '\n' || ch == '\r') break
        }
    }

    private fun skipBlockComment() {
        currentOffset += 2
        while (currentOffset < endOffset) {
            if (buffer[currentOffset] == '*' && peek(1) == '/') {
                currentOffset += 2
                return
            }
            currentOffset++
        }
    }

    private fun isBackTop(): Boolean {
        var i = currentOffset
        var count = 0
        while (i < endOffset && buffer[i] == '-') {
            count++
            i++
        }
        return count >= 3
    }

    private fun isNumberStart(ch: Char): Boolean =
        ch.isDigit() || ch == '.'

    private fun isSymbolStart(ch: Char): Boolean =
        ch.isUnicodeIdentifierStart() || ch == '_'

    private fun isSymbolPart(ch: Char): Boolean =
        ch.isUnicodeIdentifierPart() || ch == '_'

    private fun isBytePart(ch: Char): Boolean =
        ch.isDigit() || ch in 'A'..'F' || ch in 'a'..'f' || ch == '_'

    private fun peek(offset: Int): Char {
        val index = currentOffset + offset
        return if (index < endOffset) buffer[index] else '\u0000'
    }

    private fun Char.isUnicodeIdentifierStart(): Boolean =
        Character.isUnicodeIdentifierStart(this)

    private fun Char.isUnicodeIdentifierPart(): Boolean =
        Character.isUnicodeIdentifierPart(this)
}
