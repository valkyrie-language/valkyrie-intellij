package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.ast.classes.ValkyrieClassMethodNode
import valkyrie.language.ast.classes.ValkyrieClassStatement

class VisionMonomorphisms : ValkyrieCodeVision() {
    override val id: String = "hint.vision.monomorphism.name"
    override val name: String = ValkyrieBundle.message(id)
    override fun getCodeVision(element: PsiElement): TextCodeVisionEntry? {
        when (element) {
            is ValkyrieClassStatement, is ValkyrieTraitStatement -> {
                return TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Nodes.CopyOfFolder,
                    "VisionMonomorphisms",
                    "tooltip",
                    listOf()
                )
            }

            is ValkyrieClassMethodNode -> {
                return TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.General.InlineCopy,
                    "VisionMonomorphisms",
                    "tooltip",
                    listOf()
                )
            }


            else -> return null
        }
    }

    override fun handleClick(editor: Editor, textRange: TextRange, entry: CodeVisionEntry) {

    }
}

