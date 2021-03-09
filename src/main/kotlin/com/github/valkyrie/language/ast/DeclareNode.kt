package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.mixin.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import javax.swing.Icon

interface DeclareNode: PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset
}

