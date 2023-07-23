package valkyrie.project.legion

import com.intellij.ide.highlighter.ModuleFileType
import com.intellij.ide.util.projectWizard.*
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectType
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.openapi.util.Computable
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.resolveFromRootOrRelative
import valkyrie.project.modules.ValkyrieModuleType
import java.io.File


class LegionWorkspaceBuilder : ModuleBuilder() {
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
        return ProjectType("LegionWorkspaceBuilder")
    }

    override fun getAdditionalFields(): MutableList<WizardInputField<*>> {
        return mutableListOf(ValkyrieWizardInputField())
    }

    override fun isTemplate(): Boolean {
        return false
    }

    override fun addModuleConfigurationUpdater(updater: ModuleConfigurationUpdater?) {
        super.addModuleConfigurationUpdater(updater)
    }

    override fun isOpenProjectSettingsAfter(): Boolean {
        return super.isOpenProjectSettingsAfter()
    }

    override fun modifyProjectTypeStep(settingsStep: SettingsStep): ModuleWizardStep? {
        return ValkyrieModuleWizardStep("modifyProjectTypeStep")
    }

    override fun modifyStep(settingsStep: SettingsStep?): ModuleWizardStep {
        return ValkyrieModuleWizardStep("modifyStep")
    }

    override fun getContentEntryPath(): String? {
        return super.getContentEntryPath()
    }

    override fun getBuilderId(): String? {
        return super.getBuilderId()
    }

    override fun createWizardSteps(wizardContext: WizardContext, modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return arrayOf(ValkyrieModuleWizardStep("createWizardSteps"))
    }

    override fun createFinishingSteps(wizardContext: WizardContext, modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return arrayOf(ValkyrieModuleWizardStep("createFinishingSteps"))
    }

    override fun modifySettingsStep(settingsStep: SettingsStep): ModuleWizardStep {
        return ValkyrieModuleWizardStep("modifySettingsStep")
    }

    override fun commit(project: Project, model: ModifiableModuleModel?, modulesProvider: ModulesProvider?): MutableList<Module> {
        configProjectRoot(project)
        return when (val root = commitModule(project, model)) {
            null -> mutableListOf()
            else -> mutableListOf(root)
        }
    }

    override fun commitModule(project: Project, model: ModifiableModuleModel?): Module? {
        return ApplicationManager.getApplication().runWriteAction(
            Computable {
                createAndCommitIfNeeded(
                    project,
                    model,
                    true
                )
            })
    }

    override fun createModule(moduleModel: ModifiableModuleModel): Module {
        deleteModuleFile(moduleFilePath)
        val module = moduleModel.newModule(moduleFilePath, moduleType.id)
        setupModule(module)
        return module
    }

    override fun setupModule(module: Module?) {
        super.setupModule(module)
    }

    override fun setupRootModel(model: ModifiableRootModel) {
//        val root = model.module.moduleFile ?: return
//        markSources(root, model, "library", "source", "src")
//        markTests(root, model, "test", "tests")
//        markTests(root, model, "benchmark", "benchmarks", "bench")
//        markTests(root, model, "example", "examples")
//        markExclude(root, model, "target", "build", "out", "dist")
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

    override fun getCustomOptionsStep(context: WizardContext?, parentDisposable: Disposable?): ModuleWizardStep? {
        return ValkyrieModuleWizardStep("getCustomOptionsStep")
    }


}

private fun LegionWorkspaceBuilder.configProjectRoot(project: Project) {
    name = project.name
    val dotIdea = project.projectFile?.findChild(Project.DIRECTORY_STORE_FOLDER);
    moduleFilePath = when (dotIdea) {
        null -> {
            project.basePath + File.separator + name + ModuleFileType.DOT_DEFAULT_EXTENSION
        }

        else -> {
            dotIdea.resolveFromRootOrRelative(name + ModuleFileType.DOT_DEFAULT_EXTENSION)?.path
        }
    }
}


