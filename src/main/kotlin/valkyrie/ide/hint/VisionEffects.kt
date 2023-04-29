package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieVisitor

class VisionEffects : ValkyrieCodeVision() {
    override val id: String = "hint.vision.effect.name"
    override val name: String = ValkyrieBundle.message(id)

    override fun getCodeVision(element: PsiElement): TextCodeVisionEntry? {
        val visit = EffectVisitor(id)
        element.accept(visit)
        return visit.vision
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}


private class EffectVisitor : ValkyrieVisitor {
    private val id: String
    var vision: TextCodeVisionEntry? = null

    constructor(id: String) : super() {
        this.id = id
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        TextCodeVisionEntry(
            ValkyrieBundle.message(id, '?'),
            id,
            AllIcons.Actions.DiagramDiff,
            "longPresentation",
            "Tooltip",
            listOf()
        )
    }
}