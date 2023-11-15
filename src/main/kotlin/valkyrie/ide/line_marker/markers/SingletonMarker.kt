package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieSingletonDeclarationNode
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class SingletonMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieSingletonDeclarationNode) : super(
        element.keyword.firstChild,
        element.keyword.textRange,
        ValkyrieIconProvider.Instance.Singleton,
        null,
        null,
        null,
        GutterIconRenderer.Alignment.CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        // there is only one class marker
        return false
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return myIcon
    }
}

