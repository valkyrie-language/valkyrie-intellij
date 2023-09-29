package valkyrie.ast.node

import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParseMonad
import valkyrie.ast.advanceIgnore

class ValkyrieIgnoredNode {
    companion object: ParseMonad {
      override fun parse(builder: PsiBuilder): Boolean {
            builder.advanceIgnore()
            return true
        }
    }
}