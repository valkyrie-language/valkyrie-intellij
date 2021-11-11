package valkyrie.ide.runner

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import javax.swing.Icon

class ValkyrieRunningConfig: RunConfiguration {
    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        TODO("Not yet implemented")
    }

    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun getIcon(): Icon? {
        TODO("Not yet implemented")
    }

    override fun clone(): RunConfiguration {
        TODO("Not yet implemented")
    }

    override fun getFactory(): ConfigurationFactory? {
        TODO("Not yet implemented")
    }

    override fun setName(name: String?) {
        TODO("Not yet implemented")
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        TODO("Not yet implemented")
    }

    override fun getProject(): Project {
        TODO("Not yet implemented")
    }

}