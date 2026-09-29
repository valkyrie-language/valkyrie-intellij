package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * Provides identifier references only for real usages, not declarations or dedicated reference hosts.
 */
class ValkyrieCrossFileReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext,
    ): Array<out PsiReference?> {
        if (element !is ValkyrieIdentifierNode) {
            return PsiReference.EMPTY_ARRAY
        }
        if (!ValkyrieReferenceContext.isResolvableUsage(element)) {
            return PsiReference.EMPTY_ARRAY
        }
        return arrayOf(ValkyrieCrossFileReference(element, TextRange(0, element.textLength)))
    }

    companion object {
        val IDENTIFIER_USAGE_PATTERN =
            PlatformPatterns.psiElement(ValkyrieIdentifierNode::class.java)
                .with(object : com.intellij.patterns.PatternCondition<ValkyrieIdentifierNode>("ValkyrieIdentifierUsage") {
                    override fun accepts(identifier: ValkyrieIdentifierNode, context: ProcessingContext?): Boolean {
                        return ValkyrieReferenceContext.isResolvableUsage(identifier)
                    }
                })
    }
}
