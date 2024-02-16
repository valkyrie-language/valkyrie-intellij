package valkyrie.ide.test

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.InvalidDataException
import com.intellij.openapi.util.WriteExternalException
import org.jdom.Element
import valkyrie.language.ValkyrieIcons
import javax.swing.Icon

/**
 * Valkyrie 测试运行配置
 */
class ValkyrieTestRunConfiguration(
    project: Project,
    factory: ConfigurationFactory,
    name: String
) : RunConfigurationBase<ValkyrieTestRunConfigurationOptions>(project, factory, name) {
    
    public override fun getOptions(): ValkyrieTestRunConfigurationOptions {
        return super.getOptions() as ValkyrieTestRunConfigurationOptions
    }
    
    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return ValkyrieTestRunConfigurationEditor()
    }
    
    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return ValkyrieTestRunProfileState(environment, this)
    }
    
    override fun getIcon(): Icon = ValkyrieIcons.TEST_RUN
    
    @Throws(InvalidDataException::class)
    override fun readExternal(element: Element) {
        super.readExternal(element)
        // 读取配置参数
        getOptions().testFilePath = element.getAttributeValue("testFilePath") ?: ""
        getOptions().testName = element.getAttributeValue("testName") ?: ""
    }
    
    @Throws(WriteExternalException::class)
    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        // 保存配置参数
        element.setAttribute("testFilePath", getOptions().testFilePath)
        element.setAttribute("testName", getOptions().testName)
    }
}

/**
 * Valkyrie 测试运行配置选项
 */
class ValkyrieTestRunConfigurationOptions : RunConfigurationOptions() {
    var testFilePath: String = ""
    var testName: String = ""
}