package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * 解析 SFC template 语句
 */
fun parseSfcTemplateStatement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
        return false
    }
    
    // 检查是否是 template 标签
    if (builder.lookAhead(1) != ValkyrieTokenTypes.XML_TEMPLATE) {
        return false
    }

    val marker = builder.mark()
    parseXmlTag(builder, ValkyrieElementTypes.SFC_TEMPLATE)
    marker.done(ValkyrieElementTypes.SFC_TEMPLATE)
    return true
}

/**
 * 解析 SFC style 语句
 */
fun parseSfcStyleStatement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
        return false
    }
    
    // 检查是否是 style 标签
    if (builder.lookAhead(1) != ValkyrieTokenTypes.XML_STYLE) {
        return false
    }

    val marker = builder.mark()
    parseXmlTag(builder, ValkyrieElementTypes.SFC_STYLE)
    marker.done(ValkyrieElementTypes.SFC_STYLE)
    return true
}

/**
 * 解析 SFC script 语句
 */
fun parseSfcScriptStatement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START) {
        return false
    }
    
    // 检查是否是 script 标签
    if (builder.lookAhead(1) != ValkyrieTokenTypes.XML_SCRIPT) {
        return false
    }

    val marker = builder.mark()
    parseXmlTag(builder, ValkyrieElementTypes.SFC_SCRIPT)
    marker.done(ValkyrieElementTypes.SFC_SCRIPT)
    return true
}

/**
 * 解析通用XML标签
 */
private fun parseXmlTag(builder: PsiBuilder, elementType: com.intellij.psi.tree.IElementType) {
    // 解析开始标签
    parseXmlStartTag(builder)
    
    // 解析标签内容
    parseXmlContent(builder)
    
    // 解析结束标签
    parseXmlEndTag(builder)
}

/**
 * 解析XML开始标签 <tagname attributes>
 */
private fun parseXmlStartTag(builder: PsiBuilder) {
    // 消费 '<'
    if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
        builder.advanceLexer()
    }
    
    // 消费标签名
    if (builder.tokenType in listOf(ValkyrieTokenTypes.XML_TEMPLATE, ValkyrieTokenTypes.XML_SCRIPT, ValkyrieTokenTypes.XML_STYLE)) {
        builder.advanceLexer()
    }
    
    // 解析属性
    while (!builder.eof() && builder.tokenType != XmlTokenType.XML_TAG_END && builder.tokenType != XmlTokenType.XML_EMPTY_ELEMENT_END) {
        when (builder.tokenType) {
            XmlTokenType.XML_NAME -> parseXmlAttribute(builder)
            XmlTokenType.XML_WHITE_SPACE -> builder.advanceLexer()
            ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
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
 private fun parseXmlAttribute(builder: PsiBuilder) {
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
     parseXmlAttributeValue(builder)
     
     marker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
 }

/**
 * 解析XML属性值 "value" 或 {expression}
 */
private fun parseXmlAttributeValue(builder: PsiBuilder) {
    val marker = builder.mark()
    
    when (builder.tokenType) {
        XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER -> {
            builder.advanceLexer() // 消费开始引号
            
            while (!builder.eof() && builder.tokenType != XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                when (builder.tokenType) {
                    XmlTokenType.XML_ATTRIBUTE_VALUE_TOKEN -> builder.advanceLexer()
                    ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
                    else -> builder.advanceLexer()
                }
            }
            
            if (builder.tokenType == XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER) {
                builder.advanceLexer() // 消费结束引号
            }
        }
        ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
        else -> builder.advanceLexer()
    }
    
    marker.done(ValkyrieElementTypes.XML_ATTRIBUTE)
}

/**
 * 解析XML插槽表达式 {expression}
 */
private fun parseXmlSlot(builder: PsiBuilder) {
    val marker = builder.mark()
    
    if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_L) {
        builder.advanceLexer() // 消费 '{'
        
        // 解析内部表达式
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.XML_SLOT_R) {
            parseExpression(builder)
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
private fun parseXmlContent(builder: PsiBuilder) {
    while (!builder.eof() && !isXmlEndTag(builder)) {
        when (builder.tokenType) {
            XmlTokenType.XML_DATA_CHARACTERS -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
            }
            XmlTokenType.XML_START_TAG_START -> parseNestedXmlElement(builder)
            XmlTokenType.XML_COMMENT_START -> parseXmlComment(builder)
            ValkyrieTokenTypes.XML_SLOT_L -> parseXmlSlot(builder)
            else -> builder.advanceLexer()
        }
    }
}

/**
 * 解析嵌套的XML元素
 */
private fun parseNestedXmlElement(builder: PsiBuilder) {
    val marker = builder.mark()
    
    // 解析开始标签
    parseXmlStartTag(builder)
    
    // 如果不是自闭合标签，解析内容和结束标签
    if (builder.tokenType != XmlTokenType.XML_EMPTY_ELEMENT_END) {
        parseXmlContent(builder)
        parseXmlEndTag(builder)
    }
    
    marker.done(ValkyrieElementTypes.XML_COMMENT)
}

/**
 * 解析XML注释
 */
private fun parseXmlComment(builder: PsiBuilder) {
    val marker = builder.mark()
    
    while (!builder.eof() && builder.tokenType != XmlTokenType.XML_COMMENT_END) {
        builder.advanceLexer()
    }
    
    if (builder.tokenType == XmlTokenType.XML_COMMENT_END) {
        builder.advanceLexer()
    }
    
    marker.done(ValkyrieElementTypes.XML_ELEMENT)
}

/**
 * 解析XML结束标签 </tagname>
 */
private fun parseXmlEndTag(builder: PsiBuilder) {
    if (builder.tokenType == XmlTokenType.XML_END_TAG_START) {
        builder.advanceLexer() // 消费 '</'
        
        // 消费标签名
        if (builder.tokenType in listOf(ValkyrieTokenTypes.XML_TEMPLATE, ValkyrieTokenTypes.XML_SCRIPT, ValkyrieTokenTypes.XML_STYLE, XmlTokenType.XML_NAME)) {
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
private fun isXmlEndTag(builder: PsiBuilder): Boolean {
    return builder.tokenType == XmlTokenType.XML_END_TAG_START
}

/**
 * 解析表达式（简化版本，用于XML插槽）
 */
private fun parseExpression(builder: PsiBuilder) {
    when (builder.tokenType) {
        ValkyrieTokenTypes.SYMBOL_XID -> builder.advanceLexer()
        ValkyrieTokenTypes.STRING_DQ, ValkyrieTokenTypes.STRING_MQ -> builder.advanceLexer()
        ValkyrieTokenTypes.INTEGER -> builder.advanceLexer()
        ValkyrieTokenTypes.DECIMAL -> builder.advanceLexer()
        else -> builder.advanceLexer()
    }
}