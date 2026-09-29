package valkyrie.surface.file.dialect_asp

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.surface.file.ValkyrieIcons

class ValkyrieAspFileType private constructor() : LanguageFileType(ValkyrieAspLanguage.INSTANCE) {
    companion object {
        val INSTANCE = ValkyrieAspFileType()
    }

    override fun getName(): String = "Valkyrie Template"
    override fun getDescription(): String = "Valkyrie template dialect"
    override fun getDefaultExtension(): String = "vkt"
    override fun getIcon() = ValkyrieIcons.FILE
}
