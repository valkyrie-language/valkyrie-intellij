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
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieImplyStatement

class ValkyrieImplementerVisionProvider : DaemonBoundCodeVisionProvider {
    override val defaultAnchor: CodeVisionAnchorKind
        get() = CodeVisionAnchorKind.Default
    override val groupId: String
        get() = "implements"
    override val id: String
        get() = "valkyrie.implementers"
    override val name: String
        get() = "Valkyrie Implementers"
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
        
        // 查找所有 class 声明
        PsiTreeUtil.findChildrenOfType(file, ValkyrieClassDeclaration::class.java).forEach { classDecl ->
            val className = classDecl.getName()
            if (className != null) {
                // 查找该 class 的所有 trait 实现
                val implementations = PsiTreeUtil.findChildrenOfType(file, ValkyrieImplyStatement::class.java)
                    .filter { it.getTargetType()?.text == className }
                
                if (implementations.isNotEmpty()) {
                    val implText = when (implementations.size) {
                        1 -> "1 impl"
                        else -> "${implementations.size} impls"
                    }
                    
                    val entry = ClickableTextCodeVisionEntry(
                        implText,
                        id,
                        onClick = { _, _ ->
                            // 显示详细的实现信息
                            val traitNames = implementations.mapNotNull { it.getTraitName() }
                            val message = "Trait implementations: ${traitNames.joinToString(", ")}"
                            Messages.showInfoMessage(file.project, message, "Implementation Information")
                        }
                    )
                    
                    val range = classDecl.textRange
                    results.add(Pair(range, entry))
                }
            }
        }
        
        return results
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {
        super.handleClick(editor, textRange, entry)
    }
}

