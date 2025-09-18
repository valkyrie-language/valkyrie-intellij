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
import com.intellij.psi.xml.XmlTokenType
import valkyrie.language.dialect_sfc.ValkyrieSfcLanguage
import valkyrie.language.dialect_sfc.ValkyrieSfcLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.language.dialect_sfc.ValkyrieSfcFileNode
import valkyrie.psi.parsers.ValkyrieSfcParser

/**
 * Valkyrie Component 语言解析器定义
 */
class ValkyrieSfcParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType("Valkyrie Component File", ValkyrieSfcLanguage)
        val STRING_LITERALS = TokenSet.create(ValkyrieTokenTypes.STRING_DQ, ValkyrieTokenTypes.STRING_MQ)
    }

    override fun createLexer(project: Project?): Lexer = ValkyrieSfcLexer()

    override fun createParser(project: Project?): PsiParser = ValkyrieSfcParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.create(
        ValkyrieTokenTypes.COMMENT_LINE,
        ValkyrieTokenTypes.COMMENT_RANGE,
        ValkyrieTokenTypes.COMMENT_DOCUMENT,
        XmlTokenType.XML_COMMENT_START,
        XmlTokenType.XML_COMMENT_CHARACTERS,
        XmlTokenType.XML_COMMENT_END,
    )

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement {
        return ValkyrieElementFactory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ValkyrieSfcFileNode(viewProvider)
    }
}