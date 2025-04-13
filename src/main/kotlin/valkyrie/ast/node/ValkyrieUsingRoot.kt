package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import valkyrie.ast.DeclareNamespace
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_NAMESPACE

class ValkyrieUsingRoot {

    companion object : ParserMonad {
        /**
        ```vk
        namespace {a.b::{}}
        ```
         */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            if (builder.tokenType == KW_NAMESPACE) {
                marker.done(DeclareNamespace)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}