package valkyrie.language.mixin

import valkyrie.ide.reference.ValkyrieReference
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieTermNode
import com.intellij.lang.ASTNode

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



