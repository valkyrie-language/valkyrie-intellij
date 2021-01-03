package com.github.valkyrie.ide.view

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ValkyrieLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class VkFileType private constructor() : LanguageFileType(ValkyrieLanguage.INSTANCE) {
    override fun getName(): String = ValkyrieLanguage.LanguageID

    override fun getDescription(): String = ValkyrieBundle.message("filetype.description")

    override fun getDefaultExtension(): String = ValkyrieLanguage.Extensions

    override fun getIcon(): Icon = VkIconProvider.FluentFile

    companion object {
        @JvmStatic
        val INSTANCE = VkFileType()
    }
}