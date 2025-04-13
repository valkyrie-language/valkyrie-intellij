package valkyrie.ide.hint

import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.psi.util.startOffset
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieInheritItemNode
import valkyrie.psi.node.ValkyrieArgumentBody


class ArgumentNameVisitor : ValkyrieVisitor() {
    var info: MutableList<InlayInfo> = mutableListOf()

    override fun visitInheritItem(o: ValkyrieInheritItemNode) {
        if (o.identifier == null) {
//            val id = o.typeExpression.text.lowercase()
//            hint(o.startOffset, "$id:")
        }
    }


    override fun visitArgumentBody(o: ValkyrieArgumentBody) {
        for ((i, arg) in o.argumentList.withIndex()) {
            if (arg.identifierSafe == null) {
                hint(arg.startOffset, "${'a' + i}:")
            }
        }
    }

    fun hint(start: Int, text: String) {
        info.add(InlayInfo(text, start))
    }
}