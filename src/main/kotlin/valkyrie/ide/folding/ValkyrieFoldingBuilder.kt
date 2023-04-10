package valkyrie.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.file.ValkyrieFileNode
import yggdrasil.psi.node.*

class ValkyrieFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(descriptors: MutableList<FoldingDescriptor>, root: PsiElement, document: Document, quick: Boolean) {
        if (root !is ValkyrieFileNode) return
        val visitor = ValkyrieFoldVisitor(descriptors)
        PsiTreeUtil.processElements(root) { it.accept(visitor); true }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) = when (val psi = node.psi) {
        is ValkyrieUsingBodyNode -> "${psi.usingTermList.size} items"
        is ValkyrieClassBodyNode -> {
            var fields = 0;
            var methods = 0;
            for (item in psi.classItemList) {
                when (item.firstChild) {
                    is ValkyrieDeclareField -> {
                        fields += 1
                    }

                    is ValkyrieDeclareMethod -> {
                        methods += 1
                    }
                }
            }

            "$fields fields, $methods methods"
        }

        is ValkyrieEnumerateBodyNode -> {
            var counter = 0;
            for (item in psi.enumerateItemList) {
                if (item.firstChild is ValkyrieDeclareSemantic) {
                    counter += 1
                }
            }

            "$counter variants"
        }


        else -> "..."
    }


    override fun isRegionCollapsedByDefault(node: ASTNode) = when (node.psi) {
        is ValkyrieUsingBodyNode -> true
        else -> false
    }

    override fun isCustomFoldingRoot(node: ASTNode): Boolean {
        return super.isCustomFoldingRoot(node)
    }

    override fun isCustomFoldingCandidate(node: ASTNode): Boolean {
        return super.isCustomFoldingCandidate(node)
    }
}

