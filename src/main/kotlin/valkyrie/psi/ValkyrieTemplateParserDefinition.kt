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
import valkyrie.language.dialect_template.ValkyrieTemplateLanguage
import valkyrie.language.dialect_template.ValkyrieTemplateLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.language.dialect_template.ValkyrieTemplateFileNode
import valkyrie.psi.parsers.ValkyrieParser

/**
 * Valkyrie 模板语言解析器定义
 */
class ValkyrieTemplateParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(ValkyrieTemplateLanguage)
        val STRING_LITERALS = TokenSet.create(ValkyrieTokenTypes.STRING_DQ, ValkyrieTokenTypes.STRING_MQ)
    }

    override fun createLexer(project: Project?): Lexer = ValkyrieTemplateLexer()

    override fun createParser(project: Project?): PsiParser = ValkyrieParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.create(ValkyrieTokenTypes.COMMENT_LINE, ValkyrieTokenTypes.COMMENT_RANGE, ValkyrieTokenTypes.COMMENT_DOCUMENT)

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement {
        return ValkyrieElementFactory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ValkyrieTemplateFileNode(viewProvider)
    }
}