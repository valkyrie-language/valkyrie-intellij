package valkyrie.psi

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import java.lang.Integer.max

/**
 * Valkyrie 手写词法分析器 (修复版)
 */
class ValkyrieLexer : LexerBase() {
    private var buffer: CharSequence = ""
    private var startOffset = 0
    private var endOffset = 0
    private var currentOffset = 0
    private var tokenType: IElementType? = null

    // 状态量
    // 0: Normal, >0: Template Depth
    private var templateDepth = 0

    // 字符串解析状态
    private var stringDelimiter: Char? = null
    private var stringDelimiterWidth = 0

    // 数字宏解析状态
    private var pendingNumberMacro = false


    // 关键字映射 (保持不变)
    private val keywords = mapOf(
        "let" to ValkyrieTokenTypes.LET,
        "if" to ValkyrieTokenTypes.IF,
        "else" to ValkyrieTokenTypes.ELSE,
        "while" to ValkyrieTokenTypes.WHILE,
        "loop" to ValkyrieTokenTypes.LOOP,
        "for" to ValkyrieTokenTypes.FOR,
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
        // 恢复状态
        this.templateDepth = initialState
        this.stringDelimiter = null
        this.stringDelimiterWidth = 0
        this.pendingNumberMacro = false
        this.tokenType = null
        advance()
    }

    override fun getState(): Int = templateDepth

    override fun getTokenType(): IElementType? = tokenType

    override fun getTokenStart(): Int = startOffset

    override fun getTokenEnd(): Int = currentOffset

    override fun advance() {
        if (currentOffset >= endOffset) {
            tokenType = null
            return
        }

        startOffset = currentOffset

        // 优先处理多-token 状态
        if (stringDelimiter != null) {
            processStringToken()
            return
        }
        if (pendingNumberMacro) {
            readNumberMacro()
            return
        }
        if (templateDepth > 0) {
            processTemplateToken()
            return
        }

        // 常规状态解析
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
            else -> readOperatorOrPunctuation(ch)
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
            // Reset state
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
                // Should not happen if buffer is not empty
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

        // 问题 1: 检查是否为 string macro
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

        // Prefixes (0b, 0x)
        if (buffer[currentOffset] == '0' && peek()?.lowercaseChar() in listOf('b', 'x')) {
            val prefix = peek()!!.lowercaseChar()
            currentOffset += 2
            val validChars = if (prefix == 'b') "01" else "0123456789abcdefABCDEF"
            while (currentOffset < endOffset && buffer[currentOffset] in validChars) {
                currentOffset++
            }
            tokenType = ValkyrieTokenTypes.INTEGER
        } else {
            // Decimal/Integer
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

        // 检查数字后是否有宏
        if (currentOffset > numberStart && currentOffset < endOffset) {
            val nextChar = buffer[currentOffset]
            // 不允许有空格
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
            // Should not happen, but as a fallback
            advance()
        }
    }

    // =================================================================
    // 问题 3: 模板解析
    // =================================================================
    private fun processTemplateToken() {
        // 优先匹配特殊标记
        if (currentOffset + 1 < endOffset) {
            val ch1 = buffer[currentOffset]
            val ch2 = buffer[currentOffset + 1]

            when {
                // 嵌套模板开始
                ch1 == '<' && ch2 == '$' -> {
                    currentOffset += 2
                    templateDepth++
                    tokenType = ValkyrieTokenTypes.TEMPLATE_START
                    return
                }
                // 模板结束
                ch1 == '$' && ch2 == '>' -> {
                    currentOffset += 2
                    templateDepth = max(0, templateDepth - 1)
                    tokenType = ValkyrieTokenTypes.TEMPLATE_END
                    return
                }
                // 模板内注释
                ch1 == '<' && ch2 == '#' -> {
                    skipBlockComment()
                    tokenType = ValkyrieTokenTypes.COMMENT_RANGE
                    return
                }
            }
        }

        // 如果不是特殊标记, 就是模板文本
        val textStart = currentOffset
        while (currentOffset < endOffset) {
            if (currentOffset + 1 < endOffset) {
                val ch1 = buffer[currentOffset]
                val ch2 = buffer[currentOffset + 1]
                if ((ch1 == '<' && ch2 == '$') || (ch1 == '$' && ch2 == '>') || (ch1 == '<' && ch2 == '#')) {
                    break
                }
            }
            currentOffset++
        }

        if (currentOffset > textStart) {
            tokenType = ValkyrieTokenTypes.TEMPLATE_TEXT
        } else {
            // We must be at the end of the buffer.
            tokenType = null
        }
    }

    // =================================================================
    // 其他辅助函数 (大部分保持不变或微调)
    // =================================================================
    private fun skipLineComment() {
        currentOffset++ // skip # or ⍝
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun skipBlockComment() {
        currentOffset += 2 // skip <#
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
        currentOffset += 2 // skip #?
        while (currentOffset < endOffset && buffer[currentOffset] != '\n') {
            currentOffset++
        }
    }

    private fun readRawIdentifier() {
        currentOffset++ // skip opening backtick
        val contentStart = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != '`') {
            currentOffset++
        }
        if (currentOffset < endOffset) {
            currentOffset++ // skip closing backtick
        }
        tokenType = if (currentOffset > contentStart + 1) ValkyrieTokenTypes.IDENTIFIER_RAW else BAD_CHARACTER
    }

    // readOperatorOrPunctuation 经过微调以处理模板启动
    private fun readOperatorOrPunctuation(ch: Char) {
        when (ch) {
            '<' -> {
                currentOffset++
                when (peek(0)) {
                    '=' -> {
                        currentOffset++; tokenType = ValkyrieTokenTypes.LESS_EQUAL
                    }

                    '{' -> {
                        currentOffset++; tokenType = ValkyrieTokenTypes.COMPILE_L
                    }
                    // 进入模板模式
                    '$' -> {
                        currentOffset++
                        templateDepth++
                        tokenType = ValkyrieTokenTypes.TEMPLATE_START
                    }

                    else -> {
                        tokenType = ValkyrieTokenTypes.ANGLE_L
                    }
                }
            }

            '$' -> {
                currentOffset++
                if (peek(0) == '>') {
                    currentOffset++
                    // 在正常模式下遇到 $>，安全地减少深度
                    templateDepth = max(0, templateDepth - 1)
                    tokenType = ValkyrieTokenTypes.TEMPLATE_END
                } else {
                    tokenType = BAD_CHARACTER
                }
            }

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
                    tokenType = ValkyrieTokenTypes.COMPILE_R
                } else {
                    tokenType = ValkyrieTokenTypes.BRACE_R
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