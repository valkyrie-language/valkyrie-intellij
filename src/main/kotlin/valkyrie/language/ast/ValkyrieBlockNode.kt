package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement


enum class ValkyrieBlockKind {
    Brace,
    Bracket,
    Parenthesis
}

class ValkyrieBlockNode : ASTWrapperPsiElement {
    val kind: ValkyrieBlockKind

    constructor(node: CompositeElement, kind: ValkyrieBlockKind) : super(node) {
        this.kind = kind
    }


}

