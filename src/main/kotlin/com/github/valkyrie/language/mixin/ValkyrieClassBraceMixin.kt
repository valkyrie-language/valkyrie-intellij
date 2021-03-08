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
            index != null -> index
            else -> this.modifierSymbols?.lastChild ?: this.originalElement
        }
    }

    override val viewName: String = "UNN";
    override val viewIcon: Icon = AllIcons.Nodes.Field;
    override fun addChildrenView() {
        val index = this.classNumericKey;
        if (index != null) {
            val kind = ValkyriePresentationItem(index.text, AllIcons.Nodes.Variable)
            this.childrenView.add(ValkyrieViewElement(this, kind))
            return
        }
        val mods = this.modifierSymbols;
        if (mods != null) {
            val kind = ValkyriePresentationItem(mods.lastChild.text, AllIcons.Nodes.Variable)
            this.childrenView.add(ValkyrieViewElement(this, kind))
            return
        }
    }
}

