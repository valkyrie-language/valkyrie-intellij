//package valkyrie.ide.project.library
//
//import com.intellij.openapi.project.Project
//import com.intellij.openapi.roots.libraries.LibraryKind
//import com.intellij.openapi.roots.libraries.LibraryType
//import com.intellij.openapi.roots.libraries.NewLibraryConfiguration
//import com.intellij.openapi.roots.libraries.PersistentLibraryKind
//import com.intellij.openapi.roots.libraries.ui.LibraryEditorComponent
//import com.intellij.openapi.roots.libraries.ui.LibraryPropertiesEditor
//import com.intellij.openapi.vfs.VirtualFile
//import javax.swing.JComponent
//
//
//class ValkyrieLibraryType() : LibraryType<ValkyrieLibraryProperty>() {
//    companion object {
//        const val ID = "library.valkyrie"
//        val kind: LibraryKind = LibraryKind.create(ID)
//    }
//
//    override fun getCreateActionName(): String? {
//        return "getCreateActionName"
//    }
//
//    override fun createNewLibrary(parentComponent: JComponent, contextDirectory: VirtualFile?, project: Project): NewLibraryConfiguration? {
//        return null;
//    }
//
//    override fun createPropertiesEditor(editorComponent: LibraryEditorComponent<ValkyrieLibraryProperty>): LibraryPropertiesEditor? {
//        return null
//    }
//
//}