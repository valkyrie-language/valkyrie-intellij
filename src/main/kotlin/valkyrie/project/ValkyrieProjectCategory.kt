package valkyrie.project

import com.intellij.ide.highlighter.ModuleFileType
import com.intellij.ide.projectWizard.ProjectCategory
import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.resolveFromRootOrRelative
import valkyrie.project.legion.LegionWorkspaceBuilder
import java.io.File
import javax.swing.Icon

class ValkyrieProjectCategory : ProjectCategory() {
    override fun createModuleBuilder(): ModuleBuilder {
        return LegionWorkspaceBuilder()
    }

    override fun getDisplayName(): String {
        return "Valkyrie Project Category"
    }

    override fun getGroupName(): String {
        return "projectCategory.getGroupName()"
    }

    override fun getDescription(): String {
        return "Valkyrie Category"
    }

    override fun getIcon(): Icon {
        return super.getIcon()
    }
}
