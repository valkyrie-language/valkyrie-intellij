package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.xml.XmlElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

// 包含了特殊标签名和普通标签名
private val TAG_NAME_TOKENS = TokenSet.create(
    XmlTokenType.XML_TAG_NAME,
    ValkyrieTokenTypes.XML_TEMPLATE,
    ValkyrieTokenTypes.XML_SCRIPT,
    ValkyrieTokenTypes.XML_STYLE
)

// HTML5 void elements, 不需要结束标签
private val VOID_ELEMENTS = setOf(
    "area", "base", "br", "col", "embed", "hr", "img", "input",
    "link", "meta", "param", "source", "track", "wbr"
)

// 可以包含文本内容的 Token
private val XML_TEXT_TOKENS = TokenSet.create(
    XmlTokenType.XML_DATA_CHARACTERS,
    XmlTokenType.XML_WHITE_SPACE,
    ValkyrieTokenTypes.XML_TEXT // 确保我们的自定义 Token 也被包含
)


/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 采用了宿主语言 (Valkyrie) + 扩展点注入 (XML 表达式) 的架构
 */
class ValkyrieSfcParser : ValkyrieParser() {
    /**
     * [核心重构 1] SFC 文件的顶层解析逻辑
     * 只处理顶层的 <template>, <script>, <style> 块、注释和空白
     */
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseTopLevelBlock(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                XmlTokenType.XML_WHITE_SPACE -> builder.advanceLexer()
                // 顶层只允许这三类，其他都是错误
                else -> {
                    val errorMarker = builder.mark()
                    builder.advanceLexer()
                    errorMarker.error("Unexpected token at top level. Only <template>, <script>, <style>, comments, and whitespace are allowed.")
                }
            }
            // 防止解析器卡住
            if (!builder.eof() && builder.currentOffset == initialPosition) {
                builder.mark().error("Parser stalled at top level")
                builder.advanceLexer()
            }
        }
        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * [核心重构 2] 通过扩展点注入 SFC 特有的语句
     * 例如 `properties`, `emits`
     */
    override fun parseStatementExtension(builder: PsiBuilder): Boolean {
        return when (builder.tokenType) {
            ValkyrieTokenTypes.SFC_PROPERTY -> parseSfcPropertyStatement(builder)
            ValkyrieTokenTypes.SFC_EMITS -> parseSfcEmitsStatement(builder)
            else -> false
        }
    }

    /**
     * [核心重构 3] 通过扩展点将 XML 元素解析注入为 Valkyrie 表达式
     * 这是实现 JSX-like 语法的关键
     */
    override fun parseExpressionExtension(builder: PsiBuilder): Boolean {
        if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
            val marker = builder.mark()
            parseXmlElement(builder)
            marker.done(ValkyrieElementTypes.XML_ELEMENT)
            return true
        }
        return false
    }

    // --- SFC 特有语句解析 ---

    private fun parseSfcPropertyStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 'properties' or 'props'
        if (!parseObjectBody(builder)) {
            builder.error("Expected object body for properties")
        }
        marker.done(ValkyrieElementTypes.OBJECT_BODY)
        return true
    }

    private fun parseSfcEmitsStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 'emits'
        if (!parseObjectBody(builder)) {
            builder.error("Expected object body for emits")
        }
        marker.done(ValkyrieElementTypes.OBJECT_BODY)
        return true
    }

    // --- 顶层块解析 ---

    private fun parseTopLevelBlock(builder: PsiBuilder) {
        // 预读标签名以确定块类型
        val tagNameToken = builder.lookAhead(1)
        val tagName = builder.lookAhead(1)?.toString()

        val blockType = when (tagNameToken) {
            ValkyrieTokenTypes.XML_TEMPLATE -> ValkyrieElementTypes.SFC_TEMPLATE
            ValkyrieTokenTypes.XML_SCRIPT -> ValkyrieElementTypes.SFC_SCRIPT
            ValkyrieTokenTypes.XML_STYLE -> ValkyrieElementTypes.SFC_STYLE
            else -> null
        }

        if (blockType != null) {
            val blockMarker = builder.mark()
            parseBlock(builder, tagName, blockType)
            blockMarker.done(blockType)
        } else {
            val errorMarker = builder.mark()
            parseXmlElement(builder) // 仍然解析它，但标记为错误，避免解析器卡住
            errorMarker.error("Only <template>, <script>, or <style> tags are allowed at the top level.")
        }
    }

    private fun parseBlock(builder: PsiBuilder, tagName: String?, blockType: IElementType) {
        // 1. 解析开始标签
        parseStartTag(builder)

        // 2. 处理自闭合或 void 元素
        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer() // 消费 '/>'
            return
        }
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer() // 消费 '>'
        }

        // 3. 根据块类型分发内容解析器
        when (blockType) {
            ValkyrieElementTypes.SFC_SCRIPT -> parseScriptContent(builder, tagName)
            ValkyrieElementTypes.SFC_TEMPLATE -> parseTemplateContent(builder, tagName)
            ValkyrieElementTypes.SFC_STYLE -> parseStyleContent(builder, tagName)
            else -> {} // 不应该发生
        }

        // 4. 解析结束标签
        parseEndTag(builder, tagName)
    }

    // --- 内容解析器 ---

    /**
     * 解析 <script> 块内容。
     * 循环调用基础的 parseStatement，它会自动使用我们注入的扩展。
     */
    private fun parseScriptContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder, parentTagName)) {
            val initialPos = builder.currentOffset
            if (!parseStatement(builder)) {
                // 如果 parseStatement 返回 false 或没有前进，我们需要手动前进以避免死循环
                builder.advanceLexer()
            }
            if (builder.currentOffset == initialPos && !isAtEndTag(builder, parentTagName)) {
                builder.error("Parser stalled inside <script> block")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.SFC_SCRIPT_CONTENT)
    }

    /**
     * 解析 <template> 块内容。
     * 这是一个混合内容区域，包含 XML 元素、文本和 Valkyrie 插槽。
     */
    private fun parseTemplateContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder, parentTagName)) {
            val initialPos = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseXmlElement(builder)
                ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                in XML_TEXT_TOKENS -> parseXmlText(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                else -> {
                    builder.error("Unexpected token in template content")
                    builder.advanceLexer()
                }
            }
            if (builder.currentOffset == initialPos && !isAtEndTag(builder, parentTagName)) {
                builder.error("Parser stalled inside <template> block")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)
    }

    /**
     * 解析 <style> 块内容。
     * 这很简单，因为 Lexer 已经将所有内容标记为一个 Token。
     */
    private fun parseStyleContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.STYLE_CONTENT) {
            builder.advanceLexer()
        }
        contentMarker.done(ValkyrieElementTypes.SFC_STYLE_CONTENT)
    }

    // --- XML 结构化元素解析 ---

    /**
     * 解析一个完整的 XML 元素，可以作为表达式或模板内容
     */
    private fun parseXmlElement(builder: PsiBuilder) {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return
        val tagMarker = builder.mark()

        val tagName = parseStartTag(builder)

        // 自闭合标签或 void 元素
        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer() // 消费 '/>'
            tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
            return
        }
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer() // 消费 '>'
        } else if (tagName !in VOID_ELEMENTS) {
            builder.error("Expected '>' or '/>'")
        }

        if (tagName in VOID_ELEMENTS) {
            tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
            return
        }

        // 递归解析子内容 (与 parseTemplateContent 逻辑相同)
        parseTemplateContent(builder, tagName)

        parseEndTag(builder, tagName)
        tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
    }

    private fun parseStartTag(builder: PsiBuilder): String? {
        val startTagMarker = builder.mark()
        builder.advanceLexer() // 消费 '<'

        var tagName: String? = null
        if (builder.tokenType in TAG_NAME_TOKENS) {
            tagName = builder.tokenText
            builder.advanceLexer()
        } else {
            builder.error("Tag name expected")
        }

        // 解析属性
        while (builder.tokenType == XmlTokenType.XML_NAME) {
            parseAttribute(builder)
        }
        startTagMarker.done(ValkyrieElementTypes.XML_START_TAG)
        return tagName
    }

    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        builder.advanceLexer() // 消费属性名 (XML_NAME)

        // [修复] 处理带值的属性和裸属性
        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer() // 消费 '='
            if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER) {
                parseAttributeValue(builder)
            } else {
                builder.error("Attribute value expected")
            }
        }
        // 如果没有 '='，则它是一个裸属性（如 `disabled` 或 `package::Name`）
        attrMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
    }

    private fun parseAttributeValue(builder: PsiBuilder) {
        val valueMarker = builder.mark()
        builder.advanceLexer() // 消费 '"' or "'"

        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
                parseXmlSlot(builder)
            } else {
                builder.advanceLexer() // 消费属性值内的 token
            }
        }

        if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
            builder.advanceLexer()
        } else {
            builder.error("Unclosed attribute value")
        }
        valueMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE_VALUE)
    }

    private fun parseEndTag(builder: PsiBuilder, expectedTagName: String?) {
        if (!isAtEndTag(builder, expectedTagName)) {
            if (expectedTagName != null) {
                builder.error("Expected closing tag for '<$expectedTagName>'")
            }
            return
        }

        val endTagMarker = builder.mark()
        builder.advanceLexer() // 消费 '</'

        if (builder.tokenType in TAG_NAME_TOKENS) {
            if (expectedTagName != null && builder.tokenText != expectedTagName) {
                builder.error("Mismatched closing tag. Expected '</$expectedTagName>', found '</${builder.tokenText}>'")
            }
            builder.advanceLexer() // 消费 tag name
        } else {
            builder.error("Tag name expected in closing tag")
        }

        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer() // 消费 '>'
        } else {
            builder.error("Expected '>' to close the tag")
        }
        endTagMarker.done(ValkyrieElementTypes.XML_END_TAG)
    }


    private fun parseXmlSlot(builder: PsiBuilder) {
        val slotMarker = builder.mark()
        builder.advanceLexer() // 消费 '{'

        // 在插槽内部，我们期望一个 Valkyrie 表达式
        if (builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
            if (!parseTermExpression(this, builder, false)) {
                builder.error("Expected expression inside slot")
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
            builder.advanceLexer() // 消费 '}'
        } else {
            builder.error("Expected '}' to close the slot")
        }
        slotMarker.done(ValkyrieElementTypes.SLOT_STATEMENT)
    }

    private fun parseXmlText(builder: PsiBuilder) {
        val marker = builder.mark()
        // 消费所有连续的文本和空白 token
        while (builder.tokenType in XML_TEXT_TOKENS) {
            builder.advanceLexer()
        }
        marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
    }

    private fun parseComment(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 XML_COMMENT_CHARACTERS
        marker.done(XmlElementType.XML_COMMENT)
    }

    private fun isAtEndTag(builder: PsiBuilder, tagName: String?): Boolean {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) return false
        // 如果 tagName 为 null，任何结束标签都算匹配（用于未知标签的恢复）
        if (tagName == null) return true
        // 否则，精确匹配标签名
        val nextToken = builder.lookAhead(1)
        return nextToken in TAG_NAME_TOKENS && builder.lookAhead(1)?.toString() == tagName
    }
}