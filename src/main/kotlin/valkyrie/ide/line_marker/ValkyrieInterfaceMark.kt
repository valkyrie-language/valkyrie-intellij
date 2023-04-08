package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment
import com.intellij.psi.PsiElement
import yggdrasil.psi.node.ValkyrieDeclareTraitNode
import java.util.function.Supplier
import javax.swing.Icon

class ValkyrieInterfaceMark : MergeableLineMarkerInfo<PsiElement> {
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
        fun standalone(node: ValkyrieDeclareTraitNode): ValkyrieInterfaceMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieInterfaceMark(leaf, node.getIcon(0))
        }

        fun ancestor(self: ValkyrieDeclareTraitNode, parent: ValkyrieDeclareTraitNode): ValkyrieInterfaceMark? {
            val leaf = self.nameIdentifier?.firstChild ?: return null;
            return ValkyrieInterfaceMark(leaf, AllIcons.Gutter.ImplementingMethod)
        }

        fun descendant(node: ValkyrieDeclareTraitNode, child: ValkyrieDeclareTraitNode): ValkyrieInterfaceMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieInterfaceMark(leaf, AllIcons.Gutter.ImplementedMethod)
        }
    }
}