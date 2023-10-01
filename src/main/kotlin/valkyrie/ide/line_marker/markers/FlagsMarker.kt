package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider.Instance.Flags
import valkyrie.psi.node.ValkyrieDeclareFlagsNode
import javax.swing.Icon

class FlagsMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareFlagsNode) : super(
        element.navigationElement,
        element.keyword.textRange,
        Flags,
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