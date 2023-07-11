package valkyrie.project.artifact

import com.intellij.packaging.ui.ArtifactEditorContext
import com.intellij.packaging.ui.ArtifactPropertiesEditor
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ValkyrieArtifactEditor(context: ArtifactEditorContext) : ArtifactPropertiesEditor() {
    override fun createComponent(): JComponent {
        return panel {
            row("artifactPropertiesProvider") {
                textField()
            }
        }
    }

    override fun isModified(): Boolean {
        return false
    }

    override fun apply() {
        TODO("Not yet implemented")
    }

    override fun getTabName(): String {
        return "ArtifactEditorContext"
    }

    override fun getHelpId(): String? {
        return super.getHelpId()
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return super.getPreferredFocusedComponent()
    }
}