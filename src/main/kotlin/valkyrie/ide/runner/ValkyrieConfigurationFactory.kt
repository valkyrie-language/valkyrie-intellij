package valkyrie.ide.runner

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project

class ValkyrieConfigurationFactory(type: ValkyrieConfigurationType) : ConfigurationFactory(type) {
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return ValkyrieRunLocal(project, this)
    }

    override fun getId(): String {
        return type.id;
    }
}