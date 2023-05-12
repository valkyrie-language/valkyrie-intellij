package valkyrie.ide.post_template

import com.intellij.codeInsight.template.postfix.templates.editable.EditablePostfixTemplateWithMultipleExpressions
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import valkyrie.ide.live_template.ValkyrieLiveTemplate

class PostfixTemplateDotWhile : EditablePostfixTemplateWithMultipleExpressions<PostConditionType> {
    constructor() : super(
        "c",
        "d",
        "method0",
        ValkyrieLiveTemplate.getTemplate("method0")!!,
        "ddd",
        mutableSetOf(),
        true,
        PostfixTemplateFactory()
    )

    override fun getExpressions(context: PsiElement, document: Document, offset: Int): MutableList<PsiElement> {
        return mutableListOf(context)
    }

    override fun getTopmostExpression(element: PsiElement): PsiElement {
        return element
    }

    override fun getElementToRemove(element: PsiElement): PsiElement {
        return super.getElementToRemove(element)
    }

    override fun getDescription(): String {
        return "super.getDescription()"
    }
}