package valkyrie.ide.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import valkyrie.psi.parsers.ValkyrieParserDefinition

class ValkyrieSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieParserDefinition().createLexer(null)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): ValkyrieColor? {
        return ValkyrieSyntaxHighlighterFactory.valkyrieTokenColor(tokenType)
    }
}
