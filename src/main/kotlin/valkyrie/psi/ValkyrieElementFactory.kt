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
            ValkyrieElementTypes.CLASS_STATEMENT -> ValkyrieClassDeclaration(node)
            ValkyrieElementTypes.UNION_STATEMENT -> ValkyrieUnionDeclaration(node)
            ValkyrieElementTypes.TRAIT_STATEMENT -> ValkyrieTraitDeclaration(node)
            ValkyrieElementTypes.NAMESPACE_STATEMENT -> ValkyrieNamespaceDeclaration(node)
            ValkyrieElementTypes.NAMESPACE_PATH -> ValkyrieElementNode(node)
            ValkyrieElementTypes.USING_STATEMENT -> ValkyrieUsingStatementNode(node)
            ValkyrieElementTypes.EXPRESSION_STATEMENT -> ValkyrieTermExpression(node)
            ValkyrieElementTypes.OBJECT_BODY -> ValkyrieObjectBodyNode(node)
            ValkyrieElementTypes.UNION_BODY -> ValkyrieUnionBodyNode(node)
            ValkyrieElementTypes.EXPRESSION -> ValkyrieElementNode(node)
            ValkyrieElementTypes.LITERAL_EXPRESSION -> ValkyrieLiteralExpressionNode(node)
            ValkyrieElementTypes.BINARY_EXPRESSION -> ValkyrieBinaryTerm(node)
            ValkyrieElementTypes.UNARY_EXPRESSION -> ValkyrieUnaryTerm(node)
            ValkyrieElementTypes.PARENTHESIZED_EXPRESSION -> ValkyrieParenthesizedExpressionNode(node)
            ValkyrieElementTypes.CALL_EXPRESSION -> ValkyrieCallExpressionNode(node)
            ValkyrieElementTypes.GENERIC_CALL_EXPRESSION -> ValkyrieGenericCallExpressionNode(node)
            ValkyrieElementTypes.POSTFIX_EXPRESSION -> ValkyriePostfixExpressionNode(node)
            ValkyrieElementTypes.FIELD_DECLARATION -> ValkyrieFieldDeclaration(node)
            ValkyrieElementTypes.METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.INSTANCE_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.STATIC_METHOD_DECLARATION -> ValkyrieMethodDeclaration(node)
            ValkyrieElementTypes.DOMAIN_DECLARATION -> ValkyrieDomainDeclaration(node)
            ValkyrieElementTypes.UNION_VARIANT -> ValkyrieVariantDeclaration(node)
            ValkyrieElementTypes.MODIFIER_LIST -> ValkyrieModifierListNode(node)
            ValkyrieElementTypes.PATTERN -> ValkyrieElementNode(node)
            ValkyrieElementTypes.IDENTIFIER_NODE -> ValkyrieIdentifierNode(node)
            ValkyrieElementTypes.TYPE_REFERENCE -> ValkyrieTypeReferenceNode(node)
            ValkyrieElementTypes.QUALIFIED_NAME -> ValkyrieQualifiedNameNode(node)
            ValkyrieElementTypes.PARAMETER_LIST -> ValkyrieParameterListNode(node)
            ValkyrieElementTypes.PARAMETER -> ValkyrieParameterNode(node)
            ValkyrieElementTypes.GENERIC_PARAMETER_LIST -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ANNOTATION_NODE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.MODIFIER_NODE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ATTRIBUTE -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ATTRIBUTE_LIST -> ValkyrieElementNode(node)
            ValkyrieElementTypes.MACRO_CALL -> ValkyrieElementNode(node)
            ValkyrieElementTypes.ATTRIBUTE_ARGS -> ValkyrieElementNode(node)
            ValkyrieElementTypes.DOC_COMMENT -> ValkyrieDocCommentNode(node)
            else -> ValkyrieElementNode(node)
        }
    }
}