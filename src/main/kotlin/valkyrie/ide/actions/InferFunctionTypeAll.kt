package valkyrie.ide.actions

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareFunction
import valkyrie.psi.node.ValkyrieDeclareFunctionNode
import javax.swing.Icon

class InferFunctionTypeAll : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    val element: ValkyrieDeclareFunctionNode

    constructor(element: ValkyrieDeclareFunction) : super(element) {
        this.element = element as ValkyrieDeclareFunctionNode
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
    }


    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {

    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }
    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.MultipleType
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.infer.function.all")
    }
}


