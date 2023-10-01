package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ensureLeaf
import valkyrie.psi.node.ValkyrieDeclareSingletonNode
import javax.swing.Icon

class SingletonMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareSingletonNode) : super(
        element.navigationElement,
        element.navigationElement.textRange,
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

