package valkyrie.project.legion

import com.intellij.ide.JavaUiBundle
import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectImportProvider
import com.intellij.ui.dsl.builder.panel
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon
import javax.swing.JComponent

class LegionProvider : ProjectImportProvider {
    constructor() : super(LegionImporter())

    override fun canCreateNewProject(): Boolean {
        return true
    }

    override fun canImportModule(): Boolean {
        return true
    }

    override fun canImportFromFile(file: VirtualFile?): Boolean {
        return false
    }

    override fun canImport(fileOrDirectory: VirtualFile, project: Project?): Boolean {
        return super.canImport(fileOrDirectory, project)
    }


    override fun getName(): String {
        return super.getName()
    }

    override fun createSteps(context: WizardContext?): Array<ModuleWizardStep> {
        return arrayOf(ConfigPath())
    }

    override fun getFileSample(): String? {
        return JavaUiBundle.message("intellij.idea.module.file.iml")
    }

    override fun getPathToBeImported(file: VirtualFile?): String {
        return super.getPathToBeImported(file)
    }
}

private class ConfigPath : ModuleWizardStep() {
    override fun getComponent(): JComponent {
        return panel {
            row("ValkyrieLegionImportStep") {
                text("???")
            }
        }
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return panel {
            row("ValkyrieLegionImportStep") {
                text("???")
            }
        }
    }

    override fun getIcon(): Icon? {
        return ValkyrieIconProvider.Instance.Enumeration
    }

    override fun getName(): String {
        return super.getName()
    }

    override fun getHelpId(): String {
        return "super.getHelpId()"
    }

    override fun updateDataModel() {

    }
}