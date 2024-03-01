package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * Using 语句实现
 */
class ValkyrieUsingStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getQualifiedName(): ValkyrieNamepathNode? {
        return findChildByClass(ValkyrieNamepathNode::class.java)
    }

    fun getImportedName(): String? {
        return getQualifiedName()?.text
    }
}