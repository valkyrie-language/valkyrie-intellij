package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import valkyrie.psi.node.ValkyrieDeclareTraitNode

class CompletionInTrait : ValkyrieCompletionProvider {
    val node: ValkyrieDeclareTraitNode

    constructor(node: ValkyrieDeclareTraitNode, parameters: CompletionParameters, result: CompletionResultSet) : super(parameters, result) {
        this.node = node
    }

}