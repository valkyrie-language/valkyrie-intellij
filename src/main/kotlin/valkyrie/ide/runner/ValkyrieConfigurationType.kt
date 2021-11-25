package valkyrie.ide.runner

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieConfigurationType : ConfigurationType {
    override fun getDisplayName(): String {
        return ValkyrieBundle.message("running.group.name")
    }

    override fun getConfigurationTypeDescription(): String {
        return "ValkyrieRunningConfigType.getConfigurationTypeDescription"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Valkyrie
    }

    override fun getId(): String {
        return "valkyrie.script"
    }

    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(ValkyrieConfigurationFactory(this))
    }
}