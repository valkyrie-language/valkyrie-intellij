package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieTypeHint
import javax.swing.Icon

abstract class MixinTypeHint(node: ASTNode) : ValkyrieElement(node), ValkyrieTypeHint {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Type
    }
}

