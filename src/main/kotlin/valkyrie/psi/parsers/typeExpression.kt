package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes

// 解析泛型参数列表, 例如 `<T, U>`
fun parseGenericParameterList(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
        builder.advanceLexer()
    }
    // 处理 <T, U,> 形式
    if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
        builder.advanceLexer() // 吃掉 '<'
        if (parseGenericParameterItem(valkyrieParser, builder)) {
            while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R) {
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // 吃掉 ','
                } else if (parseGenericParameterItem(valkyrieParser, builder)) {
                    // 成功解析了一个参数项
                } else {
                    marker.error("需要一个泛型参数名")
                    return false
                }
            }
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // 处理末尾的可选逗号
            }
        }
        if (builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
            builder.advanceLexer() // 吃掉 '>'
        } else {
            marker.error("需要 '>' 来闭合泛型参数列表")
            return false
        }
    }
    // 处理 ⟨T, U, ⟩ 形式
    else if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L) {
        builder.advanceLexer() // 吃掉 '⟨'
        if (parseGenericParameterItem(valkyrieParser, builder)) {
            while (builder.tokenType != ValkyrieTokenTypes.GENERIC_R) {
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // 吃掉 ','
                } else if (parseGenericParameterItem(valkyrieParser, builder)) {
                    continue
                } else {
                    marker.error("需要一个泛型参数名")
                    return false
                }
            }
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            }
        }
        if (builder.tokenType == ValkyrieTokenTypes.GENERIC_R) {
            builder.advanceLexer() // 吃掉 '⟩'
        } else {
            marker.error("需要 '⟩' 来闭合泛型参数列表")
            return false
        }
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

// 解析泛型参数的应用列表, 例如 `::<String, i32>`
// term level (值层面) 支持两种泛型语法 ⟨T⟩ 和 ::<T>
// type level (类型层面) 额外支持一种 <T>
fun parseGenericArgumentList(valkyrieParser: ValkyrieParser, builder: PsiBuilder, typeLevel: Boolean): Boolean {
    val marker = builder.mark()
    var unicodeMode = false
    // ⟨T⟩
    if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L) {
        builder.advanceLexer()
        unicodeMode = true
    }
    // A<T>
    else if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
        if (!typeLevel) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer()
        unicodeMode = false
    }
    // A::<T>
    else if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
        // ::< >
        if (builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L) {
            builder.advanceLexer()
            builder.advanceLexer()
            unicodeMode = false
        } else {
            marker.rollbackTo()
            return false
        }
    } else {
        marker.rollbackTo()
        return false
    }

    // 解析参数项 (argument (, argument)*)?
    if (parseGenericArgumentItem(valkyrieParser, builder)) {
        while (builder.tokenType != ValkyrieTokenTypes.ANGLE_R && builder.tokenType != ValkyrieTokenTypes.GENERIC_R) {
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // 吃掉 ','
                // 允许末尾逗号
                if (builder.tokenType == ValkyrieTokenTypes.ANGLE_R || builder.tokenType == ValkyrieTokenTypes.GENERIC_R) {
                    break
                }
            } else {
                marker.error("在泛型参数间需要一个逗号")
                break // 出错时跳出循环
            }
            if (!parseGenericArgumentItem(valkyrieParser, builder)) {
                marker.error("需要一个泛型参数项")
                break
            }
        }
    }

    // 吃掉闭合括号
    if (unicodeMode && builder.tokenType == ValkyrieTokenTypes.GENERIC_R) {
        builder.advanceLexer()
    } else if (!unicodeMode && builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
        builder.advanceLexer()
    } else {
        marker.error("需要 '>' 或 '⟩' 来闭合泛型参数列表")
        // 即使出错, 也完成节点以利于错误恢复
    }
    marker.done(ValkyrieElementTypes.GENERIC_ARGUMENT_LIST)
    return true
}

// 解析单个泛型参数的应用项, 它本身就是一个类型表达式
fun parseGenericArgumentItem(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    // Parse type expression as generic argument
    if (parseTypeExpression(valkyrieParser, builder, true)) {
        marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
        return true
    } else {
        marker.drop()
        return false
    }
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
    } else if (parsePrimaryType(valkyrieParser, builder)) {
        // 解析基础类型, 通常是一个标识符
        lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
    } else {
        // 如果连基础类型都无法解析, 说明这不是一个有效的类型表达式的开头
        lhs_marker.drop()
        return false
    }

    // 循环处理中缀和后缀运算符
    while (true) {
        val current_token = builder.tokenType
        val postfix_precedence = typePostfixPrecedences[current_token]
        val infix_precedence = typeInfixPrecedences[current_token]

        if (postfix_precedence != null && postfix_precedence >= minPrecedence) {
            // 处理后缀表达式, 例如 `T?` 或 `A<T>`
            lhs_marker = lhs_marker.precede()
            when (current_token) {
                ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.DOUBLE_COLON -> {
                    // 对于泛型参数列表, 调用专门的解析函数
                    if (!parseGenericArgumentList(valkyrieParser, builder, true)) {
                        lhs_marker.drop() // 如果泛型列表解析失败, 回滚标记
                        return true // 但左侧仍是有效表达式, 故返回 true
                    }
                }

                else -> builder.advanceLexer() // 普通后缀运算符, 直接吃掉
            }
            lhs_marker.done(ValkyrieElementTypes.TYPE_EXPRESSION)
            // 继续循环, 因为一个后缀表达式后可能还有其他运算符, 如 `A<T>?`
            continue
        }

        if (infix_precedence != null && infix_precedence >= minPrecedence) {
            // 处理中缀表达式, 例如 `T | U`
            lhs_marker = lhs_marker.precede()
            builder.advanceLexer() // 吃掉运算符

            // 根据运算符的结合性调整下一次递归的最小优先级
            val next_min_precedence = when (current_token) {
                ValkyrieTokenTypes.ARROW -> infix_precedence // 右结合
                else -> infix_precedence + 1 // 左结合
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

// 解析基础类型，目前仅支持标识符
fun parsePrimaryType(valkyrieParser: ValkyrieParser, builder: PsiBuilder): Boolean {
    return valkyrieParser.parseIdentifier(builder)
}

// 定义前缀运算符的优先级
private val typePrefixPrecedences = mapOf(
    ValkyrieTokenTypes.PLUS to 5, // +T
    ValkyrieTokenTypes.MINUS to 5, // -T
)

// 定义中缀运算符的优先级
private val typeInfixPrecedences = mapOf(
    ValkyrieTokenTypes.PIPE to 1, // T | U
    ValkyrieTokenTypes.AMPERSAND to 2, // T & U
    ValkyrieTokenTypes.PLUS to 3, // T + U
    ValkyrieTokenTypes.MINUS to 3, // T - U
    ValkyrieTokenTypes.ARROW to 4, // T -> U (右结合)
)

// 定义后缀运算符的优先级
private val typePostfixPrecedences = mapOf(
    ValkyrieTokenTypes.WOW to 6,  // T!
    ValkyrieTokenTypes.WHAT to 6, // T?
    ValkyrieTokenTypes.ANGLE_L to 7, // 泛型应用 A<T>
    ValkyrieTokenTypes.DOUBLE_COLON to 7, // 泛型应用 A::<T>
)