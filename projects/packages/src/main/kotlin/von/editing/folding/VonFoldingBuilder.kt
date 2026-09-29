package von.editing.folding

import von.surface.file.VonFile
import von.surface.psi.VonTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class VonFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean,
    ) {
        if (root !is VonFile) return
        PsiTreeUtil.processElements(root) { element ->
            when (element.node.elementType) {
                VonTypes.TABLE,
                VonTypes.INCLUDE_STATEMENT,
                VonTypes.INHERIT_STATEMENT,
                -> descriptors += FoldingDescriptor(element.node, element.textRange)

                VonTypes.BLOCK_COMMENT -> descriptors += FoldingDescriptor(element.node, element.textRange)
            }
            true
        }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange) =
        when (node.elementType) {
            VonTypes.TABLE -> "[...]"
            else -> "{...}"
        }

    override fun isRegionCollapsedByDefault(node: ASTNode) = false
}
