package valkyrie.psi.nodes.dialect_sfc

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Valkyrie SFC Style 节点
 */
class ValkyrieSfcStyleNode(node: ASTNode) : ValkyrieElementNode(node) {

    override fun toString(): String = "ValkyrieSfcStyleNode"
}
