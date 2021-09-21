package valkyrie.ide.hint

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.navigation.GotoRelatedItem
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.ide.file.ValkyrieIconProvider
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieClassMethodNode

@Suppress("UnstableApiUsage")
class ValkyrieClassElementMark : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is ValkyrieClassMethodNode) {
            return RelatedItemLineMarkerInfo(
                element.nameIdentifier.firstChild,
                element.nameIdentifier.textRange,
                ValkyrieIconProvider.FUNCTION,
                null,
                null,
                GutterIconRenderer.Alignment.LINE_NUMBERS
            ) { mutableListOf(GotoRelatedItem(element)) }
        }
        if (element is ValkyrieClassFieldNode) {
            return RelatedItemLineMarkerInfo(
                element.nameIdentifier.firstChild,
                element.nameIdentifier.textRange,
                ValkyrieIconProvider.FIELD,
                null,
                null,
                GutterIconRenderer.Alignment.LINE_NUMBERS
            ) { mutableListOf(GotoRelatedItem(element)) }
        }
        return null
    }
}

