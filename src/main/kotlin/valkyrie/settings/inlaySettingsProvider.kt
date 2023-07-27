package valkyrie.settings

import com.intellij.codeInsight.hints.settings.InlayProviderSettingsModel
import com.intellij.codeInsight.hints.settings.InlaySettingsProvider
import com.intellij.lang.Language
import com.intellij.openapi.project.Project
import valkyrie.language.ValkyrieLanguage

class inlaySettingsProvider : InlaySettingsProvider {
    override fun createModels(project: Project, language: Language): List<InlayProviderSettingsModel> {
        return listOf()
    }

    override fun getSupportedLanguages(project: Project): Collection<Language> {
        return listOf(ValkyrieLanguage)
    }
}
