package valkyrie.project.facet.iris

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.icons.AllIcons
import com.intellij.openapi.extensions.PluginDescriptor
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon


/** Full stack framework based on MVVM, like React, Solid */
class ValkyrieFrameworkProvider : FacetType<ValkyrieFacet, ValkyrieFacetConfig> {
    constructor() : super(ValkyrieFacet.TYPE_ID, ValkyrieFacet.ID, ValkyrieFacet.SAVE_NAME)

    override fun createDefaultConfiguration(): ValkyrieFacetConfig {
        return ValkyrieFacetConfig()
    }

    override fun createFacet(module: Module, name: String?, configuration: ValkyrieFacetConfig, underlyingFacet: Facet<*>?): ValkyrieFacet {
        println("createFacet: $module $name $configuration $underlyingFacet")
        return ValkyrieFacet(this, module, name ?: "createFacet", configuration, null)
    }


    override fun getIcon(): Icon {
        return AllIcons.Gutter.Colors
    }

    override fun getHelpTopic(): String {
        return "getHelpTopic"
    }

    /** Facet display name */
    override fun getPresentableName(): String {
        return ValkyrieBundle.message("facet.name")
    }

    /** One package can have only one framework */
    override fun isOnlyOneFacetAllowed(): Boolean {
        return true
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        println("isSuitableModuleType: $moduleType(${moduleType?.name})")
        return true
    }

    override fun setPluginDescriptor(pluginDescriptor: PluginDescriptor) {
        super.setPluginDescriptor(pluginDescriptor)
    }


}

