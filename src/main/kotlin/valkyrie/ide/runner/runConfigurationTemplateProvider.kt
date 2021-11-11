package valkyrie.ide.runner

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.impl.RunConfigurationTemplateProvider
import com.intellij.execution.impl.RunManagerImpl
import com.intellij.execution.impl.RunnerAndConfigurationSettingsImpl

class runConfigurationTemplateProvider : RunConfigurationTemplateProvider {
    override fun getRunConfigurationTemplate(factory: ConfigurationFactory, runManager: RunManagerImpl): RunnerAndConfigurationSettingsImpl? {
        return RunnerAndConfigurationSettingsImpl(runManager, null, true)
    }
}