package valkyrie.language.mixin

import valkyrie.ide.reference.ValkyrieReference
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

open class MixinIdentifier(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getName(): String {
        return this.text.trim('`')
    }

    override fun getReferences(): Array<ValkyrieReference> {
        return when (this.parent) {
            is ValkyrieClassStatementNode -> {
                emptyArray()
            }
            else -> {
                arrayOf(ValkyrieReference(this))
            }
        }
    }
}
