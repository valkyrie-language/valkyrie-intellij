package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.CodeVisionPlaceholderCollector
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.codeVision.ui.model.ClickableTextCodeVisionEntry
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieFileNode
import valkyrie.psi.nodes.ValkyrieCatchStatement

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
        if (file !is ValkyrieFileNode) return emptyList()
        
        val results = mutableListOf<Pair<TextRange, CodeVisionEntry>>()
        
        // 查找所有 catch 语句
        PsiTreeUtil.findChildrenOfType(file, ValkyrieCatchStatement::class.java).forEach { catchStmt ->
            val effects = catchStmt.getHandledEffects()
            if (effects.isNotEmpty()) {
                val effectText = when (effects.size) {
                    1 -> "1 effect"
                    else -> "${effects.size} effects"
                }
                
                val entry = ClickableTextCodeVisionEntry(
                    effectText,
                    id,
                    onClick = { _, _ ->
                        // 显示详细的 effect 信息
                        val message = "Effects handled: ${effects.joinToString(", ")}"
                        Messages.showInfoMessage(file.project, message, "Effect Information")
                    }
                )
                
                val range = catchStmt.textRange
                results.add(Pair(range, entry))
            }
        }
        
        return results
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {
        super.handleClick(editor, textRange, entry)
    }
}
