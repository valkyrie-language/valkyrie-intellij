package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieDeclareInterface
import yggdrasil.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon


abstract class MixinInterface(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    PsiNameIdentifierOwner,
    ValkyrieDeclareInterface {


    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierFree as? ValkyrieIdentifierNode
    }

    override fun getName(): String? {
        return nameIdentifier?.name ?: "⟪anonymous⟫"
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.ModuleGroup
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
    override fun highlight(visitor: NodeHighlighter) {
        visitor.highlight(this.firstChild, HighlightColor.SYM_MACRO)
        this.identifierFree?.let { visitor.highlight(it, HighlightColor.SYM_MACRO) }
    }
}

