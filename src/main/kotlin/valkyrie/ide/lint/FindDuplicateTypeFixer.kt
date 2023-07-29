package valkyrie.ide.lint

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import javax.swing.Icon

class FindDuplicateTypeFixer : ValkyrieInspection {
    private val deletes: Array<PsiElement>

    constructor(tool: LocalInspectionTool, icon: Icon, except: PsiElement, deletes: MutableList<PsiElement>) : super(tool, icon, except) {
        deletes.remove(except)
        this.deletes = deletes.toTypedArray()
    }

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {

    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        for (psi in deletes) {
            psi.delete()
        }
    }
}