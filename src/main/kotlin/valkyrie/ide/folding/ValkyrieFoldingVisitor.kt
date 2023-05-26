package valkyrie.ide.folding

import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import com.intellij.psi.tree.IElementType
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.psi.findPair
import valkyrie.psi.node.*


class ValkyrieFoldingVisitor : ValkyrieVisitor, PsiRecursiveVisitor {

    private val descriptors: MutableList<FoldingDescriptor>

    constructor(descriptors: MutableList<FoldingDescriptor>) : super() {
        this.descriptors = descriptors
    }

    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }

    override fun visitUsingBody(o: ValkyrieUsingBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitClassInherit(o: ValkyrieClassInherit) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }


    override fun visitEnumerateBody(o: ValkyrieEnumerateBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitUniteBody(o: ValkyrieUniteBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitBlockBody(o: ValkyrieBlockBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitMatchBody(o: ValkyrieMatchBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitNewBody(o: ValkyrieNewBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitParameterBody(o: ValkyrieParameterBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitArgumentBody(o: ValkyrieArgumentBody) {
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset)
    }


    private fun PsiElement.foldPair(lhs: IElementType, rhs: IElementType) {
        val pair = this.findPair(lhs, rhs) ?: return
        fold(this, pair.first.startOffset, pair.second.endOffset)
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
