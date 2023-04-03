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
import yggdrasil.psi.node.ValkyrieDeclareSemantic
import yggdrasil.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinSemantic(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement, PsiNameIdentifierOwner, ValkyrieDeclareSemantic {
    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierFree as? ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return nameIdentifier?.text ?: ""
    }

    override fun setName(name: String): ValkyrieIdentifierNode {
        TODO("Not yet implemented")
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Constant
    }

    override fun getPresentation(): ItemPresentation? {
        // annotations.identifierList.joinToString(" ")
        return PresentationData(name, "", baseIcon, null)
    }

    override fun highlight(highlighter: NodeHighlighter) {
        nameIdentifier?.let { highlighter.highlight(it, HighlightColor.SYM_FIELD) }
    }
}