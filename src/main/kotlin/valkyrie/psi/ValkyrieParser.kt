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
        parseAnnotations(builder, withModifiers = true)
        try {
            when (builder.tokenType) {
                ValkyrieTokenTypes.NAMESPACE -> parseNamespaceStatement(builder)
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
                ValkyrieTokenTypes.MICRO -> parseMicroStatement(builder)
                ValkyrieTokenTypes.LET -> parseLetStatement(builder)
                ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START -> parseCompileTimeBlock(builder)
                ValkyrieTokenTypes.TEMPLATE_START -> parseTemplateBlock(builder)
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

    private fun parseClassStatement(builder: PsiBuilder) {
        parseClassLikeStatement(builder, ValkyrieElementTypes.CLASS_STATEMENT)
    }

    private fun parseTraitStatement(builder: PsiBuilder) {
        parseClassLikeStatement(builder, ValkyrieElementTypes.CLASS_STATEMENT)
    }

    private fun parseNeuralStatement(builder: PsiBuilder) {
        parseClassLikeStatement(builder, ValkyrieElementTypes.NEURAL_STATEMENT)
    }

    private fun parseWidgetStatement(builder: PsiBuilder) {
        parseClassLikeStatement(builder, ValkyrieElementTypes.WIDGET_STATEMENT)

    }

    private fun parseSingletonStatement(builder: PsiBuilder) {
        parseClassLikeStatement(builder, ValkyrieElementTypes.SINGLETON_STATEMENT)
    }

    private fun parseStructureStatement(builder: PsiBuilder) {
        parseClassLikeStatement(builder, ValkyrieElementTypes.STRUCTURE_STATEMENT)
    }

    private fun parseUnionStatement(builder: PsiBuilder) {
        parseUnionLikeStatement(builder, ValkyrieElementTypes.UNION_STATEMENT)
    }

    private fun parseUnityStatement(builder: PsiBuilder) {
        parseUnionLikeStatement(builder, ValkyrieElementTypes.UNITY_STATEMENT)
    }

    private fun parseLetStatement(builder: PsiBuilder) {

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


    // f(t, u)
    private fun parseTermArgumentList(builder: PsiBuilder) {

    }

    private fun parseTermArgumentItem(builder: PsiBuilder) {

    }

    // f::<T, U>
    private fun parseTypeArgumentList(builder: PsiBuilder) {

    }

    private fun parseTypeArgumentItem(builder: PsiBuilder) {

    }


    // term expression with optional semicolon
    private fun parseExpressionStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        marker.done(ValkyrieElementTypes.EXPRESSION_STATEMENT)
    }

    private fun parseTermExpression(builder: PsiBuilder, inline: Boolean) {

    }

    private fun parsePrimaryTerm(builder: PsiBuilder): PsiBuilder.Marker? {
        return null
    }

    // no type expression
    private fun parseTypeExpression(builder: PsiBuilder, inline: Boolean) {

    }

    private fun parsePrimaryType(builder: PsiBuilder): PsiBuilder.Marker? {
        return null
    }


    private fun getOperatorPrecedence(tokenType: IElementType?): Int {
        return operatorPrecedenceCache[tokenType] ?: -1
    }

    private fun parseNamespaceStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'namespace' keyword (支持不同类型: namespace, namespace!, namespace?, namespace*)
        when (builder.tokenType) {
            ValkyrieTokenTypes.NAMESPACE -> {
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


    private fun parseClassLikeStatement(builder: PsiBuilder, node: ValkyrieElementType) {
        val marker = builder.mark()
        
        // Parse annotations with modifiers
        val annotationsResult = parseAnnotations(builder, withModifiers = true)
        
        // Parse identifier (required)
        if (!parseIdentifier(builder)) {
            marker.error("Expected class name")
            recoverToSyncPoint(builder)
            return
        }
        
        // Parse optional components
        parseGenericParameterList(builder) // optional
        parseInheritanceList(builder) // optional
        parseImplementation(builder) // optional
        
        // Parse class body (required)
        if (!parseClassLikeBody(builder)) {
            marker.error("Expected class body")
            recoverToSyncPoint(builder)
            return
        }
        
        marker.done(node)
    }

    private fun parseClassLikeBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        
        // Expect opening brace
        if (builder.tokenType != ValkyrieTokenTypes.LBRACE) {
            marker.drop()
            return false
        }
        
        builder.advanceLexer() // consume '{'
        
        // Parse body content
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            parseClassLikeItem(builder)
            
            // Skip to next valid token if parsing failed
            if (builder.tokenType != ValkyrieTokenTypes.RBRACE && !builder.eof()) {
                if (syncTokens.contains(builder.tokenType)) {
                    break
                }
                builder.advanceLexer()
            }
        }
        
        // Expect closing brace
        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer() // consume '}'
            marker.done(ValkyrieElementTypes.OBJECT_BODY)
            return true
        } else {
            marker.error("Expected '}'")
            return false
        }
    }

    private fun parseClasXXXsLikeItem(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = false)
    }

    private fun parseUnionLikeStatement(builder: PsiBuilder, node: ValkyrieElementType) {
        parseAnnotations(builder, withModifiers = false)
        parseIdentifier(builder)
        parseInheritanceList(builder) // optional
        parseImplementation(builder) // optional
        parseSumBody(builder)
    }

    private fun parseSumBody(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = false)
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
            parseGenericArgument(builder, true)
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

    private fun parseGenericArgument(builder: PsiBuilder, typeLevel: Boolean) {
        // term level 支持两种泛型语法 ⟨T⟩ 和 ::<T>
        // type level 额外支持一种 <T>
    }

    private fun parseGenericParameterList(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        
        if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
            builder.advanceLexer() // consume '<'
            
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
            
            if (builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
                builder.advanceLexer() // consume '>'
                marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
                return true
            } else {
                marker.error("Expected '>'")
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
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(builder, true)
        }
        
        // Parse optional default type
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // consume '='
            parseTypeExpression(builder, true)
        }
        
        marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
        return true
    }

    private fun parseImplyStatement(builder: PsiBuilder) {

    }

    private fun parseMicroStatement(builder: PsiBuilder) {

    }


    private fun parseFlagsBody(builder: PsiBuilder) {
        // loop
        parseFlagsItem(builder)
    }

    private fun parseFlagsItem(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = false)
        parseIdentifier(builder)
    }

    private fun parseUnionBody(builder: PsiBuilder) {
        parseClasXXXsLikeItem(builder)
    }

    private fun parseClassLikeItem(builder: PsiBuilder) {
        // start loop
        parseMacroCall(builder)
        parseField(builder)
        parseMethod(builder)
        parseDomain(builder)
        // skip , and ;
        if (builder.tokenType == ValkyrieTokenTypes.COMMA || builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }
        // if found } end loop
    }

    /**
     * 解析宏调用作为独立的类成员
     * 宏调用只能有attributes，不能有modifiers
     */
    private fun parseMacroCallMember(builder: PsiBuilder) {
        val memberMarker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
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

    private fun parseField(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = true) // never fail
        parseIdentifier(builder)
        parseReturnType(builder) // optional
        parseDefaultValue(builder) // optional
    }

    private fun parseTypeHint(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(builder, true)
        }
    }

    private fun parseReturnType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer() // consume '->'
            parseTypeExpression(builder, true)
        }
    }

    private fun parseDefaultValue(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
            parseTermExpression(builder, false)
        }
    }

    private fun parseDefaultType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
            parseTypeExpression(builder, false)
        }
    }

    /**
     * 解析mezzo关联类型声明
     * 格式: mezzo TypeName [: Bounds] [= DefaultType],
     */
    private fun parseMezzoAssign(builder: PsiBuilder) {
        // id = mezzo
        parseIdentifier(builder)
        parseTypeHint(builder)
    }

    /**
     * 解析mezzo关联类型声明
     * 格式: mezzo TypeName [: Bounds] [= DefaultType],
     */
    private fun parseMezzoDeclaration(builder: PsiBuilder) {

    }


    private fun parseMethod(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = true) // never fail
        parseIdentifier(builder)//
        parseParameterList(builder)
        parseReturnType(builder) // optional
        parseEffect(builder) // optional
        parseBlockStatement(builder) // optional
    }

    private fun parseEffect(builder: PsiBuilder, allowArrow: Boolean = false) {
        if (builder.tokenType == ValkyrieTokenTypes.DIVIDE) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(builder, true)
        }
    }

    private fun parseDomain(builder: PsiBuilder) {
        parseIdentifier(builder)
        parseClassLikeBody(builder)
    }


    private fun parseParameterList(builder: PsiBuilder) {
        parseParameterItem(builder)
    }

    private fun parseParameterItem(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = true)
    }


    /**
     * 解析宏调用
     * 支持: @macro_name, module_path::@macro_name
     */
    private fun parseMacroCall(builder: PsiBuilder) {
        val marker = builder.mark()

        // 宏前缀: @,
        when (builder.tokenType) {
            ValkyrieTokenTypes.AT -> builder.advanceLexer()

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

        parseBlockStatement(builder)
        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
    }

    private fun parseWhileStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        parseBlockStatement(builder)

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
        parseTermExpression(builder, true)

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
            parseTermExpression(builder, false)
        }

        // ':' or '=>'
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ':' or '=>' after case pattern")
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

    private fun parseTryStatement(builder: PsiBuilder) {
        // try {}
        // try type { }
        // is try
        parseTypeExpression(builder, true)
        parseBlockStatement(builder)
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
                parseTermExpression(builder, false) // parse value

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
                            parseTermExpression(builder, false)
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
            parseTermExpression(builder, false)
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
            parseTermExpression(builder, false)
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
            parseTermExpression(builder, false)
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
        parseTermExpression(builder, false)

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
                parseTermExpression(builder, false) // condition

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
        parseTermExpression(builder, false)

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
     * 解析元编程函数声明 (micro, mezzo, macro)
     * 支持匿名函数: micro(a) {} 和具名函数: micro name(a) {}
     */
    private fun parseMacroStatement(builder: PsiBuilder, elementType: IElementType) {

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
                    parseTermExpression(builder, false)
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
        parseTermExpression(builder, false)

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
        parseTermExpression(builder, false)

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

        marker.done(ValkyrieElementTypes.TEMPLATE_WHILE)
    }

    /**
     * 解析模板匹配语句 <$ match ... $>
     */
    private fun parseTemplateMatch(builder: PsiBuilder) {
        val marker = builder.mark()


        marker.done(ValkyrieElementTypes.TEMPLATE_MATCH)
    }

    private fun parseForStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'for'


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

    }


    private fun parseInheritanceList(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer() // consume '('

            // 解析继承列表，允许空继承 class A() {}
            while (builder.tokenType != ValkyrieTokenTypes.RPAREN && !builder.eof()) {
                if (!parseInheritanceItem(builder)) {
                    marker.error("Expected inheritance item")
                    recoverToSyncPoint(builder)
                    return false
                }

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    marker.error("Expected ',' or ')'")
                    recoverToSyncPoint(builder)
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
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
        
        // Parse identifier (required)
        if (!parseIdentifier(builder)) {
            marker.error("Expected type name")
            return false
        }
        
        // Parse optional type hint
        parseTypeHint(builder)
        
        // Parse optional default value
        parseDefaultValue(builder)
        
        marker.done(ValkyrieElementTypes.INHERIT_ITEM)
        return true
    }

    private fun parseImplementation(builder: PsiBuilder): Boolean {
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(builder, true)
            return true
        }
        return false
    }

    /**
     * Annotation = Attributions + Modifiers
     * */
    private fun parseAnnotations(builder: PsiBuilder, withModifiers: Boolean): Boolean {
        val annotationMarker = builder.mark()
        var hasAnnotations = false

        // 解析若干个 attribute node ↯attr 和 attribute list ↯[attr] 混合
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            hasAnnotations = true
            // 解析 attribute list
            if (builder.lookAhead(1) == ValkyrieTokenTypes.LBRACKET) {
                // ↯[attr1, attr2, ...]
                val listMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯
                builder.advanceLexer() // 消费 [

                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
                    val attrMarker = builder.mark()
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        parseQualifiedName(builder)
                        // 可选的参数列表
                        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                            parseAttributeNode(builder, true)
                        }
                        attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                    } else {
                        attrMarker.error("Expected attribute name")
                        recoverToSyncPoint(builder)
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

                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    parseQualifiedName(builder)
                    // 可选的参数列表
                    if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                        parseAttributeNode(builder, false)
                    }
                    attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                } else {
                    attrMarker.error("Expected attribute name")
                    recoverToSyncPoint(builder)
                    break
                }
            }
        }

        // 如果 withModifiers 为 true，解析结尾的 mod ids
        if (withModifiers) {
            var hasModifiers = false

            // 解析所有的 mod id
            while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD ||
                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW
            ) {
                hasModifiers = true
                // 解析 mod id
                val modMarker = builder.mark()
                builder.advanceLexer() // consume identifier
                modMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
            }

            if (hasAnnotations || hasModifiers) {
                annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
                return true
            } else {
                annotationMarker.drop()
                return false
            }
        } else {
            if (hasAnnotations) {
                annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
                return true
            } else {
                annotationMarker.drop()
                return false
            }
        }
    }

    // attribute() {}
    private fun parseAttributeNode(builder: PsiBuilder, allowBody: Boolean) {
        parseIdentifier(builder)
        parseTermArgumentList(builder)
        if (allowBody) {
            parseClassLikeBody(builder)
        }
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

    private fun parseIdentifier(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
            builder.advanceLexer()
            marker.done(ValkyrieElementTypes.IDENTIFIER_NODE)
            return true
        } else {
            marker.drop()
            return false
        }
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
