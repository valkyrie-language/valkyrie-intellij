package valkyrie.project.legion

import com.intellij.facet.Facet
import com.intellij.facet.FacetTypeId
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ui.configuration.FacetsProvider

class LegionFacetsProvider : FacetsProvider {
    private val _models: IdeModifiableModelsProvider

    constructor(models: IdeModifiableModelsProvider) {
        this._models = models
    }

    override fun getAllFacets(module: Module): Array<Facet<*>> {
        return _models.getModifiableFacetModel(module).allFacets
    }

    override fun <F : Facet<*>?> getFacetsByType(module: Module, type: FacetTypeId<F>): Collection<F> {
        return _models.getModifiableFacetModel(module).getFacetsByType(type)
    }

    override fun <F : Facet<*>?> findFacet(module: Module, type: FacetTypeId<F>, name: String): F? {
        return _models.getModifiableFacetModel(module).findFacet(type, name)
    }
}