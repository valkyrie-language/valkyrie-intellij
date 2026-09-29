package vos.intellij.language.psi

import vos.intellij.language.file.VosFileNode
import vos.intellij.language.VosLanguage
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
import vos.intellij.language.parser.VosParser


object JssParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = JssLexerAdapter()

    override fun createParser(project: Project): PsiParser = VosParser()

    override fun getFileNodeType(): IFileElementType = IFileElementType(VosLanguage)

    override fun getCommentTokens(): TokenSet = TokenSet.create(
        VosTypes.COMMENT,
        VosTypes.COMMENT_BLOCK,
        VosTypes.COMMENT_DOCUMENT
    )

    override fun getStringLiteralElements(): TokenSet = TokenSet.create(
        VosTypes.STRING,
    )

    override fun getWhitespaceTokens(): TokenSet {
        return super.getWhitespaceTokens()
    }

    override fun createElement(node: ASTNode): PsiElement = VosTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = VosFileNode(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

}
