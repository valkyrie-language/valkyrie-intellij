package valkyrie.psi

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.refactoring.suggested.startOffset
import valkyrie.psi.node.ValkyrieIdentifierNode

abstract class ValkyrieDeclareElement(node: ASTNode) : ValkyrieElement(node), PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): ValkyrieIdentifierNode?;

    override fun getName(): String? {
        return nameIdentifier?.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this.firstChild
    }

    override fun getTextOffset(): Int {
        return navigationElement.startOffset
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(name, "", baseIcon, null)
    }

    fun createLookup(completions: MutableList<LookupElement>) {
        nameIdentifier?.let {
            completions.add(
                LookupElementBuilder.create(it)
                    .withIcon(baseIcon)
                    .withCaseSensitivity(false)
                    .withTypeText("withTypeText")
                    .withPresentableText(name ?: "⟪anonymous⟫")
                    .withTailText(" atomic", true)
            )
        }
    }
}