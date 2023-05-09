package valkyrie.ide.post_template

import com.intellij.codeInsight.template.impl.TemplateImpl
import com.intellij.codeInsight.template.postfix.templates.editable.EditablePostfixTemplate
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.util.Function
import valkyrie.ide.live_template.ValkyrieLiveTemplate

class PostfixTemplateDotUntil : EditablePostfixTemplate {
    constructor() : super(
        "until",
        "until",
        "method0",
        ValkyrieLiveTemplate.getTemplate("method0")!!,
        "condition.until",
        PostfixTemplateFactory()
    )

    override fun getExpressions(context: PsiElement, document: Document, offset: Int): MutableList<PsiElement> {
        return mutableListOf(context)
    }


    override fun getElementToRemove(element: PsiElement): PsiElement {
        return super.getElementToRemove(element)
    }

    override fun getDescription(): String {
        return "super.getDescription()"
    }

    override fun getElementRenderer(): Function<PsiElement, String> {
        return super.getElementRenderer()
    }

    override fun getLiveTemplate(): TemplateImpl {
        return super.getLiveTemplate()
    }
}