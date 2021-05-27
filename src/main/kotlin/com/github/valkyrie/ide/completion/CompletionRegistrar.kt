package com.github.valkyrie.ide.completion

import com.github.valkyrie.language.psi.ValkyrieTypes
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionInitializationContext
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.openapi.progress.ProgressManager
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext


class CompletionRegistrar : CompletionContributor() {
    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        ProgressManager.checkCanceled()
        val context = ProcessingContext()
        val element = parameters.originalPosition ?: return
        when (element.elementType) {
            ValkyrieTypes.SYMBOL_XID, ValkyrieTypes.SYMBOL_RAW -> {
                CompleteSymbol(element).addCompletionVariants(parameters, context, result)
            }

            ValkyrieTypes.KW_ESCAPING, ValkyrieTypes.AT -> {
                CompleteOperator(element).addCompletionVariants(parameters, context, result)
            }
        }
        print(result)
    }

//    override fun beforeCompletion(context: CompletionInitializationContext) {
//        ActionManager.getInstance().getAction(IdeActions.ACTION_CODE_COMPLETION).actionPerformed()
//        when (context.file.findElementAt(context.startOffset)) {
//            ValkyrieTypes.KW_ESCAPING -> {
//                context.dummyIdentifier = "\\"
//                context.replacementOffset = context.startOffset
//            }
//
//            ValkyrieTypes.AT -> {
//                context.dummyIdentifier = "@"
//                context.replacementOffset = context.startOffset
//            }
//        }
//    }

    override fun duringCompletion(context: CompletionInitializationContext) {
        super.duringCompletion(context)
    }


    companion object {
        val Escaping = PlatformPatterns.psiElement(ValkyrieTypes.KW_ESCAPING)!!

        // PlatformPatterns.psiElement(ValkyrieIdentifierNode::class.java)
        val Identifier = PlatformPatterns.psiElement(ValkyrieTypes.SYMBOL_XID)!!
//            .andOr(PlatformPatterns.psiElement(ValkyrieTypes.SYMBOL_XID))
//            .andOr(PlatformPatterns.psiElement(ValkyrieTypes.SYMBOL_RAW))
    }
}

