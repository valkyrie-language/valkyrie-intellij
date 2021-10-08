package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.editor.Document
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import com.intellij.util.DocumentUtil
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.psi.ValkyrieRecursiveVisitor


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val rootPsi = element.psi
        if (rootPsi.language !is ValkyrieLanguage) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            rootPsi.containingFile,
            ValkyrieCodeStyleSettings::class.java
        )
        if (settings.KEEP_TRAILING_COMMA) {
            return range
        }
        val psiDocumentManager = PsiDocumentManager.getInstance(rootPsi.project)
        val document = psiDocumentManager.getDocument(rootPsi.containingFile) ?: return range
        DocumentUtil.executeInBulk(document) {
            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
            val visitor: PsiElementVisitor = RewriteVisitor(document)
            rootPsi.accept(visitor)
            psiDocumentManager.commitDocument(document)
        }
        return range
    }
}

private class RewriteVisitor(private val text: Document) : ValkyrieRecursiveVisitor() {


    private fun deleteNode(node: ASTNode) {
//        val length = node.textLength
//        myDocument.deleteString(node.startOffset + myOffsetDelta, node.startOffset + length + myOffsetDelta)
//        myOffsetDelta -= length
    }
}