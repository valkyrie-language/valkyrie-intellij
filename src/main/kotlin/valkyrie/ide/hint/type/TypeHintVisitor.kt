package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.refactoring.suggested.endOffset
import valkyrie.psi.node.*

@Suppress("UnstableApiUsage")
class TypeHintVisitor : ValkyrieVisitor {
    private val sink: InlayHintsSink
    private val factory: PresentationFactory
    private val setting: TypeHintSetting

    constructor(sink: InlayHintsSink, editor: Editor, setting: TypeHintSetting) : super() {
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


    override fun visitForStatement(o: ValkyrieForStatement) {
        if (setting.showForLoopType) {
//                inline(element.identifier.textRange.endOffset, "Unknown")
        }
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        if (setting.showDefineParameterType) {
            val parameter = o.parameterBody?.parameterItemList ?: listOf()
            for (parameterItem in parameter) {
                if (parameterItem.typeHint == null) {
                    parameterItem.identifier.endOffset.let { hint(it, ": Any") }
                }
            }
        }
        if (setting.showDefineReturnType) {
            if (o.returnType == null) {
                o.parameterBody?.endOffset?.let { hint(it, "⟶ Any") }
            }
            return
        }
        if (setting.showDefineEffectType) {
//            if (o.effectType == null) {
//                o.parameterBody?.endOffset?.let { hint(it, "/ Pure") }
//            }
        }
    }

    override fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        if (setting.showDefineParameterType) {
            val parameter = o.parameterBody?.parameterItemList ?: listOf()
            for (parameterItem in parameter) {
                if (parameterItem.typeHint == null) {
                    parameterItem.identifier.endOffset.let { hint(it, ": AnyNode") }
                }
            }
        }
        if (setting.showDefineReturnType) {
            if (o.returnType == null) {
                o.parameterBody?.endOffset?.let { hint(it, "⟶ AnyNode") }
            }
            return
        }
    }


    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        if (setting.showEnumerationType) {
            if (o.classInherit == null) {
                o.identifier?.endOffset?.let { hint(it, "([u8; 4])") }
            }
        }
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        if (setting.showBitFlagType) {
            if (o.classInherit == null) {
                o.identifier?.endOffset?.let { hint(it, "([u8; 4])") }
            }
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