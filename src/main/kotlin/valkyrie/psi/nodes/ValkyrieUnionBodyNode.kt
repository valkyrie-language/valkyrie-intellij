package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * Union Body 节点实现
 */
class ValkyrieUnionBodyNode(node: ASTNode) : ValkyrieElementNode(node) {
    /**
     * 获取所有的 union variant 声明
     */
    fun getVariants(): List<ValkyrieVariantDeclaration> {
        return findChildrenByClass(ValkyrieVariantDeclaration::class.java).toList()
    }
    
    /**
     * 获取所有的方法声明
     */
    fun getMethods(): List<ValkyrieMethodDeclaration> {
        return findChildrenByClass(ValkyrieMethodDeclaration::class.java).toList()
    }
}