package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider.Instance.Trait
import valkyrie.psi.ensureLeaf
import valkyrie.psi.mixin.keyword
import valkyrie.psi.node.ValkyrieDeclareTraitNode
import valkyrie.psi.node.ValkyrieTraitAliasNode
import javax.swing.Icon

class TraitMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareTraitNode) : super(
        element.navigationElement,
        element.textRange,
        Trait,
        { "Valkyrie Trait" },
        { "PresentationProvider" },
        null,
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    constructor(element: ValkyrieTraitAliasNode) : super(
        element,
        element.textRange,
        Trait,
        { "Valkyrie Trait" },
        { "PresentationProvider" },
        null,
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        // there is only one trait marker
        return false
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }
}