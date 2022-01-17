package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil

class ModifiedNamepath(node: CompositeElement) : ASTWrapperPsiElement(node) {
    companion object {
        private fun findItems(node: PsiElement): Array<ValkyrieIdentifierNode> {
            val proxy = PsiTreeUtil.findChildOfType(node, ModifiedNamepath::class.java);
            val items = PsiTreeUtil.findChildrenOfType(proxy, ValkyrieIdentifierNode::class.java);
            return items.toTypedArray()
        }

        // Need to be lazy, otherwise it will be an infinite loop
        fun findIdentifier(node: PsiElement): ValkyrieIdentifierNode {
            return findItems(node).last()
        }

        // Need to be lazy, otherwise it will be an infinite loop
        fun findModifiers(node: PsiElement): Array<ValkyrieIdentifierNode> {
            return findItems(node).dropLast(1).toTypedArray()
        }
    }
}