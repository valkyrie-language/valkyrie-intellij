package com.github.valkyrie.ide.matcher


import com.github.valkyrie.ide.view.VkFile
import com.github.valkyrie.language.psi.FluentTypes.BRACE_BLOCK
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class VkFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is VkFile) return
        val visitor = VkFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) {
            it.accept(visitor);
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) =
        when (node.elementType) {
//            BRACKET_BLOCK -> "[...]"
            BRACE_BLOCK -> "{...}"
            else -> "..."
        }

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}

