package valkyrie.ide.hint

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.codeInsight.codeVision.CodeVisionEntry
import com.intellij.codeInsight.codeVision.settings.PlatformCodeVisionIds
import com.intellij.codeInsight.completion.CompletionData
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieDeclareClass
import valkyrie.psi.node.ValkyrieDeclareTrait


class VisionInheritors : ValkyrieCodeVision() {
    override val groupId: String = PlatformCodeVisionIds.INHERITORS.key
    override val id: String = "VisionReferences"
    override val name: String = CodeInsightBundle.message("settings.inlay.hints.inheritors")

    /// Removed, it is recommended to use shortcut keys to jump
    override fun getCodeVision(element: PsiElement): CodeVisionEntry? {
        return when (element) {
            is ValkyrieDeclareClass, is ValkyrieDeclareTrait -> {
                null
            }

//            is ValkyrieDeclareClass, is ValkyrieClassFieldNode -> {
//                null
//            }

            else -> null
        }
    }
}

//class A : CodeVisionProvider<PsiElement> {
//    override val defaultAnchor: CodeVisionAnchorKind
//        get() = TODO("Not yet implemented")
//    override val id: String
//        get() = TODO("Not yet implemented")
//    override val name: String
//        get() = TODO("Not yet implemented")
//    override val relativeOrderings: List<CodeVisionRelativeOrdering>
//        get() = TODO("Not yet implemented")
//
//    override fun precomputeOnUiThread(editor: Editor): PsiElement {
//        TODO("Not yet implemented")
//    }
//
//}

