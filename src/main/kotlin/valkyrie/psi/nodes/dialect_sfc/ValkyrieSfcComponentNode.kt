package valkyrie.psi.nodes.dialect_sfc

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Valkyrie SFC Component 节点
 */
class ValkyrieSfcComponentNode(node: ASTNode) : ValkyrieElementNode(node) {

    override fun toString(): String = "ValkyrieSfcComponentNode"
}
