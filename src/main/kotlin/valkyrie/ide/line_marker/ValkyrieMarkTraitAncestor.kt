package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieIdentifier
import javax.swing.Icon


class ValkyrieMarkTraitAncestor : RelatedItemLineMarkerInfo<PsiElement> {
    private constructor(leaf: ValkyrieIdentifier, ancestor: ValkyrieIdentifier) : super(
        leaf.firstChild,
        leaf.textRange,
        AllIcons.Gutter.ImplementingMethod,
        { "Valkyrie Trait" },
        { "PresentationProvider" },
        { e, elt -> },
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == myIcon;
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }
}