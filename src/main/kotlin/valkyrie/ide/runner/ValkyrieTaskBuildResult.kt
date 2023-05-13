package valkyrie.ide.runner

import com.intellij.build.BuildTreeConsoleView
import com.intellij.execution.ExecutionResult
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.ui.ExecutionConsole
import com.intellij.openapi.actionSystem.AnAction

class ValkyrieTaskBuildResult : ExecutionResult {
    val view: BuildTreeConsoleView

    constructor(view: BuildTreeConsoleView) {
        this.view = view
    }

    override fun getExecutionConsole(): ExecutionConsole {
        return view;
    }

    override fun getActions(): Array<AnAction> {
        return arrayOf()
    }

    override fun getProcessHandler(): ProcessHandler {
        return BuildProcessDaemon(view)
    }
}