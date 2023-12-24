package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Domain 声明实现
 */
class ValkyrieDomainDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.IDENTIFIER_STD)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    fun getDomainName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)?.text
    }

    fun getModifiers(): ValkyrieModifierListNode? {
        return findChildByClass(ValkyrieModifierListNode::class.java)
    }

    fun getDomainBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }
}