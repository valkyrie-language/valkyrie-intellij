package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareSemantic
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinSemantic(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareSemantic {
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierList.last() as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Constant
    }

}