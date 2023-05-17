package valkyrie.ide.runner

import com.intellij.execution.testframework.TestConsoleProperties
import com.intellij.execution.testframework.TestFrameworkRunningModel
import com.intellij.execution.testframework.ToggleModelAction
import com.intellij.execution.testframework.ToggleModelActionProvider
import com.intellij.util.config.BooleanProperty

class VTestActionProvider : ToggleModelActionProvider {
    override fun createToggleModelAction(properties: TestConsoleProperties?): ToggleModelAction {
        return object : ToggleModelAction(
            "ToggleModelAction",
            "ToggleModelAction",
            null,
            properties,
            object : BooleanProperty("BooleanProperty", false) {}) {
            override fun isEnabled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun setModel(model: TestFrameworkRunningModel?) {
                TODO("Not yet implemented")
            }

        }
    }
}