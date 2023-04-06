package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import yggdrasil.psi.node.ValkyrieDeclareClassNode
import java.util.function.Supplier
import javax.swing.Icon

class AncestorClassMark : MergeableLineMarkerInfo<PsiElement> {
    private constructor(element: PsiElement, icon: Icon) : super(
        element,
        element.textRange,
        icon,
        { "tooltipProvider" },
        null,
        GutterIconRenderer.Alignment.RIGHT,
        Supplier<String> { "AncestorClassMark" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == myIcon;
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }

    companion object {
        fun ancestor(node: ValkyrieDeclareClassNode): AncestorClassMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return AncestorClassMark(leaf, AllIcons.Gutter.OverridingMethod)
        }

        fun descendant(node: ValkyrieDeclareClassNode): AncestorClassMark? {
            val leaf = node.nameIdentifier?.firstChild ?: return null;
            return AncestorClassMark(leaf, AllIcons.Gutter.OverridenMethod)
        }

    }

}

class AncestorInterfaceMark : MergeableLineMarkerInfo<PsiNameIdentifierOwner> {
    constructor(element: PsiNameIdentifierOwner, range: TextRange) : super(
        element,
        range,
        AllIcons.Gutter.OverridingMethod,
        { "tooltipProvider" },
        null,
        GutterIconRenderer.Alignment.RIGHT,
        Supplier<String> { "AncestorClassMark" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == myIcon;
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return AllIcons.Gutter.OverridingMethod
    }
}