package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

/**
 * Valkyrie 手写语法分析器
 * 包含性能优化和错误恢复机制
 */
class ValkyrieParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        builder.setDebugMode(true)
        val rootMarker = builder.mark()
        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            parseStatement(builder)
            if (builder.currentOffset == initialPosition) {
                builder.advanceLexer()
            }
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    /**
     * 错误恢复：跳转到下一个同步点
     */
    private fun recoverToSyncPoint(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType !in syncTokens) {
            builder.advanceLexer()
        }
    }

    private fun parseStatement(builder: PsiBuilder) {
        val safePoint = builder.currentOffset
        when {
            parseNamespaceStatement(builder) -> return
            parseUsingStatement(builder) -> return
            parseTestsStatement(builder) -> return
            parseClassStatement(builder) -> return
            parseStructureStatement(builder) -> return
            parseSingletonStatement(builder) -> return
            parseWidgetStatement(builder) -> return
            parseNeuralStatement(builder) -> return
            parseTraitStatement(builder) -> return
            parseImplyStatement(builder) -> return
            parseUnionStatement(builder) -> return
            parseUnityStatement(builder) -> return
            parseFlagsStatement(builder) -> return
            parseEnumsStatement(builder) -> return
            parseMicroStatement(builder) -> return
            parseMezzoStatement(builder) -> return
            parseMacroStatement(builder) -> return
            parseMacroAssignment(builder) -> return
            parseLetStatement(builder) -> return

//            parseLoopStatement(builder) -> return
//            parseForStatement(builder) -> return
//            parseUntilStatement(builder) -> return


//            parseCompileTimeBlock(builder) -> return
//            parseTemplateBlock(builder) -> return

//            parseWhileStatement(builder) -> return
//            parseMatchStatement(builder) -> return
//            parseIfStatement(builder) -> return
//            parseTryStatement(builder) -> return
//            parseCatchStatement(builder) -> return
//            parseReturnStatement(builder) -> return
//            parseBreakStatement(builder) -> return
//            parseContinueStatement(builder) -> return
//            parseYieldStatement(builder) -> return
//            parseRaiseStatement(builder) -> return
//            parseResumeStatement(builder) -> return
            parseScopeStatement(builder) -> return

//            parseDocComment(builder) -> return
//            parseMacroCall(builder) -> return
            builder.tokenType == null -> return
            else -> parseExpressionStatement(builder)
        }
        if (builder.currentOffset == safePoint) {
            builder.error("Unexpected token: ${builder.tokenType}")
            builder.advanceLexer()
        }
    }


    private fun parseNamespaceStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)

        // 支持不同类型: namespace, namespace!, namespace?, namespace*
        when (builder.tokenType) {
            ValkyrieTokenTypes.NAMESPACE -> {
                builder.advanceLexer()

                // 检查namespace变体: !, ?, *
                when (builder.tokenType) {
                    ValkyrieTokenTypes.WOW -> {
                        builder.advanceLexer() // 主命名空间
                    }

                    ValkyrieTokenTypes.WHAT -> {
                        builder.advanceLexer() // 仅文档空间
                    }

                    ValkyrieTokenTypes.STAR -> {
                        builder.advanceLexer() // 仅测试空间
                    }
                    // 默认情况下不需要额外处理
                }
            }

            else -> {
                marker.drop()
                return false
            }
        }
        parseNamePath(builder, free = true)
        // 可选的分号或双分号（REPL语法）
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        } else if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.NAMESPACE_STATEMENT)
        return true
    }

    private fun parseUsingStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)

        // 检查 using 关键字
        if (builder.tokenType != ValkyrieTokenTypes.USING) {
            marker.drop()
            return false
        }

        builder.advanceLexer() // consume 'using'

        // 解析 using 语句的不同格式
        when {
            // using { ... }
            builder.tokenType == ValkyrieTokenTypes.BRACE_L -> {
                if (!parseUsingBody(builder)) {
                    marker.error("Expected using body")
                    return false
                }
            }
            // using a.b.c ... (可能带 as, {}, *, 等)
            else -> {
                if (!parseUsingItem(builder)) {
                    marker.error("Expected using item")
                    return false
                }
            }
        }

        // 可选的分号
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.USING_STATEMENT)
        return true
    }

    private fun parseUsingItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析基础路径 (a.b.c 或 a::b::c) - 使用专门的using路径解析
        if (!parseUsingNamePath(builder)) {
            marker.drop()
            return false
        }

        // 检查后续的修饰符
        when (builder.tokenType) {
            // using a.*
            ValkyrieTokenTypes.DOT -> {
                builder.advanceLexer() // consume '.'
                if (builder.tokenType == ValkyrieTokenTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
                    // using a.{}
                    if (!parseUsingBody(builder)) {
                        marker.error("Expected using body")
                        return false
                    }
                } else {
                    // 对于 a.c { } 这种情况，parseUsingNamePath已经解析了完整路径
                    // 这里不应该再有DOT，说明解析有问题
                    marker.error("Expected '*' or '{' after '.'")
                    return false
                }
            }
            // using a::*
            ValkyrieTokenTypes.DOUBLE_COLON -> {
                builder.advanceLexer() // consume '::'
                if (builder.tokenType == ValkyrieTokenTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
                    // using a::{}
                    if (!parseUsingBody(builder)) {
                        marker.error("Expected using body")
                        return false
                    }
                } else {
                    // 对于 a::b { } 这种情况，parseUsingNamePath已经解析了完整路径
                    // 这里不应该再有DOUBLE_COLON，说明解析有问题
                    marker.error("Expected '*' or '{' after '::'")
                    return false
                }
            }
            // using a as b
            ValkyrieTokenTypes.AS -> {
                builder.advanceLexer() // consume 'as'
                if (!parseIdentifier(builder)) {
                    marker.error("Expected identifier after 'as'")
                    return false
                }
            }
            // using a {} 或 using a.c {} 或 using a::b {}
            ValkyrieTokenTypes.BRACE_L -> {
                if (!parseUsingBody(builder)) {
                    marker.error("Expected using body")
                    return false
                }
            }
            // using a; (简单导入)
            else -> {
                // 不需要额外处理
            }
        }

        marker.done(ValkyrieElementTypes.USING_ITEM)
        return true
    }

    private fun parseUsingBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
            marker.drop()
            return false
        }

        builder.advanceLexer() // consume '{'

        // 解析 body 内容 - 使用简化的解析逻辑避免递归
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
            val initialPosition = builder.currentOffset

            // 解析简单的标识符路径，避免递归调用parseUsingItem
            if (!parseSimpleUsingItemInBody(builder)) {
                // 跳过无法解析的 token
                builder.error("Expected using item")
                builder.advanceLexer()
            }

            // 处理分隔符: , ; 或空格
            when (builder.tokenType) {
                ValkyrieTokenTypes.COMMA, ValkyrieTokenTypes.SEMICOLON -> {
                    builder.advanceLexer()
                }
                // 结束符，不需要处理
                ValkyrieTokenTypes.BRACE_R -> {
                    break
                }
                // 其他情况继续解析下一个 item
            }

            // 防止无限循环
            if (builder.currentOffset == initialPosition) {
                builder.error("Unable to parse using body item")
                builder.advanceLexer()
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
        } else {
            marker.error("Expected '}'")
            return false
        }

        marker.done(ValkyrieElementTypes.USING_BODY)
        return true
    }

    // 简化的using item解析，专门用于body内部，避免递归
    private fun parseSimpleUsingItemInBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析基础路径 (a.b.c 或 a::b::c) - 使用专门的using路径解析
        if (!parseUsingNamePath(builder)) {
            marker.drop()
            return false
        }

        // 检查后续修饰符，支持嵌套body
        when (builder.tokenType) {
            // using a.*
            ValkyrieTokenTypes.DOT -> {
                builder.advanceLexer() // consume '.'
                if (builder.tokenType == ValkyrieTokenTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
                    // using a.{} - 支持嵌套body
                    if (!parseUsingBody(builder)) {
                        marker.error("Expected using body")
                        return false
                    }
                } else {
                    // 不是 .* 或 .{} 的情况，回退并作为简单路径处理
                    marker.done(ValkyrieElementTypes.USING_ITEM)
                    return true
                }
            }
            // using a::*
            ValkyrieTokenTypes.DOUBLE_COLON -> {
                builder.advanceLexer() // consume '::'
                if (builder.tokenType == ValkyrieTokenTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
                    // using a::{} - 支持嵌套body
                    if (!parseUsingBody(builder)) {
                        marker.error("Expected using body")
                        return false
                    }
                } else {
                    // 不是 ::* 或 ::{} 的情况，回退并作为简单路径处理
                    marker.done(ValkyrieElementTypes.USING_ITEM)
                    return true
                }
            }
            // using a as b
            ValkyrieTokenTypes.AS -> {
                builder.advanceLexer() // consume 'as'
                if (!parseIdentifier(builder)) {
                    marker.error("Expected identifier after 'as'")
                    return false
                }
            }
            // using a {} - 支持嵌套body
            ValkyrieTokenTypes.BRACE_L -> {
                if (!parseUsingBody(builder)) {
                    marker.error("Expected using body")
                    return false
                }
            }
            // 简单导入或分隔符
            else -> {
                // 不需要额外处理
            }
        }

        marker.done(ValkyrieElementTypes.USING_ITEM)
        return true
    }

    // 专门用于using语句的路径解析，允许不完整路径如 a. 或 a::
    private fun parseUsingNamePath(builder: PsiBuilder): Boolean {
        val pathMarker = builder.mark()

        // 解析第一个标识符
        val identifierMarker = builder.mark()
        if (isIdentifier(builder)) {
            builder.advanceLexer()
            identifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        } else {
            identifierMarker.error("expected identifier")
            pathMarker.drop()
            return false
        }

        // 解析路径分隔符和后续标识符，允许不完整路径
        while (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON || builder.tokenType == ValkyrieTokenTypes.DOT) {
            // 检查分隔符后是否有标识符
            val separator = builder.tokenType
            val nextToken = builder.lookAhead(1)

            // 如果分隔符后是标识符，正常解析
            if (nextToken == ValkyrieTokenTypes.IDENTIFIER_STD || nextToken == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                builder.advanceLexer() // 消费分隔符
                val nextIdentifierMarker = builder.mark()
                builder.advanceLexer() // 消费标识符
                nextIdentifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
            } else {
                // 分隔符后不是标识符，停止解析路径，让上层处理
                break
            }
        }

        pathMarker.done(ValkyrieElementTypes.NAMESPACE_PATH)
        return true
    }

    private fun parseClassStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.CLASS, ValkyrieElementTypes.CLASS_STATEMENT)
    }

    private fun parseTraitStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        if (builder.tokenType != ValkyrieTokenTypes.TRAIT) {
            marker.drop()
            return false
        }

        builder.advanceLexer() // consume 'trait'

        if (!parseIdentifier(builder)) {
            marker.error("Expected trait name")
            return false
        }

        parseGenericParameterList(builder) // optional

        // Check for trait alias (trait C = A + B;)
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // consume '='

            // Parse trait expression (A + B)
            if (!parseTraitExpression(builder)) {
                marker.error("Expected trait expression after '='")
                return false
            }

            // Expect semicolon
            if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieElementTypes.TRAIT_ALIAS)
            return true
        } else {
            // Regular trait declaration
            parseInheritanceList(builder) // optional
            parseImplementationType(builder) // optional

            if (parseObjectBody(builder)) {
                marker.done(ValkyrieElementTypes.TRAIT_STATEMENT)
                return true
            } else {
                marker.error("Expected object body")
                return false
            }
        }
    }

    private fun parseTraitExpression(builder: PsiBuilder): Boolean {
        // Parse trait expression like A + B + C
        if (!parseTypeExpression(builder, false)) {
            return false
        }

        // Parse additional traits with '+' operator
        while (builder.tokenType == ValkyrieTokenTypes.PLUS) {
            builder.advanceLexer() // consume '+'
            if (!parseTypeExpression(builder, false)) {
                return false
            }
        }

        return true
    }

    private fun parseNeuralStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.NEURAL, ValkyrieElementTypes.NEURAL_STATEMENT)
    }

    private fun parseWidgetStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.WIDGET, ValkyrieElementTypes.WIDGET_STATEMENT)
    }

    private fun parseSingletonStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.SINGLETON, ValkyrieElementTypes.SINGLETON_STATEMENT)
    }

    private fun parseStructureStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.STRUCTURE, ValkyrieElementTypes.STRUCTURE_STATEMENT)
    }

    private fun parseUnionStatement(builder: PsiBuilder): Boolean {
        return parseUnionLikeStatement(builder, ValkyrieTokenTypes.UNION, ValkyrieElementTypes.UNION_STATEMENT)
    }

    private fun parseUnityStatement(builder: PsiBuilder): Boolean {
        return parseUnionLikeStatement(builder, ValkyrieTokenTypes.UNITY, ValkyrieElementTypes.UNITY_STATEMENT)
    }

    private fun parseLetStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.LET) return false
        val marker = builder.mark()

        builder.advanceLexer() // consume 'let'

        // Parse annotations and modifiers
        parseAnnotations(builder, withModifiers = true)

        // Parse pattern (supports bare pattern, tuple pattern, array pattern, object pattern)
        if (!parsePattern(builder, true)) {
            marker.error("Expected pattern after 'let'")
            return true
        }

        // Parse optional type annotation
        parseTypeHint(builder)

        // Parse assignment if present
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // consume '='
            if (!parseTermExpression(builder, false)) {
                marker.error("Expected expression after '='")
                return true
            }
        }

        marker.done(ValkyrieElementTypes.LET_STATEMENT)
        return true
    }

    private fun parseMicroStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTokenTypes.MICRO, ValkyrieElementTypes.DECLARE_MICRO)

    }

    private fun parseMezzoStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTokenTypes.MEZZO, ValkyrieElementTypes.DECLARE_MEZZO)
    }

    private fun parseMacroStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTokenTypes.MACRO, ValkyrieElementTypes.DECLARE_MACRO)
    }

    private fun parseMacroAssignment(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        // Consume 'macro' keyword
        builder.advanceLexer()

        // Parse identifier with error recovery
        if (!parseIdentifier(builder)) {
            marker.error("Expected macro name")
            return true
        }

        // Optional generic parameters
        if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L) {
            if (!parseGenericParameterList(builder)) {
                marker.error("Invalid generic parameters")
                return true
            }
        }

        // Expect assignment with error recovery
        if (builder.tokenType != ValkyrieTokenTypes.ASSIGN) {
            marker.error("Expected '=' in macro assignment")
            return true
        }
        builder.advanceLexer() // consume '='

        // Parse expression with error recovery
        if (!parseTermExpression(builder, false)) {
            marker.error("Expected expression after '='")
            return true
        }

        marker.done(ValkyrieElementTypes.ASSIGN_MACRO)
        return true
    }

    private fun parseTestsStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        // consume `tests`
        if (builder.tokenType == ValkyrieTokenTypes.TESTS) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return false
        }

        // 解析tests body
        if (!parseObjectBody(builder)) {
            marker.error("Expected object body")
            return false
        }
        marker.done(ValkyrieElementTypes.DECLARE_TESTS)
        return true
    }


    // f(t, u)
    private fun parseTermArgumentList(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_L) {
            builder.advanceLexer()

            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
                // 允许空参数（只有逗号的情况）
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    // 创建空参数占位符
                    val emptyMarker = builder.mark()
//                    emptyMarker.done(ValkyrieElementTypes.EMPTY_ARGUMENT)
                    builder.advanceLexer() // consume ','
                } else {
                    parseTermArgumentItem(builder)

                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
                        break
                    }
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                builder.advanceLexer()
            } else {
                builder.error("Expected ')'")
            }

            marker.done(ValkyrieElementTypes.ARGUMENT_LIST)
        } else {
            marker.drop()
        }
    }

    private fun parseTermArgumentItem(builder: PsiBuilder) {
        val marker = builder.mark()

        // 检查是否是 .. 占位符参数
        if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
            builder.advanceLexer() // consume '..'
//            marker.done(ValkyrieElementTypes.PLACEHOLDER_ARGUMENT)
            return
        }

        // 可选的参数名
        val rollbackMarker = builder.mark()
        if (parseIdentifier(builder) && builder.tokenType == ValkyrieTokenTypes.COLON) {
            rollbackMarker.drop()
            builder.advanceLexer() // consume ':'
        } else {
            // 回退到原位置，不是参数名模式
            rollbackMarker.rollbackTo()
        }

        parseTermExpression(builder, inline = true)
        marker.done(ValkyrieElementTypes.EXPRESSION)
    }

    // f::<T, U>
    private fun parseTypeArgumentList(builder: PsiBuilder) {
        val marker = builder.mark()

        // 支持两种泛型括号：::< > 和 ::⟨ ⟩
        val hasDoubleColon = builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON
        val nextIsAngle = builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L
        val nextIsGeneric = builder.lookAhead(1) == ValkyrieTokenTypes.GENERIC_L

        if (hasDoubleColon && (nextIsAngle || nextIsGeneric)) {
            builder.advanceLexer() // consume '::'
            builder.advanceLexer() // consume '<' or '⟨'

            val closingToken = if (nextIsAngle) ValkyrieTokenTypes.ANGLE_R else ValkyrieTokenTypes.GENERIC_R

            while (!builder.eof() && builder.tokenType != closingToken) {
                parseTypeArgumentItem(builder)

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                } else if (builder.tokenType != closingToken) {
                    break
                }
            }

            if (builder.tokenType == closingToken) {
                builder.advanceLexer()
            } else {
                builder.error("Expected '${if (nextIsAngle) ">" else "⟩"}'")
            }

            marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
        } else {
            marker.drop()
        }
    }

    private fun parseTypeArgumentItem(builder: PsiBuilder) {
        val marker = builder.mark()
        parseTypeExpression(builder, inline = true)
        marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
    }


    // term expression with optional semicolon
    private fun parseExpressionStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析表达式
        if (!parseTermExpression(builder, false)) {
            marker.error("Expected expression")
            recoverToSyncPoint(builder)
            return false
        }

        marker.done(ValkyrieElementTypes.EXPRESSION_STATEMENT)
        return true
    }

    // inline 则不能使用 { } 尾随闭包
    private fun parseTermExpression(builder: PsiBuilder, inline: Boolean): Boolean {
        return parseTermExpressionWithPrecedence(builder, 0, inline)
    }

    private fun parseTermExpressionWithPrecedence(builder: PsiBuilder, minPrecedence: Int, inline: Boolean): Boolean {
        // 解析前缀表达式
        var left = parsePrefixTermExpression(builder) ?: return false

        // 解析中缀表达式和后缀表达式
        while (true) {
            val tokenType = builder.tokenType

            // 先检查后缀操作符
            if (isTermPostfixOperator(tokenType)) {
                left = parsePostfixTermExpression(builder, left)
                continue
            }

            // 再检查中缀操作符
            val precedence = getTermOperatorPrecedence(tokenType)
            if (precedence < minPrecedence || !isTermInfixOperator(tokenType)) {
                break
            }

            val marker = left.precede()
            builder.advanceLexer() // 消费操作符

            // 解析右操作数
            if (!parseTermExpressionWithPrecedence(builder, precedence + 1, inline)) {
                marker.error("Expected right operand")
                recoverToSyncPoint(builder)
                return false
            }

            marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            left = marker
        }

        return true
    }

    private fun parsePrefixTermExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        val tokenType = builder.tokenType

        // 检查前缀操作符
        if (isTermPrefixOperator(tokenType)) {
            val marker = builder.mark()
            builder.advanceLexer() // 消费前缀操作符

            if (parsePrefixTermExpression(builder) == null) {
                marker.error("Expected operand after prefix operator")
                recoverToSyncPoint(builder)
                return null
            }

            marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
            return marker
        }

        // 解析主要表达式
        return parsePrimaryTerm(builder)
    }

    private fun parsePostfixTermExpression(builder: PsiBuilder, left: PsiBuilder.Marker): PsiBuilder.Marker {
        val tokenType = builder.tokenType

        if (!isTermPostfixOperator(tokenType)) {
            return left
        }

        val marker = left.precede()
        builder.advanceLexer() // 消费后缀操作符

        when (tokenType) {
            ValkyrieTokenTypes.WOW -> {
                marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
                return marker
            }

            ValkyrieTokenTypes.WHAT -> {
                marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
                return marker
            }

            ValkyrieTokenTypes.PARENTHESES_L -> {
                // 函数调用
                parseTermArgumentList(builder)
                if (!builder.eof() && builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                    builder.advanceLexer()
                } else {
                    marker.error("Expected ')'")
                    recoverToSyncPoint(builder)
                    return left
                }
                marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                return marker
            }

            ValkyrieTokenTypes.DOUBLE_COLON -> {
                // 路径分隔符 a::b 或泛型路径 a::<T>
                if (builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L) {
                    // 泛型路径调用 a::<T>
                    parseGenericArgumentList(builder, false) // term level

                    // 检查是否有函数调用
                    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_L) {
                        val callMarker = marker.precede()
                        parseTermArgumentList(builder)
                        if (!builder.eof() && builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                            builder.advanceLexer()
                        } else {
                            callMarker.error("Expected ')'")
                            recoverToSyncPoint(builder)
                            return left
                        }
                        callMarker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                        marker.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                        return callMarker
                    }

                    marker.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                    return marker
                } else if (builder.lookAhead(1) == ValkyrieTokenTypes.IDENTIFIER_STD || builder.lookAhead(1) == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                    // 路径访问 a::b
                    if (!parseIdentifier(builder)) {
                        marker.error("Expected identifier after '::'")
                        recoverToSyncPoint(builder)
                        return left
                    }
                    marker.done(ValkyrieElementTypes.PATH_EXPRESSION)
                    return marker
                } else {
                    marker.drop()
                    return left
                }
            }

            ValkyrieTokenTypes.GENERIC_L -> {
                // 泛型函数调用 a<T>()
                parseGenericArgumentList(builder, false) // term level

                // 检查是否有函数调用
                if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_L) {
                    val callMarker = marker.precede()
                    parseTermArgumentList(builder)
                    if (!builder.eof() && builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                        builder.advanceLexer()
                    } else {
                        callMarker.error("Expected ')'")
                        recoverToSyncPoint(builder)
                        return left
                    }
                    callMarker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    marker.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                    return callMarker
                }

                marker.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                return marker
            }

            ValkyrieTokenTypes.ARRAY_L -> {
                // 数组访问
                if (!parseTermExpression(builder, false)) {
                    marker.error("Expected index expression")
                    recoverToSyncPoint(builder)
                    return left
                }
                if (!builder.eof() && builder.tokenType == ValkyrieTokenTypes.ARRAY_R) {
                    builder.advanceLexer()
                } else {
                    marker.error("Expected ']'")
                    recoverToSyncPoint(builder)
                    return left
                }
                marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION)
                return marker
            }

            ValkyrieTokenTypes.DOT -> {
                // 成员访问
                if (!parseIdentifier(builder)) {
                    marker.error("Expected identifier after '.'")
                    recoverToSyncPoint(builder)
                    return left
                }
                marker.done(ValkyrieElementTypes.DOT_EXPRESSION)
                return marker
            }

            else -> {
                marker.drop()
                return left
            }
        }
    }

    private fun isTermPrefixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.AMPERSAND -> true

            else -> false
        }
    }

    private fun isTermInfixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.MULTIPLY, ValkyrieTokenTypes.SLASH, ValkyrieTokenTypes.INTEGER_DIVIDE, ValkyrieTokenTypes.PERCENT, ValkyrieTokenTypes.POWER, ValkyrieTokenTypes.EQUAL, ValkyrieTokenTypes.NOT_EQUAL, ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.ANGLE_R, ValkyrieTokenTypes.LESS_EQUAL, ValkyrieTokenTypes.GREATER_EQUAL, ValkyrieTokenTypes.LOGIC_AND, ValkyrieTokenTypes.LOGIC_OR, ValkyrieTokenTypes.LOGIC_XOR, ValkyrieTokenTypes.LOGIC_NAND, ValkyrieTokenTypes.LOGIC_NOR, ValkyrieTokenTypes.LOGIC_XAND, ValkyrieTokenTypes.PIPE, ValkyrieTokenTypes.AMPERSAND, ValkyrieTokenTypes.AS, ValkyrieTokenTypes.IN, ValkyrieTokenTypes.NOT_IN, ValkyrieTokenTypes.IS, ValkyrieTokenTypes.IS_NOT -> true

            else -> false
        }
    }

    private fun isTermPostfixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WHAT, ValkyrieTokenTypes.PARENTHESES_L, ValkyrieTokenTypes.ARRAY_L, ValkyrieTokenTypes.DOT, ValkyrieTokenTypes.DOUBLE_COLON, ValkyrieTokenTypes.GENERIC_L -> true

            else -> false
        }
    }

    private fun getTermOperatorPrecedence(tokenType: IElementType?): Int {
        return operatorPrecedenceCache[tokenType] ?: 0
    }

    private fun parsePrimaryTerm(builder: PsiBuilder): PsiBuilder.Marker? {
        return when (builder.tokenType) {
            // 标识符
            ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.IDENTIFIER_RAW -> {
                val marker = builder.mark()
                if (parseIdentifier(builder)) {
                    marker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                    marker
                } else {
                    marker.drop()
                    null
                }
            }

            // 字面量
            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.BOOLEAN, ValkyrieTokenTypes.STRING_DQ, ValkyrieTokenTypes.STRING_MQ, ValkyrieTokenTypes.UNIT_NUMBER -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.LITERAL_EXPRESSION)
                marker
            }

            // 括号表达式
            ValkyrieTokenTypes.PARENTHESES_L -> {
                val marker = builder.mark()
                builder.advanceLexer() // 消费 '('

                if (!parseTermExpression(builder, false)) {
                    marker.error("Expected expression")
                    return null
                }

                if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                    builder.advanceLexer() // 消费 ')'
                } else {
                    marker.error("Expected ')'")
                    return null
                }

                marker.done(ValkyrieElementTypes.PARENTHESIZED_EXPRESSION)
                marker
            }

            // 数组表达式
            ValkyrieTokenTypes.ARRAY_L -> {
                val marker = builder.mark()
                builder.advanceLexer() // 消费 '['

                // 解析数组元素
                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
                    if (!parseTermExpression(builder, false)) {
                        marker.error("Expected expression")
                        return null
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
                        marker.error("Expected ',' or ']'")
                        return null
                    }
                }

                if (builder.tokenType == ValkyrieTokenTypes.ARRAY_R) {
                    builder.advanceLexer() // 消费 ']'
                } else {
                    marker.error("Expected ']'")
                    return null
                }

                marker.done(ValkyrieElementTypes.ARRAY_EXPRESSION)
                marker
            }

            // 块表达式
            ValkyrieTokenTypes.BRACE_L -> {
                val marker = builder.mark()
                parseFnBody(builder)
                marker.done(ValkyrieElementTypes.BLOCK_STATEMENT)
                marker
            }

            else -> {
                // 对于无法识别的 token，创建错误节点并消费该 token
                // 这确保解析器始终前进，避免 tokens 超出根元素范围
                val marker = builder.mark()
                builder.error("Unexpected token: ${builder.tokenType}")
                builder.advanceLexer() // 关键：消费无法识别的 token
                marker.done(ValkyrieElementTypes.ERROR_ELEMENT)
                marker
            }
        }
    }

    private fun parseTypeExpression(builder: PsiBuilder, inline: Boolean): Boolean {
        return parseTypeExpressionWithPrecedence(builder, 0)
    }

    private fun parseTypeExpressionWithPrecedence(builder: PsiBuilder, minPrecedence: Int): Boolean {
        // 解析前缀类型表达式
        var left = parsePrefixTypeExpression(builder) ?: return false

        // 解析中缀类型表达式
        while (true) {
            val tokenType = builder.tokenType
            val precedence = getTypeOperatorPrecedence(tokenType)

            if (precedence < minPrecedence) {
                break
            }

            // 检查是否是类型中缀操作符
            if (!isTypeInfixOperator(tokenType)) {
                break
            }

            val marker = left?.precede() ?: return false
            builder.advanceLexer() // 消费操作符

            // 解析右操作数
            if (!parseTypeExpressionWithPrecedence(builder, precedence + 1)) {
                marker.error("Expected type expression")
                recoverToSyncPoint(builder)
                return false
            }

            when (tokenType) {
                ValkyrieTokenTypes.PIPE -> marker.done(ValkyrieElementTypes.UNION_TYPE)
                ValkyrieTokenTypes.AMPERSAND -> marker.done(ValkyrieElementTypes.INTERSECTION_TYPE)
                else -> marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            }
            left = marker
        }

        // 解析后缀类型表达式
        left = parsePostfixTypeExpression(builder, left)

        return true
    }

    private fun parsePrefixTypeExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        val tokenType = builder.tokenType

        // 检查类型前缀操作符 (只有 +- )
        if (isTypePrefixOperator(tokenType)) {
            val marker = builder.mark()
            builder.advanceLexer() // 消费前缀操作符

            if (parsePrefixTypeExpression(builder) == null) {
                marker.error("Expected type after prefix operator")
                recoverToSyncPoint(builder)
                return null
            }

            marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
            return marker
        }

        // 解析主要类型表达式
        return parsePrimaryType(builder)
    }

    private fun parsePostfixTypeExpression(builder: PsiBuilder, left: PsiBuilder.Marker): PsiBuilder.Marker {
        var current = left

        while (true) {
            val tokenType = builder.tokenType

            if (!isTypePostfixOperator(tokenType)) {
                break
            }

            val marker = current.precede()
            builder.advanceLexer() // 消费后缀操作符

            when (tokenType) {
                ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WOW -> {
                    // 非空类型 T!
                    marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
                }

                ValkyrieTokenTypes.WHAT -> {
                    // 可选类型 T?
                    marker.done(ValkyrieElementTypes.OPTIONAL_TYPE)
                }

                else -> break
            }

            current = marker
        }

        return current
    }

    private fun isTypePrefixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS -> true

            else -> false
        }
    }

    private fun isTypeInfixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.PIPE,      // 联合类型 T | U
            ValkyrieTokenTypes.AMPERSAND, // 交集类型 T & U
            ValkyrieTokenTypes.PLUS,      // 类型加法 T + U
            ValkyrieTokenTypes.MINUS -> true // 类型减法 T - U
            else -> false
        }
    }

    private fun isTypePostfixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.WOW, // 非空类型 T!
            ValkyrieTokenTypes.WOW,         // 非空类型 T!
            ValkyrieTokenTypes.WHAT -> true // 可选类型 T?
            else -> false
        }
    }

    private fun getTypeOperatorPrecedence(tokenType: IElementType?): Int {
        return when (tokenType) {
            ValkyrieTokenTypes.PIPE -> 1      // 联合类型优先级最低
            ValkyrieTokenTypes.AMPERSAND -> 2 // 交集类型
            ValkyrieTokenTypes.PLUS -> 3      // 类型加法
            ValkyrieTokenTypes.MINUS -> 3     // 类型减法
            else -> 0
        }
    }

    private fun parsePrimaryType(builder: PsiBuilder): PsiBuilder.Marker? {
        val tokenType = builder.tokenType

        return when (tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD -> {
                val marker = builder.mark()
                builder.advanceLexer()

                // 检查是否有泛型参数
                if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L || builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                    parseGenericArgumentList(builder, true)
                }

                // 处理路径分隔符和后续的泛型路径
                while (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
                    builder.advanceLexer() // 消费 ::

                    // 检查是否是泛型调用语法 ::<T> 或 ::⟨T⟩
                    if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L || builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                        parseGenericArgumentList(builder, true)
                    } else if (isIdentifier(builder)) {
                        // 普通路径分隔符后的标识符
                        builder.advanceLexer()

                        // 检查该标识符后是否有泛型参数
                        if (builder.tokenType == ValkyrieTokenTypes.GENERIC_L || builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                            parseGenericArgumentList(builder, true)
                        }
                    } else {
                        // 错误：:: 后应该跟标识符或泛型参数
                        break
                    }
                }

                marker.done(ValkyrieElementTypes.TYPE_REFERENCE)
                marker
            }

            ValkyrieTokenTypes.PARENTHESES_L -> {
                // 括号类型表达式 (T) 或 tuple 类型 (T, U)
                val marker = builder.mark()
                builder.advanceLexer() // 消费 (

                var isTuple = false
                if (!parseTypeExpression(builder, false)) {
                    marker.error("Expected type expression")
                    recoverToSyncPoint(builder)
                    return null
                }

                // 检查是否有逗号，如果有则是 tuple 类型
                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    isTuple = true
                    builder.advanceLexer() // 消费逗号

                    // 允许尾随逗号
                    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                        break
                    }

                    if (!parseTypeExpression(builder, false)) {
                        marker.error("Expected type expression after ','")
                        recoverToSyncPoint(builder)
                        return null
                    }
                }

                if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
                    marker.error("Expected ')'")
                    recoverToSyncPoint(builder)
                    return null
                }

                builder.advanceLexer() // 消费 )
                if (isTuple) {
                    marker.done(ValkyrieElementTypes.TUPLE_TYPE)
                } else {
                    marker.done(ValkyrieElementTypes.PARENTHESIZED_TYPE)
                }
                marker
            }

            ValkyrieTokenTypes.ARRAY_L -> {
                // 数组类型 [T]
                val marker = builder.mark()
                builder.advanceLexer() // 消费 [

                if (!parseTypeExpression(builder, false)) {
                    marker.error("Expected type expression")
                    recoverToSyncPoint(builder)
                    return null
                }

                if (builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
                    marker.error("Expected ']'")
                    recoverToSyncPoint(builder)
                    return null
                }

                builder.advanceLexer() // 消费 ]
                marker.done(ValkyrieElementTypes.ARRAY_TYPE)
                marker
            }

            ValkyrieTokenTypes.BRACE_L -> {
                // 元组类型 {T, U}
                val marker = builder.mark()
                builder.advanceLexer() // 消费 {

                // 解析类型列表
                if (builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
                    do {
                        if (!parseTypeExpression(builder, false)) {
                            marker.error("Expected type expression")
                            recoverToSyncPoint(builder)
                            return null
                        }

                        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                            builder.advanceLexer()
                        } else {
                            break
                        }
                    } while (builder.tokenType != ValkyrieTokenTypes.BRACE_R)
                }

                if (builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
                    marker.error("Expected '}'")
                    recoverToSyncPoint(builder)
                    return null
                }

                builder.advanceLexer() // 消费 }
                marker.done(ValkyrieElementTypes.TUPLE_TYPE)
                marker
            }

            // 基本类型关键字
            ValkyrieTokenTypes.BOOLEAN, ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.STRING_DQ -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.PRIMITIVE_TYPE)
                marker
            }

            else -> null
        }
    }


    private fun parseClassLikeStatements(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (builder.tokenType == keyword) {
            // consume keyword
            builder.advanceLexer()
        } else {
            marker.drop()
            return false
        }
        if (parseIdentifier(builder)) {
            // continue
        } else {
            marker.error("Expected class name")
            recoverToSyncPoint(builder)
            return false
        }

        parseGenericParameterList(builder) // optional
        parseInheritanceList(builder) // optional
        parseImplementationType(builder) // optional

        if (parseObjectBody(builder)) {
            marker.done(node)
            return true
        } else {
            marker.error("Expected object body")
            recoverToSyncPoint(builder)
            return false
        }
    }

    private fun parseObjectBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        // Expect opening brace
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
            marker.drop()
            return false
        }
        // consume '{'
        else {
            builder.advanceLexer()
        }
        // Parse body content
        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTokenTypes.BRACE_R -> {
                    break
                }
                // 跳过分隔符
                builder.tokenType == ValkyrieTokenTypes.COMMA -> {
                    builder.advanceLexer()
                    continue
                }

                builder.tokenType == ValkyrieTokenTypes.SEMICOLON -> {
                    builder.advanceLexer()
                    continue
                }

                parseMezzoAssign(builder) -> continue
                parseTestsStatement(builder) -> continue
                parseMacroCall(builder, true) -> continue
                parseMethod(builder) -> continue
                parseDomain(builder) -> continue
                parseField(builder) -> continue
                else -> {
                    // 未知token，创建错误节点并消费该token
                    val marker = builder.mark()
                    builder.error("Unexpected token in object body: ${builder.tokenType}")
                    builder.advanceLexer()
                    marker.done(ValkyrieElementTypes.ERROR_ELEMENT)
                }
            }
            if (builder.currentOffset == safePoint) {
                builder.error("Infinite loop detected in `parseTestBody`")
                builder.advanceLexer() // 强制前进
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
            marker.done(ValkyrieElementTypes.OBJECT_BODY)
            return true
        } else {
            marker.error("Expected '}'")
            return false
        }
    }

    private fun parseUnionLikeStatement(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (builder.tokenType != keyword) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume the keyword token
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        parseGenericParameterList(builder) // optional
        parseInheritanceList(builder)      // optional
        parseImplementationType(builder)   // optional
        if (!parseUnionBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(node)
        return true
    }

    private fun parseUnionBody(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
            return false
        }
        val marker = builder.mark()
        builder.advanceLexer()
        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTokenTypes.BRACE_R -> break
                builder.tokenType == ValkyrieTokenTypes.COMMA -> {
                    builder.advanceLexer()
                    continue
                }
                builder.tokenType == ValkyrieTokenTypes.SEMICOLON -> {
                    builder.advanceLexer()
                    continue
                }
                parseVariant(builder) -> continue
                parseMethod(builder) -> continue
            }

            // 防止无限循环：确保解析器前进
            if (builder.currentOffset == safePoint) {
                builder.error("Unable to parse union member")
                builder.advanceLexer()
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.UNION_BODY)
            return true
        } else {
            builder.error("Expected '}'")
            return false
        }
    }


    private fun parseVariant(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        parseObjectBody(builder) // optional

        // 处理可选的分隔符（逗号或分号）
        if (builder.tokenType == ValkyrieTokenTypes.COMMA || builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.UNION_VARIANT)
        return true
    }

    private fun parseFlagsStatement(builder: PsiBuilder): Boolean {
        return parseEnumerateLikeStatement(builder, ValkyrieTokenTypes.FLAGS, ValkyrieElementTypes.FLAGS_STATEMENT)
    }

    private fun parseEnumsStatement(builder: PsiBuilder): Boolean {
        return parseEnumerateLikeStatement(builder, ValkyrieTokenTypes.EIDOS, ValkyrieElementTypes.EIDOS_STATEMENT)
    }

    private fun parseEnumerateLikeStatement(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (builder.tokenType != keyword) {
            marker.rollbackTo()
            return false
        }
        // consume `enum`
        else {
            builder.advanceLexer()
        }
        /// enum Enumerate { }
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
//        parseGenericParameterList(builder)
        parseInheritanceList(builder)
        if (!parseEnumerateBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(node)
        return true
    }

    private fun parseEnumerateBody(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) {
            return false
        }
        val marker = builder.mark()
        builder.advanceLexer()

        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTokenTypes.BRACE_R -> break
                parseSemanticItem(builder) -> continue
            }

            // 防止无限循环：确保解析器前进
            if (builder.currentOffset == safePoint) {
                builder.error("Unable to parse enumerate member")
                builder.advanceLexer()
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
            return false
        }

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
        return true
    }

    private fun parseSemanticItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        parseDefaultValue(builder) // optional

        // 处理可选的分号
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.FLAGS_ITEM)
        return true
    }

    private fun parseImplyStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (builder.tokenType != ValkyrieTokenTypes.IMPLY) {
            marker.rollbackTo()
            return false
        }
        parseGenericParameterList(builder)
        // impl module::Type
        if (!parseNamePath(builder, free = true)) {
            marker.rollbackTo()
            return false
        }
        // impl module::Type: Trait
        parseImplementationType(builder)
        if (!parseObjectBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(ValkyrieElementTypes.IMPLY_STATEMENT)
        return true
    }


    private fun parseGenericArgumentList(builder: PsiBuilder, typeLevel: Boolean) {
        // term level 支持两种泛型语法 ⟨T⟩ 和 ::<T>
        // type level 额外支持一种 <T>
        val marker = builder.mark()

        val (startToken, endToken) = when {
            builder.tokenType == ValkyrieTokenTypes.GENERIC_L -> ValkyrieTokenTypes.GENERIC_L to ValkyrieTokenTypes.GENERIC_R
            typeLevel && builder.tokenType == ValkyrieTokenTypes.ANGLE_L -> ValkyrieTokenTypes.ANGLE_L to ValkyrieTokenTypes.ANGLE_R
            builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON && builder.lookAhead(1) == ValkyrieTokenTypes.GENERIC_L -> {
                builder.advanceLexer() // consume '::'
                ValkyrieTokenTypes.GENERIC_L to ValkyrieTokenTypes.GENERIC_R
            }
            typeLevel && builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON && builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L -> {
                builder.advanceLexer() // consume '::'
                ValkyrieTokenTypes.ANGLE_L to ValkyrieTokenTypes.ANGLE_R
            }

            else -> {
                marker.drop()
                return
            }
        }

        if (builder.tokenType == startToken) {
            builder.advanceLexer() // consume opening bracket

            // 允许空的泛型参数列表
            if (builder.tokenType != endToken) {
                // Parse first argument
                if (!parseGenericArgumentItem(builder)) {
                    marker.error("Expected generic argument")
                    return
                }

                // Parse remaining arguments
                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                    if (!parseGenericArgumentItem(builder)) {
                        marker.error("Expected generic argument after ','")
                        return
                    }
                }
            }

            // Expect closing bracket
            if (builder.tokenType == endToken) {
                builder.advanceLexer() // consume closing bracket
            } else {
                val expectedSymbol = if (endToken == ValkyrieTokenTypes.GENERIC_R) ">" else ">"
                marker.error("Expected '$expectedSymbol' to close generic argument list")
                return
            }
        }

        marker.done(ValkyrieElementTypes.ARGUMENT_LIST)
    }

    private fun parseGenericArgumentItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // Parse type expression as generic argument
        if (parseTypeExpression(builder, true)) {
            marker.done(ValkyrieElementTypes.EXPRESSION)
            return true
        } else {
            marker.drop()
            return false
        }
    }

    private fun parseGenericParameterList(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 支持两种泛型括号：< > 和 ⟨ ⟩
        val isAngleBrackets = builder.tokenType == ValkyrieTokenTypes.ANGLE_L
        val isGenericBrackets = builder.tokenType == ValkyrieTokenTypes.GENERIC_L

        if (isAngleBrackets || isGenericBrackets) {
            builder.advanceLexer() // consume '<' or '⟨'

            val closingToken = if (isAngleBrackets) ValkyrieTokenTypes.ANGLE_R else ValkyrieTokenTypes.GENERIC_R

            // 允许空的泛型参数列表
            if (builder.tokenType != closingToken) {
                // Parse first parameter
                if (!parseGenericParameterItem(builder)) {
                    marker.error("Expected generic parameter")
                    return false
                }

                // Parse additional parameters
                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                    if (!parseGenericParameterItem(builder)) {
                        marker.error("Expected generic parameter after ','")
                        return false
                    }
                }
            }

            if (builder.tokenType == closingToken) {
                builder.advanceLexer() // consume '>' or '⟩'
                marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
                return true
            } else {
                marker.error("Expected '${if (isAngleBrackets) ">" else "⟩"}'")
                return false
            }
        } else {
            marker.drop()
            return false
        }
    }

    private fun parseGenericParameterItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // Parse annotations and modifiers
        parseAnnotations(builder, withModifiers = true)

        // Parse identifier
        if (!parseIdentifier(builder)) {
            marker.error("Expected parameter name")
            return false
        }

        // Parse optional type constraint
        parseTypeHint(builder)

        // Parse optional default type
        parseDefaultType(builder)

        marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
        return true
    }


    private fun parseFnLikeStatement(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (builder.tokenType != keyword) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume the keyword token
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        parseGenericParameterList(builder) // micro f<T>(), optional
        // micro f()
        if (!parseFunctionParameterList(builder)) {
            marker.rollbackTo()
            return false
        }
        parseReturnType(builder)           // optional return type
        parseEffectType(builder)           // optional effect
        if (!parseFnBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(node)
        return true
    }

    private fun parseFnBody(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) return false
        val marker = builder.mark()
        builder.advanceLexer()

        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTokenTypes.BRACE_R -> break
                parseExpressionStatement(builder) -> continue
                else -> {
//                    parseExpressionStatement(builder)
                    // 未知token，创建错误节点并消费该token
                    val marker = builder.mark()
                    builder.error("Unexpected token in object body: ${builder.tokenType}")
                    builder.advanceLexer()
                    marker.done(ValkyrieElementTypes.ERROR_ELEMENT)
                }
            }

            // 防止死循环：确保解析器位置有前进
            if (builder.currentOffset == safePoint) {
                builder.error("Parser stuck at position ${safePoint}")
                builder.advanceLexer() // 强制前进
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.FUNCTION_BODY)
        return true
    }

    private fun parseTypeHint(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            val marker = builder.mark()
            builder.advanceLexer() // consume ':'
            parseTypeExpression(builder, true)
            marker.done(ValkyrieElementTypes.TYPE_HINT)
        }
    }

    private fun parseDefaultType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            val marker = builder.mark()
            builder.advanceLexer()
            parseTypeExpression(builder, false)
            marker.done(ValkyrieElementTypes.DEFAULT_TYPE)
        }
    }

    private fun parseReturnType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            val marker = builder.mark()
            // consume '->'
            builder.advanceLexer()
            parseTypeExpression(builder, true)
            marker.done(ValkyrieElementTypes.RETURN_TYPE)
        }
    }

    private fun parseEffectType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.SLASH) {
            val marker = builder.mark()
            builder.advanceLexer() // consume '/'
            parseTypeExpression(builder, true)
            marker.done(ValkyrieElementTypes.EFFECT_TYPE)
        }
    }

    private fun parseImplementationType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(builder, true)
        }
    }

    private fun parseDefaultValue(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            val marker = builder.mark()
            builder.advanceLexer()
            parseTermExpression(builder, false)
            marker.done(ValkyrieElementTypes.DEFAULT_VALUE)
        }
    }

    /**
     * 解析mezzo关联类型声明
     * 格式: mezzo TypeName [: Bounds] [= DefaultType],
     */
    private fun parseMezzoAssign(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (builder.tokenType == ValkyrieTokenTypes.MEZZO) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return false
        }
        if (parseIdentifier(builder)) {
            // continue
        } else {
            marker.error("Expected mezzo name")
            recoverToSyncPoint(builder)
            return false
        }
        parseTypeHint(builder) // optional
        parseDefaultType(builder) // optional
        marker.done(ValkyrieElementTypes.ASSIGN_MEZZO)
        return true
    }

    private fun parseField(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (parseIdentifier(builder)) {
            // continue
        } else {
            marker.rollbackTo()
            return false
        }
        parseReturnType(builder)
        parseDefaultValue(builder)
        marker.done(ValkyrieElementTypes.FIELD_DECLARATION)
        return true
    }

    private fun parseMethod(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true) // never fail

        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        if (!parseFunctionParameterList(builder)) {
            marker.rollbackTo()
            return false
        }

        parseReturnType(builder) // optional
        parseEffectType(builder) // optional
        parseFnBody(builder) // optional

        marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
        return true
    }

    private fun parseDomain(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        if (!parseObjectBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
        return true
    }

    private fun parseFunctionParameterList(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_L) {
            return false
        }

        val marker = builder.mark()
        builder.advanceLexer() // consume '('

        // 允许空参数列表
        if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
            // 解析第一个参数
            if (!parseFunctionParameterItem(builder)) {
                marker.error("Expected parameter")
                return false
            }

            // 解析后续参数 (, param)*
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','

                // 检查是否是尾随逗号（可选）
                if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                    break // 允许尾随逗号
                }

                if (!parseFunctionParameterItem(builder)) {
                    marker.error("Expected parameter after ','")
                    return false
                }
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
            builder.advanceLexer() // consume ')'
        } else {
            builder.error("Expected ')'")
            return false
        }
        marker.done(ValkyrieElementTypes.TERM_PARAMETER_LIST)
        return true
    }

    private fun parseFunctionParameterItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析注解
        parseAnnotations(builder, withModifiers = true)

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

        parseTypeHint(builder)
        parseDefaultValue(builder)

        marker.done(ValkyrieElementTypes.TERM_PARAMETER_ITEM)
        return true
    }


    /**
     * 解析宏调用
     * 支持: @macro_name, @module_path::macro_name
     */
    private fun parseMacroCall(builder: PsiBuilder, withAnnotation: Boolean): Boolean {
        val marker = builder.mark()
        if (withAnnotation) {
            parseAnnotations(builder, withModifiers = false)
        }
        if (builder.tokenType != ValkyrieTokenTypes.AT) {
            marker.drop()
            return false
        }
        // consume '@'
        else {
            builder.advanceLexer()
        }
        if (parseNamePath(builder, free = false)) {
            // continue
        } else {
            builder.error("Expected macro name")
            marker.drop()
            return false
        }
        parseObjectBody(builder)
        marker.done(ValkyrieElementTypes.MACRO_CALL)
        return true
    }

    private fun parseDocComment(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.COMMENT_DOCUMENT) return false
        val marker = builder.mark()

        builder.advanceLexer()
        marker.done(ValkyrieElementTypes.DOC_COMMENT)
        return true
    }

    private fun parseUntilStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.UNTIL) return false
        val marker = builder.mark()

        parseFnBody(builder)
        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
        return true
    }

    private fun parseWhileStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.WHILE) return false
        val marker = builder.mark()

        parseFnBody(builder)

        marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
        return true
    }

    private fun parseMatchStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.MATCH) return false
        val marker = builder.mark()

        // 'match' keyword
        builder.advanceLexer()

        // expression to match
        parseTermExpression(builder, inline = true)
        parseMatchBody(builder)
        marker.done(ValkyrieElementTypes.MATCH_STATEMENT)
        return true
    }

    private fun parseMatchBody(builder: PsiBuilder) {
        // parse match cases
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.CASE -> parseMatchCase(builder)
                ValkyrieTokenTypes.WHEN -> parseWhenClause(builder)
                ValkyrieTokenTypes.ELSE -> parseElseClause(builder)
                else -> {
                    builder.error("Expected 'case', 'when', or 'else'")
                    builder.advanceLexer()
                }
            }
        }
    }

    private fun parseMatchCase(builder: PsiBuilder) {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        // 'case' keyword
        if (builder.tokenType == ValkyrieTokenTypes.CASE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // pattern
        parsePattern(builder, true)

        // optional guard condition
        if (builder.tokenType == ValkyrieTokenTypes.IF) {
            builder.advanceLexer()
            parseTermExpression(builder, false)
        }

        // ':'
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ':' after case pattern")
        }

        // case body
        parseTermExpression(builder, false)

        // optional fallthrough
        if (builder.tokenType == ValkyrieTokenTypes.FALLTHROUGH) {
            builder.advanceLexer() // consume 'fallthrough'
        }

        marker.done(ValkyrieElementTypes.MATCH_CASE)
    }

    private fun parseWhenClause(builder: PsiBuilder) {
        val marker = builder.mark()

        marker.done(ValkyrieElementTypes.WHEN_CLAUSE)
    }

    private fun parseElseClause(builder: PsiBuilder) {
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
        parseTermExpression(builder, false)

        marker.done(ValkyrieElementTypes.WHEN_CLAUSE) // reuse WHEN_CLAUSE for else
    }

    private fun parseTryStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.TRY) return false
        // try {}
        // try type { }
        // check try
        parseTypeExpression(builder, true)
        parseFnBody(builder)
        return true
    }

    private fun parseCatchStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.CATCH) return false
        val marker = builder.mark()

        // 'catch' keyword
        builder.advanceLexer()

        // optional error variable
        parseTermExpression(builder, inline = true)
        parseMatchBody(builder)

        marker.done(ValkyrieElementTypes.CATCH_STATEMENT)
        return true
    }

    private fun parsePattern(builder: PsiBuilder, allowBare: Boolean): Boolean {
        return when {
            parseTuplePattern(builder) -> true
            parseTablePattern(builder) -> true
            parseObjectPattern(builder) -> true
            allowBare && parseBarePattern(builder) -> true
            else -> false
        }
    }

    private fun parseBarePattern(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseModifierList(builder)
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
//        marker.done(ValkyrieElementTypes.BARE_PATTERN)
        return true
    }

    private fun parseTupleType(builder: PsiBuilder) {
        // one of
        parseTupleTypePair(builder)
        parseTupleTypeItem(builder)
    }

    private fun parseTupleTypePair(builder: PsiBuilder) {
        // a: b
        parseAnnotations(builder, withModifiers = true)
        parseIdentifier(builder)
        // :
        parseTypeExpression(builder, inline = false)
    }

    private fun parseTuplePattern(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_L) return false
        val marker = builder.mark()

        builder.advanceLexer() // consume '('

        // Parse pattern list
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
            if (!parsePattern(builder, true)) {
                if (!parseIdentifier(builder)) {
                    marker.error("Expected pattern or identifier")
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
                marker.error("Expected ',' or ')'")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
            builder.advanceLexer() // consume ')'
        } else {
            marker.error("Expected ')'")
            return false
        }

        marker.done(ValkyrieElementTypes.TUPLE_PATTERN)
        return true
    }

    private fun parseTupleTypeItem(builder: PsiBuilder) {
        parseTypeExpression(builder, inline = false)
    }

    private fun parseTupleList(builder: PsiBuilder) {
        // one of
        parseTuplePair(builder)
        parseTupleItem(builder)
    }

    private fun parseTuplePair(builder: PsiBuilder) {
        // a: b
        parseAnnotations(builder, withModifiers = true)
        parseIdentifier(builder)
        // :
        parseTermExpression(builder, inline = false)
    }

    private fun parseTupleItem(builder: PsiBuilder) {
        parseTermExpression(builder, inline = false)
    }

    // [T; N]
    private fun parseTableType(builder: PsiBuilder) {
        parseTypeExpression(builder, inline = false)
        // optional
        parseTypeExpression(builder, inline = false)
    }

    // [a, b, c]
    // [a: b, b: c]
    private fun parseTablePattern(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.ARRAY_L) return false
        val marker = builder.mark()

        builder.advanceLexer() // consume '['

        // Parse pattern list
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
            // Handle rest pattern ..rest
            if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
                builder.advanceLexer() // consume '..'
                if (!parseIdentifier(builder)) {
                    marker.error("Expected identifier after '..'")
                    return false
                }
            } else if (!parsePattern(builder, true)) {
                if (!parseIdentifier(builder)) {
                    marker.error("Expected pattern or identifier")
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
                marker.error("Expected ',' or ']'")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.ARRAY_R) {
            builder.advanceLexer() // consume ']'
        } else {
            marker.error("Expected ']'")
            return false
        }

        marker.done(ValkyrieElementTypes.ARRAY_PATTERN)
        return true
    }

    private fun parseTableList(builder: PsiBuilder) {
        // one of
        parseTablePair(builder)
        parseTableItem(builder)
    }

    private fun parseTablePair(builder: PsiBuilder) {
        // a: b
        parseAnnotations(builder, withModifiers = true)
        parseIdentifier(builder)
        // :
        parseTermExpression(builder, inline = false)
    }

    private fun parseTableItem(builder: PsiBuilder) {
        parseTermExpression(builder, inline = false)
    }

    private fun parseObjectPattern(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) return false
        val marker = builder.mark()

        builder.advanceLexer() // consume '{'

        // Parse pattern fields
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
            // Handle rest pattern ..rest or ..
            if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT) {
                builder.advanceLexer() // consume '..'
                // Optional identifier after ..
                parseIdentifier(builder)
            } else {
                // Parse field pattern: identifier or identifier: pattern
                if (!parseIdentifier(builder)) {
                    marker.error("Expected field name")
                    return false
                }

                // Optional type annotation or pattern
                if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                    builder.advanceLexer() // consume ':'
                    if (!parsePattern(builder, true)) {
                        if (!parseIdentifier(builder)) {
                            marker.error("Expected pattern after ':'")
                            return false
                        }
                    }
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
                marker.error("Expected ',' or '}'")
                return false
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
        } else {
            marker.error("Expected '}'")
            return false
        }

        marker.done(ValkyrieElementTypes.OBJECT_PATTERN)
        return true
    }


    private fun parseLabelMark(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.LABEL_MARK) return false
        val marker = builder.mark()

        // consume '※'
        builder.advanceLexer()
        // optional
        parseIdentifier(builder)
        marker.done(ValkyrieElementTypes.LABEL_STATEMENT)
        return true
    }

    // a[]
    // a[:]
    // a[::]
    // a[1:-1:1]
    private fun parseSliceList(builder: PsiBuilder) {
        // optional
        parseSliceItem(builder)
    }

    private fun parseSliceItem(builder: PsiBuilder) {
        // optional
        parseTermExpression(builder, inline = false)
        // optional
        parseTermExpression(builder, inline = false)
        // optional
        parseTermExpression(builder, inline = false)
    }


    private fun parseReturnStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.RETURN) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'return'

        // Check for optional label
        parseLabelMark(builder)

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON && builder.tokenType != ValkyrieTokenTypes.NEWLINE && !builder.eof()) {
            parseTermExpression(builder, false)
        }

        marker.done(ValkyrieElementTypes.RETURN_STATEMENT)
        return true
    }

    private fun parseBreakStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BREAK) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'break'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (!parseIdentifier(builder)) {
                builder.error("Expected label name after ※")
            }
        }

        marker.done(ValkyrieElementTypes.BREAK_STATEMENT)
        return true
    }

    private fun parseContinueStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.CONTINUE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'continue'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (!parseIdentifier(builder)) {
                builder.error("Expected label name after ※")
            }
        }

        marker.done(ValkyrieElementTypes.CONTINUE_STATEMENT)
        return true
    }

    private fun parseYieldStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.YIELD) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'yield'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (!parseIdentifier(builder)) {
                builder.error("Expected label name after ※")
            }
        }

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON && builder.tokenType != ValkyrieTokenTypes.NEWLINE && !builder.eof()) {
            parseTermExpression(builder, false)
        }

        marker.done(ValkyrieElementTypes.YIELD_STATEMENT)
        return true
    }

    private fun parseRaiseStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.RAISE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'raise'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (!parseIdentifier(builder)) {
                builder.error("Expected label name after ※")
            }
        }

        // Parse required expression for raise
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON && builder.tokenType != ValkyrieTokenTypes.NEWLINE && !builder.eof()) {
            parseTermExpression(builder, false)
        } else {
            builder.error("Expected expression after 'raise'")
        }

        marker.done(ValkyrieElementTypes.RAISE_STATEMENT)
        return true
    }

    private fun parseIfStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.IF) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'if'
        // Parse optional else/else if clauses
        parseTermExpression(builder, inline = true)
        parseFnBody(builder)
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }

    private fun parseElseIfStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.ELSE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'else'
        if (builder.tokenType == ValkyrieTokenTypes.IF) {
            builder.advanceLexer() // consume 'if'
        } else {
            return false
        }
        parseTermExpression(builder, inline = true)
        parseFnBody(builder)
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }


    private fun parseElseStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.ELSE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'else'
        parseFnBody(builder)

        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }


    private fun parseIfLetStatement(builder: PsiBuilder, marker: PsiBuilder.Marker): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.LET) return false
        builder.advanceLexer() // consume 'let'

        // consume 'if'
        // consume 'let'
        // Parse optional else/else if clauses
        parseTermExpression(builder, inline = true)
        parseFnBody(builder)
        marker.done(ValkyrieElementTypes.IF_LET_STATEMENT)
        return true
    }

    /**
     * 解析编译期表达式块 <{ ... }>
     */
    private fun parseCompileTimeBlock(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START) return false
        val marker = builder.mark()

        // 消费 '<{'
        builder.advanceLexer()

        // 解析块内容
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END) {
            val initialPosition = builder.currentOffset
            parseStatement(builder)

            // 防止无限循环：确保解析器前进
            if (builder.currentOffset == initialPosition) {
                builder.error("Unable to parse statement in compile-time block")
                builder.advanceLexer()
            }
        }

        // 消费 '}>'
        if (builder.tokenType == ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}>'")
        }

        marker.done(ValkyrieElementTypes.COMPILE_TIME_BLOCK)
        return true
    }

    /**
     * 解析模板语法块 <$ ... $>
     */
    private fun parseTemplateBlock(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.TEMPLATE_START) return false
        val marker = builder.mark()

        // 消费 '<$'
        builder.advanceLexer()

        // 解析模板内容
        parseTemplateContent(builder)

        // 消费 '$>'
        if (builder.tokenType == ValkyrieTokenTypes.TEMPLATE_END) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '$>'")
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_BLOCK)
        return true
    }

    /**
     * 解析模板内容
     */
    private fun parseTemplateContent(builder: PsiBuilder): Boolean {
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END) {
            val initialPosition = builder.currentOffset

            when {
                builder.tokenText == "if" -> {
                    parseTemplateIf(builder)
                }

                builder.tokenText == "for" -> {
                    parseTemplateFor(builder)
                }

                builder.tokenText == "while" -> {
                    parseTemplateWhile(builder)
                }

                builder.tokenText == "match" -> {
                    parseTemplateMatch(builder)
                }

                else -> {
                    // 解析插值表达式
                    if (!parseTermExpression(builder, false)) {
                        builder.error("Unable to parse template expression")
                        builder.advanceLexer()
                    }
                    break
                }
            }

            // 防止无限循环：确保解析器前进
            if (builder.currentOffset == initialPosition) {
                builder.error("Unable to parse template content")
                builder.advanceLexer()
            }
        }
        return true
    }

    /**
     * 解析模板条件语句 <$ if ... $>
     */
    private fun parseTemplateIf(builder: PsiBuilder): Boolean {
        if (builder.tokenText != "if") return false
        val marker = builder.mark()

        // 消费 'if'
        if (!parseIdentifier(builder)) {
            builder.error("Expected 'if' keyword")
        }

        // 解析条件表达式
        parseTermExpression(builder, false)

        // 解析 then 部分（这里简化处理）
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END && builder.tokenText != "else" && builder.tokenText != "end") {
            parseStatement(builder)
        }

        // 处理 else 分支
        if (builder.tokenText == "else") {
            if (!parseIdentifier(builder)) {
                builder.error("Expected 'else' keyword")
            }
            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END && builder.tokenText != "end") {
                parseStatement(builder)
            }
        }

        // 消费 'end'
        if (builder.tokenText == "end") {
            if (!parseIdentifier(builder)) {
                builder.error("Expected 'end' keyword")
            }
            // 可选的 'if'
            if (builder.tokenText == "if") {
                if (!parseIdentifier(builder)) {
                    builder.error("Expected 'if' keyword")
                }
            }
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_IF)
        return true
    }

    /**
     * 解析模板循环语句 <$ for ... $>
     */
    private fun parseTemplateFor(builder: PsiBuilder): Boolean {
        if (builder.tokenText != "for") return false
        val marker = builder.mark()

        // 消费 'for'
        if (!parseIdentifier(builder)) {
            builder.error("Expected 'for' keyword")
        }

        // 解析循环变量
        if (!parseIdentifier(builder)) {
            builder.error("Expected loop variable")
        }

        // 消费 'in'
        if (builder.tokenType == ValkyrieTokenTypes.IN) {
            builder.advanceLexer()
        }

        // 解析可迭代表达式
        parseTermExpression(builder, false)

        // 解析循环体
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END && builder.tokenText != "end") {
            parseStatement(builder)
        }

        // 消费 'end'
        if (builder.tokenText == "end") {
            if (!parseIdentifier(builder)) {
                builder.error("Expected 'end' keyword")
            }
            // 可选的 'for'
            if (builder.tokenText == "for") {
                if (!parseIdentifier(builder)) {
                    builder.error("Expected 'for' keyword")
                }
            }
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_FOR)
        return true
    }

    /**
     * 解析模板 while 循环 <$ while ... $>
     */
    private fun parseTemplateWhile(builder: PsiBuilder): Boolean {
        if (builder.tokenText != "while") return false
        val marker = builder.mark()

        marker.done(ValkyrieElementTypes.TEMPLATE_WHILE)
        return true
    }

    /**
     * 解析模板匹配语句 <$ match ... $>
     */
    private fun parseTemplateMatch(builder: PsiBuilder): Boolean {
        if (builder.tokenText != "match") return false
        val marker = builder.mark()


        marker.done(ValkyrieElementTypes.TEMPLATE_MATCH)
        return true
    }

    private fun parseForStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.LOOP) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'for'


        marker.done(ValkyrieElementTypes.FOR_STATEMENT)
        return true
    }

    private fun parseLoopStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.LOOP) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'loop'

        // 解析循环体 - 必须是块语句
        if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
            parseFnBody(builder)
        } else {
            builder.error("Expected '{' after 'loop'")
        }

        marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
        return true
    }

    private fun parseResumeStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.RESUME) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'resume'

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON && builder.tokenType != ValkyrieTokenTypes.NEWLINE && !builder.eof()) {
            parseTermExpression(builder, false)
        }

        marker.done(ValkyrieElementTypes.RESUME_STATEMENT)
        return true
    }


    private fun parseInheritanceList(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_L) {
            builder.advanceLexer() // consume '('

            // 解析继承列表，允许空继承 class A() {}
            while (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R && !builder.eof()) {
                if (!parseInheritanceItem(builder)) {
                    marker.error("Expected inheritance item")
                    recoverToSyncPoint(builder)
                    return false
                }

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESES_R) {
                    marker.error("Expected ',' or ')'")
                    recoverToSyncPoint(builder)
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_R) {
                builder.advanceLexer() // consume ')'
                marker.done(ValkyrieElementTypes.INHERIT_LIST)
                return true
            } else {
                marker.error("Expected ')'")
                return false
            }
        } else {
            marker.drop()
            return false
        }
    }

    private fun parseInheritanceItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // Parse annotations and modifiers
        parseAnnotations(builder, withModifiers = true)

        // Parse type expression (支持 namepath 如 package::inheritors::A)
        if (!parseTypeExpression(builder, false)) {
            marker.error("Expected type expression")
            return false
        }

        // Parse optional type hint
        parseTypeHint(builder)

        // Parse optional default value
        parseDefaultValue(builder)

        marker.done(ValkyrieElementTypes.INHERIT_ITEM)
        return true
    }


    /**
     * Annotation = Attributions + Modifiers
     * */
    private fun parseAnnotations(builder: PsiBuilder, withModifiers: Boolean): Boolean {
        var hasAnnotations = false
        val annotationMarker = builder.mark()
        // 解析若干个 attribute node ↯attr 和 attribute list ↯[attr] 混合
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            hasAnnotations = true
            // 解析 attribute list
            if (builder.lookAhead(1) == ValkyrieTokenTypes.ARRAY_L) {
                // ↯[attr1, attr2, ...]
                val listMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯
                builder.advanceLexer() // 消费 [

                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
                    val attrMarker = builder.mark()
                    if (!parseIdentifier(builder)) {
                        attrMarker.error("Expected attribute name")
                        recoverToSyncPoint(builder)
                        break
                    } else {
                        // 可选的参数列表
                        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_L) {
                            parseAttributeNode(builder, true)
                        }
                        attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.ARRAY_R) {
                        break
                    }
                }

                if (builder.tokenType == ValkyrieTokenTypes.ARRAY_R) {
                    builder.advanceLexer()
                    listMarker.done(ValkyrieElementTypes.ATTRIBUTE_LIST)
                } else {
                    listMarker.error("Expected ']'")
                }
            }
            // 解析单个 attribute node
            else {
                // ↯attr
                val attrMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯

                if (!parseIdentifier(builder)) {
                    attrMarker.error("Expected attribute name")
                    recoverToSyncPoint(builder)
                    break
                } else {
                    // 可选的参数列表
                    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESES_L) {
                        parseAttributeNode(builder, false)
                    }
                    attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                }
            }
        }

        // 如果 withModifiers 为 true，解析结尾的 mod ids
        var hasModifiers = false
        if (withModifiers) {
            hasModifiers = parseModifierList(builder)
        }

        // 只有在有注解或修饰符时才创建节点
        if (hasAnnotations || hasModifiers) {
            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        } else {
            annotationMarker.drop()
        }
        return true
    }

    // attribute() {}
    private fun parseAttributeNode(builder: PsiBuilder, allowBody: Boolean) {
        parseIdentifier(builder)
        parseTermArgumentList(builder)
        if (allowBody) {
            parseObjectBody(builder)
        }
    }

    private fun parseModifierList(builder: PsiBuilder): Boolean {
        var hasModifiers = false
        // 吃掉所有的 identifier
        while (isIdentifier(builder)) {
            when (builder.lookAhead(1)) {
                ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.IDENTIFIER_STD,
                ValkyrieTokenTypes.MICRO, ValkyrieTokenTypes.MEZZO, ValkyrieTokenTypes.MACRO,
                ValkyrieTokenTypes.CLASS, ValkyrieTokenTypes.STRUCTURE, ValkyrieTokenTypes.SINGLETON,
                ValkyrieTokenTypes.UNION, ValkyrieTokenTypes.UNITY,
                ValkyrieTokenTypes.FLAGS, ValkyrieTokenTypes.EIDOS,
                ValkyrieTokenTypes.TESTS -> {
                    val modMarker = builder.mark()
                    builder.advanceLexer()
                    modMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
                    hasModifiers = true
                }

                else -> break
            }
        }
        return hasModifiers
    }

    private fun parseNamePath(builder: PsiBuilder, free: Boolean): Boolean {
        val pathMarker = builder.mark()

        // 解析第一个标识符 - 使用 isIdentifier 优化性能
        val identifierMarker = builder.mark()
        if (isIdentifier(builder)) {
            builder.advanceLexer()
            identifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        } else {
            identifierMarker.error("expected namepath")
            pathMarker.drop()
            return false
        }

        // 解析路径分隔符和后续标识符, free 模式下允许 a.b.c, 否则必须 a::b::c;
        while (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON || (free && builder.tokenType == ValkyrieTokenTypes.DOT)) {
            builder.advanceLexer() // 消费分隔符

            val nextIdentifierMarker = builder.mark()
            if (isIdentifier(builder)) {
                builder.advanceLexer()
                nextIdentifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
            } else {
                nextIdentifierMarker.error("expected identifier after path separator")
                pathMarker.drop()
                return false
            }
        }

        pathMarker.done(ValkyrieElementTypes.NAMESPACE_PATH)
        return true
    }

    private fun parseIdentifier(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (isIdentifier(builder)) {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
            return true
        } else {
            marker.drop()
            return false
        }
    }

    inline fun isIdentifier(builder: PsiBuilder): Boolean {
        return builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW
    }

    private fun parseScopeStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.SCOPE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'scope'

        // Parse optional generic parameters: scope::<T>
        if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
            builder.advanceLexer() // consume '::'
            if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                parseGenericParameterList(builder)
            }
        }

        // Parse the block body
        if (!parseFnBody(builder)) {
            marker.error("Expected block after 'scope'")
            return false
        }

        marker.done(ValkyrieElementTypes.SCOPE_STATEMENT)
        return true
    }
}

// 错误恢复同步点
private val syncTokens = setOf(
    ValkyrieTokenTypes.LET,
    ValkyrieTokenTypes.CLASS,
    ValkyrieTokenTypes.UNION,
    ValkyrieTokenTypes.TRAIT,
    ValkyrieTokenTypes.IMPLY,
    ValkyrieTokenTypes.MICRO,
    ValkyrieTokenTypes.NAMESPACE,
    ValkyrieTokenTypes.USING,
    ValkyrieTokenTypes.SEMICOLON,
    ValkyrieTokenTypes.BRACE_R
)


// 性能优化：缓存操作符优先级
private val operatorPrecedenceCache = mapOf(
    ValkyrieTokenTypes.LOGIC_OR to 1,
    ValkyrieTokenTypes.LOGIC_NOR to 1,
    ValkyrieTokenTypes.LOGIC_XOR to 1,
    ValkyrieTokenTypes.LOGIC_AND to 2,
    ValkyrieTokenTypes.LOGIC_NAND to 2,
    ValkyrieTokenTypes.LOGIC_XAND to 2,
    ValkyrieTokenTypes.PIPE to 3,
    ValkyrieTokenTypes.AMPERSAND to 4,
    ValkyrieTokenTypes.AS to 4,  // 类型转换
    ValkyrieTokenTypes.EQUAL to 5,
    ValkyrieTokenTypes.NOT_EQUAL to 5,
    ValkyrieTokenTypes.IN to 5,
    ValkyrieTokenTypes.NOT_IN to 5,
    ValkyrieTokenTypes.IS to 5,
    ValkyrieTokenTypes.IS_NOT to 5,
    ValkyrieTokenTypes.ANGLE_L to 6,
    ValkyrieTokenTypes.ANGLE_R to 6,
    ValkyrieTokenTypes.LESS_EQUAL to 6,
    ValkyrieTokenTypes.GREATER_EQUAL to 6,
    ValkyrieTokenTypes.PLUS to 7,
    ValkyrieTokenTypes.MINUS to 7,
    ValkyrieTokenTypes.STAR to 8,
    ValkyrieTokenTypes.MULTIPLY to 8,
    ValkyrieTokenTypes.SLASH to 8,
    ValkyrieTokenTypes.INTEGER_DIVIDE to 8,
    ValkyrieTokenTypes.PERCENT to 8,
    ValkyrieTokenTypes.POWER to 9
)

// Error recovery methods
private fun recoverToNextStatement(builder: PsiBuilder) {
    // Skip tokens until we find a statement boundary
    while (!builder.eof() && !isStatementBoundary(builder.tokenType)) {
        builder.advanceLexer()
    }
}

private fun recoverToToken(builder: PsiBuilder, targetToken: IElementType): Boolean {
    var depth = 0
    val maxLookahead = 10 // Limit lookahead to avoid infinite loops
    var count = 0

    while (!builder.eof() && count < maxLookahead) {
        val currentToken = builder.tokenType

        if (currentToken == targetToken && depth == 0) {
            return true
        }

        // Track nesting depth for balanced tokens
        when (currentToken) {
            ValkyrieTokenTypes.PARENTHESES_L, ValkyrieTokenTypes.BRACE_L, ValkyrieTokenTypes.ARRAY_L -> depth++
            ValkyrieTokenTypes.PARENTHESES_R, ValkyrieTokenTypes.BRACE_R, ValkyrieTokenTypes.ARRAY_R -> depth--
        }

        // Stop at statement boundaries if we're not nested
        if (depth == 0 && isStatementBoundary(currentToken)) {
            break
        }

        builder.advanceLexer()
        count++
    }

    return false
}

private fun isStatementBoundary(tokenType: IElementType?): Boolean {
    return when (tokenType) {
        ValkyrieTokenTypes.SEMICOLON,
        ValkyrieTokenTypes.NEWLINE,
        ValkyrieTokenTypes.CLASS,
        ValkyrieTokenTypes.MICRO,
        ValkyrieTokenTypes.LET,
        ValkyrieTokenTypes.IF,
        ValkyrieTokenTypes.LOOP,
        ValkyrieTokenTypes.WHILE,
        ValkyrieTokenTypes.RETURN,
        ValkyrieTokenTypes.BRACE_R,
        null -> true

        else -> false
    }
}
