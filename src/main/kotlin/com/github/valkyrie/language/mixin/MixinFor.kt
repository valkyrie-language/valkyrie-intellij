package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.ast.addChildrenView
import com.github.valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.github.valkyrie.language.psi_node.ValkyrieForStatementNode
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinFor(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getOriginalElement(): ValkyrieForStatementNode {
        return this as ValkyrieForStatementNode
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, null, getIcon(0), null)
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val views: MutableList<ValkyrieViewElement> = mutableListOf()
        // originalElement.modifiers.addChildrenView(views)
        return views.toTypedArray()
    }
}

