package valkyrie.project.facet

import com.intellij.openapi.module.ModuleConfigurationEditor
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationEditorProvider
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState

class ValkyrieExtraModuleConfigEditors : ModuleConfigurationEditorProvider {
    override fun createEditors(state: ModuleConfigurationState?): Array<ModuleConfigurationEditor> {
        /// Warning, this interface is valid for all languages
        /// Removed
        return arrayOf()
    }
}


