package valkyrie.ide.actions.ast_transform

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon


class ReplaceLeafText : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    // This element must a psi leaf
    private var leaf: PsiElement
    private var kind: IElementType
    private var target: String

    constructor(leaf: PsiElement, kind: IElementType, target: String) : super(leaf) {
        this.leaf = leaf
        this.kind = kind
        this.target = target
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.replace.text.name", target)
    }


    fun getDescription(): String {
        return ValkyrieBundle.message("action.replace.text.help")
    }

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
//        leaf.replaceLeaf(kind, target)
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