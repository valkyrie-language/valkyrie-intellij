package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext
import valkyrie.psi.nodes.ValkyrieCallExpressionNode
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * 函数调用引用提供者
 * 专门处理函数调用表达式中的函数名引用
 */
class ValkyrieFunctionCallReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<out PsiReference?> {
        if (element is ValkyrieCallExpressionNode) {
            val callee = element.getCallee()
            if (callee is ValkyrieIdentifierNode) {
                val textRange = TextRange(0, callee.textLength)
                return arrayOf(ValkyrieFunctionCallReference(callee, textRange))
            }
        }
        return emptyArray()
    }
}