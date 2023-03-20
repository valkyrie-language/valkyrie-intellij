package valkyrie.ide.project.`package`

import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

enum class ValkyrieLibraryType {
    Core, LIBRARY, NAMESPACE;

    fun getIcon(): Icon {
        return when (this) {
            Core -> ValkyrieIconProvider.Instance.Valkyrie
            LIBRARY -> ValkyrieIconProvider.Instance.NAMESPACE
            NAMESPACE -> ValkyrieIconProvider.Instance.NAMESPACE
        }
    }
}

