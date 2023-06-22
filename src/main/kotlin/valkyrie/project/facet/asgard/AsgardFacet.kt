package valkyrie.project.facet.asgard

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.openapi.module.Module

class AsgardFacet : Facet<AsgardConfig> {
    constructor(
        facetType: FacetType<out Facet<*>, *>,
        module: Module,
        name: String,
        configuration: AsgardConfig,
        underlyingFacet: Facet<*>?,
    ) : super(facetType, module, name, configuration, underlyingFacet)


}