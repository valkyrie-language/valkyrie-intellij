package valkyrie.psi.lexers

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Valkyrie SFC 词法分析器
 * 用于解析 Valkyrie 组件文件（.vx）
 */
class ValkyrieSfcLexer : ValkyrieLexer(ValkyrieLanguageConfig()) {

    companion object {
        // SFC 特定的词法分析器状态
        protected const val STATE_LANGUAGE = 0 // 默认状态
        protected const val STATE_XML_TAG = 1 // XML 标签状态
        protected const val STATE_TEMPLATE_CONTENT = 2 // Template 内容状态
        protected const val STATE_SCRIPT_CONTENT = 3 // Script 内容状态
        protected const val STATE_STYLE_CONTENT = 4 // Style 内容状态
    }

    // 当前处理的标签名
    private var currentTag: String? = null

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage()
            STATE_XML_TAG -> processXmlTag()
            STATE_TEMPLATE_CONTENT -> processTemplateContent()
            STATE_SCRIPT_CONTENT -> processScriptContent()
            STATE_STYLE_CONTENT -> processStyleContent()
            else -> processLanguage()
        }
    }

    /**
     * 处理 Valkyrie 语言代码
     */
    override fun processLanguage() {
        // 优先处理多-token 状态
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
                skipLineComment()
                currentTokenType = ValkyrieTypes.COMMENT_DOCUMENT
            }
            ch == '#' && peek() == '?' -> {
                skipDocComment()
                currentTokenType = ValkyrieTypes.COMMENT_DOCUMENT
            }
            ch == '#' -> {
                skipLineComment()
                currentTokenType = ValkyrieTypes.COMMENT_LINE
            }
            ch.isLetter() || ch == '_' -> readIdentifier()
            ch.isDigit() -> readNumber()
            ch == '"' || ch == '\'' -> startString()
            ch == '`' -> readRawIdentifier()
            ch == '<' -> {
                // 检查是否是 XML 标签开始
                val nextChar = peek(1)
                if (nextChar != null && (nextChar.isLetter() || nextChar == '/')) {
                    lexerState = STATE_XML_TAG
                    currentOffset++
                    currentTokenType = ValkyrieTypes.ANGLE_L
                } else {
                    readOperatorOrPunctuation(ch)
                }
            }
            else -> readOperatorOrPunctuation(ch)
        }
    }

    /**
     * 处理 XML 标签
     */
    protected fun processXmlTag() {
        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace()
            ch == '>' -> {
                currentOffset++
                currentTokenType = ValkyrieTypes.ANGLE_R
                // 根据标签名切换到相应的内容状态
                when (currentTag) {
                    "template" -> lexerState = STATE_TEMPLATE_CONTENT
                    "script" -> lexerState = STATE_SCRIPT_CONTENT
                    "style" -> lexerState = STATE_STYLE_CONTENT
                    else -> lexerState = STATE_LANGUAGE
                }
            }
            ch == '/' && peek(1) == '>' -> {
                currentOffset += 2
                currentTokenType = ValkyrieTypes.SLASH
                lexerState = STATE_LANGUAGE
            }
            ch == '<' -> {
                currentOffset++
                currentTokenType = ValkyrieTypes.ANGLE_L
            }
            ch == '/' -> {
                currentOffset++
                currentTokenType = ValkyrieTypes.SLASH
                // 结束标签，切换回默认状态
                lexerState = STATE_LANGUAGE
            }
            ch.isLetter() || ch == '_' -> {
                // 解析标签名
                val start = currentOffset
                while (currentOffset < endOffset && (buffer[currentOffset].isLetterOrDigit() || buffer[currentOffset] == '_')) {
                    currentOffset++
                }
                currentTag = buffer.substring(start, currentOffset)
                currentTokenType = ValkyrieTypes.SYMBOL_XID
            }
            ch == '"' || ch == '\'' -> startString()
            ch == '=' -> {
                currentOffset++
                currentTokenType = ValkyrieTypes.ASSIGN
            }
            else -> {
                currentOffset++
                currentTokenType = TokenType.BAD_CHARACTER
            }
        }
    }

    /**
     * 处理 Template 内容
     */
    protected fun processTemplateContent() {
        // 查找下一个标签开始
        val start = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != '<') {
            currentOffset++
        }

        if (currentOffset < endOffset && buffer[currentOffset] == '<') {
            lexerState = STATE_XML_TAG
            currentOffset++
            currentTokenType = ValkyrieTypes.ANGLE_L
        } else {
            currentTokenType = null
        }
    }

    /**
     * 处理 Script 内容
     */
    protected fun processScriptContent() {
        // 查找下一个标签开始
        val start = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != '<') {
            currentOffset++
        }

        if (currentOffset < endOffset && buffer[currentOffset] == '<') {
            lexerState = STATE_XML_TAG
            currentOffset++
            currentTokenType = ValkyrieTypes.ANGLE_L
        } else {
            currentTokenType = null
        }
    }

    /**
     * 处理 Style 内容
     */
    protected fun processStyleContent() {
        // 查找下一个标签开始
        val start = currentOffset
        while (currentOffset < endOffset && buffer[currentOffset] != '<') {
            currentOffset++
        }

        if (currentOffset < endOffset && buffer[currentOffset] == '<') {
            lexerState = STATE_XML_TAG
            currentOffset++
            currentTokenType = ValkyrieTypes.ANGLE_L
        } else {
            currentTokenType = null
        }
    }
}
