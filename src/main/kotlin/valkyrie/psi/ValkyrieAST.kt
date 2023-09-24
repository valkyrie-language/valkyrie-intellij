package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

class ValkyrieAST(show: String) : IElementType(show, ValkyrieLanguage) {
    override fun toString(): String = "${ValkyrieAST::class.simpleName}<${super.toString()}>"
}