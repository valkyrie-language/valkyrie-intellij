package valkyrie.ide.matcher

import com.intellij.codeInsight.highlighting.AbstractCodeBlockSupportHandler
import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieFileType
import valkyrie.psi.ValkyrieTypes

class BraceMatchAdapter : PairedBraceMatcherAdapter(ValkyrieBraceMatch(), ValkyrieLanguage) {
    override fun isLBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean {
        return isBrace(iterator, fileText, fileType, true)
    }

    override fun isRBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean {
        return isBrace(iterator, fileText, fileType, false)
    }

    private fun isBrace(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType, left: Boolean): Boolean {
        if (fileType != ValkyrieFileType) return false
        val pair = findPair(left, iterator, fileText, fileType)
        return pair != null
    }
}

class CodeBlockSupport : AbstractCodeBlockSupportHandler() {
    override fun getTopLevelElementTypes(): TokenSet {
        return TokenSet.create(ValkyrieTypes.DECLARE_CLASS, ValkyrieTypes.DECLARE_TRAIT)
    }

    override fun getKeywordElementTypes(): TokenSet {
        return TokenSet.create(ValkyrieTypes.KW_IF, ValkyrieTypes.KW_TYPE)
    }

    override fun getBlockElementTypes(): TokenSet {
        return TokenSet.create(ValkyrieTypes.BLOCK_BODY)
    }

    override fun getDirectChildrenElementTypes(parentElementType: IElementType?): TokenSet {
        println("getDirectChildrenElementTypes: $parentElementType")
        return TokenSet.create()
    }

}
