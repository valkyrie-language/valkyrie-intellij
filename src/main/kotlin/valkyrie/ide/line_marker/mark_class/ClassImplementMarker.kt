package valkyrie.ide.line_marker.mark_class

import com.intellij.codeInsight.daemon.DefaultGutterIconNavigationHandler
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieIdentifier
import javax.swing.Icon

class ClassImplementMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(leaf: ValkyrieIdentifier, implement: NavigatablePsiElement) : super(
        leaf.firstChild,
        leaf.textRange,
        AllIcons.Gutter.ImplementedMethod,
        { "Valkyrie Class" },
        { "PresentationProvider" },
        DefaultGutterIconNavigationHandler(mutableListOf(implement), "ClassDescendantMarker"),
        GutterIconRenderer.Alignment.LEFT,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info is ClassImplementMarker
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }
}