package vos.intellij.ide.matcher

import vos.intellij.language.VosLanguage
import vos.intellij.language.file.VosFileType
import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType

class JssBraceMatcher : PairedBraceMatcherAdapter(BaseBraceMatcher(), VosLanguage) {
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
        if (fileType != VosFileType) return false
        val pair = findPair(left, iterator, fileText, fileType)
        return pair != null
    }
}
