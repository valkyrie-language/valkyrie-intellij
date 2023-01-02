package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil

class ValkyrieForParameter(node: CompositeElement) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {
    private val _identifier by lazy { findIdentifier() }
    val modifiers by lazy { findModifiers() };
    val mutable by lazy { isMutable() };
    override fun getName(): String {
        return _identifier.text
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier
    }

    private fun findModifiers(): List<ValkyrieIdentifierNode> {
        val all = PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifierNode::class.java);
        return all.dropLast(1);
    }

    // Need to be lazy, otherwise it will be an infinite loop
    private fun findIdentifier(): ValkyrieIdentifierNode {
        val all = PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifierNode::class.java);
        return all.last()
    }

    private fun isMutable(): Boolean {
        for (m in modifiers) {
            if (m.name == "mut" || m.name == "mutable") {
                return true
            }
        }
        return false
    }
}