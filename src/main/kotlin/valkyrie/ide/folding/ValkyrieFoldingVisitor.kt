package valkyrie.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.language.psi.*
import valkyrie.language.psi_node.ValkyrieStringNode

class ValkyrieFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {

    override fun visitImportBlock(o: ValkyrieImportBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }


    /**
     * For class, trait, and extends
     */
    override fun visitClassBlock(o: ValkyrieClassBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitUnionBlock(o: ValkyrieUnionBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
        val block = o.bitflagBlock
        fold(block.node, block.firstChild.endOffset, block.lastChild.startOffset)
        super.visitBitflagStatement(o)
    }

    override fun visitMatchBlock(o: ValkyrieMatchBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitNormalBlock(o: ValkyrieNormalBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitNewBlock(o: ValkyrieNewBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }
    override fun visitWhichBlock(o: ValkyrieWhichBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitDefineBlock(o: ValkyrieDefineBlock) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitDefineTuple(o: ValkyrieDefineTuple) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitTuple(o: ValkyrieTuple) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitList(o: ValkyrieList) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitObject(o: ValkyrieObject) {
        fold(o.node, o.firstChild.endOffset, o.lastChild.startOffset)
    }

    override fun visitString(o: ValkyrieString) {
        o as ValkyrieStringNode;
        fold(o.node, o.stringStartOffset(), o.stringEndOffset())
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }

    private fun fold(node: ASTNode, range: TextRange) {
        descriptors += FoldingDescriptor(node, range)
    }

    private fun fold(node: ASTNode, start: Int, end: Int) = when {
        end > start -> {
            descriptors += FoldingDescriptor(node, TextRange(start, end))
        }

        else -> {}
    }
}


