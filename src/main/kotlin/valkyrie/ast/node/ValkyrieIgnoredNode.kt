package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.advanceIgnore

class ValkyrieIgnoredNode {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            
            return true
        }
    }
}