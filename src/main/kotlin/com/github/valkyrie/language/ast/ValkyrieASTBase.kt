package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil

open class ValkyrieASTBase(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun collectDocuments(): List<PsiElement> {
        return listOf()
    }

    fun collectAnnotations(): List<PsiElement> {
        return listOf()
    }

    open fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        for (item in PsiTreeUtil.getChildrenOfTypeAsList(this, NavigatablePsiElement::class.java)) {
            childrenView.add(ValkyrieViewElement(item))
        }
        return childrenView.toTypedArray()
    }

    open fun getChildrenSymbol(name: List<String>): ValkyrieASTBase? {
        return when (name.count()) {
            0 -> this
            else -> null
        }
    }

    override fun getReference(): ValkyrieReference? = this.references.firstOrNull()
    override fun getReferences(): Array<ValkyrieReference> = emptyArray()
}