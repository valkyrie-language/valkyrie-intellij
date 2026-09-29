package von.surface.file

import von.surface.lexer.VonLexer
import von.surface.parser.VonParser
import von.surface.psi.VonTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class VonParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = VonLexer()

    override fun createParser(project: Project): PsiParser = VonParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement = VonTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = VonFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements =
        ParserDefinition.SpaceRequirements.MAY

    companion object {
        val COMMENTS = TokenSet.create(VonTypes.COMMENT, VonTypes.BLOCK_COMMENT)
        val STRING_LITERALS = TokenSet.create(VonTypes.STRING_INLINE, VonTypes.STRING_PREFIX, VonTypes.STRING_MULTI)
        val FILE = IFileElementType(VonLanguage.INSTANCE)
    }
}
