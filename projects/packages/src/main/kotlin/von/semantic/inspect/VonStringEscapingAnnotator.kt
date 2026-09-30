package von.semantic.inspect

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class VonStringEscapingAnnotator : AnnotatorBase() {
    override fun annotateInternal(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            // is VonStringInline -> annotateStringInline(element, holder)
            else -> {}
        }
    }

    private fun annotateStringInline(element: PsiElement, holder: AnnotationHolder) {
        val message = "invalid escape";
        holder.newAnnotation(HighlightSeverity.ERROR, message).create()
    }
}
