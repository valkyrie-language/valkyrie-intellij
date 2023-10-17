package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.DefaultGutterIconNavigationHandler
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieClassDeclarationNode
import valkyrie.ast.node.ValkyrieIdentifierNode
import javax.swing.Icon

class SubtypeMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(leaf: ValkyrieIdentifierNode, descendant: NavigatablePsiElement) : super(
        leaf.firstChild,
        leaf.textRange,
        AllIcons.Gutter.OverridenMethod,
        { "Valkyrie Class" },
        { decentType(descendant) },
        DefaultGutterIconNavigationHandler(mutableListOf(descendant), "ClassDescendantMarker"),
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info is SubtypeMarker
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }

    companion object {
        fun decentType(descendant: PsiElement): String {
            if (descendant is ValkyrieClassDeclarationNode) {
                return descendant.name
            }
            return "decentTypeName"
        }
    }
}

