package valkyrie.ide.annotator

import com.intellij.codeInsight.highlighting.HyperlinkAnnotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.actions.ast_transform.CreateNamespace
import valkyrie.ide.actions.ast_transform.DeleteThis
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi.childrenOfType
import valkyrie.language.psi.endSemicolon
import valkyrie.language.psi_node.ValkyrieNamespaceStatementNode

class CheckNamespace : HyperlinkAnnotator() {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieFileNode -> annotateFile(element, holder)
            is ValkyrieNamespaceStatementNode -> annotateNamespace(element, holder)
        }
    }

    private fun annotateFile(element: ValkyrieFileNode, holder: AnnotationHolder) {
        val child = element.childrenOfType<ValkyrieNamespaceStatementNode>()
        if (child.isEmpty()) {
            val fixer = CreateNamespace(element)
            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, fixer.getDescription())
                .range(TextRange.EMPTY_RANGE)
                .withFix(fixer)
                .create()
        }
        if (child.count() > 1) {
            for (item in child) {
                val fixer = DeleteThis(item, item.endSemicolon())
                holder.newAnnotation(HighlightSeverity.ERROR, ValkyrieBundle.message("annotator.namespace.duplicated"))
                    .range(item.textRange)
                    .withFix(fixer)
                    .create()
            }
        }
    }

    private fun annotateNamespace(element: ValkyrieNamespaceStatementNode, holder: AnnotationHolder) {
        if (element.parent !is ValkyrieFileNode) {
            holder.newAnnotation(HighlightSeverity.ERROR, ValkyrieBundle.message("annotator.namespace.non-top"))
                .range(element.textRange)
//                .withFix(fixer)
                .create()
        }

        if (PsiTreeUtil.skipWhitespacesAndCommentsBackward(element) != null) {
            holder.newAnnotation(HighlightSeverity.WARNING, ValkyrieBundle.message("annotator.namespace.non-first"))
                .range(element.textRange)
                .create()
        }
    }
}

