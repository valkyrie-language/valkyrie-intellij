//package valkyrie.ide.goto_super
//
//import com.intellij.openapi.application.QueryExecutorBase
//import com.intellij.psi.PsiElement
//import com.intellij.psi.search.searches.SuperMethodsSearch.SearchParameters
//import com.intellij.util.Processor
//
//
//class SuperMethodsSearch : QueryExecutorBase<PsiElement, SearchParameters>(true) {
//    override fun processQuery(queryParameters: SearchParameters, consumer: Processor<in PsiElement>) {
//        println("superMethodsSearch : $queryParameters")
//    }
//}