package valkyrie.project.facet

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

private val facetName = ValkyrieBundle.message("facet.type.name")

class ValkyrieFacetType : FacetType<ValkyrieFacet, ValkyrieFacetConfig> {
    constructor() : super(FacetTypeId("ValkyrieFacetType1"), "ValkyrieFacetType12", facetName)

    override fun createDefaultConfiguration(): ValkyrieFacetConfig {
        return ValkyrieFacetConfig()
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return true
    }

    override fun createFacet(module: Module, name: String?, configuration: ValkyrieFacetConfig, underlyingFacet: Facet<*>?): ValkyrieFacet {
        return ValkyrieFacet(this, module, name ?: "createFacet", configuration, null)
    }

    override fun getDefaultFacetName(): String {
        return "getDefaultFacetName"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun getHelpTopic(): String {
        return "getHelpTopic"
    }

    override fun getPresentableName(): String {
        return super.getPresentableName()
    }

    override fun isOnlyOneFacetAllowed(): Boolean {
        return true
    }
}

