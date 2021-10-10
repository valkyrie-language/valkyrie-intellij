package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import com.intellij.util.DocumentUtil
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.psi.ValkyrieClassField
import valkyrie.language.psi.ValkyrieRecursiveVisitor
import valkyrie.language.psi.ValkyrieTypes


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val psiRoot = element.psi
        if (psiRoot.language !is ValkyrieLanguage) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            psiRoot.containingFile,
            ValkyrieCodeStyleSettings::class.java
        )
        val psiDocumentManager = PsiDocumentManager.getInstance(psiRoot.project)
        val document = psiDocumentManager.getDocument(psiRoot.containingFile) ?: return range
        DocumentUtil.executeInBulk(document) {
            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
            psiRoot.accept(RewriteVisitor(document, settings))
            psiDocumentManager.commitDocument(document)
        }
        return range
    }
}

private class RewriteVisitor(private val text: Document, val settings: ValkyrieCodeStyleSettings) : ValkyrieRecursiveVisitor() {
    override fun visitClassField(o: ValkyrieClassField) {
        val delimiter = o.nextLeaf(true) ?: return;
        when (settings.class_field_trailing) {
            ValkyrieCodeStyleSettings.ClassFieldTrailing.IGNORE -> {
                // do nothing
            }
            ValkyrieCodeStyleSettings.ClassFieldTrailing.NEVER -> {
                if (delimiter.elementType == ValkyrieTypes.SEMICOLON || delimiter.elementType == ValkyrieTypes.COMMA) {
                    text.deleteString(delimiter.startOffset, delimiter.endOffset)
                }
            }

            ValkyrieCodeStyleSettings.ClassFieldTrailing.COMMA -> {
                if (delimiter.elementType == ValkyrieTypes.SEMICOLON) {
                    deleteNode(delimiter)
                }
                if (delimiter.elementType != ValkyrieTypes.COMMA) {
                    text.insertString(o.endOffset, ",")
                }
            }

            ValkyrieCodeStyleSettings.ClassFieldTrailing.SEMICOLON -> {
                if (delimiter.elementType == ValkyrieTypes.COMMA) {
                    deleteNode(delimiter)
                }
                if (delimiter.elementType != ValkyrieTypes.SEMICOLON) {
                    text.insertString(o.endOffset, ";")
                }
            }
        }
    }

    fun deleteNode(node: PsiElement) {
        text.deleteString(node.startOffset, node.endOffset)
    }
}


