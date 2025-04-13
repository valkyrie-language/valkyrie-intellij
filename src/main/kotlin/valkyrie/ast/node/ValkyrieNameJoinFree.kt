package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.DOT
import valkyrie.cst.NAME_SPLIT

class ValkyrieNameJoinFree {
    companion object : ParserMonad {
        /**
         * `::model.name`
         */
        override fun parse(builder: PsiBuilder): Boolean {
            return parseNameJoin(builder, TokenSet.create(NAME_SPLIT, DOT))
        }
    }
}