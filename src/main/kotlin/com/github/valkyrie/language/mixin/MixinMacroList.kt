package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.reference.ValkyrieReference
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.github.valkyrie.language.ast.ViewableNode
import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.language.psi_node.ValkyrieMacroListNode
import com.github.valkyrie.language.psi_node.ValkyrieTermNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinMacroList(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieMacroListNode {
        return this as ValkyrieMacroListNode
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun addAnnotationView(list: MutableList<ValkyrieViewElement>) {

    }
}



