package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.ValkyrieElementTypes

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
        
        marker.done(ValkyrieElementTypes.BLOCK_STATEMENT)
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
            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.FLOAT, ValkyrieTokenTypes.STRING, ValkyrieTokenTypes.BOOLEAN -> {
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
        
        marker.done(ValkyrieElementTypes.BLOCK_STATEMENT)
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
        
        marker.done(ValkyrieElementTypes.BLOCK_STATEMENT)
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
        
        marker.done(ValkyrieElementTypes.BLOCK_STATEMENT)
    }
    
    private fun parseClassMember(builder: PsiBuilder) {
        // 收集所有标识符，然后根据最后的符号判断类型
        val identifiers = mutableListOf<String>()
        val startPos = builder.currentOffset
        
        // 收集连续的标识符
        while (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            identifiers.add(builder.tokenText ?: "")
            builder.advanceLexer()
        }
        
        if (identifiers.isEmpty()) {
            builder.error("Expected identifier")
            // 强制推进以避免无限循环
            if (!builder.eof()) {
                builder.advanceLexer()
            }
            return
        }
        
        // 根据后续符号判断最后一个标识符的类型
        when (builder.tokenType) {
            ValkyrieTokenTypes.LPAREN -> {
                // method: modifiers... methodName()
                parseMethodDeclarationWithIdentifiers(builder, identifiers)
            }
            ValkyrieTokenTypes.LBRACE -> {
                // domain: modifiers... domainName {}
                parseDomainDeclarationWithIdentifiers(builder, identifiers)
            }
            ValkyrieTokenTypes.SEMICOLON, ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN -> {
                // field: modifiers... fieldName; 或 fieldName: type; 或 fieldName = value;
                parseFieldDeclarationWithIdentifiers(builder, identifiers)
            }
            null -> {
                // EOF - 对象体不完整
                builder.error("Incomplete object body")
            }
            else -> {
                // 默认当作 field 处理，但如果无法处理则跳过当前 token
                val currentOffset = builder.currentOffset
                parseFieldDeclarationWithIdentifiers(builder, identifiers)
                // 如果解析后位置没有变化，强制推进以避免无限循环
                if (builder.currentOffset == currentOffset && !builder.eof()) {
                    builder.error("Unexpected token: ${builder.tokenType}")
                    builder.advanceLexer()
                }
            }
        }
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
    
    private fun parseFieldDeclarationWithIdentifiers(builder: PsiBuilder, identifiers: List<String>) {
        val marker = builder.mark()
        
        // 创建修饰符列表（除了最后一个标识符）
        if (identifiers.size > 1) {
            val modifierMarker = builder.mark()
            // 修饰符已经被消费了，这里只是标记
            modifierMarker.done(ValkyrieElementTypes.MODIFIER_LIST)
        }
        
        // field name（最后一个标识符）
        val nameMarker = builder.mark()
        // 名称已经被消费了，这里只是标记
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
    
    private fun parseFieldDeclaration(builder: PsiBuilder, modifiers: PsiBuilder.Marker?) {
        val marker = builder.mark()
        
        // field name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
        }
        
        // optional type annotation
        if (builder.tokenType == ValkyrieTokenTypes.COLON) {
            builder.advanceLexer()
            parseTypeReference(builder)
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
    
    private fun parseMethodDeclarationWithIdentifiers(builder: PsiBuilder, identifiers: List<String>) {
        val marker = builder.mark()
        
        // 创建修饰符列表（除了最后一个标识符）
        if (identifiers.size > 1) {
            val modifierMarker = builder.mark()
            // 修饰符已经被消费了，这里只是标记
            modifierMarker.done(ValkyrieElementTypes.MODIFIER_LIST)
        }
        
        // method name（最后一个标识符）
        val nameMarker = builder.mark()
        // 名称已经被消费了，这里只是标记
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
    
    private fun parseMethodDeclaration(builder: PsiBuilder, modifiers: PsiBuilder.Marker?) {
        val marker = builder.mark()
        
        // method name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
        }
        
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
    
    private fun parseDomainDeclarationWithIdentifiers(builder: PsiBuilder, identifiers: List<String>) {
        val marker = builder.mark()
        
        // 创建修饰符列表（除了最后一个标识符）
        if (identifiers.size > 1) {
            val modifierMarker = builder.mark()
            // 修饰符已经被消费了，这里只是标记
            modifierMarker.done(ValkyrieElementTypes.MODIFIER_LIST)
        }
        
        // domain name（最后一个标识符）
        val nameMarker = builder.mark()
        // 名称已经被消费了，这里只是标记
        nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
        
        // domain body
        if (builder.tokenType == ValkyrieTokenTypes.LBRACE) {
            parseBlockStatement(builder)
        } else {
            builder.error("Expected domain body")
        }
        
        marker.done(ValkyrieElementTypes.DOMAIN_DECLARATION)
    }
    
    private fun parseDomainDeclaration(builder: PsiBuilder, modifiers: PsiBuilder.Marker?) {
        val marker = builder.mark()
        
        // domain name
        if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
            val nameMarker = builder.mark()
            builder.advanceLexer()
            nameMarker.done(ValkyrieElementTypes.IDENTIFIER_PATTERN)
        }
        
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
        
        marker.done(ValkyrieElementTypes.BLOCK_STATEMENT)
    }
    
    private fun parseParameterList(builder: PsiBuilder) {
        val marker = builder.mark()
        
        // '('
        if (builder.tokenType == ValkyrieTokenTypes.LPAREN) {
            builder.advanceLexer()
        }
        
        // parameters
        while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.RPAREN) {
            if (builder.tokenType == ValkyrieTokenTypes.IDENTIFIER) {
                val paramMarker = builder.mark()
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
    }
}