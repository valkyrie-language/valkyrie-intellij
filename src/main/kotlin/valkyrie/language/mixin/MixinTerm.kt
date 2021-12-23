package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieTermNode

open class MixinTerm(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): ValkyrieTermNode {
        return this as ValkyrieTermNode
    }

    val namepath: List<ValkyrieIdentifier>
        get() {
            val namepath = originalElement.atom.namepath ?: return listOf();
            return namepath.identifierList
        }
}



