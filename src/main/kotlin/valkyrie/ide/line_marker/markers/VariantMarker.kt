package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieVariantNode
import valkyrie.language.file.ValkyrieIconProvider.Instance.Variant
import javax.swing.Icon

class VariantMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieVariantNode) : super(
        element.navigationElement,
        element.textRange,
        Variant,
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