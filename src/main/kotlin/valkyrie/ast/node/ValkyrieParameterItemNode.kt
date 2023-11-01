package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad

class ValkyrieParameterItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ParameterItem"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return ValkyrieIdentifierNode.parse(builder)
        }
    }
}