package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieTypeHint
import javax.swing.Icon

abstract class MixinTypeHint(node: ASTNode) : ValkyrieElement(node), ValkyrieTypeHint {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Type
    }

    override fun highlight_traits(visitor: NodeHighlighter) {

    }
}