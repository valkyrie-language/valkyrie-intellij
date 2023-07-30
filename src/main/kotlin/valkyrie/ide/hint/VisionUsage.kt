package valkyrie.ide.hint

//import valkyrie.language.psi_node.ValkyrieDefineStatementNode
//import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
//import valkyrie.language.psi_node.ValkyrieUnionStatementNode
import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.settings.PlatformCodeVisionIds
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareTrait


class VisionUsage : ValkyrieCodeVision() {
    override val groupId = PlatformCodeVisionIds.USAGES.key
    override val id = "VisionReferences"
    override val name = CodeInsightBundle.message("settings.inlay.hints.usages")
    /// Removed, it is recommended to click on the mark on the left to jump to find usages
    override fun getCodeVision(element: PsiElement): CodeVisionEntry? {
        return when (element) {
            is ValkyrieDeclareClass, is ValkyrieDeclareTrait -> {
                null
            }
            else -> null
        }
    }
}

