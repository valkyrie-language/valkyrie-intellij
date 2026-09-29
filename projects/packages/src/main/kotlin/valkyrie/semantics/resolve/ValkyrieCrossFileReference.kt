package valkyrie.semantics.resolve

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode

/**
 * Identifier reference backed by the unified symbol resolver.
 */
class ValkyrieCrossFileReference(
    element: ValkyrieIdentifierNode,
    textRange: TextRange,
) : PsiReferenceBase<ValkyrieIdentifierNode>(element, textRange) {

    override fun resolve(): PsiElement? = ValkyrieSymbolResolver.resolve(element)

    override fun getVariants(): Array<Any> = ValkyrieSymbolResolver.collectCompletionVariants(element)

    override fun handleElementRename(newElementName: String): PsiElement = element
}
