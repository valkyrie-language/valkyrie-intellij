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
import valkyrie.psi.node.ValkyrieUsingBodyNode

class ValkyrieFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(descriptors: MutableList<FoldingDescriptor>, root: PsiElement, document: Document, quick: Boolean) {
        if (root !is ValkyrieFileNode) return
        val visitor = ValkyrieFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) { it.accept(visitor); true }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange): String {
        val builder = ValkyriePlaceholderVisitor()
        node.psi.accept(builder)
        return builder.placeholder
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

