package valkyrie.language.antlr

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class CustomParser : ParserDefinition {
    override fun createLexer(project: Project?): Lexer {
        return CustomLexer(project)
    }

    override fun createParser(p0: Project?): PsiParser {
        TODO("Not yet implemented")
    }

    override fun getFileNodeType(): IFileElementType {
        TODO("Not yet implemented")
    }

    override fun getCommentTokens(): TokenSet {
        TODO("Not yet implemented")
    }

    override fun getStringLiteralElements(): TokenSet {
        TODO("Not yet implemented")
    }

    override fun createElement(p0: ASTNode?): PsiElement {
        TODO("Not yet implemented")
    }

    override fun createFile(p0: FileViewProvider): PsiFile {
        TODO("Not yet implemented")
    }

    override fun getWhitespaceTokens(): TokenSet {
        return TokenSet.WHITE_SPACE
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return super.spaceExistenceTypeBetweenTokens(left, right)
    }
}

private class CustomLexer(private val project: Project?) : Lexer() {
    override fun start(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun getState(): Int {
        TODO("Not yet implemented")
    }

    override fun getTokenType(): IElementType? {
        TODO("Not yet implemented")
    }

    override fun getTokenStart(): Int {
        TODO("Not yet implemented")
    }

    override fun getTokenEnd(): Int {
        TODO("Not yet implemented")
    }

    override fun advance() {
        TODO("Not yet implemented")
    }

    override fun getCurrentPosition(): LexerPosition {
        TODO("Not yet implemented")
    }

    override fun restore(p0: LexerPosition) {
        TODO("Not yet implemented")
    }

    override fun getBufferSequence(): CharSequence {
        TODO("Not yet implemented")
    }

    override fun getBufferEnd(): Int {
        TODO("Not yet implemented")
    }


}

