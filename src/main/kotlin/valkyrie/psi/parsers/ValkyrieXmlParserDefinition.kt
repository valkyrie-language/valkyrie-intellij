package valkyrie.psi.parsers

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
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.nodes.ValkyrieFileNode
import valkyrie.language.dialect_xml.ValkyrieXmlLexer

/**
 * Valkyrie XML 解析器定义
 */
class ValkyrieXmlParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(ValkyrieLanguage.INSTANCE)
        val STRING_LITERALS = TokenSet.create(ValkyrieTypes.STRING_DQ, ValkyrieTypes.STRING_MQ)
    }

    override fun createLexer(project: Project?): Lexer {
        val config = ValkyrieLanguageConfig()
        return ValkyrieXmlLexer()
    }

    override fun createParser(project: Project?): PsiParser {
        val config = ValkyrieLanguageConfig()
        return ValkyrieParser(config)
    }

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.create(ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_RANGE)

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement {
        return ValkyrieFactory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ValkyrieFileNode(viewProvider)
    }
}
