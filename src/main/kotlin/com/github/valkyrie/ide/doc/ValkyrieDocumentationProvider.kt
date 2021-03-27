package com.github.valkyrie.ide.doc

import com.github.valkyrie.language.psi.ValkyrieTypes.CLASS
import com.github.valkyrie.language.psi.ValkyrieTypes.DOT
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType


class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { DocumentationRender(it, originalElement).onDetail() }
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        TODO("generateRenderedDoc: $comment")
    }

    // 按住 Ctrl 后悬浮
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { this.generateHoverDoc(it, originalElement) }
    }

    // 悬浮
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String {
        return DocumentationRender(element, originalElement).onHover()
    }

    // 避免实现 PsiReference
    override fun getCustomDocumentationElement(
        // 文件路径
        editor: Editor,
        // 肯定是 ValkyrieFile
        file: PsiFile,
        // ValkyrieTypes, 需要自己找上下文
        contextElement: PsiElement?,
        // 没啥用
        targetOffset: Int,
    ): PsiElement? {
        when (contextElement) {
            is ValkyrieTraitStatementNode -> {
                contextElement.modifierSymbols.textRange.contains(targetOffset)
                return contextElement.modifierSymbols
            }
        }
        return contextElement
    }
}