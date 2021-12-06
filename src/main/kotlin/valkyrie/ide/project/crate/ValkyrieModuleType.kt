package valkyrie.ide.project.crate

import com.intellij.ide.util.frameworkSupport.FrameworkRole
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.SettingsStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import org.jetbrains.jps.model.module.JpsModuleSourceRootType
import valkyrie.ide.project.ValkyrieCreatePackage
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon


private const val ID = "VALKYRIE_MODULE_TYPE"

class ValkyrieModuleType : ModuleType<ValkyrieCreatePackage>(ID) {
    override fun createModuleBuilder(): ValkyrieCreatePackage {
        return ValkyrieCreatePackage()
    }

    override fun getName(): String {
        return "Valkyrie";
    }

    override fun getDescription(): String {
        return "ValkyrieModuleType getDescription";
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ValkyrieIconProvider.Valkyrie
    }

    override fun getDefaultAcceptableRole(): FrameworkRole {
        return super.getDefaultAcceptableRole()
    }

    override fun createWizardSteps(
        wizardContext: WizardContext,
        moduleBuilder: ValkyrieCreatePackage,
        modulesProvider: ModulesProvider
    ): Array<ModuleWizardStep> {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider)
    }

    override fun isValidSdk(module: Module, projectSdk: Sdk?): Boolean {
        return super.isValidSdk(module, projectSdk)
    }

    override fun isMarkInnerSupportedFor(type: JpsModuleSourceRootType<*>?): Boolean {
        return super.isMarkInnerSupportedFor(type)
    }

    override fun modifyProjectTypeStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep? {
        return super.modifyProjectTypeStep(settingsStep, moduleBuilder)
    }

    override fun isSupportedRootType(type: JpsModuleSourceRootType<*>?): Boolean {
        return super.isSupportedRootType(type)
    }

    override fun modifySettingsStep(settingsStep: SettingsStep, moduleBuilder: ModuleBuilder): ModuleWizardStep? {
        return super.modifySettingsStep(settingsStep, moduleBuilder)
    }

}