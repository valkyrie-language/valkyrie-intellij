package valkyrie.language.dialect_xml

import com.intellij.lang.PsiBuilder
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.psi.parsers.ValkyrieParser
import valkyrie.psi.parsers.parseTermExpression

/**
 * 解析XML元素
 */
fun parseXmlElement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
        return false
    }

    val marker = builder.mark()

    // 解析开始标签
    if (!parseXmlStartTag(builder)) {
        marker.rollbackTo()
        return false
    }

    // 解析内容和子元素
    while (!builder.eof()) {
        when (builder.tokenType) {
            XmlTokenType.XML_END_TAG_START -> {
                break
            }

            XmlTokenType.XML_DATA_CHARACTERS -> {
                builder.advanceLexer()
            }

            XmlTokenType.XML_START_TAG_START -> {
                if (!parseXmlElement(builder)) {
                    break
                }
            }

            ValkyrieTokenTypes.XML_SLOT_L -> {
                parseXmlSlotExpression(builder)
            }

            else -> {
                builder.advanceLexer()
            }
        }
    }

    // 解析结束标签
    if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
        parseXmlEndTag(builder)
    }

    marker.done(ValkyrieElementTypes.XML_ELEMENT)
    return true
}

/**
 * 解析XML开始标签
 */
private fun parseXmlStartTag(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume '<'

    // 解析标签名
    if (builder.tokenType == XmlTokenType.XML_TAG_NAME) {
        builder.advanceLexer()
    } else {
        marker.rollbackTo()
        return false
    }

    // 解析属性
    while (builder.tokenType == XmlTokenType.XML_NAME) {
        parseXmlAttribute(builder)
    }

    // 检查是否为自闭合标签
    if (builder.tokenType == XmlTokenType.XML_EMPTY_ELEMENT_END) {
        builder.advanceLexer() // consume '/>'
        marker.done(ValkyrieElementTypes.XML_ELEMENT)
        return true
    } else if (builder.tokenType == XmlTokenType.XML_TAG_END) {
        builder.advanceLexer() // consume '>'
        marker.done(ValkyrieElementTypes.XML_ELEMENT)
        return true
    }

    marker.rollbackTo()
    return false
}

/**
 * 解析XML结束标签
 */
private fun parseXmlEndTag(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_END_TAG_START) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume '</'

    if (builder.tokenType == XmlTokenType.XML_TAG_NAME) {
        builder.advanceLexer()
    }

    if (builder.tokenType == XmlTokenType.XML_TAG_END) {
        builder.advanceLexer() // consume '>'
    }

    marker.done(ValkyrieElementTypes.XML_ELEMENT)
    return true
}

/**
 * 解析XML属性
 */
private fun parseXmlAttribute(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_NAME) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // attribute name

    if (builder.tokenType == XmlTokenType.XML_EQ) {
        builder.advanceLexer() // '='

        when (builder.tokenType) {
            XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER -> {
                builder.advanceLexer() // '"'
                if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN) {
                    builder.advanceLexer()
                }
                if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                    builder.advanceLexer() // '"'
                }
            }

            ValkyrieTokenTypes.XML_SLOT_L -> {
                parseXmlSlotExpression(builder)
            }
        }
    }

    marker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
    return true
}

/**
 * 解析XML slot表达式 {expression}
 */
private fun parseXmlSlotExpression(builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.XML_SLOT_L) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume '{'

    // 解析内部表达式
    if (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
        parseTermExpression(ValkyrieParser(), builder, false)
    }

    if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
        builder.advanceLexer() // consume '}'
    }

    marker.done(ValkyrieElementTypes.XML_SLOT_EXPRESSION)
    return true
}