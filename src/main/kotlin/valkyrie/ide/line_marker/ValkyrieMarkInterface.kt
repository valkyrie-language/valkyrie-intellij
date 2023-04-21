package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareTraitNode
import valkyrie.psi.node.ValkyrieTraitAliasNode
import java.util.function.Supplier
import javax.swing.Icon

class ValkyrieMarkInterface : MergeableLineMarkerInfo<PsiElement> {
    private constructor(element: PsiElement, icon: Icon) : super(
        element,
        element.textRange,
        icon,
        { "tooltipProvider" },
        null,
        Alignment.CENTER,
        Supplier<String> { "AncestorClassMark" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == myIcon;
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }

    companion object {
        fun standalone(node: ValkyrieTraitAliasNode): ValkyrieMarkInterface? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkInterface(leaf, node.getIcon(0))
        }
        fun standalone(node: ValkyrieDeclareTraitNode): ValkyrieMarkInterface? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkInterface(leaf, node.getIcon(0))
        }

        fun ancestor(self: ValkyrieDeclareTraitNode, parent: ValkyrieDeclareTraitNode): ValkyrieMarkInterface? {
            val leaf = self.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkInterface(leaf, AllIcons.Gutter.ImplementingMethod)
        }

        fun descendant(node: ValkyrieDeclareTraitNode, child: ValkyrieDeclareTraitNode): ValkyrieMarkInterface? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkInterface(leaf, AllIcons.Gutter.ImplementedMethod)
        }
    }
}