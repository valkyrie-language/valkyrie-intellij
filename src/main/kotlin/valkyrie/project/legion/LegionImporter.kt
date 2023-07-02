package valkyrie.project.legion

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.ModifiableModuleModel
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.SdkTypeId
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.packaging.artifacts.ModifiableArtifactModel
import com.intellij.projectImport.ProjectImportBuilder
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class LegionImporter : ProjectImportBuilder<LegionImporterConfig>() {
    override fun commit(
        project: Project,
        model: ModifiableModuleModel?,
        modulesProvider: ModulesProvider,
        artifactModel: ModifiableArtifactModel,
    ): MutableList<Module> {
        val analyzer = LegionStructureAnalyzer(project)
        ApplicationManager.getApplication().runWriteAction {
            analyzer.markWorkspace(model)
        }
        return modulesProvider.modules.toMutableList()

//        return LegionWorkspaceBuilder().commit(project, model, modulesProvider)
    }


    override fun getName(): String {
        return "Legion"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun isOpenProjectSettingsAfter(): Boolean {
        return false
    }

    override fun setOpenProjectSettingsAfter(on: Boolean) {

    }

    override fun isMarked(element: LegionImporterConfig?): Boolean {
        return false
    }

    override fun createProject(name: String?, path: String?): Project? {
        return super.createProject(name, path)
    }


    override fun getTitle(): String {
        return super.getTitle()
    }


    override fun getFileToImport(): String {
        return super.getFileToImport()
    }

    override fun setList(list: MutableList<LegionImporterConfig>?) {
        super.setList(list)
    }

    override fun cleanup() {
        super.cleanup()
    }

    override fun getList(): MutableList<LegionImporterConfig>? {
        return super.getList()
    }

    override fun setFileToImport(path: String) {
        super.setFileToImport(path)
    }

    override fun isSuitableSdkType(sdkType: SdkTypeId?): Boolean {
        return super.isSuitableSdkType(sdkType)
    }
}

class LegionImporterConfig {

}


