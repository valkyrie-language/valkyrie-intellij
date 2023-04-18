package valkyrie.psi.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieTraitAlias
import javax.swing.Icon

abstract class MixinTraitAlias(node: ASTNode) : ValkyrieElement(node), PsiNameIdentifierOwner, ValkyrieTraitAlias {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }


    override fun getName(): String {
        return nameIdentifier?.name ?: "⟪anonymous trait⟫"
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this.firstChild
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }


    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }
}