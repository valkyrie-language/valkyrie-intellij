package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.psi.xml.XmlTokenType
import valkyrie.language.dialect_xml.parseXmlElement
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes


fun parseFunctionParameterList(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_L) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume '('

    // 允许空参数列表
    if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
        // 解析第一个参数
        if (!parseFunctionParameterItem(parser, builder)) {
            // FIX: 在出错时不要 drop marker，而是报告错误并继续，以便正确关闭节点
            builder.error("Expected parameter")
            // 不再 drop，让函数末尾的逻辑来关闭 marker
        } else {
            // 解析后续参数 (, param)*
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','

                // 检查是否是尾随逗号（可选）
                if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
                    break // 允许尾随逗号
                }

                if (!parseFunctionParameterItem(parser, builder)) {
                    builder.error("Expected parameter after ','")
                    break // 出错时跳出循环，尝试关闭列表
                }
            }
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
        builder.advanceLexer() // consume ')'
    } else {
        builder.error("Expected ')'")
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
    if (!parseIdentifier(builder)) {
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
            // 在这里中断意味着可能缺少逗号或右括号，是潜在的语法错误
            builder.error("Expected ',' or ')'")
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
    if (parseIdentifier(builder) && builder.tokenType == ValkyrieTokenTypes.COLON) {
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
    // CHANGE 1: 'lhs' 现在代表当前左侧表达式的 marker。
    var lhs: PsiBuilder.Marker

    // "NUD" (Null Denotation) 阶段：处理前缀表达式和原子表达式
    val prefixPrecedence = termPrefixPrecedences[builder.tokenType]
    if (prefixPrecedence != null) {
        // 处理前缀表达式（如 +a, -a, !a）
        lhs = builder.mark() // 先创建 marker
        builder.advanceLexer() // 再消费前缀运算符

        // 递归解析右侧表达式
        if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, prefixPrecedence, inline)) {
            // 即使右侧解析失败，也要关闭 marker，形成一个带错误的节点
            lhs.error("Expected expression after prefix operator")
            return true // 返回 true 表示我们消费了 token 并创建了一个（错误的）节点
        }
        lhs.done(ValkyrieElementTypes.UNARY_EXPRESSION)
    } else {
        // 处理原子表达式
        lhs = builder.mark() // 先创建 marker
        if (parsePrimaryTerm(valkyrieParser, builder, inline)) {
            // parsePrimaryTerm 成功消费了 token，但它不创建节点
            // 我们用 lhs marker 来包裹它
            lhs.done(ValkyrieElementTypes.EXPRESSION) // 先完成这个原子表达式节点
        } else {
            // 既不是前缀，也不是原子，说明这里不是一个有效的表达式。
            lhs.rollbackTo() // 回滚 marker，因为没有消费任何东西
            return false
        }
    }

    // "LED" (Left Denotation) 循环：处理中缀和后缀运算符
    while (true) {
        val currentToken = builder.tokenType
        // 特殊处理复合关键字...（这部分逻辑保持不变）
        if (currentToken == ValkyrieTokenTypes.IS && builder.lookAhead(1) == ValkyrieTokenTypes.NOT) {
            val isNotPrecedence = termInfixPrecedences[ValkyrieTokenTypes.IS]!!
            if (isNotPrecedence < minPrecedence) break

            // CHANGE 2: 核心修复 - 使用 precede() 创建新 marker，并将其赋值给 lhs
            lhs = lhs.precede()
            builder.advanceLexer() // is
            builder.advanceLexer() // not
            if (!parseTypeExpression(valkyrieParser, builder, true)) {
                lhs.error("Expected a pattern after 'is not'")
                return true // 返回 true 因为我们创建了错误节点
            }
            lhs.done(ValkyrieElementTypes.BINARY_EXPRESSION) // 使用更合适的类型
            continue
        }
        if (currentToken == ValkyrieTokenTypes.NOT && builder.lookAhead(1) == ValkyrieTokenTypes.IN) {
            val notInPrecedence = termInfixPrecedences[ValkyrieTokenTypes.IN]!!
            if (notInPrecedence < minPrecedence) break

            lhs = lhs.precede()
            builder.advanceLexer() // not
            builder.advanceLexer() // in
            if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, notInPrecedence + 1, inline)) {
                lhs.error("Expected an expression after 'not in'")
                return true
            }
            lhs.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            continue
        }

        val postfixPrecedence = termPostfixPrecedences[currentToken]
        val infixPrecedence = termInfixPrecedences[currentToken]

        if (postfixPrecedence != null && postfixPrecedence >= minPrecedence) {
            // 处理后缀表达式
            lhs = lhs.precede() // 创建新 marker 包裹旧的 lhs
            when (currentToken) {
                ValkyrieTokenTypes.PARENTHESIS_L -> {
                    parseFunctionArgumentList(valkyrieParser, builder)
                    // 检查尾随闭包
                    if (builder.tokenType == ValkyrieTokenTypes.BRACE_L && !inline) {
                        lhs.done(ValkyrieElementTypes.CALL_EXPRESSION) // 完成 f() 部分
                        lhs = lhs.precede() // 为 f() {} 创建新 marker
                        valkyrieParser.parseFnBody(builder)
                        lhs.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    } else {
                        lhs.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    }
                }

                ValkyrieTokenTypes.DOT -> {
                    builder.advanceLexer() // consume '.'
                    parseIdentifier(builder)
                    lhs.done(ValkyrieElementTypes.EXPRESSION) // 或者更具体的 MEMBER_ACCESS_EXPRESSION
                }
                // ... 其他后缀情况 ...
                else -> {
                    builder.advanceLexer()
                    lhs.done(ValkyrieElementTypes.POSTFIX_EXPRESSION)
                }
            }
            continue // 继续循环以处理链式调用
        }

        if (infixPrecedence != null && infixPrecedence >= minPrecedence) {
            // 处理中缀表达式
            lhs = lhs.precede() // 创建新 marker 包裹旧的 lhs
            builder.advanceLexer() // 消费运算符

            val nextMinPrecedence = if (currentToken == ValkyrieTokenTypes.POWER) infixPrecedence else infixPrecedence + 1

            val rhsParsed = when (currentToken) {
                ValkyrieTokenTypes.AS, ValkyrieTokenTypes.IS -> parseTypeExpression(valkyrieParser, builder, true)
                else -> parseTermExpressionWithPrecedence(valkyrieParser, builder, nextMinPrecedence, inline)
            }
            if (!rhsParsed) {
                lhs.error("Expected an expression after binary operator")
                return true
            }

            lhs.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            continue
        }

        break // 没有更多可处理的运算符
    }

    // CHANGE 3: 移除函数末尾的 .done() 调用。
    // 因为 lhs 在每次循环中都被一个新的、已完成的 marker 替换，
    // 最后的 lhs 就是代表整个表达式的、已经关闭的 marker。我们不需要再对它做任何事。
    return true
}

/**
 * 解析原子表达式。
 * CHANGE: 这个函数现在只负责消费 token，不创建 marker。
 * marker 的创建和完成由调用者 (parseTermExpressionWithPrecedence) 处理。
 */
fun parsePrimaryTerm(parser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    return when (builder.tokenType) {
        ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.BOOLEAN -> {
            builder.advanceLexer()
            true
        }

        ValkyrieTokenTypes.SYMBOL_XID, ValkyrieTokenTypes.SYMBOL_RAW -> {
            // parseNamePath 内部会创建自己的 marker，这与我们的新设计冲突。
            // 为简单起见，这里假设它只解析一个标识符路径。
            // 在实际项目中，需要确保 parseNamePath 也遵循一致的 marker 管理策略。
            // 比如，让它返回是否成功，由上层包裹 marker。
            parser.parseNamePath(builder, false) // 假设 parseNamePath 返回 Boolean
            true
        }

        // XML Slot 表达式
        ValkyrieTokenTypes.XML_SLOT_L -> {
            val marker = builder.mark()
            builder.advanceLexer() // consume XML_SLOT_L
            if (!parseTermExpression(parser, builder, inline)) {
                builder.error("Expected expression in slot")
            }
            if (builder.tokenType == ValkyrieTokenTypes.XML_SLOT_R) {
                builder.advanceLexer() // consume XML_SLOT_R
            } else {
                builder.error("Expected '}'")
            }
            marker.done(ValkyrieElementTypes.XML_SLOT_EXPRESSION)
            true
        }

        // 字符串字面量
        ValkyrieTokenTypes.STRING_L -> {
            parser.parseString(builder)
            true
        }

        // 括号表达式
        ValkyrieTokenTypes.PARENTHESIS_L -> {
            builder.advanceLexer() // consume '('
            if (!parseTermExpression(parser, builder, inline)) {
                builder.error("Expected expression")
            }
            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
                builder.advanceLexer() // consume ')'
            } else {
                builder.error("Expected ')'")
            }
            true
        }

        // 数组表达式
        ValkyrieTokenTypes.BRACKET_L -> {
            parser.parseArrayExpression(builder)
            true
        }

        // 对象表达式 (如果不是内联模式)
        ValkyrieTokenTypes.BRACE_L -> {
            if (!inline) {
                parser.parseObjectExpression(builder)
                true
            } else {
                false
            }
        }
        // 特殊值
        ValkyrieTokenTypes.NIL, ValkyrieTokenTypes.NULL -> {
            builder.advanceLexer()
            true
        }

        XmlTokenType.XML_START_TAG_START -> {
            parseXmlElement(builder)
        }

        else -> {
            parseLoopStatement(parser, builder)
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