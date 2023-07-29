package valkyrie.ide.lint

import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInsight.daemon.HighlightDisplayKey
import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.InspectionsBundle
import com.intellij.codeInspection.ex.modifyAndCommitProjectProfile
import com.intellij.icons.AllIcons
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.profile.codeInspection.InspectionProjectProfileManager
import com.intellij.psi.PsiFile
import javax.swing.Icon

class ValkyrieInspectionSuppose : IntentionAction, PriorityAction, Iconable {
    private val _name: String

    constructor(shortName: String) : super() {
        this._name = shortName
    }

    override fun getIcon(flags: Int): Icon {
        return AllIcons.Actions.Cancel
    }

    override fun getFamilyName(): String {
        return InspectionsBundle.message("disable.inspection.action.name")
    }

    override fun getText(): String {
        return familyName
    }

//    override fun getName(): String {
//        return familyName
//    }

    override fun startInWriteAction(): Boolean {
        return false
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile): Boolean {
        val profile = InspectionProjectProfileManager.getInstance(project).currentProfile
        val usedSeverity = profile.getErrorLevel(HighlightDisplayKey.find(_name)!!, file).severity
        return usedSeverity > HighlightSeverity.INFORMATION
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        modifyAndCommitProjectProfile(project) {
            val tools = it.getToolsOrNull(_name, project)
            if (tools != null) {
                tools.level = HighlightDisplayLevel.DO_NOT_SHOW
            }
        }
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.BOTTOM
    }

//    override fun applyFix(project: Project, file: PsiFile, editor: Editor?) {
//        modifyAndCommitProjectProfile(project) {
//            val tools = it.getToolsOrNull(_name, project)
//            if (tools != null) {
//                tools.level = HighlightDisplayLevel.DO_NOT_SHOW
//            }
//        }
//    }
}