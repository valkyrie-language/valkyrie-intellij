package valkyrie.ide.hint

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.settings.PlatformCodeVisionIds
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieControlRaise
import valkyrie.psi.node.ValkyrieVisitor


class VisionHandler : ValkyrieCodeVision() {
    override val groupId: String = PlatformCodeVisionIds.INHERITORS.key
    override val id: String = "VisionReferences"
    override val name: String = CodeInsightBundle.message("settings.inlay.hints.inheritors")

    override fun addCodeVision(element: PsiElement, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) {
        element.accept(HandlerVisitor(id, entry))
    }
}

private class HandlerVisitor : ValkyrieVisitor {
    private val id: String
    var entry: MutableList<Pair<TextRange, CodeVisionEntry>>

    constructor(id: String, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) : super() {
        this.id = id
        this.entry = entry
    }

    override fun visitControlRaise(o: ValkyrieControlRaise) {
        entry.add(
            o.textRange to TextCodeVisionEntry(
                ValkyrieBundle.message(id, '?'),
                id,
                ValkyrieIconProvider.Instance.Effect,
                "longPresentation",
                "Tooltip",
                listOf()
            )
        )
    }
}
