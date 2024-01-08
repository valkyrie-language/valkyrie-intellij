package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Parameter 实现
 */
class ValkyrieParameterNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getParameterName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)?.text
    }

    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
    
    /**
     * 获取参数的修饰符节点
     */
    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }
    
    /**
     * 检查参数是否有特定修饰符
     */
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }
    
    /**
     * 检查参数是否有mut修饰符
     */
    fun isMutable(): Boolean {
        return hasModifier("mut")
    }
}