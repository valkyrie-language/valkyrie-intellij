package valkyrie.ide.doc

import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ValkyrieBundle
import java.util.function.Consumer


class DocumentationProvider : DocumentationProvider {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return "generateDoc:\n${element?.text}"
    }

    override fun findDocComment(file: PsiFile, range: TextRange): PsiDocCommentBase? {
        return null
    }

    override fun collectDocComments(file: PsiFile, sink: Consumer<in PsiDocCommentBase>) {
        for (leaf in PsiTreeUtil.findChildrenOfType(file, PsiComment::class.java)) {
//            val text = ValkyrieCommenter().extractDocumentText(leaf)
//            if (text != null) {
//                sink.accept(DocumentNode(leaf, text))
//            }
        }
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return "generateRenderedDoc:\n${comment.text}"
    }

    /** Ctrl + Hover */
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return "getQuickNavigateInfo:\n${element?.text}"
    }

    /** Mouse Hover */
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String {
        // suppressed by lsp, use `getQuickNavigateInfo` instead
        return ValkyrieBundle.message("lsp.hover.install")
    }

    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        // suppressed by lsp
        return null
    }

    override fun getDocumentationElementForLink(psiManager: PsiManager?, link: String?, context: PsiElement?): PsiElement? {
        return null
    }

    override fun getDocumentationElementForLookupItem(psiManager: PsiManager?, `object`: Any?, element: PsiElement?): PsiElement? {
        return null
    }

    override fun getUrlFor(element: PsiElement?, originalElement: PsiElement?): MutableList<String> {
        return mutableListOf()
    }
}