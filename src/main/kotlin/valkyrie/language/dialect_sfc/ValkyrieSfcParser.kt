package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.xml.XmlElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

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

private val XML_TEXT_LIKE_TOKENS = TokenSet.create(
    XmlTokenType.XML_DATA_CHARACTERS,
    XmlTokenType.XML_WHITE_SPACE,
    XmlTokenType.XML_CHAR_ENTITY_REF,
    ValkyrieTokenTypes.XML_TEXT
)

private val TOP_LEVEL_IGNORED = TokenSet.create(
    XmlTokenType.XML_WHITE_SPACE,
    XmlTokenType.XML_DATA_CHARACTERS
)

/**
 * Valkyrie SFC (Single File Component) Parser
 */
class ValkyrieSfcParser : ValkyrieParser() {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> {
                    if (isAtTopLevelBlockStart(builder)) {
                        parseTopLevelBlock(builder)
                    } else {
                        builder.mark().error("Only <template>, <script>, or <style> tags are allowed at the top level.")
                        parseXmlElement(builder) // 仍然解析它以避免级联错误
                    }
                }

                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                in TOP_LEVEL_IGNORED -> builder.advanceLexer()
                else -> {
                    builder.mark().error("Unexpected token at top level.")
                    builder.advanceLexer()
                }
            }
            if (!builder.eof() && builder.currentOffset == initialPosition) {
                builder.mark().error("Parser stalled at top level")
                builder.advanceLexer(); break
            }
        }
        rootMarker.done(root)
        return builder.treeBuilt
    }

    override fun parseExpressionExtension(builder: PsiBuilder): Boolean {
        if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
            val marker = builder.mark()
            parseXmlElement(builder)
            marker.done(ValkyrieElementTypes.XML_ELEMENT)
            return true
        }
        return false
    }

    override fun parseStatementExtension(builder: PsiBuilder): Boolean {
        return when (builder.tokenType) {
            ValkyrieTokenTypes.SFC_PROPERTY -> parseSfcPropertyStatement(builder)
            ValkyrieTokenTypes.SFC_EMITS -> parseSfcEmitsStatement(builder)
            else -> false
        }
    }

    private fun parseSfcPropertyStatement(builder: PsiBuilder): Boolean {
        return false
    }

    private fun parseSfcEmitsStatement(builder: PsiBuilder): Boolean {
        return false
    }

    // --- 顶层块解析 ---
    private fun parseTopLevelBlock(builder: PsiBuilder) {
        val tagNameToken = builder.lookAhead(1)
        val blockType = when (tagNameToken) {
            ValkyrieTokenTypes.XML_TEMPLATE -> ValkyrieElementTypes.SFC_TEMPLATE
            ValkyrieTokenTypes.XML_SCRIPT -> ValkyrieElementTypes.SFC_SCRIPT
            ValkyrieTokenTypes.XML_STYLE -> ValkyrieElementTypes.SFC_STYLE
            else -> return
        }
        val blockMarker = builder.mark()
        parseBlock(builder, blockType)
        blockMarker.done(blockType)
    }

    private fun parseBlock(builder: PsiBuilder, blockType: IElementType) {
        parseStartTag(builder)
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer()
        }

        when (blockType) {
            ValkyrieElementTypes.SFC_SCRIPT -> parseScriptContent(builder)
            ValkyrieElementTypes.SFC_TEMPLATE -> parseXmlContent(builder)
            ValkyrieElementTypes.SFC_STYLE -> parseStyleContent(builder)
            else -> {}
        }
        parseEndTag(builder)
    }

    // --- 内容解析器 ---
    private fun parseScriptContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder) && !isAtTopLevelBlockStart(builder)) {
            val initialPos = builder.currentOffset
            if (!parseStatement(builder)) {
                builder.advanceLexer()
            }
            if (builder.currentOffset == initialPos) {
                builder.mark().error("Parser stalled inside <script> block"); builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.SFC_SCRIPT_CONTENT)
    }

    private fun parseXmlContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder)) {
            val initialPos = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseXmlElement(builder)
                ValkyrieTokenTypes.BRACE_L -> parseXmlSlot(builder)
                in XML_TEXT_LIKE_TOKENS -> parseXmlText(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                else -> {
                    builder.mark().error("Unexpected token in content"); builder.advanceLexer()
                }
            }
            if (builder.currentOffset == initialPos && !isAtEndTag(builder)) {
                builder.mark().error("Parser stalled inside content block"); builder.advanceLexer()
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
    private fun parseXmlElement(builder: PsiBuilder) {
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
        } else if (tagName?.lowercase() !in VOID_ELEMENTS) {
            builder.error("Expected '>' or '/>'")
        }

        if (tagName?.lowercase() in VOID_ELEMENTS) {
            tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
            return
        }

        parseXmlContent(builder)
        parseEndTag(builder)
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

    /**
     * 【核心修复】解析属性，支持三种类型的值。
     */
    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        builder.advanceLexer() // 消费属性名

        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer() // 消费 '='
            val valueMarker = builder.mark()
            when (builder.tokenType) {
                // Case 1: attr="..."
                XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER -> parseQuotedAttributeValue(builder)
                // Case 2: attr={...}
                ValkyrieTokenTypes.BRACE_L -> parseXmlSlot(builder)
                // Case 3: attr=value
                XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN -> builder.advanceLexer()
                else -> builder.error("Attribute value expected")
            }
            valueMarker.done(XmlElementType.XML_ATTRIBUTE_VALUE)
        }
        // 如果没有等号，则是布尔属性
        attrMarker.done(XmlElementType.XML_ATTRIBUTE)
    }

    private fun parseQuotedAttributeValue(builder: PsiBuilder) {
        builder.advanceLexer() // 消费 '"' or "'"
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.BRACE_L -> parseXmlSlot(builder)
                else -> builder.advanceLexer()
            }
        }

        if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
            builder.advanceLexer()
        } else {
            builder.error("Unclosed attribute value")
        }
    }

    /**
     * 【简化】只解析结束标签结构，不进行名称匹配。
     */
    private fun parseEndTag(builder: PsiBuilder) {
        if (!isAtEndTag(builder)) return
        val endTagMarker = builder.mark()
        builder.advanceLexer() // 消费 '</'

        if (builder.tokenType in TAG_NAME_TOKENS) {
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
        builder.advanceLexer() // 消费 '{'
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
            parseTermExpression(this, builder, false)
        }
        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}' to close expression")
        }
        slotMarker.done(ValkyrieElementTypes.SLOT_STATEMENT)
    }

    private fun parseXmlText(builder: PsiBuilder) {
        val marker = builder.mark()
        while (builder.tokenType in XML_TEXT_LIKE_TOKENS) {
            builder.advanceLexer()
        }
        marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
    }

    private fun parseComment(builder: PsiBuilder) {
        builder.mark().done(XmlElementType.XML_COMMENT)
        builder.advanceLexer()
    }

    private fun isAtTopLevelBlockStart(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return false
        val nextToken = builder.lookAhead(1)
        return nextToken in setOf(ValkyrieTokenTypes.XML_TEMPLATE, ValkyrieTokenTypes.XML_SCRIPT, ValkyrieTokenTypes.XML_STYLE)
    }

    private fun isAtEndTag(builder: PsiBuilder): Boolean {
        return builder.tokenType == XmlTokenType.XML_END_TAG_START
    }
}