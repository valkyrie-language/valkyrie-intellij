package valkyrie.ide.annotator

import com.intellij.model.search.SearchParameters
import com.intellij.openapi.application.DumbAwareSearchParameters
import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.*
import com.intellij.psi.util.PsiUtilCore
import com.intellij.util.Processor
import com.intellij.util.QueryParameters
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.ValkyrieDeclareClassNode
import kotlin.concurrent.Volatile

class SearchDefinitions : QueryExecutorBase<PsiElement, SearchDefinitionsParameter>(true) {
    override fun processQuery(queryParameters: SearchDefinitionsParameter, consumer: Processor<in PsiElement>) {
        val file = queryParameters.getContainingFile()


        println("SearchDefinitions: $queryParameters")
    }
}

interface SearchDefinitionsParameter : QueryParameters {
    override fun getProject(): Project;
    fun getContainingFile(): ValkyrieFileNode
}

class ASearchParameters :
    DumbAwareSearchParameters, SearchParameters<PsiReference?> {
    /**
     * @return the user-visible search scope, most often "Project Files" or "Project and Libraries".
     * Searchers most likely need to use [.getEffectiveSearchScope].
     */
    val elementToSearch: PsiElement
    val scopeDeterminedByUser: SearchScope
    val isIgnoreAccessScope: Boolean

    constructor(
        elementToSearch: PsiElement,
        scopeDeterminedByUser: SearchScope,
        isIgnoreAccessScope: Boolean,
        optimizer: SearchRequestCollector? = null,
    ) {
        this.elementToSearch = elementToSearch
        this.scopeDeterminedByUser = scopeDeterminedByUser
        this.isIgnoreAccessScope = isIgnoreAccessScope
        this.optimizer = optimizer ?: SearchRequestCollector(SearchSession(elementToSearch))
        this.myProject = PsiUtilCore.getProjectInReadAction(elementToSearch)
        this.isSharedOptimizer = optimizer != null
    }

    @Volatile
    private var myEffectiveScope: SearchScope? = null
    val optimizer: SearchRequestCollector
    private val myProject: Project
    private val isSharedOptimizer: Boolean

    override fun areValid(): Boolean {
        return isQueryValid
    }

    override fun isQueryValid(): Boolean {
        return elementToSearch.isValid
    }

    override fun getProject(): Project {
        return myProject
    }


    val effectiveSearchScope: SearchScope
        get() {
            if (isIgnoreAccessScope) {
                return scopeDeterminedByUser
            }

            var scope = myEffectiveScope
            if (scope == null) {
                if (!elementToSearch.isValid) return LocalSearchScope.EMPTY

                val useScope = PsiSearchHelper.getInstance(elementToSearch.project).getUseScope(elementToSearch)
                scope = scopeDeterminedByUser.intersectWith(useScope)
                myEffectiveScope = scope
            }
            return scope
        }
}

class ValkyrieAllOverridingMethodsSearch : QueryExecutorBase<PsiElement, ValkyrieAllOverridingMethodsSearch.SearchParameters>() {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("ValkyrieAllOverridingMethodsSearch : $queryParameters")
    }

    class SearchParameters {

    }
}

class ValkyrieClassInheritorsSearch : QueryExecutorBase<ValkyrieDeclareClassNode, ValkyrieClassInheritorsSearch.SearchParameters>() {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in ValkyrieDeclareClassNode>) {
        println("classInheritorsSearch : $queryParameters")
    }

    class SearchParameters {

    }
}
