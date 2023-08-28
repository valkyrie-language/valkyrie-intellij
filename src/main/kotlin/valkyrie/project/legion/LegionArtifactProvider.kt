//package valkyrie.project.legion
//
//import com.intellij.openapi.roots.ProjectModelExternalSource
//import com.intellij.packaging.artifacts.*
//import com.intellij.packaging.elements.CompositePackagingElement
//
//class LegionArtifactProvider : ModifiableArtifactModel {
//    override fun addArtifact(
//        name: String,
//        artifactType: ArtifactType,
//        rootElement: CompositePackagingElement<*>?,
//        externalSource: ProjectModelExternalSource?,
//    ): ModifiableArtifact {
//        throw UnsupportedOperationException()
//    }
//
//    override fun removeArtifact(artifact: Artifact) {
//    }
//
//    override fun getOrCreateModifiableArtifact(artifact: Artifact): ModifiableArtifact {
//        throw UnsupportedOperationException()
//    }
//
//    override fun getModifiableCopy(artifact: Artifact): Artifact? {
//        return null
//    }
//
//    override fun addListener(listener: ArtifactListener) {
//    }
//
//    override fun removeListener(listener: ArtifactListener) {
//    }
//
//    override fun isModified(): Boolean {
//        return false
//    }
//
//    override fun commit() {
//    }
//
//    override fun dispose() {
//    }
//
//    override fun getArtifacts(): Array<Artifact> {
//        return arrayOf()
//    }
//
//    override fun findArtifact(name: String): Artifact? {
//        return null
//    }
//
//    override fun getArtifactByOriginal(artifact: Artifact): Artifact {
//        throw UnsupportedOperationException()
//    }
//
//    override fun getOriginalArtifact(artifact: Artifact): Artifact {
//        throw UnsupportedOperationException()
//    }
//
//    override fun getArtifactsByType(type: ArtifactType): Collection<Artifact> {
//        throw UnsupportedOperationException()
//    }
//
//    override fun getAllArtifactsIncludingInvalid(): List<Artifact> {
//        throw UnsupportedOperationException()
//    }
//}