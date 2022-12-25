package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.util.elementType
import com.intellij.psi.util.parents
import com.intellij.util.ProcessingContext
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.antlr.ValkyrieLexer


class CompletionRegistrar : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, CompletionInFileScope.Condition, CompletionInFileScope())
        extend(CompletionType.BASIC, CompletionInClassScope.Condition, CompletionInClassScope())
        extend(CompletionType.BASIC, CompletionInOperators.Condition, CompletionInClassScope())
    }

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        super.fillCompletionVariants(parameters, result)
//        myFill(parameters, result)
    }

    private fun myFill(parameters: CompletionParameters, result: CompletionResultSet) {
        ProgressManager.checkCanceled()
        val context = ProcessingContext()
        val element = parameters.originalPosition ?: return
        println("CompletionRegistrar: ${element.elementType}")
        if (ValkyrieLexer.CompletionWords.contains(element.elementType)) {
            for (node in element.parents(false)) {
                if (result.isStopped) {
                    return
                }
                when (node) {
                    is ValkyrieFileNode -> {
                        println("ValkyrieFileNode: ${result.hashCode()}")
                        CompletionInFileScope().addCompletionVariants(parameters, context, result)
                        return
                    }

                    is ValkyrieClassStatement -> {
                        println("ValkyrieClassStatement: ${result.hashCode()}")
                        CompletionInClassScope().addCompletionVariants(parameters, context, result)
                        return
                    }
                }
            }
        } else if (ValkyrieLexer.Operators.contains(element.elementType)) {
            println("Operators: ${result.hashCode()}")
            CompletionInOperators().addCompletionVariants(parameters, context, result)
        }
    }


//    override fun beforeCompletion(context: CompletionInitializationContext) {
////        ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION).actionPerformed()
//        when (context.file.findElementAt(context.startOffset)) {
////            ValkyrieTypes.KW_ESCAPING -> {
////                context.dummyIdentifier = "\\"
////                context.replacementOffset = context.startOffset
////            }
//
////            ValkyrieTypes.AT -> {
////                context.dummyIdentifier = "@"
////                context.replacementOffset = context.startOffset
////            }
//        }
//    }

}
