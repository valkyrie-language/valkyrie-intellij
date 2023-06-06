package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareUnite
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinUnite(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareUnite {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.AbstractClass
    }
}



