package valkyrie.ide.goto_super

import com.intellij.openapi.application.QueryExecutorBase
import com.intellij.psi.PsiElement
import com.intellij.util.Processor


class SuperMethodsSearch : QueryExecutorBase<PsiElement, PsiElement>(true) {
    override fun processQuery(queryParameters: PsiElement, consumer: Processor<in PsiElement>) {
        println("superMethodsSearch : $queryParameters")
    }

}