package valkyrie.language.symbol

import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.psi.PsiElement

class VsMethod(override val target: ValkyrieIdentifierNode) : ValkyrieSymbol(target) {
    constructor(target: ValkyrieIdentifier) : this(target as ValkyrieIdentifierNode) {

    }
    override fun getDeclaringElement(): PsiElement {
        return super.getDeclaringElement()
    }
}
