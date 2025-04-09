package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ParserMonad
import valkyrie.ast.TypeBinary
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.OP_ARROW
import valkyrie.cst.OP_OR

class ValkyrieTypeBinaryNode(node: ASTNode) : ValkyrieTypeExpressionNode(node) {
    val left = findChildByClass(ValkyrieTypeExpressionNode::class.java)
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val right = findChildByClass(ValkyrieTypeExpressionNode::class.java)

    override fun getName(): String {
        return "BinaryType<${operator?.text}>"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTypeBinary(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            if (!ValkyrieTypeAtomicNode.parse(builder)) {
                marker.drop()
                return false
            }

            while (!builder.eof()) {
                when (builder.tokenType) {
                    OP_ARROW, OP_OR -> {
                        builder.advanceLexer() // 消费运算符
                        if (!ValkyrieTypeAtomicNode.parse(builder)) {
                            marker.error("Expected type after operator")
                            return true
                        }
                        marker.done(TypeBinary)
                        return true
                    }
                    else -> {
                        marker.drop()
                        return true
                    }
                }
            }
            marker.drop()
            return true
        }
    }
}