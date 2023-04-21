package valkyrie.psi.mixin

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieDeclareFlags
import valkyrie.psi.node.ValkyrieEnumerateItem
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinFlags(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement, PsiNameIdentifierOwner, ValkyrieDeclareFlags {
    val flagItems = enumerateBody?.enumerateItemList?.map { it.firstChild } ?: listOf();
    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return nameIdentifier?.name ?: "⟪anonymous flags⟫"
    }

    override fun setName(name: String): ValkyrieIdentifierNode {
        TODO("Not yet implemented")
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Flags
    }


    override fun getPresentation(): ItemPresentation {
        // annotations.identifierList.joinToString(" ")
        return PresentationData(name, "", baseIcon, null)
    }

    override fun createLookup(completions: MutableList<LookupElement>) {
        this.nameIdentifier?.let {
            completions.add(
                LookupElementBuilder.create(it)
                    .withIcon(baseIcon)
                    .withCaseSensitivity(false)
                    .withTypeText("withTypeText")
                    .withPresentableText(name)
                    .withTailText(" atomic", true)
            )
        }
    }

    fun flagItems(): List<ValkyrieEnumerateItem> {
        return this.enumerateBody?.enumerateItemList ?: listOf()
    }
}