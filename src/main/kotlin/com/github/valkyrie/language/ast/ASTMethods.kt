package com.github.valkyrie.language.ast


import com.github.valkyrie.language.psi.*

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
        fun getSymbol(node: ValkyrieBitflagStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTraitStatement): Array<ValkyrieIdentifier> {
            return extraModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieTaggedStatement): Array<ValkyrieIdentifier> {
            return extraModifiers(node.modifierSymbols)
        }

        @JvmStatic
        fun getModifiers(node: ValkyrieBitflagStatement): Array<ValkyrieIdentifier> {
            return extraModifiers(node.modifierSymbols)
        }
    }
}

private fun extraModifiers(node: ValkyrieModifierSymbols): Array<ValkyrieIdentifier> {
    val out = mutableListOf<ValkyrieIdentifier>()
    node.children.forEach {
        out.add(it as ValkyrieIdentifier)
    }
    out.removeLastOrNull();
    return out.toTypedArray()
}