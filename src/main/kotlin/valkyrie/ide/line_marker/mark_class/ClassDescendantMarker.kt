package valkyrie.ide.line_marker.mark_class

import com.intellij.codeInsight.daemon.DefaultGutterIconNavigationHandler
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieIdentifier
import javax.swing.Icon

class ClassDescendantMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(leaf: ValkyrieIdentifier, descendant: NavigatablePsiElement) : super(
        leaf.firstChild,
        leaf.textRange,
        AllIcons.Gutter.OverridenMethod,
        { "Valkyrie Class" },
        { decentType(descendant) },
        DefaultGutterIconNavigationHandler(mutableListOf(descendant), "ClassDescendantMarker"),
        GutterIconRenderer.Alignment.LEFT,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info is ClassDescendantMarker
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }

    companion object {
        fun decentType(descendant: PsiElement): String {
            if (descendant is ValkyrieDeclareClassNode) {
                return descendant.name
            }
            return "decentTypeName"
        }
    }
}

