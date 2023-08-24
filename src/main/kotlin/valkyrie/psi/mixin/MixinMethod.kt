package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.icons.ExpUiIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareDomain
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinMethod(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareMethod {
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierTail as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Function
    }
}

abstract class MixinDomain(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareDomain {
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ExpUiIcons.Nodes.Controller
    }
}