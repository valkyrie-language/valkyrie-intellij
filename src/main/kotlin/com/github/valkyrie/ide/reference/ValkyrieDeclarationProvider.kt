package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi_node.ValkyrieDefineStatementNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class ValkyrieDeclarationProvider : PsiSymbolDeclarationProvider {
    override fun getDeclarations(element: PsiElement, offsetInElement: Int): MutableCollection<out PsiSymbolDeclaration> {
        return when (element) {
            is ValkyrieDefineStatementNode -> {
                element.ownDeclarations
            }
            else -> {
                element.ownDeclarations
            }
        }
    }
}

