package com.github.valkyrie.ide.matcher

import com.github.valkyrie.VkLanguage
import com.github.valkyrie.ide.view.VkFileType

import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType

class FluentBraceMatcher : PairedBraceMatcherAdapter(BaseBraceMatcher(), VkLanguage.INSTANCE) {
    override fun isLBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean {
        return isBrace(iterator, fileText, fileType, true)
    }

    override fun isRBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean {
        return isBrace(iterator, fileText, fileType, false)
    }

    private fun isBrace(
        iterator: HighlighterIterator,
        fileText: CharSequence,
        fileType: FileType,
        left: Boolean
    ): Boolean {
        if (fileType != VkFileType.INSTANCE) return false
        val pair = findPair(left, iterator, fileText, fileType)
        return pair != null
    }
}
