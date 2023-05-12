package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import valkyrie.psi.node.ValkyrieClassBody
import valkyrie.psi.node.ValkyrieDeclareClassNode

class CompletionInClass : ValkyrieCompletionProvider {
    val node: ValkyrieDeclareClassNode

    constructor(node: ValkyrieDeclareClassNode, parameters: CompletionParameters, result: CompletionResultSet) : super(parameters, result) {
        this.node = node
    }

    fun complete(body: ValkyrieClassBody) {
        result.addElement(
            LookupElementBuilder.create("in class block")
                .withIcon(AllIcons.Nodes.MethodReference)
                .withTailText("withTailText")
                .withTypeText("withTypeText")
                .withPresentableText("withPresentableText")

        )

        result.addElement(LookupElementBuilder.create("constructor").withIcon(AllIcons.Nodes.MethodReference))

        addMethods()
    }
}

