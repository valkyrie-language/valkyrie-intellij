package valkyrie.project.facet

import com.intellij.facet.Facet
import com.intellij.facet.FacetConfiguration
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType

class ValkyrieFacetType :
    FacetType<ValkyrieFacet, ValkyrieFacetConfig>(FacetTypeId("ValkyrieFacetType1"), "ValkyrieFacetType12", "ValkyrieFacetType13") {
    override fun createDefaultConfiguration(): ValkyrieFacetConfig {
        return ValkyrieFacetConfig()
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return true
    }

    override fun createFacet(module: Module, name: String?, configuration: ValkyrieFacetConfig, underlyingFacet: Facet<*>?): ValkyrieFacet {
        return ValkyrieFacet(this, module, name ?: "createFacet", configuration, null)
    }

}

class ValkyrieFacet : Facet<ValkyrieFacetConfig> {
    constructor(
        facetType: FacetType<out Facet<*>, *>,
        module: Module,
        name: String,
        configuration: ValkyrieFacetConfig,
        underlyingFacet: Facet<*>?,
    ) : super(facetType, module, name, configuration, underlyingFacet)

}

class ValkyrieFacetConfig : FacetConfiguration {
    override fun createEditorTabs(editorContext: FacetEditorContext?, validatorsManager: FacetValidatorsManager?): Array<FacetEditorTab> {
        return arrayOf()
    }
}