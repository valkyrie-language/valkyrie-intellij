package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.ResolveResult

abstract class MixinIdentifier(node: ASTNode) : ValkyrieElement(node),
    PsiPolyVariantReference,
    ValkyrieIdentifier {
    override fun getElement(): PsiElement {
        return node.psi
    }

    override fun getRangeInElement(): TextRange {
        return this.element.textRange
    }

    override fun resolve(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getCanonicalText(): String {
        return "getCanonicalText"
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        TODO("Not yet implemented $element")
    }

    override fun isSoft(): Boolean {
        TODO("Not yet implemented")
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        TODO("Not yet implemented")
    }

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

