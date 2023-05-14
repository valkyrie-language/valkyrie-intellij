package valkyrie.ide.templates.post_template

import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

class PostfixTemplateDotIf : PostfixTemplateSlotSelector {
    constructor() : super(
        "if",
        "if",
        ".if",
        "condition.if",
    )

    override fun getDescription(): String {
        return "super.getDescription()"
    }

    override fun getPresentableName(): String {
        return "super.getPresentableName()"
    }

    override fun isApplicable(context: PsiElement, copyDocument: Document, newOffset: Int): Boolean {
        println("isApplicable: ${context}")
        return super.isApplicable(context, copyDocument, newOffset)
    }


    override fun expandExpression(element: PsiElement, editor: Editor) {
        expandExpressionSlot(element, editor, conditionTemplate(element))
    }
}
