package valkyrie.ide.lint

import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class ValkyrieTodoIndexPatternBuilder : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? {
        return null
    }

    override fun getCommentTokenSet(file: PsiFile): TokenSet? {
        return null
    }

    override fun getCommentStartDelta(tokenType: IElementType?): Int {
        return 0
    }

    override fun getCommentEndDelta(tokenType: IElementType?): Int {
        return 0
    }
}
