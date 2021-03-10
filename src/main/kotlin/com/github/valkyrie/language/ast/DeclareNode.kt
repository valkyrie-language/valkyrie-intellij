package com.github.valkyrie.language.ast


import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

/// 一定是可以 view 的节点
/// PsiSymbolDeclarationProvider
abstract class DeclareNode(node: ASTNode) : ViewableNode(node),
    PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): PsiElement
    override fun getName(): String = this.nameIdentifier.text
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset
}

