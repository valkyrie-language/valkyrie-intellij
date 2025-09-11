package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * Parameter List 实现
 */
class ValkyrieParameterListNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getParameters(): Array<out ValkyrieParameterNode?> {
        return findChildrenByClass(ValkyrieParameterNode::class.java)
    }
}