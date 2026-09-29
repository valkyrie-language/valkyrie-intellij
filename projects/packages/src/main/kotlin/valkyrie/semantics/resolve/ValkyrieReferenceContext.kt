package valkyrie.semantics.resolve

import com.intellij.psi.util.PsiTreeUtil
import valkyrie.surface.psi.nodes.ValkyrieCallExpressionNode
import valkyrie.surface.psi.nodes.ValkyrieClassDeclaration
import valkyrie.surface.psi.nodes.ValkyrieDomainDeclaration
import valkyrie.surface.psi.nodes.ValkyrieFieldDeclaration
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode
import valkyrie.surface.psi.nodes.ValkyrieLetStatementNode
import valkyrie.surface.psi.nodes.ValkyrieMetaStatement
import valkyrie.surface.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.surface.psi.nodes.ValkyrieNeuralDeclaration
import valkyrie.surface.psi.nodes.ValkyriePostfixExpressionNode
import valkyrie.surface.psi.nodes.ValkyrieSingletonDeclaration
import valkyrie.surface.psi.nodes.ValkyrieTraitAliasDeclaration
import valkyrie.surface.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.surface.psi.nodes.ValkyrieTypeReferenceNode
import valkyrie.surface.psi.nodes.ValkyrieUnionDeclaration
import valkyrie.surface.psi.nodes.ValkyrieUsingStatement
import valkyrie.surface.psi.nodes.ValkyrieVariantDeclaration
import valkyrie.surface.psi.nodes.ValkyrieWidgetDeclaration
import valkyrie.surface.parser.ValkyrieTypes

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
