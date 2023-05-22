package valkyrie.ide.refactor

import com.intellij.psi.PsiFile
import com.intellij.refactoring.actions.RenameFileActionProvider

class ValkyrieRenameFileActionProvider : RenameFileActionProvider {
    override fun enabledInProjectView(file: PsiFile): Boolean {
        println("enabledInProjectView: ${file}")
        return super.enabledInProjectView(file)
    }
}
