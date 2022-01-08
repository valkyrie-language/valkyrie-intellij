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
            is ValkyrieTraitStatement -> visitTraitDeclaration(element)
            is ValkyrieFunctionStatement -> visitFunctionDeclaration(element)
            is ValkyrieFunctionItem -> visitFunctionItem(element)


            else -> {
                visitOther(element)
            }
        }
        element.acceptChildren(this)
    }


    open fun visitProgram(node: ValkyrieProgramNode) {

    }

    open fun visitClassDeclaration(node: ValkyrieClassStatement) {

    }

    open fun visitTraitDeclaration(node: ValkyrieTraitStatement) {

    }
    open fun visitFunctionDeclaration(node: ValkyrieFunctionStatement) {

    }


    open fun visitFunctionItem(node: ValkyrieFunctionItem) {

    }

    open fun visitOther(node: PsiElement) {

    }
}

