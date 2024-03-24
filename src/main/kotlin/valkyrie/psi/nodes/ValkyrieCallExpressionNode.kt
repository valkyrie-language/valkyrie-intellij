package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.TokenType.WHITE_SPACE
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.reference.ValkyrieFunctionCallReference

/**
 * 函数调用表达式节点
 */
class ValkyrieCallExpressionNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取被调用的表达式（函数名）
     */
    fun getCallee(): PsiElement? {
        return this.firstChild
    }
    
    /**
     * 获取参数列表
     */
    fun getArgumentList(): List<PsiElement> {
        val args = mutableListOf<PsiElement>()
        var child = this.firstChild?.nextSibling
        
        // 跳过左括号
        while (child != null && child.node.elementType != ValkyrieTokenTypes.PARENTHESES_L) {
            child = child.nextSibling
        }
        
        if (child != null) {
            child = child.nextSibling // 跳过左括号
            
            while (child != null && child.node.elementType != ValkyrieTokenTypes.PARENTHESES_R) {
                if (child.node.elementType != ValkyrieTokenTypes.COMMA && 
                    child.node.elementType != WHITE_SPACE) {
                    args.add(child)
                }
                child = child.nextSibling
            }
        }
        
        return args
    }
    
    /**
     * 获取函数调用的引用
     * 支持跳转到函数定义
     */
    override fun getReference(): PsiReference? {
        val callee = getCallee()
        if (callee is ValkyrieIdentifierNode) {
            // 使用相对于callee元素自身的范围，而不是相对于父元素的偏移量
            val textRange = TextRange(0, callee.textLength)
            return ValkyrieFunctionCallReference(callee, textRange)
        }
        return null
    }
    
    override fun toString(): String = "ValkyrieCallExpression"
}