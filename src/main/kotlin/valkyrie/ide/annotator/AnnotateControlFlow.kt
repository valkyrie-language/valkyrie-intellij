package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.cst.KW_CONTINUE
import valkyrie.cst.KW_RETURN
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.node.ValkyrieControlYieldSend
import valkyrie.psi.node.ValkyrieControlYieldStop

class AnnotateControlFlow : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        element.accept(LintControlFlow(holder))
    }
}

private class LintControlFlow(holder: AnnotationHolder) : ValkyrieAnnotator(holder) {
    override fun visitControlYieldStop(o: ValkyrieControlYieldStop) {

    }

    override fun visitControlYieldSend(o: ValkyrieControlYieldSend) {
        for (kw in o.childrenWithLeaves) {
            if (kw.elementType == KW_RETURN) {
                kw.delete(ValkyrieBundle.message("lint.yield.return")).create()
                break
            } else if (kw.elementType == KW_CONTINUE) {
                kw.delete(ValkyrieBundle.message("lint.yield.continue")).create()
                break
            }
        }
    }
}

