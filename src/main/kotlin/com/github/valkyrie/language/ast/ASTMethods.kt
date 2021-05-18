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
            val mods = node.maybeModifier ?: return arrayOf();
            return mods.identifierList.map { it as ValkyrieIdentifierNode }.toTypedArray()
        }
    }
}