package valkyrie.semantic.resolve

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode

/**
 * Function call reference resolved through the unified symbol resolver.
 */
class ValkyrieFunctionCallReference(
    element: ValkyrieIdentifierNode,
    textRange: TextRange,
) : PsiReferenceBase<ValkyrieIdentifierNode>(element, textRange) {

    override fun resolve(): PsiElement? = ValkyrieSymbolResolver.resolve(element)

    override fun getVariants(): Array<Any> = ValkyrieSymbolResolver.collectCompletionVariants(element)

    override fun handleElementRename(newElementName: String): PsiElement = element
}
