package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

fun getTermPrefixPrecedence(tokenType: com.intellij.psi.tree.IElementType?): Int? {
    return when (tokenType) {
        ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.NOT, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.AMPERSAND -> 14
        ValkyrieTokenTypes.DOT_DOT, ValkyrieTokenTypes.DOT_DOT_EQUAL, ValkyrieTokenTypes.DOT_DOT_LESS, ValkyrieTokenTypes.COLON -> 10
        else -> null
    }
}

fun getTermInfixPrecedence(tokenType: com.intellij.psi.tree.IElementType?): Int? {
    return when (tokenType) {
        ValkyrieTokenTypes.ASSIGN -> 1
        ValkyrieTokenTypes.LOGIC_OR -> 1
        ValkyrieTokenTypes.LOGIC_XOR -> 2
        ValkyrieTokenTypes.LOGIC_AND -> 3
        ValkyrieTokenTypes.EQUAL, ValkyrieTokenTypes.NOT_EQUAL, ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.ANGLE_R, ValkyrieTokenTypes.LESS_EQUAL, ValkyrieTokenTypes.GREATER_EQUAL -> 4
        ValkyrieTokenTypes.IS, ValkyrieTokenTypes.IN -> 5
        ValkyrieTokenTypes.AS -> 6
        ValkyrieTokenTypes.PIPE -> 7
        ValkyrieTokenTypes.AMPERSAND -> 9
        ValkyrieTokenTypes.DOT_DOT, ValkyrieTokenTypes.DOT_DOT_EQUAL, ValkyrieTokenTypes.DOT_DOT_LESS, ValkyrieTokenTypes.COLON -> 10
        ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS -> 11
        ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.SLASH, ValkyrieTokenTypes.PERCENT -> 12
        ValkyrieTokenTypes.POWER -> 13
        else -> null
    }
}

fun getTermPostfixPrecedence(tokenType: com.intellij.psi.tree.IElementType?): Int? {
    return when (tokenType) {
        ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WHAT -> 14
        ValkyrieTokenTypes.PARENTHESIS_L, ValkyrieTokenTypes.BRACKET_L, ValkyrieTokenTypes.BRACE_L -> 15
        ValkyrieTokenTypes.DOT, ValkyrieTokenTypes.DOUBLE_COLON, ValkyrieTokenTypes.DOT_CIRCLE -> 16
        else -> null
    }
}

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

fun isSliceOperator(tokenType: com.intellij.psi.tree.IElementType?): Boolean {
    return tokenType == ValkyrieTokenTypes.DOT_DOT ||
        tokenType == ValkyrieTokenTypes.DOT_DOT_EQUAL ||
        tokenType == ValkyrieTokenTypes.DOT_DOT_LESS ||
        tokenType == ValkyrieTokenTypes.COLON
}

fun parseIndexArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.BRACKET_L) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()

    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
        if (!parseTermExpression(valkyrieParser, builder, inline = true)) {
            // 如果解析失败，尝试跳过一个 token 以避免无限循环
            val safe = builder.currentOffset
            if (builder.tokenType != null) builder.advanceLexer()
            if (builder.currentOffset == safe) break
            continue
        }

        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer()
        } else if (builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
            builder.error("Expected ',' or ']'")
            val safe = builder.currentOffset
            if (builder.tokenType != null) builder.advanceLexer()
            if (builder.currentOffset == safe) break
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ']'")
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
fun parseTermExpressionWithPrecedence(valkyrieParser: ValkyrieParser, builder: PsiBuilder, minPrecedence: Int, inline: Boolean): Boolean {
    // CHANGE 1: 'lhs' 现在代表当前左侧表达式的 marker。
    var lhs: PsiBuilder.Marker

    // "NUD" (Null Denotation) 阶段：处理前缀表达式和原子表达式
    val prefixPrecedence = getTermPrefixPrecedence(builder.tokenType)
    if (prefixPrecedence != null) {
        // 处理前缀表达式（如 +a, -a, !a, ..a）
        val currentToken = builder.tokenType
        lhs = builder.mark() // 先创建 marker
        builder.advanceLexer() // 再消费前缀运算符

        // 递归解析右侧表达式
        // 对于切片运算符，右侧是可选的 (例如 x[..10] 或 x[..])
        if (!parseTermExpressionWithPrecedence(valkyrieParser, builder, prefixPrecedence, inline)) {
            // 如果不是切片运算符，则右侧缺失是错误
            if (!isSliceOperator(currentToken)) {
                lhs.error("Expected expression after prefix operator")
                return true
            }
        }
        val nodeType = if (isSliceOperator(currentToken)) ValkyrieElementTypes.SLICE_EXPRESSION else ValkyrieElementTypes.UNARY_EXPRESSION
        lhs.done(nodeType)
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
        // builder.error("Current token: $currentToken, minPrecedence: $minPrecedence")
        if (currentToken == null) break
        if (currentToken == ValkyrieTokenTypes.IS && builder.lookAhead(1) == ValkyrieTokenTypes.NOT) {
            val isNotPrecedence = getTermInfixPrecedence(ValkyrieTokenTypes.IS)!!
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
            val notInPrecedence = getTermInfixPrecedence(ValkyrieTokenTypes.IN)!!
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

        val postfixPrecedence = if (inline && currentToken == ValkyrieTokenTypes.BRACE_L) {
            null
        } else {
            getTermPostfixPrecedence(currentToken)
        }
        val infixPrecedence = getTermInfixPrecedence(currentToken)
        // 处理后缀表达式
        if (postfixPrecedence != null && postfixPrecedence >= minPrecedence) {
            // 创建新 marker 包裹旧的 lhs
            lhs = lhs.precede()
            when (currentToken) {
                ValkyrieTokenTypes.PARENTHESIS_L -> {
                    parseFunctionArgumentList(valkyrieParser, builder)
                    // f() { }
                    if (builder.tokenType == ValkyrieTokenTypes.BRACE_L && !inline) {
                        lhs.done(ValkyrieElementTypes.CALL_EXPRESSION) // 完成 f() 部分
                        lhs = lhs.precede() // 为 f() {} 创建新 marker
                        valkyrieParser.parseFnBody(builder)
                        lhs.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    }
                    // f()
                    else {
                        lhs.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    }
                }
                // data[0, 1]
                ValkyrieTokenTypes.BRACKET_L -> {
                    parseIndexArgumentList(valkyrieParser, builder)
                    lhs.done(ValkyrieElementTypes.INDEX_EXPRESSION)
                }
                // data.f
                ValkyrieTokenTypes.DOT, ValkyrieTokenTypes.DOT_CIRCLE -> {
                    builder.advanceLexer() // consume '.' or '⸬'
                    parseIdentifier(builder)
                    lhs.done(ValkyrieElementTypes.EXPRESSION)
                }
                // 切片运算符作为后缀 (例如 x[0..])
                ValkyrieTokenTypes.DOT_DOT, ValkyrieTokenTypes.DOT_DOT_EQUAL, ValkyrieTokenTypes.DOT_DOT_LESS, ValkyrieTokenTypes.COLON -> {
                    builder.advanceLexer()
                    lhs.done(ValkyrieElementTypes.SLICE_EXPRESSION)
                }
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
                if (!isSliceOperator(currentToken)) {
                    lhs.error("Expected an expression after binary operator")
                } else {
                    lhs.done(ValkyrieElementTypes.SLICE_EXPRESSION)
                }
            } else {
                val nodeType = if (isSliceOperator(currentToken)) ValkyrieElementTypes.SLICE_EXPRESSION else ValkyrieElementTypes.BINARY_EXPRESSION
                lhs.done(nodeType)
            }
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
    return when {
        parser.parseExpressionExtension(builder) -> return true
        builder.tokenType == ValkyrieTokenTypes.INTEGER ||
            builder.tokenType == ValkyrieTokenTypes.DECIMAL ||
            builder.tokenType == ValkyrieTokenTypes.BOOLEAN -> {
            builder.advanceLexer()
            true
        }

        isIdentifier(builder) -> {
            // parseNamePath 内部会创建自己的 marker，这与我们的新设计冲突。
            // 为简单起见，这里假设它只解析一个标识符路径。
            // 在实际项目中，需要确保 parseNamePath 也遵循一致的 marker 管理策略。
            // 比如，让它返回是否成功，由上层包裹 marker。
            parser.parseNamePath(builder, false) // 假设 parseNamePath 返回 Boolean
            true
        }

        // 字符串字面量
        builder.tokenType == ValkyrieTokenTypes.STRING_L || 
            builder.tokenType == ValkyrieTokenTypes.STRING_START ||
            builder.tokenType == ValkyrieTokenTypes.MACRO_STRING -> {
            parser.parseString(builder)
            true
        }

        // 括号表达式
        builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_L -> {
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
        builder.tokenType == ValkyrieTokenTypes.BRACKET_L -> {
            parser.parseArrayExpression(builder)
            true
        }

        // 对象表达式 (如果不是内联模式)
        builder.tokenType == ValkyrieTokenTypes.BRACE_L -> {
            if (!inline) {
                parser.parseObjectExpression(builder)
                true
            } else {
                false
            }
        }
        // 特殊值
        builder.tokenType == ValkyrieTokenTypes.NIL || builder.tokenType == ValkyrieTokenTypes.NULL -> {
            builder.advanceLexer()
            true
        }

        // 条件控制流
        parseIfStatement(parser, builder) -> return true
        parseMatchStatement(parser, builder) -> return true
        // 循环控制流
        parseLoopStatement(parser, builder) -> return true
        parseEachStatement(parser, builder) -> return true
        parseWhileStatement(parser, builder) -> return true
        parseUntilStatement(parser, builder) -> return true
        // 异常控制流
        parseTryStatement(parser, builder) -> return true
        parseCatchStatement(parser, builder) -> return true
        else -> return false
    }
}
