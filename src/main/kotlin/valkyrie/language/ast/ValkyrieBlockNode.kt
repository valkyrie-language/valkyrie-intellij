package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.folding.ValkyrieNodeFolder
import valkyrie.language.psi.ValkyrieFoldableElement
import valkyrie.language.psi.types.ValkyrieBlockType


class ValkyrieBlockNode : ASTWrapperPsiElement, ValkyrieFoldableElement {
    val kind: ValkyrieBlockType

    constructor(node: CompositeElement, kind: ValkyrieBlockType) : super(node) {
        this.kind = kind
    }

    override fun on_fold(e: ValkyrieNodeFolder) {
        e.fold(this, e.findBrace(this))
    }
}

