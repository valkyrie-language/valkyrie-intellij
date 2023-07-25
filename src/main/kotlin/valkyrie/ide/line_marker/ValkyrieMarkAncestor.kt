package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareTraitNode
import valkyrie.psi.node.ValkyrieIdentifier
import javax.swing.Icon

class ValkyrieMarkAncestor : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(leaf: ValkyrieIdentifier, `class`: ValkyrieDeclareClassNode) : super(
        leaf.firstChild,
        leaf.textRange,
        AllIcons.Gutter.OverridingMethod,
        { "Valkyrie Class" },
        { `class`.name },
        { e, elt -> },
        GutterIconRenderer.Alignment.CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    constructor(leaf: ValkyrieIdentifier, trait: ValkyrieDeclareTraitNode) : super(
        leaf.firstChild,
        leaf.textRange,
        AllIcons.Gutter.ImplementingMethod,
        { "Valkyrie Trait" },
        { trait.name },
        { e, elt -> },
        GutterIconRenderer.Alignment.CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == AllIcons.Gutter.OverridingMethod || info.icon == AllIcons.Gutter.ImplementingMethod
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        for (info in infos) {
            if (info.icon == AllIcons.Gutter.OverridingMethod) {
                return AllIcons.Gutter.OverridingMethod
            }
        }
        return AllIcons.Gutter.ImplementingMethod
    }
}