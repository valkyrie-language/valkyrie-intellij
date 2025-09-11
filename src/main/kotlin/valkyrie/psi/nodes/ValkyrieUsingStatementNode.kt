package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * Using 语句实现
 */
class ValkyrieUsingStatementNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getQualifiedName(): ValkyrieQualifiedNameNode? {
        return findChildByClass(ValkyrieQualifiedNameNode::class.java)
    }

    fun getImportedName(): String? {
        return getQualifiedName()?.text
    }
}