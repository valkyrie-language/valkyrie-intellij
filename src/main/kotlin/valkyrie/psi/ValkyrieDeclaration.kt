package valkyrie.psi

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.refactoring.suggested.startOffset
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.node.ValkyrieIdentifierNode

abstract class ValkyrieDeclaration : ValkyrieElement, PsiNameIdentifierOwner {
    open val color: HighlightColor? = null

    constructor(node: ASTNode) : super(node)

    abstract override fun getNameIdentifier(): ValkyrieIdentifierNode?;

    override fun getName(): String {
        return nameIdentifier?.name ?: super.getName()
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

    companion object {
        fun getCaretDeclaration(editor: Editor, file: PsiFile): ValkyrieDeclaration? {
            val leaf = file.findElementAt(editor.caretModel.offset) ?: return null
            return getCaretDeclaration(leaf)
        }


        fun getCaretDeclaration(element: PsiElement): ValkyrieDeclaration? {
            for (ancestor in element.ancestors) {
                if (ancestor is ValkyrieDeclaration) {
                    return ancestor
                }
            }
            return null
        }
    }
}