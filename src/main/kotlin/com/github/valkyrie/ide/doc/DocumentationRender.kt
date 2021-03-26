package com.github.valkyrie.ide.doc

import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.ui.ColorUtil


class DocumentationRender(var element: PsiElement) {
    private val doc = StringBuilder()
    fun onHover(): String {
        when (element) {
            is ValkyrieTraitStatementNode -> build(element as ValkyrieTraitStatementNode)
            is ValkyrieClassStatementNode -> build(element as ValkyrieClassStatementNode)
            else -> "onHover: ${element.text}"
        }
        return doc.toString()
    }

    private fun build(element: ValkyrieTraitStatementNode) {
        append(ValkyrieHighlightColor.KEYWORD, "crate ")
        append("std::charset\n")
        append(ValkyrieHighlightColor.KEYWORD, "public ")
        append(ValkyrieHighlightColor.KEYWORD, "native ")
        append(ValkyrieHighlightColor.KEYWORD, "trait ")
        append(ValkyrieHighlightColor.SYM_TRAIT, element.name)
    }

    private fun build(element: ValkyrieClassStatementNode) {
        append(ValkyrieHighlightColor.KEYWORD, "crate ")
        append("std::charset\n")
        append(ValkyrieHighlightColor.KEYWORD, "public ")
        append(ValkyrieHighlightColor.KEYWORD, "native ")
        append(ValkyrieHighlightColor.KEYWORD, "class ")
        append(ValkyrieHighlightColor.SYM_CLASS, element.name)
    }

    private fun append(text: String) {
        doc.append("<span>${text}</span>")
    }

    private fun append(key: ValkyrieHighlightColor, text: String) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(key.textAttributesKey)
        val color = ColorUtil.toHtmlColor(attr.foregroundColor)
        doc.append("<span style='color:${color}'>${text}</span>")
    }
}