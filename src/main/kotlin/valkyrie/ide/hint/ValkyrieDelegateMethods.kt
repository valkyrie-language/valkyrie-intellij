package valkyrie.ide.hint

import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieFileNode

class ValkyrieDelegateMethods : LanguageCodeInsightActionHandler {
    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieDelegateMethods.invoke($editor, $file)")
    }

    override fun isValidFor(editor: Editor?, file: PsiFile?): Boolean {
       return  file is ValkyrieFileNode
    }
}