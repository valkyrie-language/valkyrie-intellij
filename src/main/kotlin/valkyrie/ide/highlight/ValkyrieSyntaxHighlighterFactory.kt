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
import valkyrie.psi.parsers.ValkyrieParserDefinition
import valkyrie.psi.parsers.ValkyrieTypes

class ValkyrieSyntaxHighlighterFactory : SyntaxHighlighterFactory() {
    companion object {
        fun valkyrieTokenColor(tokenType: IElementType): ValkyrieColor? {
            return when (tokenType) {
                ValkyrieTypes.NAMESPACE,
                ValkyrieTypes.USING,
                ValkyrieTypes.LET,
                ValkyrieTypes.IF,
                ValkyrieTypes.ELSE,
                ValkyrieTypes.WHILE,
                ValkyrieTypes.UNTIL,
                ValkyrieTypes.LOOP,
                ValkyrieTypes.CLASS,
                ValkyrieTypes.NEURAL,
                ValkyrieTypes.WIDGET,
                ValkyrieTypes.UNION,
                ValkyrieTypes.UNITY,
                ValkyrieTypes.TRAIT,
                ValkyrieTypes.IMPLY,
                ValkyrieTypes.CONSTRUCTOR,
                ValkyrieTypes.STRUCTURE,
                ValkyrieTypes.SINGLETON,
                ValkyrieTypes.FLAGS,
                ValkyrieTypes.BREAK,
                ValkyrieTypes.CONTINUE,
                ValkyrieTypes.YIELD,
                ValkyrieTypes.RAISE,
                ValkyrieTypes.RESUME,
                ValkyrieTypes.SCOPE,
                ValkyrieTypes.RETURN,
                ValkyrieTypes.ASSERT,
                ValkyrieTypes.DEBUG,
                ValkyrieTypes.TESTS,
                ValkyrieTypes.MICRO,
                ValkyrieTypes.MEZZO,
                ValkyrieTypes.MACRO,
                ValkyrieTypes.MATCH,
                ValkyrieTypes.CASE,
                ValkyrieTypes.WHEN,
                ValkyrieTypes.FALLTHROUGH,
                ValkyrieTypes.TRY,
                ValkyrieTypes.CATCH,
                ValkyrieTypes.IN,
                ValkyrieTypes.AS
                    -> ValkyrieColor.KEYWORD

                // 操作符
                ValkyrieTypes.IS -> ValkyrieColor.OPERATION

                ValkyrieTypes.PARENTHESIS_L, ValkyrieTypes.PARENTHESIS_R -> ValkyrieColor.PARENTHESES
                ValkyrieTypes.BRACKET_L, ValkyrieTypes.BRACKET_R -> ValkyrieColor.BRACKETS
                ValkyrieTypes.BRACE_L, ValkyrieTypes.BRACE_R -> ValkyrieColor.BRACES
                ValkyrieTypes.TEMPLATE_L, ValkyrieTypes.TEMPLATE_R -> ValkyrieColor.TEMPLATE_BLOCK
                ValkyrieTypes.COLON, ValkyrieTypes.ASSIGN -> ValkyrieColor.OPERATION
                ValkyrieTypes.DOT, ValkyrieTypes.DOT_CIRCLE, ValkyrieTypes.DOT_DOT, ValkyrieTypes.ELLIPSIS, ValkyrieTypes.DOT_DOT_EQUAL, ValkyrieTypes.DOT_DOT_LESS -> ValkyrieColor.OPERATION
                ValkyrieTypes.AT -> ValkyrieColor.OPERATION
                ValkyrieTypes.LABEL_MARK -> ValkyrieColor.OPERATION

                ValkyrieTypes.COMMA -> ValkyrieColor.COMMA
                // 数字和字面量
                ValkyrieTypes.INTEGER, ValkyrieTypes.DECIMAL, ValkyrieTypes.MACRO_NUMBER -> ValkyrieColor.NUMBER
                ValkyrieTypes.STRING_DQ, ValkyrieTypes.STRING_MQ, ValkyrieTypes.STRING_L,
                ValkyrieTypes.STRING_START, ValkyrieTypes.STRING_TEXT, ValkyrieTypes.STRING_END,
                ValkyrieTypes.MACRO_STRING -> ValkyrieColor.STRING

                ValkyrieTypes.BOOLEAN -> ValkyrieColor.KEYWORD
                ValkyrieTypes.NIL, ValkyrieTypes.NULL -> ValkyrieColor.NULL

                // 预定义符号
                ValkyrieTypes.KW_SOME, ValkyrieTypes.KW_NONE -> ValkyrieColor.SYM_VARIANT
                ValkyrieTypes.KW_VALUE -> ValkyrieColor.SYM_LOCAL
                ValkyrieTypes.KW_V -> ValkyrieColor.SYM_GENERIC

                ValkyrieTypes.SYMBOL_XID, ValkyrieTypes.SYMBOL_RAW -> ValkyrieColor.IDENTIFIER
                // 注释
                ValkyrieTypes.COMMENT_LINE -> ValkyrieColor.LINE_COMMENT
                ValkyrieTypes.COMMENT_RANGE -> ValkyrieColor.BLOCK_COMMENT
                ValkyrieTypes.COMMENT_DOCUMENT -> ValkyrieColor.DOC_COMMENT
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
                return ValkyrieParserDefinition().createLexer(project)
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
