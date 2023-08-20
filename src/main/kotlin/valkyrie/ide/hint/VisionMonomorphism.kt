package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.mixin.keyword
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieDeclareTrait
import valkyrie.psi.node.ValkyrieVisitor

class VisionMonomorphism : ValkyrieCodeVision() {
    override val id: String = "hint.vision.monomorphism.name"
    override val name: String = ValkyrieBundle.message(id)

    override fun addCodeVision(element: PsiElement, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) {
        element.accept(MonomorphismVisitor(id, entry))
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}

private class MonomorphismVisitor : ValkyrieVisitor {
    private val id: String
    var entry: MutableList<Pair<TextRange, CodeVisionEntry>>

    constructor(id: String, entry: MutableList<Pair<TextRange, CodeVisionEntry>>) : super() {
        this.id = id
        this.entry = entry
    }


    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        if (o.declareGeneric != null) {
            entry.add(
                o.keyword.textRange to TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Nodes.CopyOfFolder,
                    "VisionMonomorphism",
                    "tooltip",
                    listOf()
                )
            )
        }
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        if (o.declareGeneric != null) {
            entry.add(
                o.keyword.textRange to TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Nodes.CopyOfFolder,
                    "VisionMonomorphism",
                    "tooltip",
                    listOf()
                )
            )
        }
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        if (o.declareGeneric != null) {
            entry.add(
                o.identifier.textRange to TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Nodes.CopyOfFolder,
                    "VisionMonomorphism",
                    "tooltip",
                    listOf()
                )
            )
        }
    }
}