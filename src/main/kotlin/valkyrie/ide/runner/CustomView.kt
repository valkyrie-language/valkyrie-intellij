package valkyrie.ide.runner

import com.intellij.build.BuildConsoleView
import com.intellij.build.events.BuildEvent
import com.intellij.execution.filters.Filter
import com.intellij.execution.filters.HyperlinkInfo
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.execution.ui.ExecutionConsole
import com.intellij.openapi.actionSystem.AnAction
import javax.swing.JComponent
import javax.swing.JPanel

class CustomView : ConsoleView, BuildConsoleView, ExecutionConsole {
    override fun dispose() {

    }

    override fun getComponent(): JComponent {
        return JPanel()
    }

    override fun getPreferredFocusableComponent(): JComponent {
        return JPanel()
    }

    override fun print(text: String, contentType: ConsoleViewContentType) {

    }

    override fun clear() {

    }

    override fun scrollTo(offset: Int) {

    }

    override fun attachToProcess(processHandler: ProcessHandler) {

    }

    override fun setOutputPaused(value: Boolean) {

    }

    override fun isOutputPaused(): Boolean {
        return false
    }

    override fun hasDeferredOutput(): Boolean {
        return false
    }

    override fun performWhenNoDeferredOutput(runnable: Runnable) {

    }

    override fun setHelpId(helpId: String) {

    }

    override fun addMessageFilter(filter: Filter) {

    }

    override fun printHyperlink(hyperlinkText: String, info: HyperlinkInfo?) {

    }

    override fun getContentSize(): Int {
        return 0
    }

    override fun canPause(): Boolean {
        return true
    }

    override fun createConsoleActions(): Array<AnAction> {
        return arrayOf()
    }

    override fun allowHeavyFilters() {

    }

    override fun onEvent(buildId: Any, event: BuildEvent) {

    }
}