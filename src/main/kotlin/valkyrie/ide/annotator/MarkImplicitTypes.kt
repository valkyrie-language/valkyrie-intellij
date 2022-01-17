package valkyrie.ide.annotator

import com.intellij.codeInsight.highlighting.HyperlinkAnnotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassFieldNode
import valkyrie.language.ast.ValkyrieFunctionParameterItem
import valkyrie.language.ast.ValkyrieLetStatementNode

//import valkyrie.language.psi_node.ValkyrieClassFieldNode
//import valkyrie.language.psi_node.ValkyrieDefineItemNode
//import valkyrie.language.psi_node.ValkyrieLetStatementNode

class MarkImplicitTypes : HyperlinkAnnotator() {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieLetStatementNode -> {
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

            is ValkyrieFunctionParameterItem -> {
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

