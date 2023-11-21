package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.TermUnary
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.OP_ADD
import valkyrie.cst.OP_SUB

class ValkyrieTermUnaryNode(node: ASTNode) : ValkyrieTermExpressionNode(node) {
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val base = findChildByClass(ValkyrieTermExpressionNode::class.java)


    override fun getName(): String {
        return "UnaryTerm<${operator?.text}>"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermUnary(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 处理前缀一元运算符
            when (builder.tokenType) {
                OP_ADD, OP_SUB -> {
                    builder.advanceLexer() // 消费运算符
                    if (!ValkyrieTermExpressionNode.parse(builder)) {
                        marker.error("Expected expression after unary operator")
                        return true
                    }
                    marker.done(TermUnary)
                    return true
                }
            }

            marker.drop()
            return false
        }
    }
}