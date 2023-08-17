package valkyrie.ide.hint

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.settings.PlatformCodeVisionIds
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieVisitor


class VisionInheritors : ValkyrieCodeVision() {
    override val groupId: String = PlatformCodeVisionIds.INHERITORS.key
    override val id: String = "VisionReferences"
    override val name: String = CodeInsightBundle.message("settings.inlay.hints.inheritors")

    override fun addCodeVision(element: PsiElement, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) {
        element.accept(InheritorsVisitor(id, entry))
    }
}

private class InheritorsVisitor : ValkyrieVisitor {
    private val id: String
    var entry: MutableList<Pair<TextRange, CodeVisionEntry>>

    constructor(id: String, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) : super() {
        this.id = id
        this.entry = entry
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
//        entry.add(
//            o.textRange to TextCodeVisionEntry(
//                ValkyrieBundle.message(id, '?'),
//                id,
//                ValkyrieIconProvider.Instance.Effect,
//                "longPresentation",
//                "Tooltip",
//                listOf()
//            )
//        )
    }
}