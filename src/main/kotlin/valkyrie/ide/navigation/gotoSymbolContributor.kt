package valkyrie.ide.navigation

import com.intellij.navigation.ChooseByNameContributorEx2
import com.intellij.navigation.NavigationItem
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.Processor
import com.intellij.util.indexing.FindSymbolParameters
import com.intellij.util.indexing.IdFilter

class gotoSymbolContributor : ChooseByNameContributorEx2 {
    override fun processNames(processor: Processor<in String>, parameters: FindSymbolParameters) {
        TODO("Not yet implemented")
    }

    override fun processNames(processor: Processor<in String>, scope: GlobalSearchScope, filter: IdFilter?) {
        TODO("Not yet implemented")
    }

    override fun processElementsWithName(name: String, processor: Processor<in NavigationItem>, parameters: FindSymbolParameters) {
        TODO("Not yet implemented")
    }

}
