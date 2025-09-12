package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.ValkyrieTypeReferenceNode

/**
 * 类型引用提供者
 * 专门处理类型引用表达式中的类型名引用
 */
class ValkyrieTypeReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<out PsiReference?> {
        if (element is ValkyrieTypeReferenceNode) {
            // 直接使用ValkyrieTypeReferenceNode的getReference方法
            val reference = element.getReference()
            if (reference != null) {
                return arrayOf(reference)
            }
        }
        return emptyArray()
    }
}