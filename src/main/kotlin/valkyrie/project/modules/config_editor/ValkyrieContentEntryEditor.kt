package valkyrie.project.modules.config_editor

import com.intellij.openapi.roots.CompilerModuleExtension
import com.intellij.openapi.roots.ExcludeFolder
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ContentEntryEditor
import com.intellij.openapi.roots.ui.configuration.ContentRootPanel
import com.intellij.openapi.roots.ui.configuration.ModuleSourceRootEditHandler
import com.intellij.openapi.roots.ui.configuration.ProjectStructureConfigurable
import com.intellij.openapi.vfs.VirtualFile

class ValkyrieContentEntryEditor : ContentEntryEditor {
    private val myCompilerExtension: CompilerModuleExtension
    private val modifiableModel: ModifiableRootModel

    constructor(
        contentEntryUrl: String?,
        moduleSourceRootEditHandlers: List<ModuleSourceRootEditHandler<*>?>?,
        modifiableModel: ModifiableRootModel,
    ) : super(contentEntryUrl, moduleSourceRootEditHandlers) {
        this.modifiableModel = modifiableModel
        this.myCompilerExtension = model.getModuleExtension(CompilerModuleExtension::class.java)
    }

    override fun getModel(): ModifiableRootModel {
        return modifiableModel
    }

    override fun createContentRootPane(): ContentRootPanel {


        return ValkyrieContentRootPanel(this, editHandlers, contentEntry)
    }

    override fun doAddExcludeFolder(file: VirtualFile): ExcludeFolder? {
        val isCompilerOutput = isCompilerOutput(file.url)
        if (isCompilerOutput) {
            myCompilerExtension.isExcludeOutput = true
            return null
        }
        return super.doAddExcludeFolder(file)
    }

    override fun doRemoveExcludeFolder(excludeRootUrl: String) {
        if (isCompilerOutput(excludeRootUrl)) {
            myCompilerExtension.isExcludeOutput = false
        }
        super.doRemoveExcludeFolder(excludeRootUrl)
    }

    private fun isCompilerOutput(fileUrl: String): Boolean {
        if (fileUrl == myCompilerExtension.compilerOutputUrl) {
            return true
        }

        if (fileUrl == myCompilerExtension.compilerOutputUrlForTests) {
            return true
        }

        if (myCompilerExtension.isCompilerOutputPathInherited) {
            val instance = ProjectStructureConfigurable.getInstance(model.module.project)
            val compilerOutputUrl = instance.projectConfig.compilerOutputUrl
            if (fileUrl == compilerOutputUrl) {
                return true
            }
        }

        return false
    }
}