package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Identifier
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.SYMBOL
import valkyrie.cst.SYMBOL_RAW
import valkyrie.psi.ValkyrieElement

open class ValkyrieIdentifierNode(node: ASTNode) : ValkyrieElement(node) {

    override fun toString(): String {
        return "Identifier"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when (builder.tokenType) {
                SYMBOL, SYMBOL_RAW -> {
                    builder.advanceLexer()
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


