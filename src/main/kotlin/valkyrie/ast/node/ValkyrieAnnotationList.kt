package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.advanceRepeat

class ValkyrieAnnotationList {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return builder.advanceRepeat(ValkyrieAnnotationNode, 0, 1024)
        }
    }
}


