package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.xml.XmlElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 解决了 Lexer/Parser 协作、内容分发和结束标签匹配等问题
 */
class ValkyrieSfcParser : ValkyrieParser() {

    // [修复 1] 定义所有可以作为标签名的 Token 类型
    private val TAG_NAME_TOKENS = TokenSet.create(
        XmlTokenType.XML_TAG_NAME,
        ValkyrieTokenTypes.XML_TEMPLATE,
        ValkyrieTokenTypes.XML_SCRIPT,
        ValkyrieTokenTypes.XML_STYLE
    )

    // HTML5 void elements that don't need a closing tag.
    private val VOID_ELEMENTS = setOf(
        "area", "base", "br", "col", "embed", "hr", "img", "input",
        "link", "meta", "param", "source", "track", "wbr"
    )

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseTopLevelTag(builder)
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
                builder.mark().error("Parser stalled")
                builder.advanceLexer()
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 解析顶层标签，并根据标签类型进行分发
     */
    private fun parseTopLevelTag(builder: PsiBuilder) {
        // [修复 2] 使用 lookAhead 预判标签类型，决定根节点类型
        val tagNameToken = builder.lookAhead(1)
        val rootType = when (tagNameToken) {
            ValkyrieTokenTypes.XML_TEMPLATE -> ValkyrieElementTypes.SFC_TEMPLATE
            ValkyrieTokenTypes.XML_SCRIPT -> ValkyrieElementTypes.SFC_SCRIPT
            ValkyrieTokenTypes.XML_STYLE -> ValkyrieElementTypes.SFC_STYLE
            else -> null
        }

        if (rootType != null) {
            parseTag(builder, rootType)
        } else {
            // 如果顶层是未知标签，解析它但标记为错误
            val errorMarker = builder.mark()
            parseTag(builder, ValkyrieElementTypes.XML_ELEMENT)
            errorMarker.error("Only <template>, <script>, or <style> tags are allowed at the top level")
        }
    }

    /**
     * 解析一个完整的XML标签（开始标签 + 内容 + 结束标签）
     */
    private fun parseTag(builder: PsiBuilder, rootType: IElementType) {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return
        val tagMarker = builder.mark()

        // 1. 解析开始标签
        val tagName = parseStartTag(builder)

        // 2. 处理自闭合标签和void元素
        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer() // 消费 '/>'
            tagMarker.done(rootType)
            return
        }
        // 消费 '>'
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer()
        } else if (tagName !in VOID_ELEMENTS) {
            // 如果不是void元素，却缺少闭合符，则报错
            builder.error("Expected '>' or '/>'")
        }

        if (tagName in VOID_ELEMENTS) {
            tagMarker.done(rootType)
            return
        }

        // 3. 根据标签名选择正确的内容解析器
        when (tagName) {
            "script" -> parseSfcMixedContent(builder, "script")
            "style" -> parseStyleContent(builder)
            else -> parseSfcMixedContent(builder, tagName) // template 和其他 HTML 标签都走混合内容解析
        }

        // 4. 解析结束标签
        parseEndTag(builder, tagName)

        tagMarker.done(rootType)
    }

    /**
     * 解析开始标签部分： '<' tagName attr1="val1" ...
     */
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

    /**
     * [核心修复 3] 解析混合内容，能同时处理Valkyrie语句和XML标签。
     * 用于 <template> 和 <script> 内部。
     */
    private fun parseSfcMixedContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder, parentTagName)) {
            val initialPos = builder.currentOffset

            val parsed = when {
                builder.tokenType == XmlTokenType.XML_START_TAG_START -> {
                    parseTag(builder, ValkyrieElementTypes.XML_ELEMENT); true
                }
                builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L -> {
                    parseXmlSlot(builder); true
                }
                builder.tokenType == XmlTokenType.XML_COMMENT_CHARACTERS -> {
                    parseComment(builder); true
                }
                // 尝试解析一个Valkyrie语句，如果成功，继续循环
                parseStatement(builder) -> true
                // 其他任何 token 都被视为文本节点
                builder.tokenType != null -> {
                    val textMarker = builder.mark()
                    builder.advanceLexer()
                    textMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                    true
                }
                else -> false
            }

            if (!parsed || builder.currentOffset == initialPos) {
                if (builder.eof() || isAtEndTag(builder, parentTagName)) break
                builder.mark().error("Parser stalled in mixed content")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)
    }

    /**
     * 解析 <style> 标签的纯文本内容
     */
    private fun parseStyleContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.STYLE_CONTENT) {
            builder.advanceLexer()
        }
        contentMarker.done(ValkyrieElementTypes.SFC_STYLE_CONTENT)
    }

    /**
     * [修复 4] 解析 Valkyrie 插槽: { expression }
     */
    private fun parseXmlSlot(builder: PsiBuilder) {
        val slotMarker = builder.mark()
        builder.advanceLexer() // 消费 '{'

        // 尝试解析一个表达式
        if (!parseTermExpression(this, builder, false)) {
            // 如果 '{' 后面不是 '}'，说明应该有一个表达式但解析失败了
            if (builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
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

    private fun isAtEndTag(builder: PsiBuilder, tagName: String?): Boolean {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            return false
        }
        // 向前看下一个 token (`</` 之后) 是不是对应的标签名
        val endTagNameToken = builder.lookAhead(1)
        return tagName == null || (endTagNameToken in TAG_NAME_TOKENS && builder.lookAhead(1)?.toString() == tagName)
    }

    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        builder.advanceLexer() // 消费属性名

        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer() // 消费 '='
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
        builder.advanceLexer() // 消费 '"' 或 "'"

        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
                parseXmlSlot(builder)
            } else {
                builder.advanceLexer() // 消费属性值内的 token
            }
        }

        if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMETER) {
            builder.advanceLexer()
        } else {
            builder.error("Unclosed attribute value")
        }
        valueMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE_VALUE)
    }


    private fun parseEndTag(builder: PsiBuilder, expectedTagName: String?) {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            if (expectedTagName != null) {
                // 只有当期望有结束标签时才报错
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
            builder.advanceLexer() // 消费 '>'
        } else {
            builder.error("Expected '>' to close the tag")
        }
        endTagMarker.done(ValkyrieElementTypes.XML_END_TAG)
    }

    private fun parseComment(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费 XML_COMMENT_CHARACTERS
        marker.done(XmlElementType.XML_COMMENT)
    }
}