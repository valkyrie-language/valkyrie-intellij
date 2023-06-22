package valkyrie.project.facet.iris

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.icons.ExpUiIcons
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

private val facetName = ValkyrieBundle.message("framework.iris.name")

/** Full stack framework based on MVVM, like React, Solid */
class IrisFrameworkProvider : FacetType<IrisFacet, IrisConfig> {
    constructor() : super(FacetTypeId(::IrisFrameworkProvider.toString()), ::IrisFrameworkProvider.toString(), facetName)

    override fun createDefaultConfiguration(): IrisConfig {
        return IrisConfig()
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return true
    }

    override fun createFacet(module: Module, name: String?, configuration: IrisConfig, underlyingFacet: Facet<*>?): IrisFacet {
        return IrisFacet(this, module, name ?: "createFacet", configuration, null)
    }

    override fun getDefaultFacetName(): String {
        return facetName
    }

    override fun getIcon(): Icon {
        return ExpUiIcons.Gutter.Colors
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

