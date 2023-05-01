package valkyrie.ide.hint

import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.refactoring.suggested.startOffset
import valkyrie.psi.node.ValkyrieArgumentBody
import valkyrie.psi.node.ValkyrieClassInherit
import valkyrie.psi.node.ValkyrieVisitor

@Suppress("UnstableApiUsage")
class ArgumentNameVisitor : ValkyrieVisitor() {
    var info: MutableList<InlayInfo> = mutableListOf()


    override fun visitClassInherit(o: ValkyrieClassInherit) {
        if (o.identifier == null) {
            val id = o.typeExpression.text.lowercase()
            hint(o.startOffset, "$id:")
        }
    }


    override fun visitArgumentBody(o: ValkyrieArgumentBody) {
        for ((i, arg) in o.argumentList.withIndex()) {
            if (arg.identifier == null) {
                hint(arg.startOffset, "${'a' + i}:")
            }
        }
    }

    fun hint(start: Int, text: String) {
        info.add(InlayInfo(text, start))
    }
}