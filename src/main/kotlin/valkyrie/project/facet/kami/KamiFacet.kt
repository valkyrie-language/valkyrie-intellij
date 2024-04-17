package valkyrie.project.facet.kami

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.openapi.module.Module

class KamiFacet : Facet<KamiConfigPanel> {
    constructor(
        facetType: FacetType<out Facet<*>, *>,
        module: Module,
        name: String,
        configuration: KamiConfigPanel,
        underlyingFacet: Facet<*>?,
    ) : super(facetType, module, name, configuration, underlyingFacet)


}