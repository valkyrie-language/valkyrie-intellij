package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider.Instance.Unite
import valkyrie.psi.node.ValkyrieDeclareUniteNode
import javax.swing.Icon

class UniteMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareUniteNode) : super(
        element.keyword,
        element.textRange,
        Unite,
        null,
        null,
        null,
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return false
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }
}
