package valkyrie.ide.actions

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieParameterItem
import valkyrie.psi.node.ValkyrieParameterItemNode
import javax.swing.Icon

class InferFunctionParameterType : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    val element: ValkyrieParameterItemNode

    constructor(element: ValkyrieParameterItem) : super(element) {
        this.element = element as ValkyrieParameterItemNode
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
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

