package valkyrie.ide.hint

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.language.psi_node.ValkyrieClassMethodNode

class ValkyrieSuperMark : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is ValkyrieClassMethodNode) {
            return RelatedItemLineMarkerInfo(
                element.nameIdentifier.firstChild,
                element.textRange,
                ValkyrieIconProvider.FUNCTION,
                null,
                null,
                GutterIconRenderer.Alignment.LEFT
            ) { mutableListOf() }
        }
        return null
    }
}