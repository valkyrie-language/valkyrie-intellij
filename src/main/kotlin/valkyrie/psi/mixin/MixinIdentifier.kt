package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieIdentifier

abstract class MixinIdentifier(node: ASTNode) : ValkyrieElement(node), ValkyrieIdentifier {
    override fun getName(): String {
        return this.text.trim('`')
    }
}


