package von.ide.braces

import von.language.psi.VonTypes
import von.language.psi.Von_COMMENTS
import von.language.psi.tokenSetOf
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class VonBaseBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean =
        next in InsertPairBraceBefore

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val PAIRS = arrayOf(
            BracePair(VonTypes.BRACE_L, VonTypes.BRACE_R, true),
            BracePair(VonTypes.BRACKET_L, VonTypes.BRACKET_R, true),
            BracePair(VonTypes.PARENTHESIS_L, VonTypes.PARENTHESIS_R, true),
            // @annotation()
        )

        private val InsertPairBraceBefore = TokenSet.orSet(
            Von_COMMENTS,
            tokenSetOf(
                TokenType.WHITE_SPACE,
                VonTypes.COMMA,
                VonTypes.PARENTHESIS_R,
                VonTypes.BRACKET_R,
                VonTypes.BRACE_R,
                VonTypes.BRACE_L
            )
        )
    }
}
