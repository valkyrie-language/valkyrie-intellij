package valkyrie.project.facet

import com.intellij.ide.util.frameworkSupport.FrameworkRole
import com.intellij.openapi.module.ModuleType
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieModuleType : ModuleType<ValkyrieModuleBuilder> {
    val builder: ValkyrieModuleBuilder

    constructor(builder: ValkyrieModuleBuilder) : super("ValkyrieModuleType") {
        this.builder = builder
    }

    override fun createModuleBuilder(): ValkyrieModuleBuilder {
        return builder
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