package valkyrie.project.facet

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.openapi.module.Module

class ValkyrieFacet : Facet<ValkyrieFacetConfig> {
    constructor(
        facetType: FacetType<out Facet<*>, *>,
        module: Module,
        name: String,
        configuration: ValkyrieFacetConfig,
        underlyingFacet: Facet<*>?,
    ) : super(facetType, module, name, configuration, underlyingFacet)


}