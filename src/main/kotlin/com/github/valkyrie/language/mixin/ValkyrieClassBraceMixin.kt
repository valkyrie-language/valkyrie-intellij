package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieClassBraceItem
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class ValkyrieClassBraceMixin(node: ASTNode) : ViewableNode(node),
    ValkyrieClassBraceItem {
    override fun getNavigationElement(): PsiElement {
        val index = this.classNumericKey;
        return when {
            index != null -> {
                index.lastChild
            }
            else -> this.modifierSymbols?.lastChild ?: this.originalElement
        }
    }

    override val viewName: String = this.navigationElement.text;
    override val viewIcon: Icon = AllIcons.Nodes.Field;
    override fun addChildrenView() {
//        val kind = ValkyriePresentationItem(this.navigationElement.text, AllIcons.Nodes.Variable)
//        this.childrenView.add(ValkyrieViewElement(this, kind))
    }
}

