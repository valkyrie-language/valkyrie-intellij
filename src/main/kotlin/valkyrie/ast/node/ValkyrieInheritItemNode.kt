package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.InheritItem
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor

class ValkyrieInheritItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)

    override fun getName(): String? {
        return "InheritItem"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitInheritItem(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /** `named: BaseClass */
        override fun parse(builder: PsiBuilder): Boolean {
            return parseNamedTypeExpression(builder, InheritItem)
        }
    }
}

