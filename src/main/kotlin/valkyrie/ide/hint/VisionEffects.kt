package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ast.ValkyrieFunctionStatement
import valkyrie.language.ast.classes.ValkyrieClassMethodNode

class VisionEffects : ValkyrieCodeVision() {
    override val id: String = "hint.vision.effect.name"
    override val name: String = ValkyrieBundle.message(id)

    override fun getCodeVision(element: PsiElement): TextCodeVisionEntry? {
        when (element) {
            is ValkyrieFunctionStatement -> {
                return TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Actions.DiagramDiff,
                    "longPresentation",
                    "Tooltip",
                    listOf()
                )
            }

            is ValkyrieClassMethodNode -> {
                return TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Actions.DiagramDiff,
                    "longPresentation",
                    "Tooltip",
                    listOf()
                )
            }


            else -> return null
        }
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}