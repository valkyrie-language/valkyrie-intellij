package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import valkyrie.ide.templates.post_template.PostfixTemplateDotIf
import valkyrie.language.file.ValkyrieFileNode

class CompletionInFile : ValkyrieCompletionProvider {
    val node: ValkyrieFileNode

    constructor(node: ValkyrieFileNode, parameters: CompletionParameters, result: CompletionResultSet) : super(parameters, result) {
        this.node = node
    }

    fun complete() {
        addFunctions()

        result.addElement(
            ValkyriePostCompletionTemplate("", PostfixTemplateDotIf(), ".if", true)
        )

    }
}

