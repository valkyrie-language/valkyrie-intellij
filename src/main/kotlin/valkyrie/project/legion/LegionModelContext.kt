package valkyrie.project.legion

import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.roots.ui.configuration.FacetsProvider
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.packaging.artifacts.ArtifactModel
import com.intellij.packaging.artifacts.ModifiableArtifactModel
import com.intellij.packaging.elements.ManifestFileProvider
import com.intellij.packaging.elements.PackagingElementResolvingContext
import com.intellij.packaging.impl.artifacts.DefaultManifestFileProvider

class LegionModelContext : PackagingElementResolvingContext {
    private val _project: Project
    private val _models: IdeModifiableModelsProvider
    private val _artifact: ModifiableArtifactModel
    private val _modules: LegionModulesProvider
    private val _facets: LegionFacetsProvider
    private val _manifest: ManifestFileProvider

    constructor(project: Project, modules: IdeModifiableModelsProvider, modifiableArtifactModel: ModifiableArtifactModel) {
        this._project = project
        this._models = modules
        this._artifact = modifiableArtifactModel
        this._modules = LegionModulesProvider(modules)
        this._facets = LegionFacetsProvider(modules)
        this._manifest = DefaultManifestFileProvider(this)
    }

    override fun getProject(): Project {
        return _project
    }

    override fun getArtifactModel(): ArtifactModel {
        return _artifact
    }

    override fun getModulesProvider(): ModulesProvider {
        return _modules
    }

    override fun getFacetsProvider(): FacetsProvider {
        return _facets
    }

    override fun findLibrary(level: String, libraryName: String): Library? {
        if (level == LibraryTablesRegistrar.PROJECT_LEVEL) {
            return _models.getLibraryByName(libraryName)
        }
        val table = LibraryTablesRegistrar.getInstance().getLibraryTableByLevel(level, _project)
        return table?.getLibraryByName(libraryName)
    }

    override fun getManifestFileProvider(): ManifestFileProvider {
        return _manifest
    }
}