package valkyrie.ide.lint

import com.intellij.analysis.AnalysisBundle
import com.intellij.analysis.AnalysisScope
import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

class ValkyrieInspectionBatch : IntentionAction, PriorityAction, Iconable {
    private val _icon: Icon
    private val _name: String
    private val _scope: AnalysisScope

    constructor(icon: Icon, displayName: String, scope: AnalysisScope) {
        this._icon = icon
        this._name = displayName
        this._scope = scope
    }

    override fun getIcon(flags: Int): Icon {
        return _icon
    }


    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getText(): String {
        return when (_scope.scopeType) {
            AnalysisScope.PROJECT -> ValkyrieBundle.message("intention.batch.project", _name)
            // valkyrie package = java module
            AnalysisScope.MODULE -> ValkyrieBundle.message("intention.batch.package", _name)
            AnalysisScope.DIRECTORY -> ValkyrieBundle.message("intention.batch.directory", _name)
            AnalysisScope.FILE -> ValkyrieBundle.message("intention.batch.file", _name)
            // valkyrie namespace = java package
            else -> ValkyrieBundle.message("intention.batch.namespace", _name)
        }
    }

    override fun getFamilyName(): String {
        return AnalysisBundle.message("intention.family.name.fix.all.problems.like.this")
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {

    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.HIGH
    }
}