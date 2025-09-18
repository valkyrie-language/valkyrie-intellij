package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * 解析 SFC template 语句
 */
fun parseSfcTemplateStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
        return false
    }

    // 检查是否是 template 标签
    if (builder.lookAhead(1) != ValkyrieTokenTypes.XML_TEMPLATE) {
        return false
    }

    val marker = builder.mark()
    parseXmlTag(parser, builder, ValkyrieElementTypes.SFC_TEMPLATE)
    marker.done(ValkyrieElementTypes.SFC_TEMPLATE)
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
    if (builder.lookAhead(1) != ValkyrieTokenTypes.XML_STYLE) {
        return false
    }

    val marker = builder.mark()
    parseXmlTag(parser, builder, ValkyrieElementTypes.SFC_STYLE)
    marker.done(ValkyrieElementTypes.SFC_STYLE)
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
    if (builder.lookAhead(1) != ValkyrieTokenTypes.XML_SCRIPT) {
        return false
    }

    val marker = builder.mark()
    parseXmlTag(parser, builder, ValkyrieElementTypes.SFC_SCRIPT)
    marker.done(ValkyrieElementTypes.SFC_SCRIPT)
    return true
}

/**
 * 解析通用XML标签
 */
private fun parseXmlTag(parser: ValkyrieParser, builder: PsiBuilder, elementType: com.intellij.psi.tree.IElementType) {
    // 解析开始标签
    parseXmlStartTag(parser, builder)

    // 解析标签内容
    parseXmlContent(parser, builder)

    // 解析结束标签
    parseXmlEndTag(parser, builder)
}

/**
 * 解析XML开始标签 <tagname attributes>
 */
private fun parseXmlStartTag(parser: ValkyrieParser, builder: PsiBuilder) {
    // 消费 '<'
    if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
        builder.advanceLexer()
    }

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

    // 解析属性
    while (!builder.eof() && builder.tokenType != XmlTokenType.XML_TAG_END && builder.tokenType != XmlTokenType.XML_EMPTY_ELEMENT_END) {
        when (builder.tokenType) {
            XmlTokenType.XML_NAME -> parseXmlAttribute(parser, builder)
            XmlTokenType.XML_WHITE_SPACE -> builder.advanceLexer()
            ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(parser, builder)
            else -> builder.advanceLexer()
        }
    }

    // 消费 '>' 或 '/>'
    if (builder.tokenType == XmlTokenType.XML_TAG_END || builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
        builder.advanceLexer()
    }
}

/**
 * 解析XML属性 name="value"
 */
private fun parseXmlAttribute(parser: ValkyrieParser, builder: PsiBuilder) {
    val marker = builder.mark()

    // 属性名
    if (builder.tokenType == XmlTokenType.XML_NAME) {
        builder.advanceLexer()
    }

    // 等号
    if (builder.tokenType == XmlTokenType.XML_EQ) {
        builder.advanceLexer()
    }

    // 属性值
    parseXmlAttributeValue(parser, builder)

    marker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
}

/**
 * 解析XML属性值 "value" 或 {expression}
 */
private fun parseXmlAttributeValue(parser: ValkyrieParser, builder: PsiBuilder) {
    val marker = builder.mark()

    when (builder.tokenType) {
        XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER -> {
            builder.advanceLexer() // 消费开始引号

            while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                when (builder.tokenType) {
                    XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN -> builder.advanceLexer()
                    ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(parser, builder)
                    else -> builder.advanceLexer()
                }
            }

            if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                builder.advanceLexer() // 消费结束引号
            }
        }

        ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(parser, builder)
        else -> builder.advanceLexer()
    }

    marker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
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
            parseTermExpression(parser, builder, false)
        }

        if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
            builder.advanceLexer() // 消费 '}'
        }
    }

    marker.done(ValkyrieElementTypes.XML_SLOT_EXPRESSION)
}

/**
 * 解析XML标签内容
 */
private fun parseXmlContent(parser: ValkyrieParser, builder: PsiBuilder) {
    while (!builder.eof() && !isXmlEndTag(parser, builder)) {
        var parsed = false

        when (builder.tokenType) {
            XmlTokenType.XML_DATA_CHARACTERS -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                parsed = true
            }

            XmlTokenType.XML_START_TAG_START -> {
                parseNestedXmlElement(parser, builder)
                parsed = true
            }

            XmlTokenType.XML_COMMENT_CHARACTERS -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.XML_COMMENT)
                parsed = true
            }

            ValkyrieTokenTypes.XML_SLOT_L -> {
                parseXmlSlot(parser, builder)
                parsed = true
            }
            // 处理 script 标签内的 Valkyrie 代码
            ValkyrieTokenTypes.COMMENT_LINE -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.XML_COMMENT)
                parsed = true
            }

            ValkyrieTokenTypes.STYLE_CONTENT -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
                parsed = true
            }

            else -> {
                // 对于其他token，尝试解析Valkyrie语句或表达式
                if (parser.parseStatement(builder)) {
                    parsed = true
                } else {
                    // 如果无法解析为Valkyrie语句，跳过当前token
                    builder.advanceLexer()
                    parsed = true
                }
            }
        }

        // 如果没有成功解析任何内容，跳过当前token避免死循环
        if (!parsed) {
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
    parseXmlStartTag(parser, builder)

    // 如果不是自闭合标签，解析内容和结束标签
    if (builder.tokenType != XmlTokenType.XML_EMPTY_ELEMENT_END) {
        parseXmlContent(parser, builder)
        parseXmlEndTag(parser, builder)
    }

    marker.done(ValkyrieElementTypes.XML_ELEMENT)
}

/**
 * 解析XML结束标签 </tagname>
 */
private fun parseXmlEndTag(parser: ValkyrieParser, builder: PsiBuilder) {
    if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
        builder.advanceLexer() // 消费 '</'

        // 消费标签名
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

/**
 * 检查是否是XML结束标签
 */
private fun isXmlEndTag(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    return builder.tokenType == XmlTokenType.XML_END_TAG_START
}
