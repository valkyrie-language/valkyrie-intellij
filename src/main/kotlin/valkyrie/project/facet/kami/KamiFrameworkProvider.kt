package valkyrie.project.facet.kami

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.icons.ExpUiIcons
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

private val facetName = ValkyrieBundle.message("framework.aura.name")

/** Game development framework, similar to Unity, Godot */
class KamiFrameworkProvider : FacetType<KamiFacet, KamiConfigPanel> {
    constructor() : super(FacetTypeId("ValkyrieAuraFramework"), "ValkyrieAuraFramework2", facetName)

    override fun createDefaultConfiguration(): KamiConfigPanel {
        return KamiConfigPanel()
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return true
    }

    override fun createFacet(module: Module, name: String?, configuration: KamiConfigPanel, underlyingFacet: Facet<*>?): KamiFacet {
        return KamiFacet(this, module, name ?: "createFacet", configuration, null)
    }

    override fun getDefaultFacetName(): String {
        return "getDefaultFacetName"
    }

    override fun getIcon(): Icon {
        return ExpUiIcons.Javaee.WebService
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

