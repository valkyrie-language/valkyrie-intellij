package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareMethod
import javax.swing.Icon

abstract class MixinMethod(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareMethod {
    override fun getNameIdentifier(): MixinIdentifier {
        return this.identifierFree as MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Function
    }
}

