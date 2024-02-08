package valkyrie.ide.code_vision

import com.intellij.codeInsight.codeVision.CodeVisionAnchorKind
import com.intellij.codeInsight.codeVision.CodeVisionRelativeOrdering
import com.intellij.codeInsight.hints.codeVision.DaemonBoundCodeVisionProvider

class EffectVisionProvider : DaemonBoundCodeVisionProvider {
    override val defaultAnchor: CodeVisionAnchorKind
        get() = CodeVisionAnchorKind.Default
    override val id: String
        get() = TODO("Not yet implemented")
    override val name: String
        get() = TODO("Not yet implemented")
    override val relativeOrderings: List<CodeVisionRelativeOrdering>
        get() = TODO("Not yet implemented")
}
