package valkyrie.cst

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

class ValkyrieLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var bufferEnd: Int = 0
    private var bufferStart: Int = 0
    private var tokenStart: Int = 0
    private var tokenEnd: Int = 0
    private var currentState: Int = 0
    private var currentToken: IElementType? = null

    // 词法分析状态
    companion object {
        const val INITIAL = 0
        const val IN_STRING = 1
        const val IN_SINGLE_QUOTE_STRING = 2
        const val IN_NUMBER = 3
        const val IN_COMMENT = 4
        const val IN_HASH_COMMENT = 5
        const val IN_BLOCK_COMMENT = 6
        const val IN_IDENTIFIER_RAW = 8
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.bufferStart = startOffset
        this.bufferEnd = endOffset
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.currentState = initialState
        this.currentToken = null
        advance()
    }

    override fun getState(): Int = currentState

    override fun getTokenType(): IElementType? = currentToken

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = bufferEnd

    override fun advance() {
        tokenStart = tokenEnd

        if (tokenStart >= bufferEnd) {
            currentToken = null
            return
        }

        when (currentState) {
            INITIAL -> scanInitial()
            IN_STRING -> scanString()
            IN_SINGLE_QUOTE_STRING -> scanSingleQuoteString()
            IN_NUMBER -> scanNumber()
            IN_COMMENT -> scanComment()
            IN_HASH_COMMENT -> scanHashComment()
            IN_BLOCK_COMMENT -> scanBlockComment()
            IN_IDENTIFIER_RAW -> scanRawIdentifier()
        }
    }

    private fun scanInitial() {
        val c = buffer[tokenStart]

        when {
            c.isWhitespace() -> scanWhitespace()
            c == '{' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.LBRACE
            }
            c == '}' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.RBRACE
            }
            c == '[' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.LBRACK
            }
            c == ']' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.RBRACK
            }
            c == ':' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.COLON
            }
            c == ',' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.COMMA
            }

            c == '@' -> {
                if (tokenStart + 1 < bufferEnd) {
                    when (buffer[tokenStart + 1]) {
                        '^' -> {
                            tokenEnd = tokenStart + 2
                            currentToken = ValkyrieCST.OP_MACRO_UPPER
                        }
                        '.' -> {
                            tokenEnd = tokenStart + 2
                            currentToken = ValkyrieCST.OP_MACRO_LOWER
                        }
                        else -> {
                            tokenEnd = tokenStart + 1
                            currentToken = ValkyrieCST.OP_MACRO
                        }
                    }
                } else {
                    tokenEnd = tokenStart + 1
                    currentToken = ValkyrieCST.OP_MACRO
                }
            }
            c == '◤' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.OP_MACRO_UPPER
            }
            c == '↯' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.OP_MACRO_LOWER
            }
            c == '.' -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.DOT
            }
            c == '"' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_STRING
            }
            c == '\'' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_SINGLE_QUOTE_STRING
            }
            c == '/' && tokenStart + 1 < bufferEnd && buffer[tokenStart + 1] == '/' -> {
                tokenEnd = tokenStart + 2
                currentState = IN_COMMENT
            }
            c == '#' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_HASH_COMMENT
            }
            c == '<' && tokenStart + 1 < bufferEnd && buffer[tokenStart + 1] == '#' -> {
                tokenEnd = tokenStart + 2
                currentState = IN_BLOCK_COMMENT
            }
            c.isDigit() || c == '-' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_NUMBER
            }
            c.isJavaIdentifierStart() -> scanIdentifier()
            c == '`' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_IDENTIFIER_RAW
            }
            else -> {
                tokenEnd = tokenStart + 1
                currentToken = ValkyrieCST.BAD_CHARACTER
            }
        }
    }

    private fun scanWhitespace() {
        var i = tokenStart
        while (i < bufferEnd && buffer[i].isWhitespace()) {
            i++
        }
        tokenEnd = i
        currentToken = ValkyrieCST.WHITE_SPACE
    }

    private fun scanString() {
        var i = tokenEnd
        var escaped = false

        while (i < bufferEnd) {
            val c = buffer[i]

            if (escaped) {
                escaped = false
            } else if (c == '\\') {
                escaped = true
            } else if (c == '"') {
                tokenEnd = i + 1
                currentToken = ValkyrieCST.STRING
                currentState = INITIAL
                return
            }

            i++
        }

        // 未闭合的字符串
        tokenEnd = bufferEnd
        currentToken = ValkyrieCST.BAD_CHARACTER
        currentState = INITIAL
    }

    private fun scanNumber() {
        var i = tokenEnd
        var dotSeen = false
        var eSeen = false

        while (i < bufferEnd) {
            val c = buffer[i]

            when {
                c.isDigit() -> i++
                c == '.' && !dotSeen && !eSeen -> {
                    dotSeen = true
                    i++
                }
                (c == 'e' || c == 'E') && !eSeen -> {
                    eSeen = true
                    if (i + 1 < bufferEnd && (buffer[i + 1] == '+' || buffer[i + 1] == '-')) {
                        i += 2
                    } else {
                        i++
                    }
                }
                else -> break
            }
        }

        tokenEnd = i
        currentToken = ValkyrieCST.NUMBER
        currentState = INITIAL
    }

    private fun scanComment() {
        var i = tokenEnd

        while (i < bufferEnd) {
            if (buffer[i] == '\n') {
                break
            }
            i++
        }

        tokenEnd = i
        currentToken = ValkyrieCST.COMMENT_LINE
        currentState = INITIAL
    }

    private fun scanHashComment() {
        var i = tokenEnd

        while (i < bufferEnd) {
            if (buffer[i] == '\n') {
                break;
            }
            i++
        }

        tokenEnd = i
        currentToken = ValkyrieCST.COMMENT_LINE
        currentState = INITIAL
    }

    private fun scanBlockComment() {
        var i = tokenEnd
        var nestLevel = 1

        while (i < bufferEnd && nestLevel > 0) {
            if (i + 1 < bufferEnd && buffer[i] == '<' && buffer[i + 1] == '#') {
                nestLevel++
                i += 2
            } else if (i + 1 < bufferEnd && buffer[i] == '#' && buffer[i + 1] == '>') {
                nestLevel--
                i += 2
            } else {
                i++
            }
        }

        tokenEnd = i
        currentToken = ValkyrieCST.COMMENT_BLOCK
        currentState = INITIAL
    }

    private fun scanSingleQuoteString() {
        var i = tokenEnd
        var escaped = false

        while (i < bufferEnd) {
            val c = buffer[i]

            if (escaped) {
                escaped = false
            } else if (c == '\\') {
                escaped = true
            } else if (c == '\'') {
                tokenEnd = i + 1
                currentToken = ValkyrieCST.STRING
                currentState = INITIAL
                return
            }

            i++
        }

        // 未闭合的字符串
        tokenEnd = bufferEnd
        currentToken = ValkyrieCST.BAD_CHARACTER
        currentState = INITIAL
    }

    private fun scanIdentifier() {
        var i = tokenEnd

        while (i < bufferEnd && buffer[i].isJavaIdentifierPart()) {
            i++
        }

        tokenEnd = i

        // 检查是否是软关键字
        val text = buffer.subSequence(tokenStart, tokenEnd).toString()
        currentToken = when (text) {
            "class", "structure", "struct" -> ValkyrieCST.KW_CLASS
            "trait",  "interface" -> ValkyrieCST.TRAIT
            "object" -> ValkyrieCST.OBJECT
            else -> ValkyrieCST.IDENTIFIER
        }
        currentState = INITIAL
    }

    private fun scanRawIdentifier() {
        var i = tokenEnd
        var escaped = false

        while (i < bufferEnd) {
            val c = buffer[i]

            if (escaped) {
                if (c == 'u' && i + 1 < bufferEnd && buffer[i + 1] == '{') {
                    // Unicode escape sequence
                    var j = i + 2
                    while (j < bufferEnd && buffer[j] != '}') {
                        if (!buffer[j].isLetterOrDigit()) {
                            break
                        }
                        j++
                    }
                    if (j < bufferEnd && buffer[j] == '}') {
                        i = j + 1
                    } else {
                        i++
                    }
                } else {
                    i++
                }
                escaped = false
            } else if (c == '\\') {
                escaped = true
                i++
            } else if (c == '`') {
                tokenEnd = i + 1
                currentToken = ValkyrieCST.IDENTIFIER_RAW
                currentState = INITIAL
                return
            } else {
                i++
            }
        }

        // 未闭合的原始标识符
        tokenEnd = bufferEnd
        currentToken = ValkyrieCST.BAD_CHARACTER
        currentState = INITIAL
    }
}