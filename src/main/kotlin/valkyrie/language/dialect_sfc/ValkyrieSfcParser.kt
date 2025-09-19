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

// 顶层允许的空白或可以忽略的 token
private val TOP_LEVEL_WHITESPACE = TokenSet.create(
    XmlTokenType.XML_WHITE_SPACE,
    XmlTokenType.XML_DATA_CHARACTERS // 允许块之间的换行
)

/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 采用了宿主语言 (Valkyrie) + 扩展点注入 (XML 表达式) 的架构
 */
class ValkyrieSfcParser : ValkyrieParser() {
    /**
     * SFC 文件的顶层解析逻辑
     * 循环处理顶层的 <template>, <script>, <style> 块、注释和空白
     */
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> {
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
                in TOP_LEVEL_WHITESPACE -> builder.advanceLexer()
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
                break
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
        // 使用 mark/rollback 安全地获取标签名
        val marker = builder.mark()
        builder.advanceLexer() // skip '<'
        val tagNameToken = builder.tokenType
        val tagName = builder.tokenText
        marker.rollbackTo()

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
            ValkyrieElementTypes.SFC_TEMPLATE -> parseXmlContent(builder, tagName, false)
            ValkyrieElementTypes.SFC_STYLE -> parseStyleContent(builder)
            else -> {}
        }

        parseEndTag(builder, tagName)
    }

    // --- 内容解析器 ---

    private fun parseScriptContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder, parentTagName) && !isAtTopLevelBlockStart(builder)) {
            val initialPos = builder.currentOffset
            if (!parseStatement(builder)) {
                builder.advanceLexer()
            }
            if (builder.currentOffset == initialPos) {
                builder.error("Parser stalled inside <script> block")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.SFC_SCRIPT_CONTENT)
    }

    private fun parseXmlContent(builder: PsiBuilder, parentTagName: String?, isExpressionContext: Boolean) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder, parentTagName)) {
            val initialPos = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseXmlElement(builder, isExpressionContext)
                ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                in XML_TEXT_TOKENS -> parseXmlText(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                else -> {
                    // 如果遇到任何不应该在这里的结束标签，报错并消费它
                    if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
                        val errorMarker = builder.mark()
                        parseEndTag(builder, null) // Parse it without expecting a specific name
                        errorMarker.error("Unexpected closing tag")
                    } else {
                        builder.error("Unexpected token in content")
                        builder.advanceLexer()
                    }
                }
            }
            if (builder.currentOffset == initialPos && !isAtEndTag(builder, parentTagName)) {
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
        } else if (tagName != null && tagName.lowercase() !in VOID_ELEMENTS) {
            builder.error("Expected '>' or '/>'")
        }

        if (tagName != null && tagName.lowercase() in VOID_ELEMENTS) {
            tagMarker.done(ValkyrieElementTypes.XML_ELEMENT)
            return
        }

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

        // 允许没有值的属性
        while (builder.tokenType == XmlTokenType.XML_NAME || builder.tokenType == ValkyrieTokenTypes.SYMBOL_XID) {
            parseAttribute(builder)
        }
        startTagMarker.done(ValkyrieElementTypes.XML_START_TAG)
        return tagName
    }

    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        builder.advanceLexer() // 消费属性名

        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer()
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
                parseAttributeValue(builder)
            } else {
                builder.error("Attribute value expected")
            }
        }
        // 如果没有等号，则认为是一个布尔属性，直接结束
        attrMarker.done(XmlElementType.XML_ATTRIBUTE)
    }

    private fun parseAttributeValue(builder: PsiBuilder) {
        val valueMarker = builder.mark()
        builder.advanceLexer() // 消费 '"' or "'"

        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
                parseXmlSlot(builder)
            } else {
                builder.advanceLexer()
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
            builder.advanceLexer()
        } else {
            builder.error("Unclosed attribute value")
        }
        valueMarker.done(XmlElementType.XML_ATTRIBUTE_VALUE)
    }

    private fun parseEndTag(builder: PsiBuilder, expectedTagName: String?) {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
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

    private fun isAtTopLevelBlockStart(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return false
        val nextToken = builder.lookAhead(1)
        return nextToken == ValkyrieTokenTypes.XML_TEMPLATE ||
            nextToken == ValkyrieTokenTypes.XML_SCRIPT ||
            nextToken == ValkyrieTokenTypes.XML_STYLE
    }

    /**
     * [修复 1] 使用 mark/rollbackTo 安全地预读并检查结束标签是否匹配
     */
    private fun isAtEndTag(builder: PsiBuilder, tagName: String?): Boolean {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            return false
        }
        // 如果我们不在乎标签名，只要是结束标签就行
        if (tagName == null) {
            return true
        }

        // 创建一个标记，以便之后可以回滚
        val marker = builder.mark()
        try {
            builder.advanceLexer() // 跳过 '</'
            if (builder.tokenType in TAG_NAME_TOKENS) {
                // 比较真实的 token 文本
                return builder.tokenText == tagName
            }
            return false
        } finally {
            // 无论如何都要回滚，这样解析器的状态不会被改变
            marker.rollbackTo()
        }
    }
}