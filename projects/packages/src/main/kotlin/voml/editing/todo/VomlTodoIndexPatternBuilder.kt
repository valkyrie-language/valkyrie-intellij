package voml.editing.todo

import voml.surface.file.VomlFile
import voml.surface.lexer.VomlLexer
import voml.surface.psi.Voml_COMMENTS
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class VomlTodoIndexPatternBuilder : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? =
        if (file is VomlFile) VomlLexer() else null

    override fun getCommentTokenSet(file: PsiFile): TokenSet? =
        if (file is VomlFile) Voml_COMMENTS else null

    override fun getCommentStartDelta(tokenType: IElementType?): Int =
        if (tokenType in Voml_COMMENTS) 2 else 0

    override fun getCommentEndDelta(tokenType: IElementType?): Int = 0
}
