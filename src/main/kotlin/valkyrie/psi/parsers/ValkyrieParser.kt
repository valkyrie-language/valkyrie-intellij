package valkyrie.psi.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenType
import valkyrie.psi.lexers.ValkyrieTokenTypes


/**
 * Valkyrie 手写语法分析器
 * 包含性能优化和错误恢复机制
 */
open class ValkyrieParser : PsiParser {
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
    fun recoverToSyncPoint(builder: PsiBuilder) {
        while (!builder.eof() && builder.tokenType !in syncTokens) {
            builder.advanceLexer()
        }
    }

    fun parseStatement(builder: PsiBuilder): Boolean {
        val safePoint = builder.currentOffset
        when {
            // modules
            parseNamespaceStatement(builder) -> return true
            parseUsingStatement(builder) -> return true
            // tests
            parseTestsStatement(builder) -> return true
            // product types
            parseClassStatement(builder) -> return true
            parseStructureStatement(builder) -> return true
            parseSingletonStatement(builder) -> return true
            parseWidgetStatement(builder) -> return true
            parseNeuralStatement(builder) -> return true
            // traits
            parseTraitStatement(builder) -> return true
            parseImplyStatement(builder) -> return true
            // sum types
            parseUnionStatement(builder) -> return true
            parseUnityStatement(builder) -> return true
            // number types
            parseFlagsStatement(builder) -> return true
            parseEnumsStatement(builder) -> return true
            // variables
            parseLetStatement(builder, inline = false) -> return true
            // functions
            parseMicroStatement(builder) -> return true
            parseMezzoStatement(builder) -> return true
            parseMezzoAssign(builder) -> return true
            parseMacroStatement(builder) -> return true
            parseMacroAssignment(builder) -> return true
            parseControlFlow(this, builder) -> return true
            builder.tokenType == null -> return true
            else -> parseExpressionStatement(builder)
        }
        if (builder.currentOffset == safePoint) {
            builder.error("Unexpected token: ${builder.tokenType}")
            builder.advanceLexer()
        }
        return true
    }

    fun parseNamespaceStatement(builder: PsiBuilder): Boolean {
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

    fun parseUsingStatement(builder: PsiBuilder): Boolean {
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

    fun parseUsingBody(builder: PsiBuilder): Boolean {
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
    fun parseUsingNamePath(builder: PsiBuilder): Boolean {
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
            if (nextToken == ValkyrieTokenTypes.SYMBOL_XID || nextToken == ValkyrieTokenTypes.SYMBOL_RAW) {
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

    fun parseClassStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.CLASS, ValkyrieElementTypes.CLASS_STATEMENT)
    }

    fun parseTraitStatement(builder: PsiBuilder): Boolean {
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

        parseGenericParameterList(this, builder) // optional

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


    fun parseTraitExpression(builder: PsiBuilder): Boolean {
        // Parse trait expression like A + B + C
        if (!parseTypeExpression(this, builder, false)) {
            return false
        }

        // Parse additional traits with '+' operator
        while (builder.tokenType == ValkyrieTokenTypes.PLUS) {
            builder.advanceLexer() // consume '+'
            if (!parseTypeExpression(this, builder, false)) {
                return false
            }
        }

        return true
    }

    fun parseNeuralStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.NEURAL, ValkyrieElementTypes.NEURAL_STATEMENT)
    }

    fun parseWidgetStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.WIDGET, ValkyrieElementTypes.WIDGET_STATEMENT)
    }

    fun parseSingletonStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.SINGLETON, ValkyrieElementTypes.SINGLETON_STATEMENT)
    }

    fun parseStructureStatement(builder: PsiBuilder): Boolean {
        return parseClassLikeStatements(builder, ValkyrieTokenTypes.STRUCTURE, ValkyrieElementTypes.STRUCTURE_STATEMENT)
    }

    fun parseUnionStatement(builder: PsiBuilder): Boolean {
        return parseUnionLikeStatement(builder, ValkyrieTokenTypes.UNION, ValkyrieElementTypes.UNION_STATEMENT)
    }

    fun parseUnityStatement(builder: PsiBuilder): Boolean {
        return parseUnionLikeStatement(builder, ValkyrieTokenTypes.UNITY, ValkyrieElementTypes.UNITY_STATEMENT)
    }

    fun parseLetStatement(builder: PsiBuilder, inline: Boolean): Boolean {
        val marker = builder.mark()
        if (!inline) {
            parseAnnotations(builder, withModifiers = false)
        }
        if (!builder.consumeKeyword(ValkyrieTokenTypes.LET)) {
            marker.rollbackTo()
            return false
        }
        // Parse pattern (supports bare pattern, tuple pattern, array pattern, object pattern)
        if (!parsePattern(this, builder, true)) {
            marker.error("Expected pattern after 'let'")
            return true
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
            marker.done(ValkyrieElementTypes.LET_STATEMENT)
        }
        return true
    }

    fun parseMicroStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTokenTypes.MICRO, ValkyrieElementTypes.DECLARE_MICRO)

    }

    fun parseMezzoStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTokenTypes.MEZZO, ValkyrieElementTypes.DECLARE_MEZZO)
    }

    fun parseMacroStatement(builder: PsiBuilder): Boolean {
        return parseFnLikeStatement(builder, ValkyrieTokenTypes.MACRO, ValkyrieElementTypes.DECLARE_MACRO)
    }

    fun parseMacroAssignment(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.MACRO) return false
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
            if (!parseGenericParameterList(this, builder)) {
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
        if (!parseTermExpression(this, builder, false)) {
            marker.error("Expected expression after '='")
            return true
        }

        marker.done(ValkyrieElementTypes.ASSIGN_MACRO)
        return true
    }

    fun parseTestsStatement(builder: PsiBuilder): Boolean {
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


    // term expression with optional semicolon
    fun parseExpressionStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        // 解析表达式
        if (!parseTermExpression(this, builder, false)) {
            marker.error("Expected expression")
            recoverToSyncPoint(builder)
            return false
        }
        // 吃掉可选的 `;`
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.EXPRESSION_STATEMENT)
        return true
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
                builder.error("Infinite loop detected in `parseObjectBody`")
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
        marker.done(node)
        return true
    }

    fun parseUnionBody(builder: PsiBuilder): Boolean {
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


    fun parseVariant(builder: PsiBuilder): Boolean {
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

    fun parseFlagsStatement(builder: PsiBuilder): Boolean {
        return parseEnumerateLikeStatement(builder, ValkyrieTokenTypes.FLAGS, ValkyrieElementTypes.FLAGS_STATEMENT)
    }

    fun parseEnumsStatement(builder: PsiBuilder): Boolean {
        return parseEnumerateLikeStatement(builder, ValkyrieTokenTypes.EIDOS, ValkyrieElementTypes.EIDOS_STATEMENT)
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

    fun parseSemanticItem(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (!parseIdentifier(builder)) {
            marker.drop()
            return false
        }
        parseDefaultValue(builder, false) // optional

        // 处理可选的分号
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        }

        marker.done(ValkyrieElementTypes.FLAGS_ITEM)
        return true
    }

    fun parseImplyStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (builder.tokenType != ValkyrieTokenTypes.IMPLY) {
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
        if (!parseObjectBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(ValkyrieElementTypes.IMPLY_STATEMENT)
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
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) return false
        val marker = builder.mark()
        builder.advanceLexer()

        while (!builder.eof()) {
            val safePoint = builder.currentOffset
            when {
                builder.tokenType == ValkyrieTokenTypes.BRACE_R -> break
                // variables
                parseLetStatement(builder, inline = false) -> continue
                // controls
                parseControlStatement(builder) -> continue
                // term expressions
                else -> parseExpressionStatement(builder)
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

    fun parseTypeHint(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            val marker = builder.mark()
            // consume ':'
            builder.advanceLexer()
            parseTypeExpression(this, builder, false)
            marker.done(ValkyrieElementTypes.TYPE_HINT)
        }
    }

    fun parseDefaultType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            val marker = builder.mark()
            builder.advanceLexer()
            parseTypeExpression(this, builder, false)
            marker.done(ValkyrieElementTypes.DEFAULT_TYPE)
        }
    }

    fun parseReturnType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON || builder.tokenType == ValkyrieTokenTypes.ARROW) {
            val marker = builder.mark()
            // consume '->'
            builder.advanceLexer()
            parseTypeExpression(this, builder, true)
            marker.done(ValkyrieElementTypes.RETURN_TYPE)
        }
    }

    fun parseEffectType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.SLASH) {
            val marker = builder.mark()
            builder.advanceLexer() // consume '/'
            parseTypeExpression(this, builder, true)
            marker.done(ValkyrieElementTypes.EFFECT_TYPE)
        }
    }

    fun parseImplementationType(builder: PsiBuilder) {
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeExpression(this, builder, true)
        }
    }

    fun parseDefaultValue(builder: PsiBuilder, inline: Boolean): Boolean {
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            val marker = builder.mark()
            builder.advanceLexer()
            if (!parseTermExpression(this, builder, inline)) {
                marker.error("Expected expression after '='")
                return false
            }
            marker.done(ValkyrieElementTypes.DEFAULT_VALUE)
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
        marker.done(ValkyrieElementTypes.FIELD_DECLARATION)
        return true
    }

    fun parseMethod(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = true) // never fail

        if (!parseIdentifier(builder)) {
            marker.rollbackTo()
            return false
        }
        if (!parseFunctionParameterList(this, builder)) {
            marker.rollbackTo()
            return false
        }

        parseReturnType(builder) // optional
        parseEffectType(builder) // optional
        parseFnBody(builder) // optional

        marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
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
        marker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
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

    fun parseDocComment(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.COMMENT_DOCUMENT) return false
        val marker = builder.mark()

        builder.advanceLexer()
        marker.done(ValkyrieElementTypes.DOC_COMMENT)
        return true
    }

    fun parseUntilStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.UNTIL) return false
        val marker = builder.mark()

        parseFnBody(builder)
        marker.done(ValkyrieElementTypes.UNTIL_STATEMENT)
        return true
    }

    fun parseWhileStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.WHILE) return false
        val marker = builder.mark()

        parseFnBody(builder)

        marker.done(ValkyrieElementTypes.WHILE_STATEMENT)
        return true
    }

    fun parseMatchStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        if (builder.tokenType != ValkyrieTokenTypes.MATCH) return false
        // 'match' keyword
        builder.advanceLexer()

        // expression to match
        parseTermExpression(this, builder, inline = true)
        parseMatchBody(builder)
        marker.done(ValkyrieElementTypes.MATCH_STATEMENT)
        return true
    }

    fun parseMatchBody(builder: PsiBuilder) {
        val marker = builder.mark()
        if (builder.tokenType == ValkyrieTokenTypes.BRACE_L) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '{' for match body")
            marker.drop()
            return
        }

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

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}' for match body")
        }
        marker.done(ValkyrieElementTypes.MATCH_BODY) // Assuming a new element type for match body
    }

    fun parseMatchCase(builder: PsiBuilder) {
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
        parsePattern(this, builder, true)

        // optional guard condition
        if (builder.tokenType == ValkyrieTokenTypes.IF) {
            builder.advanceLexer()
            parseTermExpression(this, builder, false)
        }

        // ':'
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ':' after case pattern")
        }

        // case body
        parseTermExpression(this, builder, false)

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

    fun parseElseClause(builder: PsiBuilder) {
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
        parseTermExpression(this, builder, false)

        marker.done(ValkyrieElementTypes.WHEN_CLAUSE) // reuse WHEN_CLAUSE for else
    }

    fun parseTryStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.TRY) return false
        // try {}
        // try type { }
        // check try
        parseTypeExpression(this, builder, true)
        parseFnBody(builder)
        return true
    }

    fun parseCatchStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.CATCH) return false
        val marker = builder.mark()

        // 'catch' keyword
        builder.advanceLexer()

        // optional error variable
        parseTermExpression(this, builder, inline = true)
        parseMatchBody(builder)

        marker.done(ValkyrieElementTypes.CATCH_STATEMENT)
        return true
    }

    fun parseControlStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, false)
        when (builder.tokenType) {

            ValkyrieTokenTypes.BREAK -> {
                builder.advanceLexer()
                parseLabelMark(builder)
                parseTermExpression(this, builder, false)
                marker.done(ValkyrieElementTypes.BREAK_STATEMENT)
            }

            ValkyrieTokenTypes.CONTINUE -> {
                builder.advanceLexer()
                parseLabelMark(builder)
                parseTermExpression(this, builder, false)
                marker.done(ValkyrieElementTypes.CONTINUE_STATEMENT)
            }
            // return ※label term
            ValkyrieTokenTypes.RETURN -> {
                builder.advanceLexer()
                parseLabelMark(builder)
                parseTermExpression(this, builder, false)
                marker.done(ValkyrieElementTypes.RETURN_STATEMENT)
            }
            // resume term
            ValkyrieTokenTypes.RESUME -> {
                builder.advanceLexer()
//                parseLabelMark(builder)
                parseTermExpression(this, builder, false)
                marker.done(ValkyrieElementTypes.RESUME_STATEMENT)
            }


            ValkyrieTokenTypes.RAISE -> {
                builder.advanceLexer()
                parseLabelMark(builder)
                parseTermExpression(this, builder, false)
                marker.done(ValkyrieElementTypes.RAISE_STATEMENT)
            }

            ValkyrieTokenTypes.YIELD -> {
                builder.advanceLexer()
                parseLabelMark(builder)
                parseTermExpression(this, builder, false)
                marker.done(ValkyrieElementTypes.YIELD_STATEMENT)
            }

            else -> {
                marker.rollbackTo()
                return false
            }
        }
        return true
    }

    fun parseIfExpression(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, false)
        if (builder.consumeKeyword(ValkyrieTokenTypes.IF)) {
            marker.rollbackTo()
            return false
        } else {
            builder.advanceLexer()
        }
        // if let pat = expr { }
        if (builder.tokenType == ValkyrieTokenTypes.LET) {
            if (parseLetStatement(builder, true)) {
                marker.rollbackTo()
                return false
            }
        }
        // if conditional { }
        else {
            if (!parseTermExpression(this, builder, inline = true)) {
                marker.error("Expected condition expression after 'if'")
                return false
            }
        }

        // 解析 then 块
        if (!parseFnBody(builder)) {
            marker.error("Expected block after if condition")
            return false
        }

        // 解析 else if 和 else 子句
        parseElseIfStatement(builder)
        parseElseStatement(builder)

        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }

    fun parseIfStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseIfMainPart(builder)
        parseElseIfStatement(builder)
        parseElseStatement(builder)
        marker.done(ValkyrieElementTypes.IF_STATEMENT)
        return true
    }

    fun parseIfTemplate(builder: PsiBuilder): Boolean {
        // 这个函数应该由parseTemplateBlock调用，不需要单独处理TEMPLATE_START
        // 因为模板if-else-end结构是分布在多个独立的模板块中的
        return false
    }

    fun parseIfMainPart(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, false)
        if (builder.consumeKeyword(ValkyrieTokenTypes.IF)) {
            marker.rollbackTo()
            return false
        } else {
            builder.advanceLexer()
        }
        // if let pat = expr { }
        if (builder.tokenType == ValkyrieTokenTypes.LET) {
            if (parseLetStatement(builder, true)) {
                marker.rollbackTo()
                return false
            }
        }
        // if conditional { }
        else {
            if (!parseTermExpression(this, builder, inline = true)) {
                marker.error("Expected condition expression after 'if'")
                return false
            }
        }

        // 解析 then 块
        if (!parseFnBody(builder)) {
            marker.error("Expected block after if condition")
            return false
        }
        marker.done(ValkyrieElementTypes.IF_MAIN_PART)
        return true
    }

    fun parseTemplateIfMark(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.TEMPLATE_L) return false
        val marker = builder.mark()

        // 消费 '<$'
        builder.advanceLexer()

        // 检查是否是 'if'
        if (builder.tokenType != ValkyrieTokenTypes.IF) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume 'if'

        // <$ if let pat = expr
        if (builder.tokenType == ValkyrieTokenTypes.LET) {
            if (!parseLetStatement(builder, true)) {
                marker.error("Expected let statement after 'if let'")
                return false
            }
        }
        // <$ if conditional
        else {
            if (!parseTermExpression(this, builder, false)) {
                marker.error("Expected condition expression after 'if'")
                return false
            }
        }

        // 消费 '$>'
        if (builder.tokenType == ValkyrieTokenTypes.TEMPLATE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '$>'")
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_IF_MARK)
        return true
    }

    fun parseElseIfStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (!builder.consumeKeyword(ValkyrieTokenTypes.ELSE)) {
            marker.rollbackTo()
            return false
        }
        if (!builder.consumeKeyword(ValkyrieTokenTypes.IF)) {
            marker.rollbackTo()
            return false
        }
        if (!parseTermExpression(this, builder, inline = true)) {
            marker.rollbackTo()
            return false
        }
        if (!parseFnBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(ValkyrieElementTypes.ELSE_IF_PART)
        return true
    }

    fun parseTemplateElseIfMark(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.TEMPLATE_L) return false
        val marker = builder.mark()

        // 消费 '<$'
        builder.advanceLexer()

        // 检查是否是 'else'
        if (builder.tokenType != ValkyrieTokenTypes.ELSE) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume 'else'

        // 检查是否是 'else if'
        if (builder.tokenType == ValkyrieTokenTypes.IF) {
            builder.advanceLexer() // consume 'if'

            // 解析条件表达式
            if (!parseTermExpression(this, builder, false)) {
                marker.error("Expected condition expression after 'else if'")
                return false
            }
        }

        // 消费 '$>'
        if (builder.tokenType == ValkyrieTokenTypes.TEMPLATE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '$>'")
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_ELSE_IF)
        return true
    }

    fun parseElseStatement(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        parseAnnotations(builder, withModifiers = false)
        if (!builder.consumeKeyword(ValkyrieTokenTypes.ELSE)) {
            marker.rollbackTo()
            return false
        }
        if (!parseTermExpression(this, builder, inline = true)) {
            marker.rollbackTo()
            return false
        }
        if (!parseFnBody(builder)) {
            marker.rollbackTo()
            return false
        }
        marker.done(ValkyrieElementTypes.ELSE_PART)
        return true
    }

    fun parseTemplateElseMark(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.TEMPLATE_L) return false
        val marker = builder.mark()

        // 消费 '<$'
        builder.advanceLexer()

        // 检查是否是 'else'
        if (builder.tokenType != ValkyrieTokenTypes.ELSE) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // consume 'else'

        // 消费 '$>'
        if (builder.tokenType == ValkyrieTokenTypes.TEMPLATE_R) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '$>'")
        }

        marker.done(ValkyrieElementTypes.TEMPLATE_ELSE)
        return true
    }

    fun parseInheritanceList(builder: PsiBuilder): Boolean {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_L) {
            builder.advanceLexer() // consume '('

            // 解析继承列表，允许空继承 class A() {}
            while (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R && !builder.eof()) {
                if (!parseInheritanceItem(builder)) {
                    marker.error("Expected inheritance item")
                    recoverToSyncPoint(builder)
                    return false
                }

                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != ValkyrieTokenTypes.PARENTHESIS_R) {
                    marker.error("Expected ',' or ')'")
                    recoverToSyncPoint(builder)
                    return false
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_R) {
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

        marker.done(ValkyrieElementTypes.INHERIT_ITEM)
        return true
    }


    /**
     * Annotation = Attributions + Modifiers
     * */
    fun parseAnnotations(builder: PsiBuilder, withModifiers: Boolean): Boolean {
        var hasAnnotations = false
        val annotationMarker = builder.mark()
        // 解析若干个 attribute node ↯attr 和 attribute list ↯[attr] 混合
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            hasAnnotations = true
            // 解析 attribute list
            if (builder.lookAhead(1) == ValkyrieTokenTypes.BRACKET_L) {
                // ↯[attr1, attr2, ...]
                val listMarker = builder.mark()
                builder.advanceLexer() // 消费 ↯
                builder.advanceLexer() // 消费 [

                while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
                    val attrMarker = builder.mark()
                    if (!parseIdentifier(builder)) {
                        attrMarker.error("Expected attribute name")
                        recoverToSyncPoint(builder)
                        break
                    } else {
                        // 可选的参数列表
                        if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_L) {
                            parseAttributeNode(builder, true)
                        }
                        attrMarker.done(ValkyrieElementTypes.ATTRIBUTE)
                    }

                    if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                        builder.advanceLexer()
                    } else if (builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
                        break
                    }
                }

                if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
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
                    if (builder.tokenType == ValkyrieTokenTypes.PARENTHESIS_L) {
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
        while (isIdentifier(builder)) {
            when (builder.lookAhead(1)) {
                ValkyrieTokenTypes.SYMBOL_XID, ValkyrieTokenTypes.SYMBOL_XID,
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

    fun parseNamePath(builder: PsiBuilder, free: Boolean): Boolean {
        val pathMarker = builder.mark()

        // 解析第一个标识符
        if (!parseIdentifier(builder)) {
            // 如果连第一个标识符都没有，这不是一个 namepath
            pathMarker.drop()
            return false
        }

        // 循环解析后续路径段
        while (true) {
            val separator = builder.tokenType
            val isSeparator = separator == ValkyrieTokenTypes.DOUBLE_COLON || (free && separator == ValkyrieTokenTypes.DOT)
            // 【非贪婪检查】只有当 "分隔符" 后面跟着 "标识符" 时，才继续解析
            if (isSeparator && isIdentifier(builder.lookAhead(1))) {
                builder.advanceLexer()
                parseIdentifier(builder)
            } else {
                // 如果不是 `Separator + Identifier` 的组合，路径到此结束
                break
            }
        }

        pathMarker.done(ValkyrieElementTypes.NAMESPACE_PATH)
        return true
    }

    fun parseScopeStatement(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.SCOPE) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume 'scope'

        // Parse optional generic parameters: scope::<T>
        if (builder.tokenType == ValkyrieTokenTypes.DOUBLE_COLON) {
            builder.advanceLexer() // consume '::'
            if (builder.tokenType == ValkyrieTokenTypes.ANGLE_L) {
                parseGenericParameterList(this, builder)
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


    /**
     * 解析字符串字面量
     */
    fun parseString(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.STRING_L) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume STRING_L
        marker.done(ValkyrieElementTypes.STRING_LITERAL)
        return true
    }

    /**
     * 解析数组表达式
     */
    fun parseArrayExpression(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BRACKET_L) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume '['

        // 解析数组元素
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
            if (!parseTermExpression(this, builder, false)) {
                builder.error("Expected expression")
                break
            }
            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTokenTypes.BRACKET_R) {
                builder.error("Expected ',' or ']'")
                break
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACKET_R) {
            builder.advanceLexer() // consume ']'
        } else {
            builder.error("Expected ']'")
        }

        marker.done(ValkyrieElementTypes.ARRAY_EXPRESSION)
        return true
    }

    /**
     * 解析对象表达式
     */
    fun parseObjectExpression(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTokenTypes.BRACE_L) return false
        val marker = builder.mark()
        builder.advanceLexer() // consume '{'

        // 解析对象字段
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
            // 解析键
            if (!parseIdentifier(builder) && builder.tokenType != ValkyrieTokenTypes.STRING_L) {
                builder.error("Expected field name")
                break
            }
            if (builder.tokenType == ValkyrieTokenTypes.STRING_L) {
                builder.advanceLexer()
            }

            if (builder.tokenType == ValkyrieTokenTypes.COLON) {
                builder.advanceLexer() // consume ':'
                if (!parseTermExpression(this, builder, false)) {
                    builder.error("Expected expression")
                    break
                }
            }

            if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                builder.advanceLexer()
            } else if (builder.tokenType != ValkyrieTokenTypes.BRACE_R) {
                builder.error("Expected ',' or '}'")
                break
            }
        }

        if (builder.tokenType == ValkyrieTokenTypes.BRACE_R) {
            builder.advanceLexer() // consume '}'
        } else {
            builder.error("Expected '}'")
        }

        marker.done(ValkyrieElementTypes.TABLE_EXPRESSION)
        return true
    }
}


// 错误恢复同步点
val syncTokens = setOf(
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


fun PsiBuilder.consumeSemicolon(): Boolean {
    if (this.tokenType == ValkyrieTokenTypes.SEMICOLON) {
        this.advanceLexer()
        return true
    } else {
        return false
    }
}

fun isIdentifier(builder: PsiBuilder): Boolean {
    return isIdentifier(builder.tokenType)
}


fun parseXmlTextStatement(builder: PsiBuilder): Boolean {
    // 处理XML文本内容，包括XML_DATA_CHARACTERS和XML_WHITE_SPACE
    if (builder.tokenType != XmlTokenType.XML_DATA_CHARACTERS &&
        builder.tokenType != XmlTokenType.XML_WHITE_SPACE &&
        builder.tokenType != ValkyrieTokenTypes.XML_TEXT
    ) {
        return false
    }

    val marker = builder.mark()

    // 消费XML文本内容
    while (!builder.eof() &&
        (builder.tokenType == XmlTokenType.XML_DATA_CHARACTERS ||
            builder.tokenType == XmlTokenType.XML_WHITE_SPACE ||
            builder.tokenType == ValkyrieTokenTypes.XML_TEXT)
    ) {
        builder.advanceLexer()
    }

    marker.done(ValkyrieElementTypes.XML_TEXT_NODE)
    return true
}


fun isIdentifier(token: IElementType?): Boolean {
    return token == ValkyrieTokenTypes.SYMBOL_XID || token == ValkyrieTokenTypes.SYMBOL_RAW
}

// ※label
fun parseLabelMark(builder: PsiBuilder): Boolean {
    if (builder.tokenType != ValkyrieTokenTypes.LABEL_MARK) return false
    val marker = builder.mark()

    // consume '※'
    builder.advanceLexer()
    // optional
    parseIdentifier(builder)
    marker.done(ValkyrieElementTypes.LABEL_STATEMENT)
    return true
}

fun parseIdentifier(builder: PsiBuilder): Boolean {
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


fun PsiBuilder.consumeKeyword(keyword: ValkyrieTokenType): Boolean {
    if (this.tokenType == keyword) {
        this.advanceLexer()
        return true
    } else {
        return false
    }
}