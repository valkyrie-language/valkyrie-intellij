package valkyrie.ide.actions

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareFunctionNode
import javax.swing.Icon

class InferDefineItemType(element: ValkyrieDeclareFunctionNode) : LocalQuickFixAndIntentionActionOnPsiElement(element), PriorityAction,
    Iconable {
    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "getFamilyName"
    }

    override fun getText(): String {
        return "Infer define parameter's type"
    }

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {

    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Namespace
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }
}

