package valkyrie.language

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType


private const val LANGUAGE_ID = "valkyrie"


object ValkyrieLanguage : Language(LANGUAGE_ID) {
    private fun readResolve(): Any = ValkyrieLanguage
    override fun getID(): String {
        return LANGUAGE_ID
    }

    override fun getDisplayName(): String {
        return "Valkyrie"
    }

    override fun getAssociatedFileType(): LanguageFileType? {
        return super.getAssociatedFileType()
    }

    override fun getMimeTypes(): Array<String> {
        return arrayOf("text/x-valkyrie")
    }
}