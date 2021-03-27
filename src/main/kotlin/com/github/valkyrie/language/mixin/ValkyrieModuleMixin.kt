package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieModuleStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class ValkyrieModuleMixin(node: ASTNode) : DeclareNode(node),
    ValkyrieModuleStatement {
    override fun getNameIdentifier(): PsiElement? {
        return this.identifier
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override val viewIcon: Icon? = AllIcons.Nodes.Module
    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {

    }
}

