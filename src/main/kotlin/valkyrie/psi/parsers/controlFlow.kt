package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes


fun parseLoopStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.LOOP) {
        builder.advanceLexer()

        // 标签在loop关键字后立即解析
        parseLabelMark(builder)

        // 检查是否是 for-in 语法糖 (loop pattern in expression)
        if (isIdentifier(builder)) {
            if (!parsePattern(parser, builder, true)) {
                marker.error("Expected pattern after 'loop'")
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

            if (!parser.parseFnBody(builder)) {
                marker.error("Expected function body after '{'")
                return true
            }

            // 解析可选的 else 子句
            parser.parseElseStatement(builder)

            marker.done(ValkyrieElementTypes.EACH_STATEMENT)
            return true
        } else {
            // 普通 loop 语句
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

    // 标签在函数体前解析
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

    // 标签在函数体前解析
    parseLabelMark(builder)

    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after until condition")
        return false
    }

    parser.parseElseStatement(builder)

    marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
    return true
}

fun parseControl(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
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

            // 可选的 return 关键字
            if (builder.tokenType == ValkyrieTokenTypes.RETURN) {
                builder.advanceLexer()
            }

            // 可选的标签
            parseLabelMark(builder)

            // 检查是否是 from 语法: yield (return? label)? (from generator)
            if (builder.tokenType == ValkyrieTokenTypes.SYMBOL_XID && builder.tokenText == "from") {
                builder.advanceLexer() // consume 'from'
                parseTermExpression(parser, builder, false) // generator expression
            } else {
                // 普通语法: yield (return? label)? value
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
        else -> return false
    }
}

// ※label
fun parseLabelMark(builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.LABEL_MARK) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()   // consume '※'
    parseIdentifier(builder) // optional
    marker.done(ValkyrieElementTypes.LABEL_STATEMENT)
    return true
}