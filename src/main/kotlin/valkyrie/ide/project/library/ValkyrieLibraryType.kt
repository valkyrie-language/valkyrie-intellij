package valkyrie.ide.project.library

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.LibraryType
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration
import com.intellij.openapi.roots.libraries.ui.LibraryEditorComponent
import com.intellij.openapi.roots.libraries.ui.LibraryPropertiesEditor
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon
import javax.swing.JComponent

/// 无需实现 library.presentationProvider
class ValkyrieLibraryType() : LibraryType<ValkyrieLibraryProperty>(ValkyrieLibraryKind()) {
    companion object {
        const val ID = "library.valkyrie"
    }

    override fun getCreateActionName(): String? {
        return "ValkyrieLibraryType.getCreateActionName"
    }
    override fun getDescription(properties: ValkyrieLibraryProperty): String? {
        return  "ValkyrieLibraryType.getDescription"
    }
    override fun createNewLibrary(parentComponent: JComponent, contextDirectory: VirtualFile?, project: Project): NewLibraryConfiguration? {
        return null
    }

    override fun createPropertiesEditor(editorComponent: LibraryEditorComponent<ValkyrieLibraryProperty>): LibraryPropertiesEditor? {
        return null
    }

    override fun getIcon(properties: ValkyrieLibraryProperty?): Icon? {
        return ValkyrieIconProvider.FILE
    }

    override fun getExternalRootTypes(): Array<OrderRootType> {
        return super.getExternalRootTypes()
    }
}
