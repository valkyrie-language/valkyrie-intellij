package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareTraitNode
import valkyrie.psi.node.ValkyrieIdentifier
import javax.swing.Icon

class ValkyrieMarkTrait : RelatedItemLineMarkerInfo<PsiElement> {
    private constructor(element: PsiElement, icon: Icon) : super(
        element,
        element.textRange,
        icon,
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

    companion object {
        fun standalone(node: ValkyrieDeclareTraitNode): ValkyrieMarkTrait? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkTrait(leaf, node.getIcon(0))
        }


        fun descendant(node: ValkyrieDeclareTraitNode, child: ValkyrieDeclareTraitNode): ValkyrieMarkTrait? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkTrait(leaf, AllIcons.Gutter.ImplementedMethod)
        }
    }
}

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