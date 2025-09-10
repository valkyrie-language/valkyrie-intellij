package valkyrie.psi

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieTokenTypes.*

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
        "let" to LET,
        "mut" to MUT,
        "ref" to REF,
        "if" to IF,
        "else" to ELSE,
        "while" to WHILE,
        "for" to FOR,
        "function" to FUNCTION,
        "class" to CLASS,
        "trait" to TRAIT,
        "return" to RETURN,
        "break" to BREAK,
        "continue" to CONTINUE,
        "true" to BOOLEAN,
        "false" to BOOLEAN
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
                    tokenType = NEWLINE
                } else {
                    skipWhitespace()
                    tokenType = WHITESPACE
                }
            }
            ch == '/' && peek() == '/' -> {
                skipLineComment()
                tokenType = LINE_COMMENT
            }
            ch == '/' && peek() == '*' -> {
                skipBlockComment()
                tokenType = BLOCK_COMMENT
            }
            ch.isLetter() || ch == '_' -> {
                readIdentifier()
            }
            ch.isDigit() -> {
                readNumber()
            }
            ch == '"' -> {
                readString()
                tokenType = STRING
            }
            ch == '\'' -> {
                readCharLiteral()
                tokenType = STRING
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
        currentOffset += 2 // skip //
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }
    
    private fun skipBlockComment() {
        currentOffset += 2 // skip /*
        while (currentOffset < endOffset - 1) {
            if (buffer[currentOffset] == '*' && buffer[currentOffset + 1] == '/') {
                currentOffset += 2
                break
            }
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
        tokenType = keywords[text] ?: IDENTIFIER
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
        
        tokenType = if (hasDecimalPoint) FLOAT else INTEGER
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
                    tokenType = EQUAL
                } else {
                    tokenType = ASSIGN
                }
            }
            '!' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = NOT_EQUAL
                } else {
                    tokenType = NOT
                }
            }
            '<' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = LESS_EQUAL
                } else {
                    tokenType = LESS
                }
            }
            '>' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = GREATER_EQUAL
                } else {
                    tokenType = GREATER
                }
            }
            '&' -> {
                currentOffset++
                if (peek(0) == '&') {
                    currentOffset++
                    tokenType = AND
                } else {
                    tokenType = BAD_CHARACTER
                }
            }
            '|' -> {
                currentOffset++
                if (peek(0) == '|') {
                    currentOffset++
                    tokenType = OR
                } else {
                    tokenType = BAD_CHARACTER
                }
            }
            '-' -> {
                currentOffset++
                if (peek(0) == '>') {
                    currentOffset++
                    tokenType = ARROW
                } else {
                    tokenType = MINUS
                }
            }
            '+' -> { currentOffset++; tokenType = PLUS }
            '*' -> { currentOffset++; tokenType = MULTIPLY }
            '/' -> { currentOffset++; tokenType = DIVIDE }
            '%' -> { currentOffset++; tokenType = MODULO }
            ';' -> { currentOffset++; tokenType = SEMICOLON }
            ',' -> { currentOffset++; tokenType = COMMA }
            '.' -> { currentOffset++; tokenType = DOT }
            ':' -> { currentOffset++; tokenType = COLON }
            '(' -> { currentOffset++; tokenType = LPAREN }
            ')' -> { currentOffset++; tokenType = RPAREN }
            '{' -> { currentOffset++; tokenType = LBRACE }
            '}' -> { currentOffset++; tokenType = RBRACE }
            '[' -> { currentOffset++; tokenType = LBRACKET }
            ']' -> { currentOffset++; tokenType = RBRACKET }
            else -> {
                currentOffset++
                tokenType = BAD_CHARACTER
            }
        }
    }
}