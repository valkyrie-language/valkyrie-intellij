package valkyrie.ide.annotator

import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiElement
import com.intellij.psi.search.searches.DefinitionsScopedSearch.SearchParameters
import com.intellij.util.Processor
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieNamePathNode
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions

class SearchDefinitions : QueryExecutorBase<PsiElement, SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("SearchDefinitions : $queryParameters")
        queryParameters.element.accept(SearchDefinitionsVisitor(consumer))
    }
}


private class SearchDefinitionsVisitor : ValkyrieVisitor {
    private var consumer: Processor<in PsiElement>

    constructor(consumer: Processor<in PsiElement>) : super() {
        this.consumer = consumer
    }

    override fun visitNamePath(o: ValkyrieNamePathNode) {
        for (value in o.containingFile.definitions) {
            consumer.process(value)
        }
    }
}


class DirectClassInheritorsSearch : QueryExecutorBase<PsiElement, DirectClassInheritorsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("DirectClassInheritorsSearch : $queryParameters")
    }

    class SearchParameters
}

class OverridingMethodsSearch : QueryExecutorBase<PsiElement, OverridingMethodsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("overridingMethodsSearch : $queryParameters")
    }

    class SearchParameters
}


class ValkyrieAllOverridingMethodsSearch : QueryExecutorBase<PsiElement, ValkyrieAllOverridingMethodsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("ValkyrieAllOverridingMethodsSearch : $queryParameters")
    }

    class SearchParameters
}

class ValkyrieClassInheritorsSearch : QueryExecutorBase<ValkyrieClassNode, ValkyrieClassInheritorsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in ValkyrieClassNode>) {
        println("classInheritorsSearch : $queryParameters")
    }

    class SearchParameters
}
