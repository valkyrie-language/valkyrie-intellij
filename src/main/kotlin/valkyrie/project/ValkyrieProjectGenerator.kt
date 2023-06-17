package valkyrie.project

import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.ide.wizard.NewProjectWizardStep
import com.intellij.ide.wizard.language.LanguageGeneratorNewProjectWizard
import com.intellij.openapi.observable.util.bindBooleanStorage
import com.intellij.openapi.observable.util.bindStorage
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.BottomGap
import com.intellij.ui.dsl.builder.Panel
import com.intellij.ui.dsl.builder.bindSelected
import com.intellij.ui.dsl.builder.bindText
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon


class ValkyrieProjectGenerator : LanguageGeneratorNewProjectWizard {
    override val icon: Icon = ValkyrieIconProvider.Instance.File
    override val name: String = "Valkyrie Project"

    override fun createStep(parent: NewProjectWizardStep): NewProjectWizardStep {
        return A(parent, "NewProjectWizard.ValkyrieState")
    }

    override fun isEnabled(context: WizardContext): Boolean {
        return super.isEnabled(context)
    }


}

private class A(parentStep: NewProjectWizardStep, store: String) : NewProjectWizardStep {
    override val context = parentStep.context
    override val data = parentStep.context
    override val keywords = parentStep.keywords
    override val propertyGraph = parentStep.propertyGraph
    private val mono = propertyGraph.property(true).bindBooleanStorage(store)
    private val path = propertyGraph.property("unknown compiler version").bindStorage(store)

    override fun setupUI(builder: Panel) {
        with(builder) {
            row("row") {
                textField().bindText(path)
            }
            row("") {
                checkBox("Monorepo")
                    .bindSelected(mono)
//                    .whenStateChangedFromUi { logGitChanged() }
            }.bottomGap(BottomGap.SMALL)
        }
    }

    override fun setupProject(project: Project) {
        super.setupProject(project)
    }
}