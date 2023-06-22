package valkyrie.project.artifact

import com.intellij.packaging.artifacts.ArtifactProperties
import com.intellij.packaging.artifacts.ArtifactPropertiesProvider
import com.intellij.packaging.artifacts.ArtifactType
import com.intellij.packaging.ui.ArtifactEditorContext
import com.intellij.packaging.ui.ArtifactPropertiesEditor
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class artifactPropertiesProvider : ArtifactPropertiesProvider("artifactPropertiesProvider") {
    override fun createProperties(artifactType: ArtifactType): ArtifactProperties<*> {
        return VA()
    }

    override fun isAvailableFor(type: ArtifactType): Boolean {
        return type is ValkyrieArtifactType

    }
}

class VA : ArtifactProperties<AData>() {
    override fun getState(): AData {
        return AData()
    }

    override fun createEditor(context: ArtifactEditorContext): ArtifactPropertiesEditor {
        return AE(context)
    }

    override fun loadState(state: AData) {

    }

    override fun initializeComponent() {

    }


}

class AData {
    val id: String = ""
}

class AE(context: ArtifactEditorContext) : ArtifactPropertiesEditor() {
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