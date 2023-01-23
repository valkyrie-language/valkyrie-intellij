package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement

class ValkyrieCallArgument(node: CompositeElement) : ASTWrapperPsiElement(node) {
    val key by lazy { ValkyrieIdentifierNode.find(this) }

}