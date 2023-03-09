package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement


class ValkyrieListNode : ASTWrapperPsiElement {
    val type: ListType

    constructor(node: CompositeElement, type: ListType) : super(node) {
        this.type = type
    }
}

enum class ListType {
    Ordinal,
    Offset,
}