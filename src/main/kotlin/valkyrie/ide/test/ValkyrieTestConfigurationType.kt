package valkyrie.ide.test

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie 测试配置类型
 * 用于定义 Valkyrie 语言的测试运行配置
 */
class ValkyrieTestConfigurationType : ConfigurationType {
    
    override fun getDisplayName(): String = "Valkyrie Test"
    
    override fun getConfigurationTypeDescription(): String = "Run Valkyrie tests"
    
    override fun getIcon(): Icon = ValkyrieIcons.TEST
    
    override fun getId(): String = "ValkyrieTestConfiguration"
    
    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(ValkyrieTestConfigurationFactory(this))
    }
    
    companion object {
        const val ID = "ValkyrieTestConfiguration"
    }
}

/**
 * Valkyrie 测试配置工厂
 */
class ValkyrieTestConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    
    override fun getId(): String = "ValkyrieTestConfigurationFactory"
    
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return ValkyrieTestRunConfiguration(project, this, "Valkyrie Test")
    }
    
    override fun getName(): String = "Valkyrie Test"
}