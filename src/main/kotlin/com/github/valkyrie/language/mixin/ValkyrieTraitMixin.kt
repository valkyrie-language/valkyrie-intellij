package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTaggedItem
import com.github.valkyrie.language.psi.ValkyrieTraitStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.model.psi.PsiSymbolReference
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

abstract class ValkyrieTraitMixin(node: ASTNode) : DeclareNode(node),
    ValkyrieTraitStatement {
    override fun getNameIdentifier(): PsiElement = this.modifierSymbols.lastChild
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val viewIcon: Icon? = AllIcons.Nodes.Interface
    override fun getViewName(): String {
        val name = this.modifierSymbols.lastChild.text;
        val ty = this.typeExpression;
        return when {
            ty != null -> "${name}: ${ty.text}"
            else -> name
        }
    }
    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {
        PsiTreeUtil.getChildrenOfTypeAsList(
            this.traitBlock,
            NavigatablePsiElement::class.java
        ).forEach {
            if (it is ValkyrieTaggedItem) {
                val kind = ValkyriePresentationItem(it.identifier.text, AllIcons.Nodes.Variable)
                childrenView.add(ValkyrieViewElement(it, kind))
            }
        }
    }
}

