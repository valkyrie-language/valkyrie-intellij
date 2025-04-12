package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.cst.NAME_SPLIT

class ValkyrieNameJoin {
    companion object : ParserMonad {
        /**
         * `::name`
         */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            builder.advanceIgnore()
            if (builder.tokenType == NAME_SPLIT) {
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
    }
}