package valkyrie.project.modules.config_editor

import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.SourceFolder
import com.intellij.openapi.roots.ui.configuration.ContentRootPanel
import com.intellij.openapi.roots.ui.configuration.ModuleSourceRootEditHandler
import javax.swing.JComponent

class ValkyrieModuleRootsContentRoot : ContentRootPanel {
    private val entry: ContentEntry?

    constructor(callback: ActionCallback, handler: List<ModuleSourceRootEditHandler<*>?>, entry: ContentEntry?) : super(callback, handler) {
        this.entry = entry
    }

    override fun getContentEntry(): ContentEntry? {
        return entry
    }

    override fun createRootPropertiesEditor(editor: ModuleSourceRootEditHandler<*>, folder: SourceFolder): JComponent? {
        return editor.createPropertiesEditor(folder, this, myCallback)
    }
}