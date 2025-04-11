package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.TermAtomic
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceChoice
import valkyrie.cst.BRACE_L
import valkyrie.cst.BRACKET_L
import valkyrie.cst.COMMA
import valkyrie.cst.DOT
import valkyrie.cst.NUMBER
import valkyrie.cst.PARENTHESIS_L
import valkyrie.cst.PARENTHESIS_R
import valkyrie.cst.STRING
import valkyrie.cst.SYMBOL

class ValkyrieTermAtomicNode(node: ASTNode) : ValkyrieTermExpressionNode(node) {

    override fun getName(): String {
        return "AtomicTerm"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermAtomic(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            val success = builder.advanceChoice(
//                ValkyrieObjectNode,
//                ValkyrieArrayNode,
                ValkyrieNamePathNode
            )
            if (success) {
                marker.done(TermAtomic)
                return true
            }
            else {
                marker.rollbackTo()
                return false
            }

            // 处理后缀方法调用
//            while (builder.tokenType === DOT) {
//                builder.advanceLexer() // 消费点号
//                if (builder.tokenType !== SYMBOL) {
//                    marker.error("Expected method name")
//                    return true
//                }
//                builder.advanceLexer() // 消费方法名
//            }


        }
    }
}