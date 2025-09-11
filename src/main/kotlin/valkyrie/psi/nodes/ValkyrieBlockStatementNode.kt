package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * Block 语句节点实现
 * 用于处理代码块 { ... }
 */
class ValkyrieBlockStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取块内的所有语句
     */
    fun getStatements(): List<ValkyrieElementNode> {
        return findChildrenByClass(ValkyrieElementNode::class.java).toList()
    }
    
    /**
     * 检查是否为空块
     */
    fun isEmpty(): Boolean {
        return getStatements().isEmpty()
    }
    
    override fun toString(): String = "ValkyrieBlockStatement"
}