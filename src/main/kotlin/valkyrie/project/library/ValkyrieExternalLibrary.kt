package valkyrie.project.library

import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie 外部库实现
 */
class ValkyrieExternalLibrary(
    private val name: String,
    private val sourceRoots: Collection<VirtualFile>
) : SyntheticLibrary(), ItemPresentation {

    override fun getSourceRoots(): Collection<VirtualFile> = sourceRoots

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ValkyrieExternalLibrary) return false
        return name == other.name && sourceRoots == other.sourceRoots
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31 + sourceRoots.hashCode()
    }

    // ItemPresentation 实现
    override fun getPresentableText(): String = name

    override fun getLocationString(): String? = null

    override fun getIcon(unused: Boolean): Icon = ValkyrieIcons.PACKAGES
}