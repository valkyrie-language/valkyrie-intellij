package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.Modifier
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.SYMBOL
import valkyrie.cst.SYMBOL_RAW

class ValkyrieModifierNode(node: ASTNode) : ValkyrieIdentifierNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitModifier(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "Modifier"
    }

    companion object {
        // 解析修饰符
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when (builder.tokenType) {
                SYMBOL, SYMBOL_RAW -> {
                    builder.advanceLexer()
                    marker.done(Modifier)
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

