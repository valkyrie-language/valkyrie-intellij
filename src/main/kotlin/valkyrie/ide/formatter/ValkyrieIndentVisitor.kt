package valkyrie.ide.formatter

import com.intellij.formatting.Indent
import com.intellij.lang.ASTNode
import valkyrie.psi.node.*

class ValkyrieIndentVisitor(val child: ASTNode) : ValkyrieVisitor() {
    var indent: Indent? = Indent.getNoneIndent()

    override fun visitInferBody(o: ValkyrieInferBody) {
        byCorner(o.node)
    }

    override fun visitDeclareWhere(o: ValkyrieDeclareWhere) {
        notFirst(o.node)
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        byCorner(o.node)
    }

    override fun visitUniteBody(o: ValkyrieUniteBody) {
        byCorner(o.node)
    }

    override fun visitMatchBody(o: ValkyrieMatchBody) {
        byCorner(o.node)
    }

    override fun visitFlagsBody(o: ValkyrieFlagsBody) {
        byCorner(o.node)
    }

    override fun visitBlockBody(o: ValkyrieBlockBody) {
        byCorner(o.node)
    }

    override fun visitBlockBare(o: ValkyrieBlockBare) {
        indent = Indent.getNormalIndent()
    }

    override fun visitCasePatternDict(o: ValkyrieCasePatternDict) {
        byCorner(o.node)
    }

    override fun visitTypePatternObject(o: ValkyrieTypePatternObject) {
        byCorner(o.node)
    }

    override fun visitNewBody(o: ValkyrieNewBody) {
        byCorner(o.node)
    }

    override fun visitOffsetRange(o: ValkyrieOffsetRange) {
        byCorner(o.node)
    }

    override fun visitOrdinalRange(o: ValkyrieOrdinalRange) {
        byCorner(o.node)
    }

    override fun visitParameterBody(o: ValkyrieParameterBody) {
        byCorner(o.node)
    }

    override fun visitArgumentBody(o: ValkyrieArgumentBody) {
        byCorner(o.node)
    }

    override fun visitTuple(o: ValkyrieTuple) {
        byCorner(o.node)
    }

    private fun byCorner(parent: ASTNode) {
        val isCorner = parent.firstChildNode == child || parent.lastChildNode == child
        indent = when {
            isCorner -> Indent.getNoneIndent()
            else -> Indent.getNormalIndent()
        }
    }

    private fun notFirst(parent: ASTNode) {
        val notFirst = parent.firstChildNode == child
        indent = when {
            notFirst -> Indent.getNoneIndent()
            else -> Indent.getNormalIndent()
        }
    }

    private fun ASTNode.indentInRange(child: ASTNode, head: Int, tail: Int): Indent {
        val children = this.getChildren(null);
        val index = children.indexOf(child)
        val last = children.size - tail
        return when {
            index <= head -> Indent.getNoneIndent()
            index >= last -> Indent.getNoneIndent()
            else -> Indent.getNormalIndent()
        }
    }
}