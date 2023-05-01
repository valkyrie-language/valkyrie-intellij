package valkyrie.ide.live_template

import com.intellij.codeInsight.template.LiveTemplateContext
import com.intellij.codeInsight.template.LiveTemplateContextProvider
import com.intellij.icons.AllIcons
import com.intellij.ide.fileTemplates.DefaultTemplatePropertiesProvider
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory
import com.intellij.psi.PsiDirectory
import java.util.*

class ValkyrieLiveTemplateContext : LiveTemplateContextProvider {
    override fun createContexts(): MutableCollection<LiveTemplateContext> {
        return mutableListOf(ValkyrieLiveTemplateContextAll(), ValkyrieLiveTemplateContextTop())
    }
}

class ValkyrieDefaultTemplatePropertiesProvider : DefaultTemplatePropertiesProvider {
    override fun fillProperties(directory: PsiDirectory, props: Properties) {

    }


}

class ValkyrieFileTemplateGroupDescriptorFactory : FileTemplateGroupDescriptorFactory {
    override fun getFileTemplatesDescriptor(): FileTemplateGroupDescriptor {
        return Descriptor()
    }


}

class Descriptor : FileTemplateGroupDescriptor("aaa", AllIcons.Nodes.Type) {

}