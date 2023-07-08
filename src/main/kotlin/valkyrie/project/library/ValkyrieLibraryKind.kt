package valkyrie.project.library

import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.roots.libraries.PersistentLibraryKind
import valkyrie.language.ValkyrieLanguage

class ValkyrieLibraryKind : PersistentLibraryKind<ValkyrieLibraryProperty>(ValkyrieLanguage.libiaryID) {
    override fun createDefaultProperties(): ValkyrieLibraryProperty {
        return ValkyrieLibraryProperty()
    }

    override fun getAdditionalRootTypes(): Array<OrderRootType> {
        return super.getAdditionalRootTypes()
    }
}