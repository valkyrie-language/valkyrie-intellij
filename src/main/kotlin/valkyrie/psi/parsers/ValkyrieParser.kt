package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.LightPsiParser
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.parsers.ValkyrieElementType
import valkyrie.psi.lexers.ValkyrieTokenType

// 错误恢复同步点
private val syncTokens = setOf(
    ValkyrieTypes.LET,
    ValkyrieTypes.CLASS,
    ValkyrieTypes.UNION,
    ValkyrieTypes.TRAIT,
    ValkyrieTypes.IMPLY,
    ValkyrieTypes.MICRO,
    ValkyrieTypes.NAMESPACE,
    ValkyrieTypes.USING,
    ValkyrieTypes.SEMICOLON,
    ValkyrieTypes.BRACE_R
)

/**
 * Valkyrie 手写语法分析器
 * 包含性能优化和错误恢复机制
 */
open class ValkyrieParser(public val config: ValkyrieLanguageConfig = ValkyrieLanguageConfig()) : PsiParser, LightPsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        builder.setDebugMode(true)
        val rootMarker = builder.mark()
        parseProgram(builder)
        rootMarker.done(root)
        return builder.treeBuilt
    }

    override fun parseLight(root: IElementType?, builder: PsiBuilder?) {
        TODO("Not yet implemented")
    }

    /**
     * 错误恢复：跳转到下一个同步点
     */
    fun recoverToSyncPoint(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType !in syncTokens) {
            builder.advanceLexer()
        }
    }

    fun parseProgram(builder: PsiBuilder) {
        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                // dialect
                parseStatementExtension(builder) -> continue
                // modules
                parseNamespaceStatement(builder) -> continue
                parseUsingStatement(builder) -> continue
                // tests
                parseTestsStatement(builder) -> continue
                // product types
                parseClassStatement(builder) -> continue
                parseStructureStatement(builder) -> continue
                parseSingletonStatement(builder) -> continue
                parseWidgetStatement(builder) -> continue
                parseNeuralStatement(builder) -> continue
                // traits
                parseTraitStatement(builder) -> continue
                parseImplyStatement(builder) -> continue
                // sum types
                parseUnionStatement(builder) -> continue
                parseUnityStatement(builder) -> continue
                // number types
                parseFlagsStatement(builder) -> continue
                parseEnumsStatement(builder) -> continue
                // variables
                parseLetStatement(builder, inline = false) -> continue
                // functions
                parseMicroStatement(builder) -> continue
                parseMezzoStatement(builder) -> continue
                parseMezzoAssign(builder) -> continue
                parseMacroStatement(builder) -> continue
                parseMacroAssignment(builder) -> continue
                // control flow
                parseControlStatement(this, builder) -> continue
                parseExpressionStatement(builder) -> continue
            }
            if (builder.currentOffset == safePoint) {
                builder.error("Parser stuck in program body")
                builder.advanceLexer()
            }
        }
    }

    protected open fun parseStatementExtension(builder: PsiBuilder): Boolean {
        return false
    }

    fun parseTypeStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseDocComments(builder)
        parseAnnotations(builder, withModifiers = true)
        if (builder.tokenType != ValkyrieTypes.TYPE) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume 'type' or 'typus'

        if (!parseIdentifier(builder)) {
            marker.error("Expected type name")
            return false
        }

        // 泛型参数
        parseGenericParameterList(this, builder)

        if (builder.tokenType == ValkyrieTypes.ASSIGN) {
            builder.advanceLexer()
            if (!parseTypeExpression(this, builder, false)) {
                builder.error("Expected type expression")
            }
        }

        if (builder.tokenType == ValkyrieTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieTypes.TYPE_ALIAS)
        return true
    }

    fun parseNamespaceStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)

        // 支持不同类型: namespace, namespace!, namespace?, namespace*
        when (builder.tokenType) {
            ValkyrieTypes.NAMESPACE -> {
                builder.advanceLexer()
                // 检查namespace变体: !, ?, *
                when (builder.tokenType) {
                    // 主命名空间
                    ValkyrieTypes.WOW -> builder.advanceLexer()
                    // 仅文档空间
                    ValkyrieTypes.WHAT -> builder.advanceLexer()
                    // 仅测试空间
                    ValkyrieTypes.STAR -> builder.advanceLexer()
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
        if (builder.tokenType == ValkyrieTypes.SEMICOLON) {
            builder.advanceLexer()
        } else if (builder.tokenType == ValkyrieTypes.DOUBLE_SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieTypes.NAMESPACE_STATEMENT)
        return true
    }

    fun parseUsingStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)

        // 检查 using 关键字
        if (builder.tokenType != ValkyrieTypes.USING) {
            marker.drop()
            return false
        }

        builder.advanceLexer() // consume 'using'

        // 解析 using 语句的不同格式
        when {
            // using { ... }
            builder.tokenType == ValkyrieTypes.BRACE_L -> {
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
        if (builder.tokenType == ValkyrieTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieTypes.USING_STATEMENT)
        return true
    }

    fun parseUsingItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析基础路径 (a.b.c 或 a::b::c) - 使用专门的using路径解析
        if (!parseUsingNamePath(builder)) {
            marker.drop()
            return false
        }

        // 检查后续的修饰符
        when (builder.tokenType) {
            // using a.*
            ValkyrieTypes.DOT -> {
                builder.advanceLexer() // consume '.'
                if (builder.tokenType == ValkyrieTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTypes.BRACE_L) {
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
            ValkyrieTypes.DOUBLE_COLON -> {
                builder.advanceLexer() // consume '::'
                if (builder.tokenType == ValkyrieTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTypes.BRACE_L) {
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
            ValkyrieTypes.AS -> {
                builder.advanceLexer() // consume 'as'
                if (!parseIdentifier(builder)) {
                    marker.error("Expected identifier after 'as'")
                    return false
                }
            }
            // using a {} 或 using a.c {} 或 using a::b {}
            ValkyrieTypes.BRACE_L -> {
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

        marker.done(ValkyrieTypes.USING_ITEM)
        return true
    }

    fun parseUsingBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        if (builder.tokenType != ValkyrieTypes.BRACE_L) {
            marker.drop()
            return false
        }

        builder.advanceLexer() // consume '{'

        // 解析 body 内容 - 使用简化的解析逻辑避免递归
        while (!builder.eof() && builder.tokenType != ValkyrieTypes.BRACE_R) {
            val initialPosition = builder.currentOffset

            // 解析简单的标识符路径，避免递归调用parseUsingItem
            if (!parseSimpleUsingItemInBody(builder)) {
                // 跳过无法解析的 token
                builder.error("Expected using item")
                builder.advanceLexer()
            }

            // 处理分隔符: , ; 或空格
            when (builder.tokenType) {
                ValkyrieTypes.COMMA, ValkyrieTypes.SEMICOLON -> {
                    builder.advanceLexer()
                }
                // 结束符，不需要处理
                ValkyrieTypes.BRACE_R -> {
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

        if (builder.tokenType == ValkyrieTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
        } else {
            marker.error("Expected '}'")
            return false
        }

        marker.done(ValkyrieTypes.USING_BODY)
        return true
    }

    // 简化的using item解析，专门用于body内部，避免递归
    fun parseSimpleUsingItemInBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析基础路径 (a.b.c 或 a::b::c) - 使用专门的using路径解析
        if (!parseUsingNamePath(builder)) {
            marker.drop()
            return false
        }

        // 检查后续修饰符，支持嵌套body
        when (builder.tokenType) {
            // using a.*
            ValkyrieTypes.DOT -> {
                builder.advanceLexer() // consume '.'
                if (builder.tokenType == ValkyrieTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTypes.BRACE_L) {
                    // using a.{} - 支持嵌套body
                    if (!parseUsingBody(builder)) {
                        marker.error("Expected using body")
                        return false
                    }
                } else {
                    // 不是 .* 或 .{} 的情况，回退并作为简单路径处理
                    marker.done(ValkyrieTypes.USING_ITEM)
                    return true
                }
            }
            // using a::*
            ValkyrieTypes.DOUBLE_COLON -> {
                builder.advanceLexer() // consume '::'
                if (builder.tokenType == ValkyrieTypes.STAR) {
                    builder.advanceLexer() // consume '*'
                } else if (builder.tokenType == ValkyrieTypes.BRACE_L) {
                    // using a::{} - 支持嵌套body
                    if (!parseUsingBody(builder)) {
                        marker.error("Expected using body")
                        return false
                    }
                } else {
                    // 不是 ::* 或 ::{} 的情况，回退并作为简单路径处理
                    marker.done(ValkyrieTypes.USING_ITEM)
                    return true
                }
            }
            // using a as b
            ValkyrieTypes.AS -> {
                builder.advanceLexer() // consume 'as'
                if (!parseIdentifier(builder)) {
                    marker.error("Expected identifier after 'as'")
                    return false
                }
            }
            // using a {} - 支持嵌套body
            ValkyrieTypes.BRACE_L -> {
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

        marker.done(ValkyrieTypes.USING_ITEM)
        return true
    }

    // 专门用于using语句的路径解析，允许不完整路径如 a. 或 a::
    fun parseUsingNamePath(builder: PsiBuilder): Boolean {
        val pathMarker = builder.mark()

        // 解析第一个标识符
        val identifierMarker = builder.mark()
        if (isIdentifier(builder.tokenType)) {
            builder.advanceLexer()
            identifierMarker.done(ValkyrieTypes.IDENTIFIER_NODE)
        } else {
            identifierMarker.error("expected identifier")
            pathMarker.drop()
            return false
        }

        // 解析路径分隔符和后续标识符，允许不完整路径
        while (builder.tokenType == ValkyrieTypes.DOUBLE_COLON || builder.tokenType == ValkyrieTypes.DOT) {
            // 检查分隔符后是否有标识符
            val separator = builder.tokenType
            val nextToken = builder.lookAhead(1)

            // 如果分隔符后是标识符，正常解析
            if (nextToken == ValkyrieTypes.SYMBOL_XID || nextToken == ValkyrieTypes.SYMBOL_RAW) {
                builder.advanceLexer() // 消费分隔符
                val nextIdentifierMarker = builder.mark()
                builder.advanceLexer() // 消费标识符
                nextIdentifierMarker.done(ValkyrieTypes.IDENTIFIER_NODE)
            } else {
                // 分隔符后不是标识符，停止解析路径，让上层处理
                break
            }
        }

        pathMarker.done(ValkyrieTypes.NAMESPACE_PATH)
        return true
    }

    fun parseClassStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTypes.CLASS, ValkyrieTypes.CLASS_STATEMENT)
    }

    fun parseTraitStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        if (builder.tokenType != ValkyrieTypes.TRAIT) {
            marker.drop()
            return false
        }

        builder.advanceLexer() // consume 'trait'

        if (!parseIdentifier(builder)) {
            marker.error("Expected trait name")
            return false
        }

        parseGenericParameterList(this, builder) // optional

        // Check for trait alias (trait C = A + B;)
        if (builder.tokenType == ValkyrieTypes.ASSIGN) {
            builder.advanceLexer() // consume '='

            // Parse trait expression (A + B)
            if (!parseTraitExpression(builder)) {
                marker.error("Expected trait expression after '='")
                return false
            }

            // Expect semicolon
            if (builder.tokenType == ValkyrieTypes.SEMICOLON) {
                builder.advanceLexer()
            }

            marker.done(ValkyrieTypes.TRAIT_ALIAS)
            return true
        } else {
            // Regular trait declaration
            parseInheritanceList(builder) // optional
            parseImplementationType(builder) // optional

            if (parseObjectBody(builder)) {
                builder.consumeSemicolon()
                marker.done(ValkyrieTypes.TRAIT_STATEMENT)
                return true
            } else {
                marker.error("Expected object body")
                return false
            }
        }
    }


    fun parseTraitExpression(builder: PsiBuilder): Boolean {
        // Parse trait expression like A + B + C
        if (!parseTypeExpression(this, builder, false)) {
            return false
        }

        // Parse additional traits with '+' operator
        while (builder.tokenType == ValkyrieTypes.PLUS) {
            builder.advanceLexer() // consume '+'
            if (!parseTypeExpression(this, builder, false)) {
                return false
            }
        }

        return true
    }

    fun parseNeuralStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTypes.NEURAL, ValkyrieTypes.NEURAL_STATEMENT)
    }

    fun parseWidgetStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTypes.WIDGET, ValkyrieTypes.WIDGET_STATEMENT)
    }

    fun parseSingletonStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTypes.SINGLETON, ValkyrieTypes.SINGLETON_STATEMENT)
    }

    fun parseStructureStatement(builder: PsiBuilder): Boolean {
        // 如果不允许旧的 struct 语法，那么直接返回 false
        if (!config.allow_legacy_struct) {
            return false
        }
        return parseClassLikeStatements(builder, ValkyrieTypes.STRUCTURE, ValkyrieTypes.STRUCTURE_STATEMENT)
    }

    fun parseUnionStatement(builder: PsiBuilder): Boolean {
        return parseUnionLikeStatement(builder, ValkyrieTypes.UNION, ValkyrieTypes.UNION_STATEMENT)
    }

    fun parseUnityStatement(builder: PsiBuilder): Boolean {
        return parseUnionLikeStatement(builder, ValkyrieTypes.UNITY, ValkyrieTypes.UNITY_STATEMENT)
    }

    fun parseLetStatement(builder: PsiBuilder, inline: Boolean): Boolean {
        if (!inline && builder.tokenType != ValkyrieTypes.LET && builder.tokenType != ValkyrieTypes.ATTRIBUTE_LOWER) {
            return false
        }
        if (inline && builder.tokenType != ValkyrieTypes.LET) {
            return false
        }
        val marker = builder.mark()
        if (!inline) {
            parseAnnotations(builder, withModifiers = false)
        }
        if (!builder.consumeKeyword(ValkyrieTypes.LET)) {
            marker.rollbackTo()
            return false
        }
        // Parse pattern (supports bare pattern, tuple pattern, array pattern, object pattern)
        if (!parsePattern(this, builder, true)) {
            marker.error("Expected pattern after 'let'")
            return false
        }
        // Parse optional type annotation
        parseTypeHint(builder)

        // if let a = b
        if (inline) {
            // must
            if (!parseDefaultValue(builder, true)) {
                marker.error("Expected pattern after 'let'")
                return false
            }
            marker.drop()
        }
        // let a = b;
        else {
            // optional
            parseDefaultValue(builder, false)
            builder.consumeSemicolon()
            marker.done(ValkyrieTypes.LET_STATEMENT)
        }
        return true
    }

    fun parseMicroStatement(builder: PsiBuilder): Boolean {
        // 如果不允许旧的 function 语法，那么直接返回 false
        if (!config.allow_legacy_function) {
            return false
        }
        return parseFnLikeStatement(builder, ValkyrieTypes.MICRO, ValkyrieTypes.DECLARE_MICRO)
    }

    fun parseMezzoStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTypes.MEZZO, ValkyrieTypes.DECLARE_MEZZO)
    }

    fun parseMacroStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTypes.MACRO, ValkyrieTypes.DECLARE_MACRO)
    }

    fun parseMacroAssignment(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.MACRO) return false
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        // Consume 'macro' keyword
        builder.advanceLexer()

        // Parse identifier with error recovery
        if (!parseIdentifier(builder)) {
            marker.error("Expected macro name")
            return false
        }

        // Optional generic parameters
        if (builder.tokenType == ValkyrieTypes.GENERIC_L) {
            if (!parseGenericParameterList(this, builder)) {
                marker.error("Invalid generic parameters")
                return false
            }
        }

        // Expect assignment with error recovery
        if (builder.tokenType != ValkyrieTypes.ASSIGN) {
            marker.error("Expected '=' in macro assignment")
            return false
        }
        builder.advanceLexer() // consume '='

        // Parse expression with error recovery
        if (!parseTermExpression(this, builder, false)) {
            marker.error("Expected expression after '='")
            return false
        }

        marker.done(ValkyrieTypes.ASSIGN_MACRO)
        return true
    }

    fun parseTestsStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)

        // consume `tests`
        if (builder.tokenType == ValkyrieTypes.TESTS) {
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
        marker.done(ValkyrieTypes.DECLARE_TESTS)
        return true
    }


    // term expression with optional semicolon
    fun parseExpressionStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析表达式
        if (!parseTermExpression(this, builder, false)) {
            marker.rollbackTo()
            return false
        }
        // 吃掉可选的 `;`
        if (builder.tokenType == ValkyrieTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieTypes.EXPRESSION_STATEMENT)
        return true
    }

    public open fun parseExpressionExtension(builder: PsiBuilder): Boolean {
        return false
    }

    fun parseClassLikeStatements(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
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

        parseGenericParameterList(this, builder) // optional
        parseInheritanceList(builder) // optional
        parseImplementationType(builder) // optional

        if (parseObjectBody(builder)) {
            builder.consumeSemicolon()
            marker.done(node)
            return true
        } else {
            marker.error("Expected object body")
            recoverToSyncPoint(builder)
            return false
        }
    }

    fun parseObjectBody(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        // Expect opening brace
        if (builder.tokenType != ValkyrieTypes.BRACE_L) {
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
                builder.tokenType == ValkyrieTypes.BRACE_R -> {
                    break
                }
                // 跳过分隔符
                builder.tokenType == ValkyrieTypes.COMMA -> {
                    builder.advanceLexer()
                    continue
                }

                builder.tokenType == ValkyrieTypes.SEMICOLON -> {
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
                    marker.done(ValkyrieTypes.ERROR_ELEMENT)
                }
            }
            if (builder.currentOffset == safePoint) {
                builder.error("Infinite loop detected in `parseObjectBody`")
                builder.advanceLexer() // 强制前进
            }
        }

        if (builder.tokenType == ValkyrieTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
            marker.done(ValkyrieTypes.OBJECT_BODY)
            return true
        } else {
            marker.error("Expected '}'")
            return false
        }
    }

    fun parseUnionLikeStatement(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
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
        parseGenericParameterList(this, builder) // optional
        parseInheritanceList(builder)      // optional
        parseImplementationType(builder)   // optional
        if (!parseUnionBody(builder)) {
            marker.rollbackTo()
            return false
        }
        builder.consumeSemicolon()
        marker.done(node)
        return true
    }

    fun parseUnionBody(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.BRACE_L) {
            return false
        }
        val marker = builder.mark()
        builder.advanceLexer()
        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTypes.BRACE_R -> break
                builder.tokenType == ValkyrieTypes.COMMA -> {
                    builder.advanceLexer()
                    continue
                }

                builder.tokenType == ValkyrieTypes.SEMICOLON -> {
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

        if (builder.tokenType == ValkyrieTypes.BRACE_R) {
            builder.advanceLexer()
            marker.done(ValkyrieTypes.UNION_BODY)
            return true
        } else {
            builder.error("Expected '}'")
            return false
        }
    }


    fun parseVariant(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        parseObjectBody(builder) // optional

        // 处理可选的分隔符（逗号或分号）
        if (builder.tokenType == ValkyrieTypes.COMMA || builder.tokenType == ValkyrieTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieTypes.UNION_VARIANT)
        return true
    }

    fun parseFlagsStatement(builder: PsiBuilder): Boolean {
        return parseEnumerateLikeStatement(builder, ValkyrieTypes.FLAGS, ValkyrieTypes.FLAGS_STATEMENT)
    }

    fun parseEnumsStatement(builder: PsiBuilder): Boolean {
        return parseEnumerateLikeStatement(builder, ValkyrieTypes.EIDOS, ValkyrieTypes.EIDOS_STATEMENT)
    }

    fun parseEnumerateLikeStatement(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
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

    fun parseEnumerateBody(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.BRACE_L) {
            return false
        }
        val marker = builder.mark()
        builder.advanceLexer()

        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTypes.BRACE_R -> break
                // 允许孤立的逗号或分号，作为成员之间的分隔符
                builder.tokenType == ValkyrieTypes.COMMA || builder.tokenType == ValkyrieTypes.SEMICOLON -> {
                    builder.advanceLexer()
                    continue
                }
                parseSemanticItem(builder) -> continue
            }

            // 防止无限循环：确保解析器前进
            if (builder.currentOffset == safePoint) {
                builder.error("Unable to parse enumerate member")
                builder.advanceLexer()
            }
        }

        if (builder.tokenType == ValkyrieTypes.BRACE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
            marker.drop()
            return false
        }

        marker.done(ValkyrieTypes.OBJECT_BODY)
        return true
    }

    fun parseSemanticItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        // 这里需要包含文档注释的解析，否则文档注释会被留在外面
        parseDocComments(builder)
        parseAnnotations(builder, withModifiers = false)
        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        parseDefaultValue(builder, false) // optional

        // 如果后面跟着逗号或分号，也一并消费掉
        if (builder.tokenType == ValkyrieTypes.COMMA || builder.tokenType == ValkyrieTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieTypes.FLAGS_ITEM)
        return true
    }

    private fun parseDocComments(builder: PsiBuilder) {
        while (builder.tokenType == ValkyrieTypes.COMMENT_DOCUMENT) {
            val marker = builder.mark()
            builder.advanceLexer()
            marker.done(ValkyrieTypes.DOC_COMMENT)
        }
    }

    fun parseImplyStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        // parseAnnotations(builder, withModifiers = false)
        if (builder.tokenType != ValkyrieTypes.IMPLY) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume 'imply'
        parseGenericParameterList(this, builder)
        // impl module::Type
        if (!parseNamePath(builder, free = true)) {
            marker.rollbackTo()
            return false
        }
        // impl module::Type: Trait
        parseImplementationType(builder)
        
        if (builder.tokenType == ValkyrieTypes.BRACE_L) {
            if (parseObjectBody(builder)) {
                builder.consumeSemicolon()
            } else {
                builder.error("Expected object body")
            }
        } else {
            builder.error("Expected '{' after imply statement")
        }

        marker.done(ValkyrieTypes.IMPLY_STATEMENT)
        return true
    }


    fun parseFnLikeStatement(builder: PsiBuilder, keyword: ValkyrieTokenType, node: ValkyrieElementType): Boolean {
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
        parseGenericParameterList(this, builder) // micro f<T>(), optional
        // micro f()
        if (!parseFunctionParameterList(this, builder)) {
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

    fun parseFnBody(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.BRACE_L) {
            return false
        }
        val marker = builder.mark()
        builder.advanceLexer() // eat '{'
        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTypes.BRACE_R -> break
                parseLetStatement(builder, inline = false) -> continue
                parseControlStatement(this, builder) -> continue
                parseExpressionStatement(builder) -> continue
            }
            if (builder.currentOffset == safePoint) {
                builder.error("Parser stuck in function body")
                builder.advanceLexer()
            }
        }
        // fine
        if (builder.tokenType == ValkyrieTypes.BRACE_R) {
            builder.advanceLexer() // eat '}'
        }
        // ok but missing '}'
        else {
            builder.error("Expected '}' to end function body")
        }
        marker.done(ValkyrieTypes.FUNCTION_BODY)
        return true
    }

    fun parseTypeHint(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTypes.COLON) {
            val marker = builder.mark()
            // consume ':'
            builder.advanceLexer()
            parseTypeExpression(this, builder, false)
            marker.done(ValkyrieTypes.TYPE_HINT)
        }
    }

    fun parseDefaultType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTypes.ASSIGN) {
            val marker = builder.mark()
            builder.advanceLexer()
            parseTypeExpression(this, builder, false)
            marker.done(ValkyrieTypes.DEFAULT_TYPE)
        }
    }

    fun parseReturnType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTypes.COLON || builder.tokenType == ValkyrieTypes.ARROW) {
            val marker = builder.mark()
            // consume '->'
            builder.advanceLexer()
            parseTypeExpression(this, builder, true)
            marker.done(ValkyrieTypes.RETURN_TYPE)
        }
    }

    fun parseEffectType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTypes.SLASH) {
            val marker = builder.mark()
            builder.advanceLexer() // consume '/'
            parseTypeExpression(this, builder, true)
            marker.done(ValkyrieTypes.EFFECT_TYPE)
        }
    }

    fun parseImplementationType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(this, builder, true)
        }
    }

    fun parseDefaultValue(builder: PsiBuilder, inline: Boolean): Boolean {
        if (builder.tokenType == ValkyrieTypes.ASSIGN) {
            val marker = builder.mark()
            builder.advanceLexer()
            if (!parseTermExpression(this, builder, inline)) {
                marker.error("Expected expression after '='")
                return false
            }
            marker.done(ValkyrieTypes.DEFAULT_VALUE)
            return true
        }
        return false
    }

    /**
     * 解析mezzo关联类型声明
     * 格式: mezzo TypeName [: Bounds] [= DefaultType],
     */
    fun parseMezzoAssign(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (builder.tokenType == ValkyrieTypes.MEZZO) {
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
        marker.done(ValkyrieTypes.ASSIGN_MEZZO)
        return true
    }

    fun parseField(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true)
        if (parseIdentifier(builder)) {
            // continue
        } else {
            marker.rollbackTo()
            return false
        }
        parseTypeHint(builder)
        parseDefaultValue(builder, false)
        marker.done(ValkyrieTypes.FIELD_DECLARATION)
        return true
    }

    fun parseMethod(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true) // never fail

        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }

        // 支持泛型方法: apply<A, B>(...)
        if (builder.tokenType == ValkyrieTypes.ANGLE_L || builder.tokenType == ValkyrieTypes.GENERIC_L) {
            parseGenericParameterList(this, builder)
        }

        if (!parseFunctionParameterList(this, builder)) {
            marker.rollbackTo()
            return false
        }

        parseReturnType(builder) // optional
        parseEffectType(builder) // optional
        parseFnBody(builder) // optional

        marker.done(ValkyrieTypes.METHOD_DECLARATION)
        return true
    }

    fun parseDomain(builder: PsiBuilder): Boolean {
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
        marker.done(ValkyrieTypes.DOMAIN_DECLARATION)
        return true
    }


    /**
     * 解析宏调用
     * 支持: @macro_name, @module_path::macro_name
     */
    fun parseMacroCall(builder: PsiBuilder, withAnnotation: Boolean): Boolean {
        val marker = builder.mark()
        if (withAnnotation) {
            parseAnnotations(builder, withModifiers = false)
        }
        val token = builder.tokenType
        when (token) {
            ValkyrieTypes.AT, ValkyrieTypes.ATTRIBUTE_UPPER, ValkyrieTypes.ATTRIBUTE_LOWER -> {
                builder.advanceLexer()
            }
            else -> {
                marker.rollbackTo()
                return false
            }
        }
        if (parseNamePath(builder, free = false)) {
            // continue
        } else {
            builder.error("Expected macro name")
            marker.drop()
            return false
        }
        
        if (builder.tokenType == ValkyrieTypes.PARENTHESIS_L) {
            parseAttributeNode(builder, true)
        } else if (builder.tokenType == ValkyrieTypes.BRACE_L) {
            parseObjectBody(builder)
        }
        
        marker.done(ValkyrieTypes.MACRO_CALL)
        return true
    }

    fun parseDocComment(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.COMMENT_DOCUMENT) return false
        val marker = builder.mark()

        builder.advanceLexer()
        marker.done(ValkyrieTypes.DOC_COMMENT)
        return true
    }

    fun parseInheritanceList(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTypes.PARENTHESIS_L) {
            builder.advanceLexer() // consume '('

            // 解析继承列表，允许空继承 class A() {}
            while (builder.tokenType != ValkyrieTypes.PARENTHESIS_R && !builder.eof()) {
                if (!parseInheritanceItem(builder)) {
                    marker.error("Expected inheritance item")
                    recoverToSyncPoint(builder)
                    return false
                }

                if (builder.tokenType == ValkyrieTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != ValkyrieTypes.PARENTHESIS_R) {
                    marker.error("Expected ',' or ')'")
                    recoverToSyncPoint(builder)
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTypes.PARENTHESIS_R) {
                builder.advanceLexer() // consume ')'
                marker.done(ValkyrieTypes.INHERIT_LIST)
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

    fun parseInheritanceItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // Parse annotations and modifiers
        parseAnnotations(builder, withModifiers = true)

        // Parse type expression (支持 namepath 如 package::inheritors::A)
        if (!parseTypeExpression(this, builder, false)) {
            marker.error("Expected type expression")
            return false
        }

        // Parse optional type hint
        parseTypeHint(builder)

        // Parse optional default value
        parseDefaultValue(builder, false)

        marker.done(ValkyrieTypes.INHERIT_ITEM)
        return true
    }


    /**
     * Annotation = Attributions + Modifiers
     * */
    fun parseAnnotations(builder: PsiBuilder, withModifiers: Boolean): Boolean {
        var hasAnnotations = false
        val annotationMarker = builder.mark()
        // 解析若干个 attribute node ↯attr 和 attribute list ↯[attr] 混合
        while (builder.tokenType == ValkyrieTypes.ATTRIBUTE_LOWER) {
            hasAnnotations = true
            // 解析 attribute list
            if (builder.lookAhead(1) == ValkyrieTypes.BRACKET_L) {
                // ↯[attr1, attr2, ...]
                val listMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯
                builder.advanceLexer() // 消费 [

                while (!builder.eof() && builder.tokenType != ValkyrieTypes.BRACKET_R) {
                    val attrMarker = builder.mark()
                    if (!parseIdentifier(builder)) {
                        attrMarker.error("Expected attribute name")
                        recoverToSyncPoint(builder)
                        break
                    } else {
                        // 可选的参数列表
                        if (builder.tokenType == ValkyrieTypes.PARENTHESIS_L) {
                            parseAttributeNode(builder, true)
                        }
                        attrMarker.done(ValkyrieTypes.ATTRIBUTE)
                    }

                    if (builder.tokenType == ValkyrieTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTypes.BRACKET_R) {
                        break
                    }
                }

                if (builder.tokenType == ValkyrieTypes.BRACKET_R) {
                    builder.advanceLexer()
                    listMarker.done(ValkyrieTypes.ATTRIBUTE_LIST)
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
                    if (builder.tokenType == ValkyrieTypes.PARENTHESIS_L) {
                        parseAttributeNode(builder, false)
                    }
                    attrMarker.done(ValkyrieTypes.ATTRIBUTE)
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
            annotationMarker.done(ValkyrieTypes.ANNOTATION_NODE)
        } else {
            annotationMarker.drop()
        }
        return true
    }

    // attribute() {}
    fun parseAttributeNode(builder: PsiBuilder, allowBody: Boolean) {
        parseIdentifier(builder)
        parseFunctionArgumentList(this, builder)
        if (allowBody) {
            parseObjectBody(builder)
        }
    }

    fun parseModifierList(builder: PsiBuilder): Boolean {
        var hasModifiers = false
        // 吃掉所有的 identifier
        while (isIdentifier(builder.tokenType)) {
            when (builder.lookAhead(1)) {
                ValkyrieTypes.SYMBOL_XID, ValkyrieTypes.SYMBOL_XID,
                ValkyrieTypes.MICRO, ValkyrieTypes.MEZZO, ValkyrieTypes.MACRO,
                ValkyrieTypes.CLASS, ValkyrieTypes.STRUCTURE, ValkyrieTypes.SINGLETON,
                ValkyrieTypes.UNION, ValkyrieTypes.UNITY,
                ValkyrieTypes.FLAGS, ValkyrieTypes.EIDOS,
                ValkyrieTypes.TESTS -> {
                    val modMarker = builder.mark()
                    builder.advanceLexer()
                    modMarker.done(ValkyrieTypes.MODIFIER_NODE)
                    hasModifiers = true
                }

                else -> break
            }
        }
        return hasModifiers
    }

    fun parseNamePath(builder: PsiBuilder, free: Boolean): Boolean {
        val pathMarker = builder.mark()

        // 解析第一个标识符
        if (!parseIdentifier(builder)) {
            // 如果连第一个标识符都没有，这不是一个 namepath
            pathMarker.drop()
            return false
        }

        // 循环解析后续路径段
        while (!builder.eof()) {
            val separator = builder.tokenType
            val isSeparator = separator == ValkyrieTypes.DOUBLE_COLON || (free && separator == ValkyrieTypes.DOT)
            // 【非贪婪检查】只有当 "分隔符" 后面跟着 "标识符" 时，才继续解析
            if (isSeparator && isIdentifier(builder.lookAhead(1))) {
                builder.advanceLexer()
                parseIdentifier(builder)
            } else {
                // 如果不是 `Separator + Identifier` 的组合，路径到此结束
                break
            }
        }

        pathMarker.done(ValkyrieTypes.NAMESPACE_PATH)
        return true
    }

    fun parseScopeStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.SCOPE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'scope'

        // Parse optional generic parameters: scope::<T>
        if (builder.tokenType == ValkyrieTypes.DOUBLE_COLON) {
            builder.advanceLexer() // consume '::'
            if (builder.tokenType == ValkyrieTypes.ANGLE_L) {
                parseGenericParameterList(this, builder)
            }
        }

        // Parse the block body
        if (!parseFnBody(builder)) {
            marker.error("Expected block after 'scope'")
            return false
        }

        marker.done(ValkyrieTypes.SCOPE_STATEMENT)
        return true
    }


    /**
     * 解析字符串字面量
     */
    fun parseString(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.STRING_L) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume STRING_L
        marker.done(ValkyrieTypes.STRING_LITERAL)
        return true
    }

    /**
     * 解析多部分字符串 (STRING_START, STRING_TEXT, STRING_END)
     */
    fun parseMultiPartString(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.STRING_START) return false
        val marker = builder.mark()
        
        // 消费 STRING_START
        builder.advanceLexer()
        
        // 消费 STRING_TEXT (如果存在)
        if (builder.tokenType == ValkyrieTypes.STRING_TEXT) {
            builder.advanceLexer()
        }
        
        // 消费 STRING_END
        if (builder.tokenType == ValkyrieTypes.STRING_END) {
            builder.advanceLexer()
        } else {
            builder.error("Expected string end")
        }
        
        marker.done(ValkyrieTypes.STRING_LITERAL)
        return true
    }

    /**
     * 解析数组表达式
     */
    fun parseArrayExpression(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.BRACKET_L) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume '['

        // 解析数组元素
        while (!builder.eof() && builder.tokenType != ValkyrieTypes.BRACKET_R) {
            if (!parseTermExpression(this, builder, false)) {
                builder.error("Expected expression")
                break
            }
            if (builder.tokenType == ValkyrieTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTypes.BRACKET_R) {
                builder.error("Expected ',' or ']'")
                break
            }
        }

        if (builder.tokenType == ValkyrieTypes.BRACKET_R) {
            builder.advanceLexer() // consume ']'
        } else {
            builder.error("Expected ']'")
        }

        marker.done(ValkyrieTypes.ARRAY_EXPRESSION)
        return true
    }

    /**
     * 解析对象表达式
     */
    fun parseObjectExpression(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.BRACE_L) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume '{'

        // 解析对象字段
        while (!builder.eof() && builder.tokenType != ValkyrieTypes.BRACE_R) {
            // 解析键
            if (!parseIdentifier(builder) && builder.tokenType != ValkyrieTypes.STRING_L) {
                builder.error("Expected field name")
                break
            }
            if (builder.tokenType == ValkyrieTypes.STRING_L) {
                builder.advanceLexer()
            }

            if (builder.tokenType == ValkyrieTypes.COLON) {
                builder.advanceLexer() // consume ':'
                if (!parseTermExpression(this, builder, false)) {
                    builder.error("Expected expression")
                    break
                }
            }

            if (builder.tokenType == ValkyrieTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTypes.BRACE_R) {
                builder.error("Expected ',' or '}'")
                break
            }
        }

        if (builder.tokenType == ValkyrieTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieTypes.TABLE_EXPRESSION)
        return true
    }



    companion object {

    }
}


public fun isIdentifier(builder: PsiBuilder): Boolean {
    return isIdentifier(builder.tokenType)
}

public fun isIdentifier(token: IElementType?): Boolean {
    return token == ValkyrieTypes.SYMBOL_XID ||
            token == ValkyrieTypes.SYMBOL_RAW ||
            token == ValkyrieTypes.KW_SELF ||
            token == ValkyrieTypes.KW_SELF_TYPE
}

public fun parseIdentifier(builder: PsiBuilder): Boolean {
    val marker = builder.mark()
    if (isIdentifier(builder.tokenType)) {
        builder.advanceLexer()
        marker.done(ValkyrieTypes.IDENTIFIER_NODE)
        return true
    } else {
        marker.drop()
        return false
    }
}

public fun PsiBuilder.consumeKeyword(keyword: ValkyrieTokenType): Boolean {
    if (this.tokenType == keyword) {
        this.advanceLexer()
        return true
    } else {
        return false
    }
}

public fun PsiBuilder.consumeSemicolon(): Boolean {
    if (this.tokenType == ValkyrieTypes.SEMICOLON) {
        this.advanceLexer()
        return true
    } else {
        return false
    }
}
