package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Array
import valkyrie.ast.ParserMonad
import valkyrie.ast.parsePaired
import valkyrie.cst.COMMA
import valkyrie.cst.PARENTHESIS_L
import valkyrie.cst.PARENTHESIS_R

class ValkyrieClassInheritListNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return builder.parsePaired(
                Array,
                PARENTHESIS_L,
                PARENTHESIS_R,
                COMMA,
                ValkyrieClassInheritItemNode.Companion,
            )
        }
    }
}