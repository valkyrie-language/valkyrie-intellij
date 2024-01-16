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
        ValkyrieTokenTypes.FUNCTION,
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
        )) {
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
                ValkyrieTokenTypes.UNION -> parseUnionStatement(builder)
                ValkyrieTokenTypes.TRAIT -> parseTraitStatement(builder)
                ValkyrieTokenTypes.FUNCTION -> parseFunctionStatement(builder)
                ValkyrieTokenTypes.NAMESPACE,
                ValkyrieTokenTypes.NAMESPACE_MAIN,
                ValkyrieTokenTypes.NAMESPACE_TEST,
                ValkyrieTokenTypes.NAMESPACE_HIDE -> parseNamespaceStatement(builder)
                ValkyrieTokenTypes.USING -> parseUsingStatement(builder)
                ValkyrieTokenTypes.UNTIL -> parseUntilStatement(builder)
                ValkyrieTokenTypes.MATCH -> parseMatchStatement(builder)
                ValkyrieTokenTypes.TRY -> parseTryStatement(builder)
                ValkyrieTokenTypes.CATCH -> parseCatchStatement(builder)
                ValkyrieTokenTypes.LBRACE -> parseBlockStatement(builder)
                ValkyrieTokenTypes.COMMENT_DOCUMENT -> parseDocComment(builder)
                ValkyrieTokenTypes.AT -> parseMacroCall(builder)
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

        // optional 'mut' or 'ref'
        if (builder.tokenType == ValkyrieTokenTypes.MUT || builder.tokenType == ValkyrieTokenTypes.REF) {
            builder.advanceLexer()
        }

        // pattern (identifier for now)
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val patternMarker = builder.mark()
            builder.advanceLexer()
            patternMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
        } else {
            builder.error("Expected identifier")
            builder.advanceLexer() // 推进词法分析器避免死循环
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

        while (!builder.eof()) {
            val op = builder.tokenType
            val prec = getOperatorPrecedence(op)

            if (prec < minPrec) break

            val marker = left?.precede()
            builder.advanceLexer() // consume operator

            parseBinaryExpression(builder, prec + 1)

            marker?.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            left = marker
        }
    }

    private fun parsePostfixExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        var left = parsePrimaryExpression(builder)

        while (!builder.eof()) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.DOT -> {
                    // 点调用 a.b
                    val marker = left?.precede()
                    builder.advanceLexer() // consume '.'
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        val nameMarker = builder.mark()
                        builder.advanceLexer()
                        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                    } else {
                        builder.error("Expected identifier after '.'")
                    }
                    marker?.done(ValkyrieElementTypes.DOT_EXPRESSION)
                    left = marker
                }
                ValkyrieTokenTypes.LPAREN -> {
                    // 普通函数调用 call(args)
                    val marker = left?.precede()
                    parseArgumentList(builder)
                    marker?.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    left = marker
                }
                ValkyrieTokenTypes.LBRACE -> {
                    // 尾随闭包 call {}
                    val marker = left?.precede()
                    parseBlockStatement(builder)
                    marker?.done(ValkyrieElementTypes.TRAILING_CLOSURE_EXPRESSION)
                    left = marker
                }
                ValkyrieTokenTypes.LANGLE -> {
                    // 泛型调用 call⟨T⟩(args)
                    val marker = left?.precede()
                    parseGenericArguments(builder, ValkyrieTokenTypes.LANGLE, ValkyrieTokenTypes.RANGLE)
                    if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                        parseArgumentList(builder)
                    }
                    marker?.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                    left = marker
                }
                ValkyrieTokenTypes.DOUBLE_COLON -> {
                    // 检查是否为 call::<T> 形式
                    if (builder.lookAhead(1) == ValkyrieTokenTypes.LESS) {
                        val marker = left?.precede()
                        builder.advanceLexer() // consume '::'
                        parseGenericArguments(builder, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER)
                        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                            parseArgumentList(builder)
                        }
                        marker?.done(ValkyrieElementTypes.GENERIC_CALL_EXPRESSION)
                        left = marker
                    } else {
                        break
                    }
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
                           builder.tokenType != ValkyrieTokenTypes.RPAREN) {
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
                parseTypeReference(builder)
                
                // 确保类型解析有进展
                if (builder.currentOffset == beforeType) {
                    builder.error("Invalid type reference")
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
                           builder.tokenType != endToken) {
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
                parseIdentifier(builder)
                marker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                marker
            }

            ValkyrieTokenTypes.BACKTICK -> {
                val marker = builder.mark()
                parseSpecialIdentifier(builder)
                marker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
                marker
            }

            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.STRING, ValkyrieTokenTypes.BOOLEAN -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.LITERAL_EXPRESSION)
                marker
            }

            ValkyrieTokenTypes.LPAREN -> {
                val marker = builder.mark()
                builder.advanceLexer() // consume '('
                parseExpression(builder)
                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    builder.advanceLexer() // consume ')'
                } else {
                    builder.error("Expected ')'")
                }
                marker.done(ValkyrieElementTypes.PARENTHESIZED_EXPRESSION)
                marker
            }

            ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.WOW -> {
                val marker = builder.mark()
                builder.advanceLexer() // consume operator
                parsePrimaryExpression(builder)
                marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
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
        parseUnionType(builder)
    }

    private fun parseUnionType(builder: PsiBuilder) {
        val marker = builder.mark()
        
        // 支持开头的可选 | 符号（|A|B 语法，第一个|无意义）
        var hasUnion = false
        if (builder.tokenType == ValkyrieTokenTypes.PIPE) {
            hasUnion = true
            builder.advanceLexer() // consume leading '|'
        }
        
        // 解析第一个类型
        parseBasicType(builder)
        
        // 检查是否有联合类型操作符 |
        while (builder.tokenType == ValkyrieTokenTypes.PIPE) {
            hasUnion = true
            builder.advanceLexer() // consume '|'
            parseBasicType(builder)
        }
        
        if (hasUnion) {
            marker.done(ValkyrieElementTypes.UNION_TYPE)
        } else {
            marker.drop()
        }
    }

    private fun parseBasicType(builder: PsiBuilder) {
        val marker = builder.mark()
        
        when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD -> {
                builder.advanceLexer()
                
                // 支持复杂路径表达式，如 C::<D>::<E>
                while (true) {
                    // 支持泛型参数
                    if (builder.tokenType == ValkyrieTokenTypes.LESS) {
                        parseGenericArguments(builder, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER)
                    }
                    
                    // 检查是否有路径分隔符
                    if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
                        builder.advanceLexer() // consume '::'
                        
                        // 检查 :: 后面是否跟泛型参数 ::<T>
                        if (builder.tokenType == ValkyrieTokenTypes.LESS) {
                            parseGenericArguments(builder, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER)
                        } else if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                            // 普通路径继续，如 A::B
                            builder.advanceLexer()
                        } else {
                            builder.error("Expected identifier or generic arguments after '::'")
                            break
                        }
                    } else {
                        break
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
        
        marker.done(ValkyrieElementTypes.TYPE_REFERENCE)
    }

    // 性能优化：缓存操作符优先级
    private val operatorPrecedenceCache = mapOf(
        ValkyrieTokenTypes.LOGIC_OR to 1,
        ValkyrieTokenTypes.LOGIC_NOR to 1,
        ValkyrieTokenTypes.LOGIC_XOR to 1,
        ValkyrieTokenTypes.LOGIC_AND to 2,
        ValkyrieTokenTypes.LOGIC_NAND to 2,
        ValkyrieTokenTypes.LOGIC_XAND to 2,
        ValkyrieTokenTypes.EQUAL to 3,
        ValkyrieTokenTypes.NOT_EQUAL to 3,
        ValkyrieTokenTypes.LESS to 4,
        ValkyrieTokenTypes.GREATER to 4,
        ValkyrieTokenTypes.LESS_EQUAL to 4,
        ValkyrieTokenTypes.GREATER_EQUAL to 4,
        ValkyrieTokenTypes.PLUS to 5,
        ValkyrieTokenTypes.MINUS to 5,
        ValkyrieTokenTypes.STAR to 6,
        ValkyrieTokenTypes.MULTIPLY to 6,
        ValkyrieTokenTypes.DIVIDE to 6,
        ValkyrieTokenTypes.INTEGER_DIVIDE to 6,
        ValkyrieTokenTypes.MODULO to 6,
        ValkyrieTokenTypes.POWER to 7
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

        // 可选的分号
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
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
                    break
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
                            break
                        }
                    }

                    nextPathMarker.done(ValkyrieElementTypes.NAMESPACE_PATH)
                } else {
                    builder.error("Expected identifier after comma")
                    break
                }
            }
        } else {
            builder.error("Expected namespace identifier")
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

        marker.done(ValkyrieElementTypes.USING_STATEMENT)
    }

    private fun parseQualifiedName(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.advanceLexer()

            while (builder.tokenType == ValkyrieTokenTypes.DOT) {
                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    builder.advanceLexer()
                } else {
                    builder.error("Expected identifier after '.'")
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

        // class name (optional for anonymous classes)
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_NODE)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        }

        // class body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseObjectBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.CLASS_STATEMENT)
    }

    private fun parseOptionalGenericParameters(builder: PsiBuilder) {
        // 支持三种泛型语法: ⟨T⟩, <T>, ::<T>
        val isGeneric = when (builder.tokenType) {
            ValkyrieTokenTypes.LANGLE -> true  // ⟨
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

            // 解析泛型参数列表
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                builder.advanceLexer()

                // 处理多个泛型参数
                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                    // 支持尾随逗号：如果逗号后面直接是结束符号，则跳出循环
                    val expectedEndToken = if (startToken == ValkyrieTokenTypes.LANGLE) {
                        ValkyrieTokenTypes.RANGLE
                    } else {
                        ValkyrieTokenTypes.GREATER
                    }
                    if (builder.tokenType == expectedEndToken) {
                        break
                    }
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        builder.advanceLexer()
                    } else {
                        builder.error("Expected generic parameter name")
                        break
                    }
                }
            } else {
                builder.error("Expected generic parameter name")
            }

            // 结束符号 (⟩ 或 >)
            val expectedEndToken = if (startToken == ValkyrieTokenTypes.LANGLE) {
                ValkyrieTokenTypes.RANGLE
            } else {
                ValkyrieTokenTypes.GREATER
            }

            if (builder.tokenType == expectedEndToken) {
                builder.advanceLexer()
            } else {
                builder.error("Expected closing generic bracket")
            }

            marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
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

        // trait body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseTraitBody(builder)
        } else {
            builder.error("Expected '{'")
        }

        marker.done(ValkyrieElementTypes.TRAIT_STATEMENT)
    }

    private fun parseFunctionStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'micro' keyword
        if (builder.tokenType == ValkyrieTokenTypes.FUNCTION) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // function name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
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

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
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

    private fun parseUnionBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // union variants
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD -> {
                    parseUnionVariant(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.COMMENT_REST || builder.tokenType == ValkyrieTokenTypes.COMMENT_RANGE -> {
                    builder.advanceLexer()
                }

                else -> {
                    builder.error("Expected union variant")
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

        // 开始解析成员声明
        val memberMarker = builder.mark()

        // 解析attributes并创建annotation node
        val annotationMarker = builder.mark()

        // 解析attributes
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            parseAttributeList(builder)
        }

        // 直接解析modifiers到annotation节点下
        while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            val nextToken = builder.lookAhead(1)
            // 如果下一个token是声明分隔符，当前是声明名称，停止解析modifiers
            if (nextToken == ValkyrieTokenTypes.LPAREN ||
                nextToken == ValkyrieTokenTypes.LBRACE ||
                nextToken == ValkyrieTokenTypes.SEMICOLON ||
                nextToken == ValkyrieTokenTypes.COLON ||
                nextToken == ValkyrieTokenTypes.ASSIGN
            ) {
                break
            }

            // 当前是modifier，直接添加到annotation下
            val modifierMarker = builder.mark()
            builder.advanceLexer()
            modifierMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
        }

        annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)

        // 解析声明名称
        if (builder.tokenType != ValkyrieTokenTypes.IDENTIFIER_STD) {
            builder.error("Expected identifier")
            memberMarker.drop()
            if (!builder.eof()) {
                builder.advanceLexer()
            }
            return
        }

        val nameMarker = builder.mark()
        val declarationName = builder.tokenText ?: ""
        builder.advanceLexer()
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

            // 字段 `field: Type = default`
            ValkyrieTokenTypes.SEMICOLON, ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN, ValkyrieTokenTypes.COMMA -> {
                // field declaration
                parseFieldRest(builder)
                memberMarker.done(ValkyrieElementTypes.FIELD_DECLARATION)
            }

            // 不完整
            null -> {
                builder.error("Incomplete member declaration")
                memberMarker.drop()
                return
            }

            else -> {
                builder.error("Unexpected token: ${builder.tokenType}")
                memberMarker.drop()
                if (!builder.eof()) {
                    builder.advanceLexer()
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

        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer() // consume ';'
        }
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
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                val paramMarker = builder.mark()
                val paramName = builder.tokenText ?: ""

                // 检测第一个参数是否为self
                if (isFirstParameter && paramName == "self") {
                    hasSelfParameter = true
                }
                isFirstParameter = false

                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                    builder.advanceLexer()
                    parseTypeReference(builder)
                }
                paramMarker.done(ValkyrieElementTypes.PARAMETER)
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
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

        marker.done(ValkyrieElementTypes.PARAMETER_LIST)
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
        val marker = builder.mark()

        // 属性前缀: ↯
        when (builder.tokenType) {
            ValkyrieTokenTypes.ATTRIBUTE_LOWER -> builder.advanceLexer()
            else -> {
                builder.error("Expected attribute prefix")
                marker.drop()
                return
            }
        }

        // 属性名称或路径 (支持 module_path::macro_name)
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
            parseQualifiedName(builder)
        } else {
            builder.error("Expected attribute name")
        }

        // 可选的参数列表
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseAttributeArgs(builder)
        } else if (builder.tokenType == ValkyrieTokenTypes.LBRACKET) {
            parseAttributeArrayArgs(builder)
        }

        marker.done(ValkyrieElementTypes.ATTRIBUTE)
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

        // optional type annotation
        if (builder.tokenType == ValkyrieTokenTypes.LANGLE) {
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
            }
            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL -> {
                builder.advanceLexer()
            }
            ValkyrieTokenTypes.STRING -> {
                builder.advanceLexer()
            }
            ValkyrieTokenTypes.BOOLEAN -> {
                builder.advanceLexer()
            }
            ValkyrieTokenTypes.LPAREN -> {
                builder.advanceLexer() // consume '('
                // parse tuple pattern
                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    parsePattern(builder)
                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    }
                }
                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    builder.advanceLexer() // consume ')'
                } else {
                    builder.error("Expected ')'")
                }
            }
            else -> {
                builder.error("Expected pattern")
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.PATTERN)
    }
}