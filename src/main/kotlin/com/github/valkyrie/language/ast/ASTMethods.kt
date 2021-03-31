package com.github.valkyrie.language.ast


import com.github.valkyrie.language.psi.*

class ASTMethods {
    companion object {

        @JvmStatic
        fun getSymbol(node: ValkyrieClassStatement): ValkyrieIdentifier {
            return node.modifierSymbols.lastChild as ValkyrieIdentifier
        }

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

        /// ----------------------------------------------------------------------------
        @JvmStatic
        fun getModifiers(node: ValkyrieClassStatement): Array<ValkyrieIdentifier> {
            return extraModifiers(node.modifierSymbols)
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

        /// ----------------------------------------------------------------------------
        @JvmStatic
        fun getBraceItemList(node: ValkyrieClassStatement): Array<ValkyrieClassBraceItem> {
            return when (val brace = node.classBrace) {
                null -> arrayOf()
                else -> brace.classBraceItemList.toTypedArray()
            }
        }

        @JvmStatic
        fun getTupleItemList(node: ValkyrieClassStatement): Array<ValkyrieClassTupleItem> {
            return when (val brace = node.classTuple) {
                null -> arrayOf()
                else -> brace.classTupleItemList.toTypedArray()
            }
        }

        @JvmStatic
        fun isEmpty(node: ValkyrieClassStatement): Boolean {
            return getBraceItemList(node).isEmpty() || getTupleItemList(node).isEmpty()
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