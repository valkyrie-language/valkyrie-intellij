package valkyrie.ide.runner

import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindowManager
import valkyrie.psi.nodes.ValkyrieTestStatement
import kotlin.random.Random

/**
 * Valkyrie 测试运行器
 * 模拟测试运行，随机生成运行时间、输出内容和结果
 */
object ValkyrieTestRunner {

    private val testOutputs = listOf(
        "Initializing test environment...",
        "Loading test data...",
        "Setting up mock objects...",
        "Running test assertions...",
        "Validating test results...",
        "Checking memory usage...",
        "Verifying performance metrics...",
        "Cleaning up test resources..."
    )

    private val successMessages = listOf(
        "✓ Test passed successfully!",
        "✓ All assertions passed!",
        "✓ Test completed without errors!",
        "✓ Validation successful!"
    )

    private val failureMessages = listOf(
        "✗ Test failed: Assertion error",
        "✗ Test failed: Unexpected exception",
        "✗ Test failed: Timeout exceeded",
        "✗ Test failed: Memory leak detected",
        "✗ Test failed: Performance degradation"
    )

    fun runTest(testStatement: ValkyrieTestStatement) {
        val project = testStatement.project
        val testName = getTestName(testStatement)

        // 在后台线程运行测试
        ApplicationManager.getApplication().executeOnPooledThread {
            runTestInBackground(project, testName)
        }
    }

    private fun runTestInBackground(project: Project, testName: String) {
        val consoleView = getOrCreateConsoleView(project)

        // 开始测试
        printToConsole(consoleView, "\n=== Running Test: $testName ===", ConsoleViewContentType.SYSTEM_OUTPUT)

        // 随机运行时间 0-1 秒
        val runTimeMs = Random.nextLong(0, 1000)

        // 随机输出一些内容
        val outputCount = Random.nextInt(2, 5)
        for (i in 0 until outputCount) {
            Thread.sleep(runTimeMs / outputCount)
            val output = testOutputs.random()
            printToConsole(consoleView, output, ConsoleViewContentType.NORMAL_OUTPUT)
        }

        // 随机成功或失败
        val isSuccess = Random.nextBoolean()
        val resultMessage = if (isSuccess) {
            successMessages.random()
        } else {
            failureMessages.random()
        }

        val contentType = if (isSuccess) {
            ConsoleViewContentType.LOG_INFO_OUTPUT
        } else {
            ConsoleViewContentType.LOG_ERROR_OUTPUT
        }

        printToConsole(consoleView, resultMessage, contentType)
        printToConsole(consoleView, "Test completed in ${runTimeMs}ms\n", ConsoleViewContentType.SYSTEM_OUTPUT)
    }

    private fun getTestName(testStatement: ValkyrieTestStatement): String {
        return when {
            testStatement.isTestsBlock() -> "Tests Block"
            testStatement.isTestFunction() -> "Test Function"
            else -> "Unknown Test"
        }
    }

    private fun getOrCreateConsoleView(project: Project): ConsoleView {
        val toolWindowManager = ToolWindowManager.getInstance(project)
        val toolWindow = toolWindowManager.getToolWindow("Run")
            ?: toolWindowManager.registerToolWindow("Run", true, com.intellij.openapi.wm.ToolWindowAnchor.BOTTOM)

        // 这里简化处理，实际应该创建专门的 ConsoleView
        // 暂时返回一个模拟的 ConsoleView
        return object : ConsoleView {
            override fun print(text: String, contentType: ConsoleViewContentType) {
                // 输出到 IDE 的控制台或日志
                println("[${contentType.name}] $text")
            }

            override fun clear() {}
            override fun scrollTo(offset: Int) {}
            override fun attachToProcess(processHandler: ProcessHandler) {

            }

            override fun setOutputPaused(value: Boolean) {}
            override fun isOutputPaused(): Boolean = false
            override fun hasDeferredOutput(): Boolean = false
            override fun performWhenNoDeferredOutput(runnable: Runnable) {
                runnable.run()
            }

            override fun setHelpId(helpId: String) {}
            override fun addMessageFilter(filter: com.intellij.execution.filters.Filter) {}
            override fun printHyperlink(hyperlinkText: String, info: com.intellij.execution.filters.HyperlinkInfo?) {}
            override fun getContentSize(): Int = 0
            override fun canPause(): Boolean = false
            override fun createConsoleActions(): Array<com.intellij.openapi.actionSystem.AnAction> = emptyArray()
            override fun allowHeavyFilters() {}
            override fun getComponent(): javax.swing.JComponent = javax.swing.JPanel()
            override fun getPreferredFocusableComponent(): javax.swing.JComponent? = null
            override fun dispose() {}
        }
    }

    private fun printToConsole(consoleView: ConsoleView, text: String, contentType: ConsoleViewContentType) {
        ApplicationManager.getApplication().invokeLater {
            consoleView.print("$text\n", contentType)
        }
    }
}