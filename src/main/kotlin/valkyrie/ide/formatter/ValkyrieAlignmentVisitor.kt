package valkyrie.ide.formatter

import com.intellij.formatting.Alignment
import com.intellij.lang.ASTNode
import valkyrie.psi.node.ValkyrieDeclareEnums
import valkyrie.psi.node.ValkyrieDeclareSemantic
import valkyrie.psi.node.ValkyrieVisitor

class ValkyrieAlignmentVisitor(val child: ASTNode) : ValkyrieVisitor() {
    var alignment: Alignment? = null

    override fun visitDeclareEnums(o: ValkyrieDeclareEnums) {
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        alignment = Alignment.createAlignment(true, Alignment.Anchor.LEFT)
    }
}

