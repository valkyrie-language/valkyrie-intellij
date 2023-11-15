package valkyrie.ide.line_marker.markers

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieNeuralDeclarationNode
import valkyrie.language.file.ValkyrieIconProvider.Instance.Neural
import javax.swing.Icon

class NeuralMarker : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieNeuralDeclarationNode) : super(
        element.keyword.firstChild,
        element.keyword.textRange,
        Neural,
        null,
        null,
        null,
        CENTER,
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