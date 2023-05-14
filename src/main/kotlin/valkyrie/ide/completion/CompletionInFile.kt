package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import valkyrie.language.file.ValkyrieFileNode

class CompletionInFile : ValkyrieCompletionProvider {
    val node: ValkyrieFileNode

    constructor(node: ValkyrieFileNode, parameters: CompletionParameters, result: CompletionResultSet) : super(parameters, result) {
        this.node = node
    }

    fun complete() {
        addFunctions()
        addControls()
    }
}

