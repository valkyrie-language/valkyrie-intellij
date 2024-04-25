package valkyrie.project.artifact

import com.intellij.packaging.artifacts.ArtifactProperties
import com.intellij.packaging.ui.ArtifactEditorContext
import com.intellij.packaging.ui.ArtifactPropertiesEditor

class ValkyrieArtifactProperties : ArtifactProperties<ValkyrieArtifactState>() {
    override fun getState(): ValkyrieArtifactState {
        return ValkyrieArtifactState()
    }

    override fun createEditor(context: ArtifactEditorContext): ArtifactPropertiesEditor {
        return ValkyrieArtifactEditor(context)
    }

    override fun loadState(state: ValkyrieArtifactState) {

    }

    override fun initializeComponent() {

    }


}

