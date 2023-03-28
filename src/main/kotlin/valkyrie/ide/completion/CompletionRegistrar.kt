package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.util.elementType
import com.intellij.psi.util.parents
import com.intellij.util.ProcessingContext
import valkyrie.language.file.YggdrasilFileNode
import valkyrie.psi.ParserExtension
import yggdrasil.psi.node.ValkyrieClassNode
import yggdrasil.psi.node.ValkyrieDefineUnion


class CompletionRegistrar : CompletionContributor() {
//    init {
//        extend(CompletionType.BASIC, CompletionInFileScope.Condition, CompletionInFileScope())
//        extend(CompletionType.BASIC, CompletionInClassScope.Condition, CompletionInClassScope())
//    }

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
//        super.fillCompletionVariants(parameters, result)
        myFill(parameters, result)
    }

    private fun myFill(parameters: CompletionParameters, result: CompletionResultSet) {
        ProgressManager.checkCanceled()
        val context = ProcessingContext()
        val element = parameters.originalPosition ?: return
        if (ParserExtension.CompletionWords.contains(element.elementType)) {
            for (node in element.parents(false)) {
                if (result.isStopped) {
                    return
                }
                when (node) {
                    is YggdrasilFileNode -> {
                        CompletionInFileScope().addCompletionVariants(parameters, context, result)
                        return
                    }

                    is ValkyrieClassNode -> {
                        CompletionInClassScope().addCompletionVariants(parameters, context, result)
                        return
                    }

                    is ValkyrieDefineUnion -> {
                        CompletionInClassScope().addCompletionVariants(parameters, context, result)
                        return
                    }
                }
            }
        } else {
            println("CompletionRegistrar: ${element.elementType}")
        }
    }
}
