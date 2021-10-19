package valkyrie.ide.project.`package`

import com.intellij.openapi.module.ModuleType
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon


private const val ID = "VALKYRIE_MODULE_TYPE"

class ValkyrieModuleType() : ModuleType<ValkyriePackageCreator>(ID) {
    override fun createModuleBuilder(): ValkyriePackageCreator {
        return ValkyriePackageCreator()
    }

    override fun getName(): String {
        return "Valkyrie";
    }

    override fun getDescription(): String {
        return "ValkyrieModuleType getDescription";
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ValkyrieIconProvider.FILE
    }
}