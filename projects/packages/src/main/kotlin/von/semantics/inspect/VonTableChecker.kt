package von.semantics.inspect

import von.surface.psi.VonPairNode
import von.surface.psi.VonTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement

class VonTableChecker : CheckerBase() {
    override fun check(element: PsiElement, holder: AnnotationHolder): CheckerAnnotatorResult =
        if (holder.isBatchMode) {
            CheckerAnnotatorResult.Ok
        } else {
            when (element) {
                is VonPairNode -> checkPair(element)
                else -> CheckerAnnotatorResult.Ok
            }
        }

    private fun checkPair(mapEntry: VonPairNode): CheckerAnnotatorResult {
        return CheckerAnnotatorResult.Ok
    }
}
