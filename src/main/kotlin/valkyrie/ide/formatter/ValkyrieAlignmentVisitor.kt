package valkyrie.ide.formatter

import com.intellij.formatting.Alignment
import com.intellij.lang.ASTNode
import valkyrie.ast.ValkyrieVisitor

import valkyrie.ast.node.ValkyrieDeclareSemanticNode
import valkyrie.ast.node.ValkyrieEnumsNode

class ValkyrieAlignmentVisitor(val child: ASTNode) : ValkyrieVisitor() {
    var alignment: Alignment? = null

    override fun visitDeclareEnums(o: ValkyrieEnumsNode) {
        super.visitDeclareEnums(o)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemanticNode) {
        alignment = Alignment.createAlignment(true, Alignment.Anchor.LEFT)
    }
}

