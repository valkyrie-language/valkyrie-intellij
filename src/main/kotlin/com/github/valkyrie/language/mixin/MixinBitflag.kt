package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.psi.ValkyrieBitflagStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinBitflag(node: ASTNode) : DeclareNode(node),
    ValkyrieBitflagStatement {
    override fun getNameIdentifier(): PsiElement = this.symbol

    override val viewIcon: Icon = AllIcons.Nodes.Enum

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
    override fun getChildrenView(): Array<TreeElement> {
        return super.getChildrenView()
    }
}

