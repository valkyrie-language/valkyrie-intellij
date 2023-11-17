package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.InlayHintsSink
import com.intellij.codeInsight.hints.presentation.PresentationFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.util.endOffset
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieDeclareEnumerateNode
import valkyrie.ast.node.ValkyrieFunctionDeclareNode
import valkyrie.ast.node.ValkyrieMacroDeclarationNode
import valkyrie.ast.node.ValkyrieObjectFieldNode

import valkyrie.psi.node.*


class TypeHintVisitor : ValkyrieVisitor {
    private val sink: InlayHintsSink
    private val factory: PresentationFactory
    private val setting: TypeHintSetting

    constructor(sink: InlayHintsSink, editor: Editor, setting: TypeHintSetting) : super() {
        this.sink = sink
        this.factory = PresentationFactory(editor)
        this.setting = setting
    }

    override fun visitObjectField(o: ValkyrieObjectFieldNode) {
        if (!setting.show_class_field_type) {
            return
        }

//        if (o.typeHint == null) {
//            hint(o.identifierFree.endOffset, ": Any")
//        }
    }


    override fun visitLoopStatement(o: ValkyrieLoopStatement) {
        if (setting.show_loop_each_types) {
//                inline(element.identifier.textRange.endOffset, "Unknown")
        }
    }

    override fun visitDeclareFunction(o: ValkyrieFunctionDeclareNode) {
        if (setting.show_define_parameter_type) {
            val parameter = o.parameters
            for (parameterItem in parameter) {
                if (parameterItem.typeHint == null) {
                    parameterItem.identifier?.endOffset?.let { hint(it, ": Any") }
                }
            }
        }
        if (setting.show_define_return_type) {
            if (o.returnType == null) {
                o.parameterBody?.endOffset?.let { hint(it, "⟶ Any") }
            }
            return
        }
        if (setting.show_define_effect_type) {
            if (o.effectType == null) {
                o.parameterBody?.endOffset?.let { hint(it, "/ Pure") }
            }
        }
    }

    override fun visitDeclareMacro(o: ValkyrieMacroDeclarationNode) {
        if (setting.show_define_parameter_type) {
            for (parameterItem in o.parameters) {
                if (parameterItem.typeHint == null) {
                    parameterItem.identifier?.endOffset?.let { hint(it, ": AnyNode") }
                }
            }
        }
        if (setting.show_define_return_type) {
            if (o.returnType == null) {
                o.parameterBody?.endOffset?.let { hint(it, "⟶ AnyNode") }
            }
            return
        }
    }

    override fun visitDeclareEnums(o: ValkyrieDeclareEnumerateNode) {
        if (setting.show_enumeration_type) {
//            if (o.typeAtomic == null) {
//                o.identifierSafe?.endOffset?.let { hint(it, "= 32") }
//            }
        }
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        if (setting.show_bitflags_type) {
            if (o.typeAtomic == null) {
                o.identifierFree?.endOffset?.let { hint(it, "= 32") }
            }
        }
    }

    fun hint(start: Int, text: String) {
        sink.addInlineElement(
            start,
            true,
            // click then replace
            factory.roundWithBackgroundAndSmallInset(factory.smallTextWithoutBackground(text)),
            false
        )
    }
}