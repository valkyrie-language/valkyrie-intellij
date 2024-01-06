package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Modifier List 实现
 */
class ValkyrieModifierListNode(node: ASTNode) : ValkyrieElementNode(node) {

    /**
     * 获取所有修饰符节点
     */
    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }
    
    /**
     * 获取所有修饰符名称（向后兼容）
     */
    fun getModifiers(): List<String> {
        return getModifierNodes().mapNotNull { it.getModifierName() }
    }
    
    /**
     * 检查是否包含特定修饰符
     */
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }
    
    /**
     * 检查是否为静态
     */
    fun isStatic(): Boolean {
        return hasModifier("static")
    }
    
    /**
     * 检查是否为可变
     */
    fun isMutable(): Boolean {
        return hasModifier("mut")
    }
    
    /**
     * 获取可见性修饰符
     */
    fun getVisibilityModifier(): String? {
        return getModifierNodes()
            .firstOrNull { it.isVisibilityModifier() }
            ?.getModifierName()
    }
}

