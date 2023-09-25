package valkyrie.psi.mixin


import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareDomain

import javax.swing.Icon

abstract class MixinDomain(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareDomain {
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Controller
    }
}