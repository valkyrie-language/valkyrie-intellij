package valkyrie.project.legion

import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.externalSystem.project.ArtifactExternalDependenciesImporter
import com.intellij.openapi.externalSystem.project.PackagingModifiableModel
import com.intellij.openapi.externalSystem.service.project.ArtifactExternalDependenciesImporterImpl
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.IdeUIModifiableModelsProvider
import com.intellij.openapi.project.Project
import com.intellij.packaging.artifacts.ArtifactManager
import com.intellij.packaging.artifacts.ModifiableArtifactModel
import com.intellij.packaging.elements.PackagingElementResolvingContext

class LegionModel : PackagingModifiableModel {
    private val _project: Project
    private val _modules: IdeModifiableModelsProvider
    private var _artifacts: ModifiableArtifactModel
    private var _context: LegionModelContext
    private val _importer: ArtifactExternalDependenciesImporter

    constructor(project: Project, myModelsProvider: IdeModifiableModelsProvider) {
        println("LegionModel")
        this._project = project
        this._modules = myModelsProvider
        this._artifacts = findArtifactModel()
        this._context = findContext()
        this._importer = ArtifactExternalDependenciesImporterImpl()
    }

    override fun getModifiableArtifactModel(): ModifiableArtifactModel {
        return _artifacts
    }

    private fun findArtifactModel(): ModifiableArtifactModel {
        return when (_modules) {
            is IdeUIModifiableModelsProvider -> {
                _modules.modifiableArtifactModel
            }

            else -> {
                ReadAction.compute<ModifiableArtifactModel, RuntimeException> {
                    val artifactManager = ArtifactManager.getInstance(_project)
//                    if (artifactManager != null) artifactManager.createModifiableModel() else LegionArtifactProvider()
                    artifactManager.createModifiableModel()
                }
            }
        }
    }

    override fun getPackagingElementResolvingContext(): PackagingElementResolvingContext {
        return _context
    }

    private fun findContext(): LegionModelContext {
        return LegionModelContext(_project, _modules, modifiableArtifactModel)
    }

    override fun getArtifactExternalDependenciesImporter(): ArtifactExternalDependenciesImporter {
        return _importer
    }

    override fun commit() {
        _importer.applyChanges(modifiableArtifactModel, packagingElementResolvingContext)
        _artifacts.commit()
    }

    override fun dispose() {
        _artifacts.dispose()
    }
}