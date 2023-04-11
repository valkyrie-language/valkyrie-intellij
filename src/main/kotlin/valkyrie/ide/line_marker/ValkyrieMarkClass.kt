package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import java.util.function.Supplier
import javax.swing.Icon

class ValkyrieMarkClass : MergeableLineMarkerInfo<PsiElement> {
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
        fun standalone(node: ValkyrieDeclareClassNode): ValkyrieMarkClass? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkClass(leaf, node.getIcon(0))
        }

        fun ancestor(node: ValkyrieDeclareClassNode): ValkyrieMarkClass? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkClass(leaf, AllIcons.Gutter.OverridingMethod)
        }

        fun descendant(node: ValkyrieDeclareClassNode): ValkyrieMarkClass? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieMarkClass(leaf, AllIcons.Gutter.OverridenMethod)
        }
    }
}

