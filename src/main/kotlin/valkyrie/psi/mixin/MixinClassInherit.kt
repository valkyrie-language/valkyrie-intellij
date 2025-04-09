package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ast.node.ValkyrieIdentifierNode
import valkyrie.psi.ValkyrieDeclaration

import valkyrie.psi.node.ValkyrieInheritItem
import javax.swing.Icon

abstract class MixinClassInherit(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieInheritItem {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierSafe as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}