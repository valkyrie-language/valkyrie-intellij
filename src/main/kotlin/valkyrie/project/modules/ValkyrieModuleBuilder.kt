package valkyrie.project.modules

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.WizardInputField
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.project.ProjectType
import com.intellij.openapi.projectRoots.Sdk
import javax.swing.JComponent
import javax.swing.JLabel


class ValkyrieModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> {
        return ValkyrieModuleType()
    }

    override fun canCreateModule(): Boolean {
        return true
    }

    override fun validateModuleName(moduleName: String): Boolean {
        return super.validateModuleName(moduleName)
    }

    override fun getModuleFilePath(): String {
        return super.getModuleFilePath()
    }

    override fun getModuleFileDirectory(): String? {
        return super.getModuleFileDirectory()
    }

    override fun getName(): String {
        return "GetName23357"
    }

    override fun getPresentableName(): String {
        return "Valkyrie Module"
    }

    override fun getModuleTypeName(): String {
        return "GetModuleTypeNam123e"
    }

    override fun getDescription(): String {
        return "ValkyrieModuleBuilder.getDescription"
    }

    override fun getProjectType(): ProjectType {
        return ProjectType("ValkyrieModuleBuilder")
    }

    override fun getAdditionalFields(): MutableList<WizardInputField<*>> {
        return mutableListOf(CC())
    }

    override fun getModuleJdk(): Sdk {
        return super.getModuleJdk()
    }

}


class CC : WizardInputField<JComponent>("a", "b") {
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