package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieForStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ScopeNode {
    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Operator
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("for", null, getIcon(0), null)
    }

    override fun getContext(): ScopeNode? {
        return parentScope
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }
}

