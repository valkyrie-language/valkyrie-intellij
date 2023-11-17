package valkyrie.ide.actions

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.ast.node.ValkyrieFunctionDeclareNode
import valkyrie.ast.node.ValkyrieParameterItemNode
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class InferFunctionParameterType : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    val context: ValkyrieFunctionDeclareNode
    val element: ValkyrieParameterItemNode

    constructor(element: ValkyrieParameterItemNode, context: ValkyrieFunctionDeclareNode) : super(element) {
        this.context = context
        this.element = element
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
    }


    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {

    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Untyped
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.infer.function.parameter")
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }
}

