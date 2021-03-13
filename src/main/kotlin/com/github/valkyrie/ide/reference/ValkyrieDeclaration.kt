package com.github.valkyrie.ide.reference

import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class ValkyrieDeclaration(var declaration: PsiElement) : PsiSymbolDeclaration {
    override fun getDeclaringElement(): PsiElement {
        return declaration
    }

    override fun getRangeInDeclaringElement(): TextRange {
        return this.declaringElement.textRange
    }

    override fun getSymbol(): Symbol {
        TODO("Not yet implemented")
    }
}