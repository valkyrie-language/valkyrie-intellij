package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.ParameterList
import valkyrie.ast.ParserMonad
import valkyrie.ast.parsePaired
import valkyrie.cst.COMMA
import valkyrie.cst.PARENTHESIS_L
import valkyrie.cst.PARENTHESIS_R

class ValkyrieParameterListNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    val items = findChildrenByClass(ValkyrieParameterItemNode::class.java)

    override fun toString(): String {
        return "ParameterList"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return builder.parsePaired(
                ParameterList,
                PARENTHESIS_L,
                PARENTHESIS_R,
                TokenSet.create(COMMA),
                ValkyrieParameterItemNode
            )
        }
    }
}