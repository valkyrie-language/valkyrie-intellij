package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes

// 解析泛型参数列表, 例如 `fn foo<T, U>()` 中的 `<T, U>`
fun parseGenericParameterList(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    var unicodeMode = false
    val marker = builder.mark()

    // 确定并消费起始符号
    when (builder.tokenType) {
        // <T, U,>
        ValkyrieTokenTypes.ANGLE_L -> {
            builder.advanceLexer()
        }
        // ::<T, U,>
        ValkyrieTokenTypes.DOUBLE_COLON if builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L -> {
            builder.advanceLexer()
            builder.advanceLexer()
        }
        // ⟨T, U, ⟩
        ValkyrieTokenTypes.GENERIC_L -> {
            unicodeMode = true
            builder.advanceLexer()
        }
        // 非泛型定义
        else -> {
            marker.drop()
            return false
        }
    }

    // 健壮的列表解析逻辑
    val closingBracket = if (unicodeMode) ValkyrieTokenTypes.GENERIC_R else ValkyrieTokenTypes.ANGLE_R
    if (builder.tokenType != closingBracket) {
        while (true) {
            if (!parseGenericParameterItem(parser, builder)) {
                // 如果解析失败，可能是列表结束了但有语法错误，先报错然后跳出
                builder.error("需要一个泛型参数名")
                break
            }
            // 解析完一个 item 后，如果下一个是 '>', 则列表结束
            if (builder.tokenType == closingBracket) {
                break
            }
            // 如果下一个是 ',', 则消费掉它，准备解析下一个 item
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
                // 支持可选的末尾逗号
                if (builder.tokenType == closingBracket) {
                    break
                }
            } else {
                // 既不是 '>' 也不是 ',', 说明缺少逗号
                builder.error("在泛型参数之间需要一个逗号")
                break
            }
        }
    }

    // 消费闭合符号
    if (builder.tokenType == closingBracket) {
        builder.advanceLexer()
    } else {
        // 即使之前报过错，这里再报一次闭合错误有助于恢复
        builder.error("需要 '${if (unicodeMode) "⟩" else ">"}' 来闭合泛型参数列表")
    }

    marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
    return true
}

// 解析单个泛型参数, 例如 `T: Clone`
fun parseGenericParameterItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    // 解析注解和修饰符
    valkyrieParser.parseAnnotations(builder, withModifiers = true)
    // 解析标识符
    if (!valkyrieParser.parseIdentifier(builder)) {
        marker.error("Expected type parameter name")
        return false
    }
    // 解析可选的类型约束
    valkyrieParser.parseTypeHint(builder)
    // 解析可选的默认类型
    valkyrieParser.parseDefaultType(builder)

    marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
    return true
}

// 解析泛型参数的应用列表, 例如 `Vec<String, i32>`
fun parseGenericArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder, typeLevel: Boolean): Boolean {
    val marker = builder.mark()
    var unicodeMode = false

    // 确定并消费起始符号
    when {
        // <T as Iterator>::Item
        builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON && isIdentifier(builder.lookAhead(1)) -> {
            builder.advanceLexer()
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
            return true
        }
        // <T as Iterator>::<T
        builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON && builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L -> {
            builder.advanceLexer()
            builder.advanceLexer()
        }
        // <T as Iterator><T
        typeLevel && builder.tokenType == ValkyrieTokenTypes.ANGLE_L -> {
            builder.advanceLexer()
        }
        // <T as Iterator>⟨T
        builder.tokenType == ValkyrieTokenTypes.GENERIC_L -> {
            builder.advanceLexer()
            unicodeMode = true
        }

        else -> {
            marker.rollbackTo()
            return false
        }
    }

    // 健壮的列表解析逻辑
    val closingBracket = if (unicodeMode) ValkyrieTokenTypes.GENERIC_R else ValkyrieTokenTypes.ANGLE_R
    if (builder.tokenType != closingBracket) {
        while (true) {
            if (!parseGenericArgumentItem(valkyrieParser, builder)) {
                // 如果一个参数都解析不了，可能是空列表但有其他符号，报错并退出
                builder.error("需要一个泛型参数项")
                break
            }
            // 解析完一个 item 后，如果下一个是 '>', 则列表结束
            if (builder.tokenType == closingBracket) {
                break
            }
            // 如果下一个是 ',', 则消费掉它，准备解析下一个 item
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
                // 支持可选的末尾逗号
                if (builder.tokenType == closingBracket) {
                    break
                }
            }
            // 既不是 '>' 也不是 ',', 说明缺少逗号
            else {
                builder.error("在泛型参数之间需要一个逗号")
                break
            }
        }
    }

    // 消费闭合符号
    if (builder.tokenType == closingBracket) {
        builder.advanceLexer()
    } else {
        builder.error("需要 '${if (unicodeMode) "⟩" else ">"}' 来闭合泛型参数列表")
    }

    // 此时 marker 肯定没有被完成过，可以安全调用 done
    marker.done(ValkyrieElementTypes.GENERIC_ARGUMENT_LIST)
    return true
}

// 解析单个泛型参数的应用项, 它本身就是一个类型表达式
fun parseGenericArgumentItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    return parseTypeExpression(valkyrieParser, builder, true)
}

// 解析类型表达式的入口
fun parseTypeExpression(valkyrieParser: ValkyrieParser, builder: PsiBuilder, inline: Boolean): Boolean {
    return parseTypeExpressionWithPrecedence(valkyrieParser, builder, 0, inline)
}

// Pratt 解析器的核心, 带优先级的递归下降解析
fun parseTypeExpressionWithPrecedence(valkyrieParser: ValkyrieParser, builder: PsiBuilder, minPrecedence: Int, inline: Boolean): Boolean {
    var lhs_marker = builder.mark()
    // 首先, 我们需要处理前缀运算符或一个基础类型
    val token = builder.tokenType
    val prefix_precedence = typePrefixPrecedences[token]
    if (prefix_precedence != null && prefix_precedence >= minPrecedence) {
        // 解析前缀表达式, 例如 `+Trait`
        builder.advanceLexer()
        if (!parseTypeExpressionWithPrecedence(valkyrieParser, builder, prefix_precedence, inline)) {
            builder.error("在前缀运算符后需要一个类型表达式")
        }
        lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
    }
    // 解析基础类型
    else if (parsePrimaryType(valkyrieParser, builder)) {
        lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
    }
    // 如果连基础类型都无法解析, 说明这不是一个有效的类型表达式的开头
    else {
        lhs_marker.drop()
        return false
    }

    // 循环处理中缀和后缀运算符
    while (true) {
        val current_token = builder.tokenType

        // 对 `::` 进行特殊处理
        if (current_token == ValkyrieTokenTypes.DOUBLE_COLON) {
            val pathPrecedence = 25 // 路径操作符具有最高优先级
            if (pathPrecedence < minPrecedence) break

            val nextToken = builder.lookAhead(1)
            // 情况 1: `A::B` (路径分隔符)
            if (isIdentifier(nextToken)) {
                lhs_marker = lhs_marker.precede()
                builder.advanceLexer() // 消费 '::'
                if (!valkyrieParser.parseIdentifier(builder)) {
                    // 理论上 isIdentifier 检查后不会失败, 但为了健壮性
                    builder.error("在 '::' 后需要一个标识符")
                }
                lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
                // 继续循环以处理 A::B::C
                continue
            }
            // 情况 2: `A::<B>` (Turbofish)
            else if (nextToken == ValkyrieTokenTypes.ANGLE_L || nextToken == ValkyrieTokenTypes.GENERIC_L) {
                lhs_marker = lhs_marker.precede()
                // parseGenericArgumentList 会负责消费 '::' 和 '<...>'
                if (!parseGenericArgumentList(valkyrieParser, builder, true)) {
                    // 如果失败, 撤销标记并退出
                    lhs_marker.drop()
                    break
                }
                lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
                // 继续循环以处理 A::<B>::C
                continue
            }
            // 如果 `::` 后面跟了其他东西, 则它不是一个合法的路径操作, 退出循环
            else {
                break
            }
        }

        val postfix_precedence = typePostfixPrecedences[current_token]
        val infix_precedence = typeInfixPrecedences[current_token]

        if (postfix_precedence != null && postfix_precedence >= minPrecedence) {
            // 处理后缀表达式, 例如 `T?` 或 `A<T>`
            lhs_marker = lhs_marker.precede()
            when (current_token) {
                // 对于泛型参数列表, 调用专门的解析函数
                ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.GENERIC_L -> {
                    if (!parseGenericArgumentList(valkyrieParser, builder, true)) {
                        lhs_marker.drop()
                        return true
                    }
                }
                // 普通后缀运算符, 因为都是单个的, 直接吃掉
                else -> builder.advanceLexer()
            }
            lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
            // 继续循环, 因为一个后缀表达式后可能还有其他运算符, 如 `A<T>?`
            continue
        }

        if (infix_precedence != null && infix_precedence >= minPrecedence) {
            // 处理中缀表达式, 例如 `T | U`
            lhs_marker = lhs_marker.precede()
            // 吃掉运算符
            builder.advanceLexer()
            // 根据运算符的结合性调整下一次递归的最小优先级
            val next_min_precedence = when (current_token) {
                // 右结合
                ValkyrieTokenTypes.ARROW -> infix_precedence
                // 左结合
                else -> infix_precedence + 1
            }
            if (!parseTypeExpressionWithPrecedence(valkyrieParser, builder, next_min_precedence, inline)) {
                builder.error("在二元运算符后需要一个类型表达式")
            }
            lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
            // 继续循环, 处理链式操作, 如 `A + B + C`
            continue
        }
        // 没有更多可处理的运算符, 退出循环
        break
    }
    return true
}

// 解析基础类型，是构成类型表达式的基本单元
fun parsePrimaryType(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val typeLevel = true;
    return when (builder.tokenType) {
        // 圆括号包裹的类型: (T) (元组) 或 (T) (分组)
        ValkyrieTokenTypes.PARENTHESIS_L -> parseParenthesisType(parser, builder)
        // 方括号包裹的类型: [T] (向量), [T; N] (数组), 或 [name: T] (具名元组/记录)
        ValkyrieTokenTypes.BRACKET_L -> parseBracketType(parser, builder)
        // <T as U>::Item
        ValkyrieTokenTypes.ANGLE_L if typeLevel -> parseGenericGroup(
            parser,
            builder,
            false
        )
        // <T as U>::Item
        ValkyrieTokenTypes.GENERIC_L, ValkyrieTokenTypes.DOUBLE_COLON -> parseGenericGroup(
            parser,
            builder,
            true
        )

        else -> parser.parseNamePath(builder, false)
    }
}

// <T as U>
private fun parseGenericGroup(parser: ValkyrieParser, builder: PsiBuilder, unicodeMode: Boolean): Boolean {
    when (builder.tokenType) {
        ValkyrieTokenTypes.ANGLE_L -> {}
        ValkyrieTokenTypes.GENERIC_L if unicodeMode -> {}
        else -> return false
    }
    val marker = builder.mark()
    builder.advanceLexer()
    parseTypeExpression(parser, builder, true)
    when (builder.tokenType) {
        ValkyrieTokenTypes.ANGLE_R -> {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
            return true
        }

        ValkyrieTokenTypes.GENERIC_R if unicodeMode -> {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
            return true
        }

        else -> {
            marker.rollbackTo()
            return false
        }
    }
}

// () unit 类型, tuple 的一种
// (T) group 表达式
// (T,) tuple 表达式
// (named: T, U) 具名元组
private fun parseParenthesisType(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    builder.advanceLexer() // 吃掉 '('
    // 空元组 `()`
    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
        builder.advanceLexer()
        marker.done(ValkyrieElementTypes.TUPLE_TYPE)
        return true
    }

    // 解析第一个元素
    val firstItemMarker = builder.mark()
    val isNamed = isIdentifier(builder) && builder.lookAhead(1) == ValkyrieTokenTypes.COLON
    if (isNamed) {
        parser.parseIdentifier(builder)
        // 吃掉 ':'
        builder.advanceLexer()
    }
    if (!parseTypeExpression(parser, builder, true)) {
        builder.error("需要一个类型表达式")
        firstItemMarker.drop()
        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
            builder.advanceLexer()
        }
        marker.done(ValkyrieElementTypes.TUPLE_TYPE)
        return true
    }
    firstItemMarker.done(ValkyrieElementTypes.TUPLE_ITEM)

    // 根据接下来的符号判断是分组还是元组
    // `(T)` 是分组, `(T,)` 和 `(name: T)` 是单元元组
    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R && !isNamed) {
        builder.advanceLexer() // 吃掉 ')'
        marker.done(ValkyrieElementTypes.GROUP_TYPE)
        return true
    }

    // 剩下的情况都是元组
    while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
        builder.advanceLexer()
        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
            break
        }

        val itemMarker = builder.mark()
        if (isIdentifier(builder) && builder.lookAhead(1) == ValkyrieTokenTypes.COLON) {
            parser.parseIdentifier(builder)
            // 吃掉 ':'
            builder.advanceLexer()
        }
        if (!parseTypeExpression(parser, builder, true)) {
            builder.error("元组中需要一个类型表达式")
            itemMarker.drop()
            break
        }
        itemMarker.done(ValkyrieElementTypes.TUPLE_ITEM)
    }

    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
        builder.advanceLexer()
    } else {
        builder.error("需要 ')' 来闭合元组类型")
    }

    marker.done(ValkyrieElementTypes.TUPLE_TYPE)
    return true
}

// []
// [T]
// [T; N] 数组
// [name: T] 具名元组/记录
private fun parseBracketType(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    builder.advanceLexer() // 吃掉 '['

    // 返回空对象
    if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
        builder.advanceLexer()
        marker.done(ValkyrieElementTypes.TABLE_TYPE)
        return true
    }

    // 解析第一个元素，并检查它是否具名
    val firstItemMarker = builder.mark()
    val isNamed = isIdentifier(builder) && builder.lookAhead(1) == ValkyrieTokenTypes.COLON
    if (isNamed) {
        parser.parseIdentifier(builder)
        // 吃掉 ':'
        builder.advanceLexer()
    }
    if (!parseTypeExpression(parser, builder, true)) {
        builder.error("需要一个类型表达式")
        firstItemMarker.drop()
        if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
            builder.advanceLexer()
        }
        marker.done(ValkyrieElementTypes.TABLE_TYPE)
        return true
    }
    firstItemMarker.done(ValkyrieElementTypes.TABLE_ITEM)

    when (builder.tokenType) {
        ValkyrieTokenTypes.BRACKET_R -> {
            builder.advanceLexer()
            if (isNamed) {
                // `[name: T]` 是单元记录类型
                marker.done(ValkyrieElementTypes.TABLE_TYPE)
            } else {
                marker.done(ValkyrieElementTypes.VECTOR_TYPE)
            }
        }
        // 数组类型 `[T; N]`
        ValkyrieTokenTypes.SEMICOLON -> {
            if (isNamed) builder.error("数组类型元素不能具名")
            // 吃掉 ';'
            builder.advanceLexer()
            // 数组长度是一个值表达式
            if (!parseTermExpression(parser, builder, false)) {
                builder.error("需要一个表示数组长度的表达式")
            }
            if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
                builder.advanceLexer()
            } else {
                builder.error("需要 ']' 来闭合数组类型")
            }
            marker.done(ValkyrieElementTypes.ARRAY_TYPE)
        }
        // 记录类型 `[T, U]` 或 `[name: T, age: U]`
        ValkyrieTokenTypes.COMMA -> {
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) break

                val itemMarker = builder.mark()
                if (isIdentifier(builder) && builder.lookAhead(1) == ValkyrieTokenTypes.COLON) {
                    parser.parseIdentifier(builder)
                    builder.advanceLexer()
                }
                if (!parseTypeExpression(parser, builder, true)) {
                    builder.error("记录类型中需要一个类型表达式")
                    itemMarker.drop()
                    break
                }
                itemMarker.done(ValkyrieElementTypes.TABLE_ITEM)
            }
            if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
                builder.advanceLexer()
            } else {
                builder.error("需要 ']' 来闭合记录类型")
            }
            marker.done(ValkyrieElementTypes.TABLE_TYPE)
        }

        else -> {
            // 标记为错误的记录类型
            builder.error("在类型后需要 ']', ';', 或 ','")
            marker.done(ValkyrieElementTypes.TABLE_TYPE)
        }
    }
    return true
}

private val typePrefixPrecedences = mapOf(
    ValkyrieTokenTypes.PLUS to 5,  // +T 协变类型
    ValkyrieTokenTypes.MINUS to 5, // -T 逆变类型
)

private val typeInfixPrecedences = mapOf(
    ValkyrieTokenTypes.PIPE to 1,          // T | U  交类型
    ValkyrieTokenTypes.AMPERSAND to 2,     // T & U
    ValkyrieTokenTypes.AS to 3,            // T as U
    ValkyrieTokenTypes.PLUS to 4,          // T + U
    ValkyrieTokenTypes.MINUS to 4,         // T - U
    ValkyrieTokenTypes.ARROW to 5,         // T -> U
    ValkyrieTokenTypes.DOUBLE_COLON to 25, // <T as Iterator>::Item
)

private val typePostfixPrecedences = mapOf(
    ValkyrieTokenTypes.WOW to 6,  // T!
    ValkyrieTokenTypes.WHAT to 6, // T?
    ValkyrieTokenTypes.ANGLE_L to 7, // 泛型应用 A<T>
    ValkyrieTokenTypes.GENERIC_L to 7,  // 泛型应用 A⟨T⟩
)