package valkyrie.language.dialect_markup

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.ValkyrieIcons

class ValkyrieMarkFileType private constructor() : LanguageFileType(ValkyrieMarkLanguage.INSTANCE) {
    companion object {
        val INSTANCE = ValkyrieMarkFileType()
    }

    override fun getName(): String = "Valkyrie Mark"
    override fun getDescription(): String = "Valkyrie markup dialect"
    override fun getDefaultExtension(): String = "vkm"
    override fun getIcon() = ValkyrieIcons.FILE
}
