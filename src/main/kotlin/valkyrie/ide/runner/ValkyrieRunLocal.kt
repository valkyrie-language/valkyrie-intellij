package valkyrie.ide.runner

import com.intellij.execution.ExecutionResult
import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.panel
import com.intellij.xdebugger.XDebugProcess
import com.intellij.xdebugger.XDebugSession
import org.jetbrains.debugger.DebuggableRunConfiguration
import valkyrie.language.file.ValkyrieIconProvider
import java.net.InetSocketAddress
import javax.swing.Icon
import javax.swing.JComponent

class ValkyrieRunLocal(project: Project, factory: ValkyrieConfigurationFactory) : DebuggableRunConfiguration {
    private val myProject: Project = project
    private val myFactory: ValkyrieConfigurationFactory = factory
    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return ValkyrieRunningState(environment)
    }

    override fun getName(): String {
        return "ValkyrieRunningConfig.getName"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.FILE
    }

    override fun createDebugProcess(
        socketAddress: InetSocketAddress,
        session: XDebugSession,
        executionResult: ExecutionResult?,
        environment: ExecutionEnvironment,
    ): XDebugProcess {
        TODO("Not yet implemented")
    }

    override fun clone(): RunConfiguration {
        return this
    }

    override fun setName(name: String?) {

    }

    override fun getProject(): Project {
        return myProject
    }

    override fun getFactory(): ConfigurationFactory {
        return myFactory
    }

    override fun getConfigurationEditor(): SettingsEditor<out ValkyrieRunLocal> {
        return RunningConfigEditor()
    }
}

private class RunningConfigEditor() : SettingsEditor<ValkyrieRunLocal>() {
    override fun resetEditorFrom(s: ValkyrieRunLocal) {

    }

    override fun applyEditorTo(s: ValkyrieRunLocal) {

    }

    override fun createEditor(): JComponent {
        return panel {
            row("Name:") {
                textField()
            }
        }
    }

}