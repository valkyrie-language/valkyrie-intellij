package valkyrie.ide.folding

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor
import yggdrasil.psi.node.ValkyrieVisitor

open class ValkyrieRecursiveVisitor : ValkyrieVisitor(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }
}