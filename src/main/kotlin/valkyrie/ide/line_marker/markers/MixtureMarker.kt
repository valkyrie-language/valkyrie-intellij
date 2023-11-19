package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieMixtureNode
import javax.swing.Icon

class MixtureMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieMixtureNode) : super(
        element.keyword.firstChild,
        element.keyword.textRange,
        element.getIcon(0),
        { "tooltipProvider" },
        { "PresentationProvider" },
        null,
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        // there is only one enumeration marker
        return false
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return super.getCommonIcon(infos)
    }
}

