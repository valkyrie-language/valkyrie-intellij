package valkyrie.surface.traits

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.surface.psi.nodes.ValkyrieAnnotationNode
import valkyrie.surface.psi.nodes.ValkyrieModifierNode

interface HasAnnotation {
    fun getAnnotation(): ValkyrieAnnotationNode? {
        return PsiTreeUtil.findChildOfType(
            this as PsiElement,
            ValkyrieAnnotationNode::class.java
        )
    }

    val modifiers: List<ValkyrieModifierNode>
        get() = this.getAnnotation()?.getModifiers() ?: emptyList()

    fun hasModifier(name: String): Boolean {
        return this.getAnnotation()?.hasModifier(name) ?: false
    }
}

