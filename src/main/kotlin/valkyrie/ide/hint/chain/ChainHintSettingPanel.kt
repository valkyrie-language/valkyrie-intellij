package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.ChangeListener
import com.intellij.codeInsight.hints.ImmediateConfigurable
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.ui.dsl.builder.panel
import valkyrie.language.ValkyrieBundle
import javax.swing.JComponent


class ChainHintSettingPanel : ImmediateConfigurable {
    private val settings: ChainHintSetting

    constructor(settings: ChainHintSetting) {
        this.settings = settings
    }

    override val mainCheckboxText: String = super.mainCheckboxText
    override val cases: List<Case>
        get() {
            return listOf(
                Case(
                    "Obvious types",
                    "hints.type.obvious",
                    settings::show_obvious,
                    ValkyrieBundle.message("view.PropertiesGrouper")
                ),
                Case(
                    ".for type hint",
                    "hints.type.for",
                    settings::show_dot_for,
                    ValkyrieBundle.message("view.PropertiesGrouper")
                ),
                Case(
                    ".match type hint",
                    "hints.type.define",
                    settings::show_dot_match,
                    ValkyrieBundle.message("view.PropertiesGrouper")
                ),
                Case(
                    ".catch",
                    "hints.type.define",
                    settings::show_dot_catch,
                    ValkyrieBundle.message("view.PropertiesGrouper")
                ),
                Case(
                    "Iteration Type",
                    "hints.type.define",
                    settings::show_iterator,
                    ValkyrieBundle.message("view.PropertiesGrouper")
                ),
                Case(
                    "Future Type",
                    "hints.type.define",
                    settings::show_future,
                    ValkyrieBundle.message("view.PropertiesGrouper")
                ),
            )
        }

    override fun reset() {
        super.reset()
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
}