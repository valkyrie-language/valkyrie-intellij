package valkyrie.ide.reference.declaration

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import valkyrie.psi.node.ValkyrieModifier
import valkyrie.psi.node.ValkyrieModifierNode

class ValkyrieModifierReference : PsiReference {
    private val modifier: ValkyrieModifierNode

    constructor(modifier: ValkyrieModifier) {
        this.modifier = modifier as ValkyrieModifierNode
    }

    override fun getElement(): ValkyrieModifierNode {
        return modifier
    }

    override fun getRangeInElement(): TextRange {
        return modifier.textRange
    }

    override fun resolve(): PsiElement? {
        return modifier.parent
    }

    override fun getCanonicalText(): String {
        TODO("Not yet implemented")
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSoft(): Boolean {
        TODO("Not yet implemented")
    }
}