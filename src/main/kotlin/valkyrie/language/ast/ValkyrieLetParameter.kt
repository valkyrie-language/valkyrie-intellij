package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.antlr.register
import valkyrie.language.psi.ValkyrieHighlightElement
import javax.swing.Icon

class ValkyrieLetParameter(node: CompositeElement) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner, ValkyrieHighlightElement {
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

    override fun getIcon(flags: Int): Icon {
        return AllIcons.Nodes.Parameter
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.getIcon(0))
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

    override fun highlight(info: HighlightInfoHolder) {
        if (mutable) {
            info.register(nameIdentifier, ValkyrieHighlightColor.SYM_LOCAL_MUT)
        } else {
            info.register(nameIdentifier, ValkyrieHighlightColor.SYM_LOCAL)
        }
        for (mod in modifiers) {
            info.register(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }
}