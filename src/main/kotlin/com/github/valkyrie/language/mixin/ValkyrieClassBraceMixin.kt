package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieBitflagStatement
import com.github.valkyrie.language.psi.ValkyrieClassBraceItem
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class ValkyrieClassBraceMixin(node: ASTNode) : ViewableNode(node),
    ValkyrieClassBraceItem {
    override val viewName: String = "UNN";
    override val viewIcon: Icon = AllIcons.Nodes.Unknown;
    override fun addChildrenView() {

    }
}

