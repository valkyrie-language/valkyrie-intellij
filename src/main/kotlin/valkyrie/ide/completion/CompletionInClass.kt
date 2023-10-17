package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import valkyrie.ast.node.ValkyrieClassDeclarationNode
import valkyrie.psi.node.ValkyrieClassBody

class CompletionInClass : ValkyrieCompletionProvider {
    val node: ValkyrieClassDeclarationNode

    constructor(node: ValkyrieClassDeclarationNode, parameters: CompletionParameters, result: CompletionResultSet) : super(parameters, result) {
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

        addConstructor()
        addMethods()
        addGetSet()
    }
}

