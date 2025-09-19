package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.psi.parsers.consumeKeyword
import valkyrie.psi.parsers.isIdentifier
import valkyrie.psi.parsers.parseIdentifier
import valkyrie.psi.parsers.parseTermExpression

fun parseIfStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.IF) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer(); // eat 'if'
    // if let pattern = expression { } else { }
    if (builder.tokenType == ValkyrieTokenTypes.LET) {
        builder.advanceLexer(); // eat 'let'
        if (!parsePattern(parser, builder, allowBare = true)) {
            builder.error("Expected `pattern` after 'if-let'")
        }
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer(); // eat '='
        } else {
            builder.error("Expected `=` after `pattern` in 'if-let'")
        }
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected expression after `=` in 'if-let'")
        }
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected function body after `expression` in 'if-let'")
        }
        eatElseStatement(parser, builder) // optional
        marker.done(ValkyrieElementTypes.IF_LET_STATEMENT)
        return true
    }
    // if condition { } else if condition {} else { }
    else {
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected expression after 'if'")
        }
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected `function-body` after `expression` in 'if'")
        }
        // 循环处理所有 `else if`
        while (builder.tokenType == ValkyrieTokenTypes.ELSE && builder.lookAhead(1) == ValkyrieTokenTypes.IF) {
            val elseIfMarker = builder.mark()
            builder.advanceLexer() // eat 'else'
            builder.advanceLexer() // eat 'if'

            if (!parseTermExpression(parser, builder, inline = true)) {
                builder.error("Expected `expression` after `else-if`")
            }
            if (!parser.parseFnBody(builder)) {
                builder.error("Expected `function-body` after `expression` in 'else-if'")
            }
            elseIfMarker.done(ValkyrieElementTypes.ELSE_IF_PART)
        }
        eatElseStatement(parser, builder) // optional
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

fun parseLoopStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.LOOP) {
        return false
    }
    val marker = builder.mark()
    builder.advanceLexer() // eat 'loop'
    // loop pattern in expression if condition ※label { }
    if (parsePattern(parser, builder, true)) {
        if (builder.tokenType == ValkyrieTokenTypes.IN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected 'in' after 'pattern' in `loop-each` statement")
        }
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected 'expression' after 'in' in `loop-each` statement")
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected function body after '{'")
        }
        eatElseStatement(parser, builder) // optional
        marker.done(ValkyrieElementTypes.EACH_STATEMENT)
        return true
    }
    // loop ※label { }
    else {
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected function body after '{'")
        }
        eatElseStatement(parser, builder) // optional
        marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
        return true
    }
}

fun parseEachStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    return false
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
            builder.error("Expected pattern after 'let'")
        }
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // eat '='
        } else {
            builder.error("Expected '=' after pattern")
        }
        // 解析表达式
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected expression after '='")
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after while let condition")
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.WHILE_LET_STATEMENT)
        return true
    }
    // while expression if condition ※label { }
    else {
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected 'condition-expression' after `while`")
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after while condition")
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
            builder.error("Expected pattern after 'not'")
        }
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // eat '='
        } else {
            builder.error("Expected '=' after pattern")
        }
        // 解析表达式
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected expression after '='")
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after until not condition")
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.UNTIL_NOT_STATEMENT)
        return true
    }
    // until expression if condition { }
    else {
        if (!parseTermExpression(parser, builder, inline = true)) {
            builder.error("Expected 'condition-expression' after `until`")
        }
        eatIfCondition(parser, builder)
        eatLabelMark(builder)
        if (!parser.parseFnBody(builder)) {
            builder.error("Expected '{' after until condition")
        }
        eatElseStatement(parser, builder)
        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
        return true
    }
}

fun parseControlStatement(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val tokenType = builder.tokenType
    if (tokenType != ValkyrieTokenTypes.ATTRIBUTE_LOWER &&
        tokenType != ValkyrieTokenTypes.ASSERT &&
        tokenType != ValkyrieTokenTypes.DEBUG &&
        tokenType != ValkyrieTokenTypes.CONTINUE &&
        tokenType != ValkyrieTokenTypes.FALLTHROUGH &&
        tokenType != ValkyrieTokenTypes.BREAK &&
        tokenType != ValkyrieTokenTypes.RAISE &&
        tokenType != ValkyrieTokenTypes.YIELD &&
        tokenType != ValkyrieTokenTypes.RETURN &&
        tokenType != ValkyrieTokenTypes.RESUME) {
        return false
    }
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false);
    when (builder.tokenType) {
        ValkyrieTokenTypes.ASSERT -> {
            builder.advanceLexer()
            if (!parseTermExpression(parser, builder, inline = true)) {
                builder.error("Expected condition after 'assert'")
            }
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
                if (!parseTermExpression(parser, builder, inline = true)) {
                    builder.error("Expected message expression after ','")
                }
            }
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }
            marker.done(ValkyrieElementTypes.ASSERT_STATEMENT)
            return true
        }

        ValkyrieTokenTypes.DEBUG -> {
            builder.advanceLexer()
            // debug 语句参数可选
            parseTermExpression(parser, builder, inline = true)
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }
            marker.done(ValkyrieElementTypes.DEBUG_STATEMENT)
            return true
        }

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
            marker.rollbackTo()
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
        builder.error("Expected expression after `if-guard`")
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
    while (!builder.eof()) {
        val safePoint = builder.currentOffset
        when {
            builder.tokenType == ValkyrieTokenTypes.BRACE_R -> break
            parseCaseClause(parser, builder) -> continue
            parseWhenClause(parser, builder) -> continue
            parseTypeClause(parser, builder) -> continue
            parseElseClause(parser, builder) -> continue
        }
        if (builder.currentOffset == safePoint) {
            builder.error("Parser stuck in match body")
            builder.advanceLexer()
        }
    }

    if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
        builder.advanceLexer()
    } else {
        builder.error("Expected '}' for match body")
    }
    marker.done(ValkyrieElementTypes.MATCH_BODY)
    return true
}

private fun parseCaseClause(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false)
    if (builder.tokenType == ValkyrieTokenTypes.CASE) {
        builder.advanceLexer()     // eat 'case'
    } else {
        marker.rollbackTo()
        return false
    }
    // case pattern if condition:
    parsePattern(parser, builder, true)
    eatIfCondition(parser, builder)
    // ':'
    if (builder.tokenType == ValkyrieTokenTypes.COLON) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ':' after case pattern")
    }

    marker.done(ValkyrieElementTypes.CASE_CLAUSE)
    return true
}

private fun parseWhenClause(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false)
    if (builder.tokenType == ValkyrieTokenTypes.WHEN) {
        builder.advanceLexer()     // eat 'case'
    } else {
        marker.rollbackTo()
        return false
    }
    // pattern
    parseTermExpression(parser, builder, false)
    // ':'
    if (builder.tokenType == ValkyrieTokenTypes.COLON) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ':' after when pattern")
    }

    marker.done(ValkyrieElementTypes.WHEN_CLAUSE)
    return true
}

private fun parseTypeClause(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false)
    if (builder.tokenType == ValkyrieTokenTypes.TYPE) {
        builder.advanceLexer() // eat 'type'
    } else {
        marker.rollbackTo()
        return false
    }
    // typing
    parseTypeExpression(parser, builder, false)
    eatIfCondition(parser, builder)
    // ':'
    if (builder.tokenType == ValkyrieTokenTypes.COLON) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ':' after type pattern")
    }

    marker.done(ValkyrieElementTypes.TYPE_CLAUSE)
    return true
}

private fun parseElseClause(parser: ValkyrieParser, builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    parser.parseAnnotations(builder, withModifiers = false)
    if (builder.tokenType == ValkyrieTokenTypes.ELSE) {
        builder.advanceLexer()     // eat 'case'
    } else {
        marker.rollbackTo()
        return false
    }
    // ':'
    if (builder.tokenType == ValkyrieTokenTypes.COLON) {
        builder.advanceLexer()
    } else {
        builder.error("Expected ':' after case pattern")
    }

    marker.done(ValkyrieElementTypes.ELSE_CLAUSE)
    return true
}
