package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.NumberLiteral
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.INTEGER
import valkyrie.psi.ValkyrieElement

class ValkyrieNumberNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitNumberLiteral(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "Number"
    }

    companion object : ParserMonad {
        // 解析注解列表
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            if (builder.tokenType == INTEGER) {
                builder.advanceLexer();
            } else {
                marker.drop()
                return false
            }
            ValkyrieNumberUnitNode.parse(builder)
            marker.done(NumberLiteral)
            return true
        }
    }
}

