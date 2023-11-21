package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.cst.NAME_SPLIT

class ValkyrieNameJoin {
    companion object : ParserMonad {
        /**
         * `::name`
         */
        override fun parse(builder: PsiBuilder): Boolean {
            return parseNameJoin(builder, TokenSet.create(NAME_SPLIT))
        }
    }
}

fun parseNameJoin(builder: PsiBuilder, tokens: TokenSet): Boolean {
    val marker = builder.mark()
    builder.advanceIgnore()
    if (builder.tokenType in tokens) {
        builder.advanceLexer()
        builder.advanceIgnore()
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