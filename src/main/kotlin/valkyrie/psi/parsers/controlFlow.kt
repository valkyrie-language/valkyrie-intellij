package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

fun parseControlFlow(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false);
    when (builder.tokenType) {
        ValkyrieTokenTypes.CONTINUE -> {
            builder.advanceLexer()
            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.CONTINUE_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.FALLTHROUGH -> {
            builder.advanceLexer()

            // 检查是否是 fallthrough! 语法
            if (builder.tokenType == ValkyrieTokenTypes.WOW) {
                builder.advanceLexer() // consume '!'
            }

            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.FALLTHROUGH_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.BREAK -> {
            builder.advanceLexer()
            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.BREAK_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.RAISE -> {
            builder.advanceLexer()
            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.RAISE_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.YIELD -> {
            builder.advanceLexer()

            // 检查 yield return 语法
            if (builder.tokenType == ValkyrieTokenTypes.RETURN) {
                builder.advanceLexer() // consume 'return'

                // 检查 yield return from 语法
                if (builder.tokenType == ValkyrieTokenTypes.SYMBOL_XID && builder.tokenText == "from") {
                    builder.advanceLexer() // consume 'from'
                    parseLabelMark(builder) // optional label
                    parseTermExpression(parser, builder, false) // generator expression
                } else {
                    // yield return [label] [value]
                    parseLabelMark(builder) // optional label
                    parseTermExpression(parser, builder, false) // optional value
                }
            }
            // 检查 yield from 语法
            else if (builder.tokenType == ValkyrieTokenTypes.SYMBOL_XID && builder.tokenText == "from") {
                builder.advanceLexer() // consume 'from'
                parseLabelMark(builder) // optional label
                parseTermExpression(parser, builder, false) // generator expression
            }
            // 普通 yield [label] [value]
            else {
                parseLabelMark(builder) // optional label
                parseTermExpression(parser, builder, false) // optional value
            }

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.YIELD_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.RETURN -> {
            builder.advanceLexer()
            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.RETURN_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.RESUME -> {
            builder.advanceLexer()
            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional

            // 处理可选的分号
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.RESUME_STATEMENT)
            return true
        }
        // 不是控制流语句，返回false
        else -> {

            return false
        }
    }
}

fun parseLoopStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.LOOP) {
        builder.advanceLexer() // consume 'loop'

        // 检查是否是 for 语法糖 (loop pattern in expression)
        if (isIdentifier(builder) && builder.lookAhead(1) == ValkyrieTokenTypes.IN) {
            // 这是 for 语法糖，解析为 FOR_STATEMENT

            // 解析模式 (必须)
            if (!parsePattern(parser, builder, true)) {
                marker.error("Expected pattern after 'for'")
                return true
            }

            // 解析 'in' 关键字 (必须)
            if (builder.tokenType != ValkyrieTokenTypes.IN) {
                marker.error("Expected 'in' after pattern in for statement")
                return true
            }
            builder.advanceLexer() // consume 'in'

            // 解析表达式 (必须) - 使用inline=false允许尾随闭包
            if (!parseTermExpression(parser, builder, false)) {
                marker.error("Expected expression after 'in'")
                return true
            }

            // 解析可选的标签
            parseLabelMark(builder)

            // 解析循环体 (必须) - 循环体不可以为空
            if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
                marker.error("Expected '{' after loop keyword")
                return true
            }

            if (!parser.parseFnBody(builder)) {
                marker.error("Expected function body after '{'")
                return true
            }

            // 解析可选的 else 子句
            parser.parseElseStatement(builder)

            marker.done(ValkyrieElementTypes.EACH_STATEMENT)
            return true
        } else {
            // 这是普通的 loop 语句

            // 解析可选的标签
            parseLabelMark(builder)

            // 解析循环体 (必须) - 循环体不可以为空
            if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
                marker.error("Expected '{' after loop keyword")
                return true
            }

            if (!parser.parseFnBody(builder)) {
                marker.error("Expected function body after '{'")
                return true
            }

            // 解析可选的 else 子句
            parser.parseElseStatement(builder)

            marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
            return true
        }
    } else {
        marker.rollbackTo()
        return false
    }
}

fun parseWhileStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.WHILE) {
        builder.advanceLexer() // consume 'while'
    } else {
        marker.rollbackTo()
        return false
    }

    // 解析条件表达式 (必须)
    if (!parseTermExpression(parser, builder, inline = false)) {
        marker.error("Expected condition after 'while'")
        return false
    }

    // 可选 label
    parseLabelMark(builder)

    // 解析循环体 - 必须是块语句
    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after while condition")
        return false
    }

    // 可选 else 语句
    parser.parseElseStatement(builder)

    marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
    return true
}

fun parseUntilStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.UNTIL) {
        builder.advanceLexer() // consume 'until'
    } else {
        marker.rollbackTo()
        return false
    }

    // 解析条件表达式 (必须)
    if (!parseTermExpression(parser, builder, inline = false)) {
        marker.error("Expected condition after 'until'")
        return false
    }

    // 可选 label
    parseLabelMark(builder)

    // 解析循环体 - 必须是块语句
    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after until condition")
        return false
    }

    // 可选 else 语句
    parser.parseElseStatement(builder)

    marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
    return true
}
