package valkyrie.ide.formatter

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.psi.codeStyle.CodeStyleSettings

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

