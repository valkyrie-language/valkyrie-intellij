package valkyrie.ide.test

import com.intellij.execution.RunManager
import com.intellij.execution.RunnerAndConfigurationSettings
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.lineMarker.ExecutorAction
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.ValkyrieTestStatement

/**
 * Valkyrie 测试运行支持
 * 提供测试运行的 endpoint 功能
 */
class ValkyrieTestRunLineMarkerProvider : RunLineMarkerContributor() {
    
    override fun getInfo(element: PsiElement): Info? {
        if (element !is ValkyrieTestStatement) return null
        if (!element.isTestFunction() && !element.isTestsBlock()) return null
        
        val actions = createTestActions(element)
        return Info(
            AllIcons.RunConfigurations.TestState.Run,
            { "Run test" },
            *actions
        )
    }
    
    private fun createTestActions(testElement: ValkyrieTestStatement): Array<AnAction> {
        val project = testElement.project
        val runManager = RunManager.getInstance(project)
        
        // 创建测试运行配置
        val configurationFactory = ValkyrieTestConfigurationType().configurationFactories[0]
        val settings = runManager.createConfiguration(
            getTestName(testElement),
            configurationFactory
        )
        
        val configuration = settings.configuration as ValkyrieTestRunConfiguration
        setupTestConfiguration(configuration, testElement)
        
        return ExecutorAction.getActions(0)
    }
    
    private fun setupTestConfiguration(
        configuration: ValkyrieTestRunConfiguration,
        testElement: ValkyrieTestStatement
    ) {
        val options = configuration.getOptions()
        options.testFilePath = testElement.containingFile.virtualFile?.path ?: ""
        options.testName = getTestName(testElement)
    }
    
    private fun getTestName(testElement: ValkyrieTestStatement): String {
        return when {
            testElement.isTestsBlock() -> "Tests Block"
            testElement.isTestFunction() -> "Test Function"
            else -> "Unknown Test"
        }
    }
}

/**
 * 测试运行配置提供者
 */
class ValkyrieTestConfigurationProducer {
    
    companion object {
        fun createTestConfiguration(
            project: Project,
            testElement: ValkyrieTestStatement
        ): RunnerAndConfigurationSettings? {
            val runManager = RunManager.getInstance(project)
            val factory = ValkyrieTestConfigurationType().configurationFactories[0]
            
            val settings = runManager.createConfiguration(
                getTestDisplayName(testElement),
                factory
            )
            
            val configuration = settings.configuration as ValkyrieTestRunConfiguration
            val options = configuration.getOptions()
            options.testFilePath = testElement.containingFile.virtualFile?.path ?: ""
            options.testName = getTestDisplayName(testElement)
            
            return settings
        }
        
        private fun getTestDisplayName(testElement: ValkyrieTestStatement): String {
            return when {
                testElement.isTestsBlock() -> "Tests Block"
                testElement.isTestFunction() -> "Test Function"
                else -> "Unknown Test"
            }
        }
    }
}