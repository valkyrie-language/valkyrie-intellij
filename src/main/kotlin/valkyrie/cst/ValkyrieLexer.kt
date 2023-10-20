package valkyrie.cst

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType

class ValkyrieLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var bufferEnd: Int = 0
    private var bufferStart: Int = 0
    private var tokenStart: Int = 0
    private var tokenEnd: Int = 0
    private var currentState: Int = 0
    private var _tokenBuffer: IElementType? = null

    // 词法分析状态
    companion object {
        const val INITIAL = 0
        const val IN_STRING_DQ = 11
        const val IN_SINGLE_SQ = 12
        const val IN_STRING_RI = 13
        const val IN_NUMBER = 3
        const val IN_COMMENT_LINE = 5
        const val IN_COMMENT_BLOCK = 6
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.bufferStart = startOffset
        this.bufferEnd = endOffset
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.currentState = initialState
        advance()
    }

    override fun getState() = currentState

    override fun getTokenType() = _tokenBuffer

    override fun getTokenStart() = tokenStart

    override fun getTokenEnd() = tokenEnd

    override fun getBufferSequence() = buffer

    override fun getBufferEnd() = bufferEnd

    override fun advance() {
        tokenStart = tokenEnd
        // 非法状态
        if (tokenStart >= bufferEnd) {
            _tokenBuffer = null
            return
        }
        when (currentState) {
            INITIAL -> scanInitial()
            IN_STRING_DQ -> scanString()
            IN_SINGLE_SQ -> scanSingleQuoteString()
            IN_NUMBER -> scanNumber()
            IN_COMMENT_LINE -> scanCommentLine()
            IN_COMMENT_BLOCK -> scanBlockComment()
            IN_STRING_RI -> scanRawIdentifier()
        }
    }

    private fun scanInitial() {
        val c = buffer[tokenStart]

        when {
            c.isWhitespace() -> scanWhitespace()
            c == '{' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = BRACE_L
            }

            c == '}' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = RBRACE
            }

            c == '[' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = BRACKET_L
            }

            c == ']' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = BRACKET_R
            }

            c == '(' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = PARENTHESIS_L
            }

            c == ')' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = PARENTHESIS_R
            }

            c == ':' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = COLON
            }

            c == ',' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = COMMA
            }

            c == '@' -> when {
                // @.
                buffer.getOrNull(tokenStart + 1) == '.' -> {
                    tokenEnd = tokenStart + 2
                    _tokenBuffer = OP_MACRO_LOWER
                }

                // @^
                buffer.getOrNull(tokenStart + 1) == '^' -> {
                    tokenEnd = tokenStart + 2
                    _tokenBuffer = OP_MACRO_UPPER
                }

                // @
                else -> {
                    tokenEnd = tokenStart + 1
                    _tokenBuffer = OP_MACRO
                }
            }

            c == '.' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = DOT
            }

            c == '\'' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_SINGLE_SQ
            }

            c == '"' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_STRING_DQ
            }

            c == '`' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_STRING_RI
            }


            c == '#' || c == '⍝' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_COMMENT_LINE
                _tokenBuffer = COMMENT_LINE_HEAD
            }

            c == '⩽' || c == '≤' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_LEQ
            }

            c == '<' -> {
                // <#
                if (buffer.getOrNull(tokenStart + 1) == '#') {
                    tokenEnd = tokenStart + 2
                    currentState = IN_COMMENT_BLOCK
                    _tokenBuffer = COMMENT_LINE_HEAD
                }
                // <=
                else if (buffer.getOrNull(tokenStart + 1) == '=') {
                    tokenEnd = tokenStart + 2
                    _tokenBuffer = OP_LEQ
                }
                // <
                else {
                    tokenEnd = tokenStart + 1
                    _tokenBuffer = OP_LE
                }
            }

            c == '⩾' || c == '≥' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_GEQ
            }

            c == '>' -> {
                // >=
                if (buffer.getOrNull(tokenStart + 1) == '=') {
                    tokenEnd = tokenStart + 2
                    _tokenBuffer = OP_GEQ
                }
                // >
                else {
                    tokenEnd = tokenStart + 1
                    _tokenBuffer = OP_GE
                }
            }

            c == '◤' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_MACRO_UPPER
            }

            c == '↯' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_MACRO_LOWER
            }

            c == '+' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_PLUS
            }

            c == '-' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_MINUS
            }

            c == '*' || c == '×' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_TIMES
            }

            c == '/' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_DIVIDE
            }

            c == '^' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = OP_POWER
            }

            c.isDigit() -> {
                tokenEnd = tokenStart + 1
                currentState = IN_NUMBER
            }

            c.isJavaIdentifierStart() -> scanIdentifier()
            else -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer = BAD_CHARACTER
            }
        }
    }

    private fun scanWhitespace() {
        var i = tokenStart
        while (i < bufferEnd && buffer[i].isWhitespace()) {
            i++
        }
        tokenEnd = i
        _tokenBuffer = WHITE_SPACE
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
                _tokenBuffer = STRING
                currentState = INITIAL
                return
            }

            i++
        }

        // 未闭合的字符串
        tokenEnd = bufferEnd
        _tokenBuffer = BAD_CHARACTER
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
        _tokenBuffer = NUMBER
        currentState = INITIAL
    }

    private fun scanCommentLine() {
        var i = tokenEnd

        while (i < bufferEnd) {
            if (buffer[i] == '\n') {
                break
            }
            i++
        }

        tokenEnd = i
        _tokenBuffer = COMMENT_LINE_TEXT
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
        _tokenBuffer = COMMENT_BLOCK
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
                _tokenBuffer = STRING
                currentState = INITIAL
                return
            }

            i++
        }

        // 未闭合的字符串
        tokenEnd = bufferEnd
        _tokenBuffer = BAD_CHARACTER
        currentState = INITIAL
    }

    private fun scanIdentifier() {
        var i = tokenEnd

        while (i < bufferEnd && buffer[i].isJavaIdentifierPart()) {
            i++
        }

        tokenEnd = i

        // 检查是否是软关键字
        val text = buffer.subSequence(tokenStart, tokenEnd)
        _tokenBuffer = when (text) {
            "class", "structure", "struct" -> KW_CLASS
            "trait", "interface" -> KW_TRAIT
            else -> SYMBOL
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
                _tokenBuffer = SYMBOL_RAW
                currentState = INITIAL
                return
            } else {
                i++
            }
        }

        // 未闭合的原始标识符
        tokenEnd = bufferEnd
        _tokenBuffer = BAD_CHARACTER
        currentState = INITIAL
    }
}