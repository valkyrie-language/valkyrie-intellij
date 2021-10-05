package valkyrie.ide.project

import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

enum class ValkyrieLibraryType {
    Core, LIBRARY, NAMESPACE;

    fun getIcon(): Icon {
        return when (this) {
            Core -> ValkyrieIconProvider.FILE
            LIBRARY -> ValkyrieIconProvider.NAMESPACE
            NAMESPACE -> ValkyrieIconProvider.NAMESPACE
        }
    }
}

