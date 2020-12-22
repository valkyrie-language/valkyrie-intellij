package com.github.valkyrie.ide.view

import com.github.valkyrie.VkBundle
import com.github.valkyrie.VkLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class VkFileType private constructor() : LanguageFileType(VkLanguage.INSTANCE) {
    override fun getName(): String = VkLanguage.LanguageID

    override fun getDescription(): String = VkBundle.message("filetype.description")

    override fun getDefaultExtension(): String = VkLanguage.Extensions

    override fun getIcon(): Icon = VkIconProvider.FluentFile

    companion object {
        @JvmStatic
        val INSTANCE = VkFileType()
    }
}