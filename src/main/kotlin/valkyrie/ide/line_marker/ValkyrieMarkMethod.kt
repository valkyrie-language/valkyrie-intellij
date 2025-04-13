package valkyrie.ide.line_marker


import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieObjectMethodNode
import valkyrie.language.file.ValkyrieIconProvider.Instance.Method
import javax.swing.Icon

class ValkyrieMarkMethod : RelatedItemLineMarkerInfo<PsiElement> {
    constructor(element: ValkyrieObjectMethodNode) : super(
        element.identifier.firstChild,
        element.identifier.textRange,
        Method,
        { "tooltipProvider" },
        { element.name },
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