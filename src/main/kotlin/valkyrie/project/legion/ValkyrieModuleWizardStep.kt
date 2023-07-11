package valkyrie.project.legion

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieModuleWizardStep(val text: String) : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return panel {
            row(text) {
                text("???")
            }
        }
    }

    override fun updateDataModel() {

    }

}