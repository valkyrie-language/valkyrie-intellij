package valkyrie.ide.project

import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.VirtualFile


// ImmutableSyntheticLibrary
class ValkyrieDependenceLibrary(val id: String = "") : SyntheticLibrary(), ItemPresentation {
    var version: String = "";
    var path: VirtualFile? = null;
    var kind: ValkyrieLibraryType = ValkyrieLibraryType.LIBRARY;

    override fun getSourceRoots(): MutableCollection<VirtualFile> {
        return mutableListOf()
    }

    override fun getBinaryRoots(): MutableCollection<VirtualFile> {
        return mutableListOf()
    }

    override fun getExcludedRoots(): MutableSet<VirtualFile> {
        return mutableSetOf()
    }

    override fun isShowInExternalLibrariesNode() = true;
    override fun getIcon(unused: Boolean) = kind.getIcon()
    override fun getPresentableText() = id;
    override fun getLocationString(): String? = when {
        version.isEmpty() -> null
        else -> "($version)"
    }

    override fun hashCode() = "$id-$version".hashCode()
    override fun equals(other: Any?) = when (other) {
        is ValkyrieDependenceLibrary -> this.hashCode() == other.hashCode()
        else -> false
    }
}