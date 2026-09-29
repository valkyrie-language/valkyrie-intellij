package valkyrie.language.dialect_xml

import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.ValkyrieIcons

class ValkyrieXmlFileType private constructor() : LanguageFileType(ValkyrieXmlLanguage.INSTANCE) {
    companion object {
        val INSTANCE = ValkyrieXmlFileType()
    }

    override fun getName(): String = "Valkyrie XML"
    override fun getDescription(): String = "Valkyrie XML dialect"
    override fun getDefaultExtension(): String = "vkx"
    override fun getIcon() = ValkyrieIcons.FILE
}
