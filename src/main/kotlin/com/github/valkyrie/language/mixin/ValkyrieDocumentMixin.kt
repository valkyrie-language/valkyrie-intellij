package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DocumentNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

// PsiReference
abstract class ValkyrieDocumentMixin(node: ASTNode) : DocumentNode(node) {
    override fun getOwner(): PsiElement? {
        TODO("Not yet implemented")
    }
}

