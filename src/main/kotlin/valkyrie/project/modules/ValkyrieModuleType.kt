package valkyrie.project.modules

import com.intellij.ide.util.frameworkSupport.FrameworkRole
import com.intellij.openapi.module.ModuleType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon


class ValkyrieModuleType : ModuleType<ValkyrieModuleBuilder>(ValkyrieLanguage.moduleID) {
    override fun createModuleBuilder(): ValkyrieModuleBuilder {
        return ValkyrieModuleBuilder()
    }

    override fun getName(): String {
        return "ValkyrieModuleType11"
    }

    override fun getDescription(): String {
        return "ValkyrieModuleType22"
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Effect
    }

    override fun getDefaultAcceptableRole(): FrameworkRole {
        return super.getDefaultAcceptableRole()
    }
}


