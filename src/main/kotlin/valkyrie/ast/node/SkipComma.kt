package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad
import valkyrie.cst.COMMA
import valkyrie.cst.SEMICOLON

class SkipComma {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType == COMMA || builder.tokenType == SEMICOLON) {
                builder.advanceLexer()
                return true
            }
            return false
        }
    }
}