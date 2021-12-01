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

    }
}
