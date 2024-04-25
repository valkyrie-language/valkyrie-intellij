package valkyrie.ide.codegen

import com.intellij.util.Processor
import com.intellij.util.QueryExecutor

class deepestSuperMethodsSearch : QueryExecutor<Any?, Any?> {
    override fun execute(queryParameters: Any, consumer: Processor<in Any?>): Boolean {
        println("deepestSuperMethodsSearch: $queryParameters")
        TODO("Not yet implemented")
    }
}
