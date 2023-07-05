//package valkyrie.project.artifact
//
//import com.intellij.packaging.artifacts.ArtifactTemplate
//import com.intellij.packaging.artifacts.ArtifactType
//import com.intellij.packaging.elements.CompositePackagingElement
//import com.intellij.packaging.elements.PackagingElementOutputKind
//import com.intellij.packaging.elements.PackagingElementResolvingContext
//import com.intellij.packaging.impl.elements.ArtifactRootElementImpl
//import com.intellij.packaging.ui.PackagingSourceItem
//import valkyrie.language.file.ValkyrieIconProvider
//import javax.swing.Icon
//
//class ValkyrieArtifactType : ArtifactType("artifactType", { "ArtifactType" }) {
//    override fun getIcon(): Icon {
//        return ValkyrieIconProvider.Instance.Valkyrie
//    }
//
//    override fun getDefaultPathFor(kind: PackagingElementOutputKind): String? {
//        return "target/debug/main.wasm"
//    }
//
//    override fun getDefaultPathFor(sourceItem: PackagingSourceItem): String? {
//        return "target/debug/main.wasm"
//    }
//
//    override fun createRootElement(artifactName: String): CompositePackagingElement<*> {
//        return ArtifactRootElementImpl()
//    }
//
//    override fun getPresentableName(): String {
//        return "GetPresentableName1231"
//    }
//
//    override fun getNewArtifactTemplates(context: PackagingElementResolvingContext): MutableList<out ArtifactTemplate> {
//        return super.getNewArtifactTemplates(context)
//    }
//
//
//}
