package com.github.valkyrie.ide.doc

import com.intellij.lang.documentation.CodeDocumentationProvider
import com.intellij.openapi.util.Pair
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement


class ValkyrieDocumentationProvider : CodeDocumentationProvider {
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

    override fun findExistingDocComment(contextElement: PsiComment?): PsiComment? {
        TODO("Not yet implemented")
    }

    override fun parseContext(startPoint: PsiElement): Pair<PsiElement, PsiComment>? {
        TODO("Not yet implemented")
    }

    override fun generateDocumentationContentStub(contextComment: PsiComment?): String? {
        TODO("Not yet implemented")
    }
}