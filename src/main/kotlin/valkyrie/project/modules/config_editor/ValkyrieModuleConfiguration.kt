package valkyrie.project.modules.config_editor

import com.intellij.openapi.module.ModuleConfigurationEditor
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ui.configuration.*
import valkyrie.language.ValkyrieLanguage


class ValkyrieModuleConfiguration : ModuleConfigurationEditorProviderEx {
    /** Project Settings > Modules */
    override fun createEditors(state: ModuleConfigurationState?): Array<ModuleConfigurationEditor> {
        val module = state?.currentRootModel?.module ?: return arrayOf()
        val id = ModuleType.get(module).id
        return when {
            id == ValkyrieLanguage.moduleID -> {
                arrayOf(
                    ValkyrieModuleRootsEditor(module.name, state),
                    ClasspathEditor(state),
                    AnnotationsEditor(state),
                    JavadocEditor(state),
                )
            }

            else -> {
                arrayOf()
            }
        }
    }

    override fun isCompleteEditorSet(): Boolean {
        return false
    }
}