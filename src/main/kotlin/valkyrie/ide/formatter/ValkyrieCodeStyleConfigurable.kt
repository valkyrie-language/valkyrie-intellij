package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie 代码样式配置面板
 */
class ValkyrieCodeStyleConfigurable(settings: CodeStyleSettings, cloneSettings: CodeStyleSettings) :
    CodeStyleAbstractConfigurable(settings, cloneSettings, "Valkyrie") {
    
    override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
        return ValkyrieCodeStyleMainPanel(currentSettings, settings)
    }
    
    override fun getHelpTopic(): String? = null
}

/**
 * Valkyrie 代码样式主面板
 */
class ValkyrieCodeStyleMainPanel(currentSettings: CodeStyleSettings, settings: CodeStyleSettings) :
    TabbedLanguageCodeStylePanel(ValkyrieLanguage.INSTANCE, currentSettings, settings) {
    
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addSpacesTab(settings)
        addWrappingAndBracesTab(settings)
        addBlankLinesTab(settings)
    }
}