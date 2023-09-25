package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.DefaultGutterIconNavigationHandler
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons.Gutter.ImplementedMethod
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import valkyrie.psi.mixin.MixinIdentifier
import valkyrie.psi.node.ValkyrieDeclareImplyNode

import javax.swing.Icon

class ImplementMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(leaf: MixinIdentifier, implement: NavigatablePsiElement) : super(
        leaf.firstChild,
        leaf.textRange,
        ImplementedMethod,
        { "Implements" },
        { implementType(implement) },
        DefaultGutterIconNavigationHandler(mutableListOf(implement), "ClassDescendantMarker"),
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info is ImplementMarker
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }

    companion object {
        fun implementType(descendant: PsiElement): String {
            if (descendant is ValkyrieDeclareImplyNode) {
                return descendant.name
            }
            return "implementType"
        }
    }

}