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
            ValkyrieElementTypes.FILE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.STATEMENT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LET_STATEMENT -> ValkyrieLetStatementNode(node)
            ValkyrieElementTypes.NAMESPACE_STATEMENT -> ValkyrieNamespaceStatementNode(node)
            ValkyrieElementTypes.USING_STATEMENT -> ValkyrieUsingStatementNode(node)
            ValkyrieElementTypes.EXPRESSION_STATEMENT -> ValkyrieExpressionStatementNode(node)
            ValkyrieElementTypes.BLOCK_STATEMENT -> ValkyrieBlockStatementNode(node)
            ValkyrieElementTypes.EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.IDENTIFIER_EXPRESSION -> ValkyrieIdentifierExpressionNode(node)
            ValkyrieElementTypes.LITERAL_EXPRESSION -> ValkyrieLiteralExpressionNode(node)
            ValkyrieElementTypes.BINARY_EXPRESSION -> ValkyrieBinaryExpressionNode(node)
            ValkyrieElementTypes.UNARY_EXPRESSION -> ValkyrieUnaryExpressionNode(node)
            ValkyrieElementTypes.PARENTHESIZED_EXPRESSION -> ValkyrieParenthesizedExpressionNode(node)
            ValkyrieElementTypes.PATTERN -> ValkyrieElementNode(node)
            ValkyrieElementTypes.IDENTIFIER_PATTERN -> ValkyrieIdentifierPatternNode(node)
            ValkyrieElementTypes.TYPE_REFERENCE -> ValkyrieTypeReferenceNode(node)
            ValkyrieElementTypes.QUALIFIED_NAME -> ValkyrieQualifiedNameNode(node)
            else -> ValkyrieElementNode(node)
        }
    }
}