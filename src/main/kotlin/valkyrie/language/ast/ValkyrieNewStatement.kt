package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement

class ValkyrieNewStatement(node: CompositeElement) : ASTWrapperPsiElement(node) {
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
}