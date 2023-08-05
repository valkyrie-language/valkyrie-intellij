package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.ChangeListener
import com.intellij.codeInsight.hints.ImmediateConfigurable
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent


class ChainHintSettingPanel : ImmediateConfigurable {
    private val settings: ChainHintSetting

    constructor(settings: ChainHintSetting) {
        this.settings = settings
    }

    override val mainCheckboxText: String = super.mainCheckboxText
    override val cases: List<Case>
        get() {
            return settings.buildOptions()
        }

    override fun createComponent(listener: ChangeListener): JComponent {
        return panel {
            row {
                checkBox("Show obvious type").applyToComponent {
                    isSelected = settings.show_obvious
                    addActionListener {
                        settings.show_obvious = isSelected
                        listener.settingsChanged()
                    }
                }
            }
        }
    }

    override fun reset() {

    }
}