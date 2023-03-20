package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyle
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.traversal
import valkyrie.language.psi.ValkyrieRewritableElement

//import valkyrie.language.psi_node.ValkyrieClassStatementNode


class ValkyrieBeforeFormat : PreFormatProcessor {
    override fun process(element: ASTNode, range: TextRange): TextRange {
        val psiRoot = element.psi
        if (psiRoot.language !is ValkyrieLanguage) {
            return range
        }
        val settings = CodeStyle.getCustomSettings(
            psiRoot.containingFile, ValkyrieCodeStyleSettings::class.java
        )
        val psiDocumentManager = PsiDocumentManager.getInstance(psiRoot.project)
        val document = psiDocumentManager.getDocument(psiRoot.containingFile) ?: return range
        val writer = ValkyrieRewriter(document, settings);
        psiRoot.traversal {
            if (it is ValkyrieRewritableElement) {
                it.on_rewrite(writer)
            }
            true
        }

//        DocumentUtil.executeInBulk(document) {
//            psiDocumentManager.doPostponedOperationsAndUnblockDocument(document)
//            val writer = ValkyrieRewriter(document, settings);
//            psiRoot.traversal {
//                if (it is ValkyrieRewritableElement) {
//                    it.on_rewrite(writer)
//                }
//                true
//            }
//
//            psiDocumentManager.commitDocument(document)
//        }
        return range
    }
}


