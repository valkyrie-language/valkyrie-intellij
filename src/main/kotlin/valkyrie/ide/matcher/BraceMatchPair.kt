package valkyrie.ide.matcher

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.language.lexer.ValkyrieProgramLexer

//import valkyrie.language.psi.ValkyrieTypes.*

class BraceMatchPair : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = arrayOf(
        BracePair(ValkyrieProgramLexer.BraceL, ValkyrieProgramLexer.BraceR, true),
        BracePair(ValkyrieProgramLexer.BracketL, ValkyrieProgramLexer.BracketR, true),
        BracePair(ValkyrieProgramLexer.ParenthesisL, ValkyrieProgramLexer.ParenthesisR, true),
//        BracePair(OP_LT, OP_GT, true),
//        BracePair(STRING_START, STRING_END, true),
    )

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean {
        val insertPairBraceBefore = TokenSet.orSet(
            ValkyrieProgramLexer.Comments,
            TokenSet.create(
                TokenType.WHITE_SPACE,
//                COMMA,
                ValkyrieProgramLexer.ParenthesisR,
                ValkyrieProgramLexer.BracketR,
                ValkyrieProgramLexer.BraceR
            )
        )
        return next in insertPairBraceBefore
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
}

