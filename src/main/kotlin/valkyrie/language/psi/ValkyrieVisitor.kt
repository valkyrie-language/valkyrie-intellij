package valkyrie.language.psi

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import valkyrie.language.ast.*

open class ValkyrieRecursiveVisitor : PsiParseTreeVisitor<Unit>(), PsiRecursiveVisitor {

    override fun visitElement(node: PsiElement) {
        ProgressManager.checkCanceled()
        when (node) {
            is ValkyrieProgramNode -> visitProgram(node)
            is ValkyrieClassStatement -> visitClassDeclaration(node)
            is ValkyrieClassFieldNode -> visitClassField(node)
            is ValkyrieTraitStatement -> visitTraitDeclaration(node)
            is ValkyrieFunctionStatement -> visitFunctionDeclaration(node)
            is ValkyrieFunctionItem -> visitFunctionItem(node)


            else -> {
                visitOther(node)
            }
        }
        node.acceptChildren(this)
    }


    open fun visitProgram(node: ValkyrieProgramNode) {

    }

    open fun visitClassDeclaration(node: ValkyrieClassStatement) {

    }

    open fun visitClassField(node: ValkyrieClassFieldNode) {

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

