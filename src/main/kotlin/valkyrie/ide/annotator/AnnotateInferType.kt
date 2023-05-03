package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieParameterItem

class AnnotateInferType : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        element.accept(LintInferType(holder))
//        when (element) {
//            is ValkyrieLetStatement -> {
//                if (element.typeExpressionList.isEmpty()) {
//                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
//                        .range(element.firstChild.textRange)
//                        .withFix(InferLetType(element, true))
//                        .create()
//                } else {
//                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Remove the obvious type")
//                        .range(element.firstChild.textRange)
//                        .withFix(InferLetType(element, false))
//                        .create()
//                }
//            }
//
//            is ValkyrieClassFieldNode -> {
//                if (element.typeExpression == null) {
//                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
//                        .range(element.firstChild.textRange)
//                        .withFix(InferClassFieldType(element))
//                        .create()
//                }
//            }
//
//            is ValkyrieFunctionParameter -> {
//                if (element.typeExpression == null) {
//                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
//                        .range(element.firstChild.textRange)
//                        .withFix(InferDefineItemType(element))
//                        .create()
//                }
//            }
//        }
    }
}

private class LintInferType(holder: AnnotationHolder) : ValkyrieAnnotator(holder) {
    override fun visitParameterItem(o: ValkyrieParameterItem) {
        super.visitParameterItem(o)
    }
}


