package valkyrie.psi.lexers

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import java.util.*

/**
 * Component Valkyrie 词法分析器
 *
 * 用于解析组件定义文件 (.vkc)
 * 支持类 XML 语法、嵌入的 Valkyrie 表达式，以及 <script> 和 <style> 块。
 */
class ValkyrieSfcLexer : ValkyrieLexerBase(LexerFlavor.COMPONENT) {
    private companion object {
        // STATE_LANGUAGE (0) 继承自基类，是我们的初始和顶层状态
        private const val STATE_XML_TEXT = 1         // 标签之间的内容
        private const val STATE_XML_TAG = 2          // 标签 <...> 内部
        private const val STATE_SCRIPT_CONTENT = 3   // <script> 标签内的内容
        private const val STATE_STYLE_CONTENT = 4    // <style> 标签内的内容
    }

    // 使用一个栈来正确处理嵌套标签
    private val tagStack: Deque<String> = ArrayDeque()
    private var isExpectingTagName = false
    private var attributeQuote: Char? = null

    // 用于在 { ... } 嵌入块中保存和恢复状态
    private var storedLexerState: Int = STATE_LANGUAGE

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        super.start(buffer, startOffset, endOffset, initialState)
        // 每次 start 都必须重置所有 XML 特定状态
        tagStack.clear()
        lexerState = STATE_LANGUAGE // 总是从顶层语言状态开始
        isExpectingTagName = false
        attributeQuote = null
        storedLexerState = STATE_LANGUAGE
    }

    override fun advance() {
        if (currentOffset >= endOffset) {
            currentTokenType = null
            return
        }
        startOffset = currentOffset

        when (lexerState) {
            STATE_LANGUAGE -> processValkyrieOrTopLevel()
            STATE_XML_TAG -> processXmlTag()
            STATE_XML_TEXT -> processXmlText()
            STATE_SCRIPT_CONTENT -> processForeignContent("script", ValkyrieTokenTypes.SCRIPT_CONTENT)
            STATE_STYLE_CONTENT -> processForeignContent("style", ValkyrieTokenTypes.STYLE_CONTENT)
            else -> { // 安全回退
                lexerState = STATE_LANGUAGE
                processValkyrieOrTopLevel()
            }
        }
    }

    /**
     * 状态 0: 处理顶层 Valkyrie 代码，并检测 XML 块的开始。
     */
    private fun processValkyrieOrTopLevel() {
        // 优先检查 XML 注释，即使在顶层
        if (peekAhead(4) == "<!--") {
            skipXmlComment()
            return
        }

        val ch = buffer[currentOffset]
        // 只有当不在嵌入代码块中时，才将 '<' 视为潜在的 XML 标签起始
        if (ch == '<' && braceDepth == 0 && isStartOfTag()) {
            handleXmlTagStart()
        } else {
            // 否则，它只是一个比较运算符或泛型，由基类处理
            super.processLanguage()
        }
    }

    /**
     * 状态 1: 处理 XML 标签之间的文本内容。
     */
    private fun processXmlText() {
        // 优先检查 XML 注释
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
        // 读取直到下一个特殊字符
        while (currentOffset < endOffset) {
            if (buffer[currentOffset] == '<' && isStartOfTag()) break
            if (buffer[currentOffset] == '{') break
            if (peekAhead(4) == "<!--") break
            currentOffset++
        }

        if (currentOffset > contentStart) {
            currentTokenType = ValkyrieTokenTypes.XML_TEXT
        } else {
            // 如果没有内容，我们不能卡住，需要继续前进。
            // 这种情况可能发生在 `<div></div>`，当前指针在第一个 `>` 之后
            advance()
        }
    }

    /**
     * 状态 2: 处理 XML 标签内部 (<...>)。
     */
    private fun processXmlTag() {
        // 优先处理嵌入代码块
        if (braceDepth > 0) {
            if (buffer[currentOffset] == '}') handleBraceEnd() else super.processLanguage()
            return
        }
        // 优先处理属性字符串
        if (attributeQuote != null) {
            processAttributeValue()
            return
        }

        val ch = buffer[currentOffset]
        when {
            ch.isWhitespace() -> readWhitespace()
            // 使用 isExpectingTagName 状态来决定 token 类型
            ch.isLetter() || ch == '_' -> readXmlName()
            ch == '=' -> {
                currentOffset++; currentTokenType = ValkyrieTokenTypes.ASSIGN
            }

            ch == '"' || ch == '\'' -> startAttributeValue(ch)

            ch == '>' -> {
                currentOffset++
                currentTokenType = ValkyrieTokenTypes.ANGLE_R
                val tagName = tagStack.peek()?.lowercase()
                when {
                    // 对于 void tags，它们不会改变状态，因为它们立即“关闭”
                    isVoidTag(tagName) -> {
                        tagStack.pop()
                        lexerState = if (tagStack.isEmpty()) STATE_LANGUAGE else STATE_XML_TEXT
                    }

                    tagName == "script" -> lexerState = STATE_SCRIPT_CONTENT
                    tagName == "style" -> lexerState = STATE_STYLE_CONTENT
                    else -> lexerState = if (tagStack.isEmpty()) STATE_LANGUAGE else STATE_XML_TEXT
                }
            }

            ch == '/' && peek() == '>' -> {
                currentOffset += 2
                currentTokenType = XmlTokenType.XML_TAG_END
                if (tagStack.isNotEmpty()) tagStack.pop()
                lexerState = if (tagStack.isEmpty()) STATE_LANGUAGE else STATE_XML_TEXT
            }

            ch == '{' -> handleBraceStart()
            // 允许 `::` 在属性名中
            ch == ':' && peek() == ':' -> {
                currentOffset += 2; currentTokenType = ValkyrieTokenTypes.DOUBLE_COLON
            }
            // 其他情况，让基类处理，例如 `+` in `<hr> + <hr/>`
            else -> super.processLanguage()
        }
    }

    /**
     * 状态 3 & 4: 处理 <script> 或 <style> 的内容
     */
    private fun processForeignContent(tagName: String, tokenType: IElementType) {
        val endTag = "</$tagName"
        val contentStart = currentOffset

        // 查找闭合标签，忽略大小写
        var endPos = -1
        var searchPos = currentOffset
        while (searchPos < endOffset) {
            val potentialPos = buffer.indexOf(endTag, searchPos, ignoreCase = true)
            if (potentialPos == -1) break

            // 确保找到的是一个完整的标签，而不是像 `</scripting>` 这样的东西
            val charAfter = peek(potentialPos + endTag.length - currentOffset)
            if (charAfter == null || charAfter.isWhitespace() || charAfter == '>') {
                endPos = potentialPos
                break
            }
            searchPos = potentialPos + 1
        }


        if (endPos != -1) {
            currentOffset = endPos
        } else {
            // 未闭合的块，消费到最后
            currentOffset = endOffset
        }

        if (currentOffset > contentStart) {
            currentTokenType = tokenType
        } else {
            // 如果块为空，则直接查找结束标签
            handleXmlTagStart()
        }
    }

    private fun processAttributeValue() {
        val ch = buffer[currentOffset]
        if (ch == attributeQuote) {
            currentOffset++
            currentTokenType = ValkyrieTokenTypes.STRING_END
            attributeQuote = null
            return
        }
        if (ch == '{') {
            handleBraceStart()
            return
        }

        val valueStart = currentOffset
        while (currentOffset < endOffset) {
            val c = buffer[currentOffset]
            if (c == attributeQuote || c == '{') break
            currentOffset++
        }

        if (currentOffset > valueStart) {
            currentTokenType = ValkyrieTokenTypes.STRING_TEXT
        } else {
            // 空属性值 " " 或 ""
            advance()
        }
    }

    // -- 辅助方法 --

    private fun isStartOfTag(): Boolean {
        if (currentOffset + 1 >= endOffset) return false
        val next = buffer[currentOffset + 1]
        if (next.isLetter() || next == '_') return true
        if (next == '/') {
            if (currentOffset + 2 >= endOffset) return false
            val afterSlash = buffer[currentOffset + 2]
            return afterSlash.isLetter() || afterSlash == '_'
        }
        return next == '!' && peek(2) == '-' && peek(3) == '-'
    }

    private fun isVoidTag(tagName: String?): Boolean {
        return tagName in setOf("area", "base", "br", "col", "embed", "hr", "img", "input", "link", "meta", "param", "source", "track", "wbr")
    }

    private fun handleXmlTagStart() {
        isExpectingTagName = true
        if (peek() == '/') {
            currentOffset += 2
            currentTokenType = XmlTokenType.XML_END_TAG_START
        } else {
            currentOffset++
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
        lexerState = if (braceDepth == 0) storedLexerState else STATE_LANGUAGE
    }

    private fun startAttributeValue(delimiter: Char) {
        attributeQuote = delimiter
        currentOffset++
        currentTokenType = ValkyrieTokenTypes.STRING_START
    }

    private fun readXmlName() {
        val idStart = currentOffset
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            // XML 名称可以包含 -, _, :, 和 .
            if (ch.isLetterOrDigit() || ch in "_-.:") {
                currentOffset++
            } else {
                break
            }
        }

        if (currentOffset > idStart) {
            val name = buffer.subSequence(idStart, currentOffset).toString()
            if (isExpectingTagName) {
                if (tagStack.isNotEmpty() && buffer[startOffset - 2] == '/') {
                    // This is a closing tag name, like `</div>`
                    if (tagStack.peek()?.equals(name, ignoreCase = true) == true) {
                        tagStack.pop()
                    }
                } else {
                    // This is an opening tag name
                    tagStack.push(name)
                }
                currentTokenType = XmlTokenType.XML_TAG_NAME
                isExpectingTagName = false
            } else {
                currentTokenType = XmlTokenType.XML_NAME
            }
        } else {
            currentOffset++
            currentTokenType = TokenType.BAD_CHARACTER
        }
    }

    private fun skipXmlComment() {
        val commentStart = startOffset
        val endPos = buffer.indexOf("-->", currentOffset + 4)
        currentOffset = if (endPos != -1) endPos + 3 else endOffset
        startOffset = commentStart
        currentTokenType = XmlTokenType.XML_COMMENT_CHARACTERS
    }
}