package valkyrie.language.ast


import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.antlr.ValkyrieParser


class ModifiedIdentifier(node: CompositeElement) : ASTWrapperPsiElement(node) {
    companion object {
        fun findItems(node: PsiElement): List<ValkyrieIdentifierNode> {
            val proxy = PsiTreeUtil.getChildOfType(node, ModifiedIdentifier::class.java)
            return PsiTreeUtil.getChildrenOfTypeAsList(proxy, ValkyrieIdentifierNode::class.java);
        }

        // Need to be lazy, otherwise it will be an infinite loop
        fun findIdentifier(node: PsiElement): ValkyrieIdentifierNode? {
            return findItems(node).lastOrNull()
        }

        // Need to be lazy, otherwise it will be an infinite loop
        fun findModifiers(node: PsiElement): List<ValkyrieIdentifierNode> {
            return findItems(node).dropLast(1)
        }

        fun extractModifiers(node: PsiElement): List<ValkyrieIdentifierNode> {
            val modifiers = ValkyrieParser.getChildOfType(node, ValkyrieParser.RULE_modifiers);
            return emptyList()
        }
    }
}

