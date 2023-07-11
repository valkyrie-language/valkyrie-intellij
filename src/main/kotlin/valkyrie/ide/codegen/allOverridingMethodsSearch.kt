package valkyrie.ide.codegen

import com.intellij.util.Processor
import com.intellij.util.QueryExecutor

class allOverridingMethodsSearch : QueryExecutor<Any?, Any?> {
    override fun execute(queryParameters: Any, consumer: Processor<in Any?>): Boolean {
        println("allOverridingMethodsSearch: $queryParameters")
        TODO("Not yet implemented")
    }
}
