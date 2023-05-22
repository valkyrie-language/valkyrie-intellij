package valkyrie.ide.refactor

import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.ScrollType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.rename.RenameHandler
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.ValkyrieVisitor


class ValkyrieRenameHandler : RenameHandler {
    override fun invoke(project: Project, editor: Editor?, file: PsiFile?, dataContext: DataContext?) {
        if (file !is ValkyrieFileNode || editor == null) {
            return
        }
        val offset = editor.caretModel.offset
        editor.scrollingModel.scrollToCaret(ScrollType.MAKE_VISIBLE)
        val element = file.findElementAt(offset) ?: return
        println("invoke1($element, $dataContext)")
//        if (ValkyrieLexer.Keywords.contains(element.elementType)) {
//            val message = ValkyrieBundle.message("rename.invalid.keyword", element.elementType!!)
//            CommonRefactoringUtil.showErrorHint(project, editor, message, "getTitle", "getHelpId")
//        } else if (ValkyrieLexer.Identifiers.contains(element.elementType)) {
//            invoke(project, arrayOf(element), dataContext)
//        } else {
//
//        }

    }

    override fun invoke(project: Project, elements: Array<out PsiElement>, dataContext: DataContext?) {
        val visitor = ValkyrieRenameVisitor(project, dataContext)
        for (el in elements) {
            println("invoke2($el, $dataContext)")
        }
//        val file = CommonDataKeys.PSI_FILE.getData(dataContext!!)
//        val editor = CommonDataKeys.EDITOR.getData(dataContext!!)
//        showDialog(project, elements[0], editor, file, dataContext)
    }


    override fun isAvailableOnDataContext(dataContext: DataContext): Boolean {
        val file = CommonDataKeys.PSI_FILE.getData(dataContext)
        if (file is ValkyrieFileNode) {
            return true
        } else {
            println("isAvailableOnDataContext: $file")
            return false
        }
    }

    override fun isRenaming(dataContext: DataContext): Boolean {
        return super.isRenaming(dataContext)
    }
}

class ValkyrieRenameVisitor(val project: Project, val dataContext: DataContext?) : ValkyrieVisitor() {
    override fun visitFile(file: PsiFile) {
        super.visitFile(file)
    }
}