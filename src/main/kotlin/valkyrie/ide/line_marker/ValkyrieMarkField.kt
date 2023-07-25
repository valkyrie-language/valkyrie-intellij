package valkyrie.ide.line_marker


import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider.Instance.Field
import valkyrie.psi.node.ValkyrieDeclareFieldNode
import javax.swing.Icon

class ValkyrieMarkField : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieDeclareFieldNode) : super(
        element.identifier.firstChild,
        element.identifier.firstChild.textRange,
        Field,
        { "Valkyrie Field" },
        { "PresentationProvider" },
        { e, elt -> },
        CENTER,
        { mutableListOf() },
        { "AccessibleNameProvider" }
    )

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return super.canMergeWith(info)
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        return super.getCommonIcon(infos)
    }
}