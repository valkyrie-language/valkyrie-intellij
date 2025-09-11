package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Modifier List 实现
 */
class ValkyrieModifierListNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getModifiers(): List<String> {
        return findChildrenByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
            .mapNotNull { it.text }
    }
}