package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.TypeUnary
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.OP_ADD
import valkyrie.cst.OP_NOT
import valkyrie.cst.OP_SUB
import valkyrie.cst.QUESTION

class ValkyrieTypeUnaryNode(node: ASTNode) : ValkyrieTypeExpressionNode(node) {
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val expression = findChildByClass(ValkyrieTypeExpressionNode::class.java)

    override fun getName(): String {
        return "UnaryType<${operator?.text}>"
    }

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
                QUESTION, OP_NOT, OP_ADD, OP_SUB -> {
                    builder.advanceLexer() // 消费一元运算符
                    if (parseTypeExpression(builder)) {
                        marker.done(TypeUnary)
                        return true
                    }
                    marker.error("Expected type after unary operator")
                    return false
                }

                else -> {
                    marker.drop()
                    return parseTypeExpression(builder)
                }
            }
        }

        private fun parseTypeExpression(builder: PsiBuilder): Boolean {
            return ValkyrieTypeAtomicNode.parse(builder)
        }
    }
}