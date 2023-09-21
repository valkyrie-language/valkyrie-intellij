package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration

import valkyrie.psi.node.ValkyrieParameterItem
import javax.swing.Icon

abstract class MixinValueParameter(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieParameterItem {

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierFree as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}


