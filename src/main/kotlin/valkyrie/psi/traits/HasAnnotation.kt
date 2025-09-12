package valkyrie.psi.traits

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieAnnotationNode
import valkyrie.psi.nodes.ValkyrieModifierNode

interface HasAnnotation {
    fun getAnnotation(): ValkyrieAnnotationNode {
        return PsiTreeUtil.findChildOfType(
            this as PsiElement,
            ValkyrieAnnotationNode::class.java
        )!!
    }

    val modifiers: List<ValkyrieModifierNode>
        get() = this.getAnnotation().getModifiers()

    fun hasModifier(name: String): Boolean {
        return this.getAnnotation().hasModifier(name)
    }
}

