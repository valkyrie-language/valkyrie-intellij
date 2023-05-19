package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.InlayHintsCollector
import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class TypeHintCollector(val settings: TypeHintSetting) : InlayHintsCollector {
    override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
        element.accept(TypeHintVisitor(sink, editor, settings))
        return true
    }
}