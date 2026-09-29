package von.ide.todo

import von.language.VonFile
import von.language.lexer.VonLexer
import von.language.psi.Von_COMMENTS
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class VonTodoIndexPatternBuilder : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? =
        if (file is VonFile) VonLexer() else null

    override fun getCommentTokenSet(file: PsiFile): TokenSet? =
        if (file is VonFile) Von_COMMENTS else null

    override fun getCommentStartDelta(tokenType: IElementType?): Int =
        if (tokenType in Von_COMMENTS) 2 else 0

    override fun getCommentEndDelta(tokenType: IElementType?): Int = 0
}
