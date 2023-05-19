package valkyrie.ide.annotator

import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiElement
import com.intellij.psi.search.searches.DefinitionsScopedSearch.SearchParameters
import com.intellij.util.Processor
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieNamepath
import valkyrie.psi.node.ValkyrieNamepathNode
import valkyrie.psi.node.ValkyrieVisitor

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

    override fun visitNamepath(o: ValkyrieNamepath) {
        o as ValkyrieNamepathNode
        for (value in o.containingFile.definitions.getCache().values) {
            consumer.process(value)
        }
    }
}


class DirectClassInheritorsSearch : QueryExecutorBase<PsiElement, DirectClassInheritorsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("DirectClassInheritorsSearch : $queryParameters")
    }

    class SearchParameters {

    }
}

class OverridingMethodsSearch : QueryExecutorBase<PsiElement, OverridingMethodsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("overridingMethodsSearch : $queryParameters")
    }

    class SearchParameters {

    }
}


class ValkyrieAllOverridingMethodsSearch : QueryExecutorBase<PsiElement, ValkyrieAllOverridingMethodsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
        println("ValkyrieAllOverridingMethodsSearch : $queryParameters")
    }

    class SearchParameters {

    }
}

class ValkyrieClassInheritorsSearch : QueryExecutorBase<ValkyrieDeclareClassNode, ValkyrieClassInheritorsSearch.SearchParameters>(true) {
    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in ValkyrieDeclareClassNode>) {
        println("classInheritorsSearch : $queryParameters")
    }

    class SearchParameters {

    }
}
