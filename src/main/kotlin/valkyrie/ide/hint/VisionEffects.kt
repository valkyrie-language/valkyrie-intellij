package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieVisitor

class VisionEffects : ValkyrieCodeVision() {
    override val id: String = "hint.vision.effect.name"
    override val name: String = ValkyrieBundle.message(id)

    override fun addCodeVision(element: PsiElement, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) {
        element.accept(EffectVisitor(id, entry))
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}


private class EffectVisitor : ValkyrieVisitor {
    private val id: String
    var entry: MutableList<Pair<TextRange, CodeVisionEntry>>

    constructor(id: String, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) : super() {
        this.id = id
        this.entry = entry
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
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
