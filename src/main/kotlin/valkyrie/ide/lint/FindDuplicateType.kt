package valkyrie.ide.lint

import com.intellij.codeInsight.daemon.impl.actions.IntentionActionWithFixAllOption
import com.intellij.codeInsight.intention.CustomizableIntentionAction
import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.intention.IntentionActionWithOptions
import com.intellij.codeInspection.*
import com.intellij.codeInspection.actions.RunInspectionIntention
import com.intellij.codeInspection.ex.DisableInspectionToolAction
import com.intellij.codeInspection.ex.EditInspectionToolsSettingsAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.HintedPsiElementVisitor
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import valkyrie.ide.actions.ast_transform.DeleteThis
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareSingleton
import valkyrie.psi.node.ValkyrieVisitor
import javax.swing.Icon

class FindDuplicateType : LocalInspectionTool() {
    override fun getShortName(): String {
        return super.getShortName()
    }

    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor> {
        return arrayOf()
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean, session: LocalInspectionToolSession): PsiElementVisitor {
        return super.buildVisitor(holder, isOnTheFly, session)
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return AA(holder)
    }
}

private class AA(val holder: ProblemsHolder) : ValkyrieVisitor(), HintedPsiElementVisitor {
    override fun visitDeclareSingleton(o: ValkyrieDeclareSingleton) {
        holder.registerProblem(o, "holder.registerProblem", FFFix(), DeleteThis(o))
    }

    override fun getHintPsiElements(): MutableList<Class<*>> {
        return mutableListOf()
    }

}

class FFFix : LocalQuickFix, IntentionActionWithFixAllOption, CustomizableIntentionAction, Iconable {
    override fun isShowSubmenu(): Boolean {
        return true
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "FFFix.getFamilyName"
    }

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {

    }

    override fun getText(): String {
        return "FFFix.getText"
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {

    }


    override fun getOptions(): MutableList<IntentionAction> {
        return mutableListOf(
            KA(),
            EditInspectionToolsSettingsAction(displayKey),
            RunInspectionIntention(displayKey),
            DisableInspectionToolAction(displayKey)
        )
    }

    override fun getCombiningPolicy(): IntentionActionWithOptions.CombiningPolicy {
        return IntentionActionWithOptions.CombiningPolicy.IntentionOptionsOnly
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }
}

class KA : LocalQuickFix, IntentionAction, Iconable {
    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "KA.getFamilyName"
    }

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {

    }

    override fun getText(): String {
        return "KA.getText"
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {

    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Singleton
    }
}