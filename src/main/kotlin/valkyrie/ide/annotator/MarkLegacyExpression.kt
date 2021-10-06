package valkyrie.ide.annotator

import com.intellij.codeInsight.highlighting.HyperlinkAnnotator
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.CodeInsightColors
import com.intellij.psi.PsiElement
import valkyrie.ide.actions.ast_transform.InsertElseBlock
import valkyrie.ide.actions.ast_transform.InsertElseIf
import valkyrie.ide.actions.ast_transform.ToLegacyIf
import valkyrie.ide.actions.ast_transform.ToModernIf
import valkyrie.language.psi_node.ValkyrieForStatementNode
import valkyrie.language.psi_node.ValkyrieIfStatementNode
import valkyrie.language.psi_node.ValkyrieIffStatementNode

class MarkLegacyExpression : HyperlinkAnnotator() {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is ValkyrieIfStatementNode -> {
                if (element.elseStatement == null) {
                    insertElseBlock(element, holder)
                } else {
                    insertElseIf(element.elseStatement!!, holder, true)
                }
                for (item in element.efStatementList) {
                    insertElseIf(item.firstChild, holder, true)
                    insertElseIf(item.firstChild, holder, false)
                }
                insertElseIf(element.firstChild!!, holder, false)
                val warn = element.elseStatement != null || element.efStatementList.isNotEmpty()
                toModernIf(element, holder, warn)
            }

            is ValkyrieIffStatementNode -> {
                toLegacyIf(element, holder)
            }

            is ValkyrieForStatementNode -> {
                if (element.elseStatement == null) {
                    insertElseBlock(element, holder)
                }
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

    private fun insertElseIf(element: PsiElement, holder: AnnotationHolder, above: Boolean) {
        val fixer = InsertElseIf(element, above);
        holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
            .range(element.textRange)
            .withFix(fixer)
            .create()
    }

    private fun insertElseBlock(element: ValkyrieIfStatementNode, holder: AnnotationHolder) {
        // 确保 if 末尾没有 else 语句
        val fixer = InsertElseBlock(element);
        holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
            .range(element.firstChild.textRange)
            .withFix(fixer)
            .create()
    }

    private fun insertElseBlock(element: ValkyrieForStatementNode, holder: AnnotationHolder) {
        val fixer = InsertElseBlock(element);
        holder.newAnnotation(HighlightSeverity.INFORMATION, fixer.getDescription())
            .range(element.firstChild.textRange)
            .withFix(fixer)
            .create()
    }
}

