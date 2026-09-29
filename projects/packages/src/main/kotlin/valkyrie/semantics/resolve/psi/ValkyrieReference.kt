package valkyrie.semantics.resolve.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.util.IncorrectOperationException
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode
import valkyrie.semantics.resolve.ValkyrieSymbolResolver

/**
 * Backward-compatible identifier reference wrapper.
 */
class ValkyrieReference(element: ValkyrieIdentifierNode) : PsiReferenceBase<ValkyrieIdentifierNode>(element) {

    override fun resolve(): PsiElement? = ValkyrieSymbolResolver.resolve(element)

    override fun getVariants(): Array<Any> = ValkyrieSymbolResolver.collectCompletionVariants(element)

    override fun handleElementRename(newElementName: String): PsiElement {
        throw IncorrectOperationException("Rename not implemented")
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, element.textLength)
    }
}
