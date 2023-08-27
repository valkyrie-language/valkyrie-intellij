package valkyrie.project.facet.asgard

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.icons.AllIcons
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

private val facetName = ValkyrieBundle.message("framework.asgard.name")

/** Full stack framework based on MVC, like Elixir Phoenix, Ruby on Rails */
class AsgardFrameworkProvider : FacetType<AsgardFacet, AsgardConfig> {
    constructor() : super(FacetTypeId(::AsgardFrameworkProvider.toString()), ::AsgardFrameworkProvider.toString(), facetName)

    override fun createDefaultConfiguration(): AsgardConfig {
        return AsgardConfig()
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return true
    }

    override fun createFacet(module: Module, name: String?, configuration: AsgardConfig, underlyingFacet: Facet<*>?): AsgardFacet {
        return AsgardFacet(this, module, name ?: "createFacet", configuration, null)
    }

    override fun getDefaultFacetName(): String {
        return facetName
    }

    override fun getIcon(): Icon {
        return AllIcons.Gutter.Colors
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

