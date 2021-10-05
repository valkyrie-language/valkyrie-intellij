package valkyrie.ide.annotator

import com.intellij.codeInsight.highlighting.HyperlinkAnnotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.CodeInsightColors
import com.intellij.psi.PsiElement
import valkyrie.ide.actions.ast_transform.InsertElseIf
import valkyrie.ide.actions.ast_transform.ToLegacyIf
import valkyrie.ide.actions.ast_transform.ToModernIf
import valkyrie.language.psi_node.ValkyrieEfStatementNode
import valkyrie.language.psi_node.ValkyrieElseStatementNode
import valkyrie.language.psi_node.ValkyrieIfStatementNode
import valkyrie.language.psi_node.ValkyrieIffStatementNode

class MarkLegacyExpression : HyperlinkAnnotator() {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieIfStatementNode -> {
                val warn = element.elseStatement != null || element.efStatementList.isNotEmpty()
                toModernIf(element, holder, warn)

            }

            is ValkyrieIffStatementNode -> {
                toLegacyIf(element, holder)
            }
        }
    }

    private fun toModernIf(element: ValkyrieIfStatementNode, holder: AnnotationHolder, warn: Boolean) {
        val fixer = ToModernIf(element);
        if (warn) {
            holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
                .range(element.firstChild.textRange)
                .withFix(fixer)
                .textAttributes(CodeInsightColors.WEAK_WARNING_ATTRIBUTES)
                .create()
        } else {
            holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
                .range(element.firstChild.textRange)
                .withFix(fixer)
                .create()
        }
    }

    private fun toLegacyIf(element: ValkyrieIffStatementNode, holder: AnnotationHolder) {
        val fixer = ToLegacyIf(element);
        holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
            .range(element.firstChild.textRange)
            .withFix(fixer)
            .create()
    }
    private fun insertElseIfBranch(element: ValkyrieElseStatementNode, holder: AnnotationHolder) {
        val fixer = InsertElseIf(element);
        holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
            .range(element.firstChild.textRange)
            .withFix(fixer)
            .create()
    }

}

