package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.impl.*

/**
 * Valkyrie PSI 元素工厂
 */
object ValkyrieElementFactory {
    
    fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            ValkyrieElementTypes.FILE -> ValkyrieElementImpl(node)
            ValkyrieElementTypes.STATEMENT -> ValkyrieElementImpl(node)
            ValkyrieElementTypes.LET_STATEMENT -> ValkyrieLetStatementImpl(node)
            ValkyrieElementTypes.NAMESPACE_STATEMENT -> ValkyrieNamespaceStatementImpl(node)
            ValkyrieElementTypes.USING_STATEMENT -> ValkyrieUsingStatementImpl(node)
            ValkyrieElementTypes.EXPRESSION_STATEMENT -> ValkyrieExpressionStatementImpl(node)
            ValkyrieElementTypes.BLOCK_STATEMENT -> ValkyrieBlockStatementImpl(node)
            ValkyrieElementTypes.EXPRESSION -> ValkyrieElementImpl(node)
            ValkyrieElementTypes.IDENTIFIER_EXPRESSION -> ValkyrieIdentifierExpressionImpl(node)
            ValkyrieElementTypes.LITERAL_EXPRESSION -> ValkyrieLiteralExpressionImpl(node)
            ValkyrieElementTypes.BINARY_EXPRESSION -> ValkyrieBinaryExpressionImpl(node)
            ValkyrieElementTypes.UNARY_EXPRESSION -> ValkyrieUnaryExpressionImpl(node)
            ValkyrieElementTypes.PARENTHESIZED_EXPRESSION -> ValkyrieParenthesizedExpressionImpl(node)
            ValkyrieElementTypes.PATTERN -> ValkyrieElementImpl(node)
            ValkyrieElementTypes.IDENTIFIER_PATTERN -> ValkyrieIdentifierPatternImpl(node)
            ValkyrieElementTypes.TYPE_REFERENCE -> ValkyrieTypeReferenceImpl(node)
            ValkyrieElementTypes.QUALIFIED_NAME -> ValkyrieQualifiedNameImpl(node)
            else -> ValkyrieElementImpl(node)
        }
    }
}