package valkyrie.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import javax.swing.Icon

object ValkyrieFileType : LanguageFileType(ValkyrieLanguage) {
    override fun getName(): String = ValkyrieLanguage.id

    override fun getDescription(): String = ValkyrieBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "vk;valkyrie;"

    override fun getIcon(): Icon = ValkyrieIconProvider.Instance.File

}