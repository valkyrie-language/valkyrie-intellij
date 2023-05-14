package valkyrie.ide.post_template

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.ide.templates.post_template.PostfixTemplateSlotSelector

class PostfixTemplateDotWhile : PostfixTemplateSlotSelector {
    constructor() : super(
        "while",
        "while",
        ".while",
        "condition.while",
    )

    override fun expandExpression(element: PsiElement, editor: Editor) {
        expandExpressionSlot(element, editor, conditionTemplate(element))
    }
}