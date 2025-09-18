package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

fun parseLoopStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.LOOP) {
        builder.advanceLexer() // consume 'loop'
    } else {
        marker.rollbackTo()
        return false
    }

    var hasPattern = false;
    if (parsePattern(parser, builder, true)) {
        builder.consumeKeyword(ValkyrieTokenTypes.IN) // must
        parseTermExpression(parser, builder, inline = false) // must

        hasPattern = true
    }
    // 可选 label
    parseLabelMark(builder)
    // 解析循环体 - 必须是块语句
    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after 'loop'")
    }
    parser.parseElseStatement(builder)
    if (hasPattern) {
        marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
    } else {
        marker.done(ValkyrieElementTypes.EACH_STATEMENT)
    }
    return true
}


fun parseControlFlow(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, false);
    // 在插值上下文中，直接解析表达式，不需要语句结构

    when (builder.tokenType) {
        ValkyrieTokenTypes.CONTINUE -> {
            builder.advanceLexer()
            parseLabelMark(builder) // optional
            parseTermExpression(parser, builder, false) // optional
            marker.done(ValkyrieElementTypes.CONTINUE_STATEMENT)
        }

        ValkyrieTokenTypes.FALLTHROUGH -> {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.FALLTHROUGH_STATEMENT)
        }

        ValkyrieTokenTypes.BREAK -> {
            builder.advanceLexer()
            parseLabelMark(builder)
            parseTermExpression(parser, builder, false)
            marker.done(ValkyrieElementTypes.BREAK_STATEMENT)
        }

        ValkyrieTokenTypes.RAISE -> {
            builder.advanceLexer()
            parseLabelMark(builder)
            parseTermExpression(parser, builder, false)
            marker.done(ValkyrieElementTypes.RAISE_STATEMENT)
        }

        ValkyrieTokenTypes.YIELD -> {
            builder.advanceLexer()
            parseLabelMark(builder)
            parseTermExpression(parser, builder, false)
            marker.done(ValkyrieElementTypes.YIELD_STATEMENT)
        }

        ValkyrieTokenTypes.RETURN -> {
            builder.advanceLexer()
            parseLabelMark(builder)
            parseTermExpression(parser, builder, false)
            marker.done(ValkyrieElementTypes.RETURN_STATEMENT)
        }

        ValkyrieTokenTypes.RESUME -> {
            builder.advanceLexer()
            parseLabelMark(builder)
            parseTermExpression(parser, builder, false)
            marker.done(ValkyrieElementTypes.RESUME_STATEMENT)
        }


    }
    return true
}
