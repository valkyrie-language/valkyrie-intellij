package com.github.valkyrie.language.symbol

interface ContextProvider {
    fun resolveSymbols(symbols: List<ValkyrieSymbol>): List<ValkyrieSymbol>
}