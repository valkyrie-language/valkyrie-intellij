import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement


class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return "generateDoc"
    }

    override fun generateRenderedDoc(comment: PsiDocCommentBase): String? {
        return "generateRenderedDoc"
    }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return "getQuickNavigateInfo"
    }

    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        return "generateHoverDoc"
    }
}