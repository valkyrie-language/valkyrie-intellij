package valkyrie.ide.hint

import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.ui.model.TextCodeVisionEntry
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import yggdrasil.psi.node.ValkyrieDeclareClass
import yggdrasil.psi.node.ValkyrieDeclareMethod
import yggdrasil.psi.node.ValkyrieDeclareTrait

class VisionMonomorphism : ValkyrieCodeVision() {
    override val id: String = "hint.vision.monomorphism.name"
    override val name: String = ValkyrieBundle.message(id)
    override fun getCodeVision(element: PsiElement): TextCodeVisionEntry? {
        when (element) {
            is ValkyrieDeclareClass, is ValkyrieDeclareTrait -> {
                return TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.Nodes.CopyOfFolder,
                    "VisionMonomorphism",
                    "tooltip",
                    listOf()
                )
            }

            is ValkyrieDeclareMethod -> {
                return TextCodeVisionEntry(
                    ValkyrieBundle.message(id, '?'),
                    id,
                    AllIcons.General.InlineCopy,
                    "VisionMonomorphism",
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

