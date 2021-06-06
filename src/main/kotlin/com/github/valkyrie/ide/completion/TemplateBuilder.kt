package com.github.valkyrie.ide.completion

import com.intellij.codeInsight.template.Template
import com.intellij.codeInsight.template.TemplateBuilderImpl
import com.intellij.codeInsight.template.TemplateManager
import com.intellij.codeInsight.template.impl.ConstantNode
import com.intellij.codeInsight.template.impl.VariableNode
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

private val TemplateCache: MutableMap<String, Template> = mutableMapOf()

class TemplateBuilder(val element: PsiElement, val editor: Editor) : TemplateBuilderImpl(element) {
    private val manager: TemplateManager get() = TemplateManager.getInstance(element.project)
    fun runFromText(key: String, text: String) {
        if (!TemplateCache.containsKey(key)) {
            createFromText(key, text)
        }
        manager.startTemplate(editor, TemplateCache[key]!!)
    }

    private fun createFromText(key: String, text: String) {
        val template = manager.createTemplate(key, "valkyrie", text)
        val token = "[$]([a-zA-Z0-9]+)[$]".toRegex()
        for (variable in token.findAll(text)) {
            val name = variable.groups[1]!!.value
            template.addVariable(name, VariableNode(name, ConstantNode(name)), true)
        }
        TemplateCache[key] = template
    }
}

