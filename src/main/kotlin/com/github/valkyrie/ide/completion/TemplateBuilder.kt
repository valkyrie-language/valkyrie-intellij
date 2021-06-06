package com.github.valkyrie.ide.completion

import com.intellij.codeInsight.template.*
import com.intellij.codeInsight.template.impl.ConstantNode
import com.intellij.codeInsight.template.impl.VariableNode
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement


class TemplateBuilder(val element: PsiElement, val editor: Editor) : TemplateBuilderImpl(element) {
    private val manager: TemplateManager get() = TemplateManager.getInstance(element.project)
    // TODO: cache template
    fun runTemplate(key: String, path: String) {
        val text = object {}.javaClass.getResourceAsStream(path)?.use { it.reader(Charsets.UTF_8).readText() }!!;
        val template = manager.createTemplate(key, "valkyrie", text)
        val token = "[$]([a-zA-Z0-9]+)[$]".toRegex()
        for (variable in token.findAll(text)) {
            val name = variable.groups[1]!!.value
            template.addVariable(name, VariableNode(name, ConstantNode(name)), true)
        }
        manager.startTemplate(editor, template)
    }
}

