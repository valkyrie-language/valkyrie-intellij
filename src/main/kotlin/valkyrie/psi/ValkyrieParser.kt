package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

/**
 * Valkyrie 手写语法分析器
 */
class ValkyrieParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()

        while (!builder.eof()) {
            parseStatement(builder)
        }

        rootMarker.done(root)
        return builder.treeBuilt
    }

    private fun parseStatement(builder: PsiBuilder) {
        // 首先检查是否有attributes
        val hasAttributes = builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER

        if (hasAttributes) {
            parseAttributeList(builder)
        }

        when (builder.tokenType) {
            ValkyrieTokenTypes.LET -> parseLetStatement(builder)
            ValkyrieTokenTypes.CLASS -> parseClassStatement(builder)
            ValkyrieTokenTypes.UNION -> parseUnionStatement(builder)
            ValkyrieTokenTypes.TRAIT -> parseTraitStatement(builder)
            ValkyrieTokenTypes.NAMESPACE -> parseNamespaceStatement(builder)
            ValkyrieTokenTypes.USING -> parseUsingStatement(builder)
            ValkyrieTokenTypes.LBRACE -> parseBlockStatement(builder)
            ValkyrieTokenTypes.WHITESPACE, ValkyrieTokenTypes.NEWLINE -> builder.advanceLexer()
            ValkyrieTokenTypes.LINE_COMMENT, ValkyrieTokenTypes.BLOCK_COMMENT -> builder.advanceLexer()
            ValkyrieTokenTypes.AT -> parseMacroCall(builder)
            null -> return
            else -> parseExpressionStatement(builder)
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val patternMarker = builder.mark()
            builder.advanceLexer()
            patternMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
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

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
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
        var left = parsePrimaryExpression(builder)

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

    private fun parsePrimaryExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        return when (builder.tokenType) {
            ValkyrieTokenTypes.IDENTIFIER -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(ValkyrieElementTypes.IDENTIFIER_EXPRESSION)
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

            ValkyrieTokenTypes.MINUS, ValkyrieTokenTypes.NOT -> {
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
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            builder.advanceLexer()
        } else {
            builder.error("Expected type name")
            builder.advanceLexer() // 推进词法分析器避免死循环
        }

        marker.done(ValkyrieElementTypes.TYPE_REFERENCE)
    }

    private fun getOperatorPrecedence(tokenType: IElementType?): Int {
        return when (tokenType) {
            ValkyrieTokenTypes.OR -> 1
            ValkyrieTokenTypes.AND -> 2
            ValkyrieTokenTypes.EQUAL, ValkyrieTokenTypes.NOT_EQUAL -> 3
            ValkyrieTokenTypes.LESS, ValkyrieTokenTypes.GREATER, ValkyrieTokenTypes.LESS_EQUAL, ValkyrieTokenTypes.GREATER_EQUAL -> 4
            ValkyrieTokenTypes.PLUS, ValkyrieTokenTypes.MINUS -> 5
            ValkyrieTokenTypes.MULTIPLY, ValkyrieTokenTypes.DIVIDE, ValkyrieTokenTypes.MODULO -> 6
            else -> -1
        }
    }

    private fun parseNamespaceStatement(builder: PsiBuilder) {
        val marker = builder.mark()

        // 'namespace' keyword
        if (builder.tokenType == ValkyrieTokenTypes.NAMESPACE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }

        // namespace identifier
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            builder.advanceLexer()
        } else {
            builder.error("Expected namespace identifier")
            builder.advanceLexer() // 推进词法分析器避免死循环
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

        marker.done(ValkyrieElementTypes.USING_STATEMENT)
    }

    private fun parseQualifiedName(builder: PsiBuilder) {
        val marker = builder.mark()

        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            builder.advanceLexer()

            while (builder.tokenType == ValkyrieTokenTypes.DOT) {
                builder.advanceLexer()
                if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        }

        // class body (required)
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseClassBody(builder)
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
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
                builder.advanceLexer()

                // 处理多个泛型参数
                while (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer()
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
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
                ValkyrieTokenTypes.LINE_COMMENT, ValkyrieTokenTypes.BLOCK_COMMENT -> builder.advanceLexer()
                else -> parseClassMember(builder) // 复用 class member 解析逻辑
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

    private fun parseClassBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // class members
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                isModifierOrIdentifier(builder) -> {
                    parseClassMember(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.LINE_COMMENT || builder.tokenType == ValkyrieTokenTypes.BLOCK_COMMENT -> {
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

    private fun parseUnionBody(builder: PsiBuilder) {
        val marker = builder.mark()

        // '{'
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            builder.advanceLexer()
        }

        // union variants
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RBRACE) {
            when {
                builder.tokenType == ValkyrieTokenTypes.IDENTIFIER -> {
                    parseUnionVariant(builder)
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.LINE_COMMENT || builder.tokenType == ValkyrieTokenTypes.BLOCK_COMMENT -> {
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

    private fun parseClassMember(builder: PsiBuilder) {
        // 先解析attributes
        val attributeMarkers = mutableListOf<PsiBuilder.Marker>()
        while (builder.tokenType == ValkyrieTokenTypes.ATTRIBUTE_LOWER) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.AT -> {
                    val attrMarker = builder.mark()
                    builder.advanceLexer() // consume '@'
                    if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
                        builder.advanceLexer() // consume macro name
                        attrMarker.done(ValkyrieElementTypes.MACRO_CALL)
                        attributeMarkers.add(attrMarker)
                    } else {
                        attrMarker.error("Expected macro name after '@'")
                    }
                }

                ValkyrieTokenTypes.ATTRIBUTE_LOWER -> {
                    val attrMarker = builder.mark()
                    parseAttributeList(builder)
                    attrMarker.done(ValkyrieElementTypes.ATTRIBUTE_LIST)
                    attributeMarkers.add(attrMarker)
                }
            }
        }

        // 收集所有连续的标识符及其marker
        val identifierData = mutableListOf<Pair<String, PsiBuilder.Marker>>()
        while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val marker = builder.mark()
            val text = builder.tokenText ?: ""
            builder.advanceLexer()
            identifierData.add(Pair(text, marker))
        }

        if (identifierData.isEmpty()) {
            builder.error("Expected identifier")
            return
        }

        // 根据后续符号进行回溯解析
        when (builder.tokenType) {
            ValkyrieTokenTypes.LPAREN -> {
                // method: [modifiers] methodName()
                val (methodName, nameMarker) = identifierData.last()
                val modifierData = identifierData.dropLast(1)
                parseMethodDeclarationWithBacktrack(builder, attributeMarkers, modifierData, methodName, nameMarker)
            }

            ValkyrieTokenTypes.LBRACE -> {
                // domain: [modifiers] domainName {}
                val (domainName, nameMarker) = identifierData.last()
                val modifierData = identifierData.dropLast(1)
                parseDomainDeclarationWithBacktrack(builder, attributeMarkers, modifierData, domainName, nameMarker)
            }

            ValkyrieTokenTypes.SEMICOLON, ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN, ValkyrieTokenTypes.COMMA -> {
                // field: [modifiers] fieldName; 或 fieldName: type; 或 fieldName = value;
                val (fieldName, nameMarker) = identifierData.last()
                val modifierData = identifierData.dropLast(1)
                parseFieldDeclarationWithBacktrack(builder, attributeMarkers, modifierData, fieldName, nameMarker)
            }

            null -> {
                // EOF - 对象体不完整
                builder.error("Incomplete object body")
                // 清理未完成的marker
                identifierData.forEach { it.second.drop() }
            }

            else -> {
                // 默认当作 field 处理
                val (fieldName, nameMarker) = identifierData.last()
                val modifierData = identifierData.dropLast(1)
                parseFieldDeclarationWithBacktrack(builder, attributeMarkers, modifierData, fieldName, nameMarker)
            }
        }
    }

    private fun parseAnnotationsAndModifiers(builder: PsiBuilder): PsiBuilder.Marker? {
        var annotationMarker: PsiBuilder.Marker? = null
        var hasAttributes = false
        var hasModifiers = false

        // 解析所有的attributes和modifiers
        while (true) {
            when (builder.tokenType) {
                ValkyrieTokenTypes.AT -> {
                    // @.primitive(array) 或 @macro_name
                    if (annotationMarker == null) {
                        annotationMarker = builder.mark()
                    }
                    parseAttribute(builder)
                    hasAttributes = true
                }

                ValkyrieTokenTypes.ATTRIBUTE_LOWER -> {
                    // ↯[derive(Show)] 或 ↯derive(Show)
                    if (annotationMarker == null) {
                        annotationMarker = builder.mark()
                    }
                    parseAttributeList(builder)
                    hasAttributes = true
                }

                ValkyrieTokenTypes.IDENTIFIER -> {
                    // 检查下一个token来判断是否为modifier
                    // 如果下一个token是IDENTIFIER、LPAREN、LBRACE、SEMICOLON、COLON、ASSIGN之一
                    // 且当前不是最后一个IDENTIFIER，则当前IDENTIFIER是modifier
                    val nextToken = builder.lookAhead(1)
                    if (nextToken == ValkyrieTokenTypes.IDENTIFIER ||
                        nextToken == ValkyrieTokenTypes.LPAREN ||
                        nextToken == ValkyrieTokenTypes.LBRACE ||
                        nextToken == ValkyrieTokenTypes.SEMICOLON ||
                        nextToken == ValkyrieTokenTypes.COLON ||
                        nextToken == ValkyrieTokenTypes.ASSIGN
                    ) {

                        // 如果下一个是声明分隔符，当前是声明名称，停止解析
                        if (nextToken == ValkyrieTokenTypes.LPAREN ||
                            nextToken == ValkyrieTokenTypes.LBRACE ||
                            nextToken == ValkyrieTokenTypes.SEMICOLON ||
                            nextToken == ValkyrieTokenTypes.COLON ||
                            nextToken == ValkyrieTokenTypes.ASSIGN
                        ) {
                            break
                        }

                        // 否则当前是modifier
                        if (annotationMarker == null) {
                            annotationMarker = builder.mark()
                        }
                        val modifierMarker = builder.mark()
                        builder.advanceLexer()
                        modifierMarker.done(ValkyrieElementTypes.MODIFIER)
                        hasModifiers = true
                    } else {
                        // 不是modifier，停止解析
                        break
                    }
                }

                else -> {
                    // 其他token，停止解析
                    break
                }
            }
        }

        // 如果有任何annotations或modifiers，完成annotation node
        if (annotationMarker != null && (hasAttributes || hasModifiers)) {
            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        } else {
            annotationMarker?.drop()
            annotationMarker = null
        }

        return annotationMarker
    }

    private fun parseModifiers(builder: PsiBuilder): PsiBuilder.Marker? {
        var modifierMarker: PsiBuilder.Marker? = null

        while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val text = builder.tokenText
            // 检查是否是修饰符关键字（这里简化处理，实际应该有专门的修饰符 token）
            if (isModifierKeyword(text)) {
                if (modifierMarker == null) {
                    modifierMarker = builder.mark()
                }
                builder.advanceLexer()
            } else {
                break
            }
        }

        modifierMarker?.done(ValkyrieElementTypes.MODIFIER_LIST)
        return modifierMarker
    }

    private fun isModifierKeyword(text: String?): Boolean {
        return text in setOf("public", "private", "protected", "static", "final", "abstract", "override")
    }

    private fun isModifierOrIdentifier(builder: PsiBuilder): Boolean {
        return builder.tokenType == ValkyrieTokenTypes.IDENTIFIER
    }

    private fun parseFieldDeclarationWithBacktrack(
        builder: PsiBuilder,
        attributeMarkers: List<PsiBuilder.Marker>,
        modifierData: List<Pair<String, PsiBuilder.Marker>>,
        name: String,
        nameMarker: PsiBuilder.Marker
    ) {
        val fieldMarker = builder.mark()

        // 创建annotation_node包含attributes和modifiers
        if (attributeMarkers.isNotEmpty() || modifierData.isNotEmpty()) {
            val annotationMarker = builder.mark()

            // 添加modifiers作为nodes
            modifierData.forEach { (modifierText, modifierMarker) ->
                modifierMarker.done(ValkyrieElementTypes.MODIFIER)
            }

            // attributes已经在parseClassMember中done了，这里不需要再处理

            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        } else {
            // 如果没有annotations，清理modifier markers
            modifierData.forEach { it.second.drop() }
        }

        // 处理字段名称
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

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

        fieldMarker.done(ValkyrieElementTypes.FIELD_DECLARATION)
    }

    private fun parseFieldDeclarationWithAnnotations(builder: PsiBuilder, annotationMarker: PsiBuilder.Marker?, name: String) {
        val marker = builder.mark()

        // annotations (已经解析)
        if (annotationMarker != null) {
            // annotation node已经被创建了
        }

        // field name (已经消费)
        val nameMarker = builder.mark()
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // optional type annotation
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer()
            parseTypeReference(builder)
        }

        // optional assignment
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
            parseExpression(builder)
        }

        // semicolon
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ';'")
            // 推进词法分析器避免死循环
            if (!builder.eof()) {
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.FIELD_DECLARATION)
    }

    private fun parseFieldDeclaration(builder: PsiBuilder, modifiers: PsiBuilder.Marker?, name: String) {
        val marker = builder.mark()

        // modifiers (已经解析)
        if (modifiers != null) {
            // 修饰符已经被解析了
        }

        // field name (已经消费)
        val nameMarker = builder.mark()
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // optional type annotation
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer()
            parseTypeReference(builder)
        }

        // optional assignment
        if (builder.tokenType == ValkyrieTokenTypes.ASSIGN) {
            builder.advanceLexer()
            parseExpression(builder)
        }

        // semicolon
        if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer()
        } else {
            builder.error("Expected ';'")
            // 推进词法分析器避免死循环
            if (!builder.eof()) {
                builder.advanceLexer()
            }
        }

        marker.done(ValkyrieElementTypes.FIELD_DECLARATION)
    }

    private fun parseMethodDeclarationWithBacktrack(
        builder: PsiBuilder,
        attributeMarkers: List<PsiBuilder.Marker>,
        modifierData: List<Pair<String, PsiBuilder.Marker>>,
        name: String,
        nameMarker: PsiBuilder.Marker
    ) {
        val methodMarker = builder.mark()

        // 创建annotation_node包含attributes和modifiers
        if (attributeMarkers.isNotEmpty() || modifierData.isNotEmpty()) {
            val annotationMarker = builder.mark()

            // 添加modifiers作为nodes
            modifierData.forEach { (modifierText, modifierMarker) ->
                modifierMarker.done(ValkyrieElementTypes.MODIFIER)
            }

            // attributes已经在parseClassMember中done了，这里不需要再处理

            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        } else {
            // 如果没有annotations，清理modifier markers
            modifierData.forEach { it.second.drop() }
        }

        // 处理方法名称
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // 解析方法参数列表
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            val hasStaticSelf = parseParameterListWithSelfDetection(builder)
            // 这里可以根据hasStaticSelf来标记静态方法，但按照之前的讨论，这个逻辑应该在HighlightVisitor中处理
        }

        // 解析返回类型
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer() // consume ':'
            parseTypeReference(builder)
        }

        // 解析方法体
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else if (builder.tokenType == ValkyrieTokenTypes.SEMICOLON) {
            builder.advanceLexer() // consume ';' for abstract methods
        }

        methodMarker.done(ValkyrieElementTypes.METHOD_DECLARATION)
    }

    private fun parseMethodDeclarationWithAnnotations(builder: PsiBuilder, annotationMarker: PsiBuilder.Marker?, name: String) {
        val marker = builder.mark()

        // annotations (已经解析)
        if (annotationMarker != null) {
            // annotation node已经被创建了
        }

        // method name (已经消费)
        val nameMarker = builder.mark()
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // parameter list
        var hasSelfParameter = false
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            hasSelfParameter = parseParameterListWithSelfDetection(builder)
        }

        // method body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected method body")
        }

        // 根据是否有self参数决定方法类型
        if (hasSelfParameter) {
            marker.done(ValkyrieElementTypes.INSTANCE_METHOD_DECLARATION)
        } else {
            marker.done(ValkyrieElementTypes.STATIC_METHOD_DECLARATION)
        }
    }

    private fun parseMethodDeclaration(builder: PsiBuilder, modifiers: PsiBuilder.Marker?, name: String) {
        val marker = builder.mark()

        // modifiers (已经解析)
        if (modifiers != null) {
            // 修饰符已经被解析了
        }

        // method name (已经消费)
        val nameMarker = builder.mark()
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // parameter list
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseParameterList(builder)
        }

        // method body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected method body")
        }

        marker.done(ValkyrieElementTypes.METHOD_DECLARATION)
    }

    private fun parseDomainDeclarationWithBacktrack(
        builder: PsiBuilder,
        attributeMarkers: List<PsiBuilder.Marker>,
        modifierData: List<Pair<String, PsiBuilder.Marker>>,
        name: String,
        nameMarker: PsiBuilder.Marker
    ) {
        val domainMarker = builder.mark()

        // 创建annotation_node包含attributes和modifiers
        if (attributeMarkers.isNotEmpty() || modifierData.isNotEmpty()) {
            val annotationMarker = builder.mark()

            // 添加modifiers作为nodes
            modifierData.forEach { (modifierText, modifierMarker) ->
                modifierMarker.done(ValkyrieElementTypes.MODIFIER)
            }

            // attributes已经在parseClassMember中done了，这里不需要再处理

            annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)
        } else {
            // 如果没有annotations，清理modifier markers
            modifierData.forEach { it.second.drop() }
        }

        // 处理域名称
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // 解析域体
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseClassBody(builder) // 域体和类体结构相同
        } else {
            builder.error("Expected '{' for domain body")
        }

        domainMarker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
    }

    private fun parseDomainDeclarationWithAnnotations(builder: PsiBuilder, annotationMarker: PsiBuilder.Marker?, name: String) {
        val marker = builder.mark()

        // annotations (已经解析)
        if (annotationMarker != null) {
            // annotation node已经被创建了
        }

        // domain name (已经消费)
        val nameMarker = builder.mark()
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // domain body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected domain body")
        }

        marker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
    }

    private fun parseDomainDeclaration(builder: PsiBuilder, modifiers: PsiBuilder.Marker?, name: String) {
        val marker = builder.mark()

        // modifiers (已经解析)
        if (modifiers != null) {
            // 修饰符已经被解析了
        }

        // domain name (已经消费)
        val nameMarker = builder.mark()
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // domain body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected domain body")
        }

        marker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
    }

    private fun parseUnionVariant(builder: PsiBuilder) {
        val marker = builder.mark()

        // variant name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
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
                    parseClassMember(builder) // 复用 class member 解析逻辑
                }

                builder.tokenType == ValkyrieTokenTypes.WHITESPACE || builder.tokenType == ValkyrieTokenTypes.NEWLINE -> {
                    builder.advanceLexer()
                }

                builder.tokenType == ValkyrieTokenTypes.LINE_COMMENT || builder.tokenType == ValkyrieTokenTypes.BLOCK_COMMENT -> {
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
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            parseQualifiedName(builder)
        } else {
            builder.error("Expected macro name")
        }

        marker.done(ValkyrieElementTypes.MACRO_CALL)
    }
}