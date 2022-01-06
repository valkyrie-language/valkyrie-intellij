package valkyrie.language

import com.intellij.lang.Language

private const val LANGUAGE_ID = "Valkyrie"


object ValkyrieLanguage: Language(LANGUAGE_ID) {
    private fun readResolve(): Any = ValkyrieLanguage
    override fun getDisplayName(): String {
        return super.getDisplayName()
    }
    override fun getMimeTypes(): Array<String> {
        return arrayOf("text/x-valkyrie")
    }
}