package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.psi.ValkyrieTypes
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
        for (kw in o.childrenWithLeaves) {
            if (kw.elementType == ValkyrieTypes.KW_RETURN) {
                kw.replace(ValkyrieTypes.KW_BREAK, "break", "`yield return` is equivalent to `yield break`").create()
                break
            }
        }
    }

    override fun visitControlYieldSend(o: ValkyrieControlYieldSend) {
        for (kw in o.childrenWithLeaves) {
            if (kw.elementType == ValkyrieTypes.KW_CONTINUE) {
                kw.delete("`yield continue` is equivalent to `yield`").create()
                break
            }
        }
    }
}

