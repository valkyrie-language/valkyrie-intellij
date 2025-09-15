package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes


fun parseFunctionParameterList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_L) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume '('

    // 允许空参数列表
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
        // 解析第一个参数
        if (!parseFunctionParameterItem(valkyrieParser, builder)) {
            marker.error("Expected parameter")
            return false
        }

        // 解析后续参数 (, param)*
        while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer() // consume ','

            // 检查是否是尾随逗号（可选）
            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                break // 允许尾随逗号
            }

            if (!parseFunctionParameterItem(valkyrieParser, builder)) {
                marker.error("Expected parameter after ','")
                return false
            }
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
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
fun parseTermArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_L) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()

    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
        // 允许空参数（只有逗号的情况）
        when (builder.tokenType) {
            ValkyrieTokenTypes.COMMA -> {
                // 创建空参数占位符
                val emptyMarker = builder.mark()
                //                    emptyMarker.done(ValkyrieElementTypes.EMPTY_ARGUMENT)
                builder.advanceLexer() // consume ','
            }

            else -> {
                parseTermArgumentItem(valkyrieParser, builder)

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
                    break
                }
            }
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ')'")
    }

    marker.done(ValkyrieElementTypes.ARGUMENT_LIST)
    return true
}

fun parseTermArgumentItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder) {
    val marker = builder.mark()

    // 检查是否是 .. 占位符参数
    if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
        builder.advanceLexer() // consume '..'
//            marker.done(ValkyrieElementTypes.PLACEHOLDER_ARGUMENT)
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

fun parseTermExpressionWithPrecedence(valkyrieParser: ValkyrieParser, builder: PsiBuilder, minPrecedence: Int, inline: Boolean): Boolean {
    // 解析前缀表达式
    var left = parsePrefixTermExpression(valkyrieParser, builder) ?: return false

    // 解析中缀表达式和后缀表达式
    while (true) {
        val tokenType = builder.tokenType

        // 先检查后缀操作符
        if (isTermPostfixOperator(tokenType)) {
            left = parsePostfixTermExpression(valkyrieParser, builder, left)
            continue
        }

        // 检查复合操作符 "is not" 和 "not in"
        val isCompoundOperator = checkCompoundOperator(builder)
        if (isCompoundOperator != null) {
            val precedence = getCompoundOperatorPrecedence(isCompoundOperator)
            if (precedence >= minPrecedence) {
                val marker = left.precede()

                // 消费复合操作符的两个token
                builder.advanceLexer() // 消费第一个token (is/not)
                builder.advanceLexer() // 消费第二个token (not/in)

                // 解析右操作数
                if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, precedence + 1, inline)) {
                    marker.error("Expected right operand")
                    valkyrieParser.recoverToSyncPoint(builder)
                    return false
                }

                marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
                left = marker
                continue
            }
        }

        // 再检查单个token中缀操作符
        val precedence = getTermOperatorPrecedence(tokenType)
        if (precedence < minPrecedence || !isTermInfixOperator(tokenType)) {
            break
        }

        val marker = left.precede()
        builder.advanceLexer() // 消费操作符

        // 解析右操作数
        if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, precedence + 1, inline)) {
            marker.error("Expected right operand")
            valkyrieParser.recoverToSyncPoint(builder)
            return false
        }

        marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
        left = marker
    }

    return true
}

fun parsePrimaryTerm(builder: PsiBuilder): PsiBuilder.Marker? {
    return builder.markIdentifier()
        ?: builder.markTokenAsElement(ValkyrieTokenTypes.INTEGER, ValkyrieElementTypes.INTEGER_LITERAL)
        ?: builder.markTokenAsElement(ValkyrieTokenTypes.DECIMAL, ValkyrieElementTypes.DECIMAL_LITERAL)
        ?: builder.markTokenAsElement(ValkyrieTokenTypes.BOOLEAN, ValkyrieElementTypes.BOOLEAN_LITERAL)
        ?: builder.markTokenAsElement(ValkyrieTokenTypes.STRING_DQ, ValkyrieElementTypes.LITERAL_EXPRESSION)
//            ?: builder.markTokenAsElement(ValkyrieTokenType.NULL, ValkyrieElementTypes.NULL_LITERAL)
}

/**
 * 获取复合操作符的优先级
 */
fun getCompoundOperatorPrecedence(compoundOperator: String): Int {
    return when (compoundOperator) {
        "is_not" -> termInfixPrecedences[ValkyrieTokenTypes.IS] ?: 0
        "not_in" -> termInfixPrecedences[ValkyrieTokenTypes.IN] ?: 0
        else -> 0
    }
}

/**
 * 检查当前位置是否是复合操作符 "is not" 或 "not in"
 * @return 复合操作符类型，如果不是复合操作符则返回null
 */
fun checkCompoundOperator(builder: PsiBuilder): String? {
    val currentToken = builder.tokenType
    val nextToken = builder.lookAhead(1)

    return when {
        currentToken == ValkyrieTokenTypes.IS && nextToken == ValkyrieTokenTypes.NOT -> "is_not"
        currentToken == ValkyrieTokenTypes.NOT && nextToken == ValkyrieTokenTypes.IN -> "not_in"
        else -> null
    }
}

fun getTermOperatorPrecedence(tokenType: IElementType?): Int {
    return termInfixPrecedences[tokenType] ?: 0
}

fun isTermPrefixOperator(tokenType: IElementType?): Boolean {
    return when (tokenType) {
        ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.AMPERSAND -> true

        else -> false
    }
}

fun isTermInfixOperator(tokenType: IElementType?): Boolean {
    return when (tokenType) {
        ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.MULTIPLY, ValkyrieTokenTypes.SLASH, ValkyrieTokenTypes.INTEGER_DIVIDE, ValkyrieTokenTypes.PERCENT, ValkyrieTokenTypes.POWER, ValkyrieTokenTypes.EQUAL, ValkyrieTokenTypes.NOT_EQUAL, ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.ANGLE_R, ValkyrieTokenTypes.LESS_EQUAL, ValkyrieTokenTypes.GREATER_EQUAL, ValkyrieTokenTypes.LOGIC_AND, ValkyrieTokenTypes.LOGIC_OR, ValkyrieTokenTypes.LOGIC_XOR, ValkyrieTokenTypes.LOGIC_NAND, ValkyrieTokenTypes.LOGIC_NOR, ValkyrieTokenTypes.LOGIC_XAND, ValkyrieTokenTypes.PIPE, ValkyrieTokenTypes.AMPERSAND, ValkyrieTokenTypes.AS, ValkyrieTokenTypes.IN, ValkyrieTokenTypes.IS -> true

        else -> false
    }
}

fun isTermPostfixOperator(tokenType: IElementType?): Boolean {
    return when (tokenType) {
        ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WHAT, ValkyrieTokenTypes.PARENTHESES_L, ValkyrieTokenTypes.ARRAY_L, ValkyrieTokenTypes.DOT, ValkyrieTokenTypes.DOUBLE_COLON, ValkyrieTokenTypes.GENERIC_L -> true

        else -> false
    }
}

fun parsePostfixTermExpression(valkyrieParser: ValkyrieParser, builder: PsiBuilder, left: PsiBuilder.Marker): PsiBuilder.Marker {
    val tokenType = builder.tokenType

    if (!isTermPostfixOperator(tokenType)) {
        return left
    }

    val marker = left.precede()
    builder.advanceLexer() // 消费后缀操作符

    if (parseGenericArgumentList(valkyrieParser, builder, false)) {
        marker.done(ValkyrieElementTypes.CALL_TYPE_ARGUMENT)
        return marker
    } else {
        marker.drop()
        return left
    }
}

fun parsePrefixTermExpression(valkyrieParser: ValkyrieParser, builder: PsiBuilder): PsiBuilder.Marker? {
    val tokenType = builder.tokenType

    // 检查前缀操作符
    if (isTermPrefixOperator(tokenType)) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费前缀操作符

        if (parsePrefixTermExpression(valkyrieParser, builder) == null) {
            marker.error("Expected operand after prefix operator")
            valkyrieParser.recoverToSyncPoint(builder)
            return null
        }

        marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
        return marker
    }

    // 解析主要表达式
    return parsePrimaryTerm(builder)
}

// inline 则不能使用 { } 尾随闭包
fun parseTermExpression(valkyrieParser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    return parseTermExpressionWithPrecedence(valkyrieParser, builder, 0, inline)
}

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
    ValkyrieTokenTypes.IN to 5,
    ValkyrieTokenTypes.IS to 5,
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
