package valkyrie.ast

import com.intellij.lang.PsiBuilder

interface ParseMonad {
    fun parse(builder: PsiBuilder): Boolean
}