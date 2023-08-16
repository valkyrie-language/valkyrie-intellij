package valkyrie.lsp

import com.intellij.openapi.options.Configurable
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieLanguageServerConfiguration : Configurable {
    override fun createComponent(): JComponent {
        return panel {
            row {
                text("ValkyrieLanguageServerConfiguration")
            }
        }
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {

    }

    override fun getDisplayName(): String {
        return "ValkyrieLanguageServerConfiguration"
    }
}