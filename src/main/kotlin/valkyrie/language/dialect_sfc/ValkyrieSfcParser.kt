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
        builder.setDebugMode(true)
        val rootMarker = builder.mark()

        // 专门处理SFC文件的解析逻辑
        while (!builder.eof()) {
            val initialPosition = builder.currentOffset

            // 尝试解析SFC特定的语句
            val parsed = when {
                // 解析template标签
                isTemplateTag(builder) -> {
                    parseSfcTemplateStatement(this, builder)
                }
                // 解析script标签
                isScriptTag(builder) -> {
                    parseSfcScriptStatement(this, builder)
                }
                // 解析style标签
                isStyleTag(builder) -> {
                    parseSfcStyleStatement(this, builder)
                }
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
                    marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                    true
                }
                // 尝试使用父类的parseStatement方法
                else -> {
                    val marker = builder.mark()
                    builder.advanceLexer()
                    marker.error("Unexpected token")
                    true
                }
            }

            // 如果没有任何进展，强制前进一个token避免无限循环
            if (builder.currentOffset == initialPosition) {
                if (!builder.eof()) {
                    builder.advanceLexer()
                }
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 检查是否是template标签
     */
    private fun isTemplateTag(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }

        val nextToken = builder.lookAhead(1)
        return when (nextToken) {
            ValkyrieTokenTypes.XML_TEMPLATE -> true
            XmlTokenType.XML_TAG_NAME -> {
                // 检查标签名是否为"template"
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo()
                tagName == "template"
            }

            else -> false
        }
    }

    /**
     * 检查是否是script标签
     */
    private fun isScriptTag(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }

        val nextToken = builder.lookAhead(1)
        return when (nextToken) {
            ValkyrieTokenTypes.XML_SCRIPT -> true
            XmlTokenType.XML_TAG_NAME -> {
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo()
                tagName == "script"
            }

            else -> false
        }
    }

    /**
     * 检查是否是style标签
     */
    private fun isStyleTag(builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }

        val nextToken = builder.lookAhead(1)
        return when (nextToken) {
            ValkyrieTokenTypes.XML_STYLE -> true
            XmlTokenType.XML_TAG_NAME -> {
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo()
                tagName == "style"
            }

            else -> false
        }
    }

    /**
     * 解析XML注释
     */
    private fun parseXmlComment(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费注释开始
        if (builder.tokenType == XmlTokenType.XML_COMMENT_START) {
            builder.advanceLexer()
        }

        // 消费注释内容
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_COMMENT_END) {
            builder.advanceLexer()
        }

        // 消费注释结束
        if (builder.tokenType == XmlTokenType.XML_COMMENT_END) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.XML_COMMENT)
    }

    /**
     * 解析 SFC template 语句
     */
    fun parseSfcTemplateStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }

        // 检查是否是 template 标签
        val nextToken = builder.lookAhead(1)
        if (nextToken != ValkyrieTokenTypes.XML_TEMPLATE) {
            // 如果不是特殊的XML_TEMPLATE token，检查是否是普通的XML_NAME且内容为"template"
            if (nextToken == XmlTokenType.XML_TAG_NAME) {
                // 需要临时前进到下一个token来获取文本
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo() // 回滚到原位置
                if (tagName != "template") {
                    return false
                }
            } else {
                return false
            }
        }

        // 解析template标签，使用SFC_TEMPLATE类型
        parseXmlTag(parser, builder, ValkyrieElementTypes.SFC_TEMPLATE)
        return true
    }

    /**
     * 解析 SFC style 语句
     */
    fun parseSfcStyleStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }

        // 检查是否是 style 标签
        val nextToken = builder.lookAhead(1)
        if (nextToken != ValkyrieTokenTypes.XML_STYLE) {
            // 如果不是特殊的XML_STYLE token，检查是否是普通的XML_NAME且内容为"style"
            if (nextToken == XmlTokenType.XML_TAG_NAME) {
                // 需要临时前进到下一个token来获取文本
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo() // 回滚到原位置
                if (tagName != "style") {
                    return false
                }
            } else {
                return false
            }
        }

        // 解析style标签，使用SFC_STYLE类型
        parseXmlTag(parser, builder, ValkyrieElementTypes.SFC_STYLE)
        return true
    }

    /**
     * 解析 SFC script 语句
     */
    fun parseSfcScriptStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
        if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
            return false
        }

        // 检查是否是 script 标签
        val nextToken = builder.lookAhead(1)
        if (nextToken != ValkyrieTokenTypes.XML_SCRIPT) {
            // 如果不是特殊的XML_SCRIPT token，检查是否是普通的XML_NAME且内容为"script"
            if (nextToken == XmlTokenType.XML_TAG_NAME) {
                // 需要临时前进到下一个token来获取文本
                val marker = builder.mark()
                builder.advanceLexer() // 跳过 '<'
                val tagName = builder.tokenText
                marker.rollbackTo() // 回滚到原位置
                if (tagName != "script") {
                    return false
                }
            } else {
                return false
            }
        }

        // 解析script标签，使用SFC_SCRIPT类型
        parseXmlTag(parser, builder, ValkyrieElementTypes.SFC_SCRIPT)
        return true
    }

    /**
     * 解析XML标签的通用方法
     */
    private fun parseXmlTag(parser: ValkyrieParser, builder: PsiBuilder, elementType: IElementType) {
        val marker = builder.mark()

        // 解析开始标签
        if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
            builder.advanceLexer() // 消费 '<'

            // 消费标签名
            if (builder.tokenType in listOf(
                    ValkyrieTokenTypes.XML_TEMPLATE,
                    ValkyrieTokenTypes.XML_SCRIPT,
                    ValkyrieTokenTypes.XML_STYLE,
                    XmlTokenType.XML_TAG_NAME
                )
            ) {
                builder.advanceLexer()
            }

            // 跳过属性
            while (!builder.eof() && builder.tokenType != XmlTokenType.XML_TAG_END && builder.tokenType != XmlTokenType.XML_EMPTY_ELEMENT_END) {
                builder.advanceLexer()
            }

            // 检查是否是自闭合标签
            val isSelfClosing = builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END

            // 消费 '>' 或 '/>'
            if (builder.tokenType == XmlTokenType.XML_TAG_END || builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
                builder.advanceLexer()
            }

            // 如果不是自闭合标签，解析内容和结束标签
            if (!isSelfClosing) {
                // 解析标签内容
                parseXmlContent(parser, builder)

                // 解析结束标签
                if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
                    builder.advanceLexer() // 消费 '</'

                    // 消费结束标签名
                    if (builder.tokenType in listOf(
                            ValkyrieTokenTypes.XML_TEMPLATE,
                            ValkyrieTokenTypes.XML_SCRIPT,
                            ValkyrieTokenTypes.XML_STYLE,
                            XmlTokenType.XML_NAME
                        )
                    ) {
                        builder.advanceLexer()
                    }

                    // 消费 '>'
                    if (builder.tokenType == XmlTokenType.XML_TAG_END) {
                        builder.advanceLexer()
                    }
                }
            }
        }

        marker.done(elementType)
    }

    /**
     * 解析XML内容
     */
    private fun parseXmlContent(parser: ValkyrieParser, builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != XmlTokenType.XML_END_TAG_START) {
            val initialPosition = builder.currentOffset

            when (builder.tokenType) {
                XmlTokenType.XML_START_TAG_START -> {
                    // 解析嵌套的XML元素
                    parseNestedXmlElement(parser, builder)
                }

                XmlTokenType.XML_DATA_CHARACTERS -> {
                    // 创建文本节点而不是直接跳过
                    val textMarker = builder.mark()
                    builder.advanceLexer()
                    textMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                }

                XmlTokenType.XML_WHITE_SPACE -> {
                    builder.advanceLexer()
                }

                ValkyrieTokenTypes.XML_SLOT_L -> {
                    parseXmlSlot(parser, builder)
                }

                ValkyrieTokenTypes.STYLE_CONTENT,
                ValkyrieTokenTypes.SCRIPT_CONTENT -> {
                    // 处理style和script标签内的内容
                    val contentMarker = builder.mark()
                    builder.advanceLexer()
                    contentMarker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                }

                else -> {
                    // 对于其他token，直接跳过而不是尝试解析为表达式
                    builder.advanceLexer()
                }
            }

            // 防止无限循环
            if (builder.currentOffset == initialPosition) {
                builder.advanceLexer()
            }
        }
    }

    /**
     * 解析嵌套的XML元素
     */
    private fun parseNestedXmlElement(parser: ValkyrieParser, builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析开始标签
        if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
            builder.advanceLexer() // 消费 '<'

            // 消费标签名
            if (builder.tokenType == XmlTokenType.XML_TAG_NAME) {
                builder.advanceLexer()
            }

            // 跳过属性
            while (!builder.eof() && builder.tokenType != XmlTokenType.XML_TAG_END && builder.tokenType != XmlTokenType.XML_EMPTY_ELEMENT_END) {
                builder.advanceLexer()
            }

            // 检查是否是自闭合标签
            val isSelfClosing = builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END

            // 消费 '>' 或 '/>'
            if (builder.tokenType == XmlTokenType.XML_TAG_END || builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
                builder.advanceLexer()
            }

            // 如果不是自闭合标签，解析内容和结束标签
            if (!isSelfClosing) {
                // 解析标签内容
                parseXmlContent(parser, builder)

                // 解析结束标签
                if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
                    builder.advanceLexer() // 消费 '</'

                    // 消费结束标签名
                    if (builder.tokenType == XmlTokenType.XML_NAME) {
                        builder.advanceLexer()
                    }

                    // 消费 '>'
                    if (builder.tokenType == XmlTokenType.XML_TAG_END) {
                        builder.advanceLexer()
                    }
                }
            }
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
            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
                parseExpression(parser, builder)
            }

            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
                builder.advanceLexer() // 消费 '}'
            }
        }

        marker.done(ValkyrieElementTypes.XML_SLOT_EXPRESSION)
    }

    /**
     * 解析Valkyrie表达式
     */
    private fun parseExpression(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
        return parser.parseExpressionStatement(builder)
    }
}
