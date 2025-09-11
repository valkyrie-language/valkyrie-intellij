package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 泛型函数调用表达式节点
 * 支持 call⟨T⟩ 和 call::<T> 形式
 */
class ValkyrieGenericCallExpressionNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取被调用的表达式（函数名）
     */
    fun getCallee(): PsiElement? {
        return firstChild
    }
    
    /**
     * 获取泛型参数列表
     */
    fun getGenericArguments(): List<PsiElement> {
        val args = mutableListOf<PsiElement>()
        var child = firstChild?.nextSibling
        
        // 查找泛型参数开始标记（⟨ 或 ::< ）
        while (child != null) {
            if (child.node.elementType == ValkyrieTokenTypes.LANGLE || 
                (child.node.elementType == ValkyrieTokenTypes.DOUBLE_COLON && 
                 child.nextSibling?.node?.elementType == ValkyrieTokenTypes.LESS)) {
                
                // 跳过开始标记
                if (child.node.elementType == ValkyrieTokenTypes.DOUBLE_COLON) {
                    child = child.nextSibling // 跳过 ::
                }
                child = child.nextSibling // 跳过 ⟨ 或 <
                
                // 收集泛型参数
                while (child != null && 
                       child.node.elementType != ValkyrieTokenTypes.RANGLE && 
                       child.node.elementType != ValkyrieTokenTypes.GREATER) {
                    if (child.node.elementType != ValkyrieTokenTypes.COMMA && 
                        child.node.elementType != ValkyrieTokenTypes.WHITESPACE &&
                        child.node.elementType != ValkyrieTokenTypes.NEWLINE) {
                        args.add(child)
                    }
                    child = child.nextSibling
                }
                break
            }
            child = child.nextSibling
        }
        
        return args
    }
    
    /**
     * 获取函数参数列表
     */
    fun getArgumentList(): List<PsiElement> {
        val args = mutableListOf<PsiElement>()
        var child = firstChild
        
        // 跳过到左括号
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
     * 判断是否使用双冒号语法 (call::<T>)
     */
    fun isDoubleColonSyntax(): Boolean {
        var child = firstChild?.nextSibling
        while (child != null) {
            if (child.node.elementType == ValkyrieTokenTypes.DOUBLE_COLON) {
                return true
            }
            if (child.node.elementType == ValkyrieTokenTypes.LANGLE) {
                return false
            }
            child = child.nextSibling
        }
        return false
    }
    
    override fun toString(): String = "ValkyrieGenericCallExpression"
}