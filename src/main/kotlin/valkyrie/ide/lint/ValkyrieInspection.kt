package valkyrie.ide.lint

import com.intellij.analysis.AnalysisScope
import com.intellij.codeInsight.daemon.HighlightDisplayKey
import com.intellij.codeInsight.intention.CustomizableIntentionAction
import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.intention.IntentionActionWithOptions
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.actions.RunInspectionIntention
import com.intellij.codeInspection.ex.EditInspectionToolsSettingsAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

@Suppress("StatefulEp")
abstract class ValkyrieInspection : LocalQuickFix, IntentionActionWithOptions, CustomizableIntentionAction, Iconable {
    private val _icon: Icon
    private val key: HighlightDisplayKey?
        get() = HighlightDisplayKey.findById(tool.id)
    protected val tool: LocalInspectionTool
    protected val psi: PsiElement

    constructor(tool: LocalInspectionTool, icon: Icon, psi: PsiElement) {
        this.tool = tool


        this._icon = icon
        this.psi = psi
    }

    override fun isShowIcon(): Boolean {
        return true
    }

    override fun getIcon(flags: Int): Icon {
        return _icon
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "FFFix.getFamilyName"
    }

    override fun getText(): String {
        return ValkyrieBundle.message("${tool.id}.fix")
    }

    override fun getTooltipText(): String {
        return "super.getTooltipText()"
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun getOptions(): MutableList<IntentionAction> {
        val output = mutableListOf<IntentionAction>()
        if (key != null) {
            output.add(EditInspectionToolsSettingsAction(key!!))
            output.add(RunInspectionIntention(key!!))
            output.add(ValkyrieInspectionSuppose(tool.shortName))
        }
        output.add(ValkyrieInspectionBatch(_icon, tool.displayName, AnalysisScope(psi.project)))
        val module = ModuleUtilCore.findModuleForFile(psi.containingFile);
        if (module != null) {
            output.add(ValkyrieInspectionBatch(_icon, tool.displayName, AnalysisScope(module)))
        }
        output.add(ValkyrieInspectionBatch(_icon, tool.displayName, AnalysisScope(psi.containingFile.containingDirectory)))
        output.add(ValkyrieInspectionBatch(_icon, tool.displayName, AnalysisScope(psi.containingFile)))
        return output
    }

    override fun getCombiningPolicy(): IntentionActionWithOptions.CombiningPolicy {
        return IntentionActionWithOptions.CombiningPolicy.IntentionOptionsOnly
    }
}