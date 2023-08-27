package valkyrie.project.legion


import com.intellij.json.json5.Json5Language
import com.intellij.lang.Language
import com.intellij.lang.xml.XMLLanguage
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.isFile
import com.intellij.psi.LanguageSubstitutor

/** Make legion configuration file compatible with json5 standard */
class LegionFileTypeReinterpret : LanguageSubstitutor() {
    override fun getLanguage(file: VirtualFile, project: Project): Language? {
        return when {
            file.isFile -> when (file.name) {
                "legion.json",
                "legion.lock",
                "legions.json",
                "legions.lock",
                -> Json5Language.INSTANCE

                else -> null
            }

            else -> null
        }
    }
}