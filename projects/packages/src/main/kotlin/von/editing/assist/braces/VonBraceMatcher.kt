package von.editing.assist.braces

import von.surface.file.VonFileType
import von.surface.file.VonLanguage
import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType

class VonBraceMatcher : PairedBraceMatcherAdapter(VonBaseBraceMatcher(), VonLanguage.INSTANCE) {
    override fun isLBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean =
        isBrace(iterator, fileText, fileType, true)

    override fun isRBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean =
        isBrace(iterator, fileText, fileType, false)

    private fun isBrace(
        iterator: HighlighterIterator,
        fileText: CharSequence,
        fileType: FileType,
        left: Boolean
    ): Boolean {
        if (fileType != VonFileType.INSTANCE) return false
        val pair = findPair(left, iterator, fileText, fileType)
        return pair != null
    }
}
