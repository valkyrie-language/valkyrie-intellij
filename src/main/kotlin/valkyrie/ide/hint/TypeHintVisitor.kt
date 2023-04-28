package valkyrie.ide.hint

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.refactoring.suggested.endOffset
import valkyrie.ide.hint.TypeHintProvider.InlayTypeSetting
import valkyrie.psi.node.*

@Suppress("UnstableApiUsage")
class TypeHintVisitor : ValkyrieVisitor {
    private val sink: InlayHintsSink
    private val factory: PresentationFactory
    private val setting: InlayTypeSetting

    constructor(sink: InlayHintsSink, editor: Editor, setting: InlayTypeSetting) : super() {
        this.sink = sink
        this.factory = PresentationFactory(editor)
        this.setting = setting
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        if (setting.showClassFieldType) {
            return
        }

        if (o.typeHint == null) {
            hint(o.identifier.endOffset, ": Any")
        }
    }


    override fun visitForStatement(o: ValkyrieForStatement) {
//            settings.showForLoopType && element is ValkyriePatternItemNode -> {
//                inline(element.identifier.textRange.endOffset, "Unknown")
//            }
    }

    override fun visitReturnType(o: ValkyrieReturnType) {
//            settings.showDefineReturnType && element is ValkyrieDefineStatementNode -> {
//                if (element.returnType == null) {
//                    element.defineTuple?.textRange?.let {
//                        inline(it.endOffset, "Unknown", split = "⟶")
//                    }
//                }
//            }
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
//
//            settings.showDefineParameterType && element is ValkyrieDefineItemNode -> {
//                val id = element.identifier ?: return true;
//                if (id.text == "self") {
//                    // skip
//                } else if (element.typeExpression == null) {
//                    id.textRange?.let {
//                        inline(it.endOffset, "Unknown")
//                    }
//                }
//            }
//

    }


    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        super.visitDeclareEnumerate(o)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
//            settings.showBitFlagType && element is ValkyrieBitflagStatementNode -> {
//                if (element.typeExpression == null) {
//                    inline(element.identifier.textRange.endOffset, "u32")
//                }
//            }
    }

    fun hint(start: Int, text: String) {
        sink!!.addInlineElement(
            start, true,
            // click then replace
            factory!!.roundWithBackgroundAndSmallInset(factory!!.smallTextWithoutBackground(text)), false
        )
    }
}