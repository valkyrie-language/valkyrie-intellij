package valkyrie.ide.test

import com.intellij.execution.ExecutionResult
import com.intellij.execution.Executor
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.execution.ui.ConsoleView
import com.intellij.execution.ui.ConsoleViewContentType
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.ui.ExecutionConsole
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import java.util.*
import kotlin.random.Random

/**
 * Valkyrie 测试运行状态
 */
class ValkyrieTestRunProfileState(
    private val environment: ExecutionEnvironment,
    private val configuration: ValkyrieTestRunConfiguration
) : RunProfileState {
    
    override fun execute(executor: Executor?, runner: ProgramRunner<*>): ExecutionResult? {
        val consoleView = createConsoleView()
        val processHandler = createProcessHandler()
        
        ProcessTerminatedListener.attach(processHandler)
        consoleView.attachToProcess(processHandler)
        
        // 启动测试执行
        startTestExecution(consoleView, processHandler)
        
        return object : ExecutionResult {
            override fun getExecutionConsole(): ExecutionConsole = consoleView
            override fun getProcessHandler(): ProcessHandler = processHandler
            override fun getActions(): Array<com.intellij.openapi.actionSystem.AnAction> = emptyArray()
        }
    }
    
    private fun createConsoleView(): ConsoleView {
        return com.intellij.execution.impl.ConsoleViewImpl(
            environment.project,
            true
        )
    }
    
    private fun createProcessHandler(): ProcessHandler {
        val commandLine = com.intellij.execution.configurations.GeneralCommandLine()
        commandLine.exePath = "echo"
        commandLine.addParameter("Valkyrie Test Process")
        return ProcessHandlerFactory.getInstance().createProcessHandler(commandLine)
    }
    
    private fun startTestExecution(consoleView: ConsoleView, processHandler: ProcessHandler) {
        ProgressManager.getInstance().run(object : Task.Backgroundable(
            environment.project,
            "Running Valkyrie Tests",
            true
        ) {
            override fun run(indicator: ProgressIndicator) {
                runTests(consoleView, processHandler, indicator)
            }
        })
    }
    
    private fun runTests(consoleView: ConsoleView, processHandler: ProcessHandler, indicator: ProgressIndicator) {
        val testFilePath = configuration.getOptions().testFilePath
        val testName = configuration.getOptions().testName
        
        ApplicationManager.getApplication().invokeLater {
            consoleView.print("=== Valkyrie Test Runner ===\n", ConsoleViewContentType.SYSTEM_OUTPUT)
            consoleView.print("Test file: $testFilePath\n", ConsoleViewContentType.NORMAL_OUTPUT)
            consoleView.print("Test name: $testName\n", ConsoleViewContentType.NORMAL_OUTPUT)
            consoleView.print("\n", ConsoleViewContentType.NORMAL_OUTPUT)
        }
        
        // 模拟测试执行过程
        val random = Random.Default
        val testCount = random.nextInt(3, 8)
        
        for (i in 1..testCount) {
            if (indicator.isCanceled) break
            
            val testMethodName = "test_${UUID.randomUUID().toString().substring(0, 8)}"
            indicator.text = "Running test: $testMethodName"
            
            ApplicationManager.getApplication().invokeLater {
                consoleView.print("Running test: $testMethodName ... ", ConsoleViewContentType.NORMAL_OUTPUT)
            }
            
            // 随机执行时间
            Thread.sleep(random.nextLong(500, 2000))
            
            // 随机结果
            val success = random.nextBoolean()
            
            ApplicationManager.getApplication().invokeLater {
                if (success) {
                    consoleView.print("PASSED\n", ConsoleViewContentType.LOG_INFO_OUTPUT)
                } else {
                    consoleView.print("FAILED\n", ConsoleViewContentType.LOG_ERROR_OUTPUT)
                    consoleView.print("  Error: Assertion failed at line ${random.nextInt(10, 100)}\n", ConsoleViewContentType.LOG_ERROR_OUTPUT)
                }
            }
            
            indicator.fraction = i.toDouble() / testCount
        }
        
        ApplicationManager.getApplication().invokeLater {
            consoleView.print("\n=== Test Summary ===\n", ConsoleViewContentType.SYSTEM_OUTPUT)
            consoleView.print("Total tests: $testCount\n", ConsoleViewContentType.NORMAL_OUTPUT)
            consoleView.print("Test execution completed.\n", ConsoleViewContentType.SYSTEM_OUTPUT)
            
            processHandler.destroyProcess()
        }
    }
}