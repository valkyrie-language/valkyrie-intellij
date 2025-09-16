package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
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
            marker.drop();
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
                marker.drop();
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

// f(t, u, k: v, ...) 中的 (t, u, k: v, ...)
fun parseFunctionArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_L) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()

    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
        parseFunctionArgumentItem(valkyrieParser, builder)

        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
            break
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
        // consume '..'
        builder.advanceLexer()
    }

    // 可选的参数名
    val rollbackMarker = builder.mark()
    if (valkyrieParser.parseIdentifier(builder) && builder.tokenType == ValkyrieTokenTypes.COLON) {
        rollbackMarker.drop()
        // consume ':'
        builder.advanceLexer()
    }
    // 回退到原位置，不是参数名模式
    else {
        rollbackMarker.rollbackTo()
    }

    parseTermExpression(valkyrieParser, builder, inline = true)
    marker.done(ValkyrieElementTypes.EXPRESSION)
}

/**
 * 解析 term 级别的表达式，这是 Pratt 解析器的入口点。
 *
 * @param parser ValkyrieParser 的实例。
 * @param builder PsiBuilder，用于构建语法树。
 * @param inline 一个布尔值，指示当前上下文是否为 "inline"。
 *               在 inline 上下文中，不允许使用尾随闭包 `{}` 语法，
 *               以避免在如 `for i in 0..10 { ... }` 这样的结构中产生歧义。
 * @return 如果成功解析了一个表达式，则返回 true。
 */
fun parseTermExpression(parser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    return parseTermExpressionWithPrecedence(parser, builder, 0, inline)
}

/**
 * Pratt 解析器的核心实现。
 * 它根据运算符优先级递归地解析表达式。
 *
 * @param minPrecedence 当前递归层级需要处理的最小运算符优先级。
 */
fun parseTermExpressionWithPrecedence(
    valkyrieParser: ValkyrieParser,
    builder: PsiBuilder,
    minPrecedence: Int,
    inline: Boolean,
): Boolean {
    var lhs_marker: PsiBuilder.Marker? = null

    // "NUD" (Null Denotation) 阶段：处理前缀表达式和原子表达式
    val prefix_precedence = termPrefixPrecedences[builder.tokenType]
    if (prefix_precedence != null) {
        // 处理前缀表达式（如 +a, -a, !a）
        lhs_marker = builder.mark()
        builder.advanceLexer() // 吃掉前缀运算符

        // 递归解析右侧表达式
        if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, prefix_precedence, inline)) {
            lhs_marker.error("在前缀运算符后需要一个表达式")
            return false
        }
        lhs_marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
        lhs_marker = null // 重置标记，因为前缀表达式已经完成
    } else if (parsePrimaryTerm(valkyrieParser, builder, inline)) {
        // 成功解析了一个原子表达式（如变量、字面量、if/match 表达式等）。
        // parsePrimaryTerm 已经创建了相应的节点
        // 总是为后续的中缀/后缀处理创建新的标记
        lhs_marker = builder.mark()

        // 如果没有后续的中缀/后缀操作符，完成标记并返回成功
        if (termPostfixPrecedences[builder.tokenType] == null && termInfixPrecedences[builder.tokenType] == null) {
            lhs_marker.done(ValkyrieElementTypes.EXPRESSION)
            return true
        }
    } else {
        // 既不是前缀表达式，也不是原子表达式的开头，说明这里不是一个有效的表达式。
        return false
    }

    // "LED" (Left Denotation) 循环：处理中缀和后缀运算符
    while (true) {
        val current_token = builder.tokenType
        // 特殊处理复合关键字，因为它们由多个 token 组成
        if (current_token == ValkyrieTokenTypes.IS && builder.lookAhead(1) == ValkyrieTokenTypes.NOT) {
            val is_not_precedence = termInfixPrecedences[ValkyrieTokenTypes.IS]!!
            if (is_not_precedence < minPrecedence) break

            val is_not_marker = if (lhs_marker != null) {
                lhs_marker.precede()
            } else {
                builder.mark()
            }
            builder.advanceLexer() // a is
            builder.advanceLexer() // a is not
            // 'is not' 的右侧是一个模式表达式
            if (!parseTypeExpression(valkyrieParser, builder, true)) { // 简化处理：暂时用类型表达式代替模式表达式
                is_not_marker.error("在 'is not' 后需要一个模式")
                return false
            }
            is_not_marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
            lhs_marker = null
            continue
        }
        if (current_token == ValkyrieTokenTypes.NOT && builder.lookAhead(1) == ValkyrieTokenTypes.IN) {
            val not_in_precedence = termInfixPrecedences[ValkyrieTokenTypes.IN]!!
            if (not_in_precedence < minPrecedence) break

            val not_in_marker = if (lhs_marker != null) {
                lhs_marker.precede()
            } else {
                builder.mark()
            }
            builder.advanceLexer() // a not
            builder.advanceLexer() // a not in
            // 'not in' 的右侧是一个 term 表达式
            if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, not_in_precedence + 1, inline)) {
                not_in_marker.error("在 'not in' 后需要一个表达式")
                return false
            }
            not_in_marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
            lhs_marker = null
            continue
        }

        val postfix_precedence = termPostfixPrecedences[current_token]
        val infix_precedence = termInfixPrecedences[current_token]

        if (postfix_precedence != null && postfix_precedence >= minPrecedence) {
            // 处理后缀表达式
            val postfix_marker = if (lhs_marker != null) {
                lhs_marker.precede()
            } else {
                builder.mark()
            }
            when (current_token) {
                // 函数调用: f() 或 f?.()
                ValkyrieTokenTypes.PARENTHESIS_L -> {
                    parseFunctionArgumentList(valkyrieParser, builder)
                    // 检查尾随闭包 f() {}
                    if (builder.tokenType == ValkyrieTokenTypes.BRACE_L && !inline) {
                        val closure_marker = postfix_marker.precede()
                        valkyrieParser.parseFnBody(builder)
                        closure_marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                        postfix_marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    } else {
                        postfix_marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    }
                }
                // 索引访问: a[] 或 a?[]
//                ValkyrieTokenTypes.BRACKET_L -> {
//                    builder.advanceLexer() // 吃掉 '['
//                    valkyrieParser.parseIndexExpression(builder)
//                    valkyrieParser.expect(builder, ValkyrieTokenTypes.BRACKET_R, "期待一个 ']'")
//                    postfix_marker.done(ValkyrieElementTypes.INDEX_EXPRESSION)
//                }
                // 成员访问: a.b 或 a?.b
                ValkyrieTokenTypes.DOT -> {
                    builder.advanceLexer() // 吃掉 '.'
                    valkyrieParser.parseIdentifier(builder)
                    postfix_marker.done(ValkyrieElementTypes.EXPRESSION)
                }
                // 可空链式调用: a?
                // 它本身是一个完整的表达式，但通常后面紧跟 .、( 或 [
                ValkyrieTokenTypes.WHAT -> {
                    builder.advanceLexer() // 吃掉 '?'
                    postfix_marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION) // Using a general postfix expression type
                }
                // 泛型参数: a::<T>
                ValkyrieTokenTypes.DOUBLE_COLON -> {
                    parseGenericArgumentList(valkyrieParser, builder, false)
                    postfix_marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION) // Using a general postfix expression type
                }
                // 其他单 token 后缀运算符
                else -> {
                    builder.advanceLexer()
                    postfix_marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION)
                }
            }
            // 为下一次循环重置标记
            lhs_marker = null
            continue // 继续循环以处理链式调用，如 a.b()
        }

        if (infix_precedence != null && infix_precedence >= minPrecedence) {
            // 处理中缀表达式
            val infix_marker = if (lhs_marker != null) {
                lhs_marker.precede()
            } else {
                builder.mark()
            }
            builder.advanceLexer() // 吃掉运算符

            // 根据运算符的结合性调整下一次递归的最小优先级
            val next_min_precedence = if (current_token == ValkyrieTokenTypes.POWER) {
                infix_precedence // 右结合
            } else {
                infix_precedence + 1 // 左结合
            }

            // 特殊处理某些运算符的右侧 (RHS)
            val rhsParsed = when (current_token) {
                ValkyrieTokenTypes.AS -> parseTypeExpression(valkyrieParser, builder, true)
                ValkyrieTokenTypes.IS -> parseTypeExpression(valkyrieParser, builder, true) // 简化处理：暂时用类型表达式代替模式表达式
                else -> parseTermExpressionWithPrecedence(valkyrieParser, builder, next_min_precedence, inline)
            }
            if (!rhsParsed) {
                infix_marker.error("在二元运算符后需要一个表达式")
                return false
            }

            infix_marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            lhs_marker = null // 重置标记
            continue
        }

        break // No more operators with sufficient precedence
    }

    lhs_marker?.done(ValkyrieElementTypes.EXPRESSION) // Finalize the entire expression
    return true
}

/**
 * 解析原子表达式，这些是构成复杂表达式的基本单元。
 */
fun parsePrimaryTerm(parser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    val marker = builder.mark()
    when (builder.tokenType) {
        // 字面量
        ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL -> {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.LITERAL_EXPRESSION)
            return true
        }
        // 布尔字面量
        ValkyrieTokenTypes.BOOLEAN -> {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.LITERAL_EXPRESSION)
            return true
        }
        // 标识符或路径
        ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.IDENTIFIER_RAW -> {
            parser.parseNamePath(builder, false)
            marker.drop() // parseNamePath creates its own marker
            return true
        }
        // 分组表达式: (expr)
//        ValkyrieTokenTypes.PARENTHESIS_L -> {
//            builder.advanceLexer()
//            parseTermExpression(parser, builder, false)
//            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
//                builder.advanceLexer()
//            } else {
//                builder.error("需要 ')' 来闭合分组表达式")
//            }
//            marker.done(ValkyrieElementTypes.GROUP_EXPRESSION)
//            return true
//        }
//        // 代码块表达式: { ... }
//        ValkyrieTokenTypes.BRACE_L -> {
//            parser.parseBlock(builder, false)
//            marker.drop()
//            return true
//        }
//        // Lambda 表达式: |a, b| -> c
//        ValkyrieTokenTypes.PIPE, ValkyrieTokenTypes.DOUBLE_PIPE -> {
//            parser.parseLambda(builder)
//            marker.drop()
//            return true
//        }
//        // If 表达式
//        ValkyrieTokenTypes.KW_IF -> {
//            parser.parseIf(builder)
//            marker.drop()
//            return true
//        }
//        // Match 表达式
//        ValkyrieTokenTypes.KW_MATCH -> {
//            parser.parseMatch(builder)
//            marker.drop()
//            return true
//        }
//        // While 循环
//        ValkyrieTokenTypes.KW_WHILE -> {
//            parser.parseWhile(builder)
//            marker.drop()
//            return true
//        }
//        // For 循环
//        ValkyrieTokenTypes.KW_FOR -> {
//            parser.parseFor(builder)
//            marker.drop()
//            return true
//        }
        else -> {
            marker.drop()
            return false
        }
    }
}


val termPrefixPrecedences = mapOf(
    ValkyrieTokenTypes.PLUS to 10,  // 正号
    ValkyrieTokenTypes.MINUS to 10, // 负号
    ValkyrieTokenTypes.NOT to 10,   // 逻辑非 (在 Valkyrie 中用 `!` 表示)
//    ValkyrieTokenTypes.TILDE to 10, // 按位非
)

val termInfixPrecedences = mapOf(
    ValkyrieTokenTypes.ASSIGN to 1,
    // ...
    ValkyrieTokenTypes.LOGIC_OR to 1,
    ValkyrieTokenTypes.LOGIC_XOR to 2,
    ValkyrieTokenTypes.LOGIC_AND to 3,

    ValkyrieTokenTypes.EQUAL to 4,
    ValkyrieTokenTypes.NOT_EQUAL to 4,
    ValkyrieTokenTypes.ANGLE_L to 4,
    ValkyrieTokenTypes.ANGLE_R to 4,
    ValkyrieTokenTypes.LESS_EQUAL to 4,
    ValkyrieTokenTypes.GREATER_EQUAL to 4,

    ValkyrieTokenTypes.IS to 5, // 包括 is not
    ValkyrieTokenTypes.IN to 5, // 包括 not in

    ValkyrieTokenTypes.AS to 6,  // 类型转换

    ValkyrieTokenTypes.PIPE to 7, // 按位或
//    ValkyrieTokenTypes.CARET to 8, // 按位异或
    ValkyrieTokenTypes.AMPERSAND to 9, // 按位与

    ValkyrieTokenTypes.PLUS to 11,
    ValkyrieTokenTypes.MINUS to 11,

    ValkyrieTokenTypes.STAR to 12,
    ValkyrieTokenTypes.SLASH to 12,
    ValkyrieTokenTypes.PERCENT to 12,

    ValkyrieTokenTypes.POWER to 13, // 幂运算，通常是右结合
)

// 后缀和访问类运算符具有最高的优先级
val termPostfixPrecedences = mapOf(
    ValkyrieTokenTypes.WOW to 14,             // not null 断言: expr!
    ValkyrieTokenTypes.WHAT to 14,            // 可空链式操作符: expr?
    ValkyrieTokenTypes.PARENTHESIS_L to 15,   // 函数调用: expr(...)
    ValkyrieTokenTypes.BRACKET_L to 15,       // 索引: expr[...]
    ValkyrieTokenTypes.BRACE_L to 15,         // 尾随闭包: expr { ... }
    ValkyrieTokenTypes.DOT to 16,             // 成员访问: expr.member
    ValkyrieTokenTypes.DOUBLE_COLON to 16,    // 泛型调用: expr::<...>
)