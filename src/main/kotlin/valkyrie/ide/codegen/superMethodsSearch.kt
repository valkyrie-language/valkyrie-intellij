package valkyrie.ide.codegen

import com.intellij.util.Processor
import com.intellij.util.QueryExecutor

class superMethodsSearch : QueryExecutor<Any?, Any?> {
    override fun execute(queryParameters: Any, consumer: Processor<in Any?>): Boolean {
        println("superMethodsSearch: $queryParameters")
        TODO("Not yet implemented")
    }
}
