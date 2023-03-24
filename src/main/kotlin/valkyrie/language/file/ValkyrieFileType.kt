package valkyrie.language.file

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.YggdrasilBundle
import yggdrasil.language.file.YggdrasilIconProvider
import javax.swing.Icon

object ValkyrieFileType : LanguageFileType(ValkyrieLanguage) {
    override fun getName(): String = ValkyrieLanguage.id

    override fun getDescription(): String = YggdrasilBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "vk;valkyrie;"

    override fun getIcon(): Icon = YggdrasilIconProvider.Instance.File

}