package valkyrie.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.parser.YggdrasilParser

class ParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = ValkyrieLexer()
    override fun createParser(project: Project): PsiParser = YggdrasilParser()
    override fun getFileNodeType(): IFileElementType = IFileElementType(ValkyrieLanguage)
    override fun getCommentTokens(): TokenSet =
        TokenSet.create(ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_BLOCK)

    override fun getStringLiteralElements(): TokenSet = TokenSet.create()
    override fun getWhitespaceTokens(): TokenSet = TokenSet.create(TokenType.WHITE_SPACE)
    override fun createElement(node: ASTNode): PsiElement = ValkyrieTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = ValkyrieFileNode(viewProvider)
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

}