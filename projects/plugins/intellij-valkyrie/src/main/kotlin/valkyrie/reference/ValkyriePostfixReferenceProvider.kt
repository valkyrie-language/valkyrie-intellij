package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext
import valkyrie.psi.nodes.ValkyriePostfixExpressionNode
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * 后缀表达式引用提供者
 * 专门处理点表达式中的方法调用引用，如 obj.method()
 */
class ValkyriePostfixReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<out PsiReference?> {
        if (element is ValkyriePostfixExpressionNode) {
            // 获取后缀操作（点号右边的部分）
            val postfixOperation = element.getPostfixOperation()
            
            // 查找标识符节点（方法名）
            val methodIdentifier = findMethodIdentifier(postfixOperation)
            if (methodIdentifier != null) {
                val textRange = TextRange(0, methodIdentifier.textLength)
                return arrayOf(ValkyriePostfixReference(methodIdentifier, textRange))
            }
        }
        return emptyArray()
    }
    
    /**
     * 在后缀操作中查找方法标识符
     */
    private fun findMethodIdentifier(postfixOperation: PsiElement?): ValkyrieIdentifierNode? {
        if (postfixOperation == null) return null
        
        // 如果后缀操作本身就是标识符
        if (postfixOperation is ValkyrieIdentifierNode) {
            return postfixOperation
        }
        
        // 在子元素中查找标识符（处理函数调用的情况）
        var child = postfixOperation.firstChild
        while (child != null) {
            if (child is ValkyrieIdentifierNode) {
                return child
            }
            child = child.nextSibling
        }
        
        return null
    }
}