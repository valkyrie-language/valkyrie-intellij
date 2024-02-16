package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasTermParameter


/**
 * Method 声明实现
 */
class ValkyrieMethodDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasTermParameter {

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

    val modifiers: Sequence<ValkyrieModifierNode>
        get() = sequence {
            for (modifier in getModifierList()) {
                modifier?.let { yield(it) }
            }
        }

    override val parameters: List<ValkyrieTermParameterItem>
        get() = getParameterList()?.getParameters() ?: emptyList()

    fun hasModifier(name: String): Boolean {
        return modifiers.any { it.isModifier(name) }
    }

    fun isStatic(): Boolean {
        return hasModifier("static")
    }

    fun isMutable(): Boolean {
        return hasModifier("mut")
    }

    fun getModifierList(): Array<out ValkyrieModifierNode?> {
        return findChildrenByClass(ValkyrieModifierNode::class.java)
    }

    fun getParameterList(): ValkyrieTermParameterList? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieTermParameterList::class.java)
    }

    fun getMethodBody(): ValkyrieBlockNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockNode::class.java)
    }


}