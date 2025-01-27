package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.psi.PsiElement

class LineMarkerProvider : com.intellij.codeInsight.daemon.LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        return null
    }

    override fun collectSlowLineMarkers(elements: MutableList<out PsiElement>, result: MutableCollection<in LineMarkerInfo<*>>) {
        val visitor = ValkyrieMarkerVisitor(result)
        for (element in elements) {
            element.accept(visitor)
        }
    }
}


