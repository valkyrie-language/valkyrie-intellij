package valkyrie.ide.project.library

import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.PersistentLibraryKind

class ValkyrieLibraryKind : PersistentLibraryKind<ValkyrieLibraryProperty>(ValkyrieLibraryType.ID) {
    override fun createDefaultProperties(): ValkyrieLibraryProperty {
        return ValkyrieLibraryProperty()
    }

    override fun getAdditionalRootTypes(): Array<OrderRootType> {
        return super.getAdditionalRootTypes()
    }
}