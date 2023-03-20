package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieFunctionParameter
import valkyrie.language.ast.ValkyrieLetStatement
import valkyrie.language.ast.classes.ValkyrieClassFieldNode

//import valkyrie.language.psi_node.ValkyrieClassFieldNode
//import valkyrie.language.psi_node.ValkyrieDefineItemNode
//import valkyrie.language.psi_node.ValkyrieLetStatementNode

class MarkImplicitTypes : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieLetStatement -> {
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
            }

            is ValkyrieClassFieldNode -> {
//                if (element.typeExpression == null) {
//                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
//                        .range(element.firstChild.textRange)
//                        .withFix(InferClassFieldType(element))
//                        .create()
//                }
            }

            is ValkyrieFunctionParameter -> {
//                if (element.typeExpression == null) {
//                    holder.newAnnotation(HighlightSeverity.INFORMATION, "Infer type")
//                        .range(element.firstChild.textRange)
//                        .withFix(InferDefineItemType(element))
//                        .create()
//                }
            }
        }
    }
}

