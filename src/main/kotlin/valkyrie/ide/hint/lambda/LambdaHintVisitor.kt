package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.refactoring.suggested.endOffset
import valkyrie.psi.node.ValkyrieDeclareField
import valkyrie.psi.node.ValkyrieVisitor

@Suppress("UnstableApiUsage")
class LambdaHintVisitor : ValkyrieVisitor {
    private val sink: InlayHintsSink
    private val factory: PresentationFactory
    private val setting: LambdaHintSetting

    constructor(sink: InlayHintsSink, editor: Editor, setting: LambdaHintSetting) : super() {
        this.sink = sink
        this.factory = PresentationFactory(editor)
        this.setting = setting
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        if (!setting.showClassFieldType) {
            return
        }

        if (o.typeHint == null) {
            hint(o.identifier.endOffset, ": Any")
        }
    }

    fun hint(start: Int, text: String) {
        sink.addInlineElement(
            start, true,
            // click then replace
            factory.roundWithBackgroundAndSmallInset(factory.smallTextWithoutBackground(text)), false
        )
    }
}