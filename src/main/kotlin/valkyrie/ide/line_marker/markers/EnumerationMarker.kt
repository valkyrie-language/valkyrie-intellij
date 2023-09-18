package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider.Instance.Enumeration
import valkyrie.psi.node.ValkyrieDeclareEnumsNode
import javax.swing.Icon

class EnumerationMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareEnumsNode) : super(
        element.keyword,
        element.keyword.textRange,
        Enumeration,
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

