package valkyrie.language.psi

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import valkyrie.language.ast.ValkyrieClassDeclaration
import valkyrie.language.ast.ValkyrieProgramNode
import valkyrie.language.ast.ValkyrieTraitDeclaration

open class ValkyrieRecursiveVisitor : PsiParseTreeVisitor<Unit>(), PsiRecursiveVisitor {

    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        when (element) {
            is ValkyrieProgramNode -> visitProgram(element)
            is ValkyrieClassDeclaration -> visitClassDeclaration(element)
            is ValkyrieTraitDeclaration -> visitTraitDeclaration(element)
            else -> {
                visitOther(element)
            }
        }
        element.acceptChildren(this)
    }

    open fun visitProgram(node: ValkyrieProgramNode) {

    }

    open fun visitClassDeclaration(node: ValkyrieClassDeclaration) {

    }

    open fun visitTraitDeclaration(node: ValkyrieTraitDeclaration) {

    }
    open fun visitOther(node: PsiElement) {

    }
}

