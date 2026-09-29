package awsl.surface.psi

import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor

/**
 * AWSL 递归访问者
 */
open class AwslRecursiveVisitor : AwslVisitor(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }
}
