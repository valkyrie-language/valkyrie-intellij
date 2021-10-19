package valkyrie.ide.project.library

import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieLibraryType : LibraryPresentationProvider<ValkyrieLibraryProperty>(kind) {
    companion object {
        const val ID = "library.valkyrie"
        val kind: LibraryKind = LibraryKind.create(ID)
    }

    override fun getDescription(properties: ValkyrieLibraryProperty): String? {
        return "ValkyrieLibraryType.getDescription"
    }

    override fun getIcon(properties: ValkyrieLibraryProperty?): Icon? {
        return ValkyrieIconProvider.FILE
    }

    override fun detect(classesRoots: MutableList<VirtualFile>): ValkyrieLibraryProperty? {
        for (root in classesRoots) {
            println("ValkyrieLibraryType.detect: $root")
        }
        return ValkyrieLibraryProperty()
    }

}
