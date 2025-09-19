package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.xml.XmlElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

// （这些常量可以放在文件顶部）
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

/**
 * Valkyrie SFC (Single File Component) 专用解析器
 * 解决了 Lexer/Parser 协作、内容分发和结束标签匹配等问题
 */
class ValkyrieSfcParser : ValkyrieParser() {
    /**
     * [重构 1] 重写顶层解析逻辑，以支持多个根级标签
     */
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseTopLevelTag(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                // 忽略顶层的空白
                XmlTokenType.XML_WHITE_SPACE, XmlTokenType.XML_REAL_WHITE_SPACE -> builder.advanceLexer()
                // 顶层只允许这几类，其他都是错误
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
                break // 强制退出循环
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * [重构 2] 专门解析顶层标签，并分发到正确的内容解析器
     */
    private fun parseTopLevelTag(builder: PsiBuilder) {
        // 预判标签类型来决定根节点类型
        val tagNameToken = builder.lookAhead(1)
        val rootType = when (tagNameToken) {
            ValkyrieTokenTypes.XML_TEMPLATE -> ValkyrieElementTypes.SFC_TEMPLATE
            ValkyrieTokenTypes.XML_SCRIPT -> ValkyrieElementTypes.SFC_SCRIPT
            ValkyrieTokenTypes.XML_STYLE -> ValkyrieElementTypes.SFC_STYLE
            else -> {
                // 如果顶层是未知标签，标记为错误但仍然解析
                val errorMarker = builder.mark()
                parseTag(builder, ValkyrieElementTypes.XML_ELEMENT, isTopLevel = true)
                errorMarker.error("Only <template>, <script>, or <style> tags are allowed at the top level")
                return
            }
        }
        parseTag(builder, rootType, isTopLevel = true)
    }

    /**
     * 通用标签解析器，根据上下文分发内容解析
     */
    private fun parseTag(builder: PsiBuilder, nodeType: IElementType, isTopLevel: Boolean) {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) return
        val tagMarker = builder.mark()

        // 1. 解析开始标签
        val tagName = parseStartTag(builder)

        // 2. 处理自闭合标签和 void 元素
        if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
            builder.advanceLexer() // 消费 '/>'
            tagMarker.done(nodeType)
            return
        }
        if (builder.tokenType == XmlTokenType.XML_TAG_END) {
            builder.advanceLexer() // 消费 '>'
        } else if (tagName !in VOID_ELEMENTS) {
            builder.error("Expected '>' or '/>'")
        }

        if (tagName in VOID_ELEMENTS) {
            tagMarker.done(nodeType)
            return
        }

        // 3. [重构 3] 根据标签名选择正确的内容解析器
        if (isTopLevel) {
            when (tagName) {
                "script" -> parseScriptContent(builder)
                "style" -> parseStyleContent(builder)
                "template" -> parseTemplateContent(builder, tagName)
                else -> { /* 已经在 parseTopLevelTag 中处理了错误 */ }
            }
        } else {
            // 所有嵌套标签（在 template 或 JSX 中）都使用模板内容解析器
            parseTemplateContent(builder, tagName)
        }

        // 4. 解析结束标签
        parseEndTag(builder, tagName)

        tagMarker.done(nodeType)
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
        while (builder.tokenType == XmlTokenType.XML_NAME || builder.tokenType == ValkyrieElementTypes.NAMESPACE_PATH) {
            parseAttribute(builder)
        }

        startTagMarker.done(ValkyrieElementTypes.XML_START_TAG)
        return tagName
    }

    /**
     * [修复 4.1] 改进属性解析以支持无值属性
     */
    private fun parseAttribute(builder: PsiBuilder) {
        val attrMarker = builder.mark()
        // 属性名可以是简单的 NAME 也可以是 Namepath
        // 这里可以进一步细化，例如检查 builder.tokenType
        builder.advanceLexer()

        // 如果后面是 '='，则解析属性值
        if (builder.tokenType == XmlTokenType.XML_EQ) {
            builder.advanceLexer() // 消费 '='
            if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMETER) {
                parseAttributeValue(builder)
            } else {
                builder.error("Attribute value expected")
            }
        }
        // 否则，它是一个无值属性，什么都不做
        attrMarker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
    }

    // `parseAttributeValue` 和 `parseXmlSlot` 保持不变...

    /**
     * [新增] 解析 <script> 内容，这里是纯 Valkyrie 代码
     */
    private fun parseScriptContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            val initialPos = builder.currentOffset

            // 使用基类（已通过钩子扩展）的语句解析器
            super.parseStatement(builder)

            if (builder.currentOffset == initialPos) {
                if (builder.eof() || builder.tokenType == XmlTokenType.XML_END_TAG_START) break
                builder.mark().error("Parser stalled in script content")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.SFC_SCRIPT_CONTENT)
    }

    /**
     * [新增] 解析 <style> 内容，这里是纯文本
     */
    private fun parseStyleContent(builder: PsiBuilder) {
        val contentMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.STYLE_CONTENT) {
            builder.advanceLexer()
        }
        contentMarker.done(ValkyrieElementTypes.SFC_STYLE_CONTENT)
    }

    /**
     * [新增] 解析 <template> 内容，混合了 XML, 插值和文本
     */
    private fun parseTemplateContent(builder: PsiBuilder, parentTagName: String?) {
        val contentMarker = builder.mark()
        while (!builder.eof() && !isAtEndTag(builder, parentTagName)) {
            val initialPos = builder.currentOffset

            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> parseTag(builder, ValkyrieElementTypes.XML_ELEMENT, false)
                ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                XmlTokenType.XML_COMMENT_CHARACTERS -> parseComment(builder)
                // 其他任何 token 都被视为文本节点, 包括 '#...'
                else -> {
                    val textMarker = builder.mark()
                    builder.advanceLexer()
                    textMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                }
            }

            if (builder.currentOffset == initialPos) {
                if (builder.eof() || isAtEndTag(builder, parentTagName)) break
                builder.mark().error("Parser stalled in template content")
                builder.advanceLexer()
            }
        }
        contentMarker.done(ValkyrieElementTypes.XML_TAG_CONTENT)
    }

    // `isAtEndTag`, `parseEndTag`, `parseComment` 基本保持不变...

    /**
     * [新增] 覆盖方言钩子以解析 `props` 和 `emits` 语句
     */
    override fun parseDialectStatement(builder: PsiBuilder): Boolean {
        return when(builder.tokenType) {
            ValkyrieTokenTypes.SFC_PROPERTY, ValkyrieTokenTypes.SFC_EMITS -> parseSfcBlock(builder)
            else -> false
        }
    }

    private fun parseSfcBlock(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        val type = when(builder.tokenType) {
            ValkyrieTokenTypes.SFC_PROPERTY -> ValkyrieElementTypes.SFC_PROPS
            ValkyrieTokenTypes.SFC_EMITS -> ValkyrieElementTypes.SFC_EMITS
            else -> { marker.drop(); return false }
        }

        builder.advanceLexer() // 消费 'props' or 'emits'

        // 可选的类型参数 props<T>
        if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
            super.parseGenericParameterList(this, builder)
        }

        // 可选的代码块 props { ... }
        if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
            super.parseObjectBody(builder)
        }

        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(type)
        return true
    }

    /**
     * [新增] 覆盖方言钩子以将 XML 标签解析为表达式 (JSX-like)
     */
    override fun parseDialectPrimaryExpression(builder: PsiBuilder): Boolean {
        if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
            // 解析一个内联的 XML 元素作为表达式
            parseTag(builder, ValkyrieElementTypes.XML_ELEMENT, false)
            return true
        }
        return false
    }

    // 确保其他辅助函数如 parseAttributeValue, parseXmlSlot, isAtEndTag, parseEndTag, parseComment 存在且正确
    // ... (此处省略这些函数的代码，因为它们在你的原始实现中已经存在且大部分是正确的)
}