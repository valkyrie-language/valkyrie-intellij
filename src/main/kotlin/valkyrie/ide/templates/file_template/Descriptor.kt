package valkyrie.ide.templates.file_template

import com.intellij.icons.AllIcons
import com.intellij.ide.fileTemplates.FileTemplateDescriptor
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor
import javax.swing.Icon

class Descriptor : FileTemplateGroupDescriptor("aaa", null) {
    override fun getTemplates(): MutableList<FileTemplateDescriptor> {
        return super.getTemplates()
    }

    override fun getIcon(): Icon {
        return AllIcons.Nodes.Type
    }

    override fun getTitle(): String {
        return super.getTitle()
    }
}