package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad

class ValkyrieTypeExpressionNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {

        }
    }
}