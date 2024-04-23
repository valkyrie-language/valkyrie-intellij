package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import valkyrie.ide.actions.*
import valkyrie.psi.node.ValkyrieDeclareFunction
import valkyrie.psi.node.ValkyrieLetStatement

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
    }
}

private class LintInferType(holder: AnnotationHolder) : ValkyrieAnnotator(holder) {
    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        var missingParameterType = false;
        for (parameter in o.parameterBody?.parameterItemList ?: listOf()) {
            if (parameter.typeHint == null) {
                missingParameterType = true;
                holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
                    .range(parameter.textRange)
                    .withFix(InferFunctionParameterType(parameter, o))
                    .create()
            }
        }
        if (o.returnType == null) {
            missingParameterType = true;
            holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
                .range(o.textRange)
                .withFix(InferFunctionReturnType(o))
                .create()
        }
        if (o.effectType == null) {
            holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
                .range(o.textRange)
                .withFix(InferFunctionReturnEffect(o))
                .create()
        }
        if (missingParameterType) {
            holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
                .range(o.textRange)
                .withFix(InferFunctionTypeAll(o))
                .create()
        }
    }

    override fun visitLetStatement(o: ValkyrieLetStatement) {
        if (o.typeHint == null) {
            holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
                .range(o.textRange)
                .withFix(InferVariableType(o))
                .create()


        }
    }
}


