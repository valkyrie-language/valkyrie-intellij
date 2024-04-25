package valkyrie.project.legion

import com.intellij.ide.util.projectWizard.WizardInputField
import javax.swing.JComponent
import javax.swing.JLabel

class ValkyrieWizardInputField : WizardInputField<JComponent>("a", "b") {
    override fun getLabel(): String {
        return "WizardInputField.getLabel"
    }

    override fun getComponent(): JComponent {
        return JLabel("Put your content here")
    }

    override fun getValue(): String {
        return "WizardInputField.getValue"
    }


}