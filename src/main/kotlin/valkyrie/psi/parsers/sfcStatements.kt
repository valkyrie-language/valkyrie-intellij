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
    val nextToken = builder.lookAhead(1)
    if (nextToken != ValkyrieTokenTypes.XML_TEMPLATE) {
        // 如果不是特殊的XML_TEMPLATE token，检查是否是普通的XML_NAME且内容为"template"
        if (nextToken == XmlTokenType.XML_NAME) {
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
        if (nextToken == XmlTokenType.XML_NAME) {
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
        if (nextToken == XmlTokenType.XML_NAME) {
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
private fun parseXmlTag(parser: ValkyrieParser, builder: PsiBuilder, elementType: com.intellij.psi.tree.IElementType) {
    val marker = builder.mark()
    
    // 解析开始标签
    if (builder.tokenType == XmlTokenType.XML_START_TAG_START) {
        builder.advanceLexer() // 消费 '<'
        
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
        when (builder.tokenType) {
            XmlTokenType.XML_START_TAG_START -> {
                // 解析嵌套的XML元素
                parseNestedXmlElement(parser, builder)
            }
            XmlTokenType.XML_DATA_CHARACTERS,
            XmlTokenType.XML_WHITE_SPACE -> {
                builder.advanceLexer()
            }
            ValkyrieTokenTypes.XML_SLOT_L -> {
                parseXmlSlot(parser, builder)
            }
            ValkyrieTokenTypes.STYLE_CONTENT,
            ValkyrieTokenTypes.SCRIPT_CONTENT -> {
                // 处理style和script标签内的内容
                builder.advanceLexer()
            }
            else -> {
                // 对于其他token，直接跳过而不是尝试解析为表达式
                builder.advanceLexer()
            }
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
        if (builder.tokenType == XmlTokenType.XML_NAME) {
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
    return parser.parseExpressionRoot(builder)
}