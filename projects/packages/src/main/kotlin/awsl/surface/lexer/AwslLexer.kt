package awsl.surface.lexer

import awsl.surface.psi.AwslTypes
import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

/**
 * AWSL 语言手动实现的词法分析器
 *
 * 状态说明：
 * - STATE_INITIAL: 初始状态，处理代码和关键字
 * - STATE_HTML_BEGIN: HTML 标签开始状态，处理标签名和属性
 * - STATE_HTML_CONTEXT: HTML 文本内容状态
 * - STATE_HTML_RAW: HTML 原始内容状态（如 script/style）
 * - STATE_HTML_END: HTML 结束标签状态
 * - STATE_CODE: 代码片段状态（<\...> 内部）
 * - STATE_HTML_DIRECTIVE_EXPR: `<if (expr)>` / `<else-if (expr)>` condition expression
 */
class AwslLexer : LexerBase() {

    private lateinit var buffer: CharSequence
    private var startOffset: Int = 0
    private var endOffset: Int = 0
    private var currentOffset: Int = 0
    private var tokenStart: Int = 0
    private var tokenEnd: Int = 0
    private var currentTokenType: IElementType? = null
    private var state: Int = STATE_INITIAL

    /**
     * 状态栈，用于管理上下文切换
     */
    private val stateStack = ArrayDeque<Int>()

    /**
     * 泛型括号平衡计数
     */
    private var angleBalance: Int = 0

    /**
     * 是否已到达标签名
     */
    private var reachTag: Boolean = false

    /**
     * After `>` of `<script>` / `<style>` / `<raw>`, enter this state (null = normal HTML context).
     */
    private var pendingContentState: Int? = null

    /** Directive open tag (`if`, `else-if`, …) awaiting atom or `(expr)` condition. */
    private var pendingDirectiveCondition: Boolean = false

    private var directiveParenDepth: Int = 0

    private var directiveAtomConsumed: Boolean = false

    companion object {
        const val STATE_INITIAL = 0
        const val STATE_HTML_BEGIN = 1
        const val STATE_HTML_CONTEXT = 2
        const val STATE_HTML_RAW = 3
        const val STATE_HTML_END = 4
        const val STATE_CODE = 5
        const val STATE_NUMBER_WAIT_UNIT = 6
        const val STATE_HTML_DIRECTIVE_EXPR = 7

        /** Template control-flow tags (not plain HTML). */
        val HTML_DIRECTIVE_TAGS = setOf("if", "else-if", "else", "for", "loop")

        /** Tags that require `<if atom>` or `<if (expr)>`. */
        val HTML_COND_DIRECTIVE_TAGS = setOf("if", "else-if")

        /**
         * HTML 自闭合标签
         */
        val HTML_VOID_TAGS = setOf(
            "hr", "br", "img", "input", "meta", "link", "area", "base",
            "col", "command", "embed", "keygen", "param", "source", "track", "wbr"
        )

        /**
         * HTML 原始内容标签
         */
        val HTML_RAW_TAGS = setOf("style", "raw")

        /**
         * HTML 脚本标签
         */
        val HTML_SCRIPT_TAGS = setOf("script")
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.currentOffset = startOffset
        this.tokenStart = startOffset
        this.tokenEnd = startOffset
        this.currentTokenType = null
        this.state = initialState
        this.stateStack.clear()
        this.angleBalance = 0
        this.reachTag = false
        this.pendingContentState = null
        this.pendingDirectiveCondition = false
        this.directiveParenDepth = 0
        this.directiveAtomConsumed = false
        advance()
    }

    override fun getState(): Int = state

    override fun getTokenType(): IElementType? = currentTokenType

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun advance() {
        tokenStart = currentOffset
        currentTokenType = null

        if (currentOffset >= endOffset) {
            tokenEnd = endOffset
            state = STATE_INITIAL
            return
        }

        when (state) {
            STATE_INITIAL -> advanceInitial()
            STATE_HTML_BEGIN -> advanceHtmlBegin()
            STATE_HTML_CONTEXT -> advanceHtmlContext()
            STATE_HTML_RAW -> advanceHtmlRaw()
            STATE_HTML_END -> advanceHtmlEnd()
            STATE_CODE -> advanceCode()
            STATE_NUMBER_WAIT_UNIT -> advanceNumberWaitUnit()
            STATE_HTML_DIRECTIVE_EXPR -> advanceDirectiveExpr()
        }
    }

    /**
     * 切换到指定状态
     */
    private fun switchTo(newState: Int) {
        state = newState
    }

    /**
     * 将当前状态压入栈并切换到新状态
     */
    private fun pushState(newState: Int) {
        stateStack.addLast(state)
        state = newState
    }

    /**
     * 从状态栈弹出并恢复状态
     */
    private fun popState(): Int {
        return if (stateStack.isNotEmpty()) {
            stateStack.removeLast()
        } else {
            STATE_INITIAL
        }
    }

    /**
     * 查看状态栈顶
     */
    private fun peekState(): Int {
        return if (stateStack.isNotEmpty()) {
            stateStack.last()
        } else {
            STATE_INITIAL
        }
    }

    /**
     * 初始状态：处理代码、关键字、符号、字符串、注释
     */
    private fun advanceInitial() {
        val ch = buffer[currentOffset]

        // 跳过空白字符
        if (ch.isWhitespace()) {
            skipWhitespace()
            return
        }

        // 检查注释
        if (ch == '/') {
            if (currentOffset + 2 <= endOffset && buffer[currentOffset + 1] == '/') {
                if (currentOffset + 3 <= endOffset && buffer[currentOffset + 2] == '/') {
                    parseCommentDocument()
                } else {
                    parseCommentLine()
                }
                return
            }
        }

        // 检查 HTML 开始标签
        if (ch == '<') {
            if (currentOffset + 1 < endOffset) {
                val nextCh = buffer[currentOffset + 1]
                when (nextCh) {
                    '\\' -> {
                        // 代码片段开始 <\...>
                        currentTokenType = AwslTypes.HTML_START_CODE_L
                        currentOffset += 2
                        tokenEnd = currentOffset
                        pushState(STATE_CODE)
                        switchTo(STATE_HTML_BEGIN)
                        return
                    }
                    '/' -> {
                        // 结束标签 </...>
                        currentOffset += 2
                        tokenEnd = currentOffset
                        reachTag = false
                        switchTo(STATE_HTML_END)
                        currentTokenType = AwslTypes.HTML_END_L
                        return
                    }
                    '!' -> {
                        // HTML 注释 <!--...-->
                        if (currentOffset + 4 <= endOffset &&
                            buffer[currentOffset + 2] == '-' &&
                            buffer[currentOffset + 3] == '-') {
                            parseHtmlComment()
                            return
                        }
                    }
                }
            }
            // 普通 HTML 开始标签 <...>
            currentTokenType = AwslTypes.HTML_START_TEXT_L
            currentOffset++
            tokenEnd = currentOffset
            reachTag = false
            pushState(STATE_HTML_CONTEXT)
            switchTo(STATE_HTML_BEGIN)
            return
        }

        // 检查符号和关键字
        when (ch) {
            '(' -> {
                currentTokenType = AwslTypes.PARENTHESIS_L
                currentOffset++
            }
            ')' -> {
                currentTokenType = AwslTypes.PARENTHESIS_R
                currentOffset++
            }
            '[' -> {
                currentTokenType = AwslTypes.BRACKET_L
                currentOffset++
            }
            ']' -> {
                currentTokenType = AwslTypes.BRACKET_R
                currentOffset++
            }
            '{' -> {
                currentTokenType = AwslTypes.BRACE_L
                currentOffset++
            }
            '}' -> {
                currentTokenType = AwslTypes.BRACE_R
                currentOffset++
            }
            '^' -> {
                currentTokenType = AwslTypes.ACCENT
                currentOffset++
            }
            '=' -> {
                currentTokenType = AwslTypes.EQ
                currentOffset++
            }
            ':' -> {
                currentTokenType = AwslTypes.COLON
                currentOffset++
            }
            ';' -> {
                currentTokenType = AwslTypes.SEMICOLON
                currentOffset++
            }
            ',' -> {
                currentTokenType = AwslTypes.COMMA
                currentOffset++
            }
            '$' -> {
                currentTokenType = AwslTypes.DOLLAR
                currentOffset++
            }
            '.' -> {
                currentTokenType = AwslTypes.DOT
                currentOffset++
            }
            '*' -> {
                currentTokenType = AwslTypes.STAR
                currentOffset++
            }
            '@' -> {
                currentTokenType = AwslTypes.AT
                currentOffset++
            }
            '-' -> {
                currentTokenType = AwslTypes.MINUS
                currentOffset++
            }
            '"' -> {
                parseString()
                return
            }
            else -> {
                if (ch.isLetter() || ch == '_') {
                    parseIdentifierOrKeyword()
                    return
                } else if (ch.isDigit()) {
                    parseNumber()
                    return
                } else {
                    currentTokenType = TokenType.BAD_CHARACTER
                    currentOffset++
                }
            }
        }
        tokenEnd = currentOffset
    }

    /**
     * HTML 开始标签状态：处理标签名和属性
     */
    private fun advanceHtmlBegin() {
        val ch = buffer[currentOffset]

        // 跳过空白
        if (ch.isWhitespace()) {
            skipWhitespace()
            return
        }

        if (pendingDirectiveCondition && !directiveAtomConsumed) {
            advanceDirectiveCondition()
            return
        }

        // 检查自闭合标签结束 />
        if (ch == '/' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '>') {
            currentOffset += 2
            tokenEnd = currentOffset
            val prevState = popState()
            switchTo(prevState)
            pendingContentState = null
            currentTokenType = AwslTypes.HTML_SELF_END_R
            return
        }

        // 检查标签结束 >
        if (ch == '>') {
            currentOffset++
            tokenEnd = currentOffset
            val prevState = popState()
            if (angleBalance > 0) {
                angleBalance--
                currentTokenType = AwslTypes.GENERIC_R
                return
            }
            currentTokenType = AwslTypes.HTML_START_R
            val contentState = pendingContentState
            pendingDirectiveCondition = false
            directiveAtomConsumed = false
            if (contentState != null) {
                // Keep parent on stack so </script>/</style> can pop back
                stateStack.addLast(prevState)
                state = contentState
                pendingContentState = null
            } else {
                switchTo(prevState)
            }
            return
        }

        // 检查泛型开始 <
        if (ch == '<') {
            angleBalance++
            currentOffset++
            tokenEnd = currentOffset
            currentTokenType = AwslTypes.GENERIC_L
            return
        }

        // 检查泛型结束 >
        if (ch == '>') {
            if (angleBalance > 0) {
                angleBalance--
                currentOffset++
                tokenEnd = currentOffset
                currentTokenType = AwslTypes.GENERIC_R
                return
            }
        }

        // 检查符号
        when (ch) {
            '=' -> {
                currentTokenType = AwslTypes.EQ
                currentOffset++
                tokenEnd = currentOffset
                return
            }
            ':' -> {
                currentTokenType = AwslTypes.COLON
                currentOffset++
                tokenEnd = currentOffset
                return
            }
            '[' -> {
                currentTokenType = AwslTypes.BRACKET_L
                currentOffset++
                tokenEnd = currentOffset
                return
            }
            ']' -> {
                currentTokenType = AwslTypes.BRACKET_R
                currentOffset++
                tokenEnd = currentOffset
                return
            }
            '{' -> {
                currentTokenType = AwslTypes.BRACE_L
                currentOffset++
                tokenEnd = currentOffset
                return
            }
            '}' -> {
                currentTokenType = AwslTypes.BRACE_R
                currentOffset++
                tokenEnd = currentOffset
                return
            }
        }

        // 处理字符串
        if (ch == '"') {
            parseString()
            return
        }

        // 处理标识符（标签名或属性名）
        if (ch.isLetter() || ch == '_') {
            val start = currentOffset
            while (currentOffset < endOffset &&
                (buffer[currentOffset].isLetterOrDigit() || buffer[currentOffset] == '_' || buffer[currentOffset] == '-')) {
                currentOffset++
            }
            val name = buffer.substring(start, currentOffset)
            tokenEnd = currentOffset

            if (!reachTag) {
                reachTag = true
                // 检查是否是特殊标签
                when {
                    HTML_VOID_TAGS.contains(name) -> {
                        currentTokenType = AwslTypes.HTML_TAG_SYMBOL
                    }
                    HTML_RAW_TAGS.contains(name) -> {
                        // Enter raw content only after consuming '>'
                        pendingContentState = STATE_HTML_RAW
                        currentTokenType = AwslTypes.HTML_TAG_RAW
                    }
                    HTML_SCRIPT_TAGS.contains(name) -> {
                        // Raw content host for language injection (Valkyrie)
                        pendingContentState = STATE_HTML_RAW
                        currentTokenType = AwslTypes.HTML_TAG_SCRIPT
                    }
                    HTML_DIRECTIVE_TAGS.contains(name) -> {
                        pendingDirectiveCondition = name in HTML_COND_DIRECTIVE_TAGS
                        directiveAtomConsumed = false
                        currentTokenType = AwslTypes.HTML_TAG_DIRECTIVE
                    }
                    else -> {
                        currentTokenType = AwslTypes.HTML_TAG_SYMBOL
                    }
                }
            } else {
                currentTokenType = AwslTypes.SYMBOL
            }
            return
        }

        // 其他字符作为 BAD_CHARACTER
        currentTokenType = TokenType.BAD_CHARACTER
        currentOffset++
        tokenEnd = currentOffset
    }

    /**
     * HTML 文本内容状态
     */
    private fun advanceHtmlContext() {
        val start = currentOffset

        // 检查结束标签开始
        if (buffer[currentOffset] == '<' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '/') {
            if (start == currentOffset) {
                // 立即切换到结束标签状态
                currentOffset += 2
                tokenEnd = currentOffset
                reachTag = false
                switchTo(STATE_HTML_END)
                currentTokenType = AwslTypes.HTML_END_L
            } else {
                // 先返回已积累的文本
                tokenEnd = currentOffset
                currentTokenType = AwslTypes.HTML_STRING_TOKEN
            }
            return
        }

        // 检查代码片段开始
        if (buffer[currentOffset] == '<' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '\\') {
            if (start == currentOffset) {
                currentTokenType = AwslTypes.HTML_START_CODE_L
                currentOffset += 2
                tokenEnd = currentOffset
                pushState(STATE_CODE)
                switchTo(STATE_HTML_BEGIN)
            } else {
                tokenEnd = currentOffset
                currentTokenType = AwslTypes.HTML_STRING_TOKEN
            }
            return
        }

        // 检查 HTML 注释
        if (buffer[currentOffset] == '<' && currentOffset + 3 < endOffset &&
            buffer[currentOffset + 1] == '!' &&
            buffer[currentOffset + 2] == '-' &&
            buffer[currentOffset + 3] == '-') {
            if (start == currentOffset) {
                parseHtmlComment()
            } else {
                tokenEnd = currentOffset
                currentTokenType = AwslTypes.HTML_STRING_TOKEN
            }
            return
        }

        // 检查新标签开始
        if (buffer[currentOffset] == '<') {
            if (start == currentOffset) {
                currentTokenType = AwslTypes.HTML_START_TEXT_L
                currentOffset++
                tokenEnd = currentOffset
                reachTag = false
                pushState(STATE_HTML_CONTEXT)
                switchTo(STATE_HTML_BEGIN)
            } else {
                tokenEnd = currentOffset
                currentTokenType = AwslTypes.HTML_STRING_TOKEN
            }
            return
        }

        // 检查 HTML 转义序列
        if (buffer[currentOffset] == '&') {
            if (start == currentOffset) {
                parseHtmlEscape()
            } else {
                tokenEnd = currentOffset
                currentTokenType = AwslTypes.HTML_STRING_TOKEN
            }
            return
        }

        // 积累文本内容
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch == '<' || ch == '&') {
                break
            }
            currentOffset++
        }

        tokenEnd = currentOffset
        currentTokenType = AwslTypes.HTML_STRING_TOKEN
    }

    /**
     * HTML 原始内容状态（script/style 等）
     */
    private fun advanceHtmlRaw() {
        val start = currentOffset

        // 检查结束标签开始
        if (buffer[currentOffset] == '<' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '/') {
            // 预查看是否是匹配的结束标签
            var tagEnd = currentOffset + 2
            while (tagEnd < endOffset &&
                (buffer[tagEnd].isLetterOrDigit() || buffer[tagEnd] == '_' || buffer[tagEnd] == '-')) {
                tagEnd++
            }
            if (tagEnd < endOffset && buffer[tagEnd] == '>') {
                if (start == currentOffset) {
                    // 这是结束标签
                    currentOffset += 2
                    tokenEnd = currentOffset
                    reachTag = false
                    switchTo(STATE_HTML_END)
                    currentTokenType = AwslTypes.HTML_END_L
                } else {
                    // 先返回已积累的文本
                    tokenEnd = currentOffset
                    currentTokenType = AwslTypes.HTML_STRING_TOKEN
                }
                return
            }
        }

        // 积累原始内容
        while (currentOffset < endOffset) {
            if (buffer[currentOffset] == '<' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '/') {
                // 预查看是否是结束标签
                var tagEnd = currentOffset + 2
                while (tagEnd < endOffset &&
                    (buffer[tagEnd].isLetterOrDigit() || buffer[tagEnd] == '_' || buffer[tagEnd] == '-')) {
                    tagEnd++
                }
                if (tagEnd < endOffset && buffer[tagEnd] == '>') {
                    break
                }
            }
            currentOffset++
        }

        tokenEnd = currentOffset
        currentTokenType = if (currentOffset > start) {
            AwslTypes.HTML_STRING_TOKEN
        } else {
            TokenType.BAD_CHARACTER
        }
    }

    /**
     * HTML 结束标签状态
     */
    private fun advanceHtmlEnd() {
        val ch = buffer[currentOffset]

        // 跳过空白
        if (ch.isWhitespace()) {
            skipWhitespace()
            return
        }

        // 检查标签结束 >
        if (ch == '>') {
            currentOffset++
            tokenEnd = currentOffset
            val prevState = popState()
            switchTo(prevState)
            currentTokenType = AwslTypes.HTML_END_R
            reachTag = false
            return
        }

        // 处理标签名
        if (ch.isLetter() || ch == '_') {
            val start = currentOffset
            while (currentOffset < endOffset &&
                (buffer[currentOffset].isLetterOrDigit() || buffer[currentOffset] == '_' || buffer[currentOffset] == '-')) {
                currentOffset++
            }
            tokenEnd = currentOffset
            if (!reachTag) {
                reachTag = true
                val name = buffer.substring(start, currentOffset)
                currentTokenType = when {
                    HTML_RAW_TAGS.contains(name) -> AwslTypes.HTML_TAG_RAW
                    HTML_SCRIPT_TAGS.contains(name) -> AwslTypes.HTML_TAG_SCRIPT
                    HTML_DIRECTIVE_TAGS.contains(name) -> AwslTypes.HTML_TAG_DIRECTIVE
                    else -> AwslTypes.HTML_TAG_SYMBOL
                }
            } else {
                currentTokenType = AwslTypes.SYMBOL
            }
            return
        }

        // 其他字符
        currentTokenType = TokenType.BAD_CHARACTER
        currentOffset++
        tokenEnd = currentOffset
    }

    /**
     * 代码片段状态（<\...> 内部）
     */
    private fun advanceCode() {
        val ch = buffer[currentOffset]

        // 跳过空白
        if (ch.isWhitespace()) {
            skipWhitespace()
            return
        }

        // 检查代码片段结束 </...>
        if (ch == '<' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '/') {
            currentOffset += 2
            tokenEnd = currentOffset
            reachTag = false
            switchTo(STATE_HTML_END)
            currentTokenType = AwslTypes.HTML_END_L
            return
        }

        // 在代码状态中，使用初始状态的逻辑
        advanceInitial()
    }

    /**
     * 数字等待单位状态
     */
    private fun advanceNumberWaitUnit() {
        val ch = buffer[currentOffset]

        if (ch.isLetter() || ch == '_') {
            val start = currentOffset
            while (currentOffset < endOffset &&
                (buffer[currentOffset].isLetterOrDigit() || buffer[currentOffset] == '_')) {
                currentOffset++
            }
            tokenEnd = currentOffset
            currentTokenType = AwslTypes.NUMBER_UNIT
            // 恢复之前的状态
            val prevState = popState()
            switchTo(prevState)
        } else {
            // 不是单位，恢复状态并重新处理当前字符
            val prevState = popState()
            switchTo(prevState)
            // 重新处理当前字符
            when (state) {
                STATE_INITIAL -> advanceInitial()
                STATE_HTML_BEGIN -> advanceHtmlBegin()
                STATE_CODE -> advanceCode()
                else -> {
                    currentTokenType = TokenType.BAD_CHARACTER
                    currentOffset++
                    tokenEnd = currentOffset
                }
            }
        }
    }

    /**
     * `<if atom>` / `<if (expr)>` — atom branch (single identifier or true/false).
     */
    private fun advanceDirectiveCondition() {
        val ch = buffer[currentOffset]
        if (ch.isWhitespace()) {
            skipWhitespace()
            return
        }
        if (ch == '(') {
            currentTokenType = AwslTypes.PARENTHESIS_L
            currentOffset++
            tokenEnd = currentOffset
            directiveParenDepth = 1
            pendingDirectiveCondition = false
            pushState(STATE_HTML_BEGIN)
            switchTo(STATE_HTML_DIRECTIVE_EXPR)
            return
        }
        if (ch.isLetter() || ch == '_') {
            val start = currentOffset
            while (currentOffset < endOffset &&
                (buffer[currentOffset].isLetterOrDigit() || buffer[currentOffset] == '_' || buffer[currentOffset] == '-')) {
                currentOffset++
            }
            val name = buffer.substring(start, currentOffset)
            tokenEnd = currentOffset
            currentTokenType = when (name) {
                "true", "false" -> AwslTypes.BOOLEAN
                else -> AwslTypes.SYMBOL
            }
            directiveAtomConsumed = true
            pendingDirectiveCondition = false
            return
        }
        currentTokenType = TokenType.BAD_CHARACTER
        currentOffset++
        tokenEnd = currentOffset
    }

    /**
     * Parenthesized directive condition: `<if (!todos() || count_all() == 0)>`.
     */
    private fun advanceDirectiveExpr() {
        val ch = buffer[currentOffset]
        if (ch.isWhitespace()) {
            skipWhitespace()
            return
        }
        if (ch == ')') {
            currentTokenType = AwslTypes.PARENTHESIS_R
            currentOffset++
            tokenEnd = currentOffset
            directiveParenDepth--
            if (directiveParenDepth <= 0) {
                directiveParenDepth = 0
                switchTo(popState())
            }
            return
        }
        if (ch == '(') {
            directiveParenDepth++
            currentTokenType = AwslTypes.PARENTHESIS_L
            currentOffset++
            tokenEnd = currentOffset
            return
        }
        if (ch == '!') {
            currentTokenType = AwslTypes.BANG
            currentOffset++
            tokenEnd = currentOffset
            return
        }
        if (ch == '<') {
            currentTokenType = AwslTypes.LT
            currentOffset++
            tokenEnd = currentOffset
            return
        }
        if (ch == '>') {
            currentTokenType = AwslTypes.GT
            currentOffset++
            tokenEnd = currentOffset
            return
        }
        if (ch == '|' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '|') {
            currentTokenType = AwslTypes.OR_OR
            currentOffset += 2
            tokenEnd = currentOffset
            return
        }
        if (ch == '&' && currentOffset + 1 < endOffset && buffer[currentOffset + 1] == '&') {
            currentTokenType = AwslTypes.AND_AND
            currentOffset += 2
            tokenEnd = currentOffset
            return
        }
        advanceExpressionToken()
    }

    /** Tokens shared by directive conditions and inline code (no HTML `<tag>` restart). */
    private fun advanceExpressionToken() {
        val ch = buffer[currentOffset]
        when (ch) {
            '[' -> {
                currentTokenType = AwslTypes.BRACKET_L
                currentOffset++
            }
            ']' -> {
                currentTokenType = AwslTypes.BRACKET_R
                currentOffset++
            }
            '{' -> {
                currentTokenType = AwslTypes.BRACE_L
                currentOffset++
            }
            '}' -> {
                currentTokenType = AwslTypes.BRACE_R
                currentOffset++
            }
            '^' -> {
                currentTokenType = AwslTypes.ACCENT
                currentOffset++
            }
            '=' -> {
                currentTokenType = AwslTypes.EQ
                currentOffset++
            }
            ':' -> {
                currentTokenType = AwslTypes.COLON
                currentOffset++
            }
            ';' -> {
                currentTokenType = AwslTypes.SEMICOLON
                currentOffset++
            }
            ',' -> {
                currentTokenType = AwslTypes.COMMA
                currentOffset++
            }
            '$' -> {
                currentTokenType = AwslTypes.DOLLAR
                currentOffset++
            }
            '.' -> {
                currentTokenType = AwslTypes.DOT
                currentOffset++
            }
            '*' -> {
                currentTokenType = AwslTypes.STAR
                currentOffset++
            }
            '@' -> {
                currentTokenType = AwslTypes.AT
                currentOffset++
            }
            '-' -> {
                currentTokenType = AwslTypes.MINUS
                currentOffset++
            }
            '"' -> {
                parseString()
                return
            }
            else -> {
                if (ch.isLetter() || ch == '_') {
                    parseIdentifierOrKeyword()
                    return
                } else if (ch.isDigit()) {
                    parseNumber()
                    return
                } else {
                    currentTokenType = TokenType.BAD_CHARACTER
                    currentOffset++
                }
            }
        }
        tokenEnd = currentOffset
    }

    /**
     * 跳过空白字符
     */
    private fun skipWhitespace() {
        currentTokenType = TokenType.WHITE_SPACE
        while (currentOffset < endOffset && buffer[currentOffset].isWhitespace()) {
            currentOffset++
        }
        tokenEnd = currentOffset
    }

    /**
     * 解析行注释 //...
     */
    private fun parseCommentLine() {
        currentTokenType = AwslTypes.COMMENT_LINE
        currentOffset += 2
        while (currentOffset < endOffset && buffer[currentOffset] != '\n' && buffer[currentOffset] != '\r') {
            currentOffset++
        }
        tokenEnd = currentOffset
    }

    /**
     * 解析文档注释 ///...
     */
    private fun parseCommentDocument() {
        currentTokenType = AwslTypes.COMMENT_DOCUMENT
        currentOffset += 3
        while (currentOffset < endOffset && buffer[currentOffset] != '\n' && buffer[currentOffset] != '\r') {
            currentOffset++
        }
        tokenEnd = currentOffset
    }

    /**
     * 解析 HTML 注释 <!--...-->
     */
    private fun parseHtmlComment() {
        currentTokenType = AwslTypes.COMMENT_HTML
        currentOffset += 4
        while (currentOffset + 2 < endOffset) {
            if (buffer[currentOffset] == '-' &&
                buffer[currentOffset + 1] == '-' &&
                buffer[currentOffset + 2] == '>') {
                currentOffset += 3
                break
            }
            currentOffset++
        }
        tokenEnd = currentOffset
    }

    /**
     * 解析字符串 "..."
     */
    private fun parseString() {
        currentTokenType = AwslTypes.STRING
        currentOffset++
        while (currentOffset < endOffset) {
            when (buffer[currentOffset]) {
                '\\' -> {
                    currentOffset++
                    if (currentOffset < endOffset) {
                        currentOffset++
                    }
                }
                '"' -> {
                    currentOffset++
                    break
                }
                else -> currentOffset++
            }
        }
        tokenEnd = currentOffset
    }

    /**
     * 解析标识符或关键字
     */
    private fun parseIdentifierOrKeyword() {
        val start = currentOffset
        while (currentOffset < endOffset &&
            (buffer[currentOffset].isLetterOrDigit() || buffer[currentOffset] == '_' || buffer[currentOffset] == '-')) {
            currentOffset++
        }
        val name = buffer.substring(start, currentOffset)
        tokenEnd = currentOffset

        currentTokenType = when (name) {
            "for" -> AwslTypes.FOR
            "in" -> AwslTypes.IN
            "while" -> AwslTypes.WHILE
            "if" -> AwslTypes.IF
            "else" -> AwslTypes.ELSE
            else -> AwslTypes.SYMBOL
        }
    }

    /**
     * 解析数字（整数或小数）
     */
    private fun parseNumber() {
        val start = currentOffset
        var isDecimal = false

        while (currentOffset < endOffset && buffer[currentOffset].isDigit()) {
            currentOffset++
        }

        if (currentOffset < endOffset && buffer[currentOffset] == '.' &&
            currentOffset + 1 < endOffset && buffer[currentOffset + 1].isDigit()) {
            isDecimal = true
            currentOffset++
            while (currentOffset < endOffset && buffer[currentOffset].isDigit()) {
                currentOffset++
            }
        }

        tokenEnd = currentOffset
        currentTokenType = if (isDecimal) AwslTypes.DECIMAL else AwslTypes.INTEGER

        // 检查是否有单位
        if (currentOffset < endOffset &&
            (buffer[currentOffset].isLetter() || buffer[currentOffset] == '_')) {
            pushState(state)
            switchTo(STATE_NUMBER_WAIT_UNIT)
        }
    }

    /**
     * 解析 HTML 转义序列 &...;
     */
    private fun parseHtmlEscape() {
        currentTokenType = AwslTypes.HTML_ESCAPE_TOKEN
        currentOffset++
        while (currentOffset < endOffset && buffer[currentOffset] != ';' && buffer[currentOffset] != ' ' && buffer[currentOffset] != '\n') {
            currentOffset++
        }
        if (currentOffset < endOffset && buffer[currentOffset] == ';') {
            currentOffset++
        }
        tokenEnd = currentOffset
    }

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = endOffset
}
