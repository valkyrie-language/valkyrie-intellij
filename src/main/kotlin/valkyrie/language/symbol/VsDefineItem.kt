package valkyrie.language.symbol

import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.psi.PsiElement

class VsDefineItem(override val target: ValkyrieIdentifierNode) : ValkyrieDeclaration(target) {
    constructor(target: ValkyrieIdentifier) : this(target as ValkyrieIdentifierNode) {

    }
    override fun getDeclaringElement(): PsiElement {
        return super.getDeclaringElement()
    }
}
