package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.ast.ValkyrieASTBase

open class MixinIdentifier(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}
