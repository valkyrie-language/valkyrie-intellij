package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTaggedItem
import com.github.valkyrie.language.psi.ValkyrieTaggedStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

abstract class ValkyrieEnumMixin(node: ASTNode) : ViewableNode(node),
    PsiNameIdentifierOwner,
    ValkyrieTaggedStatement {
    override fun getName(): String = this.nameIdentifier.text

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement {
        return this.modifierSymbols.lastChild
    }
    override fun getNavigationElement(): PsiElement = this.nameIdentifier
    override fun getTextOffset(): Int = this.nameIdentifier.textOffset


    override val viewName: String = this.navigationElement.text;
    override val viewIcon: Icon = AllIcons.Nodes.Enum;
    override fun addChildrenView() {
        PsiTreeUtil.getChildrenOfTypeAsList(
            this.taggedBlock,
            NavigatablePsiElement::class.java
        ).forEach {
            if (it is ValkyrieTaggedItem) {
                val kind = ValkyriePresentationItem(it.symbol.text, AllIcons.Nodes.Variable)
                this.childrenView.add(ValkyrieViewElement(it, kind))
            }
        }
    }
}

