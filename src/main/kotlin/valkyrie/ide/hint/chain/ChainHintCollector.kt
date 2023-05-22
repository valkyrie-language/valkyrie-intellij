package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.InlayHintsCollector
import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class ChainHintCollector : InlayHintsCollector {
    val settings: ChainHintSetting

    constructor(settings: ChainHintSetting) {
        this.settings = settings
    }

    override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
        element.accept(ChainHintVisitor(sink, editor, settings))
        return true
    }
}