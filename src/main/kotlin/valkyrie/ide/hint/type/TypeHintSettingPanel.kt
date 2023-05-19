package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.ChangeListener
import com.intellij.codeInsight.hints.ImmediateConfigurable
import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import com.intellij.ui.dsl.builder.panel
import valkyrie.language.ValkyrieBundle
import javax.swing.JComponent

@Suppress("UnstableApiUsage")
class TypeHintSettingPanel(private val settings: TypeHintSetting) : ImmediateConfigurable {
    override val mainCheckboxText: String
        get() = super.mainCheckboxText
    override val cases: List<Case>
        get() = listOf(
            Case(
                "Obvious types",
                "hints.type.obvious",
                settings::show_obvious_type,
                ValkyrieBundle.message("view.PropertiesGrouper")
            ),
            Case(
                "For loop types",
                "hints.type.for",
                settings::showForLoopType,
                ValkyrieBundle.message("view.PropertiesGrouper")
            ),
            Case(
                "Define return types",
                "hints.type.define",
                settings::showDefineReturnType,
                ValkyrieBundle.message("view.PropertiesGrouper")
            ),
            Case(
                "Bitflag types",
                "hints.type.bitflag",
                settings::showBitFlagType,
                ValkyrieBundle.message("view.PropertiesGrouper")
            ),
        )

    override fun reset() {
        super.reset()
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
}