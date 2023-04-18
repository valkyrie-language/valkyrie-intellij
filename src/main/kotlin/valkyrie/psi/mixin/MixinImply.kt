package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieDeclareImply
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinImply(node: ASTNode) : ValkyrieDeclareElement(node), ValkyrieDeclareImply {
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.IdeaModule
    }
}

