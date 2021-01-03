package com.github.valkyrie.language.psi


import com.github.valkyrie.ValkyrieLanguage
import com.github.valkyrie.ide.view.ValkyrieFile
import com.github.valkyrie.language.parser.ValkyrieParser

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


class ValkyrieParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = ValkyrieLexerAdapter()

    override fun createParser(project: Project): PsiParser = ValkyrieParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement = ValkyrieTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = ValkyrieFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    companion object {
        val COMMENTS = TokenSet.create(ValkyrieTypes.COMMENT_LINE)
        val STRING_LITERALS = TokenSet.create(ValkyrieTypes.STRING_LITERAL)
        val FILE = IFileElementType(ValkyrieLanguage.INSTANCE)
    }
}
