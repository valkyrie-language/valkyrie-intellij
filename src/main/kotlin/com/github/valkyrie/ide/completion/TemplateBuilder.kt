package com.github.valkyrie.ide.completion

import com.github.valkyrie.language.psi.startOffset
import com.intellij.codeInsight.template.TemplateBuilderImpl
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement


class TemplateBuilder(val element: PsiElement, val editor: Editor) : TemplateBuilderImpl(element) {
    private val templateManager: TemplateManager get() = TemplateManager.getInstance(element.project)
    fun runTemplate(key: String, text: String) {
        val template = templateManager.createTemplate(key, "valkyrie", text)
        editor.caretModel.moveToOffset(element.startOffset)
        templateManager.runTemplate(editor, initTemplate(template))
    }

    fun runInline(key: String, text: String) {
        val template = templateManager.createTemplate(key, "valkyrie", text)
        editor.caretModel.moveToOffset(element.startOffset)
        templateManager.runTemplate(editor, initInlineTemplate(template))
    }
}
