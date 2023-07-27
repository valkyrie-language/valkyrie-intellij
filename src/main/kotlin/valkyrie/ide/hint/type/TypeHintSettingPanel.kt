package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.ChangeListener
import com.intellij.codeInsight.hints.ImmediateConfigurable
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent


class TypeHintSettingPanel(private val settings: TypeHintSetting) : ImmediateConfigurable {
    override val mainCheckboxText = super.mainCheckboxText
    override val cases: List<Case>
        get() {
            return settings.buildOptions()
        }


    override fun createComponent(listener: ChangeListener): JComponent {
        return panel {
            row {
                checkBox("Show obvious type").applyToComponent {
                    isSelected = settings.show_obvious_type
                    addActionListener {
                        settings.show_obvious_type = isSelected
                        listener.settingsChanged()
                    }
                }
            }
        }
    }

    override fun reset() {

    }
}