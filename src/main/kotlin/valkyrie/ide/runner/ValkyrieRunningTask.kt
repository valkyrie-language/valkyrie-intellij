package valkyrie.ide.runner

import com.intellij.execution.Executor
import com.intellij.execution.configuration.PersistentAwareRunConfiguration
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.testframework.sm.runner.SMTRunnerConsoleProperties
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.panel
import org.jdom.Element
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieRunningTask(project: Project, factory: ValkyrieConfigurationFactory) : PersistentAwareRunConfiguration {
    private val myProject: Project = project
    private val myFactory: ValkyrieConfigurationFactory = factory
    private var parallel: Boolean = false
    private var template: Boolean = false
    private var myName: String = "Unnamed1"
    private var myPackage: String = "Unnamed2"
    private var myModule: String = "Unnamed3"

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState {

        val test = SMTRunnerConsoleProperties(this, "aa", executor)

        return ValkyrieRunningState(environment, test)
    }

    override fun getName(): String {
        return myName
    }

    override fun setName(name: String?) {
        if (name != null) {
            myName = name
        }
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }

    override fun clone(): RunConfiguration {
        return this
    }


    override fun getProject(): Project {
        return myProject
    }

    override fun getFactory(): ConfigurationFactory {
        return myFactory
    }

    override fun hideDisabledExecutorButtons(): Boolean {
        return true
    }

    override fun isAllowRunningInParallel(): Boolean {
        return parallel
    }

    override fun setAllowRunningInParallel(value: Boolean) {
        this.parallel = value
    }


    override fun readPersistent(element: Element) {
        myName = element.getAttributeValue("name")
        parallel = element.getAttributeValue("parallel").toBoolean()
//        myPackage = element.getAttributeValue("package")
//        myModule = element.getAttributeValue("module")
    }

    override fun writePersistent(element: Element) {
        element.setAttribute("name", myName)
        element.setAttribute("parallel", parallel.toString())
        element.setAttribute("package", myPackage)
        element.setAttribute("module", myModule)
    }

    override fun setTemplate(isTemplate: Boolean) {
        template = isTemplate
    }

    override fun needsToBeMigrated(): Boolean {
        return true
    }

    override fun checkConfiguration() {
        super.checkConfiguration()
    }

    override fun getConfigurationEditor(): SettingsEditor<out ValkyrieRunningTask> {
        return object : SettingsEditor<ValkyrieRunningTask>() {
            override fun resetEditorFrom(s: ValkyrieRunningTask) {
            }

            override fun applyEditorTo(s: ValkyrieRunningTask) {
            }

            override fun createEditor() = panel {
                row("Package:") {
                    textField()
                }
                row("Module:") {
                    textField()
                }
            }
        }
    }
}