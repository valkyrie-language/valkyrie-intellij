package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolDeclarationProvider
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class ValkyrieDeclarationProvider : PsiSymbolDeclarationProvider {
    override fun getDeclarations(element: PsiElement, offsetInElement: Int): MutableCollection<out PsiSymbolDeclaration> {
        return when (element) {
            is ValkyrieClassStatementNode -> {
                TODO("Not yet implemented $element")
            }
            else -> {
                mutableListOf()
            }
        }
    }
}

