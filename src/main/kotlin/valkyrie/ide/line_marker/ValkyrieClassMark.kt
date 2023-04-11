package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import java.util.function.Supplier
import javax.swing.Icon

class ValkyrieClassMark : MergeableLineMarkerInfo<PsiElement> {
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
        fun standalone(node: ValkyrieDeclareClassNode): ValkyrieClassMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieClassMark(leaf, node.getIcon(0))
        }

        fun ancestor(node: ValkyrieDeclareClassNode): ValkyrieClassMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieClassMark(leaf, AllIcons.Gutter.OverridingMethod)
        }

        fun descendant(node: ValkyrieDeclareClassNode): ValkyrieClassMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return ValkyrieClassMark(leaf, AllIcons.Gutter.OverridenMethod)
        }
    }
}

