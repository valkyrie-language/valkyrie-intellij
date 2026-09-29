package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * 后缀表达式节点
 * 用于处理函数调用、成员访问等后缀操作
 */
class ValkyriePostfixExpressionNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取基础表达式
     */
    fun getBaseExpression(): PsiElement? {
        return this.firstChild
    }
    
    /**
     * 获取后缀操作
     */
    fun getPostfixOperation(): PsiElement? {
        return this.firstChild?.nextSibling
    }
    
    override fun toString(): String = "ValkyriePostfixExpression"
}