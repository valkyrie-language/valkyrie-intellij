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
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.replaceLeaf
import javax.swing.Icon

class ReplaceGenericBrackets : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    private var left: PsiElement
    private var right: PsiElement
    private var jointer: PsiElement?

    constructor(left: PsiElement, right: PsiElement, join: PsiElement? = null) : super(left) {
        this.left = left
        this.right = right
        this.jointer = join
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.replace.generic.brackets.name")
    }

    fun getDescription(): String {
        return ValkyrieBundle.message("action.replace.generic.brackets.help")
    }

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        jointer?.delete()
        left.replaceLeaf(ValkyrieTypes.GENERIC_L, "⟨")
        right.replaceLeaf(ValkyrieTypes.GENERIC_R, "⟩")
    }

    override fun getIcon(flags: Int): Icon {
        return AllIcons.Gutter.SuggestedRefactoringBulb
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }

    override fun availableInBatchMode(): Boolean {
        return true
    }


}