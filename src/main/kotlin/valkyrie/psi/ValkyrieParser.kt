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
            ValkyrieTokenTypes.FUNCTION -> parseFunctionStatement(builder)
            ValkyrieTokenTypes.NAMESPACE -> parseNamespaceStatement(builder)
            ValkyrieTokenTypes.USING -> parseUsingStatement(builder)
            ValkyrieTokenTypes.LBRACE -> parseBlockStatement(builder)
            ValkyrieTokenTypes.WHITESPACE, ValkyrieTokenTypes.NEWLINE -> builder.advanceLexer()
            ValkyrieTokenTypes.COMMENT_REST, ValkyrieTokenTypes.COMMENT_RANGE -> builder.advanceLexer()
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
                ValkyrieTokenTypes.LPAREN -> {
                    // 普通函数调用 call(args)
                    val marker = left?.precede()
                    parseArgumentList(builder)
                    marker?.done(ValkyrieElementTypes.CALL_EXPRESSION)
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
            
            while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
                parseExpression(builder)
                
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
    }

    private fun parseGenericArguments(builder: PsiBuilder, startToken: IElementType, endToken: IElementType) {
        if (builder.tokenType == startToken) {
            builder.advanceLexer() // consume start token
            
            while (!builder.eof() && builder.tokenType != endToken) {
                parseTypeReference(builder)
                
                if (builder.tokenType == ValkyrieTokenTypes.COMMA) {
                    builder.advanceLexer() // consume ','
                } else if (builder.tokenType != endToken) {
                    builder.error("Expected ',' or end token")
                    break
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
            ValkyrieTokenTypes.IDENTIFIER -> {
                val marker = builder.mark()
                parseIdentifier(builder)
                marker.done(ValkyrieElementTypes.IDENTIFIER_EXPRESSION)
                marker
            }

            ValkyrieTokenTypes.BACKTICK -> {
                val marker = builder.mark()
                parseSpecialIdentifier(builder)
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
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

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
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

            // optional generic parameters
            parseOptionalGenericParameters(builder)
        } else {
            builder.error("Expected function name")
        }

        // parameter list
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            parseParameterList(builder)
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

        marker.done(ValkyrieElementTypes.OBJECT_BODY)
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

        // 解析modifiers
        val modifierTexts = mutableListOf<String>()
        while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
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

            // 当前是modifier
            val modifierMarker = builder.mark()
            modifierTexts.add(builder.tokenText ?: "")
            builder.advanceLexer()
            modifierMarker.done(ValkyrieElementTypes.MODIFIER_NODE)
        }

        annotationMarker.done(ValkyrieElementTypes.ANNOTATION_NODE)

        // 解析声明名称
        if (builder.tokenType != ValkyrieTokenTypes.IDENTIFIER) {
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
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)

        // 根据后续符号确定成员类型
        when (builder.tokenType) {
            // 方法 `method() { }`
            ValkyrieTokenTypes.LPAREN -> {
                parseMethodRest(builder)
                memberMarker.done(ValkyrieElementTypes.METHOD_DECLARATION)
            }

            // 域 `domain { }`
            ValkyrieTokenTypes.LBRACE -> {
                parseObjectBody(builder)
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
        return builder.tokenType == ValkyrieTokenTypes.IDENTIFIER
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