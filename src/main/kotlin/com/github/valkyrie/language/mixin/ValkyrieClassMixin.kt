package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

// PsiReference
abstract class ValkyrieClassMixin(node: ASTNode) : ValkyrieElement(node),
    PsiNameIdentifierOwner,
    PsiSymbolDeclarationProvider,
    NavigatablePsiElement,
    ValkyrieClassStatement {
    override fun getName(): String = this.nameIdentifier.text
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement = this.modifiers.lastChild
    override fun getNavigationElement(): PsiElement = this.nameIdentifier

    override fun getDeclarations(
        element: PsiElement,
        offsetInElement: Int,
    ): MutableCollection<out PsiSymbolDeclaration> {
        TODO("Not yet implemented")
    }

    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.modifiers.lastChild.text,
        AllIcons.Nodes.Class
    )
}

