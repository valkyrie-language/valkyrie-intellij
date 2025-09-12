package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * Parameter List 实现
 */
class ValkyrieTermParameterList(node: ASTNode) : ValkyrieElementNode(node) {

    fun getParameters(): Array<out ValkyrieTermParameterItem?> {
        return findChildrenByClass(ValkyrieTermParameterItem::class.java)
    }
}