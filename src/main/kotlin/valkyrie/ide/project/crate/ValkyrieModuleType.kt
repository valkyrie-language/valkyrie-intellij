package valkyrie.ide.project.crate

import com.intellij.openapi.module.ModuleType
import valkyrie.ide.project.ValkyrieCreatePackage
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon


private const val ID = "VALKYRIE_MODULE_TYPE"

class ValkyrieModuleType : ModuleType<ValkyrieCreatePackage>(ID) {
    override fun createModuleBuilder(): ValkyrieCreatePackage {
        return ValkyrieCreatePackage()
    }

    override fun getName(): String {
        return "Valkyrie";
    }

    override fun getDescription(): String {
        return "ValkyrieModuleType getDescription";
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ValkyrieIconProvider.Valkyrie
    }
}