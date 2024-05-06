package valkyrie.ide.doc

import com.intellij.lang.documentation.DocumentationProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import valkyrie.psi.ValkyrieTypes
import java.util.function.Consumer


class DocumentationProvider : DocumentationProvider {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return "generateDoc:\n${element?.text}"
    }

    override fun findDocComment(file: PsiFile, range: TextRange): PsiDocCommentBase? {
        println("findDocComment $file $range")
        return super.findDocComment(file, range)
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
//        if (comment is ValkyrieCommentDocument) {
//            return comment.render()
//        }
        return "generateRenderedDoc:\n${comment.text}"
    }

    // 按住 Ctrl 后悬浮
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return "getQuickNavigateInfo:\n${element?.text}"
    }

    // 悬浮
    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return "generateHoverDoc:\n${element.text}"
    }

    override fun getCustomDocumentationElement(editor: Editor, file: PsiFile, contextElement: PsiElement?, targetOffset: Int): PsiElement? {
        return when (contextElement.elementType) {
            ValkyrieTypes.ANY_LIST,
            ValkyrieTypes.ANY_DICT,
            -> contextElement

            TokenType.WHITE_SPACE -> null
            else -> null
        }
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