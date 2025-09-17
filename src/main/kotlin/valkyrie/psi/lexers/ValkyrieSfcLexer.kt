package valkyrie.psi.lexers

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import java.util.*

/**
 * Component Valkyrie 词法分析器
 *
 * 用于解析组件定义文件 (.vkc)。
 * 核心设计变更：
 * 1. 默认状态是 XML 文本解析，而不是 Valkyrie 语言解析。
 * 2. 将 <template>, <script>, <style> 视为特殊的 XML 关键字标签。
 * 3. 简化了标签和属性名称的解析，不再过度解析为 Valkyrie token。
 * 4. 移除了关闭标签的匹配逻辑，遵循 Lexer 的职责。
 */
class ValkyrieSfcLexer : ValkyrieLexerBase(LexerFlavor.COMPONENT) {
    private companion object {
        // STATE_LANGUAGE (0) 继承自基类, 用于 { ... } 和 <script> 内部
        private const val STATE_XML_TEXT = 1         // 默认状态：标签之间的内容
        private const val STATE_XML_TAG = 2          // 标签 <...> 内部
        private const val STATE_SCRIPT_CONTENT = 3   // <script> 标签内的内容
        private const val STATE_STYLE_CONTENT = 4    // <style> 标签内的内容

        val VOID_TAGS = setOf(
            "area", "base", "br", "col", "embed", "hr", "img", "input",
            "link", "meta", "param", "source", "track", "wbr"
        )

        val SPECIAL_TAGS = mapOf(
            "template" to ValkyrieTokenTypes.XML_TEMPLATE,
            "script" to ValkyrieTokenTypes.XML_SCRIPT,
            "style" to ValkyrieTokenTypes.XML_STYLE
        )
    }

    private val tagStack: Deque<String> = ArrayDeque()
    private var isExpectingTagName = false
    private var attributeQuote: Char? = null
    private var storedLexerState: Int = STATE_XML_TEXT

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        // 注意：这里的 initialState 仍然来自 ValkyrieLexerBase 的 braceDepth，但对于 SFC 文件，
        // 我们总是从 XML 文本状态开始，除非 IntelliJ 恢复了某个特定状态。
        super.start(buffer, startOffset, endOffset, initialState)
        tagStack.clear()
        // *** 核心变更：默认状态是 STATE_XML_TEXT ***
        lexerState = STATE_XML_TEXT
        isExpectingTagName = false
        attributeQuote = null
        storedLexerState = STATE_XML_TEXT
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_XML_TEXT -> processXmlText()
            STATE_XML_TAG -> processXmlTag()
            STATE_SCRIPT_CONTENT -> processForeignContent("script", ValkyrieTokenTypes.SCRIPT_CONTENT)
            STATE_STYLE_CONTENT -> processForeignContent("style", ValkyrieTokenTypes.STYLE_CONTENT)
            // STATE_LANGUAGE 由嵌入代码块 { ... } 触发
            STATE_LANGUAGE -> processEmbeddedValkyrie()
            else -> { // 安全回退
                lexerState = STATE_XML_TEXT
                processXmlText()
            }
        }
    }

    /**
     * 处理嵌入的 Valkyrie 代码块，例如 { ... }
     */
    private fun processEmbeddedValkyrie() {
        if (buffer[currentOffset] == '}') {
            handleBraceEnd()
        } else {
            // 使用基类的 Valkyrie 解析逻辑
            super.processLanguage()
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。这是文件的默认状态。
     */
    private fun processXmlText() {
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            return
        }

        when (buffer[currentOffset]) {
            '<' -> if (isStartOfTag()) handleXmlTagStart() else readTextContent()
            '{' -> handleBraceStart()
            else -> readTextContent()
        }
    }

    private fun readTextContent() {
        val contentStart = currentOffset
        while (currentOffset < endOffset) {
            // 查找下一个有意义的分隔符
            if (buffer[currentOffset] == '<' && isStartOfTag()) break
            if (buffer[currentOffset] == '{') break
            if (peekAhead(4) == "<!--") break
            currentOffset++
        }

        if (currentOffset > contentStart) {
            // 所有非标签、非注释、非嵌入块的文本都是 XML_TEXT
            currentTokenType = ValkyrieTokenTypes.XML_TEXT
        } else {
            // 如果没有内容可读（例如在 '<div></div>' 的中间），则必须推进状态机
            // 这种情况通常由 `processXmlText` 的调用者处理，所以我们再次调用 advance
            if (currentOffset < endOffset) {
                advance()
            } else {
                currentTokenType = null
            }
        }
    }

    /**
     * 状态 2: 处理 XML 标签内部 (<...>)。
     */
    private fun processXmlTag() {
        // 优先处理属性字符串值
        if (attributeQuote != null) {
            processAttributeValue()
            return
        }

        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace()
            // 标签名或属性名
            ch.isLetter() || ch == '_' -> readXmlName()
            ch == '=' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.ASSIGN
            }

            ch == '"' || ch == '\'' -> startAttributeValue(ch)
            ch == '>' -> handleTagClose()
            ch == '/' && peek() == '>' -> handleSelfClosingTag()
            ch == '{' -> handleBraceStart() // 支持 <div class={my_class}>
            // 支持 package::name 这样的属性名
            ch == ':' || ch == '-' -> readXmlName() // 允许以 : 或 - 开头的名称部分
            else -> {
                // 如果遇到无法识别的字符，例如在 `let node = <hr> + <hr/>` 中的 `+`
                // 将其视为 BAD_CHARACTER 并切换回 XML_TEXT 状态，让 parser 决定如何处理
                lexerState = STATE_XML_TEXT
                currentOffset++
                currentTokenType = TokenType.BAD_CHARACTER
            }
        }
    }

    private fun handleTagClose() {
        currentOffset++
        currentTokenType = ValkyrieTokenTypes.ANGLE_R
        val tagName = tagStack.peek()?.lowercase()

        when {
            isVoidTag(tagName) -> {
                tagStack.pop() // 自闭合，立即出栈
                lexerState = if (tagStack.isEmpty()) STATE_XML_TEXT else STATE_XML_TEXT
            }

            tagName == "script" -> lexerState = STATE_SCRIPT_CONTENT
            tagName == "style" -> lexerState = STATE_STYLE_CONTENT
            else -> lexerState = STATE_XML_TEXT
        }
    }

    private fun handleSelfClosingTag() {
        currentOffset += 2
        currentTokenType = XmlTokenType.XML_EMPTY_ELEMENT_END
        if (tagStack.isNotEmpty()) {
            tagStack.pop()
        }
        lexerState = STATE_XML_TEXT
    }

    /**
     * 状态 3 & 4: 处理 <script> 或 <style> 的内容
     */
    private fun processForeignContent(tagName: String, tokenType: IElementType) {
        val endTag = "</$tagName"
        val contentStart = currentOffset
        var endPos = -1
        var searchPos = currentOffset
        while (searchPos < endOffset) {
            val potentialPos = buffer.indexOf(endTag, searchPos, ignoreCase = true)
            if (potentialPos == -1) break

            val charAfter = peek(potentialPos + endTag.length - currentOffset)
            if (charAfter == null || charAfter.isWhitespace() || charAfter == '>') {
                endPos = potentialPos
                break
            }
            searchPos = potentialPos + 1
        }

        currentOffset = if (endPos != -1) endPos else endOffset

        if (currentOffset > contentStart) {
            currentTokenType = tokenType
        } else {
            // 空内容块，直接处理结束标签
            handleXmlTagStart()
        }
    }

    private fun processAttributeValue() {
        when (buffer[currentOffset]) {
            attributeQuote -> {
                currentOffset++
                currentTokenType = ValkyrieTokenTypes.STRING_END
                attributeQuote = null
            }

            '{' -> handleBraceStart()
            else -> {
                val valueStart = currentOffset
                while (currentOffset < endOffset) {
                    val c = buffer[currentOffset]
                    if (c == attributeQuote || c == '{') break
                    currentOffset++
                }
                if (currentOffset > valueStart) {
                    currentTokenType = ValkyrieTokenTypes.STRING_TEXT
                } else {
                    // 空属性值 " " 或 ""，会导致死循环，所以要推进
                    advance()
                }
            }
        }
    }

    // -- 辅助方法 --

    private fun isStartOfTag(): Boolean {
        if (currentOffset + 1 >= endOffset) return false
        val next = buffer[currentOffset + 1]
        // <tag, </tag, <!--
        return next.isLetter() || next == '_' || next == '/' || (next == '!' && peek(2) == '-' && peek(3) == '-')
    }

    private fun isVoidTag(tagName: String?): Boolean = tagName != null && VOID_TAGS.contains(tagName)

    private fun handleXmlTagStart() {
        isExpectingTagName = true
        if (peek() == '/') {
            currentOffset += 2 // Consume '</'
            currentTokenType = XmlTokenType.XML_END_TAG_START
        } else {
            currentOffset++ // Consume '<'
            currentTokenType = ValkyrieTokenTypes.ANGLE_L
        }
        lexerState = STATE_XML_TAG
    }

    private fun handleBraceStart() {
        storedLexerState = lexerState
        currentOffset++
        braceDepth++
        currentTokenType = ValkyrieTokenTypes.BRACE_L
        lexerState = STATE_LANGUAGE
    }

    private fun handleBraceEnd() {
        currentOffset++
        braceDepth = (braceDepth - 1).coerceAtLeast(0)
        currentTokenType = ValkyrieTokenTypes.BRACE_R
        // 恢复到进入 { 之前的状态
        lexerState = if (braceDepth == 0) storedLexerState else STATE_LANGUAGE
    }

    private fun startAttributeValue(delimiter: Char) {
        attributeQuote = delimiter
        currentOffset++
        currentTokenType = ValkyrieTokenTypes.STRING_START
    }

    private fun readXmlName() {
        val idStart = currentOffset
        // XML 属性和标签名可以包含更多字符
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (ch.isLetterOrDigit() || ch in "_-.:") {
                currentOffset++
            } else {
                break
            }
        }

        if (currentOffset > idStart) {
            val name = buffer.subSequence(idStart, currentOffset).toString()
            if (isExpectingTagName) {
                // *** 核心变更：识别特殊标签 ***
                currentTokenType = SPECIAL_TAGS[name.lowercase()] ?: XmlTokenType.XML_TAG_NAME

                val isClosingTag = startOffset > 0 && buffer[startOffset - 1] == '/'
                if (isClosingTag) {
                    // *** 核心变更：不进行匹配，仅出栈 ***
                    if (tagStack.isNotEmpty()) {
                        tagStack.pop()
                    }
                } else {
                    tagStack.push(name)
                }
                isExpectingTagName = false
            } else {
                // 这是一个属性名
                currentTokenType = XmlTokenType.XML_NAME
            }
        } else {
            // 无法读取名称，这是一个错误
            currentOffset++
            currentTokenType = TokenType.BAD_CHARACTER
        }
    }

    private fun skipXmlComment() {
        // 使用 XmlTokenType 以便获得更好的 IDE 高亮
        val commentStart = startOffset
        currentOffset += 4 // "<!--"
        val endPos = buffer.indexOf("-->", currentOffset)

        startOffset = commentStart
        if (endPos != -1) {
            currentOffset = endPos + 3
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
        } else {
            // 未闭合的注释
            currentOffset = endOffset
            currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
        }
    }
}