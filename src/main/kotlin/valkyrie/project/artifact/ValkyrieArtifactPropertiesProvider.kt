package valkyrie.project.artifact

import com.intellij.packaging.artifacts.ArtifactProperties
import com.intellij.packaging.artifacts.ArtifactPropertiesProvider
import com.intellij.packaging.artifacts.ArtifactType

class ValkyrieArtifactPropertiesProvider : ArtifactPropertiesProvider("artifactPropertiesProvider") {
    override fun createProperties(artifactType: ArtifactType): ArtifactProperties<*> {
        return ValkyrieArtifactProperties()
    }

    override fun isAvailableFor(type: ArtifactType): Boolean {
        return type is ValkyrieArtifactType

    }
}

