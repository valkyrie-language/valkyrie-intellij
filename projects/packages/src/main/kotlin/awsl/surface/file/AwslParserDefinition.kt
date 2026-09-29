package awsl.surface.file

import awsl.surface.file.AwslFile
import awsl.surface.parser.AwslParser
import awsl.surface.psi.AwslTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

/**
 * AWSL 语言的 ParserDefinition
 *
 * 使用手动实现的 AwslLexer 和 AwslParser
 */
class AwslParserDefinition : ParserDefinition {

    companion object {
        /**
         * 注释 Token 集合
         */
        val COMMENTS = TokenSet.create(
            AwslTypes.COMMENT_LINE,
            AwslTypes.COMMENT_BLOCK,
            AwslTypes.COMMENT_HTML,
            AwslTypes.COMMENT_DOCUMENT
        )

        /**
         * 字符串字面量 Token 集合
         */
        val STRING_LITERALS = TokenSet.create(AwslTypes.STRING)

        /**
         * 空白字符 Token 集合
         */
        val WHITE_SPACE = TokenSet.create(com.intellij.psi.TokenType.WHITE_SPACE)

        /**
         * 文件节点类型
         */
        val FILE = IFileElementType(AwslLanguage.INSTANCE)
    }

    /**
     * 创建词法分析器
     */
    override fun createLexer(project: Project): Lexer = AwslLexerAdapter()

    /**
     * 创建语法解析器
     */
    override fun createParser(project: Project): PsiParser = AwslParser()

    /**
     * 获取文件节点类型
     */
    override fun getFileNodeType(): IFileElementType = FILE

    /**
     * 获取注释 Token 集合
     */
    override fun getCommentTokens(): TokenSet = COMMENTS

    /**
     * 获取空白字符 Token 集合
     */
    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACE

    /**
     * 获取字符串字面量 Token 集合
     */
    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    /**
     * 创建 PSI 元素
     */
    override fun createElement(node: ASTNode): PsiElement = AwslTypes.Factory.createElement(node)

    /**
     * 创建 PSI 文件
     */
    override fun createFile(viewProvider: FileViewProvider): PsiFile = AwslFile(viewProvider)

    /**
     * 判断两个 Token 之间是否需要空格
     */
    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}
