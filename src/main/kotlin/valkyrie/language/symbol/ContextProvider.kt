package valkyrie.language.symbol


interface ContextProvider {
    fun resolveSymbols(symbols: List<ValkyrieDeclaration>): List<ValkyrieDeclaration>
}