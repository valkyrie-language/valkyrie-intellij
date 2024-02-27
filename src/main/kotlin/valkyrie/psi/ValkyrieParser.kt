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

    // 递归深度控制
    private var recursionDepth: Int = 0
    private val maxRecursionDepth = 100


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
                ValkyrieTokenTypes.WHITESPACE, ValkyrieTokenTypes.NEWLINE, ValkyrieTokenTypes.COMMENT_REST, ValkyrieTokenTypes.COMMENT_RANGE
            )
        ) {
            builder.advanceLexer()
        }

        if (builder.eof()) return

        val initialOffset = builder.currentOffset

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
                ValkyrieTokenTypes.FLAGS -> parseEnumsStatement(builder)
                ValkyrieTokenTypes.TRAIT -> parseTraitStatement(builder)
                ValkyrieTokenTypes.IMPLY -> parseImplyStatement(builder)
                ValkyrieTokenTypes.STRUCTURE -> parseStructureStatement(builder)
                ValkyrieTokenTypes.MICRO -> parseMicroStatement(builder)
                ValkyrieTokenTypes.MEZZO -> parseMezzoStatement(builder)
                ValkyrieTokenTypes.MACRO -> parseMacroStatement(builder)
                ValkyrieTokenTypes.TESTS -> parseTestsStatement(builder)
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
                ValkyrieTokenTypes.LBRACE -> parseFunctionLikeBody(builder)
                ValkyrieTokenTypes.COMMENT_DOCUMENT -> parseDocComment(builder)
                ValkyrieTokenTypes.AT -> parseMacroCall(builder)
                ValkyrieTokenTypes.LABEL_MARK -> parseLabelMark(builder)
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
        val marker = builder.mark()

        // Parse annotations and modifiers
        parseAnnotations(builder, withModifiers = true)

        // Parse identifier
        if (!parseIdentifier(builder)) {
            marker.error("Expected identifier after 'let'")
            recoverToSyncPoint(builder)
            return
        }

        // Parse optional type annotation
        parseTypeHint(builder)

        // Parse assignment if present
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer() // consume '='
            if (!parseTermExpression(builder, false)) {
                marker.error("Expected expression after '='")
                recoverToSyncPoint(builder)
                return
            }
        }

        marker.done(ValkyrieElementTypes.LET_STATEMENT)
    }

    private fun parseMicroStatement(builder: PsiBuilder) {
        return parseFunctionLikeStatement(builder, ValkyrieElementTypes.DECLARE_MICRO)

    }

    private fun parseMezzoStatement(builder: PsiBuilder) {
        return parseFunctionLikeStatement(builder, ValkyrieElementTypes.DECLARE_MEZZO)
    }

    private fun parseMacroStatement(builder: PsiBuilder) {
        return parseFunctionLikeStatement(builder, ValkyrieElementTypes.DECLARE_MACRO)
    }

    private fun parseTestsStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        // 解析 tests 关键字
        if (builder.tokenType == ValkyrieTokenTypes.TESTS) {
            builder.advanceLexer()
        } else {
            builder.error("Expected 'tests' keyword")
            marker.drop()
            return
        }

        // 解析可选的标识符
        if (!parseIdentifier(builder)) {
            // 标识符解析失败，继续处理
        }

        // 解析泛型参数（如果有）
        parseGenericParameterList(builder)

        // tests { } - 使用class-like body解析
        if (!parseClassLikeBody(builder)) {
            marker.error("Expected tests body")
            recoverToSyncPoint(builder)
            marker.done(ValkyrieElementTypes.ERROR_ELEMENT)
            return
        }
        
        marker.done(ValkyrieElementTypes.DECLARE_TESTS)
    }


    // f(t, u)
    private fun parseTermArgumentList(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer()

            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                parseTermArgumentItem(builder)

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                } else if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    break
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
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

        if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON && builder.lookAhead(1) == ValkyrieTokenTypes.LESS) {
            builder.advanceLexer() // consume '::'
            builder.advanceLexer() // consume '<'

            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.GREATER) {
                parseTypeArgumentItem(builder)

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                } else if (builder.tokenType != ValkyrieTokenTypes.GREATER) {
                    break
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.GREATER) {
                builder.advanceLexer()
            } else {
                builder.error("Expected '>'")
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
    private fun parseExpressionStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 解析表达式
        if (!parseTermExpression(builder, false)) {
            marker.error("Expected expression")
            recoverToSyncPoint(builder)
            return
        }

        marker.done(ValkyrieElementTypes.EXPRESSION_STATEMENT)
    }

    private fun parseTermExpression(builder: PsiBuilder, inline: Boolean): Boolean {
        return parseTermExpressionWithPrecedence(builder, 0)
    }

    private fun parseTermExpressionWithPrecedence(builder: PsiBuilder, minPrecedence: Int): Boolean {
        // 解析前缀表达式
        var left = parsePrefixTermExpression(builder)
        if (left == null) {
            return false
        }

        // 解析中缀表达式
        while (true) {
            val tokenType = builder.tokenType
            val precedence = getTermOperatorPrecedence(tokenType)

            if (precedence < minPrecedence) {
                break
            }

            // 检查是否是中缀操作符
            if (!isTermInfixOperator(tokenType)) {
                break
            }

            val marker = left?.precede() ?: return false
            builder.advanceLexer() // 消费操作符

            // 解析右操作数
            if (!parseTermExpressionWithPrecedence(builder, precedence + 1)) {
                marker.error("Expected right operand")
                recoverToSyncPoint(builder)
                return false
            }

            marker.done(ValkyrieElementTypes.BINARY_EXPRESSION)
            left = marker
        }

        // 解析后缀表达式
        left = parsePostfixTermExpression(builder, left)

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
        var current = left

        while (true) {
            val tokenType = builder.tokenType

            if (!isTermPostfixOperator(tokenType)) {
                break
            }

            val marker = current.precede()
            builder.advanceLexer() // 消费后缀操作符

            when (tokenType) {
                ValkyrieTokenTypes.EXCLAMATION, ValkyrieTokenTypes.WOW -> {
                    marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
                    current = marker
                }

                ValkyrieTokenTypes.WHAT -> {
                    marker.done(ValkyrieElementTypes.UNARY_EXPRESSION)
                    current = marker
                }

                ValkyrieTokenTypes.LPAREN -> {
                    // 函数调用
                    parseTermArgumentList(builder)
                    if (!builder.eof() && builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                        builder.advanceLexer()
                    } else {
                        marker.error("Expected ')'")
                        return current
                    }
                    marker.done(ValkyrieElementTypes.CALL_EXPRESSION)
                    current = marker
                }

                ValkyrieTokenTypes.LBRACKET -> {
                    // 数组访问
                    if (!parseTermExpression(builder, false)) {
                        marker.error("Expected index expression")
                        return current
                    }
                    if (!builder.eof() && builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                        builder.advanceLexer()
                    } else {
                        marker.error("Expected ']'")
                        return current
                    }
                    marker.done(ValkyrieElementTypes.POSTFIX_EXPRESSION)
                    current = marker
                }

                ValkyrieTokenTypes.DOT -> {
                    // 成员访问
                    if (!parseIdentifier(builder)) {
                        marker.error("Expected identifier after '.'")
                        return current
                    }
                    marker.done(ValkyrieElementTypes.DOT_EXPRESSION)
                    current = marker
                }

                else -> break
            }
        }

        return current
    }

    private fun isTermPrefixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.EXCLAMATION, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.AMPERSAND -> true

            else -> false
        }
    }

    private fun isTermInfixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.STAR, ValkyrieTokenTypes.MULTIPLY, ValkyrieTokenTypes.DIVIDE, ValkyrieTokenTypes.INTEGER_DIVIDE, ValkyrieTokenTypes.PERCENT, ValkyrieTokenTypes.POWER, ValkyrieTokenTypes.EQUAL, ValkyrieTokenTypes.NOT_EQUAL, ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER, ValkyrieTokenTypes.LESS_EQUAL, ValkyrieTokenTypes.GREATER_EQUAL, ValkyrieTokenTypes.LOGIC_AND, ValkyrieTokenTypes.LOGIC_OR, ValkyrieTokenTypes.LOGIC_XOR, ValkyrieTokenTypes.LOGIC_NAND, ValkyrieTokenTypes.LOGIC_NOR, ValkyrieTokenTypes.LOGIC_XAND, ValkyrieTokenTypes.PIPE, ValkyrieTokenTypes.AMPERSAND, ValkyrieTokenTypes.AS, ValkyrieTokenTypes.IN, ValkyrieTokenTypes.NOT_IN, ValkyrieTokenTypes.IS, ValkyrieTokenTypes.IS_NOT -> true

            else -> false
        }
    }

    private fun isTermPostfixOperator(tokenType: IElementType?): Boolean {
        return when (tokenType) {
            ValkyrieTokenTypes.EXCLAMATION, ValkyrieTokenTypes.WOW, ValkyrieTokenTypes.WHAT, ValkyrieTokenTypes.LPAREN, ValkyrieTokenTypes.LBRACKET, ValkyrieTokenTypes.DOT -> true

            else -> false
        }
    }

    private fun getTermOperatorPrecedence(tokenType: IElementType?): Int {
        return operatorPrecedenceCache[tokenType] ?: 0
    }

    private fun parsePrimaryTerm(builder: PsiBuilder): PsiBuilder.Marker? {
        val tokenType = builder.tokenType

        return when (tokenType) {
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
            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.BOOLEAN, ValkyrieTokenTypes.STRING, ValkyrieTokenTypes.MULTI_QUOTE_STRING, ValkyrieTokenTypes.UNIT_NUMBER -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.LITERAL_EXPRESSION)
                marker
            }

            // 括号表达式
            ValkyrieTokenTypes.LPAREN -> {
                val marker = builder.mark()
                builder.advanceLexer() // 消费 '('

                if (!parseTermExpression(builder, false)) {
                    marker.error("Expected expression")
                    return null
                }

                if (builder.tokenType == ValkyrieTokenTypes.RPAREN) {
                    builder.advanceLexer() // 消费 ')'
                } else {
                    marker.error("Expected ')'")
                    return null
                }

                marker.done(ValkyrieElementTypes.PARENTHESIZED_EXPRESSION)
                marker
            }

            // 数组表达式
            ValkyrieTokenTypes.LBRACKET -> {
                val marker = builder.mark()
                builder.advanceLexer() // 消费 '['

                // 解析数组元素
                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
                    if (!parseTermExpression(builder, false)) {
                        marker.error("Expected expression")
                        return null
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
                        marker.error("Expected ',' or ']'")
                        return null
                    }
                }

                if (builder.tokenType == ValkyrieTokenTypes.RBRACKET) {
                    builder.advanceLexer() // 消费 ']'
                } else {
                    marker.error("Expected ']'")
                    return null
                }

                marker.done(ValkyrieElementTypes.ARRAY_EXPRESSION)
                marker
            }

            // 块表达式
            ValkyrieTokenTypes.LBRACE -> {
                val marker = builder.mark()
                parseFunctionLikeBody(builder)
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
        var left = parsePrefixTypeExpression(builder)
        if (left == null) {
            return false
        }

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
                ValkyrieTokenTypes.EXCLAMATION, ValkyrieTokenTypes.WOW -> {
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
            ValkyrieTokenTypes.EXCLAMATION, // 非空类型 T!
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
                if (builder.tokenType == ValkyrieTokenTypes.LESS) {
                    parseGenericParameterList(builder)
                }

                marker.done(ValkyrieElementTypes.TYPE_REFERENCE)
                marker
            }

            ValkyrieTokenTypes.LPAREN -> {
                // 括号类型表达式 (T)
                val marker = builder.mark()
                builder.advanceLexer() // 消费 (

                if (!parseTypeExpression(builder, false)) {
                    marker.error("Expected type expression")
                    recoverToSyncPoint(builder)
                    return null
                }

                if (builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                    marker.error("Expected ')'")
                    recoverToSyncPoint(builder)
                    return null
                }

                builder.advanceLexer() // 消费 )
                marker.done(ValkyrieElementTypes.PARENTHESIZED_TYPE)
                marker
            }

            ValkyrieTokenTypes.LBRACKET -> {
                // 数组类型 [T]
                val marker = builder.mark()
                builder.advanceLexer() // 消费 [

                if (!parseTypeExpression(builder, false)) {
                    marker.error("Expected type expression")
                    recoverToSyncPoint(builder)
                    return null
                }

                if (builder.tokenType != ValkyrieTokenTypes.RBRACKET) {
                    marker.error("Expected ']'")
                    recoverToSyncPoint(builder)
                    return null
                }

                builder.advanceLexer() // 消费 ]
                marker.done(ValkyrieElementTypes.ARRAY_TYPE)
                marker
            }

            ValkyrieTokenTypes.LBRACE -> {
                // 元组类型 {T, U}
                val marker = builder.mark()
                builder.advanceLexer() // 消费 {

                // 解析类型列表
                if (builder.tokenType != ValkyrieTokenTypes.RBRACE) {
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
                    } while (builder.tokenType != ValkyrieTokenTypes.RBRACE)
                }

                if (builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                    marker.error("Expected '}'")
                    recoverToSyncPoint(builder)
                    return null
                }

                builder.advanceLexer() // 消费 }
                marker.done(ValkyrieElementTypes.TUPLE_TYPE)
                marker
            }

            // 基本类型关键字
            ValkyrieTokenTypes.BOOLEAN, ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.STRING -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.PRIMITIVE_TYPE)
                marker
            }

            else -> null
        }
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

        parseNamePath(builder, free = true)

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
        parseNamePath(builder, free = true)

        // 支持嵌套using语法: using package.collections.{ hashmap.HashMap }
        if (builder.tokenType == ValkyrieTokenTypes.DOT) {
            builder.advanceLexer() // consume '.'

            if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
                builder.advanceLexer() // consume '{'

                // 解析导入列表
                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                    parseNamePath(builder, free = true)

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
            val initialPosition = builder.currentOffset
            parseClassLikeItem(builder)

            // 防止无限循环：确保解析器前进
            if (builder.currentOffset == initialPosition) {
                builder.error("Unable to parse class member")
                builder.advanceLexer()
            }

            // Skip to next valid token if parsing failed
            if (builder.tokenType != ValkyrieTokenTypes.RBRACE && !builder.eof()) {
                if (syncTokens.contains(builder.tokenType)) {
                    break
                }
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




    private fun parseUnionLikeStatement(builder: PsiBuilder, node: ValkyrieElementType) {
        val marker = builder.mark()

        parseAnnotations(builder, withModifiers = false)
        parseIdentifier(builder)
        parseGenericParameterList(builder) // optional
        parseInheritanceList(builder)       // optional
        parseImplementation(builder)        // optional
        parseUnionLikeBody(builder)

        marker.done(node)
    }

    private fun parseUnionLikeBody(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()

            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                val initialPosition = builder.currentOffset
                parseUnionLikeItem(builder)

                // 防止无限循环：确保解析器前进
                if (builder.currentOffset == initialPosition) {
                    builder.error("Unable to parse union member")
                    builder.advanceLexer()
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
                builder.advanceLexer()
            } else {
                builder.error("Expected '}'")
            }

            marker.done(ValkyrieElementTypes.UNION_BODY)
        } else {
            marker.drop()
        }
    }

    private fun parseUnionLikeItem(builder: PsiBuilder) {
        val marker = builder.mark()

        parseAnnotations(builder, withModifiers = false)

        when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD -> {
                parseVariant(builder)
                marker.done(ValkyrieElementTypes.UNION_VARIANT)
            }

            else -> {
                parseMethod(builder)
                marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
            }
        }
    }

    private fun parseVariant(builder: PsiBuilder) {
        parseIdentifier(builder)
        parseClassLikeBody(builder) // optional
    }

    private fun parseFlagsStatement(builder: PsiBuilder) {
        parseEnumerateLikeStatement(builder, ValkyrieElementTypes.FLAGS_STATEMENT)
    }

    private fun parseEnumsStatement(builder: PsiBuilder) {
        parseEnumerateLikeStatement(builder, ValkyrieElementTypes.ENUMS_STATEMENT)
    }

    private fun parseEnumerateLikeStatement(builder: PsiBuilder, node: ValkyrieElementType) {
        val marker = builder.mark()

        parseAnnotations(builder, withModifiers = false)
        parseIdentifier(builder)
        parseGenericParameterList(builder) // optional
        parseInheritanceList(builder)       // optional
        parseEnumerateLikeBody(builder)

        marker.done(node)
    }

    private fun parseEnumerateLikeBody(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()

            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
                val initialPosition = builder.currentOffset
                parseEnumerateLikeItem(builder)

                // 防止无限循环：确保解析器前进
                if (builder.currentOffset == initialPosition) {
                    builder.error("Unable to parse enumerate member")
                    builder.advanceLexer()
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
                builder.advanceLexer()
            } else {
                builder.error("Expected '}'")
            }

            marker.done(ValkyrieElementTypes.OBJECT_BODY)
        } else {
            marker.drop()
        }
    }

    private fun parseEnumerateLikeItem(builder: PsiBuilder) {
        val marker = builder.mark()

        parseAnnotations(builder, withModifiers = false)

        when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER_STD -> {
                parseSemantic(builder)
                marker.done(ValkyrieElementTypes.FLAGS_ITEM)
            }

            else -> {
                parseMethod(builder)
                marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
            }
        }
    }

    private fun parseSemantic(builder: PsiBuilder) {
        parseIdentifier(builder)
        parseDefaultValue(builder) // optional
    }

    private fun parseImplyStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        parseAnnotations(builder, withModifiers = false)
        parseNamePath(builder, free = false) // impl module::Type
        parseImplementation(builder) // impl module::Type: Trait
        parseClassLikeBody(builder)

        marker.done(ValkyrieElementTypes.IMPLY_STATEMENT)
    }


    private fun parseGenericArgumentList(builder: PsiBuilder, typeLevel: Boolean) {
        // term level 支持两种泛型语法 ⟨T⟩ 和 ::<T>
        // type level 额外支持一种 <T>
        val marker = builder.mark()

        val startToken = when {
            builder.tokenType == ValkyrieTokenTypes.ANGLE_L -> ValkyrieTokenTypes.ANGLE_L
            builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON && builder.lookAhead(1) == ValkyrieTokenTypes.ANGLE_L -> {
                builder.advanceLexer() // consume '::'
                ValkyrieTokenTypes.ANGLE_L
            }

            else -> {
                marker.drop()
                return
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
            builder.advanceLexer() // consume '<'

            // Parse first argument
            if (!parseGenericArgumentItem(builder)) {
                marker.error("Expected generic argument")
                marker.drop()
                return
            }

            // Parse remaining arguments
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','
                if (!parseGenericArgumentItem(builder)) {
                    marker.error("Expected generic argument after ','")
                    marker.drop()
                    return
                }
            }

            // Expect closing '>'
            if (builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
                builder.advanceLexer() // consume '>'
            } else {
                marker.error("Expected '>' to close generic argument list")
                marker.drop()
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

        if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
            builder.advanceLexer() // consume '<'

            // Parse first parameter
            if (!parseGenericParameterItem(builder)) {
                marker.error("Expected generic parameter")
                marker.drop()
                return false
            }

            // Parse additional parameters
            while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer() // consume ','
                if (!parseGenericParameterItem(builder)) {
                    marker.error("Expected generic parameter after ','")
                    marker.drop()
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.ANGLE_R) {
                builder.advanceLexer() // consume '>'
                marker.done(ValkyrieElementTypes.GENERIC_PARAMETER_LIST)
                return true
            } else {
                marker.error("Expected '>'")
                marker.drop()
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
            marker.drop()
            return false
        }

        // Parse optional type constraint
        parseTypeHint(builder)

        // Parse optional default type
        parseDefaultType(builder)

        marker.done(ValkyrieElementTypes.GENERIC_PARAMETER)
        return true
    }


    private fun parseFunctionLikeStatement(builder: PsiBuilder, node: ValkyrieElementType) {
        val marker = builder.mark()

        parseAnnotations(builder, withModifiers = true)
        parseIdentifier(builder)
        parseGenericParameterList(builder) // micro f<T>(), optional
        parseParameterList(builder)        // micro f()
        parseReturnType(builder)           // optional return type
        parseEffect(builder)               // optional effect
        parseFunctionLikeBody(builder)

        marker.done(node)
    }

    private fun parseFunctionLikeBody(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            val initialPosition = builder.currentOffset
            parseStatement(builder)

            // 防止死循环：确保解析器位置有前进
            if (builder.currentOffset == initialPosition && !builder.eof()) {
                builder.error("Parser stuck at position ${initialPosition}")
                builder.advanceLexer() // 强制前进
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.BLOCK_BODY)
    }


    private fun parseClassLikeItem(builder: PsiBuilder) {
        val marker = builder.mark()

        // 跳过空白和注释
        while (builder.tokenType in setOf(
                ValkyrieTokenTypes.WHITESPACE, ValkyrieTokenTypes.NEWLINE,
                ValkyrieTokenTypes.COMMENT_REST, ValkyrieTokenTypes.COMMENT_RANGE
            )
        ) {
            builder.advanceLexer()
        }

        if (builder.eof() || builder.tokenType == ValkyrieTokenTypes.RBRACE) {
            marker.drop()
            return
        }

        val initialPos = builder.currentOffset
        
        // 所有item都以annotation开头
        val annotationsResult = parseAnnotations(builder, withModifiers = true)
        
        // 根据annotation后的token类型选择合适的解析方法
        when (builder.tokenType) {
            ValkyrieTokenTypes.AT -> {
                parseMacroCallMember(builder)
                if (builder.currentOffset > initialPos) {
                    marker.done(ValkyrieElementTypes.MACRO_CALL)
                } else {
                    marker.error("Failed to parse macro call")
                }
            }

            ValkyrieTokenTypes.MICRO, ValkyrieTokenTypes.MEZZO, ValkyrieTokenTypes.MACRO -> {
                parseMethod(builder)
                if (builder.currentOffset > initialPos) {
                    marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
                } else {
                    marker.error("Failed to parse method")
                }
            }

            ValkyrieTokenTypes.IDENTIFIER_STD, ValkyrieTokenTypes.IDENTIFIER_RAW -> {
                // 可能是字段或方法，需要前瞻判断
                if (isMethodDeclaration(builder)) {
                    parseMethod(builder)
                    if (builder.currentOffset > initialPos) {
                        marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
                    } else {
                        marker.error("Failed to parse method")
                    }
                } else {
                    parseField(builder)
                    if (builder.currentOffset > initialPos) {
                        marker.done(ValkyrieElementTypes.FIELD_DECLARATION)
                    } else {
                        marker.error("Failed to parse field")
                    }
                }
            }

            ValkyrieTokenTypes.COMMA, ValkyrieTokenTypes.SEMICOLON -> {
                builder.advanceLexer() // 跳过分隔符
                marker.drop()
            }

            else -> {
                // 未知token，创建错误节点并消费该token
                builder.error("Unexpected token in class body: ${builder.tokenType}")
                builder.advanceLexer() // 关键：消费无法识别的token
                marker.done(ValkyrieElementTypes.ERROR_ELEMENT)
            }
        }
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

    private fun parseField(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = true) // never fail

        if (!parseIdentifier(builder)) {
            builder.error("Expected field name")
            return
        }

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
        parseIdentifier(builder)
        parseTypeHint(builder)
        parseDefaultType(builder)
    }

    private fun parseMethod(builder: PsiBuilder) {
        parseAnnotations(builder, withModifiers = true) // never fail

        if (!parseIdentifier(builder)) {
            builder.error("Expected method name")
            return
        }

        parseParameterList(builder)
        parseReturnType(builder) // optional
        parseEffect(builder) // optional
        parseFunctionLikeBody(builder) // optional
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
        if (!parseNamePath(builder, free = false)) {
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

        parseFunctionLikeBody(builder)
        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
    }

    private fun parseWhileStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        parseFunctionLikeBody(builder)

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
        parseTermExpression(builder, inline = true)
        parseMatchBody(builder)
        marker.done(ValkyrieElementTypes.MATCH_STATEMENT)
    }

    private fun parseMatchBody(builder: PsiBuilder) {
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
        // check try
        parseTypeExpression(builder, true)
        parseFunctionLikeBody(builder)
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
        parseTermExpression(builder, inline = true)
        parseMatchBody(builder)

        marker.done(ValkyrieElementTypes.CATCH_STATEMENT)
    }

    private fun parsePattern(builder: PsiBuilder): Boolean {
        // one of
        parseIdentifier(builder)
        parseTuplePattern(builder)
        parseTablePattern(builder)
        parseObjectPattern(builder)
        return false
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

    private fun parseTuplePattern(builder: PsiBuilder) {
        // (a, b, c)
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
    private fun parseTablePattern(builder: PsiBuilder) {

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

    private fun parseObjectPattern(builder: PsiBuilder) {
        // Class { a: b}
    }


    private fun parseLabelMark(builder: PsiBuilder) {
        val marker = builder.mark()

        // consume '※'
        if (builder.tokenType == ValkyrieTokenTypes.LABEL_MARK) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '※'")
        }
        // optional
        parseIdentifier(builder)
        marker.done(ValkyrieElementTypes.LABEL_STATEMENT)
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


    private fun parseReturnStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'return'

        // Check for optional label
        parseLabelMark(builder)

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON && builder.tokenType != ValkyrieTokenTypes.NEWLINE && !builder.eof()) {
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
            if (!parseIdentifier(builder)) {
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
            if (!parseIdentifier(builder)) {
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
            if (!parseIdentifier(builder)) {
                builder.error("Expected label name after ※")
            }
        }

        // Parse optional expression
        if (builder.tokenType != ValkyrieTokenTypes.SEMICOLON && builder.tokenType != ValkyrieTokenTypes.NEWLINE && !builder.eof()) {
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
    }

    private fun parseIfStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        // consume 'if'
        // Parse optional else/else if clauses
        parseTermExpression(builder, inline = true)
        parseFunctionLikeBody(builder)
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
    }

    private fun parseElseIfStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        // consume 'else'
        // consume 'if'
        parseTermExpression(builder, inline = true)
        parseFunctionLikeBody(builder)
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
    }


    private fun parseElseStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        builder.advanceLexer() // consume 'else'
        parseFunctionLikeBody(builder)

        marker.done(ValkyrieElementTypes.IF_STATEMENT)
    }


    private fun parseIfLetStatement(builder: PsiBuilder, marker: PsiBuilder.Marker) {
        builder.advanceLexer() // consume 'let'

        // consume 'if'
        // consume 'let'
        // Parse optional else/else if clauses
        parseTermExpression(builder, inline = true)
        parseFunctionLikeBody(builder)
        marker.done(ValkyrieElementTypes.IF_LET_STATEMENT)
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
    }

    /**
     * 解析模板条件语句 <$ if ... $>
     */
    private fun parseTemplateIf(builder: PsiBuilder) {
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
    }

    /**
     * 解析模板循环语句 <$ for ... $>
     */
    private fun parseTemplateFor(builder: PsiBuilder) {
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
            parseFunctionLikeBody(builder)
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
                    if (!parseIdentifier(builder)) {
                        attrMarker.error("Expected attribute name")
                        recoverToSyncPoint(builder)
                    } else {
                        // 可选的参数列表
                        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                            parseAttributeNode(builder, true)
                        }
                        attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
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

                if (!parseIdentifier(builder)) {
                    attrMarker.error("Expected attribute name")
                    recoverToSyncPoint(builder)
                    break
                } else {
                    // 可选的参数列表
                    if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
                        parseAttributeNode(builder, false)
                    }
                    attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                }
            }
        }

        // 如果 withModifiers 为 true，解析结尾的 mod ids
        if (withModifiers) {
            var hasModifiers = false

            // 解析所有的 mod id
            while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD || builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW) {
                hasModifiers = true
                // 解析 mod id
                val modMarker = builder.mark()
                if (!parseIdentifier(builder)) {
                    modMarker.error("expected modifier identifier")
                    break
                }
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

    /**
     * 判断当前位置是否为方法声明
     * 通过前瞻判断是否有参数列表
     */
    private fun isMethodDeclaration(builder: PsiBuilder): Boolean {
        var lookahead = 1

        // 跳过标识符
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_STD ||
            builder.tokenType == ValkyrieTokenTypes.IDENTIFIER_RAW
        ) {

            // 检查是否有泛型参数 <T>
            if (builder.lookAhead(lookahead) == ValkyrieTokenTypes.ANGLE_L) {
                lookahead++
                var depth = 1
                while (depth > 0 && lookahead < 10) { // 限制前瞻深度
                    val token = builder.lookAhead(lookahead)
                    when (token) {
                        ValkyrieTokenTypes.ANGLE_L -> depth++
                        ValkyrieTokenTypes.ANGLE_R -> depth--
                        null -> break
                    }
                    lookahead++
                }
            }

            // 检查是否有参数列表 ()
            return builder.lookAhead(lookahead) == ValkyrieTokenTypes.LPAREN
        }

        return false
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
    ValkyrieTokenTypes.PIPE to 3,
    ValkyrieTokenTypes.AMPERSAND to 4,
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
