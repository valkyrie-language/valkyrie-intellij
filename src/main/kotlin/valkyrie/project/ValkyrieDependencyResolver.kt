package valkyrie.project

import com.intellij.packageDependencies.DependenciesBuilder.DependencyProcessor
import com.intellij.packageDependencies.DependencyVisitorFactory
import com.intellij.packageDependencies.DependencyVisitorFactory.VisitorOptions
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import valkyrie.psi.node.ValkyrieVisitor

class ValkyrieDependencyResolver : DependencyVisitorFactory() {
    override fun getVisitor(processor: DependencyProcessor, options: VisitorOptions): PsiElementVisitor {
        return Visitor(processor, options)
    }
}

private class Visitor(val processor: DependencyProcessor, val options: VisitorOptions) : ValkyrieVisitor() {
    override fun visitFile(file: PsiFile) {
        println("ValkyrieDependencyResolver: ${file}")
        super.visitFile(file)
    }
}