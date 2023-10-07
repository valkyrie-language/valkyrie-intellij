package valkyrie.ast

import com.intellij.lang.PsiBuilder

interface ParserMonad {
    fun parse(builder: PsiBuilder): Boolean
}