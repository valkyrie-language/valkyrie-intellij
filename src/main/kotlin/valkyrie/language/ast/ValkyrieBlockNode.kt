package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.language.psi.types.ValkyrieBlockType


class ValkyrieBlockNode : ASTWrapperPsiElement {
    val kind: ValkyrieBlockType

    constructor(node: CompositeElement, kind: ValkyrieBlockType) : super(node) {
        this.kind = kind
    }


}

