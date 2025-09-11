package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.*

/**
 * Valkyrie PSI 元素工厂
 */
object ValkyrieElementFactory {
    
    fun createElement(node: ASTNode): PsiElement {
        return when (node.elementType) {
            ValkyrieElementTypes.FILE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.STATEMENT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LET_STATEMENT -> ValkyrieLetStatementNode(node)
            ValkyrieElementTypes.CLASS_STATEMENT -> ValkyrieClassStatementNode(node)
            ValkyrieElementTypes.UNION_STATEMENT -> ValkyrieUnionDeclaration(node)
            ValkyrieElementTypes.TRAIT_STATEMENT -> ValkyrieElementNode(node)
            ValkyrieElementTypes.NAMESPACE_STATEMENT -> ValkyrieNamespaceDeclaration(node)
            ValkyrieElementTypes.USING_STATEMENT -> ValkyrieUsingStatementNode(node)
            ValkyrieElementTypes.EXPRESSION_STATEMENT -> ValkyrieTermExpression(node)
            ValkyrieElementTypes.BLOCK_STATEMENT -> ValkyrieObjectBodyNode(node)
            ValkyrieElementTypes.EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.IDENTIFIER_EXPRESSION -> ValkyrieIdentifierExpressionNode(node)
            ValkyrieElementTypes.LITERAL_EXPRESSION -> ValkyrieLiteralExpressionNode(node)
            ValkyrieElementTypes.BINARY_EXPRESSION -> ValkyrieBinaryTerm(node)
            ValkyrieElementTypes.UNARY_EXPRESSION -> ValkyrieUnaryTerm(node)
            ValkyrieElementTypes.PARENTHESIZED_EXPRESSION -> ValkyrieParenthesizedExpressionNode(node)
            ValkyrieElementTypes.FIELD_DECLARATION -> ValkyrieFieldDeclaration(node)
            ValkyrieElementTypes.METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.DOMAIN_DECLARATION -> ValkyrieDomainDeclaration(node)
            ValkyrieElementTypes.UNION_VARIANT -> ValkyrieVariantDeclaration(node)
            ValkyrieElementTypes.MODIFIER_LIST -> ValkyrieModifierListNode(node)
            ValkyrieElementTypes.PATTERN -> ValkyrieElementNode(node)
            ValkyrieElementTypes.IDENTIFIER_PATTERN -> ValkyrieIdentifierPatternNode(node)
            ValkyrieElementTypes.TYPE_REFERENCE -> ValkyrieTypeReferenceNode(node)
            ValkyrieElementTypes.QUALIFIED_NAME -> ValkyrieQualifiedNameNode(node)
            ValkyrieElementTypes.PARAMETER_LIST -> ValkyrieParameterListNode(node)
            ValkyrieElementTypes.PARAMETER -> ValkyrieParameterNode(node)
            ValkyrieElementTypes.GENERIC_PARAMETER_LIST -> ValkyrieElementNode(node)
            else -> ValkyrieElementNode(node)
        }
    }
}