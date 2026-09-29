package vos.intellij.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import vos.intellij.language.VosLanguage
import javax.swing.Icon

object VosFileType : LanguageFileType(VosLanguage) {
    override fun getName(): String = VosLanguage.id

    override fun getDescription(): String = MessageBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "vos"

    override fun getIcon(): Icon = VosIcons.FILE
}