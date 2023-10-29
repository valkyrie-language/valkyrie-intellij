package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ParserMonad
import valkyrie.ast.TypeUnary
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.QUESTION

class ValkyrieTypeUnaryNode(node: ASTNode) : ValkyrieTypeExpressionNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTypeUnary(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when (builder.tokenType) {
                QUESTION -> {
                    builder.advanceLexer() // 消费一元运算符
                    if (ValkyrieTypeAtomicNode.parse(builder)) {
                        marker.done(TypeUnary)
                        return true
                    }
                    marker.drop()
                    return false
                }
                else -> {
                    marker.drop()
                    return ValkyrieTypeAtomicNode.parse(builder)
                }
            }
        }
    }
}