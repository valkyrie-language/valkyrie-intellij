package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.ValkyrieIdentifierNode
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
        while (child != null && child.node.elementType != ValkyrieTokenTypes.LPAREN) {
            child = child.nextSibling
        }
        
        if (child != null) {
            child = child.nextSibling // 跳过左括号
            
            while (child != null && child.node.elementType != ValkyrieTokenTypes.RPAREN) {
                if (child.node.elementType != ValkyrieTokenTypes.COMMA && 
                    child.node.elementType != ValkyrieTokenTypes.WHITESPACE &&
                    child.node.elementType != ValkyrieTokenTypes.NEWLINE) {
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
            val textRange = TextRange(callee.startOffsetInParent, callee.startOffsetInParent + callee.textLength)
            return ValkyrieFunctionCallReference(callee, textRange)
        }
        return null
    }
    
    override fun toString(): String = "ValkyrieCallExpression"
}