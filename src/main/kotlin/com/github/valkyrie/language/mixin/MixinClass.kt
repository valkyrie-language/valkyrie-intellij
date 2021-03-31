package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi_node.ValkyrieClassBraceItemNode
import com.github.valkyrie.language.psi_node.ValkyrieClassTupleNode
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

// PsiReference
abstract class MixinClass(node: ASTNode) : DeclareNode(node),
    ValkyrieClassStatement {
    override fun getNameIdentifier(): PsiElement = this.modifierSymbols.lastChild
    override fun setName(name: String): PsiElement {
        return this.nameIdentifier
    }
    override val viewIcon: Icon = AllIcons.Nodes.Class;
    override fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {
        for (it in this.braceItemList) {
            childrenView.add(ValkyrieViewElement(it as NavigatablePsiElement))
        }
        for (it in this.tupleItemList) {
            childrenView.add(ValkyrieViewElement(it as NavigatablePsiElement))
        }
    }
}

