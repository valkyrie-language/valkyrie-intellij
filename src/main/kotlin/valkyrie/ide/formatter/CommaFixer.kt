package valkyrie.ide.formatter


import valkyrie.language.psi.getNextNonCommentSibling
import valkyrie.language.psi.getPrevNonCommentSibling
import valkyrie.language.psi.getPrevNonWhitespaceSibling
import com.intellij.lang.SmartEnterProcessorWithFixers.Fixer
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.refactoring.suggested.endOffset

class CommaFixer : Fixer<SmartEnter>() {
    override fun apply(editor: Editor, processor: SmartEnter, element: PsiElement) {
        element.isValid
        val current = if (element is LeafPsiElement && element.parent !is PsiFile) {
            element.parent
        } else {
            element
        }
        var errorElement: PsiErrorElement? = getFirstErrorAround(current)
        if (errorElement != null) {
            val description = errorElement.errorDescription
            val expectedId = description.indexOf("expected")
            val commaExpectationId = description.indexOf("VomlTokenType.,")
            val commaIsExpected = expectedId >= 0 && commaExpectationId in 0 until expectedId

            val siblingOnLeft = errorElement.getPrevNonCommentSibling()
            if (siblingOnLeft != null && commaIsExpected) {
                editor.document.insertString(siblingOnLeft.endOffset, ",")
            }
        }
    }

    private fun getFirstErrorAround(current: PsiElement?): PsiErrorElement? {
        if (current is PsiErrorElement) {
            return current
        }

        var next = current.getNextNonCommentSibling()
        while (!(next == null || next is PsiErrorElement)) {
            next = next.getNextNonCommentSibling()
        }

        if (next != null && next is PsiErrorElement) {
            return next
        }

        var prev = current.getPrevNonWhitespaceSibling()
        while (!(prev == null || prev is PsiErrorElement)) {
            prev = prev.getPrevNonWhitespaceSibling()
        }

        if (prev != null && prev is PsiErrorElement) {
            return prev
        }

        return null
    }
}
