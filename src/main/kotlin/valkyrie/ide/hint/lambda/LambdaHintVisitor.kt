package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import valkyrie.psi.node.ValkyrieVisitor


class LambdaHintVisitor : ValkyrieVisitor {
    private val sink: InlayHintsSink
    private val factory: PresentationFactory
    private val setting: LambdaHintSetting

    constructor(sink: InlayHintsSink, editor: Editor, setting: LambdaHintSetting) : super() {
        this.sink = sink
        this.factory = PresentationFactory(editor)
        this.setting = setting
    }


    fun hint(start: Int, text: String) {
        sink.addInlineElement(
            start, true,
            // click then replace
            factory.roundWithBackgroundAndSmallInset(factory.smallTextWithoutBackground(text)), false
        )
    }
}