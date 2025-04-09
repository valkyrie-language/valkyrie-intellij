package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.util.endOffset
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.lineNumber
import valkyrie.psi.node.ValkyrieDotCall

class ChainHintVisitor : ValkyrieVisitor {
    private val sink: InlayHintsSink
    private val factory: PresentationFactory
    private val setting: ChainHintSetting

    constructor(sink: InlayHintsSink, editor: Editor, setting: ChainHintSetting) : super() {
        this.sink = sink
        this.factory = PresentationFactory(editor)
        this.setting = setting
    }

    override fun visitDotCall(o: ValkyrieDotCall) {
        // 如果该行后面没有文字
        if (
            o.nextSibling == null || o.lineNumber != o.nextSibling?.lineNumber) {
            hint(o.endOffset, " any ")
        }
    }

    fun hint(start: Int, text: String) {
        sink.addInlineElement(
            start,
            true,
            factory.roundWithBackgroundAndSmallInset(factory.smallTextWithoutBackground(text)),
            true
        )
    }
}