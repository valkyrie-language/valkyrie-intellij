package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.Keyword
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.ValkyrieCST

class ParseKeywords(vararg val tokens: ValkyrieCST) : ParserMonad {
    override fun parse(builder: PsiBuilder): Boolean {
        val marker = builder.mark()
        val set = TokenSet.create(*tokens)
        if (builder.tokenType in set) {
            builder.advanceLexer()
            marker.done(Keyword)
            return true
        } else {
            marker.drop()
            return false
        }
    }
}