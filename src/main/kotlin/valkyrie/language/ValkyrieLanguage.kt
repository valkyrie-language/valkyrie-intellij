package valkyrie.language

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import valkyrie.language.file.ValkyrieFileType


private const val LANGUAGE_ID = "valkyrie"

object ValkyrieLanguage : Language(LANGUAGE_ID) {
    private fun readResolve(): Any = ValkyrieLanguage
    override fun getID(): String {
        return LANGUAGE_ID
    }

    val moduleID: String = "VALKYRIE_MODULE_TYPE"
    val libiaryID: String = "valkyrie.source"

    override fun getDisplayName(): String {
        return "Valkyrie"
    }

    override fun getAssociatedFileType(): LanguageFileType {
        return ValkyrieFileType
    }

    override fun getMimeTypes(): Array<String> {
        return arrayOf("text/x-valkyrie")
    }
}