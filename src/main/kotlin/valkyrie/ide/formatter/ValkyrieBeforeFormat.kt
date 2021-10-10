package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
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

private class RewriteVisitor(private val text: Document, settings: ValkyrieCodeStyleSettings) : ValkyrieRecursiveVisitor() {
    override fun visitClassField(o: ValkyrieClassField) {
        o.nextLeaf(false)?.let {
            println(it)
            if (it.elementType == ValkyrieTypes.SEMICOLON) {
                it.delete()
            }
        }
    }

    private fun deleteNode(node: ASTNode) {
//        val length = node.textLength
//        myDocument.deleteString(node.startOffset + myOffsetDelta, node.startOffset + length + myOffsetDelta)
//        myOffsetDelta -= length
    }
}

