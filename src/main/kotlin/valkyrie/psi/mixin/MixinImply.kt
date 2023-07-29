package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareImply
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinImply(node: ASTNode) : ValkyrieElement(node), ValkyrieDeclareImply {
    val id = this.namepath?.identifierList?.lastOrNull() as? ValkyrieIdentifierNode

    override fun getName(): String {
        return id?.name ?: "⟪anonymous imply⟫"
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.IdeaModule
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}

val ValkyrieDeclareImply.keyword: PsiElement
    get() {
        return findKeyword(ValkyrieTypes.KW_IMPLY)
    }

