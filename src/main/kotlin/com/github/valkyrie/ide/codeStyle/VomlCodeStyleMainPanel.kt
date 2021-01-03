package com.github.valkyrie.ide.codeStyle

import com.intellij.application.options.GenerationCodeStylePanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class VomlCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings?) :
    TabbedLanguageCodeStylePanel(
        com.github.valkyrie.ValkyrieLanguage.INSTANCE,
        currentSettings,
        settings
    ) {
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addWrappingAndBracesTab(settings)
        addTab(GenerationCodeStylePanel(settings, com.github.valkyrie.ValkyrieLanguage.INSTANCE))
    }
}
