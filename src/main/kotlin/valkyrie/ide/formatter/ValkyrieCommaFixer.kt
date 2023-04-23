package valkyrie.ide.formatter


import com.intellij.lang.SmartEnterProcessorWithFixers.Fixer
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

class ValkyrieCommaFixer : Fixer<SmartEnter>() {
    override fun apply(editor: Editor, processor: SmartEnter, element: PsiElement) {

    }
}
