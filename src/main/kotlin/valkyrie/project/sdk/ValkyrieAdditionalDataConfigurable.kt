package valkyrie.project.sdk

import com.intellij.openapi.projectRoots.AdditionalDataConfigurable
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieAdditionalDataConfigurable : AdditionalDataConfigurable {
    override fun createComponent(): JComponent? {
        return panel {
            row("ValkyrieAdditionalDataConfigurable") {
                text("???")
            }
        }
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {

    }

    override fun setSdk(sdk: Sdk?) {

    }
}