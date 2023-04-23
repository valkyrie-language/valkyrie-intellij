package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.ValkyrieElement
import java.util.function.Supplier
import javax.swing.Icon

class ValkyrieMarkAny : MergeableLineMarkerInfo<PsiElement> {
    private val declare: ValkyrieElement

    constructor(declare: ValkyrieDeclareElement) : super(
        declare.navigationElement.firstChild,
        declare.navigationElement.firstChild.textRange,
        declare.getIcon(0),
        { "tooltipProvider" },
        null,
        GutterIconRenderer.Alignment.CENTER,
        Supplier<String> { "AncestorClassMark" }
    ) {
        this.declare = declare
    }

    constructor(declare: ValkyrieElement) : super(
        declare.firstChild,
        declare.firstChild.textRange,
        declare.getIcon(0),
        { "tooltipProvider" },
        null,
        GutterIconRenderer.Alignment.CENTER,
        Supplier<String> { "AncestorClassMark" }
    ) {
        this.declare = declare
    }


    override fun getElement(): ValkyrieElement {
        return declare
    }

    override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean {
        return info.icon == myIcon;
    }

    override fun getCommonIcon(infos: MutableList<out MergeableLineMarkerInfo<*>>): Icon {
        // TODO: if this object have testes, return test version
        return element.getIcon(0)
    }
}