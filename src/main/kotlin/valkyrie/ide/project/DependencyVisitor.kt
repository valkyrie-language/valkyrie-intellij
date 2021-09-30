package valkyrie.ide.project

import com.intellij.packageDependencies.DependenciesBuilder
import com.intellij.packageDependencies.DependencyVisitorFactory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor

class DependencyVisitor : DependencyVisitorFactory() {
    override fun getVisitor(processor: DependenciesBuilder.DependencyProcessor, options: VisitorOptions): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
            }
        }
    }
}