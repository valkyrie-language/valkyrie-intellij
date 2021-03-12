package com.github.valkyrie.language.ast


import com.github.valkyrie.language.psi.startOffset
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

/// 一定是可以 view 的节点
/// PsiSymbolDeclarationProvider,
@Suppress("UnstableApiUsage")
abstract class DeclareNode(node: ASTNode) : ViewableNode(node),
    PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): PsiElement?
    override fun getName(): String {
        val id = this.nameIdentifier;
        return when {
            id != null -> id.text
            else -> node.psi.text
        }
    }

    override fun getNavigationElement(): PsiElement {
        val id = this.nameIdentifier;
        return when {
            id != null -> id
            else -> node.psi
        }
    }

    override fun getTextOffset(): Int {
        val id = this.nameIdentifier;
        return when {
            id != null -> id.textOffset
            else -> this.startOffset
        }
    }
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

