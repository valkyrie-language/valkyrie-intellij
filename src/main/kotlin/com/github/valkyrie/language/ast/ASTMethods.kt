package com.github.valkyrie.language.ast


import com.github.valkyrie.language.psi.*
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode

class ASTMethods {
    companion object {
        @JvmStatic
        fun getKeyword(node: ValkyrieTraitStatement): ValkyrieIdentifierNode {
            return node.firstChild as ValkyrieIdentifierNode
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTraitStatement): Array<ValkyrieIdentifierNode> {
            val mods = node.maybeModifier ?: return arrayOf();
            return mods.identifierList.map { it as ValkyrieIdentifierNode }.toTypedArray()
        }
    }
}