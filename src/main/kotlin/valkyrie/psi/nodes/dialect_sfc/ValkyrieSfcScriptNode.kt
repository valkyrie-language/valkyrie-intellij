package valkyrie.psi.nodes.dialect_sfc

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Valkyrie SFC Script 节点
 */
class ValkyrieSfcScriptNode(node: ASTNode) : ValkyrieElementNode(node) {

    override fun toString(): String = "ValkyrieSfcScriptNode"
}
