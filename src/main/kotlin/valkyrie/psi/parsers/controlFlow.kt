package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

fun parseIfStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.IF) {
        return false
    }
    val marker = builder.mark()
    // if let pattern = expression { }
    if (builder.tokenType == ValkyrieTokenTypes.LET) {
        builder.advanceLexer(); // eat 'if'
        builder.advanceLexer(); // eat 'let'
        if (!parsePattern(parser, builder, allowBare = false)) {
            builder.error("xxxx")
            return false
        }
        builder.advanceLexer(); // eat '='
        if (!parseTermExpression(parser, builder, inline = true)) {
            return false
        }
        if (!parser.parseFnBody(builder)) {
            return false
        }
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }
    // if condition { } else if condition {} else { }
    else {
        if (!eatIfCondition(parser, builder)) {
            return false
        }
        while (builder.tokenType == ValkyrieTokenTypes.ELSE) {
            if (builder.tokenType == ValkyrieTokenTypes.IF) {
                val elsePartMarker = builder.mark()
                builder.advanceLexer(); // eat 'else'
                if (eatIfCondition(parser, builder)) {
                    elsePartMarker.done(ValkyrieElementTypes.ELSE_IF_PART)
                } else {
                    elsePartMarker.error("incomplete if")
                    return false
                }
                // else continue
            } else {
                if (!eatElseStatement(parser, builder)) {
                    marker.rollbackTo()
                    return false
                }
            }
        }
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }
}

private fun eatElseStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false)
    if (!builder.consumeKeyword(ValkyrieTokenTypes.ELSE)) {
        marker.rollbackTo()
        return false
    }
    // 对于loop-else语法，else后面直接跟函数体，不需要表达式
    if (!parser.parseFnBody(builder)) {
        marker.rollbackTo()
        return false
    }
    marker.done(ValkyrieElementTypes.ELSE_PART)
    return true
}

// loop ※label { }
fun parseLoopStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.LOOP) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // eat 'loop'
    eatLabelMark(builder)
    if (!parser.parseFnBody(builder)) {
        marker.error("Expected function body after '{'")
        return false
    }
    eatElseStatement(parser, builder) // optional
    marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
    return true
}

// loop pattern in expression if condition ※label { }
fun parseEachStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.LOOP) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // eat 'loop'
    if (!parsePattern(parser, builder, true)) {
        marker.rollbackTo()
        return false
    }
    if (builder.tokenType == ValkyrieTokenTypes.IN) {
        builder.advanceLexer()
    } else {
        marker.error("Expected 'in' after 'pattern' in `loop-each` statement")
        return false
    }
    if (!parseTermExpression(parser, builder, inline = true)) {
        marker.error("Expected 'expression' after 'in' in `loop-each` statement")
        return false
    }
    eatIfCondition(parser, builder)
    eatLabelMark(builder)
    if (!parser.parseFnBody(builder)) {
        marker.error("Expected function body after '{'")
        return false
    }
    eatElseStatement(parser, builder) // optional
    marker.done(ValkyrieElementTypes.EACH_STATEMENT)
    return true
}

fun parseWhileStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.WHILE) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // eat 'while'
    // while let pattern = expression if condition ※label { }
    if (builder.tokenType == ValkyrieTokenTypes.LET) {
        builder.advanceLexer() // eat 'let'
        if (!parsePattern(parser, builder, true)) {
            marker.error("Expected pattern after 'let'")
            marker.done(ValkyrieElementTypes.WHILE_LET_STATEMENT)
            return true
        }
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // eat '='
        } else {
            marker.error("Expected '=' after pattern")
            marker.done(ValkyrieElementTypes.WHILE_LET_STATEMENT)
            return true
        }
        // 解析表达式
        if (!parseTermExpression(parser, builder, inline = true)) {
            marker.error("Expected expression after '='")
            marker.done(ValkyrieElementTypes.WHILE_LET_STATEMENT)
            return true
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after while let condition")
            marker.done(ValkyrieElementTypes.WHILE_LET_STATEMENT)
            return true
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.WHILE_LET_STATEMENT)
        return true
    }
    // while expression if condition ※label { }
    else {
        if (!parseTermExpression(parser, builder, inline = true)) {
            marker.error("Expected 'condition-expression' after `while`")
            marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
            return true
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after while condition")
            marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
            return true
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
        return true
    }
}

fun parseUntilStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.UNTIL) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()
    // until not pattern = expression if condition { }
    if (builder.tokenType == ValkyrieTokenTypes.NOT) {
        builder.advanceLexer() // eat 'not'
        if (!parsePattern(parser, builder, true)) {
            marker.error("Expected pattern after 'not'")
            marker.done(ValkyrieElementTypes.UNTIL_NOT_STATEMENT)
            return true
        }
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // eat '='
        } else {
            marker.error("Expected '=' after pattern")
            marker.done(ValkyrieElementTypes.UNTIL_NOT_STATEMENT)
            return true
        }
        // 解析表达式
        if (!parseTermExpression(parser, builder, inline = true)) {
            marker.error("Expected expression after '='")
            marker.done(ValkyrieElementTypes.UNTIL_NOT_STATEMENT)
            return true
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after until not condition")
            marker.done(ValkyrieElementTypes.UNTIL_NOT_STATEMENT)
            return true
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.UNTIL_NOT_STATEMENT)
        return true
    }
    // until expression if condition { }
    else {
        if (!parseTermExpression(parser, builder, inline = true)) {
            marker.error("Expected 'condition-expression' after `until`")
            marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
            return true
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after until condition")
            marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
            return true
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
        return true
    }
}

fun parseControlStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false);
    when (builder.tokenType) {
        ValkyrieTokenTypes.CONTINUE -> {
            builder.advanceLexer()
            eatLabelMark(builder) // optional
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

            eatLabelMark(builder) // optional
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
            eatLabelMark(builder) // optional
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
            eatLabelMark(builder) // optional
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
            eatLabelMark(builder)

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
            eatLabelMark(builder) // optional
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
            eatLabelMark(builder) // optional
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
            marker.drop()
            return false
        }
    }
}

// ※label
fun eatLabelMark(builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.LABEL_MARK) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()   // consume '※'
    parseIdentifier(builder) // optional
    marker.done(ValkyrieElementTypes.LABEL_STATEMENT)
    return true
}

fun eatIfCondition(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.IF) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()   // consume '※'
    if (!parseTermExpression(parser, builder, inline = true)) {
        marker.error("Expected expression after `if-guard`")
        return false
    }
    marker.done(ValkyrieElementTypes.IF_MAIN_PART)
    return true
}


// try {}
// try type { }
fun parseTryStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.TRY) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer()
    when (builder.tokenType) {
        // try?
        ValkyrieTokenTypes.WHAT -> builder.advanceLexer()
        // try!
        ValkyrieTokenTypes.WOW -> builder.advanceLexer()
    }
    parseTypeExpression(parser, builder, true) // optional
    if (!parser.parseFnBody(builder)) {
        marker.drop()
        return false
    }
    marker.done(ValkyrieElementTypes.TRY_STATEMENT)
    return true
}

fun parseCatchStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.CATCH) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // eat 'catch'
    parseTermExpression(parser, builder, inline = true)
    parseMatchBody(parser, builder)
    marker.done(ValkyrieElementTypes.CATCH_STATEMENT)
    return true
}

fun parseMatchStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.MATCH) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // eat 'match'
    parseTermExpression(parser, builder, inline = true)
    parseMatchBody(parser, builder)
    marker.done(ValkyrieElementTypes.MATCH_STATEMENT)
    return true
}


fun parseMatchBody(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
        return false
    }
    val marker = builder.mark()

    builder.advanceLexer()

    // parse match cases
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
        when (builder.tokenType) {
            ValkyrieTokenTypes.CASE -> parseMatchCase(parser, builder)
            ValkyrieTokenTypes.WHEN -> parseWhenClause(builder)
            ValkyrieTokenTypes.ELSE -> parseElseClause(parser, builder)
            else -> {
                builder.error("Expected 'case', 'when', or 'else'")
                builder.advanceLexer()
            }
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
        builder.advanceLexer()
    } else {
        builder.error("Expected '}' for match body")
    }
    marker.done(ValkyrieElementTypes.MATCH_BODY) // Assuming a new element type for match body
    return true
}

fun parseMatchCase(parser: ValkyrieParser, builder: PsiBuilder) {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false)
    // 'case' keyword
    if (builder.tokenType == ValkyrieTokenTypes.CASE) {
        builder.advanceLexer()
    } else {
        marker.drop()
        return
    }

    // pattern
    parsePattern(parser, builder, true)

    // optional guard condition
    if (builder.tokenType == ValkyrieTokenTypes.IF) {
        builder.advanceLexer()
        parseTermExpression(parser, builder, false)
    }

    // ':'
    if (builder.tokenType == ValkyrieTokenTypes.COLON) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ':' after case pattern")
    }

    // case body
    parseTermExpression(parser, builder, false)

    // optional fallthrough
    if (builder.tokenType == ValkyrieTokenTypes.FALLTHROUGH) {
        builder.advanceLexer() // consume 'fallthrough'
    }

    marker.done(ValkyrieElementTypes.MATCH_CASE)
}

fun parseWhenClause(builder: PsiBuilder) {
    val marker = builder.mark()

    marker.done(ValkyrieElementTypes.WHEN_CLAUSE)
}

fun parseElseClause(parser: ValkyrieParser, builder: PsiBuilder) {
    val marker = builder.mark()

    // 'else' keyword
    if (builder.tokenType == ValkyrieTokenTypes.ELSE) {
        builder.advanceLexer()
    } else {
        marker.drop()
        return
    }

    // ':' or '=>'
    if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ':' or '=>' after else")
    }

    // else body
    parseTermExpression(parser, builder, false)

    marker.done(ValkyrieElementTypes.WHEN_CLAUSE) // reuse WHEN_CLAUSE for else
}