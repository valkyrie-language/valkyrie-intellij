package valkyrie.project.legion

import com.intellij.ide.util.frameworkSupport.FrameworkRole
import com.intellij.ide.util.projectWizard.*
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectType
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.resolveFromRootOrRelative
import com.intellij.ui.dsl.builder.panel
import valkyrie.project.modules.ValkyrieModuleType
import javax.swing.Icon
import javax.swing.JComponent
import javax.swing.JLabel


class LegionBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> {
        return ValkyrieModuleType()
    }

    override fun canCreateModule(): Boolean {
        return true
    }


    override fun validateModuleName(moduleName: String): Boolean {
        return super.validateModuleName(moduleName)
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

    override fun isTemplate(): Boolean {
        return super.isTemplate()
    }

    override fun addModuleConfigurationUpdater(updater: ModuleConfigurationUpdater?) {
        super.addModuleConfigurationUpdater(updater)
    }

    override fun setModuleJdk(jdk: Sdk?) {
        super.setModuleJdk(jdk)
    }

    override fun isOpenProjectSettingsAfter(): Boolean {
        return super.isOpenProjectSettingsAfter()
    }

    override fun modifyProjectTypeStep(settingsStep: SettingsStep): ModuleWizardStep? {
        return DD("modifyProjectTypeStep")
    }

    override fun modifyStep(settingsStep: SettingsStep?): ModuleWizardStep {
        return DD("modifyStep")
    }

    override fun getContentEntryPath(): String? {
        return super.getContentEntryPath()
    }

    override fun getBuilderId(): String? {
        return super.getBuilderId()
    }

    override fun getNodeIcon(): Icon {
        return super.getNodeIcon()
    }

    override fun getDefaultAcceptableRole(): FrameworkRole {
        return super.getDefaultAcceptableRole()
    }


    override fun createWizardSteps(wizardContext: WizardContext, modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return arrayOf(DD("createWizardSteps"))
    }

    override fun createFinishingSteps(wizardContext: WizardContext, modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return arrayOf(DD("createFinishingSteps"))
    }

    override fun createProject(name: String?, path: String?): Project? {
        return super.createProject(name, path)
    }

    override fun modifySettingsStep(settingsStep: SettingsStep): ModuleWizardStep {
        return DD("modifySettingsStep")
    }

    override fun commit(project: Project, model: ModifiableModuleModel?, modulesProvider: ModulesProvider?): MutableList<Module> {
        val module = commitModule(project, model)
        return if (module != null) mutableListOf(module) else mutableListOf()
    }

    override fun setModuleFilePath(path: String?) {
        super.setModuleFilePath(path)
    }


    override fun setupRootModel(model: ModifiableRootModel) {
        val root = model.module.moduleFile ?: return
        markSources(root, model, "library", "source", "src")
        markTests(root, model, "test", "tests")
        markTests(root, model, "benchmark", "benchmarks", "bench")
        markTests(root, model, "example", "examples")
        markExclude(root, model, "target", "build", "out", "dist")
        model.commit()
    }

    private fun markSources(root: VirtualFile, model: ModifiableRootModel, vararg sources: String) {
        for (source in sources) {
            val src = root.resolveFromRootOrRelative(source)
            if (src != null) {
                val contentEntry = model.addContentEntry(src)
                contentEntry.addSourceFolder(src, false)
                break
            }
        }
    }

    private fun markTests(root: VirtualFile, model: ModifiableRootModel, vararg sources: String) {
        for (source in sources) {
            val src = root.resolveFromRootOrRelative(source)
            if (src != null) {
                val contentEntry = model.addContentEntry(src)
                contentEntry.addSourceFolder(src, true)
                break
            }
        }
    }

    private fun markExclude(root: VirtualFile, model: ModifiableRootModel, vararg sources: String) {
        for (source in sources) {
            val src = root.resolveFromRootOrRelative(source)
            if (src != null) {
                val contentEntry = model.addContentEntry(src)
                contentEntry.addExcludeFolder(src)
            }
        }
    }
}

class DD(val text: String) : ModuleWizardStep() {
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