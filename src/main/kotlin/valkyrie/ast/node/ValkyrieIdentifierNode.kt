package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Identifier
import valkyrie.ast.NamePath
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.ast.advanceRepeat
import valkyrie.cst.NAME_JOIN
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


class ValkyrieNamePathNode(node: ASTNode) : ValkyrieElement(node) {

    override fun toString(): String {
        return "NamePath"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            if (ValkyrieIdentifierNode.parse(builder)) {
                builder.advanceRepeat(ValkyrieNameJoin, 0, 100)
//                ValkyrieNameJoin.parse(builder)
                marker.done(NamePath)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}

class ValkyrieNameJoin {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            builder.advanceIgnore()
            if (builder.tokenType == NAME_JOIN) {
                builder.advanceLexer()
            } else {
                marker.rollbackTo();
                return false
            }
            if (ValkyrieIdentifierNode.parse(builder)) {
                marker.drop()
                return true
            } else {
                marker.rollbackTo();
                return false
            }
        }
    }
}
