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
}