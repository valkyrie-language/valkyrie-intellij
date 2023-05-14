package valkyrie.ide.templates.post_template

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

class PostfixTemplateDotUntil : PostfixTemplateSlotSelector {
    constructor() : super("until", ".until")

    override fun expandExpression(element: PsiElement, editor: Editor) {
        expandExpressionSlot(element, editor, conditionTemplate(element))
    }
}