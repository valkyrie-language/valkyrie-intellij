package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 专门处理 .vkc 文件的解析逻辑
 */
class ValkyrieSfcParser : ValkyrieParser() {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        // 在测试中启用Debug模式有助于排查问题
        // builder.setDebugMode(true)
        val rootMarker = builder.mark()

        // 专门处理SFC文件的解析逻辑
        while (!builder.eof()) {
            val initialPosition = builder.currentOffset

            // 尝试解析SFC特定的语句
            val parsed = when {
                isSfcTag(builder, "template") -> parseSfcTag(this, builder, ValkyrieElementTypes.SFC_TEMPLATE, "template")
                isSfcTag(builder, "script") -> parseSfcTag(this, builder, ValkyrieElementTypes.SFC_SCRIPT, "script")
                isSfcTag(builder, "style") -> parseSfcTag(this, builder, ValkyrieElementTypes.SFC_STYLE, "style")

                // 处理XML注释
                builder.tokenType == XmlTokenType.XML_COMMENT_START -> {
                    parseXmlComment(builder)
                    true
                }
                // 处理空白字符
                builder.tokenType == XmlTokenType.XML_WHITE_SPACE -> {
                    builder.advanceLexer()
                    true
                }
                // 处理其他XML内容
                builder.tokenType == XmlTokenType.XML_DATA_CHARACTERS -> {
                    val marker = builder.mark()
                    builder.advanceLexer()
                    // 通常顶层不应该有裸露的文本，可以标记为错误或一个特殊的 text 节点
                    marker.error("Unexpected text content at top level")
                    true
                }
                // 其他情况，标记为错误并前进
                else -> {
                    val marker = builder.mark()
                    builder.advanceLexer()
                    marker.error("Unexpected token")
                    true
                }
            }

            // 如果没有任何进展，强制前进一个token避免无限循环
            if (!parsed || builder.currentOffset == initialPosition) {
                if (!builder.eof()) {
                    val errorMarker = builder.mark()
                    builder.advanceLexer()
                    errorMarker.error("Parser stalled: Unrecognized token")
                }
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 通用的SFC标签检查方法
     */
    private fun isSfcTag(builder: PsiBuilder, tagName: String): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }
        // 使用 lookAhead(1) 来预览下一个 token，这比创建 marker 更高效
        val nextToken = builder.lookAhead(1)
        if (nextToken == XmlTokenType.XML_TAG_NAME) {
            // 使用 n-th token text 来获取预览的 token 的文本，而不需要移动词法分析器
            return builder.lookAhead(1)?.let {
                builder.originalText.subSequence(builder.currentOffset + 1, builder.currentOffset + 1 + it.toString().length).toString()
            } == tagName
        }
        // 支持特殊的 token 类型
        return when (tagName) {
            "template" -> nextToken == ValkyrieElementTypes.XML_TEMPLATE
            "script" -> nextToken == ValkyrieElementTypes.XML_SCRIPT
            "style" -> nextToken == ValkyrieElementTypes.XML_STYLE
            else -> false
        }
    }


    /**
     * 解析XML注释
     */
    private fun parseXmlComment(builder: PsiBuilder) {
        val marker = builder.mark()
        if (builder.tokenType == XmlTokenType.XML_COMMENT_START) {
            builder.advanceLexer()
        }
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_COMMENT_END) {
            builder.advanceLexer()
        }
        if (builder.tokenType == XmlTokenType.XML_COMMENT_END) {
            builder.advanceLexer()
        }
        marker.done(ValkyrieElementTypes.XML_COMMENT)
    }

    /**
     * 通用的 SFC 标签解析方法
     */
    fun parseSfcTag(parser: ValkyrieParser, builder: PsiBuilder, elementType: IElementType, tagName: String): Boolean {
        if (!isSfcTag(builder, tagName)) return false

        val tagMarker = builder.mark()

        // --- 解析开始标签 ---
        builder.advanceLexer() // 消费 '<'
        builder.advanceLexer() // 消费 标签名 ('template', 'script', 'style')

        // 跳过属性
        while (!builder.eof() && builder.tokenType !in listOf(XmlTokenType.XML_TAG_END, XmlTokenType.XML_EMPTY_ELEMENT_END)) {
            // 这里可以实现完整的属性解析，为简化先跳过
            builder.advanceLexer()
        }

        val isSelfClosing = builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END
        if (isSelfClosing) {
            builder.advanceLexer() // 消费 '/>'
            tagMarker.done(elementType)
            return true
        }

        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer() // 消费 '>'
        } else {
            builder.error("Expected '>' or '/>'")
            tagMarker.done(elementType)
            return true
        }

        // --- ★★★ 核心修复：为标签内容创建一个节点 ★★★ ---
        // 即使内容为空，这个 XML_TAG_CONTENT 节点也会被创建，从而保证 AST 结构的完整性。
        val contentMarker = builder.mark()
        parseXmlContent(parser, builder)
        // 假设 ValkyrieElementTypes 中有一个 XML_TAG_CONTENT 类型
        contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)

        // --- 解析结束标签 ---
        if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
            builder.advanceLexer() // 消费 '</'

            if (builder.tokenType == XmlTokenType.XML_TAG_NAME && builder.tokenText == tagName) {
                builder.advanceLexer() // 消费 标签名
            } else {
                builder.error("Expected closing tag for '$tagName'")
            }

            if (builder.tokenType == XmlTokenType.XML_TAG_END) {
                builder.advanceLexer() // 消费 '>'
            } else {
                builder.error("Expected '>' to close the tag")
            }
        } else {
            builder.error("Expected closing tag for '$tagName'")
        }

        tagMarker.done(elementType)
        return true
    }

    /**
     * 解析XML内容
     */
    private fun parseXmlContent(parser: ValkyrieParser, builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            val initialPosition = builder.currentOffset

            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseNestedXmlElement(parser, builder)
                XmlTokenType.XML_COMMENT_START -> parseXmlComment(builder)
                ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(parser, builder)

                // 处理文本内容
                XmlTokenType.XML_DATA_CHARACTERS,
                ValkyrieTokenTypes.SCRIPT_CONTENT,
                ValkyrieTokenTypes.STYLE_CONTENT -> {
                    val textMarker = builder.mark()
                    builder.advanceLexer()
                    textMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                }

                // 其他任何 token 都被视为内容的一部分，直到遇到结束标签
                else -> {
                    // 对于无法识别的 token，简单地前进以避免无限循环
                    // 在更复杂的解析器中，这里可能会创建错误节点
                    builder.advanceLexer()
                }
            }

            // 保护机制，防止因解析逻辑错误导致的无限循环
            if (builder.currentOffset == initialPosition) {
                builder.error("Parser did not advance inside XML content")
                builder.advanceLexer()
            }
        }
    }

    /**
     * 解析嵌套的XML元素 (简化版)
     */
    private fun parseNestedXmlElement(parser: ValkyrieParser, builder: PsiBuilder) {
        val marker = builder.mark()
        // 调用一个更通用的XML标签解析器，这里为了演示，我们用一个简化的实现
        // 假设我们有一个通用的 `parseXmlTag` 变体来处理任意XML元素
        // 这里只是一个占位实现：
        builder.advanceLexer() // <
        if (builder.tokenType == XmlTokenType.XML_TAG_NAME) builder.advanceLexer()
        while (!builder.eof() && builder.tokenType !in listOf(XmlTokenType.XML_TAG_END, XmlTokenType.XML_EMPTY_ELEMENT_END)) {
            builder.advanceLexer() // attributes
        }
        val isSelfClosing = builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END
        if (builder.tokenType in listOf(XmlTokenType.XML_TAG_END, XmlTokenType.XML_EMPTY_ELEMENT_END)) builder.advanceLexer()

        if (!isSelfClosing) {
            parseXmlContent(parser, builder)
            if (builder.tokenType == XmlTokenType.XML_END_TAG_START) builder.advanceLexer() // </
            if (builder.tokenType == XmlTokenType.XML_TAG_NAME) builder.advanceLexer()
            if (builder.tokenType == XmlTokenType.XML_TAG_END) builder.advanceLexer() // >
        }
        marker.done(ValkyrieElementTypes.XML_ELEMENT)
    }

    /**
     * 解析XML插槽表达式 {expression}
     */
    private fun parseXmlSlot(parser: ValkyrieParser, builder: PsiBuilder) {
        val marker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
            builder.advanceLexer() // 消费 '{'
            // 解析内部表达式
            if (builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
                parseExpression(parser, builder)
            }
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
                builder.advanceLexer() // 消费 '}'
            } else {
                builder.error("Expected '}'")
            }
        }
        marker.done(ValkyrieElementTypes.XML_SLOT_EXPRESSION)
    }

    /**
     * 解析Valkyrie表达式
     */
    private fun parseExpression(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
        // 确保你的父类 ValkyrieParser 有一个 parseExpressionStatement 方法
        return parser.parseExpressionStatement(builder)
    }
}