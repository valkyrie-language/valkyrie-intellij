package com.github.valkyrie.language.ast

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.psi_node.ValkyrieMacroCallNode
import com.github.valkyrie.language.psi_node.ValkyrieMacroListNode
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.prevLeafs
import com.intellij.psi.util.siblings

open class ValkyrieASTBase(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun collectDocuments(): List<PsiElement> {
        return listOf()
    }

    fun addAnnotationView(list: MutableList<ValkyrieViewElement>) {
        for (node in this.siblings(forward = true, withSelf = false)) {
           when (node ) {
               is ValkyrieMacroListNode -> list.add(ValkyrieViewElement(node))
               is ValkyrieMacroCallNode -> list.add(ValkyrieViewElement(node))
               is PsiWhiteSpace, is PsiComment -> continue
               else -> break
           }
        }
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