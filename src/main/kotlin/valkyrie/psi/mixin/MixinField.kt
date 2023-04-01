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
import yggdrasil.psi.node.ValkyrieDeclareField
import yggdrasil.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinField(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    PsiNameIdentifierOwner,
    ValkyrieDeclareField {
    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.modifierList.lastOrNull()?.identifier as? ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return nameIdentifier?.text ?: ""
    }

    override fun setName(name: String): ValkyrieIdentifierNode {
        TODO("Not yet implemented")
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }

    override fun getPresentation(): ItemPresentation? {
        // annotations.identifierList.joinToString(" ")
        return PresentationData(name, "", baseIcon, null)
    }


    override fun highlight(visitor: NodeHighlighter) {
        if (modifierList.isNotEmpty()) {
            for (mod in modifierList.subList(0, modifierList.size - 1)) {
                visitor.highlight(mod, HighlightColor.KEYWORD)
            }
            nameIdentifier?.let { visitor.highlight(it, HighlightColor.SYM_FIELD) }
        }

    }
}