package com.github.valkyrie.ide.doc

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType


class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    var metaInfo: String = ""
    var tokenType: IElementType! = ValkyrieTypes.DOT;
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return "generateDoc: $element, $originalElement $metaInfo"
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return "generateRenderedDoc"
    }

    // 按住 Ctrl 后悬浮
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return "getQuickNavigateInfo $element, $originalElement"
    }

    // 悬浮
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return "generateHoverDoc"
    }

    // 避免实现 PsiReference
    override fun getCustomDocumentationElement(
        editor: Editor,
        file: PsiFile,
        contextElement: PsiElement?,
        targetOffset: Int,
    ): PsiElement? {
        this.tokenType = contextElement.elementType ?: return null;
        return when (this.tokenType) {
            ValkyrieTypes.CLASS -> contextElement
            // contextElement?.parentOfTypes(ValkyrieClassStatement::class.java)
            else -> {
                val parent = contextElement?.parent
                metaInfo = "$editor $file $parent $targetOffset"
                contextElement
            }
        }
    }
}