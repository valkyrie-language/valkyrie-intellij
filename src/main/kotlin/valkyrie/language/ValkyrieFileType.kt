package valkyrie.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class ValkyrieFileType private constructor() : LanguageFileType(ValkyrieLanguage.INSTANCE) {
    companion object {
        val INSTANCE = ValkyrieFileType()
    }

    override fun getName(): String {
        return "Valkyrie File"
    }

    override fun getDescription(): String {
        return "Valkyrie language file"
    }

    override fun getDefaultExtension(): String {
        return "valkyrie"
    }

    override fun getIcon(): Icon? {
        return ValkyrieIcons.VK_FILE
    }
}