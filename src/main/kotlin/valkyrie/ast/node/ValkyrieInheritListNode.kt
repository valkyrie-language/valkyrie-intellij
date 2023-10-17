package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.InheritList
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parsePaired
import valkyrie.cst.COMMA
import valkyrie.cst.PARENTHESIS_L
import valkyrie.cst.PARENTHESIS_R

class ValkyrieInheritListNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    val items = findChildrenByClass(ValkyrieInheritItemNode::class.java);

    override fun getName(): String? {
        return "InheritList"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitInheritList(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return builder.parsePaired(
                InheritList,
                PARENTHESIS_L,
                PARENTHESIS_R,
                COMMA,
                ValkyrieInheritItemNode.Companion,
            )
        }
    }
}