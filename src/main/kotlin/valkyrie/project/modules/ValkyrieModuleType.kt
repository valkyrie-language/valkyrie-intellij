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
import valkyrie.project.legion.LegionBuilder
import javax.swing.Icon
import javax.swing.JComponent


class ValkyrieModuleType : ModuleType<LegionBuilder>(ValkyrieLanguage.moduleID) {
    override fun createModuleBuilder(): LegionBuilder {
        return LegionBuilder()
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
        moduleBuilder: LegionBuilder,
        modulesProvider: ModulesProvider,
    ): Array<ModuleWizardStep> {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider)
    }

    override fun isSupportedRootType(type: JpsModuleSourceRootType<*>?): Boolean {
        return super.isSupportedRootType(type)
    }

    override fun isValidSdk(module: Module, projectSdk: Sdk?): Boolean {
        return super.isValidSdk(module, projectSdk)
    }

    override fun isMarkInnerSupportedFor(type: JpsModuleSourceRootType<*>?): Boolean {
        return super.isMarkInnerSupportedFor(type)
    }

    override fun modifyProjectTypeStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep? {
        return AA()
    }

    override fun modifySettingsStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep? {
        return BB()
    }
}


class AA : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return panel {
            row("modifyProjectTypeStep") {
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