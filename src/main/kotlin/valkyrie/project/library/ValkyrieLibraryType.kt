package valkyrie.project.library

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.*
import com.intellij.openapi.roots.libraries.ui.LibraryEditorComponent
import com.intellij.openapi.roots.libraries.ui.LibraryPropertiesEditor
import com.intellij.openapi.roots.libraries.ui.LibraryRootsComponentDescriptor
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor
import com.intellij.openapi.vfs.VirtualFile
import org.jdom.Element
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon
import javax.swing.JComponent

class ValkyrieLibraryType : LibraryType<ValkyrieLibraryProperty>(ValkyrieLibraryKind()) {
    companion object {
        const val ID = "library.valkyrie"
        val kind by lazy {
            LibraryKind(ID)
        }
    }

    override fun getIcon(properties: ValkyrieLibraryProperty?): Icon? {
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

class ValkyrieLibraryProperty : LibraryProperties<Element>() {
    override fun equals(other: Any?): Boolean {
        if (other !is ValkyrieLibraryProperty) return false;
        return this.hashCode() == other.hashCode()
    }

    override fun hashCode(): Int {
        return 0
    }

    override fun getState(): Element? {
        return null
    }

    override fun loadState(state: Element) {

    }
}

class ValkyrieLibraryKind : PersistentLibraryKind<ValkyrieLibraryProperty>(ValkyrieLibraryType.ID) {
    override fun createDefaultProperties(): ValkyrieLibraryProperty {
        return ValkyrieLibraryProperty()
    }

    override fun getAdditionalRootTypes(): Array<OrderRootType> {
        return super.getAdditionalRootTypes()
    }
}