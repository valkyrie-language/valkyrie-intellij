package valkyrie.ast.parser

import com.intellij.lang.PsiBuilder

interface ParserMonad {
    fun parse(builder: PsiBuilder): Boolean
}