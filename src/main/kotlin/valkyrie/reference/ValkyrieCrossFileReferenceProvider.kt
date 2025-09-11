package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * 跨文件引用提供者
 */
class ValkyrieCrossFileReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<out PsiReference?> {
        if (element is ValkyrieIdentifierNode) {
            val textRange = TextRange(0, element.textLength)
            return arrayOf(ValkyrieCrossFileReference(element, textRange))
        }
        return emptyArray()
    }
}