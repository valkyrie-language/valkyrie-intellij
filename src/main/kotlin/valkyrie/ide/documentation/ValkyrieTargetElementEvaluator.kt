package valkyrie.ide.documentation

import com.intellij.codeInsight.TargetElementEvaluator
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * TargetElementEvaluator 用于控制哪个 PSI 元素被选中用于文档显示、导航等功能。
 * 这个类解决了 ValkyrieClassDeclaration 中类名无法触发 getQuickNavigateInfo 的问题。
 */
class ValkyrieTargetElementEvaluator : TargetElementEvaluator {

    /**
     * 当用户点击或悬停在某个元素上时，决定应该使用哪个元素作为目标。
     * 对于类声明，我们希望类名标识符也能触发类声明的文档显示。
     */
    override fun getElementByReference(ref: PsiReference, flags: Int): PsiElement? {
        val element = ref.element

        // 如果是类名标识符，返回其父类声明
        if (element is ValkyrieIdentifierNode) {
            val parent = element.parent
            if (parent is ValkyrieClassDeclaration) {
                // 确保这个标识符确实是类名
                if (parent.nameIdentifier == element) {
                    return parent
                }
            }
        }

        return null
    }

    /**
     * 判断给定的元素是否应该被包含在目标元素的搜索中。
     * 对于 Valkyrie 语言，我们接受类声明和标识符。
     */
    override fun includeSelfInGotoImplementation(element: PsiElement): Boolean {
        return element is ValkyrieClassDeclaration || element is ValkyrieIdentifierNode
    }
}