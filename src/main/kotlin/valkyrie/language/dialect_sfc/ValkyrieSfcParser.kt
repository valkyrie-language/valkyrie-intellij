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

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> {
                    // [修复 2] 使用 lookAhead 检查标签类型，更健壮
                    val nextToken = builder.lookAhead(1)
                    val tagName = builder.lookAhead(1)?.toString()
                    when (nextToken) {
                        ValkyrieTokenTypes.XML_TEMPLATE -> parseTag(builder, ValkyrieElementTypes.SFC_TEMPLATE)
                        ValkyrieTokenTypes.XML_SCRIPT -> parseTag(builder, ValkyrieElementTypes.SFC_SCRIPT)
                        ValkyrieTokenTypes.XML_STYLE -> parseTag(builder, ValkyrieElementTypes.SFC_STYLE)
                        else -> {
                            val errorMarker = builder.mark()
                            // 允许其他顶层标签，但标记为错误
                            parseTag(builder, ValkyrieElementTypes.XML_ELEMENT)
                            errorMarker.error("Only <template>, <script>, or <style> tags are allowed at the top level")
                        }
                    }
                }

                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                XmlTokenType.XML_WHITE_SPACE -> builder.advanceLexer()
                else -> {
                    builder.mark().error("Unexpected token at top level")
                    builder.advanceLexer()
                }
            }

            if (!builder.eof() && builder.currentOffset == initialPosition) {
                builder.mark().error("Parser stalled")
                builder.advanceLexer()
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 解析一个完整的XML标签，并根据标签名分发到不同的内容解析器
     */
    private fun parseTag(builder: PsiBuilder, rootType: IElementType) {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return
        val tagMarker = builder.mark()

        // 1. 解析开始标签
        val tagName = parseStartTag(builder)

        // 自闭合标签 (e.g., <br/>)
        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer()
            tagMarker.done(rootType)
            return
        }

        // 消费 '>'
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer()
        } else {
            // 允许 <br> 这种非自闭合的空标签
            if (!isVoidElement(tagName)) {
                builder.error("Expected '>' or '/>'")
            }
        }

        if (isVoidElement(tagName)) {
            tagMarker.done(rootType)
            return
        }

        // 2. [修复 3] 根据标签名选择正确的内容解析器
        when (tagName) {
            "script" -> parseScriptContent(builder)
            "style" -> parseStyleContent(builder)
            else -> parseXmlContent(builder, tagName) // 默认解析 XML 内容
        }

        // 3. 解析结束标签
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
        // [修复 1] 接受多种 Token 作为标签名
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

    private fun isVoidElement(tagName: String?): Boolean {
        // HTML5 void elements. Add more if needed.
        return tagName in setOf("br", "hr", "img", "input", "link", "meta")
    }

    /**
     * 解析 <script> 标签的内容，委托给 Valkyrie 语言解析器
     */
    private fun parseScriptContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        // 简单地将 <script> 内部的所有内容都交给 Valkyrie 的顶层解析器
        // 注意：这里需要一个能解析代码片段的入口，我们暂时用 ValkyrieProgramParser
        val programParser = ValkyrieProgramParser()
        programParser.parse(builder, setOf(XmlTokenType.XML_END_TAG_START))
        contentMarker.done(ValkyrieElementTypes.SFC_SCRIPT)
    }

    /**
     * 解析 <style> 标签的内容
     */
    private fun parseStyleContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.STYLE_CONTENT) {
            builder.advanceLexer()
        }
        contentMarker.done(ValkyrieElementTypes.SFC_STYLE)
    }

    /**
     * 解析通用 XML 内容（用于 <template> 和其他 HTML 标签）
     */
    private fun parseXmlContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        // [修复 3] 循环直到遇到匹配的结束标签或文件末尾
        while (!builder.eof() && !isAtEndTag(builder, parentTagName)) {
            val initialPos = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseTag(builder, ValkyrieElementTypes.XML_ELEMENT)
                // [修复 4] 正确处理注释和插槽
                ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                // 其他所有内容都视为文本
                else -> {
                    val textMarker = builder.mark()
                    builder.advanceLexer()
                    textMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                }
            }
            if (builder.currentOffset == initialPos) {
                builder.error("Parser stalled in XML content")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)
    }

    /**
     * 解析 Valkyrie 插槽: { expression }
     */
    private fun parseXmlSlot(builder: PsiBuilder) {
        val slotMarker = builder.mark()
        builder.advanceLexer() // 消费 '{'

        // 在这里可以嵌入一个表达式解析器
        // 为了简单起见，我们先消费掉所有内容直到 '}'
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
            builder.advanceLexer()
        }

        if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
            builder.advanceLexer() // 消费 '}'
        } else {
            builder.error("Expected '}' to close the slot")
        }
        slotMarker.done(ValkyrieElementTypes.SLOT_STATEMENT)
    }

    /**
     * 辅助函数：向前看，判断当前是否是指定标签的结束标签
     */
    private fun isAtEndTag(builder: PsiBuilder, tagName: String?): Boolean {
        if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            return false
        }
        // lookAhead(1) 是 `</` 后面的 token，即结束标签名
        val endTagName = builder.lookAhead(1)?.toString()
        // 如果 tagName 为 null，任何结束标签都匹配
        // 否则，必须是对应的结束标签
        return tagName == null || tagName == endTagName
    }

    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        builder.advanceLexer() // 消费属性名

        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer() // 消费 '='
            if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER) {
                builder.advanceLexer() // 消费 '"' 或 "'"
                // 消费属性值内的 tokens，直到结束引号
                while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                    builder.advanceLexer()
                }
                if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                    builder.advanceLexer()
                } else {
                    builder.error("Unclosed attribute value")
                }
            } else {
                builder.error("Attribute value expected")
            }
        }
        attrMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
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
            builder.advanceLexer() // 消费 '>'
        } else {
            builder.error("Expected '>' to close the tag")
        }
        endTagMarker.done(ValkyrieElementTypes.XML_END_TAG)
    }

    private fun parseComment(builder: PsiBuilder) {
        val marker = builder.mark()
        if (builder.tokenType == XmlTokenType.XML_COMMENT_CHARACTERS) {
            builder.advanceLexer()
        }
        marker.done(XmlElementType.XML_COMMENT)
    }
}