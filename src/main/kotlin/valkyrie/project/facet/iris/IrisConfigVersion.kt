package valkyrie.project.facet.iris

import com.intellij.facet.ui.FacetEditorTab
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class IrisConfigVersion : FacetEditorTab() {
    override fun createComponent(): JComponent {
        return panel {
            row("IrisConfigVersion") {
                text("???")
            }
        }
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun getDisplayName(): String {
        return "IrisConfigVersion"
    }

    override fun getHelpTopic(): String? {
        return "getHelpTopic"
    }
}