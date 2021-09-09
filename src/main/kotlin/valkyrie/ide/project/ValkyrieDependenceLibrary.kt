package valkyrie.ide.project

import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.VirtualFile

// ImmutableSyntheticLibrary
class ValkyrieDependenceLibrary(val id: String) : SyntheticLibrary() {
    override fun equals(other: Any?): Boolean {
        return id == (other as ValkyrieDependenceLibrary).id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun getSourceRoots(): MutableCollection<VirtualFile> {
        return mutableListOf()
    }


}