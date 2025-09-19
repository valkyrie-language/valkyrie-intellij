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
        builder.advanceLexer()
        if (isIdentifier(builder)) {
            if (!parsePattern(parser, builder, true)) {
                marker.error("Expected pattern after 'for'")
                return true
            }

            if (builder.tokenType != ValkyrieTokenTypes.IN) {
                marker.error("Expected 'in' after pattern in for statement")
                return true
            }
            builder.advanceLexer()
            if (!parseTermExpression(parser, builder, inline = true)) {
                marker.error("Expected expression after 'in'")
                return true
            }

            parseLabelMark(builder)

            if (!parser.parseFnBody(builder)) {
                marker.error("Expected function body after '{'")
                return true
            }

            // 解析可选的 else 子句
            parser.parseElseStatement(builder)

            marker.done(ValkyrieElementTypes.EACH_STATEMENT)
            return true
        } else {
            parseLabelMark(builder)

            if (!parser.parseFnBody(builder)) {
                marker.error("Expected function body after '{'")
                return true
            }

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
        builder.advanceLexer()
    } else {
        marker.rollbackTo()
        return false
    }

    if (!parseTermExpression(parser, builder, inline = true)) {
        marker.error("Expected condition after 'while'")
        return false
    }

    parseLabelMark(builder)

    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after while condition")
        return false
    }

    parser.parseElseStatement(builder)

    marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
    return true
}

fun parseUntilStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.UNTIL) {
        builder.advanceLexer()
    } else {
        marker.rollbackTo()
        return false
    }
    if (!parseTermExpression(parser, builder, inline = true)) {
        marker.error("Expected condition after 'until'")
        return false
    }
    parseLabelMark(builder)
    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after until condition")
        return false
    }

    parser.parseElseStatement(builder)

    marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
    return true
}
