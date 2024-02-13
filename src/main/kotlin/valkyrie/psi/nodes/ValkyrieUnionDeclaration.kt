package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Union 语句实现
 */
class ValkyrieUnionDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: String): PsiElement {
        val nameIdentifier = getNameIdentifier()
        if (nameIdentifier is ValkyrieIdentifierNode) {
            return nameIdentifier.setName(name)
        }
        return this
    }

    fun getUnionBody(): ValkyrieUnionBodyNode? {
        return findChildByClass(ValkyrieUnionBodyNode::class.java)
    }
}