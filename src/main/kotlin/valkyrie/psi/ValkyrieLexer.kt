package valkyrie.psi

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import java.util.*

/**
 * Valkyrie 手写词法分析器 (支持模板语法)
 */
class ValkyrieLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset = 0
    private var endOffset = 0
    private var currentOffset = 0
    private var tokenType: IElementType? = null

    // =================================================================
    // 状态管理
    // =================================================================
    companion object {
        private const val STATE_LANGUAGE = 0
        private const val STATE_TEMPLATE_BODY = 1
    }

    private var lexerState = STATE_LANGUAGE

    // 用于辅助判断标签类型的栈。我们只需要知道当前是否在标签内即可。
    private var tagDepth = 0

    // 字符串解析状态 (保持不变)
    private var stringDelimiter: Char? = null
    private var stringDelimiterWidth = 0

    // 数字宏解析状态 (保持不变)
    private var pendingNumberMacro = false

    // 关键字映射
    private val keywords = mapOf(
        "let" to ValkyrieTokenTypes.LET,
        "if" to ValkyrieTokenTypes.IF,
        "else" to ValkyrieTokenTypes.ELSE,
        "end" to ValkyrieTokenTypes.END, // 添加 'end' 关键字
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

    // 用于帮助 Lexer 判断标签类型的关键字
    private val blockOpeningKeywords = setOf("if", "for", "while", "loop", "match", "scope")

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentOffset = startOffset

        // 恢复状态
        this.lexerState = initialState
        this.tagDepth = 0 // 重置 tag 深度

        this.stringDelimiter = null
        this.stringDelimiterWidth = 0
        this.pendingNumberMacro = false
        this.tokenType = null
        advance()
    }

    override fun getState(): Int = lexerState

    override fun getTokenType(): IElementType? = tokenType

    override fun getTokenStart(): Int = startOffset

    override fun getTokenEnd(): Int = currentOffset

    override fun advance() {
        if (currentOffset >= endOffset) {
            tokenType = null
            return
        }
        startOffset = currentOffset

        // 根据当前状态分发任务
        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            STATE_TEMPLATE_BODY -> processTemplateBody()
            else -> { // Fallback
                lexerState = STATE_LANGUAGE
                processLanguage()
            }
        }
    }

    /**
     * 处理模板主体部分。
     * 在这个模式下，所有内容都是 TEMPLATE_TEXT，直到遇到 '<$'。
     */
    private fun processTemplateBody() {
        val textStart = currentOffset
        while (currentOffset < endOffset) {
            if (peek(0) == '<' && peek(1) == '$') {
                break
            }
            currentOffset++
        }

        if (currentOffset > textStart) {
            // 我们找到了文本内容，在 '<$' 之前结束
            tokenType = ValkyrieTokenTypes.TEMPLATE_TEXT
        } else {
            // 没有文本内容，直接遇到了 '<$' 或文件末尾
            // 切换回 LANGUAGE 模式来处理 '<$' 标签
            lexerState = STATE_LANGUAGE
            processLanguage()
        }
    }

    /**
     * 处理语言代码部分。
     * 这包括文件顶层代码和 `<$...$>` 标签内部的代码。
     */
    private fun processLanguage() {
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
                skipLineComment(); tokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' && peek() == '?' -> {
                skipDocComment(); tokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' -> {
                skipLineComment(); tokenType = ValkyrieTokenTypes.COMMENT_LINE
            }

            ch == '<' && peek() == '#' -> {
                skipBlockComment(); tokenType = ValkyrieTokenTypes.COMMENT_RANGE
            }

            ch.isLetter() || ch == '_' -> readIdentifier()
            ch.isDigit() -> readNumber()
            ch == '"' || ch == '\'' -> startString()
            ch == '`' -> readRawIdentifier()
            ch == '<' && peek() == '$' -> readTemplateTagStart()
            ch == '$' && peek() == '>' -> readTemplateTagEnd()
            else -> readOperatorOrPunctuation(ch)
        }
    }

    /**
     * 智能地处理模板开始标签 '<$'。
     * 它会预读标签内的第一个关键字，以决定这个标签是否会开启一个模板主体。
     */
    private fun readTemplateTagStart() {
        currentOffset += 2
        tagDepth++
        tokenType = ValkyrieTokenTypes.TEMPLATE_L

        // 预读（Lookahead）来判断标签类型
        val keyword = peekNextKeyword()
        if (blockOpeningKeywords.contains(keyword)) {
            // 这是一个块级开始标签，标记一下，在遇到对应的 `>` 后切换到 TEMPLATE_BODY 状态
            pushStateTransition(STATE_TEMPLATE_BODY)
        } else {
            // 这是一个表达式或块级结束标签，保持在 LANGUAGE 状态
            pushStateTransition(STATE_LANGUAGE)
        }
    }

    /**
     * 处理模板结束标签 '$>'。
     * 它会根据之前 `readTemplateTagStart` 的决定来切换状态。
     */
    private fun readTemplateTagEnd() {
        currentOffset += 2
        tagDepth = (tagDepth - 1).coerceAtLeast(0)
        tokenType = ValkyrieTokenTypes.TEMPLATE_R
        // 应用之前预读时决定的状态
        popAndApplyStateTransition()
    }

    // 状态转换栈，用于解决 Lexer 的“记忆”问题
    // 当遇到 '<$' 时，我们推入一个目标状态；当遇到 '$>' 时，我们弹出并应用它。
    private val stateTransitionStack = Stack<Int>()
    private fun pushStateTransition(nextState: Int) {
        stateTransitionStack.push(nextState)
    }

    private fun popAndApplyStateTransition() {
        if (stateTransitionStack.isNotEmpty()) {
            lexerState = stateTransitionStack.pop()
        } else {
            // 如果栈为空（例如，一个不匹配的 `>`），安全地回到 LANGUAGE 状态
            lexerState = STATE_LANGUAGE
        }
    }


    /**
     * 预读函数：从当前位置向后看，找到第一个非空格的单词。
     * @return 返回找到的单词，如果没找到则返回空字符串。
     */
    private fun peekNextKeyword(): String {
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

    private fun readWhitespace() {
        while (currentOffset < endOffset && buffer[currentOffset].isWhitespace()) {
            currentOffset++
        }
        tokenType = WHITE_SPACE
    }

    override fun getBufferSequence(): CharSequence = buffer
    override fun getBufferEnd(): Int = endOffset
    private fun peek(offset: Int = 1): Char? {
        val pos = currentOffset + offset
        return if (pos < endOffset) buffer[pos] else null
    }

    private fun startString() {
        val delimiter = buffer[currentOffset]
        var width = 0
        while (currentOffset + width < endOffset && buffer[currentOffset + width] == delimiter) {
            width++
        }

        stringDelimiter = delimiter
        stringDelimiterWidth = width
        currentOffset += width
        tokenType = ValkyrieTokenTypes.STRING_START
    }

    private fun processStringToken() {
        if (isAtStringEnd()) {
            currentOffset += stringDelimiterWidth
            tokenType = ValkyrieTokenTypes.STRING_END
            stringDelimiter = null
            stringDelimiterWidth = 0
        } else {
            val contentStart = currentOffset
            while (currentOffset < endOffset && !isAtStringEnd()) {
                currentOffset++
            }
            if (currentOffset > contentStart) {
                tokenType = ValkyrieTokenTypes.STRING_TEXT
            } else {
                tokenType = null
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

    private fun readIdentifier() {
        val idStart = currentOffset
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch == '_') {
                currentOffset++
            } else {
                break
            }
        }

        val nextChar = peek(0)
        if (nextChar == '\'' || nextChar == '"') {
            tokenType = ValkyrieTokenTypes.MACRO_STRING
            return
        }

        val text = buffer.subSequence(idStart, currentOffset).toString()
        tokenType = keywords[text] ?: ValkyrieTokenTypes.IDENTIFIER_STD
    }

    private fun readNumber() {
        var hasDecimalPoint = false
        val numberStart = currentOffset

        if (buffer[currentOffset] == '0' && peek()?.lowercaseChar() in listOf('b', 'x')) {
            val prefix = peek()!!.lowercaseChar()
            currentOffset += 2
            val validChars = if (prefix == 'b') "01" else "0123456789abcdefABCDEF"
            while (currentOffset < endOffset && buffer[currentOffset] in validChars) {
                currentOffset++
            }
            tokenType = ValkyrieTokenTypes.INTEGER
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
            tokenType = if (hasDecimalPoint) ValkyrieTokenTypes.DECIMAL else ValkyrieTokenTypes.INTEGER
        }

        if (currentOffset > numberStart && currentOffset < endOffset) {
            val nextChar = buffer[currentOffset]
            if (nextChar.isLetter() || nextChar == '_') {
                pendingNumberMacro = true
            }
        }
    }

    private fun readNumberMacro() {
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
            tokenType = ValkyrieTokenTypes.MACRO_NUMBER
        } else {
            advance()
        }
    }

    private fun skipLineComment() {
        currentOffset++
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun skipBlockComment() {
        currentOffset += 2
        var depth = 1
        while (currentOffset < endOffset && depth > 0) {
            if (peek(0) == '<' && peek(1) == '#') {
                depth++
                currentOffset += 2
            } else if (peek(0) == '#' && peek(1) == '>') {
                depth--
                currentOffset += 2
            } else {
                currentOffset++
            }
        }
    }

    private fun skipDocComment() {
        currentOffset += 2
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun readRawIdentifier() {
        currentOffset++
        val contentStart = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != '`') {
            currentOffset++
        }
        if (currentOffset < endOffset) {
            currentOffset++
        }
        tokenType = if (currentOffset > contentStart + 1) ValkyrieTokenTypes.IDENTIFIER_RAW else BAD_CHARACTER
    }

    private fun readOperatorOrPunctuation(ch: Char) {
        when (ch) {
            '<' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++; tokenType = ValkyrieTokenTypes.LESS_EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.ANGLE_L
                }
            }

            '=' -> {
                currentOffset++
                when (peek(0)) {
                    '=' -> {
                        currentOffset++; tokenType = ValkyrieTokenTypes.EQUAL
                    }

                    '>' -> {
                        currentOffset++; tokenType = ValkyrieTokenTypes.DOUBLE_ARROW
                    }

                    else -> tokenType = ValkyrieTokenTypes.ASSIGN
                }
            }
            // ... (rest of your operator/punctuation logic remains the same)
            // Note: I have removed '<$' and '$>' from here.
            '!' -> {
                currentOffset++
                if (peek(0) == '=') {
                    currentOffset++
                    tokenType = ValkyrieTokenTypes.NOT_EQUAL
                } else {
                    tokenType = ValkyrieTokenTypes.WOW
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
                tokenType = ValkyrieTokenTypes.BRACE_R
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
                currentOffset++; tokenType = ValkyrieTokenTypes.PARENTHESIS_L
            }

            ')' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.PARENTHESIS_R
            }

            '{' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.BRACE_L
            }

            '[' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.BRACKET_L
            }

            ']' -> {
                currentOffset++; tokenType = ValkyrieTokenTypes.BRACKET_R
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