package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieDeclareNamespace
import yggdrasil.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinNamespace(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    PsiNameIdentifierOwner,
    ValkyrieDeclareNamespace {

    override fun getName(): String? {
        return this.nameIdentifier?.name ?: "⟪anonymous⟫"
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.namepathFree?.lastChild as? ValkyrieIdentifierNode
    }


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.DataSchema
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}

