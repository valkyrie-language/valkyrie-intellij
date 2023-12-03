package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieTokenTypes.*
import valkyrie.psi.ValkyrieElementTypes.*

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
            LET -> parseLetStatement(builder)
            NAMESPACE -> parseNamespaceStatement(builder)
            USING -> parseUsingStatement(builder)
            LBRACE -> parseBlockStatement(builder)
            WHITESPACE, NEWLINE -> builder.advanceLexer()
            LINE_COMMENT, BLOCK_COMMENT -> builder.advanceLexer()
            null -> return
            else -> parseExpressionStatement(builder)
        }
    }
    
    private fun parseLetStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        
        // 'let' keyword
        if (builder.tokenType == LET) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }
        
        // optional 'mut' or 'ref'
        if (builder.tokenType == MUT || builder.tokenType == REF) {
            builder.advanceLexer()
        }
        
        // pattern (identifier for now)
        if (builder.tokenType == IDENTIFIER) {
            val patternMarker = builder.mark()
            builder.advanceLexer()
            patternMarker.done(IDENTIFIER_PATTERN)
        } else {
            builder.error("Expected identifier")
        }
        
        // optional type annotation
        if (builder.tokenType == COLON) {
            builder.advanceLexer()
            parseTypeReference(builder)
        }
        
        // '=' assignment
        if (builder.tokenType == ASSIGN) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '='")
        }
        
        // expression
        parseExpression(builder)
        
        // optional semicolon
        if (builder.tokenType == SEMICOLON) {
            builder.advanceLexer()
        }
        
        marker.done(LET_STATEMENT)
    }
    
    private fun parseBlockStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        
        if (builder.tokenType == LBRACE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }
        
        while (!builder.eof() && builder.tokenType != RBRACE) {
            parseStatement(builder)
        }
        
        if (builder.tokenType == RBRACE) {
            builder.advanceLexer()
        } else {
            builder.error("Expected '}'")
        }
        
        marker.done(BLOCK_STATEMENT)
    }
    
    private fun parseExpressionStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        
        parseExpression(builder)
        
        // optional semicolon
        if (builder.tokenType == SEMICOLON) {
            builder.advanceLexer()
        }
        
        marker.done(EXPRESSION_STATEMENT)
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
            
            marker?.done(BINARY_EXPRESSION)
            left = marker
        }
    }
    
    private fun parsePrimaryExpression(builder: PsiBuilder): PsiBuilder.Marker? {
        return when (builder.tokenType) {
            IDENTIFIER -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(IDENTIFIER_EXPRESSION)
                marker
            }
            INTEGER, FLOAT, STRING, BOOLEAN -> {
                val marker = builder.mark()
                builder.advanceLexer()
                marker.done(LITERAL_EXPRESSION)
                marker
            }
            LPAREN -> {
                val marker = builder.mark()
                builder.advanceLexer() // consume '('
                parseExpression(builder)
                if (builder.tokenType == RPAREN) {
                    builder.advanceLexer() // consume ')'
                } else {
                    builder.error("Expected ')'")
                }
                marker.done(PARENTHESIZED_EXPRESSION)
                marker
            }
            MINUS, NOT -> {
                val marker = builder.mark()
                builder.advanceLexer() // consume operator
                parsePrimaryExpression(builder)
                marker.done(UNARY_EXPRESSION)
                marker
            }
            else -> {
                builder.error("Expected expression")
                null
            }
        }
    }
    
    private fun parseTypeReference(builder: PsiBuilder) {
        val marker = builder.mark()
        
        if (builder.tokenType == IDENTIFIER) {
            builder.advanceLexer()
        } else {
            builder.error("Expected type name")
        }
        
        marker.done(TYPE_REFERENCE)
    }
    
    private fun getOperatorPrecedence(tokenType: IElementType?): Int {
        return when (tokenType) {
            OR -> 1
            AND -> 2
            EQUAL, NOT_EQUAL -> 3
            LESS, GREATER, LESS_EQUAL, GREATER_EQUAL -> 4
            PLUS, MINUS -> 5
            MULTIPLY, DIVIDE, MODULO -> 6
            else -> -1
        }
    }
    
    private fun parseNamespaceStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        
        // 'namespace' keyword
        if (builder.tokenType == NAMESPACE) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }
        
        // namespace identifier
        if (builder.tokenType == IDENTIFIER) {
            builder.advanceLexer()
        } else {
            builder.error("Expected namespace identifier")
        }
        
        marker.done(NAMESPACE_STATEMENT)
    }
    
    private fun parseUsingStatement(builder: PsiBuilder) {
        val marker = builder.mark()
        
        // 'using' keyword
        if (builder.tokenType == USING) {
            builder.advanceLexer()
        } else {
            marker.drop()
            return
        }
        
        // qualified name (e.g., file_b.b)
        parseQualifiedName(builder)
        
        marker.done(USING_STATEMENT)
    }
    
    private fun parseQualifiedName(builder: PsiBuilder) {
        val marker = builder.mark()
        
        if (builder.tokenType == IDENTIFIER) {
            builder.advanceLexer()
            
            while (builder.tokenType == DOT) {
                builder.advanceLexer()
                if (builder.tokenType == IDENTIFIER) {
                    builder.advanceLexer()
                } else {
                    builder.error("Expected identifier after '.'")
                    break
                }
            }
        } else {
            builder.error("Expected identifier")
        }
        
        marker.done(QUALIFIED_NAME)
    }
}