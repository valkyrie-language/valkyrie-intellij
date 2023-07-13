package valkyrie.project.library

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.LibraryType
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration
import com.intellij.openapi.roots.libraries.PersistentLibraryKind
import com.intellij.openapi.roots.libraries.ui.LibraryEditorComponent
import com.intellij.openapi.roots.libraries.ui.LibraryPropertiesEditor
import com.intellij.openapi.roots.libraries.ui.LibraryRootsComponentDescriptor
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon
import javax.swing.JComponent

class ValkyrieLibraryType : LibraryType<ValkyrieLibraryProperty>(ValkyrieLibraryKind()) {
    override fun getIcon(properties: ValkyrieLibraryProperty?): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun getCreateActionName() = ValkyrieBundle.message("library.create")
    override fun getDescription(properties: ValkyrieLibraryProperty): String? {


        return "ValkyrieLibraryType.getDescription: ${properties.state}"
    }

    override fun createNewLibrary(parentComponent: JComponent, contextDirectory: VirtualFile?, project: Project): NewLibraryConfiguration? {
        if (contextDirectory == null) {
            return null
        }
        return NewLibraryPanel(project, contextDirectory, this, ValkyrieLibraryProperty())
    }

    override fun createPropertiesEditor(editorComponent: LibraryEditorComponent<ValkyrieLibraryProperty>): LibraryPropertiesEditor? {
        return null
    }

    override fun createLibraryRootsComponentDescriptor(): LibraryRootsComponentDescriptor? {
        return null
    }

    override fun getExternalRootTypes(): Array<OrderRootType> {
        return super.getExternalRootTypes()
    }

    override fun detect(classesRoots: MutableList<VirtualFile>): ValkyrieLibraryProperty? {
        return ValkyrieLibraryProperty()
    }

    override fun getKind(): PersistentLibraryKind<ValkyrieLibraryProperty> {
        return super.getKind()
    }
}

private class NewLibraryPanel(
    val project: Project,
    val directory: VirtualFile,
    library: ValkyrieLibraryType,
    properties: ValkyrieLibraryProperty,
) :
    NewLibraryConfiguration("NewLibraryPanel", library, properties) {
    override fun addRoots(editor: LibraryEditor) {
        project.projectFile?.let {
            for (item in it.children) {
                editor.addRoot(item, OrderRootType.CLASSES)
            }
        }
    }

    override fun getDefaultLibraryName(): String {
        return directory.name
    }
}

