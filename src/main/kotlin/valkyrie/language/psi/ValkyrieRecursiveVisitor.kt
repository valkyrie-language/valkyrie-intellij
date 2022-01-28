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
            is ValkyrieNamespaceStatement -> visitNamespace(element)
            // class
            is ValkyrieClassStatement -> visitClassDeclaration(element)
            is ValkyrieClassFieldNode -> visitClassField(element)
            is ValkyrieClassMethodNode -> visitClassMethod(element)
            //
            is ValkyrieFlagsStatement -> visitFlagsDeclaration(element)
            is ValkyrieFlagsItemNode -> visitFlagsField(element)
            is ValkyrieUnionStatement -> visitUnionDeclaration(element)
            is ValkyrieVariantItem -> visitVariantDeclaration(element)
            //
            is ValkyrieTraitStatement -> visitTraitDeclaration(element)
            is ValkyrieFunctionStatement -> visitFunctionDeclaration(element)
            is ValkyrieFunctionParameter -> visitFunctionItem(element)


            else -> {
                visitOther(element)
            }
        }
        element.acceptChildren(this)
    }




    open fun visitProgram(o: ValkyrieProgramNode) {

    }
    open fun visitNamespace(o: ValkyrieNamespaceStatement) {

    }
    open fun visitClassDeclaration(o: ValkyrieClassStatement) {

    }

    open fun visitClassField(o: ValkyrieClassFieldNode) {

    }

    open fun visitClassMethod(o: ValkyrieClassMethodNode) {

    }

    open fun visitFlagsDeclaration(o: ValkyrieFlagsStatement) {

    }

    open fun visitFlagsField(o: ValkyrieFlagsItemNode) {

    }

    open fun visitUnionDeclaration(o: ValkyrieUnionStatement) {

    }

    open fun visitVariantDeclaration(o: ValkyrieVariantItem) {

    }


    open fun visitTraitDeclaration(o: ValkyrieTraitStatement) {

    }

    open fun visitFunctionDeclaration(o: ValkyrieFunctionStatement) {

    }


    open fun visitFunctionItem(o: ValkyrieFunctionParameter) {

    }

    open fun visitOther(o: PsiElement) {

    }
}

