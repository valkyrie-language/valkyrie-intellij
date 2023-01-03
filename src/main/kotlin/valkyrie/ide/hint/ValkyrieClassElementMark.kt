package valkyrie.ide.hint

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.navigation.GotoRelatedItem
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassFieldNode
import valkyrie.language.ast.ValkyrieClassMethodNode
import valkyrie.language.file.ValkyrieIconProvider
//import valkyrie.language.psi_node.ValkyrieClassFieldNode
//import valkyrie.language.psi_node.ValkyrieClassMethodNode

@Suppress("UnstableApiUsage")
class ValkyrieClassElementMark : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element is ValkyrieClassMethodNode) {
            return RelatedItemLineMarkerInfo(
                element.nameIdentifier.firstChild,
                element.nameIdentifier.textRange,
                ValkyrieIconProvider.Instance.Function,
                null,
                null,
                GutterIconRenderer.Alignment.RIGHT // 上
            ) { mutableListOf(GotoRelatedItem(element)) }
        }
        if (element is ValkyrieClassFieldNode) {
            return RelatedItemLineMarkerInfo(
                element.nameIdentifier.firstChild,
                element.nameIdentifier.textRange,
                ValkyrieIconProvider.Instance.Field,
                null,
                null,
                GutterIconRenderer.Alignment.RIGHT // 下
            ) { mutableListOf(GotoRelatedItem(element)) }
        }
        return null
    }
}

