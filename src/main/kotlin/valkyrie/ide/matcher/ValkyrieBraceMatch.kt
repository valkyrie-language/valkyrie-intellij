package valkyrie.ide.matcher

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ValkyrieTypes.*


class ValkyrieBraceMatch : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> {
        return arrayOf(
//            BracePair(BRACE_L, BRACE_R, false),
//            BracePair(BRACKET_L, BRACKET_R, false),
//            BracePair(PARENTHESIS_L, PARENTHESIS_R, false),
//            BracePair(GENERIC_L, GENERIC_R, false),
        )
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }

    companion object {
        val Left = TokenSet.create(
            PARENTHESIS_L, BRACKET_L, BRACE_L, GENERIC_L
        )
        val Right = TokenSet.create(
            PARENTHESIS_R, BRACKET_R, BRACE_R, GENERIC_R
        )
    }
}

