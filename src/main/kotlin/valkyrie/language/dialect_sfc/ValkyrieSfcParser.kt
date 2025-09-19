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
    ValkyrieTokenTypes.XML_TEXT
)


/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 采用了宿主语言 (Valkyrie) + 扩展点注入 (XML 表达式) 的架构
 */
class ValkyrieSfcParser : ValkyrieParser() {
    /**
     * [核心修正] SFC 文件的顶层解析逻辑
     * 循环处理顶层的 <template>, <script>, <style> 块、注释和空白
     */
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> {
                    // 只处理顶层块，如果不是顶层块则报错
                    if (isAtTopLevelBlockStart(builder)) {
                        parseTopLevelBlock(builder)
                    } else {
                        val errorMarker = builder.mark()
                        // 尝试解析为一个普通XML元素，但标记为错误
                        parseXmlElement(builder, false)
                        errorMarker.error("Only <template>, <script>, or <style> tags are allowed at the top level.")
                    }
                }

                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                XmlTokenType.XML_WHITE_SPACE -> builder.advanceLexer()
                // 顶层只允许这几类，其他都是错误
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

    override fun parseStatementExtension(builder: PsiBuilder): Boolean {
        return when (builder.tokenType) {
            ValkyrieTokenTypes.SFC_PROPERTY -> parseSfcPropertyStatement(builder)
            ValkyrieTokenTypes.SFC_EMITS -> parseSfcEmitsStatement(builder)
            else -> false
        }
    }

    override fun parseExpressionExtension(builder: PsiBuilder): Boolean {
        if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
            val marker = builder.mark()
            parseXmlElement(builder, true) // isExpressionContext = true
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
        }
        // else case is handled in parse()
    }

    private fun parseBlock(builder: PsiBuilder, tagName: String?, blockType: IElementType) {
        parseStartTag(builder)

        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer()
            return
        }
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer()
        }

        when (blockType) {
            ValkyrieElementTypes.SFC_SCRIPT -> parseScriptContent(builder, tagName)
            ValkyrieElementTypes.SFC_TEMPLATE -> parseXmlContent(builder, tagName, false) // isExpressionContext = false
            ValkyrieElementTypes.SFC_STYLE -> parseStyleContent(builder)
            else -> {}
        }

        parseEndTag(builder, tagName)
    }

    // --- 内容解析器 ---

    private fun parseScriptContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        // [核心修正] 增加 isAtTopLevelBlockStart 检查
        while (!builder.eof() && !isAtEndTag(builder, parentTagName) && !isAtTopLevelBlockStart(builder)) {
            val initialPos = builder.currentOffset
            if (!parseStatement(builder)) {
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
     * [核心修正] 通用化的 XML 内容解析器
     * isExpressionContext:
     *   true - 在 Valkyrie 表达式上下文中（如 <script> 块内），允许任意 XML 元素
     *   false - 在顶层 <template> 块中，只允许标准 XML 内容
     */
    private fun parseXmlContent(builder: PsiBuilder, parentTagName: String?, isExpressionContext: Boolean) {
        val contentMarker = builder.mark()
        // [核心修正] 增加 isAtTopLevelBlockStart 检查
        val stopCondition = {
            isAtEndTag(builder, parentTagName) || (!isExpressionContext && isAtTopLevelBlockStart(builder))
        }

        while (!builder.eof() && !stopCondition()) {
            val initialPos = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseXmlElement(builder, isExpressionContext)
                ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                in XML_TEXT_TOKENS -> parseXmlText(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                else -> {
                    builder.error("Unexpected token in content")
                    builder.advanceLexer()
                }
            }
            if (builder.currentOffset == initialPos && !stopCondition()) {
                builder.error("Parser stalled inside content block")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)
    }

    private fun parseStyleContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.STYLE_CONTENT) {
            builder.advanceLexer()
        }
        contentMarker.done(ValkyrieElementTypes.SFC_STYLE_CONTENT)
    }

    // --- XML 结构化元素解析 ---

    private fun parseXmlElement(builder: PsiBuilder, isExpressionContext: Boolean) {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return
        val tagMarker = builder.mark()

        val tagName = parseStartTag(builder)

        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer()
            tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
            return
        }
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer()
        } else if (tagName !in VOID_ELEMENTS) {
            builder.error("Expected '>' or '/>'")
        }

        if (tagName in VOID_ELEMENTS) {
            tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
            return
        }

        // [核心修正] 递归调用通用内容解析器
        parseXmlContent(builder, tagName, isExpressionContext)

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

        while (builder.tokenType == XmlTokenType.XML_NAME) {
            parseAttribute(builder)
        }
        startTagMarker.done(ValkyrieElementTypes.XML_START_TAG)
        return tagName
    }

    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        builder.advanceLexer() // 消费属性名 (XML_NAME)

        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer()
            if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER) {
                parseAttributeValue(builder)
            } else {
                builder.error("Attribute value expected")
            }
        }
        attrMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
    }

    private fun parseAttributeValue(builder: PsiBuilder) {
        val valueMarker = builder.mark()
        builder.advanceLexer()

        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
                parseXmlSlot(builder)
            } else {
                builder.advanceLexer()
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
        if (!isAtEndTag(builder, null)) { // Check if it's an end tag at all
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
            builder.advanceLexer()
        } else {
            builder.error("Tag name expected in closing tag")
        }

        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '>' to close the tag")
        }
        endTagMarker.done(ValkyrieElementTypes.XML_END_TAG)
    }


    private fun parseXmlSlot(builder: PsiBuilder) {
        val slotMarker = builder.mark()
        builder.advanceLexer()

        if (builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
            if (!parseTermExpression(this, builder, false)) {
                // parseTermExpression will already create an error if it fails
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}' to close the slot")
        }
        slotMarker.done(ValkyrieElementTypes.SLOT_STATEMENT)
    }

    private fun parseXmlText(builder: PsiBuilder) {
        val marker = builder.mark()
        while (builder.tokenType in XML_TEXT_TOKENS) {
            builder.advanceLexer()
        }
        marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
    }

    private fun parseComment(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer()
        marker.done(XmlElementType.XML_COMMENT)
    }

    // --- 辅助函数 ---

    /**
     * [核心修正] 新增辅助函数，判断当前是否在顶层块的开始处
     */
    private fun isAtTopLevelBlockStart(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return false
        val nextToken = builder.lookAhead(1)
        return nextToken == ValkyrieTokenTypes.XML_TEMPLATE ||
            nextToken == ValkyrieTokenTypes.XML_SCRIPT ||
            nextToken == ValkyrieTokenTypes.XML_STYLE
    }

    private fun isAtEndTag(builder: PsiBuilder, tagName: String?): Boolean {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) return false
        if (tagName == null) return true
        val nextToken = builder.lookAhead(1)
        return nextToken in TAG_NAME_TOKENS && builder.lookAhead(1)?.toString() == tagName
    }
}