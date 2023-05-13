package valkyrie.ide.post_template

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


    override fun expandExpression(element: PsiElement, editor: Editor) {
        expandExpressionSlot(element, editor, conditionTemplate(element))
    }
}
