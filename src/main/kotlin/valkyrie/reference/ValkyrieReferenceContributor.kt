package valkyrie.reference

import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import valkyrie.psi.impl.ValkyrieIdentifierExpressionImpl

/**
 * Valkyrie 引用贡献者
 */
class ValkyrieReferenceContributor : PsiReferenceContributor() {
    
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ValkyrieIdentifierExpressionImpl::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element is ValkyrieIdentifierExpressionImpl) {
                        val reference = element.reference
                        return if (reference != null) arrayOf(reference) else emptyArray()
                    }
                    return emptyArray()
                }
            }
        )
    }
}