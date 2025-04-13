package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.parser.ParserMonad

class SkipSeparator(vararg val tokens: IElementType) : ParserMonad {
    override fun parse(builder: PsiBuilder): Boolean {
        val set = TokenSet.create(*tokens)
        if (builder.tokenType in set) {
            builder.advanceLexer()
            return true
        }
        return false
    }
}
