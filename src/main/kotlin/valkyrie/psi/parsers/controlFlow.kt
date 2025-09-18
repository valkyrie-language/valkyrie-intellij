package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

fun parseLoopStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (builder.tokenType == ValkyrieTokenTypes.LOOP) {
        builder.advanceLexer() // consume 'loop' or 'for'
    } else {
        marker.rollbackTo()
        return false
    }

    var hasPattern = false;
    if (parsePattern(parser, builder, true)) {
        if (builder.tokenType == ValkyrieTokenTypes.IN) {
            builder.advanceLexer() // consume 'in'
            parseTermExpression(parser, builder, inline = false) // must
            hasPattern = true
        }
    }
    // 可选 label
    parseLabelMark(builder)
    // 解析循环体 - 必须是块语句
    if (!parser.parseFnBody(builder)) {
        builder.error("Expected '{' after loop keyword")
    }
    parser.parseElseStatement(builder)
    if (hasPattern) {
        marker.done(ValkyrieElementTypes.EACH_STATEMENT)
    } else {
        marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
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

        else -> {
            // 如果不是控制流语句，回滚标记
            marker.rollbackTo()
            return false
        }
    }
}
