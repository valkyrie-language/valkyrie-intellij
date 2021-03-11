package com.github.valkyrie.language.ast


import com.intellij.lang.ASTNode
import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

/// 一定是可以 view 的节点
/// PsiSymbolDeclarationProvider, PsiSymbolDeclaration
@Suppress("UnstableApiUsage")
abstract class DeclareNode(node: ASTNode) : ViewableNode(node),
    PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): PsiElement
    override fun getName(): String = this.nameIdentifier.text
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset
//    override fun getDeclaringElement(): PsiElement {
//        return this.nameIdentifier
//    }
//
//    override fun getRangeInDeclaringElement(): TextRange {
//        return this.declaringElement.textRange
//    }
//
//    override fun getSymbol(): Symbol {
//        TODO("Not yet implemented")
//    }
}

