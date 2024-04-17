package valkyrie.project.facet.asgard

import com.intellij.facet.FacetConfiguration
import com.intellij.facet.ui.FacetEditorContext
import com.intellij.facet.ui.FacetEditorTab
import com.intellij.facet.ui.FacetValidatorsManager
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class AsgardConfig : FacetConfiguration {
    override fun createEditorTabs(editorContext: FacetEditorContext?, validatorsManager: FacetValidatorsManager?): Array<FacetEditorTab> {
        return arrayOf(AsgardConfigVersion())
    }
}

class AsgardConfigVersion : FacetEditorTab() {
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

