package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import java.util.function.Supplier
import javax.swing.Icon

class DescendantClassMark : MergeableLineMarkerInfo<PsiElement> {
    constructor(element: PsiElement, range: TextRange) : super(
        element,
        range,
        AllIcons.Gutter.OverridenMethod,
        { "tooltipProvider" },
        null,
        GutterIconRenderer.Alignment.RIGHT,
        Supplier<String> { "DescendantClassMark" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == myIcon;
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return AllIcons.Gutter.OverridenMethod
    }
}