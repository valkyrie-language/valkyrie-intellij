package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement


abstract class MixinIdentifier(node: ASTNode) : ValkyrieElement(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}


