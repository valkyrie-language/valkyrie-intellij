package com.github.valkyrie.language.psi


import com.github.valkyrie.VkLanguage
import com.github.valkyrie.ide.view.VkFile
import com.github.valkyrie.language.parser.FluentParser

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


class FluentParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = ValkyrieLexerAdapter()

    override fun createParser(project: Project): PsiParser = FluentParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement = FluentTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = VkFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    companion object {
        val COMMENTS = TokenSet.create(FluentTypes.COMMENT_LINE)
        val STRING_LITERALS = TokenSet.create(FluentTypes.STRING_LITERAL)
        val FILE = IFileElementType(VkLanguage.INSTANCE)
    }
}
