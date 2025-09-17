package valkyrie.ide.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.xml.XmlTokenType
import valkyrie.language.file.ValkyrieSfcFileType
import valkyrie.language.file.ValkyrieXmlFileType
import valkyrie.psi.lexers.ValkyrieSfcLexer
import valkyrie.psi.lexers.ValkyrieStandardLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.psi.lexers.ValkyrieXmlLexer

class ValkyrieSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    companion object {
        fun valkyrieTokenColor(tokenType: IElementType): ValkyrieColor? {
            return when (tokenType) {
                ValkyrieTokenTypes.NAMESPACE,
                ValkyrieTokenTypes.USING,
                ValkyrieTokenTypes.LET,
                ValkyrieTokenTypes.IF,
                ValkyrieTokenTypes.ELSE,
                ValkyrieTokenTypes.WHILE,
                ValkyrieTokenTypes.UNTIL,
                ValkyrieTokenTypes.LOOP,
                ValkyrieTokenTypes.CLASS,
                ValkyrieTokenTypes.NEURAL,
                ValkyrieTokenTypes.WIDGET,
                ValkyrieTokenTypes.UNION,
                ValkyrieTokenTypes.UNITY,
                ValkyrieTokenTypes.TRAIT,
                ValkyrieTokenTypes.IMPLY,
                ValkyrieTokenTypes.STRUCTURE,
                ValkyrieTokenTypes.SINGLETON,
                ValkyrieTokenTypes.FLAGS,
                ValkyrieTokenTypes.BREAK,
                ValkyrieTokenTypes.CONTINUE,
                ValkyrieTokenTypes.YIELD,
                ValkyrieTokenTypes.RAISE,
                ValkyrieTokenTypes.RESUME,
                ValkyrieTokenTypes.SCOPE,
                ValkyrieTokenTypes.RETURN,
                ValkyrieTokenTypes.TESTS,
                ValkyrieTokenTypes.MICRO,
                ValkyrieTokenTypes.MEZZO,
                ValkyrieTokenTypes.MACRO,
                ValkyrieTokenTypes.MATCH,
                ValkyrieTokenTypes.CASE,
                ValkyrieTokenTypes.WHEN,
                ValkyrieTokenTypes.FALLTHROUGH,
                ValkyrieTokenTypes.TRY,
                ValkyrieTokenTypes.CATCH,
                ValkyrieTokenTypes.IN,
                ValkyrieTokenTypes.AS
                    -> ValkyrieColor.KEYWORD

                // 操作符
                ValkyrieTokenTypes.IS -> ValkyrieColor.OPERATION

                ValkyrieTokenTypes.PARENTHESIS_L, ValkyrieTokenTypes.PARENTHESIS_R -> ValkyrieColor.PARENTHESES
                ValkyrieTokenTypes.BRACKET_L, ValkyrieTokenTypes.BRACKET_R -> ValkyrieColor.BRACKETS
                ValkyrieTokenTypes.BRACE_L, ValkyrieTokenTypes.BRACE_R -> ValkyrieColor.BRACES
                ValkyrieTokenTypes.TEMPLATE_L, ValkyrieTokenTypes.TEMPLATE_R -> ValkyrieColor.TEMPLATE_BLOCK
                ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN -> ValkyrieColor.OPERATION
                ValkyrieTokenTypes.DOT_DOT, ValkyrieTokenTypes.ELLIPSIS, ValkyrieTokenTypes.DOT_DOT_EQUAL, ValkyrieTokenTypes.DOT_DOT_LESS -> ValkyrieColor.OPERATION
                ValkyrieTokenTypes.AT -> ValkyrieColor.OPERATION
                ValkyrieTokenTypes.LABEL_MARK -> ValkyrieColor.OPERATION

                ValkyrieTokenTypes.COMMA -> ValkyrieColor.COMMA
                // 数字和字面量
                ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.MACRO_NUMBER -> ValkyrieColor.NUMBER
                ValkyrieTokenTypes.STRING_DQ, ValkyrieTokenTypes.STRING_MQ -> ValkyrieColor.STRING
                ValkyrieTokenTypes.BOOLEAN -> ValkyrieColor.KEYWORD

                ValkyrieTokenTypes.SYMBOL_XID -> ValkyrieColor.IDENTIFIER
                // 注释
                ValkyrieTokenTypes.COMMENT_LINE -> ValkyrieColor.LINE_COMMENT
                ValkyrieTokenTypes.COMMENT_RANGE -> ValkyrieColor.BLOCK_COMMENT
                ValkyrieTokenTypes.COMMENT_DOCUMENT -> ValkyrieColor.DOC_COMMENT
                XmlTokenType.XML_COMMENT_CHARACTERS -> ValkyrieColor.BLOCK_COMMENT
                // XML 染色
                XmlTokenType.XML_TAG_NAME -> ValkyrieColor.XML_TAG_NAME
                XmlTokenType.XML_NAME -> ValkyrieColor.XML_ATTRIBUTE_NAME
                XmlTokenType.XML_EQ -> ValkyrieColor.OPERATION
                // 错误
                TokenType.BAD_CHARACTER -> ValkyrieColor.BAD_CHARACTER
                else -> null
            }
        }
    }

    override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
        return object : SyntaxHighlighterBase() {
            override fun getHighlightingLexer(): Lexer {
                return ValkyrieSfcLexer()
                return when (virtualFile?.fileType) {
                    ValkyrieXmlFileType.INSTANCE -> {
                        ValkyrieXmlLexer()
                    }

                    ValkyrieSfcFileType.INSTANCE -> {
                        ValkyrieSfcLexer()
                    }

                    else -> {
                        ValkyrieStandardLexer()
                    }
                }
            }

            override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
                return pack(getTokenColor(tokenType)?.textAttributesKey)
            }

            private fun getTokenColor(tokenType: IElementType): ValkyrieColor? {
                return valkyrieTokenColor(tokenType)
            }
        }
    }
}
