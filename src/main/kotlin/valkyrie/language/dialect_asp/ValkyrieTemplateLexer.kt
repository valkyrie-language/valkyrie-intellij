package valkyrie.language.dialect_asp

import valkyrie.psi.lexers.LexerFlavor
import valkyrie.psi.lexers.ValkyrieLexerBase
import valkyrie.psi.lexers.ValkyrieTokenTypes


// 块开启关键字（会增加嵌套深度）
private val blockOpeningKeywords = setOf("if", "for", "while", "loop", "match", "scope", "try", "class", "struct")

// 块关闭关键字（会减少嵌套深度）
private val blockClosingKeywords = setOf("end")

/**
 * Template Valkyrie 词法分析器
 *
 * 用于解析模板文件 (.vkt)
 * 支持文本内容和嵌入的 Valkyrie 表达式
 *
 * 示例：
 * ```
 * Hello, <% user.name %>!
 *
 * Your balance is: <% format_currency(account.balance) %>
 *
 * <% if user.is_premium %>
 *   Welcome to Premium!
 * <% else %>
 *   Upgrade to Premium for more features.
 * <% end %>
 * ```
 */
class ValkyrieTemplateLexer : ValkyrieLexerBase(LexerFlavor.TEMPLATE) {
    companion object {
        private const val STATE_TEMPLATE_TEXT = 4   // 解析模板文本
        private const val STATE_MARK_TEXT = 5       // 解析标记文本 <$ $>
        private const val TEMPLATE_DEPTH_SHIFT = 16
    }

    // Template 特定状态
    private var templateDepth: Int = 0  // 模板嵌套深度 {% if %} ... {% endif %}

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)
        
        if (initialState == 0) {
            // Template 文件默认从模板文本模式开始
            this.lexerState = STATE_TEMPLATE_TEXT
            this.templateDepth = 0
        } else {
            // 从之前的状态恢复 - 移除 STATE_MASK，直接使用位移
            this.templateDepth = initialState shr TEMPLATE_DEPTH_SHIFT
        }
    }

    override fun getState(): Int {
        return (templateDepth shl TEMPLATE_DEPTH_SHIFT) or super.getState()
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            STATE_TEMPLATE_TEXT -> processTemplateText()
            STATE_MARK_TEXT -> processMarkText()
            else -> processTemplateText() // 安全回退
        }
    }

    override fun processLanguage() {
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
                skipLineComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' && peek() == '?' -> {
                skipDocComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_DOCUMENT
            }

            ch == '#' -> {
                skipLineComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_LINE
            }

            ch == '<' && peek() == '#' -> {
                skipBlockComment(); currentTokenType = ValkyrieTokenTypes.COMMENT_RANGE
            }

            ch.isLetter() || ch == '_' -> readIdentifier()
            ch.isDigit() -> readNumber()
            ch == '"' || ch == '\'' -> startString()
            ch == '`' -> readRawIdentifier()

            // Template 特定的边界标记处理
            ch == '{' && peek() == '%' -> handleTemplateStart()
            ch == '%' && peek() == '}' -> handleTemplateEnd()
            ch == '{' -> handleBraceStart()
            ch == '}' -> handleBraceEnd()

            else -> readOperatorOrPunctuation(ch)
        }
    }

    /**
     * 处理模板文本（普通文本内容）
     */
    private fun processTemplateText() {
        // 如果遇到 '{%' 或 '{'，切换到语言模式
        if (peek(0) == '{' && (peek(1) == '%' || peek(1) != '{')) {
            lexerState = STATE_LANGUAGE
            return
        }

        // 读取文本直到下一个 '{' 或文件末尾
        val textStart = currentOffset
        while (currentOffset < endOffset && peek(0) != '{') {
            currentOffset++
        }

        if (currentOffset > textStart) {
            currentTokenType = ValkyrieTokenTypes.TEMPLATE_TEXT
        } else {
            currentTokenType = null
        }
    }

    /**
     * 处理标记文本（{% ... %} 内的内容）
     */
    private fun processMarkText() {
        // 如果遇到 '%}'，切换到模板文本模式
        if (peek(0) == '%' && peek(1) == '}') {
            lexerState = STATE_TEMPLATE_TEXT
            return
        }

        // 在标记内部，使用语言模式解析
        processLanguage()
    }

    private fun handleTemplateStart() {
        currentOffset += 2  // 跳过 '{%'
        templateDepth++
        currentTokenType = ValkyrieTokenTypes.TEMPLATE_START
        lexerState = STATE_MARK_TEXT
    }

    private fun handleTemplateEnd() {
        currentOffset += 2  // 跳过 '%}'
        templateDepth = (templateDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.TEMPLATE_END
        lexerState = STATE_TEMPLATE_TEXT
    }

    private fun handleBraceStart() {
        currentOffset++
        braceDepth++
        currentTokenType = ValkyrieTokenTypes.BRACE_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.BRACE_R

        // 表达式结束，返回模板文本状态
        if (braceDepth == 0) {
            lexerState = STATE_TEMPLATE_TEXT
        }
    }
}