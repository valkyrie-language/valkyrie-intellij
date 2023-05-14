package valkyrie.ide.runner

import com.intellij.build.BuildTextConsoleView
import com.intellij.build.BuildTreeConsoleView
import com.intellij.build.DefaultBuildDescriptor
import com.intellij.execution.ExecutionResult
import com.intellij.execution.Executor
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.execution.testframework.sm.runner.SMTRunnerConsoleProperties

class ValkyrieRunningState : RunProfileState {
    private val environment: ExecutionEnvironment
    private val configuration: SMTRunnerConsoleProperties

    constructor(environment: ExecutionEnvironment, configuration: SMTRunnerConsoleProperties) {
        this.environment = environment
        this.configuration = configuration

    }

    override fun execute(executor: Executor?, runner: ProgramRunner<*>): ExecutionResult? {
        val line = BuildTextConsoleView(environment.project, true, listOf())
        val console = BuildTreeConsoleView(
            environment.project,
            DefaultBuildDescriptor("Valkyrie", "Valkyrie", "Valkyrie", System.currentTimeMillis()),
            line
        )
        return ValkyrieTaskBuildResult(console);
    }
}


