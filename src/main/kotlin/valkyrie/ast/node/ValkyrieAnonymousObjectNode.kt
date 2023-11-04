package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder


class ValkyrieAnonymousObjectNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder = builder, anonymous = true)
        }
    }
}