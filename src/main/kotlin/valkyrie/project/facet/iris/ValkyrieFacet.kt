package valkyrie.project.facet.iris

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.openapi.module.Module

class ValkyrieFacet : Facet<ValkyrieFacetConfig> {
    constructor(
        facetType: FacetType<out Facet<*>, *>,
        module: Module,
        name: String,
        configuration: ValkyrieFacetConfig,
        underlyingFacet: Facet<*>?,
    ) : super(facetType, module, name, configuration, underlyingFacet)

    override fun initFacet() {

    }

    companion object {
        /** saved in project.iml */
        const val SAVE_NAME = "Valkyrie Framework"

        /** recommend name for JetBrains users */
        const val ID = "VALKYRIE_FACET_TYPE";
        val TYPE_ID = FacetTypeId<ValkyrieFacet>("ValkyrieFacet debug name")
    }
}