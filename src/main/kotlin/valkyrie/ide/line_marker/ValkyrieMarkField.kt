package valkyrie.ide.line_marker


import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieObjectFieldNode
import valkyrie.language.file.ValkyrieIconProvider.Instance.Field
import javax.swing.Icon

class ValkyrieMarkField : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieObjectFieldNode) : super(
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
        return myIcon
    }
}