package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.file.ValkyrieIconProvider
import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.mixin.MixinNamepath
import com.github.valkyrie.language.psi.*
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class ASTMethods {
    companion object {
        @JvmStatic
        fun addChildrenView(node: ValkyrieModified?, list: MutableList<ValkyrieViewElement>) {
            if (node == null) return
            PsiTreeUtil
                .getChildrenOfTypeAsList(node, NavigatablePsiElement::class.java)
                .forEach {
                    list.add(ValkyrieViewElement(it, it.text, ValkyrieIconProvider.MODIFIER))
                }
        }

        @JvmStatic
        fun getIdentifier(node: ValkyrieTraitStatement): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTraitStatement): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieDefineStatement): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }
        @JvmStatic
        fun getNamepath(node: ValkyrieDefineStatement): MixinNamepath {
            return node.modified.lastChild as MixinNamepath
        }

        @JvmStatic
        fun getIdentifier(node: ValkyrieClassStatement): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieClassStatement): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }

        @JvmStatic
        fun getIdentifier(node: ValkyrieClassDefine): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieClassDefine): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }
    }
}

private fun ValkyrieModifiers?.getModifiers(): Array<ValkyrieIdentifierNode> {
    this ?: return arrayOf();
    return this.identifierList.map { it as ValkyrieIdentifierNode }.toTypedArray()
}
