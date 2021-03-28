package com.github.valkyrie.language.ast


import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.language.psi.ValkyrieTaggedStatement
import com.github.valkyrie.language.psi.ValkyrieTraitStatement

class ASTMethods {
    companion object {
        @JvmStatic
        fun getSymbol(node: ValkyrieTraitStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }
        @JvmStatic
        fun getSymbol(node: ValkyrieTaggedStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTraitStatement): Array<ValkyrieIdentifier> {
            val out = mutableListOf<ValkyrieIdentifier>()
            node.modifierSymbols.children.forEach {
                out.add(it as ValkyrieIdentifier)
            }
            out.removeLastOrNull();
            return out.toTypedArray()
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTaggedStatement): Array<ValkyrieIdentifier> {
            val out = mutableListOf<ValkyrieIdentifier>()
            node.modifierSymbols.children.forEach {
                out.add(it as ValkyrieIdentifier)
            }
            out.removeLastOrNull();
            return out.toTypedArray()
        }
    }
}

