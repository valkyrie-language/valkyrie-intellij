package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.NumberUnit
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.SYMBOL
import valkyrie.cst.SYMBOL_RAW
import valkyrie.psi.ValkyrieElement

class ValkyrieNumberUnitNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitNumberUnit(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "NumberUnit<${node.text}>"
    }

    companion object : ParserMonad {
        // 解析注解列表
        override fun parse(builder: PsiBuilder): Boolean {
            val next = builder.rawLookup(0);
            when (next) {
                SYMBOL, SYMBOL_RAW -> {
                    val unit = builder.mark()
                    builder.advanceLexer()
                    unit.done(NumberUnit)
                    return true
                }

                else -> {
                    return false
                }
            }
        }
    }
}