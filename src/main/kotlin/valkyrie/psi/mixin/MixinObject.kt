package valkyrie.psi.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieNewObject
import javax.swing.Icon

abstract class MixinObject(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement, ValkyrieNewObject {
    override fun getNavigationElement(): PsiElement {
        return this.firstChild
    }


    override fun getName(): String {
        return "⟪anonymous class⟫"
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Object
    }


    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }
}