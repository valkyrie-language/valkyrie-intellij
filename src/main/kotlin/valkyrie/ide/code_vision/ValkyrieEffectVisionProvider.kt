package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionPlaceholderCollector
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile

class ValkyrieEffectVisionProvider : DaemonBoundCodeVisionProvider {
    override val defaultAnchor: CodeVisionAnchorKind
        get() = CodeVisionAnchorKind.Default
    override val groupId: String
        get() = "effects"
    override val id: String
        get() = "valkyrie.effects"
    override val name: String
        get() = "Valkyrie Effects"
    override val relativeOrderings: List<CodeVisionRelativeOrdering>
        get() = emptyList()

    override fun getPlaceholderCollector(editor: Editor, psiFile: PsiFile?): CodeVisionPlaceholderCollector? {
        return super.getPlaceholderCollector(editor, psiFile)
    }

    override fun preparePreview(editor: Editor, file: PsiFile) {
        super.preparePreview(editor, file)
    }

    override fun computeForEditor(editor: Editor, file: PsiFile): List<Pair<TextRange, CodeVisionEntry>> {
        return super.computeForEditor(editor, file)
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {
        super.handleClick(editor, textRange, entry)
    }
}
