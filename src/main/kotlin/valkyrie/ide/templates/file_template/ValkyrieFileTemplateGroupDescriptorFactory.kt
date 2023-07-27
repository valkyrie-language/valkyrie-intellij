package valkyrie.ide.templates.file_template

import com.intellij.ide.fileTemplates.FileTemplateDescriptor
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory

class ValkyrieFileTemplateGroupDescriptorFactory : FileTemplateGroupDescriptorFactory {
    override fun getFileTemplatesDescriptor(): FileTemplateGroupDescriptor {
        return FileTemplateGroupDescriptor(
            "aaa",
            null,
            FileTemplateDescriptor("bb", null),
            FileTemplateDescriptor("cc", null)
        )
    }
}
