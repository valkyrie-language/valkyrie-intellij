package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElementNode

/**
 * Domain body 节点实现
 */
class ValkyrieDomainBodyNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getDomainMembers(): List<ValkyrieElementNode> {
        return children.filterIsInstance<ValkyrieElementNode>()
    }
    
    fun getFields(): List<ValkyrieFieldDeclaration> {
        return findChildrenByClass(ValkyrieFieldDeclaration::class.java).toList()
    }
    
    fun getMethods(): List<ValkyrieMethodDeclaration> {
        return findChildrenByClass(ValkyrieMethodDeclaration::class.java).toList()
    }
    
    fun getDomains(): List<ValkyrieDomainDeclaration> {
        return findChildrenByClass(ValkyrieDomainDeclaration::class.java).toList()
    }
}