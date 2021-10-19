package valkyrie.ide.project.library

import com.intellij.openapi.roots.libraries.LibraryKind
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider
import com.intellij.openapi.vfs.VirtualFile

class ValkyrieLibraryPresentation() : LibraryPresentationProvider<ValkyrieLibraryProperty>(ValkyrieLibraryType.kind) {
    override fun detect(classesRoots: MutableList<VirtualFile>): ValkyrieLibraryProperty? {
        return ValkyrieLibraryProperty()
    }
}


