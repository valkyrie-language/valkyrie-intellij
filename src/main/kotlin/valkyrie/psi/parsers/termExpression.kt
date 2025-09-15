package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes


fun parseFunctionParameterList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_L) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume '('

    // 允许空参数列表
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
        // 解析第一个参数
        if (!parseFunctionParameterItem(valkyrieParser, builder)) {
            marker.error("Expected parameter")
            return false
        }

        // 解析后续参数 (, param)*
        while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer() // consume ','

            // 检查是否是尾随逗号（可选）
            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
                break // 允许尾随逗号
            }

            if (!parseFunctionParameterItem(valkyrieParser, builder)) {
                marker.error("Expected parameter after ','")
                return false
            }
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
        builder.advanceLexer() // consume ')'
    } else {
        builder.error("Expected ')'")
        return false
    }
    marker.done(ValkyrieElementTypes.TERM_PARAMETER_LIST)
    return true
}

fun parseFunctionParameterItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()

    // 解析注解
    valkyrieParser.parseAnnotations(builder, withModifiers = true)

    // 检查是否是可变参数 ..list 或任意参数 ...
    if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT || builder.tokenType == ValkyrieTokenTypes.ELLIPSIS) {
        builder.advanceLexer()
    }

    // 解析参数名
    if (!valkyrieParser.parseIdentifier(builder)) {
        builder.error("Expected parameter name")
        marker.rollbackTo()
        return false
    }

    valkyrieParser.parseTypeHint(builder)
    valkyrieParser.parseDefaultValue(builder, false)

    marker.done(ValkyrieElementTypes.TERM_PARAMETER_ITEM)
    return true
}

// f(t, u) 中的 (t, u)
fun parseFunctionArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_L) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()

    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
        // 允许空参数（只有逗号的情况）
        when (builder.tokenType) {
            ValkyrieTokenTypes.COMMA -> {
                // 创建空参数占位符
                val emptyMarker = builder.mark()
                //                    emptyMarker.done(ValkyrieElementTypes.EMPTY_ARGUMENT)
                builder.advanceLexer() // consume ','
            }

            else -> {
                parseFunctionArgumentItem(valkyrieParser, builder)

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
                    break
                }
            }
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ')'")
    }

    marker.done(ValkyrieElementTypes.ARGUMENT_LIST)
    return true
}

fun parseFunctionArgumentItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder) {
    val marker = builder.mark()

    // 检查是否是 .. 占位符参数
    if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
        builder.advanceLexer() // consume '..'
        return
    }

    // 可选的参数名
    val rollbackMarker = builder.mark()
    if (valkyrieParser.parseIdentifier(builder) && builder.tokenType == ValkyrieTokenTypes.COLON) {
        rollbackMarker.drop()
        builder.advanceLexer() // consume ':'
    } else {
        // 回退到原位置，不是参数名模式
        rollbackMarker.rollbackTo()
    }

    parseTermExpression(valkyrieParser, builder, inline = true)
    marker.done(ValkyrieElementTypes.EXPRESSION)
}

// inline 则不能使用 { } 尾随闭包
fun parseTermExpression(parser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    return parseTermExpressionWithPrecedence(parser, builder, 0, inline)
}

fun parseTermExpressionWithPrecedence(valkyrieParser: ValkyrieParser, builder: PsiBuilder, minPrecedence: Int, inline: Boolean): Boolean {
    return false
}

val termPrefixPrecedences = mapOf(
    ValkyrieTokenTypes.PLUS to 5,
    ValkyrieTokenTypes.MINUS to 5,
    ValkyrieTokenTypes.WOW to 5, // not
)


// 性能优化：缓存操作符优先级
val termInfixPrecedences = mapOf(
    ValkyrieTokenTypes.LOGIC_OR to 1,
    ValkyrieTokenTypes.LOGIC_NOR to 1,
    ValkyrieTokenTypes.LOGIC_XOR to 1,
    ValkyrieTokenTypes.LOGIC_AND to 2,
    ValkyrieTokenTypes.LOGIC_NAND to 2,
    ValkyrieTokenTypes.LOGIC_XAND to 2,
    ValkyrieTokenTypes.PIPE to 3,
    ValkyrieTokenTypes.AMPERSAND to 4,
    ValkyrieTokenTypes.AS to 4,  // 类型转换
    ValkyrieTokenTypes.EQUAL to 5,
    ValkyrieTokenTypes.NOT_EQUAL to 5,
    ValkyrieTokenTypes.IN to 5, // 包括 not in
    ValkyrieTokenTypes.IS to 5, // 模式判断, 包括 is not
    ValkyrieTokenTypes.ANGLE_L to 6,
    ValkyrieTokenTypes.ANGLE_R to 6,
    ValkyrieTokenTypes.LESS_EQUAL to 6,
    ValkyrieTokenTypes.GREATER_EQUAL to 6,
    ValkyrieTokenTypes.PLUS to 7,
    ValkyrieTokenTypes.MINUS to 7,
    ValkyrieTokenTypes.STAR to 8,
    ValkyrieTokenTypes.MULTIPLY to 8,
    ValkyrieTokenTypes.SLASH to 8,
    ValkyrieTokenTypes.INTEGER_DIVIDE to 8,
    ValkyrieTokenTypes.PERCENT to 8,
    ValkyrieTokenTypes.POWER to 9
)

val termPostfixPrecedences = mapOf(
    ValkyrieTokenTypes.WOW to 5, // not null
    ValkyrieTokenTypes.WHAT to 5, // 可选链
)