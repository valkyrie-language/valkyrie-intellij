package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieTraitNode
import valkyrie.psi.mixin.MixinIdentifier
import javax.swing.Icon

class ValkyrieMarkAncestor : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(leaf: MixinIdentifier, `class`: ValkyrieClassNode) : super(
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

    constructor(leaf: MixinIdentifier, trait: ValkyrieTraitNode) : super(
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