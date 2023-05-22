package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.InlayHintsCollector
import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class LambdaHintCollector : InlayHintsCollector {
    val settings: LambdaHintSetting

    constructor(settings: LambdaHintSetting) {
        this.settings = settings
    }

    override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
        element.accept(LambdaHintVisitor(sink, editor, settings))
        return true
    }
}