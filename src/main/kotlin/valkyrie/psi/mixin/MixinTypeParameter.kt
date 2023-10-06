package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration

import javax.swing.Icon

abstract class MixinTypeParameter(node: ASTNode) : ValkyrieDeclaration(node) {

    override fun getNameIdentifier(): MixinIdentifier? {
        return null
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}