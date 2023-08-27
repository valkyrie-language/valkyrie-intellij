package valkyrie.project.facet.kami

import com.intellij.facet.Facet
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.facet.impl.invalid.MultipleInvalidFacetEditor
import com.intellij.facet.ui.FacetEditor
import com.intellij.facet.ui.MultipleFacetSettingsEditor
import com.intellij.icons.AllIcons
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.project.Project
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

private val facetName = ValkyrieBundle.message("framework.kami.name")

/** Game development framework, similar to Unity, Godot */
class KamiFrameworkProvider : FacetType<KamiFacet, KamiConfigPanel> {
    constructor() : super(FacetTypeId(::KamiFrameworkProvider.toString()), ::KamiFrameworkProvider.toString(), facetName)

    override fun createDefaultConfiguration(): KamiConfigPanel {
        return KamiConfigPanel()
    }

    override fun createMultipleConfigurationsEditor(project: Project, editors: Array<out FacetEditor>): MultipleFacetSettingsEditor? {
        return MultipleInvalidFacetEditor(editors)
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return true
    }

    override fun createFacet(module: Module, name: String?, configuration: KamiConfigPanel, underlyingFacet: Facet<*>?): KamiFacet {
        return KamiFacet(this, module, name ?: "createFacet", configuration, null)
    }

    override fun getDefaultFacetName(): String {
        return facetName
    }

    override fun getIcon(): Icon {
        return AllIcons.CodeWithMe.CwmAccess
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

