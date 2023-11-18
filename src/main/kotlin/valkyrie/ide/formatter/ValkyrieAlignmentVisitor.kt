package valkyrie.ide.formatter

import com.intellij.formatting.Alignment
import com.intellij.lang.ASTNode
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieDeclareEnumerateNode
import valkyrie.ast.node.ValkyrieDeclareSemanticNode

class ValkyrieAlignmentVisitor(val child: ASTNode) : ValkyrieVisitor() {
    var alignment: Alignment? = null

    override fun visitDeclareEnums(o: ValkyrieDeclareEnumerateNode) {
        super.visitDeclareEnums(o)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemanticNode) {
        alignment = Alignment.createAlignment(true, Alignment.Anchor.LEFT)
    }
}

