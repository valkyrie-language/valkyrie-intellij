package valkyrie.psi.lexers

import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.xml.XmlTokenType

/**
 * XML Valkyrie 词法分析器
 *
 * 用于解析声明式 UI 文件 (.vkx)
 * 支持 XML 标签语法和嵌入的 Valkyrie 表达式
 *
 * 示例：
 * ```
 * <div class="container">
 *   <h1>{ title }</h1>
 *   <p>Welcome, { user.name }!</p>
 *   <button onclick={ handleClick }>
 *     Click me
 *   </button>
 * </div>
 * ```
 */
class ValkyrieXmlLexer : ValkyrieLexerBase(LexerFlavor.XML) {

    // XML 特定状态
    companion object {
        private const val STATE_XML_TEXT = 1        // 解析 XML 标签间文本 (如 "Hello World")
        private const val STATE_XML_TAG = 2         // 解析 XML 标签内部 (如 "<div class='foo'>")
        // STATE_LANGUAGE (0) 继承自 ValkyrieLexerBase，用于解析嵌入的 Valkyrie 代码 ({...})
    }

    private var tagDepth: Int = 0       // XML 标签嵌套深度 <div> ... </div>
    // braceDepth 继承自基类，并由 base.getState() 返回

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)

        // initialState 现在只包含 braceDepth。
        // 如果 initialState 为 0，表示全新启动，通常用于文件开头。
        // 对于 .vkx 文件，我们默认从 XML_TEXT 模式开始。
        if (initialState == 0) {
            this.lexerState = STATE_XML_TEXT // 以 XML 文本模式启动 .vkx 文件
            this.tagDepth = 0 // 重置标签深度
        } else {
            // 如果从非 0 状态恢复，表示我们是从一个嵌入的 Valkyrie 表达式 ({...}) 中恢复。
            // super.start() 会恢复 braceDepth 并将 lexerState 设置为 STATE_LANGUAGE (0)。
            // tagDepth 在此模式下无法从 initialState 恢复，所以保持为 0。
            // 这种设计是根据请求移除 XML_DEPTH_SHIFT 的结果，它意味着 tagDepth 不在 getState() 中持久化。
            // 这可能会影响增量词法分析，但符合您的要求。
            this.lexerState = STATE_LANGUAGE // 假设我们处于嵌入代码中
            this.tagDepth = 0
        }
    }

    override fun getState(): Int {
        // 按照要求，XML_DEPTH_SHIFT 已移除。只返回基类的状态 (braceDepth)。
        return super.getState()
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processLanguage() // 处理嵌入的 Valkyrie 代码
            STATE_XML_TEXT -> processXmlText() // 处理 XML 文本、标签开始/结束、注释
            STATE_XML_TAG -> processXmlTag()   // 处理 XML 标签内的元素 (名称、属性)
            else -> processXmlText()           // 安全回退到 XML 文本模式
        }
    }

    /**
     * 覆盖基类的 processLanguage 方法。
     * 当 lexerState 为 STATE_LANGUAGE 时调用，用于解析嵌入在 XML 中的 Valkyrie 代码。
     * 特别处理 `{` 和 `}`，它们作为 XML 嵌入表达式的边界。
     */
    override fun processLanguage() {
        // 检查是否已退出嵌入的 Valkyrie 表达式块。
        // 如果 braceDepth 变为 0 且当前状态仍然是 STATE_LANGUAGE，并且文件尚未结束，
        // 则表示我们已完成嵌入表达式，应返回到 XML 文本模式。
        if (braceDepth == 0 && lexerState == STATE_LANGUAGE && currentOffset < endOffset) {
            lexerState = STATE_XML_TEXT
            processXmlText() // 立即处理 XML 文本状态下的下一个 token
            return
        }

        val ch = buffer[currentOffset]
        // 嵌入代码中遇到大括号时，使用 XML 专用 token 并管理状态
        if (ch == '{') {
            handleBraceStart()
            return
        } else if (ch == '}') {
            handleBraceEnd()
            return
        }

        // 对于嵌入 Valkyrie 表达式中的其他 Valkyrie 语言 token，委托给基类处理
        super.processLanguage()
    }


    /**
     * 处理 XML 文本区域 (STATE_XML_TEXT)。
     * 在 XML 标签之间解析纯文本、XML 注释、Valkyrie XML 块注释，并检测标签和嵌入表达式的开始。
     */
    private fun processXmlText() {
        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace() // XML 文本中的空白字符
            ch == '<' -> {
                // 检查各种 '<' 开头的模式
                val nextChars = peekAhead(4)
                if (nextChars?.startsWith("<!--") == true) { // <!-- 标准 XML 注释
                    skipBlockComment()
                } else if (peek(0) == '/') { // </ 结束标签
                    currentOffset += 2
                    currentTokenType = XmlTokenType.XML_END_TAG_START
                    tagDepth = (tagDepth - 1).coerceAtLeast(0) // 结束标签，深度减一
                    lexerState = STATE_XML_TAG // 转换到标签解析状态，以获取标签名
                } else if (peek(0)?.isLetter() == true || peek(0) == '_') { // <TagName 开始标签
                    currentOffset++
                    currentTokenType = XmlTokenType.XML_START_TAG_START
                    tagDepth++ // 开始标签，深度加一
                    lexerState = STATE_XML_TAG // 转换到标签解析状态，以获取标签名
                } else {
                    currentOffset++ // 仅仅是 '<' 符号，不构成有效 XML 结构
                    currentTokenType = BAD_CHARACTER
                }
            }

            ch == '{' -> handleBraceStart() // 嵌入的 Valkyrie 表达式开始
            else -> readXmlDataCharacters() // 默认读取 XML 文本数据
        }
    }

    /**
     * 处理 XML 标签内部区域 (STATE_XML_TAG)。
     * 解析标签名、属性名、等号、属性值，并检测标签的结束。
     */
    private fun processXmlTag() {
        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace() // 标签内的空白字符
            ch == '/' && peek(0) == '>' -> { // 自闭合标签结束: />
                currentOffset += 2
                currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
                tagDepth = (tagDepth - 1).coerceAtLeast(0) // 自闭合标签，深度减一
                lexerState = STATE_XML_TEXT // 返回 XML 文本模式
            }

            ch == '>' -> { // 标签结束: >
                currentOffset++
                currentTokenType = XmlTokenType.XML_TAG_END
                lexerState = STATE_XML_TEXT // 返回 XML 文本模式
            }

            ch.isLetter() || ch == '_' -> { // 标签名或属性名
                val idStart = currentOffset
                while (currentOffset < endOffset) {
                    val nextCh = buffer[currentOffset]
                    // XML 名称可以包含字母、数字、下划线、连字符、点
                    if (nextCh.isLetterOrDigit() || nextCh == '-' || nextCh == '_' || nextCh == '.') {
                        currentOffset++
                    } else {
                        break
                    }
                }
                currentTokenType = XmlTokenType.XML_TAG_NAME // 对于标签名和属性名，都使用 XML_TAG_NAME，解析器负责区分
            }

            ch == '=' -> { // 属性赋值符
                currentOffset++
                currentTokenType = XmlTokenType.XML_EQ
            }

            ch == '\'' || ch == '"' -> { // 属性值字符串
                startAttributeValue()
            }

            else -> {
                currentOffset++
                currentTokenType = BAD_CHARACTER
            }
        }
    }

    /**
     * 覆盖基类方法，确保在 XML 上下文中，{ 和 } 优先被 XML 处理。
     */
    override fun readOperatorOrPunctuation(ch: Char) {
        if (ch == '{') {
            handleBraceStart()
            return
        }
        if (ch == '}') {
            handleBraceEnd()
            return
        }
        // 对于其他操作符和标点符号，委托给基类处理
        super.readOperatorOrPunctuation(ch)
    }

    /**
     * 解析 XML 属性值字符串。
     */
    private fun startAttributeValue() {
        val delimiter = buffer[currentOffset]
        currentOffset++ // 消耗起始引号
        val valueStart = currentOffset

        while (currentOffset < endOffset && buffer[currentOffset] != delimiter && buffer[currentOffset] != '\n') {
            // 这里可以添加对转义序列（如 &amp;）的处理，但目前简化为直接消耗字符
            currentOffset++
        }

        if (currentOffset < endOffset && buffer[currentOffset] == delimiter) {
            currentOffset++ // 消耗结束引号
            currentTokenType = XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN
        } else {
            currentTokenType = BAD_CHARACTER // 未闭合的属性值字符串
        }
    }


    /**
     * 读取 XML 标签间的纯数据字符。
     */
    private fun readXmlDataCharacters() {
        val textStart = currentOffset
        // 消耗文本直到遇到 '<' (可能表示新标签或注释)、'{' (表示嵌入表达式) 或文件结束
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch == '<' || ch == '{') {
                break
            }
            currentOffset++
        }

        if (currentOffset > textStart) {
            currentTokenType = XmlTokenType.XML_DATA_CHARACTERS
        } else {
            currentTokenType = null // 没有文本可读，这通常意味着 advance() 的逻辑有问题
        }
    }

    /**
     * 覆盖基类方法，处理 Valkyrie 独有的 XML 块注释：<# ... #>
     * 支持嵌套。
     */
    override fun skipBlockComment() {
        currentOffset += 4 // 消耗 "<!--"
        currentTokenType = XmlTokenType.XML_COMMENT_START

        // 查找 "-->"
        val commentContentStart = currentOffset
        while (currentOffset + 2 < endOffset && !(buffer[currentOffset] == '-' && buffer[currentOffset + 1] == '-' && buffer[currentOffset + 2] == '>')) {
            currentOffset++
        }

        if (currentOffset > commentContentStart) { // 如果有注释文本内容
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS // 假设这部分是内容
        }

        // 检查是否找到结束符 "-->"
        if (currentOffset + 2 < endOffset && buffer[currentOffset] == '-' && buffer[currentOffset + 1] == '-' && buffer[currentOffset + 2] == '>') {
            currentOffset += 3 // 消耗 "-->"
            currentTokenType = XmlTokenType.XML_COMMENT_END
        } else {
            // 未闭合的注释
            currentTokenType = BAD_CHARACTER // 或者定义一个未闭合注释的特定 token
        }
    }


    // --- XML 嵌入表达式的特定大括号处理 ---
    private fun handleBraceStart() {
        currentOffset++
        braceDepth++
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_L // 使用 XmlTokenType 作为嵌入表达式的左大括号
        lexerState = STATE_LANGUAGE // 切换到 Valkyrie 语言模式，解析嵌入代码
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0) // 确保深度不小于 0
        currentTokenType = ValkyrieTokenTypes.XML_SLOT_R // 使用 XmlTokenType 作为嵌入表达式的右大括号

        // 如果 braceDepth 变为 0，表示嵌入的 Valkyrie 表达式结束
        if (braceDepth == 0) {
            lexerState = STATE_XML_TEXT // 返回 XML 文本模式
        }
    }
}