package valkyrie.ide.actions.ast_transform

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

class DeleteThis : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    val todo: MutableList<PsiElement> = mutableListOf()

    constructor(element: PsiElement, vararg rest: PsiElement?) : super(element) {
        this.todo.add(element)
        for (item in rest) {
            if (item != null) {
                this.todo.add(item)
            }
        }
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.delete.node.name")
    }

    fun getDescription(): String {
        return ValkyrieBundle.message("action.delete.node.help")
    }

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        for (item in todo) {
            item.delete()
        }
    }

    override fun getIcon(flags: Int): Icon {
        return AllIcons.CodeWithMe.CwmTerminate
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }
}

