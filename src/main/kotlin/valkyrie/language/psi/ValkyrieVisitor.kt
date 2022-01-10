package valkyrie.language.psi

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import valkyrie.language.ast.*

open class ValkyrieRecursiveVisitor : PsiParseTreeVisitor<Unit>(), PsiRecursiveVisitor {

    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        when (element) {
            is ValkyrieProgramNode -> visitProgram(element)
            is ValkyrieClassStatement -> visitClassDeclaration(element)
            is ValkyrieClassFieldNode -> visitClassField(element)

            is ValkyrieFlagsStatement -> visitFlagsDeclaration(element)
            is ValkyrieFlagsItemNode -> visitFlagsField(element)

            is ValkyrieTraitStatement -> visitTraitDeclaration(element)
            is ValkyrieFunctionStatement -> visitFunctionDeclaration(element)
            is ValkyrieFunctionItem -> visitFunctionItem(element)


            else -> {
                visitOther(element)
            }
        }
        element.acceptChildren(this)
    }





    open fun visitProgram(o: ValkyrieProgramNode) {

    }

    open fun visitClassDeclaration(o: ValkyrieClassStatement) {

    }

    open fun visitClassField(o: ValkyrieClassFieldNode) {

    }
    open fun visitFlagsDeclaration(o: ValkyrieFlagsStatement) {

    }
    open fun visitFlagsField(o: ValkyrieFlagsItemNode) {

    }
    open fun visitTraitDeclaration(o: ValkyrieTraitStatement) {

    }

    open fun visitFunctionDeclaration(o: ValkyrieFunctionStatement) {

    }


    open fun visitFunctionItem(o: ValkyrieFunctionItem) {

    }

    open fun visitOther(o: PsiElement) {

    }
}

