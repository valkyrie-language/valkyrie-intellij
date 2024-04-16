package valkyrie.project.facet

import com.intellij.openapi.module.ModuleConfigurationEditor
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationEditorProvider
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState

class moduleConfigurationEditorProvider : ModuleConfigurationEditorProvider {
    override fun createEditors(state: ModuleConfigurationState?): Array<ModuleConfigurationEditor> {
        return arrayOf(ValkyrieModuleConfigurationEditor(), ValkyrieModuleConfigurationEditor())
    }
}


