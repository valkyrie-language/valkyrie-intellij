package valkyrie.ide.navigation

//import com.intellij.navigation.NavigationTarget
import com.intellij.model.Symbol
import com.intellij.navigation.SymbolNavigationProvider
import com.intellij.openapi.project.Project
import com.intellij.platform.backend.navigation.NavigationTarget
import valkyrie.language.symbol.ValkyrieSymbolTemplate

@Suppress("UnstableApiUsage")
class ValkyrieSymbolNavigationProvider : SymbolNavigationProvider {

    override fun getNavigationTargets(project: Project, symbol: Symbol): MutableCollection<out NavigationTarget> {
        val sym = symbol as? ValkyrieSymbolTemplate ?: return mutableSetOf()
        TODO("Not yet implemented $project, $sym")
    }
}

