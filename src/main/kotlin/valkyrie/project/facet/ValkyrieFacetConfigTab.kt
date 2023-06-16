package valkyrie.project.facet

import com.intellij.facet.ui.FacetEditorTab
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieFacetConfigTab : FacetEditorTab() {
    override fun createComponent(): JComponent {
        return panel {
            row("ValkyrieFacetConfigTab") {
                text("???")
            }
        }
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun getDisplayName(): String {
        return "FacetEditorTab"
    }

    override fun getHelpTopic(): String? {
        return "getHelpTopic"
    }


}