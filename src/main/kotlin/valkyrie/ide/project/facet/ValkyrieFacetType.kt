package valkyrie.ide.project.facet

import com.intellij.facet.Facet
import com.intellij.facet.FacetConfiguration
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeId
import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import valkyrie.ide.project.crate.ValkyrieModuleType
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

const val ID = "VALKYRIE_FACET_TYPE"

val Facet_ID: FacetTypeId<ValkyrieFacetInfo> = FacetTypeId(ID)

class ValkyrieFacetType : FacetType<ValkyrieFacetInfo, ValkyrieFacet>(Facet_ID, ID, "_") {
    override fun createDefaultConfiguration(): ValkyrieFacet {
        return ValkyrieFacet()
    }

    override fun isSuitableModuleType(moduleType: ModuleType<*>?): Boolean {
        return moduleType is ValkyrieModuleType
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Valkyrie
    }

    override fun getDefaultFacetName(): String {
        return "ValkyrieFacetType.getDefaultFacetName()"
    }

    override fun getPresentableName(): String {
        return "ValkyrieFacetType.getPresentableName()"
    }

    override fun getHelpTopic(): String {
        return "ValkyrieFacetType.getHelpTopic()"
    }


    override fun createFacet(module: Module, name: String?, configuration: ValkyrieFacet, underlyingFacet: Facet<*>?): ValkyrieFacetInfo {
        return ValkyrieFacetInfo(module, name ?: defaultFacetName, configuration, underlyingFacet)
    }
}


class ValkyrieFacet : FacetConfiguration {
    override fun createEditorTabs(editorContext: FacetEditorContext?, validatorsManager: FacetValidatorsManager?): Array<FacetEditorTab> {
        return arrayOf(

        )
    }
}


class ValkyrieFacetInfo(module: Module, name: String, configuration: ValkyrieFacet, underlyingFacet: Facet<*>?) :
    Facet<ValkyrieFacet>(
        ValkyrieFacetType(), module, name, configuration,
        underlyingFacet
    ) {


}