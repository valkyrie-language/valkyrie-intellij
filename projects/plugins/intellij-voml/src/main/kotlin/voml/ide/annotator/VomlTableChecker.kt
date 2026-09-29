package voml.ide.annotator

import voml.language.psi.VomlPairNode
import voml.language.psi.VomlTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement

class VomlTableChecker : CheckerBase() {
    override fun check(element: PsiElement, holder: AnnotationHolder): CheckerAnnotatorResult =
        if (holder.isBatchMode) {
            CheckerAnnotatorResult.Ok
        } else {
            when (element) {
                is VomlPairNode -> checkPair(element)
                else -> CheckerAnnotatorResult.Ok
            }
        }

    private fun checkPair(mapEntry: VomlPairNode): CheckerAnnotatorResult {
        return CheckerAnnotatorResult.Ok
    }
}
