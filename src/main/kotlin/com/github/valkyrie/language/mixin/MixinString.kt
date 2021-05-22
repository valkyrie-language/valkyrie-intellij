package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

// PsiReference
open class MixinString(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): PsiElement {
        return super.getOriginalElement()
    }
    fun getStringText(): String {
        return this.children.reversed()[2].text
    }
}

