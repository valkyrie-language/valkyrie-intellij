package valkyrie.ide.project

import com.intellij.openapi.module.ModuleType
import valkyrie.ide.file.ValkyrieIconProvider
import javax.swing.Icon


private const val ID = "VALKYRIE_MODULE_TYPE"

class ValkyrieModuleType() : ModuleType<ValkyrieModuleBuilder>(ID) {
    override fun createModuleBuilder(): ValkyrieModuleBuilder {
        return ValkyrieModuleBuilder()
    }

    override fun getName(): String {
        return "ValkyrieModuleType getName";
    }

    override fun getDescription(): String {
        return "ValkyrieModuleType getDescription";
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ValkyrieIconProvider.NAMESPACE
    }


}