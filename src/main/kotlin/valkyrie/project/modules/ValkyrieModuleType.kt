package valkyrie.project.modules

import com.intellij.ide.util.frameworkSupport.FrameworkRole
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.SettingsStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.ui.dsl.builder.panel
import org.jetbrains.jps.model.module.JpsModuleSourceRootType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.project.legion.LegionWorkspaceBuilder
import javax.swing.Icon
import javax.swing.JComponent


class ValkyrieModuleType : ModuleType<LegionWorkspaceBuilder>(ValkyrieLanguage.moduleID) {
    override fun createModuleBuilder(): LegionWorkspaceBuilder {
        return LegionWorkspaceBuilder()
    }

    override fun getName(): String {
        return "ValkyrieModuleType11"
    }

    override fun getDescription(): String {
        return "ValkyrieModuleType22"
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Effect
    }

    override fun getDefaultAcceptableRole(): FrameworkRole {
        return super.getDefaultAcceptableRole()
    }

    override fun createWizardSteps(
        wizardContext: WizardContext,
        moduleBuilder: LegionWorkspaceBuilder,
        modulesProvider: ModulesProvider,
    ): Array<ModuleWizardStep> {
        return arrayOf(AA("createWizardSteps"))
    }

    override fun isSupportedRootType(type: JpsModuleSourceRootType<*>?): Boolean {
        return true
    }

    override fun isValidSdk(module: Module, projectSdk: Sdk?): Boolean {
        return super.isValidSdk(module, projectSdk)
    }

    override fun isMarkInnerSupportedFor(type: JpsModuleSourceRootType<*>?): Boolean {
        return super.isMarkInnerSupportedFor(type)
    }

    override fun modifyProjectTypeStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep? {
        return AA("modifyProjectTypeStep")
    }

    override fun modifySettingsStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep? {
        return AA("modifySettingsStep")
    }
}


class AA(private val name: String) : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return panel {
            row(name) {
                text("???")
            }
        }
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return super.getPreferredFocusedComponent()
    }

    override fun getIcon(): Icon? {
        return super.getIcon()
    }

    override fun getName(): String {
        return super.getName()
    }

    override fun getHelpId(): String {
        return super.getHelpId()
    }

    override fun updateDataModel() {

    }

}

class BB : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return panel {
            row("modifySettingsStep") {
                text("???")
            }
        }
    }

    override fun updateDataModel() {

    }

}