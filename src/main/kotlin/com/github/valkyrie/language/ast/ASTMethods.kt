package com.github.valkyrie.language.ast


import com.github.valkyrie.language.psi.*
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.psi.PsiElement

class ASTMethods {
    companion object {
        @JvmStatic
        fun getKeyword(node: ValkyrieTraitStatement): PsiElement {
            return node.firstChild
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
        fun getIdentifier(node: ValkyrieClassStatement): ValkyrieIdentifierNode {
            return node.modified.lastChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieClassStatement): Array<ValkyrieIdentifierNode> {
            return node.modified.modifiers.getModifiers()
        }
    }
}

private fun ValkyrieModifiers?.getModifiers(): Array<ValkyrieIdentifierNode> {
    this ?: return arrayOf();
    return this.identifierList.map { it as ValkyrieIdentifierNode }.toTypedArray()
}
