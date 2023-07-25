package valkyrie.ide.line_marker.mark_class

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import javax.swing.Icon

class ClassMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareClassNode) : super(
        element.keyword,
        element.textRange,
        AllIcons.Nodes.Class,
        { "Valkyrie Class" },
        { element.name },
        null,
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        // there is only one class marker
        return false
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }
}


