package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.ExpUiIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import javax.swing.Icon

class ValkyrieObjectStatement(node: CompositeElement) : ASTWrapperPsiElement(node) {
    override fun getBaseIcon(): Icon {
        return ExpUiIcons.Nodes.ClassAnonymous
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("object", null, this.baseIcon, null)
    }
}