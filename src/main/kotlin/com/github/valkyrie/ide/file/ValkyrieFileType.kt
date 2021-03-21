package com.github.valkyrie.ide.file

import com.github.valkyrie.ValkyrieBundle
import com.github.valkyrie.ValkyrieLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class ValkyrieFileType private constructor() : LanguageFileType(ValkyrieLanguage.INSTANCE) {
    override fun getName(): String = ValkyrieLanguage.LanguageID

    override fun getDescription(): String = ValkyrieBundle.message("filetype.description")

    override fun getDefaultExtension(): String = ValkyrieLanguage.Extensions

    override fun getIcon(): Icon = ValkyrieIconProvider.IconSVG

    companion object {
        @JvmStatic
        val INSTANCE = ValkyrieFileType()
    }
}