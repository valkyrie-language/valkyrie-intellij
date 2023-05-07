package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationBuilder
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import valkyrie.ide.actions.ast_transform.DeleteThis
import valkyrie.ide.actions.ast_transform.ReplaceLeafText
import valkyrie.psi.node.ValkyrieVisitor

open class ValkyrieAnnotator : ValkyrieVisitor {
    protected val holder: AnnotationHolder

    constructor(holder: AnnotationHolder) : super() {
        this.holder = holder
    }

    protected fun PsiElement.replace(kind: IElementType, target: String, message: String): AnnotationBuilder {
        return holder.newAnnotation(HighlightSeverity.WARNING, message)
            .range(this.textRange)
            .withFix(ReplaceLeafText(this, kind, target))
    }

    protected fun PsiElement.delete(message: String): AnnotationBuilder {
        return holder.newAnnotation(HighlightSeverity.WARNING, message)
            .range(this.textRange)
            .withFix(DeleteThis(this))
    }
}