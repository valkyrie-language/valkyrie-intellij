package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider.Instance.Enumeration
import valkyrie.psi.node.ValkyrieDeclareEnumerateNode
import javax.swing.Icon

class ValkyrieMarkEnumeration : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareEnumerateNode) : super(
        element,
        element.keyword.textRange,
        Enumeration,
        { "tooltipProvider" },
        { "PresentationProvider" },
        { e, elt -> },
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return super.canMergeWith(info)
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return super.getCommonIcon(infos)
    }
}

