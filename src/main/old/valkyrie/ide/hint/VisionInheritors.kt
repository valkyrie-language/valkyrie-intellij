package valkyrie.ide.hint

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.settings.PlatformCodeVisionIds
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.ast.classes.ValkyrieClassFieldNode
import valkyrie.language.ast.classes.ValkyrieClassMethodNode
import valkyrie.language.ast.classes.ValkyrieClassStatement


class VisionInheritors : ValkyrieCodeVision() {
    override val groupId: String = PlatformCodeVisionIds.INHERITORS.key
    override val id: String = "VisionReferences"
    override val name: String = CodeInsightBundle.message("settings.inlay.hints.inheritors")

    /// Removed, it is recommended to use shortcut keys to jump
    override fun getCodeVision(element: PsiElement): CodeVisionEntry? {
        return when (element) {
            is ValkyrieClassStatement, is ValkyrieTraitStatement -> {
                null
            }

            is ValkyrieClassMethodNode, is ValkyrieClassFieldNode -> {
                null
            }

            else -> null
        }
    }
}

