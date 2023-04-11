package valkyrie.ide.folding

import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.psi.node.ValkyrieBlockBody
import valkyrie.psi.node.ValkyrieClassBody
import valkyrie.psi.node.ValkyrieEnumerateBody
import valkyrie.psi.node.ValkyrieUsingBody


class ValkyrieFoldVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {

    override fun visitUsingBody(o: ValkyrieUsingBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitEnumerateBody(o: ValkyrieEnumerateBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitBlockBody(o: ValkyrieBlockBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }


    private fun fold(node: PsiElement, start: Int, end: Int) {
        if (end > start) {
            descriptors += FoldingDescriptor(node.node, TextRange(start, end))
        }
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
