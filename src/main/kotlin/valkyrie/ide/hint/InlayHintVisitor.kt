package valkyrie.ide.hint

import com.intellij.codeInsight.hints.declarative.EndOfLinePosition
import com.intellij.codeInsight.hints.declarative.InlayActionData
import com.intellij.codeInsight.hints.declarative.InlayTreeSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.util.endOffset

import valkyrie.psi.node.ValkyrieVisitor

abstract class InlayHintVisitor : ValkyrieVisitor {
    protected val sink: InlayTreeSink
    protected val editor: Editor
    protected val factory: PresentationFactory

    constructor(sink: InlayTreeSink, editor: Editor) : super() {
        this.sink = sink
        this.editor = editor
        this.factory = PresentationFactory(editor)
    }

    protected fun PsiElement.hintEndOfLine(text: String, tooltip: String? = null, actionData: InlayActionData? = null) {
        val eol = EndOfLinePosition(editor.document.getLineNumber(this.endOffset));
        sink.addPresentation(eol, null, tooltip, false) {
            this.text(text, actionData)
        }
    }
}