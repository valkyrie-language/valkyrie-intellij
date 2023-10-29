package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.Identifier
import valkyrie.ast.ParserMonad
import valkyrie.ast.TypeAtomic
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.SYMBOL

class ValkyrieTypeAtomicNode(node: ASTNode) : ValkyrieTypeExpressionNode(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)

    override fun getName(): String {
        return "AtomicType<${identifier?.text}>"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTypeAtomic(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when (builder.tokenType) {
                SYMBOL -> {
                    builder.advanceLexer() // 消费标识符
                    marker.done(Identifier)
                    return true
                }
                else -> {
                    marker.drop()
                    return false
                }
            }
        }
    }
}