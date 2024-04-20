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

import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.language.dialect_sfc.ValkyrieSfcLanguage
import valkyrie.psi.nodes.SfcFileNode
import valkyrie.psi.lexers.ValkyrieSfcLexer
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.psi.parsers.ValkyrieFactory
import valkyrie.psi.parsers.ValkyrieSfcParser
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcTemplateNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcScriptNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcStyleNode
import valkyrie.psi.nodes.dialect_sfc.ValkyrieSfcComponentNode

/**
 * Valkyrie SFC 语言解析器定义
 */
class ValkyrieSfcParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(ValkyrieSfcLanguage.INSTANCE)
        val STRING_LITERALS = TokenSet.create(ValkyrieTypes.STRING_DQ, ValkyrieTypes.STRING_MQ)
    }

    override fun createLexer(project: Project?): Lexer {
        return ValkyrieSfcLexer()
    }

    override fun createParser(project: Project?): PsiParser {
        val config = ValkyrieLanguageConfig()
        return ValkyrieSfcParser(config)
    }

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.create(ValkyrieTypes.COMMENT_LINE, ValkyrieTypes.COMMENT_RANGE)

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement {
        val elementType = node.elementType
        
        // 直接处理所有 SFC 相关元素类型
        when (elementType) {
            ValkyrieTypes.SFC_TEMPLATE -> {
                return ValkyrieSfcTemplateNode(node)
            }
            ValkyrieTypes.SFC_SCRIPT -> {
                return ValkyrieSfcScriptNode(node)
            }
            ValkyrieTypes.SFC_STYLE -> {
                return ValkyrieSfcStyleNode(node)
            }
            ValkyrieTypes.SFC_COMPONENT -> {
                return ValkyrieSfcComponentNode(node)
            }
            ValkyrieTypes.STRING_TEXT -> {
                return ValkyrieElementNode(node)
            }
            else -> {
                // 处理其他元素类型
                if (elementType.toString() == "ValkyrieToken.STRING.TEXT") {
                    return ValkyrieElementNode(node)
                }
                
                // 对于其他元素类型，使用 ValkyrieFactory
                return ValkyrieFactory.createElement(node)
            }
        }
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SfcFileNode(viewProvider)
    }
}
