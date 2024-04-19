package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * XML Slot 表达式节点
 * 表示 XML 中的嵌入表达式，如 {variable} 或 {function()}
 */
class ValkyrieXmlSlotExpressionNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取左大括号
     */
    fun getLeftBrace(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.XML_SLOT_L)
    }
    
    /**
     * 获取右大括号
     */
    fun getRightBrace(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.XML_SLOT_R)
    }
    
    /**
     * 获取内部表达式
     */
    fun getExpression(): ValkyrieElementNode? {
        // 查找大括号之间的表达式节点
        val leftBrace = getLeftBrace()
        val rightBrace = getRightBrace()
        
        if (leftBrace != null && rightBrace != null) {
            // 查找左右大括号之间的表达式
            var current = leftBrace.nextSibling
            while (current != null && current != rightBrace) {
                if (current is ValkyrieElementNode) {
                    return current
                }
                current = current.nextSibling
            }
        }
        
        // 如果没有找到，尝试查找任何子表达式节点
        return PsiTreeUtil.getChildOfType(this, ValkyrieElementNode::class.java)
    }
    
    /**
     * 获取表达式的文本内容（不包括大括号）
     */
    fun getExpressionText(): String? {
        val expression = getExpression()
        return expression?.text
    }
    
    /**
     * 检查slot表达式是否完整（有左右大括号）
     */
    fun isComplete(): Boolean {
        return getLeftBrace() != null && getRightBrace() != null
    }
}