package valkyrie.psi

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
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.nodes.ValkyrieFileNode

/**
 * Valkyrie 语言解析器定义
 */
class ValkyrieParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(ValkyrieLanguage.INSTANCE)

        val WHITESPACE_TOKENS = TokenSet.create(ValkyrieTokenTypes.WHITESPACE, ValkyrieTokenTypes.NEWLINE)
        val COMMENT_TOKENS =
            TokenSet.create(ValkyrieTokenTypes.COMMENT_LINE, ValkyrieTokenTypes.COMMENT_RANGE, ValkyrieTokenTypes.COMMENT_DOCUMENT)
        val STRING_LITERALS = TokenSet.create(ValkyrieTokenTypes.STRING_DQ)
    }

    override fun createLexer(project: Project?): Lexer = ValkyrieLexer()

    override fun createParser(project: Project?): PsiParser = ValkyrieParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENT_TOKENS

    override fun getWhitespaceTokens(): TokenSet = WHITESPACE_TOKENS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement {
        return ValkyrieElementFactory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ValkyrieFileNode(viewProvider)
    }
}