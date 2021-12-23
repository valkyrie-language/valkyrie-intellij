package valkyrie.language.mixin

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.lang.ASTNode
import valkyrie.language.ast.ValkyrieASTBase

open class MixinObjectKey(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }
}
