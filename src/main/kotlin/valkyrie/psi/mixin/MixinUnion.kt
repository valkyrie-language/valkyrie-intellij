package valkyrie.psi.mixin

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
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
import yggdrasil.psi.node.ValkyrieDeclareUnion
import yggdrasil.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinUnion(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement, PsiNameIdentifierOwner, ValkyrieDeclareUnion {
    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }


    override fun getName(): String {
        return this.identifier?.text ?: ""
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.AbstractClass
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }

    override fun createLookup(completions: MutableList<LookupElement>) {
        this.identifier?.let {
            completions.add(
                LookupElementBuilder.create(it)
                    .withIcon(baseIcon)
                    .withCaseSensitivity(false)
                    .withTypeText("withTypeText")
                    .withPresentableText(name)
                    .withTailText(" withTailText")
            )
        }
    }
    override fun highlight(visitor: NodeHighlighter) {
        visitor.highlight(this.firstChild, HighlightColor.SYM_MACRO)
        this.identifier?.let { visitor.highlight(it, HighlightColor.SYM_MACRO) }
    }
}