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

    // 错误恢复同步点
    private val syncTokens = setOf(
        ValkyrieTokenTypes.LET,
        ValkyrieTokenTypes.CLASS,
        ValkyrieTokenTypes.UNION,
        ValkyrieTokenTypes.TRAIT,
        ValkyrieTokenTypes.IMPLY,
        ValkyrieTokenTypes.MICRO,
        ValkyrieTokenTypes.NAMESPACE,
        ValkyrieTokenTypes.NAMESPACE_MAIN,
        ValkyrieTokenTypes.NAMESPACE_TEST,
        ValkyrieTokenTypes.NAMESPACE_HIDE,
        ValkyrieTokenTypes.USING,
        ValkyrieTokenTypes.SEMICOLON,
        ValkyrieTokenTypes.RBRACE
    )

    // 性能监控
    private var parseStartTime: Long = 0
    private var statementCount: Int = 0
    private val performanceThreshold = 1000 // 毫秒

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        parseStartTime = System.currentTimeMillis()
        statementCount = 0

        // marker 不平衡问题已修复，调试模式已关闭
        val rootMarker = builder.mark()

        // 性能优化：预分配错误计数器
        var consecutiveErrors = 0
        val maxConsecutiveErrors = 10

        while (!builder.eof()) {
            val initialPosition = builder.currentOffset
            val statementStartTime = System.currentTimeMillis()

            try {
                parseStatement(builder)
                consecutiveErrors = 0 // 重置错误计数
                statementCount++

                // 性能监控：检查单个语句解析时间
                val statementTime = System.currentTimeMillis() - statementStartTime
                if (statementTime > 100) { // 单个语句超过100ms
                    // 可以在这里记录慢解析的语句
                }

            } catch (e: Exception) {
                consecutiveErrors++

                // 错误恢复：如果连续错误过多，跳到同步点
                if (consecutiveErrors >= maxConsecutiveErrors) {
                    recoverToSyncPoint(builder)
                    consecutiveErrors = 0
                }

                // 确保解析器前进，避免死循环
                if (builder.currentOffset == initialPosition) {
                    builder.advanceLexer()
                }
            }

            // 性能监控：检查总解析时间
            val totalTime = System.currentTimeMillis() - parseStartTime
            if (totalTime > performanceThreshold) {
                // 解析时间过长，可能需要优化
                break
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
        // 性能优化：快速跳过空白和注释
        while (builder.tokenType in setOf(
                ValkyrieTokenTypes.WHITESPACE,
                ValkyrieTokenTypes.NEWLINE,
                ValkyrieTokenTypes.COMMENT_REST,
                ValkyrieTokenTypes.COMMENT_RANGE
            )
        ) {
            builder.advanceLexer()
        }

        if (builder.eof()) return

        val initialOffset = builder.currentOffset

        // 首先检查是否有attributes
        val hasAttributes = builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER

        if (hasAttributes) {
            parseAttributeList(builder)
        }

        try {
            when (builder.tokenType) {
                ValkyrieTokenTypes.LET -> parseLetStatement(builder)
                ValkyrieTokenTypes.CLASS -> parseClassStatement(builder)
                ValkyrieTokenTypes.NEURAL -> parseNeuralStatement(builder)
                ValkyrieTokenTypes.WIDGET -> parseWidgetStatement(builder)
                ValkyrieTokenTypes.SINGLETON -> parseSingletonStatement(builder)
                ValkyrieTokenTypes.UNION -> parseUnionStatement(builder)
                ValkyrieTokenTypes.UNITY -> parseUnityStatement(builder)
                ValkyrieTokenTypes.FLAGS -> parseFlagsStatement(builder)
                ValkyrieTokenTypes.TRAIT -> parseTraitStatement(builder)
                ValkyrieTokenTypes.IMPLY -> parseImplyStatement(builder)
                ValkyrieTokenTypes.STRUCTURE -> parseStructureStatement(builder)
                ValkyrieTokenTypes.MICRO -> parseFunctionStatement(builder)
                ValkyrieTokenTypes.MICRO -> parseTimeLevelStatement(builder, "micro")
                ValkyrieTokenTypes.MEZZO -> parseTimeLevelStatement(builder, "mezzo")
                ValkyrieTokenTypes.MACRO -> parseTimeLevelStatement(builder, "macro")
                ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START -> parseCompileTimeBlock(builder)
                ValkyrieTokenTypes.TEMPLATE_START -> parseTemplateBlock(builder)
                ValkyrieTokenTypes.NAMESPACE,
                ValkyrieTokenTypes.NAMESPACE_MAIN,
                ValkyrieTokenTypes.NAMESPACE_TEST,
                ValkyrieTokenTypes.NAMESPACE_HIDE -> parseNamespaceStatement(builder)

                ValkyrieTokenTypes.USING -> parseUsingStatement(builder)
                ValkyrieTokenTypes.UNTIL -> parseUntilStatement(builder)
                ValkyrieTokenTypes.FOR -> parseForStatement(builder)
                ValkyrieTokenTypes.WHILE -> parseWhileStatement(builder)
                ValkyrieTokenTypes.MATCH -> parseMatchStatement(builder)
                ValkyrieTokenTypes.IF -> parseIfStatement(builder)
                ValkyrieTokenTypes.TRY -> parseTryStatement(builder)
                ValkyrieTokenTypes.CATCH -> parseCatchStatement(builder)
                ValkyrieTokenTypes.RETURN -> parseReturnStatement(builder)
                ValkyrieTokenTypes.BREAK -> parseBreakStatement(builder)
                ValkyrieTokenTypes.CONTINUE -> parseContinueStatement(builder)
                ValkyrieTokenTypes.YIELD -> parseYieldStatement(builder)
                ValkyrieTokenTypes.RAISE -> parseRaiseStatement(builder)
                ValkyrieTokenTypes.RESUME -> parseResumeStatement(builder)
                ValkyrieTokenTypes.LOOP -> parseLoopStatement(builder)
                ValkyrieTokenTypes.LBRACE -> parseBlockStatement(builder)
                ValkyrieTokenTypes.COMMENT_DOCUMENT -> parseDocComment(builder)
                ValkyrieTokenTypes.AT -> parseMacroCall(builder)
                ValkyrieTokenTypes.LABEL_MARK -> parseLabelStatement(builder)
                null -> return
                else -> parseExpressionStatement(builder)
            }
        } catch (e: Exception) {
            // 错误恢复：确保解析器前进
            if (builder.currentOffset == initialOffset) {
                builder.error("Unexpected token: ${builder.tokenType}")
                builder.advanceLexer()
            }
        }
    }

    private fun parseLetStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'let' keyword
        if (builder.tokenType == ValkyrieTokenTypes.LET) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // pattern - 支持标识符和元组模式（包括 raw identifier）
        when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.IDENTIFIER_RAW -> {
                val patternMarker = builder.mark()
                builder.advanceLexer()
                patternMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
            }

            ValkyrieTokenTypes.LPAREN -> {
                // 解析元组模式 (a, b)
                parseTuplePattern(builder)
            }

            else -> {
                builder.error("Expected identifier or pattern")
                builder.advanceLexer() // 推进词法分析器避免死循环
            }
        }

        // optional type annotation
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer()
            parseTypeReference(builder)
        }

        // '=' assignment
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '='")
            builder.advanceLexer() // 推进词法分析器避免死循环
        }

        // expression
        parseExpression(builder)

        // optional semicolon
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.LET_STATEMENT)
    }

    private fun parseBlockStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            parseStatement(builder)
        }

        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.BLOCK_BODY)
    }

    private fun parseExpressionStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        parseExpression(builder)

        // 检查是否是赋值语句
        when (builder.tokenType) {
            ValkyrieTokenTypes.ASSIGN,
            ValkyrieTokenTypes.PLUS_ASSIGN,
            ValkyrieTokenTypes.MINUS_ASSIGN,
            ValkyrieTokenTypes.MULTIPLY_ASSIGN,
            ValkyrieTokenTypes.DIVIDE_ASSIGN,
            ValkyrieTokenTypes.MODULO_ASSIGN,
            ValkyrieTokenTypes.POWER_ASSIGN -> {
                builder.advanceLexer() // consume assignment operator
                parseExpression(builder) // parse right-hand side

                // optional semicolon
                if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
                    builder.advanceLexer()
                }

                marker.done(ValkyrieElementTypes.ASSIGN_STATEMENT)
                return
            }
        }

        // optional semicolon
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.EXPRESSION_STATEMENT)
    }

    private fun parseExpression(builder: PsiBuilder) {
        parseBinaryExpression(builder, 0)
    }

    private fun parseBinaryExpression(builder: PsiBuilder, minPrec: Int) {
        var left = parsePostfixExpression(builder)

        while (!builder.eof() && left != null) {
            val op = builder.tokenType
            val prec = getOperatorPrecedence(op)

            if (prec < minPrec) break

            val marker = left.precede()
            builder.advanceLexer() // consume operator

            if (op == ValkyrieTokenTypes.AS) {
                // AS操作符右侧是类型表达式
                parseTypeReference(builder)
                marker.done(ValkyrieElementTypes.AS_EXPRESSION)
            } else if (op == ValkyrieTokenTypes.IS || op == ValkyrieTokenTypes.IS_NOT) {
                // IS操作符右侧是模式表达式
                parsePattern(builder)
                marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            } else {
                parseBinaryExpression(builder, prec + 1)
                marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            }
            left = marker
        }
    }

    private fun parsePostfixExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        var left = parsePrimaryExpression(builder)

        while (!builder.eof() && left != null) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.DOT -> {
                    // 点调用 a.b
                    val marker = left.precede()
                    builder.advanceLexer() // consume '.'
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        val nameMarker = builder.mark()
                        builder.advanceLexer()
                        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                    } else {
                        builder.error("Expected identifier after '.'")
                    }
                    marker.done(ValkyrieElementTypes.DOT_EXPRESSION)
                    left = marker
                }

                ValkyrieTokenTypes.LPAREN -> {
                    // 普通函数调用 call(args)
                    val marker = left.precede()
                    parseArgumentList(builder)
                    marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    left = marker
                }

                ValkyrieTokenTypes.LBRACE -> {
                    // 尾随闭包 call {}
                    val marker = left.precede()
                    parseBlockStatement(builder)
                    marker.done(ValkyrieElementTypes.TRAILING_CLOSURE_EXPRESSION)
                    left = marker
                }

                ValkyrieTokenTypes.ANGLE_L -> {
                    // 泛型调用 call⟨T⟩(args)
                    val marker = left.precede()
                    parseGenericArguments(builder, ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.ANGLE_R)
                    if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                        parseArgumentList(builder)
                    }
                    marker.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                    left = marker
                }

                ValkyrieTokenTypes.DOUBLE_COLON -> {
                    // 检查是否为 call::<T> 形式
                    if (builder.lookAhead(1) == ValkyrieTokenTypes.LESS) {
                        val marker = left.precede()
                        builder.advanceLexer() // consume '::'
                        parseGenericArguments(builder, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER)
                        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                            parseArgumentList(builder)
                        }
                        marker.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                        left = marker
                    } else {
                        break
                    }
                }

                ValkyrieTokenTypes.WHAT -> {
                    // 错误处理操作符 expr?
                    val marker = left.precede()
                    builder.advanceLexer() // consume '?'
                    marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION)
                    left = marker
                }

                ValkyrieTokenTypes.CELSIUS, ValkyrieTokenTypes.FAHRENHEIT, ValkyrieTokenTypes.PERMILLE, ValkyrieTokenTypes.PERMYRIAD -> {
                    // 后缀运算符 expr℃, expr℉, expr‰, expr‱
                    val marker = left.precede()
                    builder.advanceLexer() // consume postfix operator
                    marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION)
                    left = marker
                }

                else -> break
            }
        }

        return left
    }

    private fun parseArgumentList(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer() // consume '('

            // 性能优化：预检查空参数列表
            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                builder.advanceLexer() // consume ')'
                return
            }

            var argumentCount = 0
            val maxArguments = 100 // 防止过多参数导致性能问题

            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                if (argumentCount >= maxArguments) {
                    builder.error("Too many arguments (maximum $maxArguments)")
                    break
                }

                val beforeExpr = builder.currentOffset
                parseExpression(builder)

                // 确保表达式解析有进展
                if (builder.currentOffset == beforeExpr) {
                    builder.error("Invalid expression")
                    builder.advanceLexer() // 强制前进避免死循环
                }

                argumentCount++

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    builder.error("Expected ',' or ')'")
                    // 错误恢复：跳到下一个逗号或右括号
                    while (!builder.eof() &&
                        builder.tokenType != ValkyrieTokenTypes.COMMA &&
                        builder.tokenType != ValkyrieTokenTypes.RPAREN
                    ) {
                        builder.advanceLexer()
                    }
                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    }
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                builder.advanceLexer() // consume ')'
            } else {
                builder.error("Expected ')'")
            }
        }
    }

    private fun parseGenericArguments(builder: PsiBuilder, startToken: IElementType, endToken: IElementType) {
        if (builder.tokenType == startToken) {
            builder.advanceLexer() // consume start token

            // 性能优化：预检查空泛型参数列表
            if (builder.tokenType == endToken) {
                builder.advanceLexer() // consume end token
                return
            }

            var typeCount = 0
            val maxTypes = 50 // 防止过多泛型参数导致性能问题

            while (!builder.eof() && builder.tokenType != endToken) {
                if (typeCount >= maxTypes) {
                    builder.error("Too many generic arguments (maximum $maxTypes)")
                    break
                }

                val beforeType = builder.currentOffset

                // 支持泛型参数中的字面量（数字和字符串）、命名参数语法和tuple
                when (builder.tokenType) {
                    ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.UNIT_NUMBER -> {
                        builder.advanceLexer() // 消费数字字面量
                    }

                    ValkyrieTokenTypes.STRING -> {
                        builder.advanceLexer() // 消费字符串字面量
                    }

                    ValkyrieTokenTypes.LPAREN -> {
                        // 解析tuple语法 (1, 2, 3)
                        val tupleMarker = builder.mark()
                        builder.advanceLexer() // consume '('

                        // 解析tuple元素
                        if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                            // 解析第一个元素
                            when (builder.tokenType) {
                                ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.UNIT_NUMBER -> {
                                    builder.advanceLexer()
                                }

                                else -> parseTypeReference(builder)
                            }

                            // 解析后续元素
                            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                                builder.advanceLexer() // consume ','
                                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) break // 允许尾随逗号

                                when (builder.tokenType) {
                                    ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.UNIT_NUMBER -> {
                                        builder.advanceLexer()
                                    }

                                    else -> parseTypeReference(builder)
                                }
                            }
                        }

                        if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                            builder.advanceLexer() // consume ')'
                        } else {
                            builder.error("Expected ')'")
                        }
                        tupleMarker.done(ValkyrieElementTypes.TUPLE_EXPRESSION)
                    }

                    ValkyrieTokenTypes.IDENTIFIER_STD -> {
                        // 检查是否是命名参数语法 (如 Item: AnyNode)
                        val nextToken = builder.lookAhead(1)
                        if (nextToken == ValkyrieTokenTypes.COLON) {
                            builder.advanceLexer() // consume identifier
                            builder.advanceLexer() // consume ':'
                            parseTypeReference(builder) // parse the type after colon
                        } else {
                            parseTypeReference(builder)
                        }
                    }

                    else -> {
                        parseTypeReference(builder)
                    }
                }

                // 确保类型解析有进展
                if (builder.currentOffset == beforeType) {
                    builder.error("Invalid type reference or literal")
                    builder.advanceLexer() // 强制前进避免死循环
                }

                typeCount++

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != endToken) {
                    builder.error("Expected ',' or end token")
                    // 错误恢复：跳到下一个逗号或结束token
                    while (!builder.eof() &&
                        builder.tokenType != ValkyrieTokenTypes.COMMA &&
                        builder.tokenType != endToken
                    ) {
                        builder.advanceLexer()
                    }
                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    }
                }
            }

            if (builder.tokenType == endToken) {
                builder.advanceLexer() // consume end token
            } else {
                builder.error("Expected end token")
            }
        }
    }

    private fun parseIdentifier(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()
        } else {
            builder.error("Expected identifier")
        }
    }

    private fun parseSpecialIdentifier(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
            builder.advanceLexer() // consume '`'

            // 解析特殊名称内容（可能包含空格等特殊字符）
            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BACKTICK) {
                builder.advanceLexer()
            }

            if (builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
                builder.advanceLexer() // consume closing '`'
            } else {
                builder.error("Expected closing backtick")
            }
        } else {
            builder.error("Expected backtick")
        }
    }

    private fun parsePrimaryExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        return when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD -> {
                val marker = builder.mark()
                parseQualifiedName(builder)
                marker.done(ValkyrieElementTypes.QUALIFIED_NAME)
                marker
            }

            ValkyrieTokenTypes.BACKTICK -> {
                val marker = builder.mark()
                parseSpecialIdentifier(builder)
                marker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                marker
            }

            ValkyrieTokenTypes.INTERNATIONAL_MARK -> {
                val marker = builder.mark()
                parseQualifiedName(builder)
                marker.done(ValkyrieElementTypes.QUALIFIED_NAME)
                marker
            }

            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.UNIT_NUMBER, ValkyrieTokenTypes.STRING, ValkyrieTokenTypes.BOOLEAN -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.LITERAL_EXPRESSION)
                marker
            }

            ValkyrieTokenTypes.LPAREN -> {
                val marker = builder.mark()
                builder.advanceLexer() // consume '('

                // 检查是否为空元组
                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    builder.advanceLexer() // consume ')'
                    marker.done(ValkyrieElementTypes.TUPLE_EXPRESSION)
                    return marker
                }

                // 解析第一个元素
                parseExpression(builder)

                // 检查是否为named tuple或普通元组
                if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                    // Named tuple: (name: value, ...)
                    builder.advanceLexer() // consume ':'
                    parseExpression(builder) // parse value

                    // 解析后续元素
                    while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer() // consume ','

                        // 允许尾随逗号
                        if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                            break
                        }

                        parseExpression(builder) // parse name
                        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                            builder.advanceLexer() // consume ':'
                            parseExpression(builder) // parse value
                        }
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        builder.advanceLexer() // consume ')'
                    } else {
                        builder.error("Expected ')'")
                    }
                    marker.done(ValkyrieElementTypes.NAMED_TUPLE_EXPRESSION)
                    marker
                } else if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    // 普通元组: (a, b, c)
                    while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer() // consume ','

                        // 允许尾随逗号
                        if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                            break
                        }

                        parseExpression(builder)
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        builder.advanceLexer() // consume ')'
                    } else {
                        builder.error("Expected ')'")
                    }
                    marker.done(ValkyrieElementTypes.TUPLE_EXPRESSION)
                    marker
                } else {
                    // 括号表达式: (expression)
                    if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        builder.advanceLexer() // consume ')'
                    } else {
                        builder.error("Expected ')'")
                    }
                    marker.done(ValkyrieElementTypes.PARENTHESIZED_EXPRESSION)
                    marker
                }
            }

            ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.RECIPROCAL, ValkyrieTokenTypes.WOW -> {
                val marker = builder.mark()
                builder.advanceLexer() // consume operator
                parsePrimaryExpression(builder)
                marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
                marker
            }

            ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START -> {
                val marker = builder.mark()
                parseCompileTimeBlock(builder)
                marker.done(ValkyrieElementTypes.COMPILE_TIME_BLOCK)
                marker
            }

            ValkyrieTokenTypes.TEMPLATE_START -> {
                val marker = builder.mark()
                parseTemplateBlock(builder)
                marker.done(ValkyrieElementTypes.TEMPLATE_BLOCK)
                marker
            }

            ValkyrieTokenTypes.LBRACKET -> {
                // 数组字面量 [1, 2, 3]
                val marker = builder.mark()
                builder.advanceLexer() // consume '['

                // 检查是否为空数组
                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer() // consume ']'
                    marker.done(ValkyrieElementTypes.ARRAY_EXPRESSION)
                    return marker
                }

                // 解析数组元素
                parseExpression(builder)

                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','

                    // 允许尾随逗号
                    if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                        break
                    }

                    parseExpression(builder)
                }

                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer() // consume ']'
                } else {
                    builder.error("Expected ']'")
                }

                marker.done(ValkyrieElementTypes.ARRAY_EXPRESSION)
                marker
            }

            else -> {
                builder.error("Expected expression")
                builder.advanceLexer() // 推进词法分析器避免死循环
                null
            }
        }
    }

    private fun parseTypeReference(builder: PsiBuilder) {
        parseIntersectionType(builder)
    }

    private fun parseIntersectionType(builder: PsiBuilder) {
        val marker = builder.mark()

        // 支持开头的可选 & 符号（&A&B 语法，第一个&无意义）
        var hasIntersection = false
        if (builder.tokenType == ValkyrieTokenTypes.AMPERSAND) {
            hasIntersection = true
            builder.advanceLexer() // consume leading '&'
        }

        // 解析第一个类型（可能是联合类型）
        parseUnionType(builder)

        // 检查是否有交集类型操作符 & 或 + (用于接口实现)
        while (builder.tokenType == ValkyrieTokenTypes.AMPERSAND || builder.tokenType == ValkyrieTokenTypes.PLUS) {
            hasIntersection = true
            builder.advanceLexer() // consume '&' or '+'
            parseUnionType(builder)
        }

        if (hasIntersection) {
            marker.done(ValkyrieElementTypes.INTERSECTION_TYPE)
        } else {
            marker.drop()
        }
    }

    private fun parseUnionType(builder: PsiBuilder) {
        val marker = builder.mark()

        // 支持开头的可选 | 符号（|A|B 语法，第一个|无意义）
        var hasUnion = false
        if (builder.tokenType == ValkyrieTokenTypes.PIPE) {
            hasUnion = true
            builder.advanceLexer() // consume leading '|'
        }

        // 解析第一个类型（可能是函数类型）
        parseFunctionType(builder)

        // 检查是否有联合类型操作符 |
        while (builder.tokenType == ValkyrieTokenTypes.PIPE) {
            hasUnion = true
            builder.advanceLexer() // consume '|'
            parseFunctionType(builder)
        }

        if (hasUnion) {
            marker.done(ValkyrieElementTypes.UNION_TYPE)
        } else {
            marker.drop()
        }
    }

    private fun parseFunctionType(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析第一个类型
        parseBasicType(builder)

        // 检查是否有函数类型操作符 -> 或 =>
        if (builder.tokenType == ValkyrieTokenTypes.ARROW || builder.tokenType == ValkyrieTokenTypes.DOUBLE_ARROW) {
            builder.advanceLexer() // consume '->' or '=>'
            parseFunctionType(builder) // 递归解析右侧类型，支持链式函数类型
            marker.done(ValkyrieElementTypes.FUNCTION_TYPE)
        } else {
            marker.drop()
        }
    }

    private fun parseBasicType(builder: PsiBuilder) {
        val marker = builder.mark()

        when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.IDENTIFIER_RAW, ValkyrieTokenTypes.INTERNATIONAL_MARK -> {
                // 使用parseQualifiedName来处理命名空间路径
                parseQualifiedName(builder)

                // 支持泛型参数 - 同时支持 <T> 和 ⟨T⟩ 语法
                while (builder.tokenType == ValkyrieTokenTypes.LESS || builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                    if (builder.tokenType == ValkyrieTokenTypes.LESS) {
                        parseGenericArguments(builder, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER)
                    } else {
                        parseGenericArguments(builder, ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.ANGLE_R)
                    }
                }
            }

            ValkyrieTokenTypes.LPAREN -> {
                // 支持元组类型 (A, B, C)
                builder.advanceLexer() // consume '('
                if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    parseTypeReference(builder)
                    while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer() // consume ','
                        parseTypeReference(builder)
                    }
                }
                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    builder.advanceLexer() // consume ')'
                } else {
                    builder.error("Expected ')'")
                }
            }

            ValkyrieTokenTypes.LBRACKET -> {
                // 支持数组类型 [T]
                builder.advanceLexer() // consume '['
                parseTypeReference(builder)
                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer() // consume ']'
                } else {
                    builder.error("Expected ']'")
                }
            }

            else -> {
                builder.error("Expected type name")
                builder.advanceLexer() // 推进词法分析器避免死循环
            }
        }

        // 支持effect标注语法 Type / Effect⟨T⟩
        if (builder.tokenType == ValkyrieTokenTypes.DIVIDE) {
            builder.advanceLexer() // consume '/'

            // 解析effect类型
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume effect name

                // 支持effect泛型参数 ⟨T⟩ 或 <T>
                if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                    parseGenericArguments(builder, ValkyrieTokenTypes.ANGLE_L, ValkyrieTokenTypes.ANGLE_R)
                } else if (builder.tokenType == ValkyrieTokenTypes.LESS) {
                    parseGenericArguments(builder, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER)
                }
            } else {
                builder.error("Expected effect name after '/'")
            }
        }

        // 支持可选类型语法 Type?
        if (builder.tokenType == ValkyrieTokenTypes.WHAT) {
            builder.advanceLexer() // consume '?'
            marker.done(ValkyrieElementTypes.OPTIONAL_TYPE)
        } else {
            marker.done(ValkyrieElementTypes.TYPE_REFERENCE)
        }
    }

    // 性能优化：缓存操作符优先级
    private val operatorPrecedenceCache = mapOf(
        ValkyrieTokenTypes.LOGIC_OR to 1,
        ValkyrieTokenTypes.LOGIC_NOR to 1,
        ValkyrieTokenTypes.LOGIC_XOR to 1,
        ValkyrieTokenTypes.LOGIC_AND to 2,
        ValkyrieTokenTypes.LOGIC_NAND to 2,
        ValkyrieTokenTypes.LOGIC_XAND to 2,
        ValkyrieTokenTypes.PIPE to 3,  // 位运算 OR
        ValkyrieTokenTypes.AMPERSAND to 4,  // 位运算 AND
        ValkyrieTokenTypes.AS to 4,  // 类型转换
        ValkyrieTokenTypes.EQUAL to 5,
        ValkyrieTokenTypes.NOT_EQUAL to 5,
        ValkyrieTokenTypes.IN to 5,
        ValkyrieTokenTypes.NOT_IN to 5,
        ValkyrieTokenTypes.IS to 5,
        ValkyrieTokenTypes.IS_NOT to 5,
        ValkyrieTokenTypes.LESS to 6,
        ValkyrieTokenTypes.GREATER to 6,
        ValkyrieTokenTypes.LESS_EQUAL to 6,
        ValkyrieTokenTypes.GREATER_EQUAL to 6,
        ValkyrieTokenTypes.PLUS to 7,
        ValkyrieTokenTypes.MINUS to 7,
        ValkyrieTokenTypes.STAR to 8,
        ValkyrieTokenTypes.MULTIPLY to 8,
        ValkyrieTokenTypes.DIVIDE to 8,
        ValkyrieTokenTypes.INTEGER_DIVIDE to 8,
        ValkyrieTokenTypes.PERCENT to 8,
        ValkyrieTokenTypes.POWER to 9
    )

    private fun getOperatorPrecedence(tokenType: IElementType?): Int {
        return operatorPrecedenceCache[tokenType] ?: -1
    }

    private fun parseNamespaceStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'namespace' keyword (支持不同类型: namespace, namespace!, namespace?, namespace*)
        when (builder.tokenType) {
            ValkyrieTokenTypes.NAMESPACE,
            ValkyrieTokenTypes.NAMESPACE_MAIN,
            ValkyrieTokenTypes.NAMESPACE_TEST,
            ValkyrieTokenTypes.NAMESPACE_HIDE -> {
                builder.advanceLexer()
            }

            else -> {
                marker.drop()
                return
            }
        }

        // 解析namespace路径，支持多种格式
        parseNamespacePath(builder)

        // 可选的分号或双分号（REPL语法）
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        } else if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.NAMESPACE_STATEMENT)
    }

    private fun parseNamespacePath(builder: PsiBuilder) {
        val pathMarker = builder.mark()

        // 解析第一个标识符
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val identifierMarker = builder.mark()
            builder.advanceLexer()
            identifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // 解析路径分隔符和后续标识符
            while (builder.tokenType == ValkyrieTokenTypes.DOT || builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
                builder.advanceLexer() // 消费分隔符

                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    val nextIdentifierMarker = builder.mark()
                    builder.advanceLexer()
                    nextIdentifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                } else {
                    builder.error("Expected identifier after path separator")
                    pathMarker.drop() // 在错误情况下 drop pathMarker
                    return
                }
            }

            pathMarker.done(ValkyrieElementTypes.NAMESPACE_PATH)

            // 支持逗号分隔的多个namespace路径
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // 消费逗号

                // 解析下一个namespace路径
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    val nextPathMarker = builder.mark()
                    val nextIdentifierMarker = builder.mark()
                    builder.advanceLexer()
                    nextIdentifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

                    // 解析这个路径的分隔符和后续标识符
                    while (builder.tokenType == ValkyrieTokenTypes.DOT || builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
                        builder.advanceLexer() // 消费分隔符

                        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                            val pathIdentifierMarker = builder.mark()
                            builder.advanceLexer()
                            pathIdentifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                        } else {
                            builder.error("Expected identifier after path separator")
                            nextPathMarker.drop() // 在错误情况下 drop nextPathMarker
                            return
                        }
                    }

                    nextPathMarker.done(ValkyrieElementTypes.NAMESPACE_PATH)
                } else {
                    builder.error("Expected identifier after comma")
                    return
                }
            }
        } else {
            builder.error("Expected namespace identifier")
            pathMarker.drop() // 当没有找到标识符时，需要 drop marker
        }
    }

    private fun parseUsingStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'using' keyword
        if (builder.tokenType == ValkyrieTokenTypes.USING) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // qualified name (e.g., file_b.b)
        parseQualifiedName(builder)

        // 支持嵌套using语法: using package.collections.{ hashmap.HashMap }
        if (builder.tokenType == ValkyrieTokenTypes.DOT) {
            builder.advanceLexer() // consume '.'

            if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
                builder.advanceLexer() // consume '{'

                // 解析导入列表
                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                    parseQualifiedName(builder)

                    // 处理逗号分隔
                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                        builder.error("Expected ',' or '}'")
                        break
                    }
                }

                if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
                    builder.advanceLexer() // consume '}'
                } else {
                    builder.error("Expected '}'")
                }
            }
        }

        marker.done(ValkyrieElementTypes.USING_STATEMENT)
    }

    private fun parseQualifiedName(builder: PsiBuilder) {
        val marker = builder.mark()

        // 支持包路径前缀 ⸿
        if (builder.tokenType == ValkyrieTokenTypes.INTERNATIONAL_MARK) {
            builder.advanceLexer() // consume ⸿
        }

        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            builder.advanceLexer()

            // 支持点号和双冒号分隔符
            while (builder.tokenType == ValkyrieTokenTypes.DOT || builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
                val separator = builder.tokenType
                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                    builder.advanceLexer()
                } else {
                    val separatorText = if (separator == ValkyrieTokenTypes.DOT) "." else "::"
                    builder.error("Expected identifier after '$separatorText'")
                    builder.advanceLexer() // 推进词法分析器避免死循环
                    break
                }
            }
        } else {
            builder.error("Expected identifier")
        }

        marker.done(ValkyrieElementTypes.QUALIFIED_NAME)
    }

    private fun parseClassStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'class' keyword
        if (builder.tokenType == ValkyrieTokenTypes.CLASS) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // class name (optional for anonymous classes) - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val nameMarker = builder.mark()
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                builder.advanceLexer() // consume raw identifier
            } else {
                builder.advanceLexer() // consume standard identifier
            }
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        }

        // optional inheritance (class A(B, C) or class A() {})
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseClassInheritance(builder)
        }

        // optional trait constraints (class A: Trait)
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder) // 解析trait约束
        }

        // class body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.CLASS_STATEMENT)
    }

    private fun parseNeuralStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'neural' keyword
        if (builder.tokenType == ValkyrieTokenTypes.NEURAL) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // neural name (optional for anonymous neurals) - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val nameMarker = builder.mark()
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                builder.advanceLexer() // consume raw identifier
            } else {
                builder.advanceLexer() // consume standard identifier
            }
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        }

        // optional inheritance (neural A(B, C) or neural A() {})
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseClassInheritance(builder)
        }

        // optional trait constraints (neural A: Trait)
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder) // 解析trait约束
        }

        // neural body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.NEURAL_STATEMENT)
    }

    private fun parseWidgetStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'widget' keyword
        if (builder.tokenType == ValkyrieTokenTypes.WIDGET) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // widget name (optional for anonymous widgets) - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val nameMarker = builder.mark()
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                builder.advanceLexer() // consume raw identifier
            } else {
                builder.advanceLexer() // consume standard identifier
            }
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        }

        // optional inheritance (widget A(B, C) or widget A() {})
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseClassInheritance(builder)
        }

        // optional trait constraints (widget A: Trait)
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder) // 解析trait约束
        }

        // widget body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.WIDGET_STATEMENT)
    }

    private fun parseSingletonStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'singleton' keyword
        if (builder.tokenType == ValkyrieTokenTypes.SINGLETON) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // singleton name (required) - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val nameMarker = builder.mark()
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                builder.advanceLexer() // consume raw identifier
            } else {
                builder.advanceLexer() // consume standard identifier
            }
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected singleton name")
        }

        // optional inheritance (singleton A(B, C) or singleton A() {})
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseClassInheritance(builder)
        }

        // optional trait constraints (singleton A: Trait)
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder) // 解析trait约束
        }

        // singleton body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.SINGLETON_STATEMENT)
    }

    private fun parseStructureStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'structure' keyword
        if (builder.tokenType == ValkyrieTokenTypes.STRUCTURE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // structure name (required)
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected structure name")
        }

        // structure body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.STRUCTURE_STATEMENT)
    }

    private fun parseOptionalGenericParameters(builder: PsiBuilder) {
        // 支持三种泛型语法: ⟨T⟩, <T>, ::<T>
        val isGeneric = when (builder.tokenType) {
            ValkyrieTokenTypes.ANGLE_L -> true  // ⟨
            ValkyrieTokenTypes.LESS -> true    // <
            ValkyrieTokenTypes.DOUBLE_COLON -> {
                // 检查 :: 后面是否跟 <
                builder.lookAhead(1) == ValkyrieTokenTypes.LESS
            }

            else -> false
        }

        if (isGeneric) {
            val marker = builder.mark()

            // 处理 :: 前缀
            if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
                builder.advanceLexer()
            }

            // 开始符号 (⟨ 或 <)
            val startToken = builder.tokenType
            builder.advanceLexer()

            // 解析泛型参数列表 (支持空泛型列表)
            val expectedEndToken = if (startToken == ValkyrieTokenTypes.ANGLE_L) {
                ValkyrieTokenTypes.ANGLE_R
            } else {
                ValkyrieTokenTypes.GREATER
            }

            // 检查是否为空泛型列表
            if (builder.tokenType != expectedEndToken) {
                // 解析第一个泛型参数
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                    parseGenericParameter(builder)

                    // 处理多个泛型参数
                    while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                        // 支持尾随逗号：如果逗号后面直接是结束符号，则跳出循环
                        if (builder.tokenType == expectedEndToken) {
                            break
                        }
                        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                            parseGenericParameter(builder)
                        } else {
                            builder.error("Expected generic parameter name")
                            break
                        }
                    }
                } else {
                    builder.error("Expected generic parameter name")
                }
            }

            // 结束符号 (⟩ 或 >)
            if (builder.tokenType == expectedEndToken) {
                builder.advanceLexer()
            } else {
                builder.error("Expected closing generic bracket")
            }

            marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
        }
    }

    private fun parseGenericParameter(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析annotation
        while (builder.tokenType == ValkyrieTokenTypes.AT) {
            parseMacroCall(builder)
        }

        // 解析修饰符（如 readonly T）- 支持 raw identifier
        var hasModifier = false
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val currentText = builder.tokenText ?: ""
            if (currentText == "readonly" || currentText == "const" || currentText == "mut") {
                hasModifier = true
                val modifierMarker = builder.mark()
                builder.advanceLexer() // 跳过修饰符关键字
                modifierMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
            }
        }

        // 解析泛型参数名称 - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val identifierMarker = builder.mark()
            builder.advanceLexer()
            identifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // 检查是否有泛型约束 (冒号后跟类型)
            if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                builder.advanceLexer()
                // 解析约束类型，支持多个约束用 + 连接
                parseTypeReference(builder)
                while (builder.tokenType == ValkyrieTokenTypes.PLUS) {
                    builder.advanceLexer()
                    parseTypeReference(builder)
                }
            }

            // 检查是否有默认值 (等号后跟类型表达式)
            if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
                builder.advanceLexer()
                // 解析默认类型表达式
                parseTypeReference(builder)
            }

            marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
        } else {
            builder.error("Expected generic parameter name")
            marker.drop()
        }
    }

    private fun parseUnionStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'union' keyword
        if (builder.tokenType == ValkyrieTokenTypes.UNION) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // union name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected union name")
        }

        // union body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseUnionBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.UNION_STATEMENT)
    }

    private fun parseFlagsStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'flags' keyword
        if (builder.tokenType == ValkyrieTokenTypes.FLAGS) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // flags name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected flags name")
        }

        // flags body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseFlagsBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.FLAGS_STATEMENT)
    }

    private fun parseUnityStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'unity' keyword
        if (builder.tokenType == ValkyrieTokenTypes.UNITY) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // unity name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected unity name")
        }

        // unity body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseUnionBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.UNION_STATEMENT)
    }

    private fun parseTraitStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'trait' keyword
        if (builder.tokenType == ValkyrieTokenTypes.TRAIT) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // trait name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected trait name")
        }

        // 支持trait约束语法 trait Future: Asynchronous
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder) // 解析约束类型表达式
        }

        // 支持类型别名语法 trait C = A + B
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // consume '='
            parseTypeReference(builder) // 解析类型表达式
        } else if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseTraitBody(builder)
        } else {
            builder.error("Expected ':', '=' or '{'")
        }

        marker.done(ValkyrieElementTypes.TRAIT_STATEMENT)
    }

    private fun parseImplyStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'imply' keyword
        if (builder.tokenType == ValkyrieTokenTypes.IMPLY) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // imply name - 支持命名空间路径
        parseQualifiedName(builder)

        // 解析泛型参数 ⟨T⟩
        parseOptionalGenericParameters(builder)

        // 可选的类型表达式 : Type
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder)
        }

        // imply body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected imply body")
        }

        marker.done(ValkyrieElementTypes.IMPLY_STATEMENT)
    }

    private fun parseFunctionStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'micro' keyword
        if (builder.tokenType == ValkyrieTokenTypes.MICRO) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // function name - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected function name")
        }

        // parameter list
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseParameterList(builder)
        }

        // 解析返回类型 - 支持 : T 和 -> T 两种形式
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer() // consume ':' or '->'
            parseTypeReference(builder)
        }

        // function body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected function body")
        }

        marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
    }

    private fun parseTraitBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // trait members (similar to class members)
        while (builder.tokenType != ValkyrieTokenTypes.RBRACE && !builder.eof()) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.WHITESPACE, ValkyrieTokenTypes.NEWLINE -> builder.advanceLexer()
                ValkyrieTokenTypes.COMMENT_REST, ValkyrieTokenTypes.COMMENT_RANGE -> builder.advanceLexer()
                else -> parseObjectMember(builder) // 复用 class member 解析逻辑
            }
        }

        // '}'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.UNION_BODY)
    }

    private fun parseObjectBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // class members
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                isModifierOrIdentifier(builder) -> {
                    parseObjectMember(builder)
                    // 处理逗号分隔的多个字段声明
                    while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer() // consume ','
                        // 跳过空白符
                        while (builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE) {
                            builder.advanceLexer()
                        }
                        // 解析下一个字段
                        if (isModifierOrIdentifier(builder)) {
                            parseObjectMember(builder)
                        } else {
                            break
                        }
                    }
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.COMMENT_REST || builder.tokenType == ValkyrieTokenTypes.COMMENT_RANGE -> {
                    builder.advanceLexer()
                }

                else -> {
                    builder.error("Expected class member")
                    builder.advanceLexer()
                }
            }
        }

        // '}'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.UNION_BODY)
    }

    private fun parseDomainBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // domain members
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                isModifierOrIdentifier(builder) -> {
                    parseObjectMember(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.COMMENT_REST || builder.tokenType == ValkyrieTokenTypes.COMMENT_RANGE -> {
                    builder.advanceLexer()
                }

                else -> {
                    builder.error("Expected domain member")
                    builder.advanceLexer()
                }
            }
        }

        // '}'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
    }

    private fun parseFlagsBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // flags items and methods
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD -> {
                    // 前瞻判断是方法还是 flags item
                    val nextToken = builder.lookAhead(1)
                    if (nextToken == ValkyrieTokenTypes.LPAREN) {
                        // 解析方法声明
                        parseObjectMember(builder)
                    } else {
                        // 解析 flags item
                        parseFlagsItem(builder)
                    }
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.COMMENT_REST || builder.tokenType == ValkyrieTokenTypes.COMMENT_RANGE -> {
                    builder.advanceLexer()
                }

                // 跳过多余的逗号和分号
                builder.tokenType == ValkyrieTokenTypes.COMMA || builder.tokenType == ValkyrieTokenTypes.SEMICOLON -> {
                    builder.advanceLexer()
                }

                else -> {
                    builder.error("Expected flags item or method")
                    builder.advanceLexer()
                }
            }
        }

        // '}'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
    }

    private fun parseFlagsItem(builder: PsiBuilder) {
        val marker = builder.mark()

        // flags item name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        } else {
            builder.error("Expected flags item name")
            marker.drop()
            return
        }

        // optional assignment
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
            parseExpression(builder)
        }

        marker.done(ValkyrieElementTypes.FLAGS_ITEM)
    }

    private fun parseUnionBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // union variants and methods
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD -> {
                    // 前瞻判断是方法还是 variant
                    val nextToken = builder.lookAhead(1)
                    if (nextToken == ValkyrieTokenTypes.LPAREN) {
                        // 解析方法声明
                        parseObjectMember(builder)
                    } else {
                        // 解析 variant
                        parseUnionVariant(builder)
                    }
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.COMMENT_REST || builder.tokenType == ValkyrieTokenTypes.COMMENT_RANGE -> {
                    builder.advanceLexer()
                }

                // 跳过多余的逗号和分号
                builder.tokenType == ValkyrieTokenTypes.COMMA || builder.tokenType == ValkyrieTokenTypes.SEMICOLON -> {
                    builder.advanceLexer()
                }

                else -> {
                    builder.error("Expected union variant or method")
                    builder.advanceLexer()
                }
            }
        }

        // '}'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
    }

    private fun parseObjectMember(builder: PsiBuilder) {
        // 检查是否是宏调用 - 宏调用是完全独立的类成员
        if (builder.tokenType == ValkyrieTokenTypes.AT) {
            parseMacroCallMember(builder)
            return
        }

        // 检查是否是mezzo关键字 - trait中的关联类型声明
        if (builder.tokenType == ValkyrieTokenTypes.MEZZO) {
            parseMezzoDeclaration(builder)
            return
        }

        // 开始解析成员声明
        val memberMarker = builder.mark()

        // 解析attributes并创建annotation node
        val annotationMarker = builder.mark()

        // 解析attributes (↯标记)
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            parseAttributeList(builder)
        }


        // 直接解析modifiers到annotation节点下 - 支持关键字修饰符和元编程前缀
        while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD ||
            builder.tokenType == ValkyrieTokenTypes.MICRO ||
            builder.tokenType == ValkyrieTokenTypes.MEZZO ||
            builder.tokenType == ValkyrieTokenTypes.MACRO
        ) {
            val nextToken = builder.lookAhead(1)

            // 如果下一个token是声明分隔符，停止解析modifiers
            if (nextToken == ValkyrieTokenTypes.LPAREN ||
                nextToken == ValkyrieTokenTypes.LBRACE ||
                nextToken == ValkyrieTokenTypes.SEMICOLON ||
                nextToken == ValkyrieTokenTypes.COLON ||
                nextToken == ValkyrieTokenTypes.ASSIGN
            ) {
                break
            }

            // 当前是modifier，解析为modifier节点
            val modifierMarker = builder.mark()
            val identifierMarker = builder.mark()

            if (builder.tokenType == ValkyrieTokenTypes.MICRO ||
                builder.tokenType == ValkyrieTokenTypes.MEZZO ||
                builder.tokenType == ValkyrieTokenTypes.MACRO
            ) {
                // 元编程关键字作为modifier
                builder.advanceLexer()
            } else {
                // 普通标识符modifier
                parseIdentifier(builder)
            }

            identifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
            modifierMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
        }

        annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)

        // 解析声明名称 - 支持普通标识符和 raw identifier
        if (builder.tokenType != ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenType != ValkyrieTokenTypes.BACKTICK) {
            builder.error("Expected identifier")
            memberMarker.drop()
            if (!builder.eof()) {
                builder.advanceLexer()
            }
            return
        }

        val nameMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
            // 处理 raw identifier
            builder.advanceLexer() // consume '`'
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume identifier
            } else {
                builder.error("Expected identifier after backtick")
            }
            if (builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
                builder.advanceLexer() // consume closing '`'
            } else {
                builder.error("Expected closing backtick")
            }
        } else {
            // 处理普通标识符
            val declarationName = builder.tokenText ?: ""
            builder.advanceLexer()
        }
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

        // 根据后续符号确定成员类型
        when (builder.tokenType) {
            // 方法 `method() { }`
            ValkyrieTokenTypes.LPAREN -> {
                parseMethodRest(builder)
                memberMarker.done(ValkyrieElementTypes.METHOD_DECLARATION)
            }

            // 域 `domain { }`
            ValkyrieTokenTypes.LBRACE -> {
                parseDomainBody(builder)
                memberMarker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
            }

            // 字段 `field: Type = default` 或 `field;` 或 `field,` 或单独的 `field`
            ValkyrieTokenTypes.SEMICOLON, ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN, ValkyrieTokenTypes.COMMA -> {
                // field declaration
                parseFieldRest(builder)
                memberMarker.done(ValkyrieElementTypes.FIELD_DECLARATION)
            }

            // 不完整或到达结束符
            null, ValkyrieTokenTypes.RBRACE, ValkyrieTokenTypes.NEWLINE, ValkyrieTokenTypes.WHITESPACE -> {
                // 单独的字段名，没有类型或默认值
                parseFieldRest(builder)
                memberMarker.done(ValkyrieElementTypes.FIELD_DECLARATION)
            }

            else -> {
                // 检查是否是下一个成员的开始（如另一个标识符或修饰符）
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    // 当前字段声明结束，这是下一个成员
                    parseFieldRest(builder)
                    memberMarker.done(ValkyrieElementTypes.FIELD_DECLARATION)
                } else {
                    builder.error("Unexpected token: ${builder.tokenType}")
                    memberMarker.drop()
                    if (!builder.eof()) {
                        builder.advanceLexer()
                    }
                }
            }
        }
    }

    /**
     * 解析宏调用作为独立的类成员
     * 宏调用只能有attributes，不能有modifiers
     */
    private fun parseMacroCallMember(builder: PsiBuilder) {
        val memberMarker = builder.mark()

        // 解析可能的attributes
        val attributeMarkers = mutableListOf<PsiBuilder.Marker>()
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            val attrMarker = builder.mark()
            parseAttributeList(builder)
            attrMarker.done(ValkyrieElementTypes.ATTRIBUTE_LIST)
            attributeMarkers.add(attrMarker)
        }

        // 创建annotation_node包含attributes（如果有的话）
        if (attributeMarkers.isNotEmpty()) {
            val annotationMarker = builder.mark()
            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        }

        // 解析宏调用
        if (builder.tokenType == ValkyrieTokenTypes.AT) {
            parseMacroCall(builder)
        } else {
            builder.error("Expected macro call")
        }

        memberMarker.done(ValkyrieElementTypes.MACRO_CALL)
    }

    private fun isModifierOrIdentifier(builder: PsiBuilder): Boolean {
        return builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD
    }

    private fun parseFieldRest(builder: PsiBuilder) {
        // 解析字段声明的其余部分
        when (builder.tokenType) {
            ValkyrieTokenTypes.COLON -> {
                builder.advanceLexer() // consume ':'
                parseTypeReference(builder)
                if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
                    builder.advanceLexer() // consume '='
                    parseExpression(builder)
                }
            }

            ValkyrieTokenTypes.ASSIGN -> {
                builder.advanceLexer() // consume '='
                parseExpression(builder)
            }
        }

        // 处理字段声明结束符
        when (builder.tokenType) {
            ValkyrieTokenTypes.SEMICOLON -> {
                builder.advanceLexer() // consume ';'
            }

            ValkyrieTokenTypes.COMMA -> {
                builder.advanceLexer() // consume ','
            }
            // 如果没有分隔符，也是合法的（在trait或class的最后一个成员）
        }
    }

    /**
     * 解析mezzo关联类型声明
     * 格式: mezzo TypeName [: Bounds] [= DefaultType],
     */
    private fun parseMezzoDeclaration(builder: PsiBuilder) {
        val marker = builder.mark()

        // consume 'mezzo'
        if (builder.tokenType == ValkyrieTokenTypes.MEZZO) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // 解析类型名称 - 支持 raw identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        } else {
            builder.error("Expected type name after 'mezzo'")
            marker.drop()
            return
        }

        // 可选的类型约束 ': Bounds'
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder)
        }

        // 可选的默认类型 '= DefaultType' - 支持联合类型语法 A | B
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // consume '='
            parseUnionType(builder)
        }

        // 处理结尾的逗号或分号
        if (builder.tokenType == ValkyrieTokenTypes.COMMA || builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.MEZZO_DECLARATION)
    }

    private fun parseMethodRest(builder: PsiBuilder) {
        // 解析方法参数列表
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseParameterListWithSelfDetection(builder)
        }

        // 解析返回类型 - 支持 : T 和 -> T 两种形式
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer() // consume ':' or '->'
            parseTypeReference(builder)
        }

        // 解析方法体
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer() // consume ';' for abstract methods
        } else if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
            builder.advanceLexer() // consume ',' for method declarations
        }
    }

    private fun parseUnionVariant(builder: PsiBuilder) {
        val marker = builder.mark()

        // variant name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        }

        // variant body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseVariantBody(builder)
        } else {
            builder.error("Expected variant body")
        }

        marker.done(ValkyrieElementTypes.UNION_VARIANT)
    }

    private fun parseVariantBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // variant members (fields, methods, domains)
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                isModifierOrIdentifier(builder) -> {
                    parseObjectMember(builder) // 复用 class member 解析逻辑
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.COMMENT_REST || builder.tokenType == ValkyrieTokenTypes.COMMENT_RANGE -> {
                    builder.advanceLexer()
                }

                else -> {
                    builder.error("Expected variant member")
                    builder.advanceLexer()
                }
            }
        }

        // '}'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
    }

    private fun parseParameterList(builder: PsiBuilder) {
        parseParameterListWithSelfDetection(builder)
    }

    private fun parseParameterListWithSelfDetection(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        var hasSelfParameter = false

        // '('
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer()
        }

        // parameters
        var isFirstParameter = true
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
            // 处理省略参数语法 .. 和 ...
            if (builder.tokenType == ValkyrieTokenTypes.DOT_DOT || builder.tokenType == ValkyrieTokenTypes.ELLIPSIS) {
                val paramMarker = builder.mark()
                builder.advanceLexer() // consume .. or ...

                // 解析省略参数名称和类型
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    builder.advanceLexer()
                    if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                        builder.advanceLexer()
                        parseTypeReference(builder)
                    }
                }

                paramMarker.done(ValkyrieElementTypes.TERM_PARAMETER_ITEM)

                // 处理逗号分隔符，允许尾随逗号
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                    // 检查逗号后是否直接是右括号（尾随逗号情况）
                    if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        break // 允许尾随逗号，直接退出循环
                    }
                }
                continue
            }
            // 处理位置限定符 < 和 >
            else if (builder.tokenType == ValkyrieTokenTypes.LESS || builder.tokenType == ValkyrieTokenTypes.GREATER) {
                val paramMarker = builder.mark()
                builder.advanceLexer() // consume '<' or '>'
                paramMarker.done(ValkyrieElementTypes.TERM_PARAMETER_ITEM)

                // 处理逗号分隔符，允许尾随逗号
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                    // 检查逗号后是否直接是右括号（尾随逗号情况）
                    if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        break // 允许尾随逗号，直接退出循环
                    }
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
                val paramMarker = builder.mark()

                // 检查是否有修饰符（如 mut）
                var paramName = ""
                var hasModifier = false

                // 处理 mut 修饰符
                if (builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
                    // 处理 raw identifier 参数名
                    parseSpecialIdentifier(builder)
                    paramName = "raw_identifier" // 占位符，实际名称由 parseSpecialIdentifier 处理
                } else if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                    // 检查是否是其他修饰符关键字
                    val currentText = builder.tokenText ?: ""
                    if (currentText == "readonly" || currentText == "const") {
                        hasModifier = true
                        val modifierMarker = builder.mark()
                        builder.advanceLexer() // 跳过修饰符关键字
                        modifierMarker.done(ValkyrieElementTypes.MODIFIER_NODE)

                        // 解析实际的参数名（支持 raw identifier）
                        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                            paramName = builder.tokenText ?: ""
                            builder.advanceLexer()
                        } else if (builder.tokenType == ValkyrieTokenTypes.BACKTICK) {
                            parseSpecialIdentifier(builder)
                            paramName = "raw_identifier" // 占位符，实际名称由 parseSpecialIdentifier 处理
                        } else {
                            builder.error("Expected parameter name after modifier")
                        }
                    } else {
                        paramName = currentText
                        builder.advanceLexer()
                    }
                }

                // 检测第一个参数是否为self（不考虑注解）
                if (isFirstParameter && paramName == "self") {
                    hasSelfParameter = true
                }
                isFirstParameter = false

                // 解析类型注解
                if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                    builder.advanceLexer()
                    parseTypeReference(builder)
                }

                // 解析默认值
                if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
                    builder.advanceLexer()
                    parseExpression(builder) // 解析默认值表达式
                }

                paramMarker.done(ValkyrieElementTypes.TERM_PARAMETER_ITEM)

                // 处理逗号分隔符，允许尾随逗号
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                    // 检查逗号后是否直接是右括号（尾随逗号情况）
                    if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        break // 允许尾随逗号，直接退出循环
                    }
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE) {
                builder.advanceLexer()
            } else {
                builder.error("Expected parameter")
                builder.advanceLexer()
            }
        }

        // ')'
        if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ')'")
        }

        marker.done(ValkyrieElementTypes.TERM_PARAMETER_LIST)
        return hasSelfParameter
    }

    /**
     * 解析属性列表
     * 支持: ↯derive(Show), @.primitive(array), ↯[serde(args), sqlx(args)]
     */
    private fun parseAttributeList(builder: PsiBuilder) {
        val marker = builder.mark()

        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            parseAttribute(builder)
        }

        marker.done(ValkyrieElementTypes.ATTRIBUTE_LIST)
    }

    /**
     * 解析单个属性
     */
    private fun parseAttribute(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = false)
    }

    /**
     * 解析注解（重构后的独立方法）
     * @param builder PsiBuilder 实例
     * @param withModifiers 是否包含修饰符解析
     */
    private fun parseAnnotations(builder: PsiBuilder, withModifiers: Boolean) {
        val annotationMarker = builder.mark()

        // 解析若干个 attribute node ↯attr 和 attribute list ↯[attr] 混合
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            if (builder.lookAhead(1) == ValkyrieTokenTypes.LBRACKET) {
                // 解析 attribute list: ↯[attr1, attr2, ...]
                val listMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯
                builder.advanceLexer() // 消费 [
                
                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
                    val attrMarker = builder.mark()
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        parseQualifiedName(builder)
                        // 可选的参数列表
                        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                            parseAttributeArgs(builder)
                        }
                        attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                    } else {
                        builder.error("Expected attribute name")
                        attrMarker.drop()
                        break
                    }
                    
                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
                        break
                    }
                }
                
                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer()
                }
                listMarker.done(ValkyrieElementTypes.ATTRIBUTE_LIST)
            } else {
                // 解析单个 attribute node: ↯attr
                val attrMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯
                
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    parseQualifiedName(builder)
                    // 可选的参数列表
                    if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                        parseAttributeArgs(builder)
                    }
                    attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                } else {
                    builder.error("Expected attribute name")
                    attrMarker.drop()
                    break
                }
            }
        }

        // 如果 withModifiers 为 true，解析结尾的 mod id
        if (withModifiers) {
            var lastNonIdToken: String? = null
            
            // 解析所有的 mod id
            while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || 
                   builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                val currentText = builder.tokenText ?: ""
                
                // 检查是否是 micro, mezzo, macro 关键字
                if (currentText == "micro" || currentText == "mezzo" || currentText == "macro") {
                    lastNonIdToken = currentText
                }
                
                // 解析 mod id
                val modMarker = builder.mark()
                builder.advanceLexer() // consume identifier
                modMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
            }
            
            // 根据最后一个非id节点决定返回值
            if (lastNonIdToken != null) {
                // 如果最后一个非id节点是 micro/mezzo/macro，返回该节点且不pop
                annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
            } else {
                // 其他情况 pop 并返回 null
                annotationMarker.drop()
            }
        } else {
            // 如果 mods 关了就算了, 直接打包 attrs 结束
            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        }
    }

    /**
     * 解析属性参数 (args)
     */
    private fun parseAttributeArgs(builder: PsiBuilder) {
        val marker = builder.mark()

        // '('
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer()
        }

        // 参数列表
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.STRING) {
                // 支持字符串字面量参数，如 "v:legacy/text", "utf16"
                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.WHITESPACE ||
                builder.tokenType == ValkyrieTokenTypes.NEWLINE
            ) {
                builder.advanceLexer()
            } else {
                builder.error("Expected argument")
                builder.advanceLexer()
            }
        }

        // ')'
        if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ')'")
        }

        marker.done(ValkyrieElementTypes.ATTRIBUTE_ARGS)
    }

    /**
     * 解析属性数组参数 [args]
     */
    private fun parseAttributeArrayArgs(builder: PsiBuilder) {
        val marker = builder.mark()

        // '['
        if (builder.tokenType == ValkyrieTokenTypes.LBRACKET) {
            builder.advanceLexer()
        }

        // 参数列表
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                parseQualifiedName(builder)

                // 可选的参数
                if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                    parseAttributeArgs(builder)
                }

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.WHITESPACE ||
                builder.tokenType == ValkyrieTokenTypes.NEWLINE
            ) {
                builder.advanceLexer()
            } else {
                builder.error("Expected argument")
                builder.advanceLexer()
            }
        }

        // ']'
        if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ']'")
        }

        marker.done(ValkyrieElementTypes.ATTRIBUTE_ARGS)
    }

    /**
     * 解析宏调用
     * 支持: @macro_name, @module_path::macro_name
     */
    private fun parseMacroCall(builder: PsiBuilder) {
        val marker = builder.mark()

        // 宏前缀: @, @., ↯
        when (builder.tokenType) {
            ValkyrieTokenTypes.AT,
            ValkyrieTokenTypes.ATTRIBUTE_LOWER,
            ValkyrieTokenTypes.ATTRIBUTE_LOWER -> builder.advanceLexer()

            else -> {
                builder.error("Expected macro prefix")
                marker.drop()
                return
            }
        }

        // 宏名称或路径
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            parseQualifiedName(builder)
        } else {
            builder.error("Expected macro name")
        }

        marker.done(ValkyrieElementTypes.MACRO_CALL)
    }

    private fun parseDocComment(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.COMMENT_DOCUMENT) {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.DOC_COMMENT)
        } else {
            marker.drop()
        }
    }

    private fun parseUntilStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'until' keyword
        if (builder.tokenType == ValkyrieTokenTypes.UNTIL) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // condition expression
        parseExpression(builder)

        // body block
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after until condition")
        }

        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
    }

    private fun parseWhileStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'while' keyword
        if (builder.tokenType == ValkyrieTokenTypes.WHILE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // condition expression
        parseExpression(builder)

        // body block
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after while condition")
        }

        marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
    }

    private fun parseMatchStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'match' keyword
        if (builder.tokenType == ValkyrieTokenTypes.MATCH) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // expression to match
        parseExpression(builder)

        // match body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer() // consume '{'

            // parse match cases
            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
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

            if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
                builder.advanceLexer() // consume '}'
            } else {
                builder.error("Expected '}'")
            }
        } else {
            builder.error("Expected '{' after match expression")
        }

        marker.done(ValkyrieElementTypes.MATCH_STATEMENT)
    }

    private fun parseMatchCase(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'case' keyword
        if (builder.tokenType == ValkyrieTokenTypes.CASE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // pattern
        parsePattern(builder)

        // optional guard condition
        if (builder.tokenType == ValkyrieTokenTypes.IF) {
            builder.advanceLexer()
            parseExpression(builder)
        }

        // ':' or '=>'
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ':' or '=>' after case pattern")
        }

        // case body
        parseExpression(builder)

        // optional fallthrough
        if (builder.tokenType == ValkyrieTokenTypes.FALLTHROUGH) {
            builder.advanceLexer() // consume 'fallthrough'
        }

        marker.done(ValkyrieElementTypes.MATCH_CASE)
    }

    private fun parseWhenClause(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'when' keyword
        if (builder.tokenType == ValkyrieTokenTypes.WHEN) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // condition expression
        parseExpression(builder)

        // ':' or '=>'
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ':' or '=>' after when condition")
        }

        // when body
        parseExpression(builder)

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
        parseExpression(builder)

        marker.done(ValkyrieElementTypes.WHEN_CLAUSE) // reuse WHEN_CLAUSE for else
    }

    private fun parseTryStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'try' keyword
        if (builder.tokenType == ValkyrieTokenTypes.TRY) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // 支持try语法形式:
        // try { } - 无类型注解
        // try Type { } - 带类型注解
        // try* { } - 编译期通配符

        // 检查是否是编译期通配符
        if (builder.tokenType == ValkyrieTokenTypes.MULTIPLY) {
            builder.advanceLexer() // consume '*'
        } else if (builder.tokenType != ValkyrieTokenTypes.LBRACE) {
            // 解析可选的类型表达式
            parseTypeReference(builder)
        }

        // try body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after try")
        }

        marker.done(ValkyrieElementTypes.TRY_STATEMENT)
    }

    private fun parseCatchStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'catch' keyword
        if (builder.tokenType == ValkyrieTokenTypes.CATCH) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // optional error variable
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val identifierMarker = builder.mark()
            builder.advanceLexer()
            identifierMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        }

        // catch body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer() // consume '{'

            // parse catch cases (similar to match)
            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                when (builder.tokenType) {
                    ValkyrieTokenTypes.CASE -> parseMatchCase(builder)
                    ValkyrieTokenTypes.ELSE -> parseElseClause(builder)
                    else -> {
                        builder.error("Expected 'case' or 'else' in catch block")
                        builder.advanceLexer()
                    }
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
                builder.advanceLexer() // consume '}'
            } else {
                builder.error("Expected '}'")
            }
        } else {
            builder.error("Expected '{' after catch")
        }

        marker.done(ValkyrieElementTypes.CATCH_STATEMENT)
    }

    private fun parsePattern(builder: PsiBuilder) {
        val marker = builder.mark()

        when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD -> {
                builder.advanceLexer()
                // Check for struct pattern: Identifier { ... }
                if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
                    builder.advanceLexer() // consume '{'

                    // Parse struct pattern fields (if any)
                    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                            builder.advanceLexer()
                            if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                                builder.advanceLexer()
                                parsePattern(builder)
                            }
                        } else {
                            builder.error("Expected field name")
                            builder.advanceLexer()
                        }

                        if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                            builder.advanceLexer()
                        } else if (builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                            break
                        }
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
                        builder.advanceLexer() // consume '}'
                    } else {
                        builder.error("Expected '}'")
                    }
                    marker.done(ValkyrieElementTypes.STRUCT_PATTERN)
                } else {
                    marker.done(ValkyrieElementTypes.PATTERN)
                }
            }

            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.UNIT_NUMBER -> {
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.PATTERN)
            }

            ValkyrieTokenTypes.STRING -> {
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.PATTERN)
            }

            ValkyrieTokenTypes.BOOLEAN -> {
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.PATTERN)
            }

            ValkyrieTokenTypes.LPAREN -> {
                // 使用单独的标记器处理元组模式
                marker.drop()
                parseTuplePattern(builder)
                return
            }

            ValkyrieTokenTypes.LBRACKET -> {
                // 使用单独的标记器处理数组/字典模式
                marker.drop()
                parseArrayOrDictPattern(builder)
                return
            }

            else -> {
                builder.error("Expected pattern")
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.PATTERN)
            }
        }
    }

    private fun parseTuplePattern(builder: PsiBuilder) {
        val marker = builder.mark()

        // consume '('
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '('")
            marker.drop()
            return
        }

        // 检查是否为空元组
        if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
            builder.advanceLexer() // consume ')'
            marker.done(ValkyrieElementTypes.TUPLE_PATTERN)
            return
        }

        // 解析第一个元素
        parsePattern(builder)

        // 检查是否为named tuple pattern
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            // Named tuple pattern: (name: pattern, ...)
            builder.advanceLexer() // consume ':'
            parsePattern(builder) // parse pattern

            // 解析后续元素
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','

                // 允许尾随逗号
                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    break
                }

                parsePattern(builder) // parse name
                if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                    builder.advanceLexer() // consume ':'
                    parsePattern(builder) // parse pattern
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                builder.advanceLexer() // consume ')'
            } else {
                builder.error("Expected ')'")
            }
            marker.done(ValkyrieElementTypes.NAMED_TUPLE_PATTERN)
        } else {
            // 普通元组模式: (a, b, c)
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','

                // 允许尾随逗号
                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    break
                }

                parsePattern(builder)
            }

            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                builder.advanceLexer() // consume ')'
            } else {
                builder.error("Expected ')'")
            }
            marker.done(ValkyrieElementTypes.TUPLE_PATTERN)
        }
    }

    private fun parseArrayOrDictPattern(builder: PsiBuilder) {
        val marker = builder.mark()

        // consume '['
        if (builder.tokenType == ValkyrieTokenTypes.LBRACKET) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '['")
            marker.drop()
            return
        }

        // Check if empty pattern
        if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
            builder.advanceLexer() // consume ']'
            marker.done(ValkyrieElementTypes.DICT_PATTERN)
            return
        }

        // Parse first element to determine if it's dict pattern
        val firstElementMarker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()
            if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                // This is a dict pattern: [key: value, ...]
                firstElementMarker.drop()
                builder.advanceLexer() // consume ':'
                parseExpression(builder) // parse value

                // Parse remaining key-value pairs
                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','

                    // Allow trailing comma
                    if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                        break
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        builder.advanceLexer()
                        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                            builder.advanceLexer()
                            parseExpression(builder)
                        } else {
                            builder.error("Expected ':' after key")
                        }
                    } else {
                        builder.error("Expected key name")
                        builder.advanceLexer()
                    }
                }

                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer() // consume ']'
                } else {
                    builder.error("Expected ']'")
                }
                marker.done(ValkyrieElementTypes.DICT_PATTERN)
            } else {
                // This is an array pattern: [a, b, c]
                firstElementMarker.done(ValkyrieElementTypes.PATTERN)

                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','

                    // Allow trailing comma
                    if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                        break
                    }

                    parsePattern(builder)
                }

                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer() // consume ']'
                } else {
                    builder.error("Expected ']'")
                }
                marker.done(ValkyrieElementTypes.PATTERN)
            }
        } else {
            // Array pattern with non-identifier first element
            firstElementMarker.drop()
            parsePattern(builder)

            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','

                // Allow trailing comma
                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    break
                }

                parsePattern(builder)
            }

            if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                builder.advanceLexer() // consume ']'
            } else {
                builder.error("Expected ']'")
            }
            marker.done(ValkyrieElementTypes.PATTERN)
        }
    }

    private fun parseLabelStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // consume '※'
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '※'")
        }

        // parse label name (identifier)
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()
        } else {
            builder.error("Expected label name after '※'")
        }

        marker.done(ValkyrieElementTypes.LABEL_STATEMENT)
    }

    private fun parseReturnStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'return'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume label name
            } else {
                builder.error("Expected label name after ※")
            }
        }

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON &&
            builder.tokenType != ValkyrieTokenTypes.NEWLINE &&
            !builder.eof()
        ) {
            parseExpression(builder)
        }

        marker.done(ValkyrieElementTypes.RETURN_STATEMENT)
    }

    private fun parseBreakStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'break'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume label name
            } else {
                builder.error("Expected label name after ※")
            }
        }

        marker.done(ValkyrieElementTypes.BREAK_STATEMENT)
    }

    private fun parseContinueStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'continue'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume label name
            } else {
                builder.error("Expected label name after ※")
            }
        }

        marker.done(ValkyrieElementTypes.CONTINUE_STATEMENT)
    }

    private fun parseYieldStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'yield'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume label name
            } else {
                builder.error("Expected label name after ※")
            }
        }

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON &&
            builder.tokenType != ValkyrieTokenTypes.NEWLINE &&
            !builder.eof()
        ) {
            parseExpression(builder)
        }

        marker.done(ValkyrieElementTypes.YIELD_STATEMENT)
    }

    private fun parseRaiseStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'raise'

        // Check for optional label
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer() // consume ※
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer() // consume label name
            } else {
                builder.error("Expected label name after ※")
            }
        }

        // Parse required expression for raise
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON &&
            builder.tokenType != ValkyrieTokenTypes.NEWLINE &&
            !builder.eof()
        ) {
            parseExpression(builder)
        } else {
            builder.error("Expected expression after 'raise'")
        }

        marker.done(ValkyrieElementTypes.RAISE_STATEMENT)
    }

    private fun parseIfStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'if'

        // Check for 'let' pattern (if let-else)
        if (builder.tokenType == ValkyrieTokenTypes.LET) {
            parseIfLetStatement(builder, marker)
            return
        }

        // Parse condition expression
        parseExpression(builder)

        // Parse then block
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after if condition")
        }

        // Parse optional else/else if clauses
        while (builder.tokenType == ValkyrieTokenTypes.ELSE) {
            val elseMarker = builder.mark()
            builder.advanceLexer() // consume 'else'

            if (builder.tokenType == ValkyrieTokenTypes.IF) {
                // else if
                builder.advanceLexer() // consume 'if'
                parseExpression(builder) // condition

                if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
                    parseBlockStatement(builder)
                } else {
                    builder.error("Expected '{' after else if condition")
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
                // else
                parseBlockStatement(builder)
                elseMarker.done(ValkyrieElementTypes.ELSE_CLAUSE)
                break // else clause is final
            } else {
                builder.error("Expected 'if' or '{' after 'else'")
            }

            elseMarker.done(ValkyrieElementTypes.ELSE_CLAUSE)
        }

        marker.done(ValkyrieElementTypes.IF_STATEMENT)
    }

    private fun parseIfLetStatement(builder: PsiBuilder, marker: PsiBuilder.Marker) {
        builder.advanceLexer() // consume 'let'

        // Parse pattern
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val patternMarker = builder.mark()
            builder.advanceLexer()
            patternMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        } else {
            builder.error("Expected pattern after 'if let'")
        }

        // Parse '=' assignment
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '=' in if let statement")
        }

        // Parse expression to match against
        parseExpression(builder)

        // Parse then block
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after if let condition")
        }

        // Parse required else clause for if let
        if (builder.tokenType == ValkyrieTokenTypes.ELSE) {
            val elseMarker = builder.mark()
            builder.advanceLexer() // consume 'else'

            if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
                parseBlockStatement(builder)
            } else {
                builder.error("Expected '{' after else in if let statement")
            }

            elseMarker.done(ValkyrieElementTypes.ELSE_CLAUSE)
        } else {
            builder.error("if let statement requires else clause")
        }

        marker.done(ValkyrieElementTypes.IF_LET_STATEMENT)
    }

    /**
     * 解析带time level前缀的语句 (micro, mezzo, macro)
     * 支持函数声明和控制流语句
     */
    private fun parseTimeLevelStatement(builder: PsiBuilder, timeLevel: String) {
        // 先检查下一个token来决定是函数声明还是控制流语句
        val nextToken = builder.lookAhead(1)

        when (nextToken) {
            ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.LPAREN -> {
                // 函数声明: micro name() {} 或 micro() {}
                val elementType = when (timeLevel) {
                    "micro" -> ValkyrieElementTypes.DECLARE_MICRO
                    "mezzo" -> ValkyrieElementTypes.DECLARE_MEZZO
                    "macro" -> ValkyrieElementTypes.DECLARE_MACRO
                    else -> ValkyrieElementTypes.DECLARE_MICRO
                }
                parseMetaFunctionStatement(builder, elementType)
            }

            ValkyrieTokenTypes.FOR -> {
                builder.advanceLexer() // consume time level
                parseForStatement(builder)
            }

            ValkyrieTokenTypes.WHILE -> {
                builder.advanceLexer() // consume time level
                parseWhileStatement(builder)
            }

            ValkyrieTokenTypes.LOOP -> {
                builder.advanceLexer() // consume time level
                parseLoopStatement(builder)
            }

            ValkyrieTokenTypes.MATCH -> {
                builder.advanceLexer() // consume time level
                parseMatchStatement(builder)
            }

            ValkyrieTokenTypes.TRY -> {
                builder.advanceLexer() // consume time level
                parseTryStatement(builder)
            }

            ValkyrieTokenTypes.CATCH -> {
                builder.advanceLexer() // consume time level
                parseCatchStatement(builder)
            }

            else -> {
                // 默认作为函数声明处理
                val elementType = when (timeLevel) {
                    "micro" -> ValkyrieElementTypes.DECLARE_MICRO
                    "mezzo" -> ValkyrieElementTypes.DECLARE_MEZZO
                    "macro" -> ValkyrieElementTypes.DECLARE_MACRO
                    else -> ValkyrieElementTypes.DECLARE_MICRO
                }
                parseMetaFunctionStatement(builder, elementType)
            }
        }
    }

    /**
     * 解析元编程函数声明 (micro, mezzo, macro)
     * 支持匿名函数: micro(a) {} 和具名函数: micro name(a) {}
     */
    private fun parseMetaFunctionStatement(builder: PsiBuilder, elementType: IElementType) {
        val marker = builder.mark()

        // 消费关键字 (micro/mezzo/macro)
        builder.advanceLexer()

        // 解析可选的函数名 - 支持匿名函数
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // 可选的泛型参数
            parseOptionalGenericParameters(builder)
        }
        // 如果没有函数名，直接解析参数列表（匿名函数）

        // 解析参数列表
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseParameterList(builder)
        }

        // 解析返回类型 - 支持 : T 和 -> T 两种形式
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer() // consume ':' or '->'
            parseTypeReference(builder)
        }

        // 解析函数体
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected function body")
        }

        marker.done(elementType)
    }

    /**
     * 解析编译期表达式块 <{ ... }>
     */
    private fun parseCompileTimeBlock(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 '<{'
        if (builder.tokenType == ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '<{'")
            marker.drop()
            return
        }

        // 解析块内容
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END) {
            parseStatement(builder)
        }

        // 消费 '}>'
        if (builder.tokenType == ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}>'")
        }

        marker.done(ValkyrieElementTypes.COMPILE_TIME_BLOCK)
    }

    /**
     * 解析模板语法块 <$ ... $>
     */
    private fun parseTemplateBlock(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 '<$'
        if (builder.tokenType == ValkyrieTokenTypes.TEMPLATE_START) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '<$'")
            marker.drop()
            return
        }

        // 解析模板内容
        parseTemplateContent(builder)

        // 消费 '$>'
        if (builder.tokenType == ValkyrieTokenTypes.TEMPLATE_END) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '$>'")
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_BLOCK)
    }

    /**
     * 解析模板内容
     */
    private fun parseTemplateContent(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END) {
            when {
                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "if" -> {
                    parseTemplateIf(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "for" -> {
                    parseTemplateFor(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "while" -> {
                    parseTemplateWhile(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "match" -> {
                    parseTemplateMatch(builder)
                }

                else -> {
                    // 解析插值表达式
                    parseExpression(builder)
                    break
                }
            }
        }
    }

    /**
     * 解析模板条件语句 <$ if ... $>
     */
    private fun parseTemplateIf(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 'if'
        builder.advanceLexer()

        // 解析条件表达式
        parseExpression(builder)

        // 解析 then 部分（这里简化处理）
        while (!builder.eof() &&
            builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
            !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "else") &&
            !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
        ) {
            parseStatement(builder)
        }

        // 处理 else 分支
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "else") {
            builder.advanceLexer() // consume 'else'
            while (!builder.eof() &&
                builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
                !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
            ) {
                parseStatement(builder)
            }
        }

        // 消费 'end'
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end") {
            builder.advanceLexer()
            // 可选的 'if'
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "if") {
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_IF)
    }

    /**
     * 解析模板循环语句 <$ for ... $>
     */
    private fun parseTemplateFor(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 'for'
        builder.advanceLexer()

        // 解析循环变量
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()
        }

        // 消费 'in'
        if (builder.tokenType == ValkyrieTokenTypes.IN) {
            builder.advanceLexer()
        }

        // 解析可迭代表达式
        parseExpression(builder)

        // 解析循环体
        while (!builder.eof() &&
            builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
            !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
        ) {
            parseStatement(builder)
        }

        // 消费 'end'
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end") {
            builder.advanceLexer()
            // 可选的 'for'
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "for") {
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_FOR)
    }

    /**
     * 解析模板 while 循环 <$ while ... $>
     */
    private fun parseTemplateWhile(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 'while'
        builder.advanceLexer()

        // 解析条件表达式
        parseExpression(builder)

        // 解析循环体
        while (!builder.eof() &&
            builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
            !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
        ) {
            parseStatement(builder)
        }

        // 消费 'end'
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end") {
            builder.advanceLexer()
            // 可选的 'while'
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "while") {
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_WHILE)
    }

    /**
     * 解析模板匹配语句 <$ match ... $>
     */
    private fun parseTemplateMatch(builder: PsiBuilder) {
        val marker = builder.mark()

        // 消费 'match'
        builder.advanceLexer()

        // 解析匹配表达式
        parseExpression(builder)

        // 解析匹配分支
        while (!builder.eof() &&
            builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
            !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
        ) {

            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "case") {
                builder.advanceLexer() // consume 'case'
                parsePattern(builder) // 解析模式

                // 解析分支体
                while (!builder.eof() &&
                    builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
                    !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "case") &&
                    !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "else") &&
                    !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
                ) {
                    parseStatement(builder)
                }
            } else if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "else") {
                builder.advanceLexer() // consume 'else'
                // 解析默认分支
                while (!builder.eof() &&
                    builder.tokenType != ValkyrieTokenTypes.TEMPLATE_END &&
                    !(builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end")
                ) {
                    parseStatement(builder)
                }
            } else {
                break
            }
        }

        // 消费 'end'
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "end") {
            builder.advanceLexer()
            // 可选的 'match'
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD && builder.tokenText == "match") {
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_MATCH)
    }

    private fun parseForStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'for'

        // 解析循环变量
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()
        } else {
            builder.error("Expected identifier after 'for'")
        }

        // 'in' keyword
        if (builder.tokenType == ValkyrieTokenTypes.IN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected 'in' after for variable")
        }

        // 迭代表达式
        parseExpression(builder)

        // 循环体
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after for expression")
        }

        marker.done(ValkyrieElementTypes.FOR_STATEMENT)
    }

    private fun parseLoopStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'loop'

        // 解析循环体 - 必须是块语句
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected '{' after 'loop'")
        }

        marker.done(ValkyrieElementTypes.LOOP_STATEMENT)
    }

    private fun parseResumeStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'resume'

        // 可选的标签
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()
        }

        // 可选的表达式
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON &&
            builder.tokenType != ValkyrieTokenTypes.NEWLINE &&
            !builder.eof()
        ) {
            parseExpression(builder)
        }

        marker.done(ValkyrieElementTypes.RESUME_STATEMENT)
    }

    private fun parseClassInheritance(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer() // consume '('

            // 解析继承列表，允许空继承 class A() {}
            while (builder.tokenType != ValkyrieTokenTypes.RPAREN && !builder.eof()) {
                parseInheritItem(builder)

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    builder.error("Expected ',' or ')'")
                    break
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                builder.advanceLexer() // consume ')'
            } else {
                builder.error("Expected ')'")
            }
        }

        marker.done(ValkyrieElementTypes.CLASS_INHERIT)
    }

    private fun parseInheritItem(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析annotation
        while (builder.tokenType == ValkyrieTokenTypes.AT) {
            parseMacroCall(builder)
        }

        // 解析修饰符（如 readonly father: List⟨Integer⟩）
        var hasModifier = false
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val currentText = builder.tokenText ?: ""
            if (currentText == "readonly" || currentText == "const" || currentText == "mut") {
                hasModifier = true
                val modifierMarker = builder.mark()
                builder.advanceLexer() // 跳过修饰符关键字
                modifierMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
            }
        }

        // 检查是否是重命名继承 (rename: Type)
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nextToken = builder.lookAhead(1)
            if (nextToken == ValkyrieTokenTypes.COLON) {
                // 重命名继承
                builder.advanceLexer() // consume rename name
                builder.advanceLexer() // consume ':'
            }
        }

        // 解析类型表达式
        parseTypeReference(builder)

        marker.done(ValkyrieElementTypes.INHERIT_ITEM)
    }
}