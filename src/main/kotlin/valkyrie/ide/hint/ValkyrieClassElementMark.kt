package valkyrie.ide.hint

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.navigation.GotoRelatedItem
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassFieldNode
import valkyrie.language.ast.ValkyrieClassInheritItem
import valkyrie.language.ast.ValkyrieClassMethodNode
import valkyrie.language.ast.ValkyrieClassStatement

//import valkyrie.language.psi_node.ValkyrieClassFieldNode
//import valkyrie.language.psi_node.ValkyrieClassMethodNode

@Suppress("UnstableApiUsage")
class ValkyrieClassElementMark : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        when (element) {
            is ValkyrieClassStatement -> {
                return RelatedItemLineMarkerInfo(
                    element.nameIdentifier.firstChild,
                    element.nameIdentifier.textRange,
                    AllIcons.Gutter.OverridenMethod,
                    null,
                    null,
                    GutterIconRenderer.Alignment.RIGHT // 上
                ) { mutableListOf(GotoRelatedItem(element)) }
            }
            is ValkyrieClassMethodNode -> {
                return RelatedItemLineMarkerInfo(
                    element.nameIdentifier.firstChild,
                    element.nameIdentifier.textRange,
                    element.baseIcon,
                    null,
                    null,
                    GutterIconRenderer.Alignment.RIGHT // 上
                ) { mutableListOf(GotoRelatedItem(element)) }
            }

            is ValkyrieClassInheritItem -> {
                return RelatedItemLineMarkerInfo(
                    element.inherit.firstChild,
                    element.inherit.textRange,
                    element.baseIcon,
                    null,
                    null,
                    GutterIconRenderer.Alignment.RIGHT // 上
                ) { mutableListOf(GotoRelatedItem(element)) }
            }

            is ValkyrieClassFieldNode -> {
                return RelatedItemLineMarkerInfo(
                    element.nameIdentifier.firstChild,
                    element.nameIdentifier.textRange,
                    element.baseIcon,
                    null,
                    null,
                    GutterIconRenderer.Alignment.RIGHT // 下
                ) { mutableListOf(GotoRelatedItem(element)) }
            }

            else -> return null
        }
    }
}

