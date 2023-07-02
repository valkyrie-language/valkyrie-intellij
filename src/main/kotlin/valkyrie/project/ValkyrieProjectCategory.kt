package valkyrie.project

import com.intellij.ide.projectWizard.ProjectCategory
import com.intellij.ide.util.projectWizard.ModuleBuilder
import valkyrie.project.legion.LegionBuilder
import javax.swing.Icon

class ValkyrieProjectCategory : ProjectCategory() {
    override fun createModuleBuilder(): ModuleBuilder {
        return LegionBuilder()
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
