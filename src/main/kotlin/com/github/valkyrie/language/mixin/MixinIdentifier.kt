package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.intellij.lang.ASTNode

abstract class MixinIdentifier(node: ASTNode) : ValkyrieElement(node),
    // PsiPolyVariantReference,
    ValkyrieIdentifier {

//    override fun getNameIdentifier(): PsiElement? {
//        return this.element
//    }
//
//    override val viewIcon: Icon?
//        get() = TODO("Not yet implemented")
//
//    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {
//        TODO("Not yet implemented")
//    }
//
//    override fun setName(name: String): PsiElement {
//        TODO("Not yet implemented")
//    }

}

