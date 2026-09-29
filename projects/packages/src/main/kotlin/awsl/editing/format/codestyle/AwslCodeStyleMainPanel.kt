package awsl.editing.format.codestyle

import awsl.surface.file.AwslLanguage
import com.intellij.application.options.GenerationCodeStylePanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class AwslCodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings) :
    TabbedLanguageCodeStylePanel(
        awsl.surface.file.AwslLanguage.INSTANCE,
        currentSettings,
        settings
    ) {
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addWrappingAndBracesTab(settings)
        addTab(GenerationCodeStylePanel(settings, awsl.surface.file.AwslLanguage.INSTANCE))
    }
}
