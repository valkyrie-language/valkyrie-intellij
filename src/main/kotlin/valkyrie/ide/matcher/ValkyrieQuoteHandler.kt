package valkyrie.ide.matcher

import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator


class ValkyrieQuoteHandler : MultiCharQuoteHandler {
    override fun isOpeningQuote(iterator: HighlighterIterator?, offset: Int): Boolean {
        return ValkyrieBraceMatch.Left.contains(iterator?.tokenType)
    }


    override fun isClosingQuote(iterator: HighlighterIterator?, offset: Int): Boolean {
        return ValkyrieBraceMatch.Right.contains(iterator?.tokenType)
    }


    override fun hasNonClosedLiteral(editor: Editor?, iterator: HighlighterIterator?, offset: Int): Boolean {
        return false
    }

    override fun isInsideLiteral(iterator: HighlighterIterator?): Boolean {
        return false
    }

    override fun getClosingQuote(iterator: HighlighterIterator, offset: Int): CharSequence? {
        return null;
    }
}
