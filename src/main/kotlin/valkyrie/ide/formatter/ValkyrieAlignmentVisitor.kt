package valkyrie.ide.formatter

import com.intellij.formatting.Alignment
import com.intellij.lang.ASTNode
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieDeclareEnumerateNode
import valkyrie.psi.node.ValkyrieDeclareSemantic

class ValkyrieAlignmentVisitor(val child: ASTNode) : ValkyrieVisitor() {
    var alignment: Alignment? = null

    override fun visitDeclareEnums(o: ValkyrieDeclareEnumerateNode) {
        super.visitDeclareEnums(o)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        alignment = Alignment.createAlignment(true, Alignment.Anchor.LEFT)
    }
}

