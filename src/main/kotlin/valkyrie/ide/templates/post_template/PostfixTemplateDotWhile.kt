package valkyrie.ide.templates.post_template

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

class PostfixTemplateDotWhile : PostfixTemplateSlotSelector {
    constructor() : super("while", ".while")
    override fun expandExpression(element: PsiElement, editor: Editor) {
        expandExpressionSlot(element, editor, conditionTemplate(element))
    }
}