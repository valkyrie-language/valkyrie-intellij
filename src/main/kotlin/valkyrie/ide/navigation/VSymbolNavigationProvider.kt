package valkyrie.ide.goto

import valkyrie.language.symbol.ValkyrieDeclaration
import com.intellij.model.Symbol
import com.intellij.navigation.NavigationTarget
import com.intellij.navigation.SymbolNavigationProvider
import com.intellij.openapi.project.Project

@Suppress("UnstableApiUsage")
class VSymbolNavigationProvider : SymbolNavigationProvider {
    override fun getNavigationTargets(project: Project, symbol: Symbol): MutableCollection<out NavigationTarget> {
        val sym = symbol as? ValkyrieDeclaration ?: return mutableSetOf()
        TODO("Not yet implemented $project, $sym")
    }
}

