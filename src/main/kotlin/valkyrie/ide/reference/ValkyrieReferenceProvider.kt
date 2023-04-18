package valkyrie.ide.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceService
import com.intellij.util.ProcessingContext


class ValkyrieReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        println("getReferencesByElement(${element}, ${context})")
        return arrayOf()
    }

    override fun acceptsTarget(target: PsiElement): Boolean {
        println("getReferencesByElement(${target})")
        return super.acceptsTarget(target)
    }

    override fun acceptsHints(element: PsiElement, hints: PsiReferenceService.Hints): Boolean {
        println("acceptsHints(${element})")
        return super.acceptsHints(element, hints)
    }
}
