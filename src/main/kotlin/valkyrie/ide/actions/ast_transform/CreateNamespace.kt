package valkyrie.ide.actions.ast_transform

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.CheckUtil
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class CreateNamespace(private val element: ValkyrieFileNode) : LocalQuickFixAndIntentionActionOnPsiElement(element), PriorityAction, Iconable {
    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "getFamilyName"
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.create.namespace.name")
    }

    fun getDescription(): String {
        return ValkyrieBundle.message("action.create.namespace.help")
    }

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        CheckUtil.checkWritable(element)
        editor!!.document.insertString(0, "namespace std.create.test;\n")
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.NAMESPACE
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }
}