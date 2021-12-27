package valkyrie.language.psi

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieProgramNode
import valkyrie.language.ast.ValkyrieTraitStatement

open class ValkyrieRecursiveVisitor : PsiParseTreeVisitor<Unit>(), PsiRecursiveVisitor {

    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        when (element) {
            is ValkyrieProgramNode -> visitProgram(element)
            is ValkyrieClassStatement -> visitClassDeclaration(element)
            is ValkyrieTraitStatement -> visitTraitDeclaration(element)
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
    open fun visitOther(node: PsiElement) {

    }
}

