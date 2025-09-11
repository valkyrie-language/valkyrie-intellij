package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Method 声明实现
 */
class ValkyrieMethodDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {

    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
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



    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }
    
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }
    
    fun isStatic(): Boolean {
        return hasModifier("static")
    }
    
    fun isMutable(): Boolean {
        return hasModifier("mut")
    }

    fun getParameterList(): ValkyrieParameterListNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieParameterListNode::class.java)
    }

    fun getMethodBody(): ValkyrieBlockNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockNode::class.java)
    }
}