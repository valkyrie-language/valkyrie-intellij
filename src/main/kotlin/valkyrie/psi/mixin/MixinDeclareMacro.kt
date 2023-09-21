package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareMacro

import javax.swing.Icon

abstract class MixinDeclareMacro(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareMacro {
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Method
    }
}