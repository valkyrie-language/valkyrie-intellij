package valkyrie.project.modules.config_editor

import com.intellij.facet.Facet
import com.intellij.facet.FacetModel
import com.intellij.facet.FacetTypeId
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.externalSystem.project.ArtifactExternalDependenciesImporter
import com.intellij.openapi.externalSystem.project.PackagingModifiableModel
import com.intellij.openapi.externalSystem.service.project.ArtifactExternalDependenciesImporterImpl
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.IdeUIModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.ModifiableModelsProviderExtension
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootModel
import com.intellij.openapi.roots.ProjectModelExternalSource
import com.intellij.openapi.roots.libraries.Library
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import com.intellij.openapi.roots.ui.configuration.FacetsProvider
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.intellij.openapi.util.Pair
import com.intellij.packaging.artifacts.*
import com.intellij.packaging.elements.CompositePackagingElement
import com.intellij.packaging.elements.ManifestFileProvider
import com.intellij.packaging.elements.PackagingElementResolvingContext
import com.intellij.packaging.impl.artifacts.DefaultManifestFileProvider


class ValkyrieModifiableModelsProvider : ModifiableModelsProviderExtension<ValkyriePackagingModifiableModel> {
    override fun create(
        project: Project,
        modelsProvider: IdeModifiableModelsProvider,
    ): Pair<Class<ValkyriePackagingModifiableModel>, ValkyriePackagingModifiableModel> {
        return Pair.create(
            ValkyriePackagingModifiableModel::class.java, ValkyriePackagingModifiableModel(project, modelsProvider)
        )
    }
}

class ValkyriePackagingModifiableModel : PackagingModifiableModel {
    private val myProject: Project
    private val myModelsProvider: IdeModifiableModelsProvider
    private var myModifiableArtifactModel: ModifiableArtifactModel? = null
    private var myPackagingElementResolvingContext: MyPackagingElementResolvingContext? = null
    private val myArtifactExternalDependenciesImporter: ArtifactExternalDependenciesImporter

    constructor(myProject: Project, myModelsProvider: IdeModifiableModelsProvider) {
        println("ValkyriePackagingModifiableModel")
        this.myProject = myProject
        this.myModelsProvider = myModelsProvider
        this.myArtifactExternalDependenciesImporter = ArtifactExternalDependenciesImporterImpl()
    }

    override fun getModifiableArtifactModel(): ModifiableArtifactModel {
        if (myModifiableArtifactModel == null) {
            myModifiableArtifactModel = if (myModelsProvider is IdeUIModifiableModelsProvider
            ) {
                myModelsProvider.modifiableArtifactModel
            } else {
                doGetModifiableArtifactModel()
            }
        }
        return myModifiableArtifactModel!!
    }

    private fun doGetModifiableArtifactModel(): ModifiableArtifactModel {
        return ReadAction.compute<ModifiableArtifactModel, RuntimeException> {
            val artifactManager = ArtifactManager.getInstance(myProject)
            if (artifactManager != null) artifactManager.createModifiableModel() else DummyArtifactModel()
        }
    }

    override fun getPackagingElementResolvingContext(): PackagingElementResolvingContext {
        if (myPackagingElementResolvingContext == null) {
            myPackagingElementResolvingContext = MyPackagingElementResolvingContext()
        }
        return myPackagingElementResolvingContext as MyPackagingElementResolvingContext
    }

    override fun getArtifactExternalDependenciesImporter(): ArtifactExternalDependenciesImporter {
        return myArtifactExternalDependenciesImporter
    }

    override fun commit() {
        myArtifactExternalDependenciesImporter.applyChanges(modifiableArtifactModel, packagingElementResolvingContext)
        if (myModifiableArtifactModel != null) {
            myModifiableArtifactModel!!.commit()
        }
    }

    override fun dispose() {
        if (myModifiableArtifactModel != null) {
            myModifiableArtifactModel!!.dispose()
        }
    }

    private inner class MyPackagingElementResolvingContext : PackagingElementResolvingContext {
        private val myModulesProvider: ModulesProvider = MyModulesProvider()
        private val myFacetsProvider = MyFacetsProvider()
        private val myManifestFileProvider: ManifestFileProvider = DefaultManifestFileProvider(this)

        override fun getProject(): Project {
            return myProject
        }

        override fun getArtifactModel(): ArtifactModel {
            return modifiableArtifactModel
        }

        override fun getModulesProvider(): ModulesProvider {
            return myModulesProvider
        }

        override fun getFacetsProvider(): FacetsProvider {
            return myFacetsProvider
        }

        override fun findLibrary(level: String, libraryName: String): Library? {
            if (level == LibraryTablesRegistrar.PROJECT_LEVEL) {
                return myModelsProvider.getLibraryByName(libraryName)
            }
            val table = LibraryTablesRegistrar.getInstance().getLibraryTableByLevel(level, myProject)
            return table?.getLibraryByName(libraryName)
        }

        override fun getManifestFileProvider(): ManifestFileProvider {
            return myManifestFileProvider
        }
    }

    private inner class MyModulesProvider : ModulesProvider {
        override fun getModules(): Array<Module> {
            return myModelsProvider.modules
        }

        override fun getModule(name: String): Module? {
            return myModelsProvider.findIdeModule(name)
        }

        override fun getRootModel(module: Module): ModuleRootModel {
            return myModelsProvider.getModifiableRootModel(module)
        }

        override fun getFacetModel(module: Module): FacetModel {
            return myModelsProvider.getModifiableFacetModel(module)
        }
    }

    private inner class MyFacetsProvider : FacetsProvider {
        override fun getAllFacets(module: Module): Array<Facet<*>> {
            return myModelsProvider.getModifiableFacetModel(module).allFacets
        }

        override fun <F : Facet<*>?> getFacetsByType(module: Module, type: FacetTypeId<F>): Collection<F> {
            return myModelsProvider.getModifiableFacetModel(module).getFacetsByType(type)
        }

        override fun <F : Facet<*>?> findFacet(module: Module, type: FacetTypeId<F>, name: String): F? {
            return myModelsProvider.getModifiableFacetModel(module).findFacet(type, name)
        }
    }

    private class DummyArtifactModel : ModifiableArtifactModel {
        override fun addArtifact(
            name: String,
            artifactType: ArtifactType,
            rootElement: CompositePackagingElement<*>?,
            externalSource: ProjectModelExternalSource?,
        ): ModifiableArtifact {
            throw UnsupportedOperationException()
        }

        override fun removeArtifact(artifact: Artifact) {
        }

        override fun getOrCreateModifiableArtifact(artifact: Artifact): ModifiableArtifact {
            throw UnsupportedOperationException()
        }

        override fun getModifiableCopy(artifact: Artifact): Artifact? {
            return null
        }

        override fun addListener(listener: ArtifactListener) {
        }

        override fun removeListener(listener: ArtifactListener) {
        }

        override fun isModified(): Boolean {
            return false
        }

        override fun commit() {
        }

        override fun dispose() {
        }

        override fun getArtifacts(): Array<Artifact> {
            return arrayOf()
        }

        override fun findArtifact(name: String): Artifact? {
            return null
        }

        override fun getArtifactByOriginal(artifact: Artifact): Artifact {
            throw UnsupportedOperationException()
        }

        override fun getOriginalArtifact(artifact: Artifact): Artifact {
            throw UnsupportedOperationException()
        }

        override fun getArtifactsByType(type: ArtifactType): Collection<Artifact> {
            throw UnsupportedOperationException()
        }

        override fun getAllArtifactsIncludingInvalid(): List<Artifact> {
            throw UnsupportedOperationException()
        }
    }
}
