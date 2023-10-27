package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieElement

open class ValkyrieTermExpressionNode(node: ASTNode) : ValkyrieElement(node) {

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermExpression(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return ValkyrieTermBinaryNode.parse(builder)
        }
    }
}
