package valkyrie.ide.annotator

import com.intellij.codeInsight.highlighting.HyperlinkAnnotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import valkyrie.ide.actions.InferLetType
import valkyrie.language.psi_node.ValkyrieLetStatementNode

class MarkTypeInfer : HyperlinkAnnotator() {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieLetStatementNode -> {
                if (element.typeExpressionList.isEmpty()) {
                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
                        .range(element.firstChild.textRange)
                        .withFix(InferLetType(element, true))
                        .create()
                } else {
                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Remove type")
                        .range(element.firstChild.textRange)
                        .withFix(InferLetType(element, false))
                        .create()
                }
            }
        }
    }
}

