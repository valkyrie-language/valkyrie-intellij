package voml.editing.folding

import voml.surface.file.VomlFile
import voml.surface.psi.VomlTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class VomlFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean,
    ) {
        if (root !is VomlFile) return
        PsiTreeUtil.processElements(root) { element ->
            when (element.node.elementType) {
                VomlTypes.TABLE,
                VomlTypes.INCLUDE_STATEMENT,
                VomlTypes.INHERIT_STATEMENT,
                -> descriptors += FoldingDescriptor(element.node, element.textRange)

                VomlTypes.BLOCK_COMMENT -> descriptors += FoldingDescriptor(element.node, element.textRange)
            }
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) =
        when (node.elementType) {
            VomlTypes.TABLE -> "[...]"
            else -> "{...}"
        }

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}
