package valkyrie.reference

import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieCallExpressionNode
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieDomainDeclaration
import valkyrie.psi.nodes.ValkyrieFieldDeclaration
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieLetStatementNode
import valkyrie.psi.nodes.ValkyrieMetaStatement
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieNeuralDeclaration
import valkyrie.psi.nodes.ValkyriePostfixExpressionNode
import valkyrie.psi.nodes.ValkyrieSingletonDeclaration
import valkyrie.psi.nodes.ValkyrieTraitAliasDeclaration
import valkyrie.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.psi.nodes.ValkyrieTypeReferenceNode
import valkyrie.psi.nodes.ValkyrieUnionDeclaration
import valkyrie.psi.nodes.ValkyrieUsingStatement
import valkyrie.psi.nodes.ValkyrieVariantDeclaration
import valkyrie.psi.nodes.ValkyrieWidgetDeclaration
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Decides whether an identifier should participate in cross-file reference resolution.
 */
object ValkyrieReferenceContext {

    fun isResolvableUsage(identifier: ValkyrieIdentifierNode): Boolean {
        if (isDeclarationName(identifier)) {
            return false
        }
        if (isUsingImportPath(identifier)) {
            return false
        }
        if (isBoundByDedicatedReference(identifier)) {
            return false
        }
        return true
    }

    fun isDeclarationName(identifier: ValkyrieIdentifierNode): Boolean {
        val parent = identifier.parent ?: return false
        return when (parent) {
            is ValkyrieClassDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieTraitDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieUnionDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieVariantDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieFieldDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieMethodDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieDomainDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieMetaStatement -> parent.nameIdentifier == identifier
            is ValkyrieLetStatementNode -> parent.getIdentifier() == identifier
            is ValkyrieSingletonDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieNeuralDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieWidgetDeclaration -> parent.nameIdentifier == identifier
            is ValkyrieTraitAliasDeclaration -> parent.nameIdentifier == identifier
            else -> false
        }
    }

    fun isUsingImportPath(identifier: ValkyrieIdentifierNode): Boolean {
        return PsiTreeUtil.getParentOfType(identifier, ValkyrieUsingStatement::class.java) != null
    }

    fun isBoundByDedicatedReference(identifier: ValkyrieIdentifierNode): Boolean {
        val parent = identifier.parent
        if (parent is ValkyrieCallExpressionNode && parent.getCallee() == identifier) {
            return true
        }
        if (PsiTreeUtil.getParentOfType(identifier, ValkyrieTypeReferenceNode::class.java) != null) {
            return true
        }
        val postfix = PsiTreeUtil.getParentOfType(identifier, ValkyriePostfixExpressionNode::class.java)
        if (postfix != null && findPostfixMethodIdentifier(postfix) == identifier) {
            return true
        }
        return false
    }

    fun isInTypeContext(identifier: ValkyrieIdentifierNode): Boolean {
        var parent = identifier.parent
        while (parent != null) {
            when (parent.node?.elementType) {
                ValkyrieTypes.TYPE_REFERENCE,
                ValkyrieTypes.INHERIT_LIST,
                ValkyrieTypes.INHERIT_ITEM,
                ValkyrieTypes.GENERIC_PARAMETER_LIST -> return true
            }
            if (parent is ValkyrieTypeReferenceNode) {
                return true
            }
            parent = parent.parent
        }
        return false
    }

    fun primaryReference(identifier: ValkyrieIdentifierNode) =
        identifier.references.firstOrNull()

    private fun findPostfixMethodIdentifier(postfix: ValkyriePostfixExpressionNode): ValkyrieIdentifierNode? {
        val postfixOperation = postfix.getPostfixOperation() ?: return null
        if (postfixOperation is ValkyrieIdentifierNode) {
            return postfixOperation
        }
        var child = postfixOperation.firstChild
        while (child != null) {
            if (child is ValkyrieIdentifierNode) {
                return child
            }
            child = child.nextSibling
        }
        return null
    }
}
