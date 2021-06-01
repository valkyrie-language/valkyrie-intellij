package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.ast.DeclareNode
import com.github.valkyrie.language.ast.addChildrenView
import com.github.valkyrie.language.psi_node.ValkyrieClassDefineNode
import com.github.valkyrie.language.psi_node.ValkyrieClassItemNode
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.github.valkyrie.language.psi_node.ValkyrieObjectKeyNode

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinClassField(node: ASTNode) : DeclareNode(node) {
    override fun getOriginalElement(): ValkyrieClassItemNode {
        return this as ValkyrieClassItemNode
    }

    override fun getNameIdentifier(): ValkyrieObjectKeyNode {
        return originalElement.objectKey as ValkyrieObjectKeyNode
    }

    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.FIELD

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}

