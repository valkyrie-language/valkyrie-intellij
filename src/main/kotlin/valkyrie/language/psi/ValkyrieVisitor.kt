package valkyrie.language.psi

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import valkyrie.language.ast.*
import valkyrie.language.ast.calls.ValkyrieCallGeneric

open class ValkyrieVisitor : PsiParseTreeVisitor<Unit>(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        when (element) {
            is ValkyrieProgramNode -> visitProgram(element)
            is ValkyrieNamespaceStatement -> visitNamespace(element)
            // class
            is ValkyrieClassStatement -> visitClassDeclaration(element)
            is ValkyrieClassFieldNode -> visitClassField(element)
            is ValkyrieClassMethodNode -> visitClassMethod(element)
            is ValkyrieCallGeneric -> visitGenericCall(element)

            //
            is ValkyrieFlagsStatement -> visitFlagsDeclaration(element)
            is ValkyrieFlagsItemNode -> visitFlagsField(element)
            is ValkyrieUnionStatement -> visitUnionDeclaration(element)
            is ValkyrieVariantItem -> visitVariantDeclaration(element)
            //
            is ValkyrieTraitStatement -> visitTraitDeclaration(element)
            is ValkyrieFunctionStatement -> visitFunctionDeclaration(element)
            is ValkyrieFunctionParameter -> visitFunctionItem(element)
            // let binding
            is ValkyrieLetStatement -> visitVariableDeclaration(element)

            // for statement
            is ValkyrieForStatement -> visitForStatement(element)
            is ValkyrieLetParameter -> visitForParameter(element)
            //
            is ValkyrieCallArgument -> visitCallArgument(element)
            //
            is ValkyrieNewStatement -> visitNewObject(element)
            is ValkyrieNamepathNode -> {
                visitNamepath(element)
                return;
            }
            // parent will not be namepath

            is ValkyrieStringNode -> visitString(element)
            is ValkyrieIdentifierNode -> visitIdentifier(element)
            else -> visitOther(element)
        }
        element.acceptChildren(this)
    }

    protected open fun visitCallArgument(o: ValkyrieCallArgument) {

    }


    protected open fun visitProgram(o: ValkyrieProgramNode) {

    }

    protected open fun visitNamespace(o: ValkyrieNamespaceStatement) {

    }

    protected open fun visitClassDeclaration(o: ValkyrieClassStatement) {

    }

    protected open fun visitClassField(o: ValkyrieClassFieldNode) {

    }

    protected open fun visitClassMethod(o: ValkyrieClassMethodNode) {

    }

    protected open fun visitGenericCall(o: ValkyrieCallGeneric) {

    }

    protected open fun visitFlagsDeclaration(o: ValkyrieFlagsStatement) {

    }

    protected open fun visitFlagsField(o: ValkyrieFlagsItemNode) {

    }

    protected open fun visitUnionDeclaration(o: ValkyrieUnionStatement) {

    }

    protected open fun visitVariantDeclaration(o: ValkyrieVariantItem) {

    }


    protected open fun visitTraitDeclaration(o: ValkyrieTraitStatement) {

    }

    protected open fun visitFunctionDeclaration(o: ValkyrieFunctionStatement) {

    }

    protected open fun visitVariableDeclaration(o: ValkyrieLetStatement) {

    }

    protected open fun visitFunctionItem(o: ValkyrieFunctionParameter) {

    }

    protected open fun visitForParameter(o: ValkyrieLetParameter) {

    }

    protected open fun visitForStatement(o: ValkyrieForStatement) {

    }

    protected open fun visitNewObject(o: ValkyrieNewStatement) {

    }

    protected open fun visitNamepath(o: ValkyrieNamepathNode) {

    }

    protected open fun visitString(o: ValkyrieStringNode) {

    }

    protected open fun visitIdentifier(o: ValkyrieIdentifierNode) {

    }

    protected open fun visitOther(o: PsiElement) {

    }
}

