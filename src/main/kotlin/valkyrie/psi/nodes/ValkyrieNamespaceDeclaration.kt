package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Namespace 语句实现
 */
class ValkyrieNamespaceDeclaration(node: ASTNode) : ValkyrieElementNode(node) {

    fun getNamespaceIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
    }

    fun getNamespaceName(): String? {
        return getNamespaceIdentifier()?.text
    }
}