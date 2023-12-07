package valkyrie.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

/**
 * Valkyrie PSI 元素基础实现
 */
open class ValkyrieElementNode(node: ASTNode) : ASTWrapperPsiElement(node), ValkyrieElement {
//    override fun accept(visitor: PsiElementVisitor) {
//        super.accept(visitor)
//    }
}