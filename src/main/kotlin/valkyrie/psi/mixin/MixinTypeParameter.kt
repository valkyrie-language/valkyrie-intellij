package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieGenericParameter

import javax.swing.Icon

abstract class MixinTypeParameter(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieGenericParameter {

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}