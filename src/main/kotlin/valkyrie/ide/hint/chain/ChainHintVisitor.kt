package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.refactoring.suggested.endOffset
import valkyrie.psi.node.ValkyrieDotCall
import valkyrie.psi.node.ValkyrieDotCallInline
import valkyrie.psi.node.ValkyrieVisitor

@Suppress("UnstableApiUsage")
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
        hint(o.endOffset, "Iterator<Item=Any>")
    }

    override fun visitDotCallInline(o: ValkyrieDotCallInline) {
        super.visitDotCallInline(o)
    }

    fun hint(start: Int, text: String) {
        sink.addInlineElement(
            start, true,
            // click then replace
            factory.roundWithBackgroundAndSmallInset(factory.smallTextWithoutBackground(text)), false
        )
    }
}