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
    private var _tokenBuffer: MutableList<IElementType> = mutableListOf()

    // 词法分析状态
    companion object {
        const val INITIAL = 0
        const val IN_STRING_DQ = 11
        const val IN_SINGLE_SQ = 12
        const val IN_STRING_RI = 13
        const val IN_NUMBER = 3
        const val IN_COMMENT = 4
        const val IN_HASH_COMMENT = 5
        const val IN_BLOCK_COMMENT = 6
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

    override fun getState(): Int = currentState

    override fun getTokenType(): IElementType? {
        return _tokenBuffer.getOrNull(0)
    }

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = bufferEnd

    override fun advance() {
        // 还有很多未返回的 token
        if (!_tokenBuffer.isEmpty()) {
            _tokenBuffer.removeAt(0)
            return;
        }
        // 非法状态
        else if (tokenStart >= bufferEnd) {
            _tokenBuffer.clear()
            return
        }
        tokenStart = tokenEnd
        when (currentState) {
            INITIAL -> scanInitial()
            IN_STRING_DQ -> scanString()
            IN_SINGLE_SQ -> scanSingleQuoteString()
            IN_NUMBER -> scanNumber()
            IN_COMMENT -> scanComment()
            IN_HASH_COMMENT -> scanHashComment()
            IN_BLOCK_COMMENT -> scanBlockComment()
            IN_STRING_RI -> scanRawIdentifier()
        }
    }

    private fun scanInitial() {
        val c = buffer[tokenStart]

        when {
            c.isWhitespace() -> scanWhitespace()
            c == '{' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(LBRACE)
            }

            c == '}' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(RBRACE)
            }

            c == '[' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(LBRACK)
            }

            c == ']' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(RBRACK)
            }

            c == '(' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(PARENTHESIS_L)
            }

            c == ')' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(PARENTHESIS_R)
            }

            c == ':' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(COLON)
            }

            c == ',' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(COMMA)
            }

            c == '@' -> {
                if (tokenStart + 1 < bufferEnd) {
                    when (buffer[tokenStart + 1]) {
                        '^' -> {
                            tokenEnd = tokenStart + 2
                            _tokenBuffer.add(OP_MACRO_UPPER)
                        }

                        '.' -> {
                            tokenEnd = tokenStart + 2
                            _tokenBuffer.add(OP_MACRO_LOWER)
                        }

                        else -> {
                            tokenEnd = tokenStart + 1
                            _tokenBuffer.add(OP_MACRO)
                        }
                    }
                } else {
                    tokenEnd = tokenStart + 1
                    _tokenBuffer.add(OP_MACRO)
                }
            }

            c == '.' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(DOT)
            }

            c == '"' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_STRING_DQ
            }

            c == '\'' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_SINGLE_SQ
            }

            c == '`' -> {
                tokenEnd = tokenStart + 1
                currentState = IN_STRING_RI
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

            c == '◤' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(OP_MACRO_UPPER)
            }

            c == '↯' -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(OP_MACRO_LOWER)
            }

            c.isDigit() -> {
                tokenEnd = tokenStart + 1
                currentState = IN_NUMBER
            }

            c.isJavaIdentifierStart() -> scanIdentifier()
            else -> {
                tokenEnd = tokenStart + 1
                _tokenBuffer.add(BAD_CHARACTER)
            }
        }
    }

    private fun scanWhitespace() {
        var i = tokenStart
        while (i < bufferEnd && buffer[i].isWhitespace()) {
            i++
        }
        tokenEnd = i
        _tokenBuffer.add(WHITE_SPACE)
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
                _tokenBuffer.add(STRING)
                currentState = INITIAL
                return
            }

            i++
        }

        // 未闭合的字符串
        tokenEnd = bufferEnd
        _tokenBuffer.add(BAD_CHARACTER)
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
        _tokenBuffer.add(NUMBER)
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
        _tokenBuffer.add(COMMENT_LINE)
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
        _tokenBuffer.add(COMMENT_LINE)
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
        _tokenBuffer.add(COMMENT_BLOCK)
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
                _tokenBuffer.add(STRING)
                currentState = INITIAL
                return
            }

            i++
        }

        // 未闭合的字符串
        tokenEnd = bufferEnd
        _tokenBuffer.add(BAD_CHARACTER)
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
        _tokenBuffer.add(
            when (text) {
                "class", "structure", "struct" -> KW_CLASS
                "trait", "interface" -> KW_TRAIT
                else -> SYMBOL
            }
        )
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
                _tokenBuffer.add(SYMBOL_RAW)
                currentState = INITIAL
                return
            } else {
                i++
            }
        }

        // 未闭合的原始标识符
        tokenEnd = bufferEnd
        _tokenBuffer.add(BAD_CHARACTER)
        currentState = INITIAL
    }
}