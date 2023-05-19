package valkyrie.ide.lint

import com.intellij.util.indexing.DataIndexer

class ValkyrieTodoIndexer : DataIndexer<Any?, Any?, Any?> {
    override fun map(inputData: Any): MutableMap<Any?, Any?> {
        return mutableMapOf()
    }
}
